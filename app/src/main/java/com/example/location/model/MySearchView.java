package com.example.location.model;

import android.content.Context;
import android.widget.CursorAdapter;
import android.widget.SearchView;

/**
 * Created by Administrator on 2016/4/5.
 */
public class MySearchView extends SearchView {
    public MySearchView(Context context) {
        super(context);
    }
    @Override
    public void setSuggestionsAdapter(CursorAdapter adapter) {
        super.setSuggestionsAdapter(adapter);

    }
    @Override
    public CursorAdapter getSuggestionsAdapter() {
        return null;
    }
}
