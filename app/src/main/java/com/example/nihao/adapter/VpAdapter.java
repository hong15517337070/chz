package com.example.nihao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.nihao.R;

import java.util.ArrayList;

public class VpAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<Integer> integers;
    private ImageView iv_img;
    private ImageView iv_img1;

    public VpAdapter(Context context, ArrayList<Integer> integers) {
        this.context = context;
        this.integers = integers;
    }


    @Override
    public int getCount() {
        return integers.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.vp, null);
        iv_img1 = view.findViewById(R.id.iv_img);
        Glide.with(context).load(integers.get(position)).into(iv_img1);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((View)object);
    }
}
