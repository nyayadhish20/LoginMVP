package com.example.fenix_ii.loginmvp.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by fenix-ii on 11/8/16.
 */
public class AppData {
    private  final String KEYEMAIL = "email";
    private  final String KEYPASS = "pass";
    private final String KEYREMEBER = "remember";
    private SharedPreferences loginpreff;
    private SharedPreferences.Editor preffEditor;
    private static final String DEFAULTPREFERENCES = "default";
    static AppData appData;
    public AppData(Context context) {
        loginpreff=context.getSharedPreferences(DEFAULTPREFERENCES, Context.MODE_PRIVATE);
        preffEditor= loginpreff.edit();
        preffEditor.commit();
    }
    public AppData(){
        appData= AppData.this;
    }

    public static void init(){
        if(appData==null){
            appData= new AppData();
        }

    }


    public boolean getRememberMe(){
        return loginpreff.getBoolean(KEYREMEBER,false);
    }

    public void setRememberMe(){
        preffEditor.putBoolean(KEYREMEBER,true);
        preffEditor.commit();
    }

    public void unsetRememberMe(){
        preffEditor.clear();
        preffEditor.commit();
    }

    public void savePassword(String password){
        preffEditor.putString(KEYPASS,password);
        preffEditor.commit();
    }

    public void saveEmail(String email){
        preffEditor.putString(KEYEMAIL,email);
        preffEditor.commit();
    }

    public String getSavedEmail(){
        return loginpreff.getString(KEYEMAIL,"");
    }

    public String getSavedPassword(){
        return loginpreff.getString(KEYPASS,"");
    }
}
