package com.xh.sea.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xh.sea.R;
import com.xh.sea.base.BaseActivity;
import com.xh.sea.util.ProgressUtil;

public class MainActivity extends BaseActivity {


    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public View bindView() {
        return null;
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(View view) {
        ProgressUtil.showProgressDialog(this,"请稍后...");
    }

    @Override
    public void doBusiness(Context mContext) {

    }
}
