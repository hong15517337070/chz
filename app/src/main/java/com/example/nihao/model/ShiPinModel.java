package com.example.nihao.model;

import com.example.nihao.api.ApiService;
import com.example.nihao.back.ShiPinBack;
import com.example.nihao.base.BaseModel;
import com.example.nihao.bean.ShiPinBean;
import com.example.nihao.net.BaseObserver;
import com.example.nihao.net.HttpManager;
import com.example.nihao.net.RxUtil;
import com.example.nihao.zawu.ShA1;

import java.io.IOException;
import java.util.HashMap;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShiPinModel extends BaseModel {
    public void call(ShiPinBack shiPinBack){
//        /start 是 ⽂章开始位置，默认传0，下次请求时，⽤本接⼝返回值
//number 是 ⽂章开始次数，默认传0，下次请求时，⽤本接⼝返回值
//point_time 是 节点时间，默认传0，下次请求时，⽤本接⼝返回值
//token 否 ⽤户身份标识
        HashMap<String, String> map = ShA1.sha1();
        map.put("start", "0");
        map.put("number", "0");
        map.put("point_time", "0");
//        Retrofit retrofit = new Retrofit.Builder()
////                .baseUrl(ApiService.baseShiPin)
////                .addConverterFactory(GsonConverterFactory.create())
////                .build();
////        ApiService apiService = retrofit.create(ApiService.class);
////        Flowable<ShiPinBean> getdataaa = apiService.getdataaa(map);
////        getdataaa.compose(RxUtil.rxFlowableTransformer())
////                .subscribe(new BaseObserver<ShiPinBean>() {
////                    @Override
////                    public void onSuccess(ShiPinBean shiPinBean) {
////                        shiPinBack.onSuccess(shiPinBean);
////                    }
////                });
        HttpManager.getHttpManager().getApiService(ApiService.baseShiPin, ApiService.class)
                .getdataaa(map)
                .compose(RxUtil.rxFlowableTransformer())
                .subscribe(new BaseObserver<ShiPinBean>() {
                    @Override
                    public void onSuccess(ShiPinBean shiPinBean) {
                        shiPinBack.onSuccess(shiPinBean);
                    }
                });
   }
}
