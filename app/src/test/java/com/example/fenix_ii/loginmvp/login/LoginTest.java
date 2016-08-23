package com.example.fenix_ii.loginmvp.login;

import android.content.Context;
import android.provider.Settings;
import android.view.View;

import com.example.fenix_ii.loginmvp.data.AppData;
import com.example.fenix_ii.loginmvp.data.ServerData;
import com.example.fenix_ii.loginmvp.login.presenter.LoginPresenter;
import com.example.fenix_ii.loginmvp.login.view.ILoginView;
import com.example.fenix_ii.loginmvp.utilities.Validations;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.verification.VerificationMode;

import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by fenix-ii on 11/8/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginTest {
    @Mock
    AppData appData;

    @Mock
    Context context;

    LoginPresenter mPresenter;
    @Mock
    ServerData serverData;
    @Mock
    Login login;



    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

       // when(appData.getSavedEmail()).thenReturn("savedemail@gmail.com");
        //when(appData.getSavedPassword()).thenReturn("password");

        mPresenter = new LoginPresenter(login);
    }

    @Test
    public void shouldShowErrorMsgWhenEmailIsEmpty() throws Exception {
        when(login.getUser()).thenReturn("someemail@fmail.com") ;
        System.out.println("The value of first test email address is : " + login.getUser());
        assertEquals(false,mPresenter.checkEmailIsEmpty(login.getUser()));
    }

    @Test
    public void shouldReturnTrueWhenEmailIsEmpty() throws Exception {
        when(login.getUser()).thenReturn("") ;
        System.out.println("The value of second test email address is : " + login.getUser() + " Length " + login.getUser().length() + " AND " + mPresenter.checkEmailIsEmpty(login.getUser()));
        assertEquals(true,mPresenter.checkEmailIsEmpty(login.getUser()));
    }

    @Test
    public void shouldShowResultWhenLoggedIn() throws Exception{
        /*
        * 1. Pass input params to login method of presenter
        * 2. Mock Resposne from server
        * 3. Parse received response
        * */

        //when(mPresenter.loginUser("teast@ggmailc.om","passwrod"));
        //when(login.onLoggedInSucces(anyString(),anyString(),anyString())).
    }

}
