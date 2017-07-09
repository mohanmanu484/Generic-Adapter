package com.mohang.genericadapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;




/**
 * Created by mohang on 3/7/17.
 */

public class RecyclerConfigurationImpl implements RecyclerConfiguration {

    private Context context;
    public RecyclerConfigurationImpl(Context context) {
        this.context=context;
    }








    @Override
    public RecyclerView.LayoutManager layoutManager() {
        return new LinearLayoutManager(context);
    }

    @Override
    public boolean hasFixedSize() {
        return true;
    }

    @Nullable
    @Override
    public RecyclerView.ItemDecoration itemDecoration() {
        return null;
    }


    @Override
    public RecyclerView.ItemAnimator itemAnimator() {
        return new DefaultItemAnimator();
    }
}
