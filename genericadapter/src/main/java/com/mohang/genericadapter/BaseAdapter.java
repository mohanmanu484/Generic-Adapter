package com.mohang.genericadapter;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by mohang on 3/7/17.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public abstract void updateItems(List<T> listItems);
    public abstract void calculateDiff(List<T> data);
    
}
