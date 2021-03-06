package com.example.dipto.dagger2example;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dipto.dagger2example.main.MainActivity;
import com.example.dipto.dagger2example.model.ServerResponseItem;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class RecylerAdapter extends RecyclerView.Adapter<RecylerAdapter.RecylerViewHolder> {

    private final LayoutInflater inflater;
    private Picasso picasso;
    //private List<ServerResponseItem> list = Collections.emptyList() ;
    private Context context ;
    private List<String> list = Collections.emptyList() ;

    @Inject
    public RecylerAdapter(MainActivity context, Picasso picasso){
        this.context = context ;
        inflater = LayoutInflater.from(context) ;
        this.picasso = picasso ;
    }

    public void setArrayList(/*List<ServerResponseItem> list*/List<String> list){
        this.list = list ;
    }

    @Override
    public RecylerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_recylerview, parent, false) ;
        RecylerViewHolder recylerViewHolder = new RecylerViewHolder(view) ;
        return recylerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecylerViewHolder holder, int position) {
        /*ServerResponseItem serverResponse = list.get(position) ;
        holder.name.setText(serverResponse.getName());
        holder.email.setText(serverResponse.getEmail());*/
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecylerViewHolder extends RecyclerView.ViewHolder{

        TextView name, email ;

        public RecylerViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            email = (TextView) itemView.findViewById(R.id.email) ;
        }
    }
}
