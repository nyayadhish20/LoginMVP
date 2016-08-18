package com.example.fenix_ii.loginmvp.login.presenter;



import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.fenix_ii.loginmvp.data.AppData;
import com.example.fenix_ii.loginmvp.data.CustomVolleyRequest;
import com.example.fenix_ii.loginmvp.data.ServerData;
import com.example.fenix_ii.loginmvp.login.view.ILoginView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


/**
 * Created by fenix-ii on 9/8/16.
 */
public class LoginPresenter implements ILoginPresenter {
    String username,password;

    boolean savelogin;
    AppData appData;
    ServerData serverData;//
    private ILoginView view;

    public boolean checkEmailIsEmpty(String email){
        if(email.isEmpty())
            return false;
        else
            return true;

    }
    public boolean checkPasswdIsEmpty(String pass){
        if(pass.isEmpty())
            return false;
        else
            return true;

    }


    @Override
    public void loginUser(String email, String passwd) {
        HashMap<String, String> map = new HashMap<>();
        map.put("email",email);
        map.put("password",passwd);
        serverData.APICallLogin(map);


        CustomVolleyRequest jsonObjectRequest = new CustomVolleyRequest(Request.Method.POST,"http://api.v1.heallify.com/account/login",map,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String success = response.getString("success");
                            if(success.equals("1")){
                                JSONObject data = response.getJSONObject("data");
                                String id = data.getString("id");
                                String first_name = data.getString("first_name");
                                String last_name= data.getString("last_name");

                                view.onLoggedInSucces(id, first_name, last_name);


                            }else{
                                view.onFailToLogin("FAIL");
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                                view.onFailToLogin(" BUG ");
                        }


                    }
                },
                new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        view.onFailToLogin("NETWORK ERROR");
                    }
                }
        );
        serverData.addToRequestQueue(jsonObjectRequest);
    }

    @Override
    public String getSavedEmail() {
         return appData.getSavedEmail();
    }

    @Override
    public String getSavedPassword() {
        return appData.getSavedPassword();
    }

    @Override
    public void saveEmail(String email) {
        appData.saveEmail(email);
    }

    @Override
    public void savePassword(String password) {
        appData.savePassword(password);
    }

    @Override
    public Boolean wasRememberMeChecked() {
        return appData.getRememberMe();
    }

    public void ifChecked(){
        appData.setRememberMe();
    }
    public void ifNotChecked(){
        appData.unsetRememberMe();
    }


    public LoginPresenter(AppData appData, ServerData serverData, ILoginView view) {
        this.serverData = serverData;
        this.appData = appData;
        this.view = view;
    }




}
