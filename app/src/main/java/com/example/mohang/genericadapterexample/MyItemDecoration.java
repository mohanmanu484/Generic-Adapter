package com.example.mohang.genericadapterexample;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by mohang on 12/7/17.
 */

public class MyItemDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        int pos=parent.getChildAdapterPosition(view);
        if(pos==0 || pos==1 ){
            outRect.top=16;
        }
        if((pos+1)%2==0){
            outRect.right=16;
            outRect.left=8;
        }else {
            outRect.left=16;
            outRect.right=8;
        }
        outRect.bottom=16;
    }
}
