package ua.nure.kushnarenko.rest.myapi.constant;

public class PathConstant {

    private static final String LH = "http://localhost";

    private static final String SERVER_HOST = LH;
    private static final String SERVER_PORT = ":8080";
    private static final String SERVER = SERVER_HOST + SERVER_PORT;

    private static final String USER = SERVER + "/user/";
    private static final String BICYCLE = SERVER + "/bicycle/";

    public static final String BICYCLE_GETALL = BICYCLE + "getAll";
    public static final String BICYCLE_GET = BICYCLE + "get?id=%s";

    public static final String AMP = "&";

    public static final String USER_EMAIL = "email=%s";
    public static final String USER_NAME = "name=%s";
    public static final String USER_PASSWORD = "password=%s";


    public static final String BICYCLE_TYPE = "type=%s";
    public static final String BICYCLE_NAME = "name=%s";
    public static final String BICYCLE_PRICE = "price=%s";
    public static final String USER_ID = "user_id=%s";

    public static final String GETUSER = USER + "get?" + USER_EMAIL;

    public static final String ADD_USER = USER + "add?" + USER_NAME + AMP + USER_EMAIL + AMP + USER_PASSWORD;
    public static final String ADD_BICYCLE = BICYCLE + "add";//?" + BICYCLE_TYPE + AMP + BICYCLE_NAME + AMP + BICYCLE_PRICE + AMP + USER_ID;
    public static final String ADD_AGREEMENT = SERVER + "/agreement/add";
}
