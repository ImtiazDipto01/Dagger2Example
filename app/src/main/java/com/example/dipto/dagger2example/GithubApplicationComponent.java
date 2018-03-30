package com.example.dipto.dagger2example;

import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by Dipto on 3/29/2018.
 */
@Component(modules = {GithubServiceModule.class, NetworkModule.class, ContextModule.class})
public interface GithubApplicationComponent {

    Picasso getPiacasso();

    GithubService getGithubService();

}
