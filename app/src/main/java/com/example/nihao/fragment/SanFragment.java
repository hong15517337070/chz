package com.example.nihao.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.nihao.R;
import com.example.nihao.base.BaseFragment;
import com.example.nihao.ui.DengLuActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SanFragment extends BaseFragment {


    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.btn_weiqiandao)
    Button btnWeiqiandao;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.ll3)
    LinearLayout ll3;
    @BindView(R.id.ll4)
    LinearLayout ll4;
    @BindView(R.id.btn_denglu)
    Button btnDenglu;
    private Unbinder bind;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_san;
    }

    @Override
    public void initView() {
        super.initView();
        bind = ButterKnife.bind(getActivity());

    }
    @OnClick({R.id.ll1,R.id.ll2,R.id.ll3,R.id.ll4,R.id.btn_denglu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll1:
                Intent intent = new Intent(getActivity(), DengLuActivity.class);
                startActivity(intent);
                break;
            case R.id.ll2:
                Intent intent2 = new Intent(getActivity(), DengLuActivity.class);
                startActivity(intent2);
                break;
            case R.id.ll3:
                Intent intent3 = new Intent(getActivity(), DengLuActivity.class);
                startActivity(intent3);
                break;
            case R.id.ll4:
                Intent intent4 = new Intent(getActivity(), DengLuActivity.class);
                startActivity(intent4);
                break;
            case R.id.btn_denglu:
                Intent intentd = new Intent(getActivity(), DengLuActivity.class);
                startActivity(intentd);
                break;
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}

