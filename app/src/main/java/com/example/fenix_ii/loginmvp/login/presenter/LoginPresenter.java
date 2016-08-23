package com.example.fenix_ii.loginmvp.login.presenter;





import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.fenix_ii.loginmvp.data.AppData;
import com.example.fenix_ii.loginmvp.data.CustomVolleyRequest;
import com.example.fenix_ii.loginmvp.data.ServerData;
import com.example.fenix_ii.loginmvp.login.model.User;
import com.example.fenix_ii.loginmvp.login.view.ILoginView;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Created by fenix-ii on 9/8/16.
 */
public class LoginPresenter implements ILoginPresenter {
    String username,password;
    String url="http://api.v1.heallify.com/account/login";
    boolean savelogin;
    AppData appData;
    ServerData serverData = new ServerData();
    private ILoginView view;
    RealmConfiguration realmConfig;


    public boolean checkEmailIsEmpty(String email){
        if(!email.isEmpty())
            return true;
        else
            return false;

    }
    public boolean checkPasswdIsEmpty(String pass){
        if(!pass.isEmpty())
            return true;
        else
            return false;

    }


    @Override
    public void loginUser(String email, String passwd) {
        HashMap<String, String> map = new HashMap<>();
        map.put("email",email);
        map.put("password",passwd);
        serverData.APICallLogin(map);
        // appData.init();

        CustomVolleyRequest jsonObjectRequest = new CustomVolleyRequest(Request.Method.POST,url,map,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String success = response.getString("success");
                            if(success.equals("1")){
                                JSONObject data = response.getJSONObject("data");
                                User user = new Gson().fromJson(data.toString(),User.class);
                                createRealmObject(data);
                                view.onLoggedInSucces(user);
                                view.showDetails(user);


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
    public void createRealmObject(JSONObject userJSONOBject){

        /*realmConfig = new RealmConfiguration().Builder(this).build();
        Realm.setDefaultConfiguration(realmConfig);
        Realm realm = Realm.getDefaultInstance();*/
        Realm realm = Realm.getInstance(new RealmConfiguration.Builder(this).build());

        realm.beginTransaction();
        //User u = realm.createObject(User.class);
        realm.createObjectFromJson(User.class,userJSONOBject);
        realm.commitTransaction();

        realm.beginTransaction();
        view.onFailToLogin(realm.where(User.class).findFirst().toString());
        realm.commitTransaction();
    }

    public void showDetails(){

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
