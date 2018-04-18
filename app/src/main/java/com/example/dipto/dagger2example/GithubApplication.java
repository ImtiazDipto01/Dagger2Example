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
        GithubApplicationComponent component = DaggerGithubApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        githubService = component.getGithubService();
        picasso = component.getPiacasso() ;



        /***** for checking is scope working well ******/

        /*GithubService githubService2 = component.getGithubService();
        Picasso picasso2 = component.getPiacasso() ;

        GithubService githubService3 = component.getGithubService();
        Picasso picasso3 = component.getPiacasso() ;

        Log.i("DAGGER", "githubService : "+githubService) ;
        Log.i("DAGGER", "githubService2 : "+githubService2) ;
        Log.i("DAGGER", "githubService3 : "+githubService3) ;
        Log.i("DAGGER", "picasso : "+picasso) ;
        Log.i("DAGGER", "picasso2 : "+picasso2) ;
        Log.i("DAGGER", "picasso3 : "+picasso3) ;*/

        /***** for checking is scope working well ******/
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
