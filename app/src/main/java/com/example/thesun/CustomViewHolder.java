package com.example.thesun;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder{

    TextView newsTitle, newsSource;
    ImageView newsImage;
    CardView cardView;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        newsTitle = itemView.findViewById(R.id.heading_text);
        newsSource = itemView.findViewById(R.id.source_text);
        newsImage = itemView.findViewById(R.id.image_news);
        cardView = itemView.findViewById(R.id.main_card);
    }
}
