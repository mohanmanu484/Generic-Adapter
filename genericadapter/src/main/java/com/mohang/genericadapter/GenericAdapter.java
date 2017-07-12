package com.mohang.genericadapter;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohang on 3/7/17.
 */

public class GenericAdapter<T> extends BaseAdapter {

    private List<T> listItems = new ArrayList<>();
    private int layout;
    private ViewTypeHandler viewTypeHandler;
    private ActionHandler actionHandler;
    private ViewListener viewListener;


    public RecyclerConfiguration recyclerConfiguration;


    @Override
    public void updateItems(List listItems) {
        this.listItems = listItems;

    }

    @Override
    public void calculateDiff(List data) {

        DiffCallBack diffCallBack1 = new DiffCallBack(listItems, data);
        List<T> newList = new ArrayList<>(data);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallBack1);
        listItems = newList;
        diffResult.dispatchUpdatesTo(this);
    }


    public void setViewListener(ViewListener viewListener) {
        this.viewListener = viewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GenericViewHolder<>(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false), viewListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        GenericViewHolder<T> genericViewHolder = (GenericViewHolder<T>) holder;
        genericViewHolder.setItem(listItems.get(position), position, actionHandler);
        setListeners(genericViewHolder);

    }

    private void setListeners(final GenericViewHolder viewHolder) {


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewListener != null) {
                    viewListener.onClick(view, viewHolder.getAdapterPosition(), listItems.get(viewHolder.getAdapterPosition()));
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }


    @Override
    public int getItemViewType(int position) {
        return viewTypeHandler == null ? layout : viewTypeHandler.getViewType(position, listItems.get(position));
    }

    public static class GenericViewHolder<T> extends RecyclerView.ViewHolder {

        private ViewDataBinding viewDataBinding;
        private ViewListener viewListener;

        public GenericViewHolder(ViewDataBinding viewDataBinding) {
            this(viewDataBinding, null);
        }

        public GenericViewHolder(final ViewDataBinding viewDataBinding, final ViewListener viewListener) {
            super(viewDataBinding.getRoot());
            this.viewDataBinding = viewDataBinding;
            this.viewListener = viewListener;
        }

        public void setItem(T item, int pos, ActionHandler actionHandler) {

            ObservableField<T> observableField=new ObservableField<>();

            viewDataBinding.setVariable(com.mohang.genericadapter.BR.item, item);
            viewDataBinding.setVariable(com.mohang.genericadapter.BR.pos, pos);
            viewDataBinding.setVariable(com.mohang.genericadapter.BR.actionHandler, actionHandler);

            viewDataBinding.executePendingBindings();
        }
    }


    ///////////////////////////////////////////

    private GenericAdapter(int layout, List<T> listItems, ActionHandler actionHandler, ViewListener viewListener, RecyclerConfiguration recyclerConfiguration) {
        this.listItems = listItems;
        this.layout = layout;
        this.actionHandler = actionHandler;
        this.recyclerConfiguration=recyclerConfiguration;
        this.viewListener=viewListener;
    }

    private GenericAdapter(ViewTypeHandler viewTypeHandler, List<T> listItems, ActionHandler actionHandler, ViewListener viewListener, RecyclerConfiguration recyclerConfiguration) {
        this.actionHandler = actionHandler;
        this.listItems = listItems;
        this.viewTypeHandler = viewTypeHandler;
        this.recyclerConfiguration=recyclerConfiguration;
        this.viewListener=viewListener;
    }



    public void intoList(RecyclerView recyclerView){

        RecyclerConfiguration recyclerConfiguration=this.recyclerConfiguration;
        if(recyclerConfiguration==null){
            recyclerConfiguration=new RecyclerConfigurationImpl(recyclerView.getContext());
        }

        recyclerView.setHasFixedSize(recyclerConfiguration.hasFixedSize());
        recyclerView.setLayoutManager(recyclerConfiguration.layoutManager() );
        recyclerView.setItemAnimator( recyclerConfiguration.itemAnimator());
        if(recyclerConfiguration.itemDecoration()!=null){
            recyclerView.addItemDecoration(recyclerConfiguration.itemDecoration());
        }
        recyclerView.setAdapter(this);
        updateItems(new ArrayList(listItems));



    }



    //////////////////////////////////


    public static class Builder<T> {

        private List<T> list;
        private ActionHandler actionHandler;
        private ViewTypeHandler viewTypeHandler;
        private ViewListener viewListener;
        private Integer layoutRes;
        private RecyclerConfiguration recyclerConfiguration;


        public Builder(List<T> list) {
            this.list = list;
        }

        public Builder withLayoutRes( Integer layoutRes) {
            this.layoutRes = layoutRes;
            return this;
        }


        public Builder withViewListener(ViewListener viewListener) {
            this.viewListener = viewListener;
            return this;
        }

        public Builder withViewTypeHandler(ViewTypeHandler viewTypeHandler) {
            this.viewTypeHandler = viewTypeHandler;
            return this;
        }

        public Builder withActionHandler(ActionHandler actionHandler) {
            this.actionHandler = actionHandler;
            return this;
        }

        public Builder withRecyclerConfig(RecyclerConfiguration recyclerConfig){
            this.recyclerConfiguration=recyclerConfig;
            return this;
        }

        public GenericAdapter<T> build() {

            if (layoutRes == null && viewTypeHandler == null) {
                throw new IllegalArgumentException("need to provide layout resource or viewType actionHandler for the adapter");
            }

            if (viewTypeHandler == null) {
                return new GenericAdapter<T>(layoutRes, list, actionHandler,viewListener,recyclerConfiguration);
            }

            return new GenericAdapter<T>(viewTypeHandler, list, actionHandler,viewListener,recyclerConfiguration);
        }




    }


}
