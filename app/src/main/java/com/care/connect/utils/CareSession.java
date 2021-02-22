package com.care.connect.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class CareSession {

    public static final String USER_NAME = "Username";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "care_connect_app";

    // Constructor
    public CareSession(Context context) {
        this._context = context;
        if (_context != null) {
            pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
            editor = pref.edit();
        }
    }

    public String getUserName() {
        return pref.getString(USER_NAME, "");
    }

    public void setUserName(String name) {
        editor.putString(USER_NAME, name);
        editor.commit();
    }
}
