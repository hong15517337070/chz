package com.example.nihao.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.nihao.R;
import com.example.nihao.bean.YouYeBean;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class TabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<YouYeBean.DataBean.ArticleListBean> list;
    private ArrayList<YouYeBean.DataBean.BannerListBean> listBeans;
    private ArrayList<YouYeBean.DataBean.FlashListBean> listBeans1;
    private ArrayList<String> imgg;
    private ArrayList<String> title;
    private onClickListener onClickListener;

    public void setOnClickListener(TabAdapter.onClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public TabAdapter(Context context, ArrayList<YouYeBean.DataBean.ArticleListBean> list, ArrayList<YouYeBean.DataBean.FlashListBean> listBeans1, ArrayList<String> imgg, ArrayList<String> title) {
        this.context = context;
        this.list = list;
        this.listBeans = listBeans;
        this.listBeans1 = listBeans1;
        this.imgg = imgg;
        this.title = title;
    }

    private int TYPE_0 = 0;
    private int TYPE_1 = 1;
    private int TYPE_2 = 2;
    private int TYPE_3 = 3;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.add, null);
            return new ViewHolder(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.addd, null);
            return new ViewHolder1(view);
        } else if (viewType == 2) {
            View view = LayoutInflater.from(context).inflate(R.layout.adddd, null);
            return new ViewHolder2(view);
        } else if (viewType == 3) {
            View view = LayoutInflater.from(context).inflate(R.layout.addddd, null);
            return new ViewHolder4(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == TYPE_0) {
            ViewHolder holder0 = (ViewHolder) holder;
            holder0.pb.setMax(4);
            holder0.pb.setProgress(1);
            holder0.bann.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load(path).into(imageView);
                }
            }).setImages(imgg)
                    .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                    .setBannerTitles(title)
                    .start()
                    .setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                        @Override
                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                        }

                        @Override
                        public void onPageSelected(int position) {
                            holder0.pb.setProgress(position + 1);
                        }

                        @Override
                        public void onPageScrollStateChanged(int state) {

                        }
                    });
        } else if (type == TYPE_1) {
            ViewHolder1 holder1 = (ViewHolder1) holder;
            Glide.with(context).load(list.get(position).getImage_url()).into(holder1.imageView6);
            holder1.textView13.setText(list.get(position).getEdit_time());
            holder1.textView14.setText(list.get(position).getColumn_name());
        } else if (type == TYPE_2) {
            ViewHolder2 holder2 = (ViewHolder2) holder;
            Glide.with(context).load(list.get(position).getImage_url()).into(holder2.iv_adddd_img);
            holder2.tv_adddd.setText(list.get(position).getEdit_time());
            holder2.tv_adddd_er.setText(list.get(position).getId());

        } else if (type == TYPE_3) {
            ViewHolder4 holder4 = (ViewHolder4) holder;
        //  Uri uri = Uri.parse(list.get(position).getVideo_url());
            holder4.vivo.setMediaController(new MediaController(context));
          // holder4.vivo.setVideoURI(uri);
            holder4.vivo.requestFocus();
            holder4.vivo.start();
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onClickListener!=null){
                    onClickListener.onClick(position);
                }
            }
        });



    }

    @Override
    public int getItemViewType(int position) {
        int i = position;
        if (i == 0) {
            return TYPE_0;
        } else if (list.get(position).getView_type() == 1) {
            return TYPE_1;
        } else if (list.get(position).getView_type() == 2) {
            return TYPE_2;
        } else if (list.get(position).getView_type() == 4) {
            return TYPE_3;
        }
        return i;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public interface onClickListener{
        void onClick(int position);
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public Banner bann;
        public ProgressBar pb;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.bann = (Banner) rootView.findViewById(R.id.bann);
            this.pb = (ProgressBar) rootView.findViewById(R.id.pb);
        }

    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView imageView6;
        public TextView textView13;
        public TextView textView14;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.imageView6 = (ImageView) rootView.findViewById(R.id.imageView6);
            this.textView13 = (TextView) rootView.findViewById(R.id.textView13);
            this.textView14 = (TextView) rootView.findViewById(R.id.textView14);
        }
    }


    public static
    class ViewHolder4 extends RecyclerView.ViewHolder {
        public View rootView;
        public VideoView vivo;

        public ViewHolder4(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.vivo = (VideoView) rootView.findViewById(R.id.vivo);
        }

    }

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_adddd_img;
        public TextView tv_adddd;
        public TextView tv_adddd_er;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_adddd_img = (ImageView) rootView.findViewById(R.id.iv_adddd_img);
            this.tv_adddd = (TextView) rootView.findViewById(R.id.tv_adddd);
            this.tv_adddd_er = (TextView) rootView.findViewById(R.id.tv_adddd_er);
        }


    }
}
