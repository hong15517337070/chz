package com.example.nihao.p;

import com.example.nihao.back.ZhuanTiBack;
import com.example.nihao.base.BasePresenter;
import com.example.nihao.bean.ZhuanTiBean;
import com.example.nihao.model.ZhuanTiModel;

public class ZhuanTiPrenster extends BasePresenter implements ZhuanTiBack {
    private ZhuanTiModel zhuanTiModel;
    @Override
    protected void initModel() {
        zhuanTiModel=new ZhuanTiModel();
    }

    public void ni(){
        zhuanTiModel.call(this);
    }

    @Override
    public void onSuccess(ZhuanTiBean zhuanTiBean) {
        mView.onSuccess(zhuanTiBean);
    }

    @Override
    public void onFail(String error) {
        mView.onFail(error);
    }
}
