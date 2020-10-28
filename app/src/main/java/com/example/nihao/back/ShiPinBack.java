package com.example.nihao.back;

import com.example.nihao.base.BaseCallback;
import com.example.nihao.bean.ShiPinBean;
import com.example.nihao.bean.YouYeBean;

public interface ShiPinBack extends BaseCallback<ShiPinBean> {
    void onSuccess(ShiPinBean shiPinBean);
    void onFail(String error);
}
