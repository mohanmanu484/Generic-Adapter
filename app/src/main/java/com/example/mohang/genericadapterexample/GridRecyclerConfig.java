package com.example.mohang.genericadapterexample;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mohang.genericadapter.RecyclerConfiguration;

/**
 * Created by mohang on 11/7/17.
 */

public class GridRecyclerConfig implements RecyclerConfiguration {

    private Context context;


    public GridRecyclerConfig(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.LayoutManager layoutManager() {
        return new GridLayoutManager(context,2);
    }

    @Override
    public boolean hasFixedSize() {
        return true;
    }

    @Override
    public RecyclerView.ItemDecoration itemDecoration() {
        return new MyItemDecoration();
    }

    @Override
    public RecyclerView.ItemAnimator itemAnimator() {
        return new DefaultItemAnimator();
    }
}
