package com.example.nihao.fragment;


import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.nihao.R;
import com.example.nihao.adapter.ShouYeAdapter;
import com.example.nihao.base.BaseMvpFragment;
import com.example.nihao.bean.TabbBean;
import com.example.nihao.p.TabbPrenster;
import com.example.nihao.view.TabbView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/*
 *  /** * SimpleDateFormat是一个具体的类，用于以区域设置敏感的方式格式化和解析日期。
 *  它允许格式化（日期 - * >文本），解析（文本 - >日期）和规范化。 * SimpleDateFormat允许您从选择任何用户定义的日期时间格式的模式开始。
 *  不过，建议您创建一个日期-时间格式有两种 * getTimeInstance，getDateInstance或 * getDateTimeInstance在DateFormat。
 *  这些类方法中的每一个都可以返回使用默认格式模式初始化的日期 * /时间格式化程序。
 *  您可以applyPattern根据需要使用方法修改格式模式。
 *  * */
public class HomeFragment extends BaseMvpFragment<TabbPrenster, TabbView> implements TabbView {

    @BindView(R.id.img_home_logo)
    ImageView imgHomeLogo;
    @BindView(R.id.img_home_search)
    ImageView imgHomeSearch;
    @BindView(R.id.vp_home)
    ViewPager vpHome;
    @BindView(R.id.tab_home)
    TabLayout tabHome;
    @BindView(R.id.cl_home)
    ConstraintLayout clHome;
    @BindView(R.id.nv_home)
    NavigationView nvHome;
    @BindView(R.id.dl)
    DrawerLayout dl;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> title;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home2;
    }



    @Override
    public void initView() {
        super.initView();
        fragments = new ArrayList<Fragment>();
        title = new ArrayList<>();
    }

    @Override
    public void initData() {
        super.initData();
        mPresenter.ni();
    }

    @Override
    protected TabbView initMvpView() {
        return this;
    }

    @Override
    protected TabbPrenster initMvpPresenter() {
        return new TabbPrenster();
    }

    @Override
    public void onSuccess(TabbBean tabbBean) {
        List<TabbBean.DataBean.ListBean> list = tabbBean.getData().getList();
        for (int i = 0; i < list.size(); i++) {
            //fragments.add(new TaoFragment(list.get(i).getId()));
            fragments.add(new TaoFragment(list.get(i).getId()));
            title.add(list.get(i).getName());
            Log.e("TAG", list.get(i).getName().toString());
        }
        ShouYeAdapter shouYeAdapter = new ShouYeAdapter(getChildFragmentManager(), fragments, title);
        vpHome.setAdapter(shouYeAdapter);
        tabHome.setupWithViewPager(vpHome);


    }

    @Override
    public void onFail(String error) {

    }

    @OnClick({R.id.img_home_search,R.id.img_home_logo,R.id.vp_home,R.id.tab_home,R.id.cl_home,R.id.nv_home,R.id.dl})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.img_home_logo:

                break;
            case R.id.img_home_search:

                break;
            case R.id.vp_home:

                break;
            case R.id.tab_home:

                break;
            case R.id.cl_home:

                break;
            case R.id.nv_home:

                break;
            case R.id.dl:

                break;
        }
    }


}
//    private void shiJianChuo() {
//        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        //获取当前时间
//      String time = sd.format(new Date());
//        // 输出当前时间
//       System.out.println("输出当前时间:"+time);
//        // 时间转换为时间戳
//        Date date = null;
//        try {
//            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        // java中时间戳毫秒计/1000 换算为秒
//       long unixTimestamp = date.getTime() / 1000;
//        // 输出时间戳
//      // System.out.println("输出时间戳:"+unixTimestamp);
//       Log.e("TAG:", unixTimestamp+"");
//        // 时间戳转换为当前时间
//       String ntime = sd.format(unixTimestamp * 1000);
//        // 输出当前时间
//        //System.out.println("输出当前时间[时间戳转换]:"+ntime);
//        Log.e("TAG:", ntime);
//        timestamp = String.valueOf(System.currentTimeMillis() / 1000);
//        nonce = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
//        String str="K;9)Bq|ScMF1h=Vp5uA-G87d(_fi[aP,.w^{vQ:W";
//        try {
//            signature = ShA1.sha1(str);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


