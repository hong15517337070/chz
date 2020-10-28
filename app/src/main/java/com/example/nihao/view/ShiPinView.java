package com.example.nihao.view;

import com.example.nihao.base.BaseView;
import com.example.nihao.bean.ShiPinBean;

public interface ShiPinView extends BaseView<ShiPinBean>{
    void onSuccess(ShiPinBean shiPinBean);
    void onFail(String error);
}
