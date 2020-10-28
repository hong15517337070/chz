package com.example.nihao.model;

import com.example.nihao.api.ApiService;
import com.example.nihao.back.TabbBack;
import com.example.nihao.base.BaseModel;
import com.example.nihao.bean.TabbBean;
import com.example.nihao.net.BaseObserver;
import com.example.nihao.net.HttpManager;
import com.example.nihao.net.RxUtil;
import com.example.nihao.zawu.ShA1;

import java.util.HashMap;
import java.util.Map;

public class TabbModel extends BaseModel {
    public void call(TabbBack tabbBack){
        HashMap<String, String> map = ShA1.sha1();

        HttpManager.getHttpManager().getApiService(ApiService.baseTabb, ApiService.class)
                .getdataa(map,"id")
                .compose(RxUtil.rxFlowableTransformer())
                .subscribe(new BaseObserver<TabbBean>() {
                    @Override
                    public void onSuccess(TabbBean tabbBean) {
                        tabbBack.onSuccess(tabbBean);
                    }
                });
    }
}
