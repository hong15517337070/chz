package com.example.nihao.model;

import com.example.nihao.api.ApiService;
import com.example.nihao.back.ZhuanTiBack;
import com.example.nihao.base.BaseModel;
import com.example.nihao.bean.ZhuanTiBean;
import com.example.nihao.net.BaseObserver;
import com.example.nihao.net.HttpManager;
import com.example.nihao.net.RxUtil;
import com.example.nihao.zawu.ShA1;

import java.util.HashMap;

public class ZhuanTiModel extends BaseModel {
        public void call(ZhuanTiBack zhuanTiBack){
            HashMap<String, String> map = ShA1.sha1();
            map.put("start", "0");
            map.put("number", "0");
            map.put("point_time", "0");
            HttpManager.getHttpManager().getApiService(ApiService.basezhuanti, ApiService.class)
                    .getdataaaa(map)
                    .compose(RxUtil.rxFlowableTransformer())
                    .subscribe(new BaseObserver<ZhuanTiBean>() {
                        @Override
                        public void onSuccess(ZhuanTiBean zhuanTiBean) {
                            zhuanTiBack.onSuccess(zhuanTiBean);
                        }
                    });
        }
}
