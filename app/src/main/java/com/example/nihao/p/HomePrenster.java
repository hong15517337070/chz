package com.example.nihao.p;

import com.example.nihao.back.HomeBack;
import com.example.nihao.base.BasePresenter;
import com.example.nihao.base.BaseView;
import com.example.nihao.bean.YouYeBean;
import com.example.nihao.model.HomeModel;

public class HomePrenster extends BasePresenter implements HomeBack{

    private HomeModel homeModel;
    @Override
    protected void initModel() {

        homeModel=new HomeModel();
    }
    public void in(String id){
        homeModel.call(this,id);
    }

    @Override
    public void onSuccess(YouYeBean youYeBean) {
        mView.onSuccess(youYeBean);
    }

    @Override
    public void onFail(String error) {
            mView.onFail(error);
    }
}
