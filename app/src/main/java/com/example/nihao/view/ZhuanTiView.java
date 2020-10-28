package com.example.nihao.view;

import com.example.nihao.base.BaseView;
import com.example.nihao.bean.TabbBean;
import com.example.nihao.bean.ZhuanTiBean;

public interface ZhuanTiView extends BaseView<ZhuanTiBean> {
    void onSuccess(ZhuanTiBean zhuanTiBean);
    void onFail(String error);
}
