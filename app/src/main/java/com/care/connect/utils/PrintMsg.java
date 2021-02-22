package com.care.connect.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.care.connect.BuildConfig;

public class PrintMsg {

    public static void SetToast(Context context, String Msg) {

        try {
            Toast.makeText(context, ""+Msg, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setprint(Context context, String Msg) {

//        if (BuildConfig.DEBUG) {
        if (context != null)
            Log.e(context.getClass().getSimpleName(), Msg);
//        }
    }

}