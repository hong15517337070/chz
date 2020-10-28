package com.example.nihao.view;

import com.example.nihao.base.BaseView;
import com.example.nihao.bean.TabbBean;

public interface TabbView extends BaseView<TabbBean> {
    void onSuccess(TabbBean tabbBean);
    void onFail(String error);
}
