package com.example.fenix_ii.loginmvp.utilities;

import android.util.Patterns;

import java.util.regex.Pattern;

/**
 * Created by fenix-ii on 9/8/16.
 */
public class Validations {
    public static Boolean validateEmail(CharSequence email){
        return Patterns.EMAIL_ADDRESS.matcher(email)
                .matches();
    }

    public static Boolean validateMobile(String mobileNumber){
        return true;
    }

 /*   public static Pattern getEmailPattern(){
        return Patterns.EMAIL_ADDRESS;
    }*/

}
