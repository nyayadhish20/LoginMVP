package com.example.fenix_ii.loginmvp.login.view;

/**
 * Created by fenix-ii on 9/8/16.
 */
public interface ILoginView {

    void onFailToLogin(String message);
    void onLoggedInSucces(String id, String firstName, String lastName);
    void onWrongPassword();
    void onWrongEmail();
    void showProgressBar(String message);
    void hideProgress();

}
