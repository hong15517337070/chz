package com.example.nihao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.nihao.R;
import com.example.nihao.bean.ZhuanTiBean;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class ZhuanTiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<ZhuanTiBean.DataBean.BannerListBean> list;
    private ArrayList<String> imgg;
    private ArrayList<String> title;
    private int TYPE_ONE = 0;
    private int TYPE_TWO = 1;

    public ZhuanTiAdapter(Context context, ArrayList<ZhuanTiBean.DataBean.BannerListBean> list, ArrayList<String> imgg, ArrayList<String> title) {
        this.context = context;
        this.list = list;
        this.imgg = imgg;
        this.title = title;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.zhuanti, null);
            return new ViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.zhuantiii, null);
            return new ViewHoldertwo(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if(type==TYPE_ONE){
            ViewHolder holder1= (ViewHolder) holder;
            holder1.pr1.setMax(4);
            holder1.pr1.setProgress(1);
            holder1.bannnn.setImageLoader(new img()).setImages(imgg).setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                    .setBannerTitles(title)
                    .start()
                    .setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                        @Override
                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                        }

                        @Override
                        public void onPageSelected(int position) {
                            holder1.pr1.setProgress(position+1);
                        }

                        @Override
                        public void onPageScrollStateChanged(int state) {

                        }
                    });
        }else {
            ViewHoldertwo holdertwo= (ViewHoldertwo) holder;
            Glide.with(context).load(list.get(position).getImage_url()).into(holdertwo.imageView8);
            holdertwo.textView12.setText(list.get(position).getTheme());
            holdertwo.textView15.setText(list.get(position).getDescription());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_ONE;
        } else {
            return TYPE_TWO;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public Banner bannnn;
        public ProgressBar pr1;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.bannnn = (Banner) rootView.findViewById(R.id.bannnn);
            this.pr1 = (ProgressBar) rootView.findViewById(R.id.pr1);
        }

    }
    public static
    class ViewHoldertwo extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView imageView8;
        public TextView textView12;
        public TextView textView15;

        public ViewHoldertwo(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.imageView8 = (ImageView) rootView.findViewById(R.id.imageView8);
            this.textView12 = (TextView) rootView.findViewById(R.id.textView12);
            this.textView15 = (TextView) rootView.findViewById(R.id.textView15);
        }

    }
   public class img extends ImageLoader{

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }

}
