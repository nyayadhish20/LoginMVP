package com.example.fenix_ii.loginmvp.login.presenter;

import org.json.JSONException;

/**
 * Created by fenix-ii on 9/8/16.
 */
public interface ILoginPresenter {
    void loginUser(String email, String passwd);
    String getSavedEmail();
    String getSavedPassword();
    void saveEmail(String email);
    void savePassword(String password);
    //void saveRememberMe(boolean )
    Boolean wasRememberMeChecked();
    boolean checkEmailIsEmpty(String email);
    boolean checkPasswdIsEmpty(String pass);


}
