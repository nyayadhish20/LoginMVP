package com.example.fenix_ii.loginmvp;

import android.app.Application;
import com.example.fenix_ii.loginmvp.data.AppData;
import com.example.fenix_ii.loginmvp.data.ServerData;
import io.realm.Realm;
import io.realm.RealmConfiguration;

    /**
     * Created by fenix-ii on 19/8/16.
     */
    public class LoginApplication extends Application {
        LoginApplication loginApplication;
        AppData appData;
        ServerData serverData;

        @Override
        public void onCreate() {
            super.onCreate();
            Realm.setDefaultConfiguration(new RealmConfiguration.Builder(this).build());
            loginApplication = this;
            loginApplication.initialize();

        }

        private void initialize() {
            appData.init();
            serverData.init();
        }


    }
