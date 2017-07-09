package com.mohang.genericadapter;

import android.support.v7.util.DiffUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohang on 3/7/17.
 */

public  class DiffCallBack<E> extends DiffUtil.Callback {
    protected List<E> oldList = new ArrayList<>();
    protected List<E> newList = new ArrayList<>();

    public DiffCallBack(List<E> oldList, List<E> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    public DiffCallBack() {
    }

    void setData(List<E> oldList, List<E> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }



    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        E oldItem = oldList.get(oldItemPosition);
        E newItem = newList.get(newItemPosition);
        return oldItem.hashCode() == newItem.hashCode();
    }

/*

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Thing currentItem = current.get(oldItemPosition);
        Thing nextItem = next.get(newItemPosition);
        return currentItem.equals(nextItem);
    }*/

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        E currentItem = oldList.get(oldItemPosition);
        E nextItem = newList.get(newItemPosition);
        return currentItem.equals(nextItem);
    }
}