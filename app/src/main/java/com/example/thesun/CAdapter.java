package com.example.thesun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thesun.models.Headlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private Context context;
    private List<Headlines> headlines;
    private SelectPageListner listner;

    public CAdapter(Context context, List<Headlines> headlines, SelectPageListner listner) {
        this.context = context;
        this.headlines = headlines;
        this.listner = listner;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.news_headline_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.newsTitle.setText(headlines.get(position).getTitle());
        holder.newsSource.setText(headlines.get(position).getSource().getName());

        if (headlines.get(position).getUrlToImage()!=null){
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.newsImage);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.NewsClicked(headlines.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
