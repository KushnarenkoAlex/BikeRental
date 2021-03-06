package ua.nure.kushnarenko;

import javafx.application.Application;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.kushnarenko.rest.myapi.constant.PathConstant;
import ua.nure.kushnarenko.rest.myapi.entity.Agreement;
import ua.nure.kushnarenko.rest.myapi.entity.Bicycle;
import ua.nure.kushnarenko.rest.myapi.entity.User;
import ua.nure.kushnarenko.rest.myapi.query.JsonQuery;
import ua.nure.kushnarenko.rest.myapi.query.ServerQuery;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/bicycle")
public class BikeController {

    @RequestMapping("/list")
    public ModelAndView goBikeList(HttpSession session, ModelMap model) {
        ServerQuery query = new JsonQuery();
        String res = query.sendGetQuery(PathConstant.BICYCLE_GETALL);
        List<Bicycle> bicycles = Bicycle.fromJsonList(res);
        model.put("bikes", bicycles);
        return new ModelAndView("bicycles");
    }

    @RequestMapping("/rent")
    public ModelAndView goBikeRent(@RequestParam(value = "id") Long id, HttpSession session, ModelMap model) {
        ServerQuery query = new JsonQuery();
        String res = query.sendGetQuery(String.format(PathConstant.BICYCLE_GET, id));
        model.put("bike", Bicycle.fromJson(res));
        return new ModelAndView("bikeRent");
    }

    @RequestMapping(value = "/rend")
    public ModelAndView doBikeRent(@RequestParam(value = "id") Long id, HttpSession session, ModelMap model) {
        Agreement curAgreement = new Agreement();
        curAgreement.setBicycle(Bicycle.fromJson(new JsonQuery().sendGetQuery(String.format(PathConstant.BICYCLE_GET, id))));
        curAgreement.setFromDate(new Date(new java.util.Date().getTime()));
        session.setAttribute("curAgreement", curAgreement);
        return new ModelAndView("myPage");
    }

    @RequestMapping(value = "/rend", method = RequestMethod.POST)
    public ModelAndView doAgreement(HttpSession session, ModelMap model) {
        Agreement curAgreement = (Agreement) session.getAttribute("curAgreement");
        System.out.println(curAgreement);
        ServerQuery query = new JsonQuery();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("bikeId", curAgreement.getBicycle().getId());
        map.put("fromDate", curAgreement.getFromDate());
        map.put("toDate", new java.util.Date());
        User u = (User) session.getAttribute("currentUser");
        map.put("userId", u.getId());
        String res = query.sendPostQuery(PathConstant.ADD_AGREEMENT, map);
        session.setAttribute("curAgreement", null);
        return goBikeList(session, model);
    }

    @RequestMapping("/add")
    public ModelAndView goAddBike(HttpSession session, ModelMap model) {
        return new ModelAndView("addBike");
    }

    @RequestMapping(value = "/add", headers = "content-type=multipart/*", method = RequestMethod.POST)
    public ModelAndView doAddBike(@RequestParam(value = "name") String name,
                                  @RequestParam(value = "type") String type,
                                  @RequestParam(value = "price") String price,
                                  @RequestParam(value = "x") Float x,
                                  @RequestParam(value = "y") Float y,
                                  @RequestParam("image") MultipartFile image,
                                  HttpSession session,
                                  ModelMap model) {
        ServerQuery query = new JsonQuery();
        HashMap<String, Object> map = new HashMap<String, Object>();
        User u = (User) session.getAttribute("currentUser");
        map.put("name", name);
        map.put("type", type);
        map.put("price", price);
        map.put("user_id", u.getId());
        map.put("x", x);
        map.put("y", y);
        String imageName = u.getId().toString() + name + ".jpg";
        map.put("image", imageName);
        if (!image.isEmpty()) {
            try {
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File("D:\\Uni\\ATPPZ\\BikeRentalWebSbring\\src\\main\\webapp\\resources\\images\\bikeimg\\" +imageName)));
                FileCopyUtils.copy(image.getInputStream(), stream);
                stream.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
        String res = query.sendPostQuery(PathConstant.ADD_BICYCLE, map);
        return goBikeList(session, model);
    }

}