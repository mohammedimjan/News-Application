package com.example.thesun;

import com.example.thesun.models.Headlines;

import java.util.List;

public interface fetchDataListener<NewsResponseAPI> {
    void onFetchData(List<Headlines> list, String message);
    void onError(String message);
}
