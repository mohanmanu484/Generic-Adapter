package com.mohang.genericadapter;


import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohang on 3/7/17.
 */

public class BindingUtil {


    @BindingAdapter(value = {"genericLayout", "viewTypeHandler", "listItem", "recyclerConfiguration", "actionHandler", "viewListener"}, requireAll = false)
    public static  <T> void setAdapter(RecyclerView recyclerView, int genericLayout, ViewTypeHandler viewTypeHandler, List<T> items, RecyclerConfiguration recyclerConfiguration, ActionHandler actionHandler, ViewListener viewListener) {

        GenericAdapter<T> adapter = (GenericAdapter<T>) recyclerView.getAdapter();
        if (adapter == null) {

            adapter = new GenericAdapter.Builder(new ArrayList<T>(items))
                    .withActionHandler(actionHandler)
                    .withViewTypeHandler(viewTypeHandler)
                    .withViewListener(viewListener)
                    .withLayoutRes(genericLayout)
                    .withRecyclerConfig(recyclerConfiguration)
                    .build();
            adapter.intoList(recyclerView);

        } else {
            adapter.calculateDiff(items);
        }


    }

}




