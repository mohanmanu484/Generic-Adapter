package com.mohang.genericadapter;

import android.support.v7.widget.RecyclerView;

/**
 * Created by mohang on 3/7/17.
 */

public interface RecyclerConfiguration {


    RecyclerView.LayoutManager layoutManager();

    boolean  hasFixedSize();

    RecyclerView.ItemDecoration itemDecoration();

     RecyclerView.ItemAnimator itemAnimator();
}
