package com.example.nihao.fragment;


import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nihao.R;
import com.example.nihao.adapter.ZhuanTiAdapter;
import com.example.nihao.base.BaseMvpFragment;
import com.example.nihao.bean.ZhuanTiBean;
import com.example.nihao.p.ZhuanTiPrenster;
import com.example.nihao.view.ZhuanTiView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ErFragment extends BaseMvpFragment<ZhuanTiPrenster, ZhuanTiView> implements ZhuanTiView {


    @BindView(R.id.rvvv)
    RecyclerView rvvv;
    @BindView(R.id.iv_er)
    ImageView ivEr;
    private ArrayList<ZhuanTiBean.DataBean.BannerListBean> list;
    private ArrayList<String> imgg;
    private ArrayList<String> title;
    private ZhuanTiAdapter zhuanTiAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_er;
    }

    @Override
    protected ZhuanTiView initMvpView() {
        return this;
    }

    @Override
    protected ZhuanTiPrenster initMvpPresenter() {
        return new ZhuanTiPrenster();
    }

    @Override
    public void initView() {
        super.initView();
        Glide.with(this).load(R.drawable.loading_3).into(ivEr);
        rvvv.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        imgg = new ArrayList<>();
        title = new ArrayList<>();
        zhuanTiAdapter = new ZhuanTiAdapter(getActivity(), list, imgg, title);
        rvvv.setAdapter(zhuanTiAdapter);
    }

    @Override
    public void initData() {
        super.initData();
        mPresenter.ni();

    }

    @Override
    public void onSuccess(ZhuanTiBean zhuanTiBean) {
        List<ZhuanTiBean.DataBean.BannerListBean> list1 = zhuanTiBean.getData().getBanner_list();
        list.addAll(list1);
        for (int i = 0; i < list1.size(); i++) {
            imgg.add(list1.get(i).getImage_url());
            title.add(list1.get(i).getTheme());
        }
        zhuanTiAdapter.notifyDataSetChanged();
        ivEr.setVisibility(View.GONE);
        rvvv.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFail(String error) {

    }
}
