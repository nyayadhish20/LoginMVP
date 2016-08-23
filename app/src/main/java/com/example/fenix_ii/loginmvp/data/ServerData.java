package com.example.fenix_ii.loginmvp.data;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


import com.example.fenix_ii.loginmvp.login.view.Result;

import java.util.HashMap;

/**
 * Created by fenix-ii on 17/8/16.
 */
public class ServerData {

    public static final String TAG = ServerData.class.getSimpleName();
    private String url="http://api.v1.heallify.com/account/login";
    private RequestQueue requestQueue;
    private Context context;
    public String first_name,last_name,id;

    public static ServerData serverData;
    Result resultObject = new Result(context);
    public ServerData(Context context){
          this.context=context;
    }
    public ServerData(){}
/*  *//*  public static synchronized ServerData getServerDataInstance() {
        return serverDataInstance;
    }
*/  public static  ServerData getInstance(){
    return serverData;
        }
    public static void init(){
        if(serverData==null){
            serverData=new ServerData();
        }
    }
    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(this.context);
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (requestQueue != null) {
            requestQueue.cancelAll(tag);
        }
    }

    public void APICallLogin(HashMap credentials){

    }
}