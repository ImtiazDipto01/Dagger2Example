package com.example.dipto.dagger2example.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dipto.dagger2example.GithubApplication;
import com.example.dipto.dagger2example.GithubService;
import com.example.dipto.dagger2example.R;
import com.example.dipto.dagger2example.RecylerAdapter;
import com.example.dipto.dagger2example.model.ResponseRoot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.recylerview)
    RecyclerView recylerview;

    @Inject
    GithubService githubService ;

    @Inject
    RecylerAdapter recylerAdapter ;

    Picasso picasso ;
    Call<ResponseRoot> call ;
    private LinearLayoutManager layoutManager;
    MainActivityComponent component ;
    List<String> list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        component = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .githubApplicationComponent(GithubApplication.get(this).component())
                .build() ;

        component.injectMainActivity(this);

        setNotificationRecylerView();
    }

    private void setNotificationRecylerView() {

        //TODO inject layout manager
        layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recylerview.setLayoutManager(layoutManager);
        //notificationAdapter.setClicklistner(this);
        recylerAdapter.setArrayList(getData());
        recylerview.setAdapter(recylerAdapter);
    }

    private List<String> getData(){
        list = new ArrayList<String>() ;
        list.add("Value");
        list.add("Value");
        list.add("Value");
        return list ;
    }
}
