package com.example.fenix_ii.loginmvp.login.view;

import com.example.fenix_ii.loginmvp.login.model.User;

/**
 * Created by fenix-ii on 9/8/16.
 */
public interface ILoginView {

    void onFailToLogin(String message);
    void onLoggedInSucces(User data);
    void showDetails(User data);
    void onWrongPassword();
    void onWrongEmail();
    void showProgressBar(String message);
    void hideProgress();
    void onClickDetails(User data);

}
