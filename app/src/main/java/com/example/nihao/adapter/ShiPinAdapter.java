package com.example.nihao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nihao.R;
import com.example.nihao.bean.ShiPinBean;
import com.example.nihao.view.HomeView;

import java.util.ArrayList;

import cn.jzvd.JzvdStd;


public class ShiPinAdapter extends RecyclerView.Adapter<ShiPinAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ShiPinBean.DataBean.ListBean> list;

    public ShiPinAdapter(Context context, ArrayList<ShiPinBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shipin, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.jd.setUp(list.get(position).getVideo_url(), list.get(position).getTheme());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public JzvdStd jd;
        public TextView tv_tv;
        public TextView tv_tvv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.jd = (JzvdStd) itemView.findViewById(R.id.jd);
            this.tv_tv = (TextView) itemView.findViewById(R.id.tv_tv);
            this.tv_tvv = (TextView) itemView.findViewById(R.id.tv_tvv);
        }
    }
}
