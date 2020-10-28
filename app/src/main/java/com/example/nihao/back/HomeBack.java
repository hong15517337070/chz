package com.example.nihao.back;

import com.example.nihao.base.BaseCallback;
import com.example.nihao.bean.YouYeBean;

public interface HomeBack extends BaseCallback<YouYeBean> {
    void onSuccess(YouYeBean youYeBean);
    void onFail(String error);
}
