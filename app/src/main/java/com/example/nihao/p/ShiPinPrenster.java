package com.example.nihao.p;

import com.example.nihao.back.ShiPinBack;
import com.example.nihao.base.BasePresenter;
import com.example.nihao.bean.ShiPinBean;
import com.example.nihao.model.ShiPinModel;

public class ShiPinPrenster extends BasePresenter implements ShiPinBack {
    private ShiPinModel shiPinModel;
    @Override
    protected void initModel() {
        shiPinModel=new ShiPinModel();
    }

    public void ni(){
        shiPinModel.call(this);
    }

    @Override
    public void onSuccess(ShiPinBean shiPinBean) {
        mView.onSuccess(shiPinBean);
    }

    @Override
    public void onFail(String error) {
            mView.onFail(error);
    }
}
