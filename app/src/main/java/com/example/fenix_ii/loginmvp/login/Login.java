package com.example.fenix_ii.loginmvp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fenix_ii.loginmvp.R;
import com.example.fenix_ii.loginmvp.data.AppData;
import com.example.fenix_ii.loginmvp.data.ServerData;
import com.example.fenix_ii.loginmvp.login.model.User;
import com.example.fenix_ii.loginmvp.login.presenter.LoginPresenter;
import com.example.fenix_ii.loginmvp.login.view.ILoginView;
import com.example.fenix_ii.loginmvp.login.view.Result;
import com.example.fenix_ii.loginmvp.utilities.Validations;



import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Login extends AppCompatActivity implements ILoginView {

    @BindView (R.id.editText) EditText boxEmailAddres;
    @BindView(R.id.editText2) EditText boxPassword;
    @BindView(R.id.button)Button click;
    @BindView(R.id.checkBox)CheckBox chksave;
    private LoginPresenter mPresenter;
    private String user, pass;
    private HashMap<String,String> credentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        credentials= new HashMap<>();

        Realm realm = Realm.getInstance(new RealmConfiguration.Builder(this).build());
        User user = realm.where(User.class).findFirst();
        if(user!=null){
            Intent intent =new Intent(this ,Result.class);
            intent.putExtra("id",user.getId());
            intent.putExtra("firstName",user.getFirst_name());
            intent.putExtra("lastName",user.getLast_name());
            intent.putExtra("Gender",user.getGender());
            intent.putExtra("Mobile",user.getMobile());
            intent.putExtra("DateOfBirth",user.getDate_of_birth());
            startActivity(intent);
        }else{
            mPresenter = new LoginPresenter(new AppData(this),new ServerData(this),this);
            if (mPresenter.wasRememberMeChecked()) {
                boxEmailAddres.setText(mPresenter.getSavedEmail());
                boxPassword.setText(mPresenter.getSavedPassword());
                chksave.setChecked(true);
            }
        }


    }

    @OnClick(R.id.button)
    public void loginUser() {
        user = getUser();
        pass = getPass();
        credentials.put("email",user);
        credentials.put("password",pass);


        if (mPresenter.checkEmailIsEmpty(user)) {
                    if(mPresenter.checkPasswdIsEmpty(pass)){
                        if (chksave.isChecked()) {
                            mPresenter.ifChecked();
                            mPresenter.saveEmail(user);
                            mPresenter.savePassword(pass);
                        } else {
                            mPresenter.ifNotChecked();
                        }
                        if (Validations.validateEmail(boxEmailAddres.getText())) {
                           mPresenter.loginUser(boxEmailAddres.getText().toString(), boxPassword.getText().toString());
                        } else {
                            boxEmailAddres.setError("Invalid Email");
                        }
                    }else{
                        boxPassword.setError("Password should not be blank");
                    }
                }else{
                    boxEmailAddres.setError("Email should not be blank");
                }
            }


    public String getPass(){
       return boxPassword.getText().toString();
    }

    public String getUser(){

       return boxEmailAddres.getText().toString();
    }




    @Override
    public void onFailToLogin(String message) {
        Toast.makeText(Login.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoggedInSucces(User data) {
        Toast.makeText(Login.this, "Success Fully ", Toast.LENGTH_SHORT).show();
        Intent intent =new Intent(this ,Result.class);
                                intent.putExtra("id",data.getId());
                                intent.putExtra("firstName",data.getFirst_name());
                                intent.putExtra("lastName",data.getLast_name());
                                intent.putExtra("Gender",data.getGender());
                                intent.putExtra("Mobile",data.getMobile());
                                intent.putExtra("DateOfBirth",data.getDate_of_birth());
                                startActivity(intent);
    }

    @Override
    public void showDetails(User data) {

    }

    @Override
    public void onWrongPassword() {
        boxPassword.setError("Password is Wrong");
    }

    @Override
    public void onWrongEmail() {
        boxEmailAddres.setError("Email is wrong");
    }

    @Override
    public void showProgressBar(String message) {

    }

    @Override
    public void hideProgress() {

    }
}