package com.example.dipto.dagger2example;

import android.app.Activity;
import android.app.Application;

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
        GithubApplicationComponent component = DaggerGithubApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        githubService = component.getGithubService();
        picasso = component.getPiacasso() ;
    }

    /*public GithubApplicationComponent component() {
        return component;
    }*/

    public GithubService getGithubService() {
        return githubService;
    }

    public Picasso getPicasso() {
        return picasso;
    }
}
