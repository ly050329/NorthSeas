package com.xh.sea.base;

import android.app.Application;
import android.text.TextUtils;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.HttpHeaders;
import com.xh.sea.util.Density;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/**
 * Created by Administrator on 2019/9/9.
 */

public class SeaApplication extends Application {

    private static SeaApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
//        Density.setDensity(this);
        initOkgo();
    }

    public static SeaApplication getInstance() {
        return instance;
    }

    private void initOkgo() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //全局的读取超时时间
        builder.readTimeout(100000, TimeUnit.MILLISECONDS);
        //全局的写入超时时间
        builder.writeTimeout(100000, TimeUnit.MILLISECONDS);
        //全局的连接超时时间
        builder.connectTimeout(100000, TimeUnit.MILLISECONDS);
        builder.protocols(Collections.singletonList(Protocol.HTTP_1_1));
        HttpHeaders headers = new HttpHeaders();

        OkGo.getInstance().init(this)                       //必须调用初始化
                .setOkHttpClient(builder.build())               //建议设置OkHttpClient，不设置将使用默认的
                .setCacheMode(CacheMode.NO_CACHE)               //全局统一缓存模式，默认不使用缓存，可以不传
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)   //全局统一缓存时间，默认永不过期，可以不传
                .addCommonHeaders(headers)                      //全局公共头
                .setRetryCount(0);                          //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
//				.addCommonParams(params);                       //全局公共参数
    }
}
