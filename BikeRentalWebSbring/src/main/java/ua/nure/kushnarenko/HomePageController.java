package ua.nure.kushnarenko;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.kushnarenko.rest.myapi.constant.PathConstant;
import ua.nure.kushnarenko.rest.myapi.entity.Agreement;
import ua.nure.kushnarenko.rest.myapi.entity.User;
import ua.nure.kushnarenko.rest.myapi.query.JsonQuery;
import ua.nure.kushnarenko.rest.myapi.query.ServerQuery;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/")
public class HomePageController {

    @RequestMapping(method = RequestMethod.GET)
    public String goMain(ModelMap model) {
        model.addAttribute("user", new User());
        return "main";
    }

    @RequestMapping("/login")
    public String goLogin(HttpSession session, ModelMap model) {
        session.setAttribute("loginError", false);
        return "log_in";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView doLogin(@RequestParam(value = "email") String email,
                                @RequestParam(value = "password") String password,
                                HttpSession session,
                                ModelMap model) {
        ServerQuery query = new JsonQuery();
        String res = query.sendGetQuery(String.format(PathConstant.GETUSER, email));
        User u = User.fromJson(res);
        System.out.println(res);
        System.out.println(u);
        String page = "log_in";
        if (u != null && password.equals(u.getPassword())) {
            page = "myPage";
            session.setAttribute("currentUser", u);
            session.setAttribute("loginError", false);
        } else {
            session.setAttribute("loginError", true);
        }
        return new ModelAndView(page);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ModelAndView doLogout(HttpSession session) {
        session.setAttribute("currentUser", null);
        return new ModelAndView("log_in");
    }

    @RequestMapping("/signUp")
    public String goSignUp(ModelMap model) {
        return "sign_up";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ModelAndView doSignUp(@RequestParam(value = "nameReg") String name,
                                 @RequestParam(value = "emailReg") String email,
                                 @RequestParam(value = "passwordReg") String password,
                                 @RequestParam(value = "password2") String password2,
                                 ModelMap model) {
        String path = "log_in";
        if (!password.equals(password2)) {
            path = "sign_up";
            model.put("pass", true);
        } else {
            ServerQuery query = new JsonQuery();
            String res = query.sendGetQuery(String.format(PathConstant.GETUSER, email));
            User u = User.fromJson(res);
            if (u != null) {
                path = "sign_up";
                model.put("exist", true);
            } else {
                query.sendGetQuery(String.format(PathConstant.ADD_USER, name, email, password));
            }
        }
        if (path.equals("sign_up")) {
            model.put("nameVal", name);
            model.put("emailVal", email);
        } else {
            model.put("nameVal", "");
            model.put("emailVal", "");
        }
        return new ModelAndView(path);
    }

    @RequestMapping("/bikeList")
    public String goBikeList(ModelMap model) {
        return "bikeList";
    }

    @RequestMapping("/myPage")
    public String goMyPage(ModelMap model, HttpSession session) {

        Agreement curAgreement = (Agreement) session.getAttribute("curAgreement");
        if (curAgreement != null) {
            Date d = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(d);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(curAgreement.getFromDate());
            Integer hours = calendar.get(Calendar.HOUR_OF_DAY) - calendar2.get(Calendar.HOUR_OF_DAY);
            hours = (hours.equals(0)) ? 1 : hours;
            session.setAttribute("price", hours * curAgreement.getBicycle().getPrice());
        }
        return "myPage";
    }

}