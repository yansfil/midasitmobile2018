package com.example.hoyeonlee.example.Network;

import com.example.hoyeonlee.example.Utils.Preferences;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class AddCookiesInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

        // Preference에서 cookies를 가져오는 작업을 수행
        String key =  SharedPreferenceBase.getSharedPreference(Preferences.SHARED_PREFERENCE_NAME_COOKIE, "");
        if(!key.equals("")) {
            builder.addHeader("Authorization", "token " + key);
        }
        // Web,Android,iOS 구분을 위해 User-Agent세팅
        builder.removeHeader("User-Agent").addHeader("User-Agent", "Android");


        return chain.proceed(builder.build());
    }
}