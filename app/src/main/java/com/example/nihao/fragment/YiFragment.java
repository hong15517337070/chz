package com.example.nihao.fragment;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nihao.R;
import com.example.nihao.adapter.ShiPinAdapter;
import com.example.nihao.base.BaseMvpFragment;
import com.example.nihao.bean.ShiPinBean;
import com.example.nihao.p.ShiPinPrenster;
import com.example.nihao.view.ShiPinView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class YiFragment extends BaseMvpFragment<ShiPinPrenster, ShiPinView> implements ShiPinView {

    @BindView(R.id.rvv)
    RecyclerView rvv;
    private ShiPinAdapter shiPinAdapter;
    private ArrayList<ShiPinBean.DataBean.ListBean> list;

    @Override
    protected ShiPinView initMvpView() {
        return this;
    }

    @Override
    protected ShiPinPrenster initMvpPresenter() {
        return new ShiPinPrenster();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_yi;
    }

    @Override
    public void initView() {
        super.initView();
        rvv.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        shiPinAdapter = new ShiPinAdapter(getActivity(), list);
        rvv.setAdapter(shiPinAdapter);
    }

    @Override
    public void initData() {
        super.initData();
        mPresenter.ni();
    }

    @Override
    public void onSuccess(ShiPinBean shiPinBean) {
        List<ShiPinBean.DataBean.ListBean> list1 = shiPinBean.getData().getList();
        list.addAll(list1);
        shiPinAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {

    }
}
