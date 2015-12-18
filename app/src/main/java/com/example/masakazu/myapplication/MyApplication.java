package com.example.masakazu.myapplication;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

/**
 * Created by Masakazu on 15/12/18.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());
    }
}
