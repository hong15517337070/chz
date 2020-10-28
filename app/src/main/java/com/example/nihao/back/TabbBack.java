package com.example.nihao.back;

import com.example.nihao.base.BaseCallback;
import com.example.nihao.bean.TabbBean;


public interface TabbBack extends BaseCallback<TabbBean> {
    void onSuccess(TabbBean tabbBean);
    void onFail(String error);
}
