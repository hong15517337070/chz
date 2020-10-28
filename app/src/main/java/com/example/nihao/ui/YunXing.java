package com.example.nihao.ui;

import android.util.Log;

import com.example.nihao.api.ApiService;
import com.example.nihao.zawu.ShA1;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YunXing {
    public static void main(String[] args){
//        HashMap<String, String> map = ShA1.sha1();
//        map.put("start", "0");
//        map.put("number", "0");
//        map.put("point_time", "0");
//        start 是 ⽂章开始位置，默认传0，下次请求时，⽤本接⼝返回值
//        number 是 ⽂章开始次数，默认传0，下次请求时，⽤本接⼝返回值
//        point_time 是 节点时间，默认传0，下次请求时，⽤本接⼝返回值
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(ApiService.basezhuanti)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        ApiService apiService = retrofit.create(ApiService.class);
//        Call<ResponseBody> getdataaaa = apiService.getdataaaa(map);
//        getdataaaa.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    String string = response.body().string();
//                    System.out.println(string);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });
//        for (int i = 0; i < 100; i+=2) {
//            System.out.println(i);
//        }
  }
}
