package com.example.fenix_ii.loginmvp.login.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.fenix_ii.loginmvp.R;

import butterknife.ButterKnife;

/**
 * Created by fenix-ii on 17/8/16.
 */
public class Result extends AppCompatActivity {
    public TextView result;
    private Context context;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        ButterKnife.bind(this);

        result=(TextView) findViewById(R.id.textView3);
        result.setText("ID :"+getIntent().getStringExtra("id")+"First Name :"+getIntent().getStringExtra("firstName")+"Last Name :"+getIntent().getStringExtra("lastName"));

}
    public Result(Context context){
        this.context=context;
    }
    public Result(){}

}
