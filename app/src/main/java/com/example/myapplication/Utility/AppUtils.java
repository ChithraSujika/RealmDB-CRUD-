package com.example.myapplication.Utility;

import android.util.Log;

import retrofit2.Response;

public class AppUtils {
    public static String TAG = AppUtils.class.getSimpleName();
    public static final String BASE_URL = "https://kiakaha.in/alcoatsapi/";

    public static boolean analyseResponse(Response<?> response) {
        if (response == null) {
            Log.d(TAG,"Response is null");
            return false;
        }

        if (response.body() == null) {
            //Toast.makeText(MainApplication.getContext(), response.message(), Toast.LENGTH_SHORT).show();
            Log.d(TAG,"Response Body null");
            return false;
        }

        return true;
    }
}
