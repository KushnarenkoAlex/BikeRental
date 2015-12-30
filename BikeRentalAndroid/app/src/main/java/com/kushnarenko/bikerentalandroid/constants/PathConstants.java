package com.kushnarenko.bikerentalandroid.constants;

public class PathConstants {
    private PathConstants() {
    }

    private static final String SERVER_HOST = "http://192.168.13.132";
    private static final String SERVER_PORT = ":8080";
    private static final String SERVER = SERVER_HOST + SERVER_PORT;

    private static final String USER = SERVER + "/user/";

    public static final String AUTH = USER + "auth";
    public static final String GETUSER = USER + "get?email=kushnarenko.alex@gmail.com";

}
