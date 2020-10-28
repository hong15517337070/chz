package com.example.nihao.api;

import com.example.nihao.bean.ShiPinBean;
import com.example.nihao.bean.TabbBean;
import com.example.nihao.bean.YouYeBean;
import com.example.nihao.bean.ZhuanTiBean;

import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiService {
    String baseUrl="https://www.seetao.com";
    //推荐
    @GET("/app/v_1_3/article/recommendlist")
    Flowable<YouYeBean> getData(@QueryMap Map<String ,String > map);
    //Tabb
    String baseTabb="https://www.seetao.com";
    @GET("/api/column/columnlist")
    Flowable<TabbBean> getdataa(@QueryMap Map<String,String> map,@Query("id") String id);

    //视频
    String baseShiPin="https://www.seetao.com";
    @GET("/app/v_1_3/article/videolist")
    Flowable<ShiPinBean>getdataaa(@QueryMap Map<String,String> map);


    //专题
    String basezhuanti="https://www.seetao.com";
    @GET("/app/v_1_3/article/speciallist")
    Flowable<ZhuanTiBean>getdataaaa(@QueryMap Map<String,String> map);

}
