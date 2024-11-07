package com.example.user.photoapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class AppUtils {
    public static String getEndUrl(String word){
        return "api/?key=10109852-f12434a85e5f8601c1214df2d&q="+word+"&image_type=photo&pretty=true";
    }

    public static boolean isInternet(Context ctxt)
    {
        ConnectivityManager cm=(ConnectivityManager)ctxt.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni=cm.getActiveNetworkInfo();
        if(ni!=null&&ni.isConnectedOrConnecting()){
            return true;
        }else {
            return false;
        }
    }
}
