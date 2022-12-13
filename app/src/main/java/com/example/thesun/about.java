package com.example.thesun;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.thesun.databinding.ActivityAboutBinding;

public class about extends AppCompatActivity {

    Button contactUs;
    TextView aboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        String AboutDesc = "News Zilla is USA's most trusted source of news and current affairs. News Zilla experienced team has delivered breaking news, features and exclusive news from around USA and the world into homes since 1956.\n" +
                "\n" +
                "Since the very first news  Channel Nine has continued to broadcast more hours of news and current affairs than any other USA commercial TV network.";


        aboutUs = findViewById(R.id.abouttxt);
        contactUs = findViewById(R.id.contactbtn);
        aboutUs.setText(AboutDesc);

        contactUs.setOnClickListener(v -> {
            Intent contact = new Intent(about.this, contactsUS.class);
            startActivity(contact);
        });

    }



}