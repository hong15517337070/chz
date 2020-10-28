package com.example.nihao.model;

import android.util.Log;

import com.example.nihao.api.ApiService;
import com.example.nihao.back.HomeBack;
import com.example.nihao.base.BaseModel;
import com.example.nihao.bean.YouYeBean;
import com.example.nihao.net.BaseObserver;
import com.example.nihao.net.HttpManager;
import com.example.nihao.net.RxUtil;
import com.example.nihao.zawu.ShA1;

import java.io.IOException;
import java.util.HashMap;


public class HomeModel extends BaseModel {
    public void call(HomeBack homeBack, String id) {
        //id 是 栏⽬id
        //start 是 ⽂章开始位置，默认传0，下次请求时，⽤本接⼝返回值
        //number 是 ⽂章开始次数，默认传0，下次请求时，⽤本接⼝返回值
        //point_time 是 节点时间，默认传0，下次请求时，⽤本接⼝返回值
        //token 否 ⽤户身份标识
        HashMap<String, String> map = ShA1.sha1();
        map.put("id", id);
        map.put("start", "0");
        map.put("number", "0");
        map.put("point_time", "0");

        HttpManager.getHttpManager().getApiService(ApiService.baseUrl, ApiService.class)
                .getData(map)
                .compose(RxUtil.rxFlowableTransformer())
                .subscribe(new BaseObserver<YouYeBean>() {
                    @Override
                    public void onSuccess(YouYeBean youYeBean) {
                        homeBack.onSuccess(youYeBean);
                    }
                });


    }
}
