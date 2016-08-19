package com.example.fenix_ii.loginmvp.login.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fenix_ii.loginmvp.R;
import com.example.fenix_ii.loginmvp.login.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fenix-ii on 17/8/16.
 */
public class Result extends AppCompatActivity implements ILoginView {
    public TextView result;
    private Context context;
    Button details;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        ButterKnife.bind(this);

        result=(TextView) findViewById(R.id.textView3);
        result.setText("ID :"+getIntent().getStringExtra("id")+'\n'+"First Name :"+getIntent().getStringExtra("firstName")+'\n'+"Last Name :"+getIntent().getStringExtra("lastName")+'\n');
        details=(Button)findViewById(R.id.button2);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("Gender:"+getIntent().getStringExtra("Gender")+'\n'+"Mobile:"+getIntent().getStringExtra("Mobile")+'\n');
                result.append("Date of Birth:"+getIntent().getStringExtra("DateOfBirth"));

            }
        });
}
    public Result(Context context){
        this.context=context;
    }
    public Result(){}


    @Override
    public void showDetails(User data) {
        result.append("Gender:"+data.getGender());
    }


    @Override
    public void onLoggedInSucces(User data){


    }
    @Override
    public void onFailToLogin(String message) {

    }





    @Override
    public void onWrongPassword() {

    }

    @Override
    public void onWrongEmail() {

    }

    @Override
    public void showProgressBar(String message) {

    }

    @Override
    public void hideProgress() {

    }
}
