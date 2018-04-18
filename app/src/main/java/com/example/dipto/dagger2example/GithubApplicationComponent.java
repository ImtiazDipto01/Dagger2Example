package com.example.dipto.dagger2example;

import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by Dipto on 3/29/2018.
 */

@GithubApplicationScope
@Component(modules = {GithubServiceModule.class, PicassoModule.class, ActivityModule.class})
public interface GithubApplicationComponent {

    Picasso getPiacasso();

    GithubService getGithubService();

}
