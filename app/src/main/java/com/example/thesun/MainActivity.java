package com.example.thesun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.thesun.models.Headlines;
import com.example.thesun.models.NewsResponseAPI;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectPageListner, View.OnClickListener {

    RecyclerView recyclerView;
    CAdapter cAdapter;
    ProgressDialog dialog;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    ImageButton aboutUs;
    SearchView searchView;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView =findViewById(R.id.search_view);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                dialog.setTitle("Loading News articles of"+ query);
                dialog.show();
                ManageRequest manageRequest = new ManageRequest(MainActivity.this);
                manageRequest.getNewsHeadlines(listener, "general", query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        dialog =new ProgressDialog(this);

        dialog.setTitle("Loading News Articles");
        dialog.show();


        btn1 = findViewById(R.id.button_1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.button_2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.button_3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.button_4);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.button_5);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.button_6);
        btn6.setOnClickListener(this);
        btn7 = findViewById(R.id.button_7);
        btn7.setOnClickListener(this);

        aboutUs = findViewById(R.id.aboutUs);

        aboutUs.setOnClickListener(v -> {
            Intent contact = new Intent(MainActivity.this, about.class);
            startActivity(contact);
        });


        ManageRequest manageRequest = new ManageRequest(this);
        manageRequest.getNewsHeadlines(listener, "general", null);



    }

    private final fetchDataListener<NewsResponseAPI> listener = new fetchDataListener<NewsResponseAPI>() {
        @Override
        public void onFetchData(List<Headlines> list, String message) {
            if(list.isEmpty()){
                Toast.makeText(MainActivity.this,"No Data Found", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
            else {
                ShowNews(list);
                dialog.dismiss();
            }

        }

        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity.this,"An Error Occurred",Toast.LENGTH_SHORT).show();
        }
    };

    private void ShowNews(List<Headlines> list) {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        cAdapter = new CAdapter(this, list, this);
        recyclerView.setAdapter(cAdapter);

    }

    @Override
    public void NewsClicked(Headlines headlines) {
        startActivity(new Intent(MainActivity.this, AllDetailsActivity.class)
                .putExtra("data", headlines));
    }

    @Override
    public void onClick(View v){
        Button button = (Button) v;
        String category = button.getText().toString();

        dialog.setTitle("Loading News Articles of "+category);
        dialog.show();
        ManageRequest manageRequest = new ManageRequest(this);
        manageRequest.getNewsHeadlines(listener, category, null);
    }
}