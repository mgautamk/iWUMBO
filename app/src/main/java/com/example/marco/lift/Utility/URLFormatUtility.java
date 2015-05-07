package com.example.marco.lift.Utility;

/**
 * Created by kting_000 on 3/26/2015.
 */
public class URLFormatUtility {
    //EDIT URL FOR THE HTTP CALLS
    final static private String BASE_URL = "http://www.cs.sonoma.edu:8025/";

    static public String formatApiUrl(String param){
        String urlString = String.format(BASE_URL, param);
        return urlString;
    }
    static public final String submitAccount(){
        return BASE_URL + "user/create";
    }

    static public final String loginAccount(String Username){
        return BASE_URL + "user/login?Username=" + Username;
    }

    static public final String submitEvent() {
        return BASE_URL + "/event/create";
    }
}