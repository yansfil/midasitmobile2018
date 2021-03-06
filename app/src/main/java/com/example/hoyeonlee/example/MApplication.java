package com.example.hoyeonlee.example;

import android.app.Application;
import android.provider.Settings;


import com.example.hoyeonlee.example.DataSchema.OrderList;
import com.example.hoyeonlee.example.DataSchema.ReservedItem;
import com.example.hoyeonlee.example.Firebase.MyFirebaseInstanceIDService;
import com.example.hoyeonlee.example.Network.AddCookiesInterceptor;
import com.example.hoyeonlee.example.Network.ApiService;
import com.example.hoyeonlee.example.Network.ReceivedCookiesInterceptor;
import com.google.firebase.FirebaseApp;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hoyeonlee on 2018. 2. 23..
 */

public class MApplication extends Application{
    private static MApplication appInstance;

    private static OrderList orderList;
    private static ArrayList<ReservedItem> reservedItems;

    Retrofit retrofit;
    ApiService apiService = null;

    //싱글턴 Application & APiService 객체


    public static ArrayList<ReservedItem> getReservedItems() {
        return reservedItems;
    }

    public static void setReservedItems(ArrayList<ReservedItem> reservedItems) {
        MApplication.reservedItems = reservedItems;
    }

    public static OrderList getOrderList(){
        return orderList;
    }


    public static MApplication getInstance(){
        if(appInstance == null){
            appInstance = new MApplication();
        }
        return appInstance;
    }
    public ApiService getApiService(){
        if(apiService == null){
            OkHttpClient.Builder oktHttpClient = new OkHttpClient.Builder();
            oktHttpClient.interceptors().add(new AddCookiesInterceptor());

            //Body에 Cookie를 직접 넣어주므로 생략
//            oktHttpClient.interceptors().add(new ReceivedCookiesInterceptor());
            retrofit = new Retrofit.Builder().
                    baseUrl(ApiService.URL).
                    client(oktHttpClient.build()).
                    addConverterFactory(GsonConverterFactory.create()).
                    build();
            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        orderList=new OrderList();
        appInstance = this;
        OkHttpClient.Builder oktHttpClient = new OkHttpClient.Builder();
        oktHttpClient.interceptors().add(new AddCookiesInterceptor());
//        oktHttpClient.interceptors().add(new ReceivedCookiesInterceptor());
        retrofit = new Retrofit.Builder().
                baseUrl(ApiService.URL).
                client(oktHttpClient.build()).
                addConverterFactory(GsonConverterFactory.create()).
                build();
        apiService = retrofit.create(ApiService.class);
        FirebaseApp.initializeApp(this);
    }



}
