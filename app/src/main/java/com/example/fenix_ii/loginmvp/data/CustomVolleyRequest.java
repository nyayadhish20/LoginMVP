package com.example.fenix_ii.loginmvp.data;

import android.content.Context;

import com.android.volley.ExecutorDelivery;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ResponseDelivery;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * Created by fenix-ii on 17/8/16.
 */
public class CustomVolleyRequest extends Request<JSONObject> {

    private Response.Listener<JSONObject> listener;
    private Map<String, String> params;

  /*  public CustomVolleyRequest(String url, Map<String, Object> params,
                               Listener<JSONObject> reponseListener, ErrorListener errorListener) {
        super(Method.POST, url, errorListener);
        this.listener = reponseListener;
        this.params = params;
    }*/

    public CustomVolleyRequest(int method, String url, Map<String, String> params,
                               Response.Listener<JSONObject> reponseListener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.listener = reponseListener;

       /* if(params!=null){
            HashMap<String,String> mappToStringString = new HashMap<String,String>();
            for (String key:
                    params.keySet()) {
                mappToStringString.put(key,(String)params.get(key));
                AppLog.d(AppLog.T.API,"key : " + key+ " value : " + (String)params.get(key));
            }
*/
        this.params = params;
        //   }
    }

    /*public CustomVolleyRequest(int method, String url, Map<String, String> params,
                               Listener<JSONObject> reponseListener, ErrorListener errorListener) {
        super(method, url, errorListener);
        this.listener = reponseListener;
        this.params = params;
    }*/

    protected Map<String, String> getParams()
            throws com.android.volley.AuthFailureError {
        return params;
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(new JSONObject(jsonString),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
            return Response.error(new ParseError(je));
        }
    }

    @Override
    protected void deliverResponse(JSONObject response) {
        // TODO Auto-generated method stub
        listener.onResponse(response);
    }

    public static RequestQueue newRequestQueueForTest(Context context){
        final File cacheDir = new File(context.getCacheDir(), "volley");

        final ResponseDelivery responseDelivery = new ExecutorDelivery(Executors.newSingleThreadExecutor());

        final RequestQueue queue =
                new RequestQueue(
                        new DiskBasedCache(cacheDir),
                        null,
                        4,
                        responseDelivery);

        queue.start();

        return queue;
    }
}
