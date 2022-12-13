package com.example.thesun;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;


public class start extends AppCompatActivity {

    Button startButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        startButton = findViewById(R.id.button_start);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(start.this,"Welcome", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(start.this, MainActivity.class));
            }
        });

    }

}