package com.example.dipto.dagger2example;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import com.squareup.picasso.Picasso;

/**
 * Created by Dipto on 3/29/2018.
 */

public class GithubApplication extends Application{

    private GithubApplicationComponent component;

    private GithubService githubService;

    private Picasso picasso;

    public static GithubApplication get(Activity activity) {
        return (GithubApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerGithubApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        githubService = component.getGithubService() ;
        picasso = component.getPiacasso() ;

        //githubApplication component need to return
    }

    public GithubApplicationComponent component() {
        return component;
    }
}
