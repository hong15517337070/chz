package com.example.nihao.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.Guideline;

import com.example.nihao.R;
import com.example.nihao.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class DengLuActivity extends BaseActivity {
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.editText2)
    EditText editText2;
    @BindView(R.id.imageView4)
    ImageView imageView4;
    @BindView(R.id.textView2)
    EditText textView2;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.textView5)
    EditText textView5;
    @BindView(R.id.editText3)
    EditText editText3;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.guideline)
    Guideline guideline;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.guideline3)
    Guideline guideline3;
    @BindView(R.id.textView9)
    TextView textView9;
    @BindView(R.id.textView10)
    TextView textView10;
    private Unbinder bind;
    private Unbinder bind1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_deng_lu;
    }


    @Override
    protected void initView() {
        super.initView();
        bind1 = ButterKnife.bind(this);
    }

    @OnClick({R.id.textView9, R.id.textView10})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.textView9:

                break;
            case R.id.textView10:

                break;
            case R.id.editText3:

                break;
            case R.id.textView5:

                break;
        }




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind1.unbind();
    }
}


