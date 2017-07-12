package com.example.mohang.genericadapterexample;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by mohang on 12/7/17.
 */

public class LinearLayoutItemDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        int pos=parent.getChildAdapterPosition(view);
        if(pos==0 ){
            outRect.top=16;
        }
        outRect.left=16;
        outRect.right=16;
        outRect.bottom=16;
    }
}
