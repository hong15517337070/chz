package com.example.nihao.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.viewpager.widget.ViewPager;

import com.example.nihao.R;
import com.example.nihao.adapter.VpAdapter;
import com.example.nihao.base.BaseActivity;
import com.example.nihao.net.AppTion;
import com.example.nihao.zawu.SharedPreferencesUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class VpActivity extends BaseActivity {
    @BindView(R.id.vp_a)
    ViewPager vpA;
    @BindView(R.id.btn_tg)
    Button btnTg;
    private Unbinder bind;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_vp;
    }


    @Override
    protected void initView() {
        super.initView();
        bind = ButterKnife.bind(this);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(R.drawable.splash_guild1);
        integers.add(R.drawable.splash_guild2);
        integers.add(R.drawable.qq);
        VpAdapter vpAdapter = new VpAdapter(this, integers);
        vpA.setAdapter(vpAdapter);


    }

    @Override
    protected void initListener() {
        super.initListener();
        vpA.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                    if (position == 2) {
                        btnTg.setVisibility(View.VISIBLE);
                    }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

   @OnClick({R.id.btn_tg})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_tg:
                Intent intent = new Intent(this, MainActivity.class);
                SharedPreferencesUtil.setParam(this, "key", true);
                startActivity(intent);
                break;
        }
   }
}
