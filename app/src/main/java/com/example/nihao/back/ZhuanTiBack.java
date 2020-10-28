package com.example.nihao.back;

import com.example.nihao.base.BaseCallback;
import com.example.nihao.bean.ZhuanTiBean;

public interface ZhuanTiBack extends BaseCallback<ZhuanTiBean> {
    void onSuccess(ZhuanTiBean zhuanTiBean);
    void onFail(String error);
}
