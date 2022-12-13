package com.example.thesun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thesun.models.Headlines;
import com.squareup.picasso.Picasso;

public class AllDetailsActivity extends AppCompatActivity {

    Headlines headlines;
    TextView newsHeading, newsAuthor, newsTime,newsDesc, newsContent;
    ImageView newsImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_details);

        newsHeading = findViewById(R.id.news_title__single);
        newsAuthor = findViewById(R.id.news_author_single);
        newsTime = findViewById(R.id.news_time_single);
        newsDesc = findViewById(R.id.news_description_single);
        newsContent = findViewById(R.id.news_content_single);
        newsImage = findViewById(R.id.news_image_single);

        headlines = (Headlines) getIntent().getSerializableExtra("data");

        newsHeading.setText(headlines.getTitle());
        newsAuthor.setText(headlines.getAuthor());
        newsTime.setText(headlines.getPublishedAt());
        newsDesc.setText(headlines.getDescription());
        newsContent.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(newsImage);
    }
}