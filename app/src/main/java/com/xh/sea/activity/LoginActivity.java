package com.xh.sea.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.xh.sea.R;
import com.xh.sea.base.BaseActivity;
import com.xh.sea.view.SmoothCheckBox;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.et_login_name)
    EditText etLoginName;
    @BindView(R.id.et_login_password)
    EditText etLoginPassword;
    @BindView(R.id.tv_login_forget_password)
    TextView tvLoginForgetPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_login_register)
    TextView tvLoginRegister;
    @BindView(R.id.scb_login)
    SmoothCheckBox scbLogin;
    @BindView(R.id.lly_login_auto_login)
    LinearLayout llyLoginAutoLogin;

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public View bindView() {
        return null;
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_sea_login;
    }

    @Override
    public void initView(View view) {
//        ProgressUtil.showProgressDialog(this,"请稍后...");
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    protected void setStatusBar() {
//        StatusBarUtil.setTranslucentForImageViewInFragment(this, null);
        StatusBarUtil.setTransparent(this);
    }

    @OnClick({R.id.btn_login, R.id.tv_login_register,R.id.tv_login_forget_password})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_login:
                break;
            case R.id.tv_login_register:
                intent.setClass(this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_login_forget_password:
                intent.setClass(this,ForgetPasswordActivity.class);
                startActivity(intent);
                break;
        }
    }
}
