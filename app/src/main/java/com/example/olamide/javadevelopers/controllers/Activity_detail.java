package com.example.olamide.javadevelopers.controllers;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.olamide.javadevelopers.R;

public class Activity_detail extends AppCompatActivity {
    TextView title;
    TextView link, username;
    Toolbar mActionBarToolbar;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = (ImageView) findViewById(R.id.user_image_header);
        username = (TextView) findViewById(R.id.header);
        link = (TextView) findViewById(R.id.githubLink);

        String uname = getIntent().getExtras().getString("login");
        String avatar_url = getIntent().getExtras().getString("avatar_url");
        String hrml_url = getIntent().getExtras().getString("html_url");
        link.setText(hrml_url);
        Linkify.addLinks(link, Linkify.WEB_URLS);
        username.setText(uname);
        Glide.with(this)
                .load(avatar_url)
                .placeholder(R.drawable.icon)
                .into(imageView);
        getSupportActionBar().setTitle("Developer Details ");

    }

    private Intent createShareForCastIntent() {
        String uname = getIntent().getExtras().getString("login");
        String hrml_url = getIntent().getExtras().getString("html_url");
        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText("Check out this awesome developer " + uname + " " + hrml_url)
                .getIntent();
        return shareIntent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        menuItem.setIntent(createShareForCastIntent());
        return true;
    }
}
