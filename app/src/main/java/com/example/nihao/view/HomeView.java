package com.example.nihao.view;


import com.example.nihao.base.BaseView;
import com.example.nihao.bean.YouYeBean;

public  interface HomeView  extends BaseView<YouYeBean> {
    void onSuccess(YouYeBean youYeBean);
    void onFail(String error);
}
