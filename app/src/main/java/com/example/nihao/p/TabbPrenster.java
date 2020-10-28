package com.example.nihao.p;

import android.util.Log;

import com.example.nihao.back.TabbBack;
import com.example.nihao.base.BasePresenter;
import com.example.nihao.base.BaseView;
import com.example.nihao.bean.TabbBean;
import com.example.nihao.model.TabbModel;

public class TabbPrenster extends BasePresenter implements TabbBack {
    private TabbModel tabbModel;
    @Override
    protected void initModel() {

        tabbModel=new TabbModel();
    }

    public void ni(){
        tabbModel.call(this);
    }

    @Override
    public void onSuccess(TabbBean tabbBean) {
        Log.e("TAG", tabbBean.getData().getList().get(0).getName());
        mView.onSuccess(tabbBean);
    }

    @Override
    public void onFail(String error) {
        mView.onFail(error);
    }
}
