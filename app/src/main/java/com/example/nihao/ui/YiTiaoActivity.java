package com.example.nihao.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.nihao.R;
import com.example.nihao.adapter.YiTiaoAdapter;
import com.example.nihao.base.BaseActivity;
import com.example.nihao.bean.TabbBean;
import com.example.nihao.bean.YouYeBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YiTiaoActivity extends BaseActivity{


    @BindView(R.id.iv_tui1)
    ImageView ivTui1;
    @BindView(R.id.vp_yi_tiao)
    ViewPager vpYiTiao;
    @BindView(R.id.et_xiepinglun)
    EditText etXiepinglun;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_yi_tiao;
    }

    @Override
    protected void initView() {
        super.initView();
        Intent intent = getIntent();
        YouYeBean name = (YouYeBean) intent.getSerializableExtra("name");

    }
}

