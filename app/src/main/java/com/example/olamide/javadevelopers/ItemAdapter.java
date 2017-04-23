package com.example.olamide.javadevelopers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.olamide.javadevelopers.controllers.Activity_detail;
import com.example.olamide.javadevelopers.models.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olamide on 4/21/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {


    public List<Item> items = new ArrayList<>();
    public Context context;

    public ItemAdapter(Context appContext, List<Item> items) {
        this.items = items;
        this.context = appContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(items.get(position).getLogin());
        holder.gitlUrl.setText(items.get(position).getAvatarUrl());
        Picasso.with(context)
                .load(items.get(position).getAvatarUrl())
                .placeholder(R.drawable.icon)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView gitlUrl;
        ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            gitlUrl = (TextView) view.findViewById(R.id.githubUrl);
            imageView = (ImageView) view.findViewById(R.id.cover);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        Item clickDataItems = items.get(pos);
                        Intent intent = new Intent(context, Activity_detail.class);
                        intent.putExtra("login", items.get(pos).getLogin());
                        intent.putExtra("html_url", items.get(pos).getHtmlUrl());
                        intent.putExtra("avatar_url", items.get(pos).getAvatarUrl());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(context, "View Clicked" + clickDataItems.getLogin(), Toast.LENGTH_SHORT).show();


                    }
                }
            });
        }
    }
}
