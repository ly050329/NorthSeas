package com.xh.sea.util;

import android.app.ProgressDialog;
import android.content.Context;

import com.xh.sea.R;
import com.xh.sea.base.SeaApplication;
import com.xh.sea.view.CustomDialog;

public class ProgressUtil {
    public static ProgressDialog progressDialog;
    public static Context context;

    public static void showProgressDialog(String message) {
        showProgressDialog(SeaApplication.getInstance(), message, true);
    }

    public static void showProgressDialog(Context context, String message) {
        showProgressDialog(context, message, true);
    }

    public static void showProgressDialog(Context context, String message, boolean cancelable) {
        try {
            if (progressDialog == null) {
                progressDialog = new CustomDialog(context, R.style.CustomDialog, message);
                progressDialog.setCancelable(cancelable);
                progressDialog.show();
            } else {
                getProgressDialog().setMessage(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dismissProgressDialog() {
//        LogUtils.i("    隐藏对话框    ");
        try {
            if (progressDialog != null) {
                progressDialog.dismiss();
                progressDialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ProgressDialog getProgressDialog() {
        return progressDialog;
    }

}
