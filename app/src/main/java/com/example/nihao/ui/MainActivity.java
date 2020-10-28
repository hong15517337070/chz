package com.example.nihao.ui;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TableLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.nihao.R;
import com.example.nihao.api.ApiService;
import com.example.nihao.base.BaseActivity;
import com.example.nihao.fragment.ErFragment;
import com.example.nihao.fragment.HomeFragment;
import com.example.nihao.fragment.SanFragment;
import com.example.nihao.fragment.YiFragment;
import com.example.nihao.zawu.ShA1;
import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends BaseActivity {

    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.tab)
    TabLayout tab;
    private Unbinder bind;
//    private ArrayList<Fragment> fragments;
//    private int lastPositoin=0;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        bind = ButterKnife.bind(this);
    }
    @Override
    protected void initView() {
        super.initView();
        tab.addTab(tab.newTab().setText("推荐").setIcon(R.drawable.yi));
        tab.addTab(tab.newTab().setText("视频").setIcon(R.drawable.er));
        tab.addTab(tab.newTab().setText("专题").setIcon(R.drawable.san));
        tab.addTab(tab.newTab().setText("我").setIcon(R.drawable.si));
//        fragments = new ArrayList<>();
//        fragments.add(new HomeFragment());
//        fragments.add(new ErFragment());
//        fragments.add(new SanFragment());
//        fragments.add(new YiFragment());
//        switchFragment(0);

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        YiFragment yiFragment = new YiFragment();
        ErFragment erFragment = new ErFragment();
        SanFragment sanFragment = new SanFragment();
        fragmentTransaction.add(R.id.fl, homeFragment);
        fragmentTransaction.add(R.id.fl, yiFragment);
        fragmentTransaction.add(R.id.fl, erFragment);
        fragmentTransaction.add(R.id.fl, sanFragment);


        fragmentTransaction.show(homeFragment);
        fragmentTransaction.hide(yiFragment);
        fragmentTransaction.hide(erFragment);
        fragmentTransaction.hide(sanFragment);
      fragmentTransaction.commit();

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                switch (tab.getPosition()){
//                    case 0:
//                        switchFragment(0);
//                        break;case 1:
//                        switchFragment(1);
//                        break;case 2:
//                        switchFragment(2);
//                        break;case 3:
//                        switchFragment(3);
//                        break;
//                }
                if(tab.getPosition()==0){

                    FragmentManager supportFragmentManager1 = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction1 = supportFragmentManager1.beginTransaction();
                    fragmentTransaction1.show(homeFragment);
                    fragmentTransaction1.hide(yiFragment);
                    fragmentTransaction1.hide(erFragment);
                    fragmentTransaction1.hide(sanFragment);
                    fragmentTransaction1.commit();
                }else if(tab.getPosition()==1){
                    FragmentManager supportFragmentManager1 = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction1 = supportFragmentManager1.beginTransaction();
                    fragmentTransaction1.show(yiFragment);
                    fragmentTransaction1.hide(homeFragment);
                    fragmentTransaction1.hide(erFragment);
                    fragmentTransaction1.hide(sanFragment);
                    fragmentTransaction1.commit();
                }else if(tab.getPosition()==2){
                    FragmentManager supportFragmentManager1 = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction1 = supportFragmentManager1.beginTransaction();
                    fragmentTransaction1.show(erFragment);
                    fragmentTransaction1.hide(homeFragment);
                    fragmentTransaction1.hide(yiFragment);
                    fragmentTransaction1.hide(sanFragment);
                    fragmentTransaction1.commit();
                }else if(tab.getPosition()==3){
                    FragmentManager supportFragmentManager1 = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction1 = supportFragmentManager1.beginTransaction();
                    fragmentTransaction1.show(sanFragment);
                    fragmentTransaction1.hide(homeFragment);
                    fragmentTransaction1.hide(yiFragment);
                    fragmentTransaction1.hide(erFragment);
                    fragmentTransaction1.commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
//    private void switchFragment(int position) {
//        //获得FragmentTransaction对象
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        //获得fragment对象
//        Fragment curFragment = fragments.get(position);
//        Fragment lastFragment = fragments.get(lastPositoin);
//        //把fragment添加进布局
//        if (!curFragment.isAdded()) {
//            transaction.add(R.id.fl, curFragment);
//        }
//        //切换显示的fragment
//        transaction.hide(lastFragment).show(curFragment);
//        //提交事务
//        transaction.commit();
//        lastPositoin = position;
//    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
