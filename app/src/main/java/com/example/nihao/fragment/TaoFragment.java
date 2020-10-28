package com.example.nihao.fragment;


import android.content.Intent;
import android.media.Image;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nihao.R;
import com.example.nihao.adapter.TabAdapter;
import com.example.nihao.base.BaseMvpFragment;
import com.example.nihao.bean.TabbBean;
import com.example.nihao.bean.YouYeBean;
import com.example.nihao.p.HomePrenster;
import com.example.nihao.ui.YiTiaoActivity;
import com.example.nihao.view.HomeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaoFragment extends BaseMvpFragment<HomePrenster, HomeView> implements HomeView {

    @BindView(R.id.rv)
    RecyclerView rv;
    private String id;
    private ArrayList<YouYeBean.DataBean.ArticleListBean> list;
    private ArrayList<YouYeBean.DataBean.BannerListBean> listBeans;
    private ArrayList<YouYeBean.DataBean.FlashListBean> listBeans1;
    private ArrayList<String> imgg;
    private ArrayList<String> title;
    private TabAdapter tabAdapter;
    private Intent intent;
    private YouYeBean y;
    public TaoFragment(String id) {

        this.id = id;
    }

    @Override
    protected HomeView initMvpView() {
        return this;
    }

    @Override
    protected HomePrenster initMvpPresenter() {
        return new HomePrenster();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tao;
    }

    @Override
    public void onSuccess(YouYeBean youYeBean) {
        List<YouYeBean.DataBean.ArticleListBean> article_list = youYeBean.getData().getArticle_list();
        List<YouYeBean.DataBean.BannerListBean> banner_list1 = youYeBean.getData().getBanner_list();
        List<YouYeBean.DataBean.FlashListBean> flash_list = youYeBean.getData().getFlash_list();
        list.addAll(article_list);
        listBeans.addAll(banner_list1);
        listBeans1.addAll(flash_list);
        y=youYeBean;
        for (int i = 0; i < banner_list1.size(); i++) {
            imgg.add(banner_list1.get(i).getImage_url());
            title.add(banner_list1.get(i).getTheme());
            Log.e("tagg", imgg+"////"+title);
        }
        tabAdapter.notifyDataSetChanged();

    }

    @Override
    public void onFail(String error) {

    }

    @Override
    public void initView() {
       super.initView();
        //Log.e("TAG", "------");
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        listBeans = new ArrayList<>();
        listBeans1 = new ArrayList<>();
        imgg = new ArrayList<>();
        title = new ArrayList<>();
        tabAdapter = new TabAdapter(getActivity(), list,listBeans1, imgg, title);
        rv.setAdapter(tabAdapter);
    }
    @Override
    public void initData() {
        super.initData();
        mPresenter.in(id);
    }

    @Override
    public void initListener() {
        super.initListener();
        tabAdapter.setOnClickListener(new TabAdapter.onClickListener() {



            @Override
            public void onClick(int position) {
                intent = new Intent(getActivity(), YiTiaoActivity.class);
                intent.putExtra("name", y);
                startActivity(intent);
            }
        });
    }
}
