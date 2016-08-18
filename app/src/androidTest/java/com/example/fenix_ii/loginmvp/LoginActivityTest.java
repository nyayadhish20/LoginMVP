package com.example.fenix_ii.loginmvp;

import android.support.test.annotation.UiThreadTest;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.EditText;

import com.example.fenix_ii.loginmvp.login.Login;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by fenix-ii on 11/8/16.
 */
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest extends ActivityInstrumentationTestCase2<Login> {
    public LoginActivityTest() {
        super(Login.class);
    }

    private Button loinButton;
    private EditText et1;
    private EditText et2;
    private Login login;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(false);
        login = getActivity();
        //login = new Login();
        et1 = (EditText) getActivity().findViewById(R.id.editText);
        et2 = (EditText) getActivity().findViewById(R.id.editText2);
        loinButton = (Button) getActivity().findViewById(R.id.button);

        emailValidation();

    }

    @SmallTest
    public void testPreConditions() {
       //assertNotNull(et2);
       // assertNotNull(et1);
    }

    @SmallTest


    @UiThreadTest
//    @Test
    public void emailValidation() {
        login.runOnUiThread(
                new Runnable() {
                    public void run() {

                        assertTrue(et1.requestFocus());
                        //et1.requestFocus();
                        et1.setText("domain.cm");
                        //et2.requestFocus();
                        assertTrue(et2.hasFocus());
                        et2.setText("1234");

                        loinButton.performClick();
                    }
                });
    }


    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
