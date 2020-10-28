package com.example.nihao.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.nihao.R;
import com.example.nihao.base.BaseActivity;
import com.example.nihao.zawu.SharedPreferencesUtil;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HuanYingYeActivity extends BaseActivity {

    @BindView(R.id.iv_huanyingye)
    ImageView ivHuanyingye;
    private Unbinder bind;
    private int i=3;
    //private String[] str={"1","2","3"};
    private Timer timer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_huan_ying_ye;
    }

    @Override
    protected void initView() {
        super.initView();
        bind = ButterKnife.bind(this);
        boolean k = (boolean) SharedPreferencesUtil.getParam(this, "key", false);


        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new TimerTask() {
                    @Override
                    public void run() {
                        i--;
                        if(i==0){
                            if(k==true){
                                Intent intent = new Intent(HuanYingYeActivity.this, MainActivity.class);
                                startActivity(intent);
                            }else {
                                startActivity(new Intent(HuanYingYeActivity.this,VpActivity.class));
                                timer.cancel();
                                finish();
                            }

                        }
                    }
                });
            }
        };
        timer = new Timer();
        timer.schedule(timerTask, 1000, 1000);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
