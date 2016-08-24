package com.example.fenix_ii.loginmvp.Search.presenter;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.fenix_ii.loginmvp.Search.View.ISearchView;
import com.example.fenix_ii.loginmvp.Search.model.SearchModel;
import com.example.fenix_ii.loginmvp.data.ServerData;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by fenix-ii on 23/8/16.
 */
public class SearchPresenter implements ISearchPresenter {
    ISearchView searchView;
    JSONObject jsonObjectInJsonArray;
    String listUrl="http://api.v1.heallify.com/autocomplete";
    @Override
    public void fetchList() throws JSONException {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(listUrl, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<response.length();i++){
                    try{
                        JSONObject jObj= response.getJSONObject(i);
                        JSONArray jArray= jObj.getJSONArray("specializations");
                        for(i=0;i<jArray.length();i++){
                            jsonObjectInJsonArray = jArray.getJSONObject(i);
                        }
                        SearchModel searchModel=new Gson().fromJson(jsonObjectInJsonArray.toString(),SearchModel.class);
                        searchView.onFetchSuccess(searchModel);

                    } catch (JSONException e) {
                        e.printStackTrace();
                        searchView.onFail("Fail in parsing");
                    }
                }

            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                searchView.onFail("volley Error");
            }
        });
        ServerData.getServerData().addToRequestQueue(jsonArrayRequest);
    }
}
