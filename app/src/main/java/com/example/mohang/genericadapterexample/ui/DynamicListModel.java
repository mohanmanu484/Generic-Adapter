package com.example.mohang.genericadapterexample.ui;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.example.mohang.genericadapterexample.R;
import com.example.mohang.genericadapterexample.model.Bus;
import com.example.mohang.genericadapterexample.model.Car;
import com.mohang.genericadapter.ActionHandler;
import com.mohang.genericadapter.ViewTypeHandler;

/**
 * Created by mohang on 16/7/17.
 */

public class DynamicListModel implements ActionHandler {


    public ObservableList<Object> dynamicList=new ObservableArrayList<>();

    public int carItemCount;
    public int busItemCount;

    public void onAddBusClick(){

        dynamicList.add(new Bus("bus item "+busItemCount++));

    }

    public void removeLastItem(){

        if(dynamicList.size()>0){
            dynamicList.remove(dynamicList.size()-1);
        }

    }

    public void removeFirstItem(){

        if(dynamicList.size()>0){
            dynamicList.remove(0);
        }

    }

    public void onAddCarClick(){
        dynamicList.add(new Car("car item "+carItemCount++));
    }

    public ViewTypeHandler viewTypeHandler=new ViewTypeHandler() {
        @Override
        public int getViewType(int pos, Object item) {

            if(item instanceof Car){
                return R.layout.adapter_dynamic_item_car;
            }
            return R.layout.adapter_dynamic_item_bus;
        }
    };

    public void onItemClick(View view,@NonNull String msg){

        Toast.makeText(view.getContext(), msg, Toast.LENGTH_SHORT).show();

    }


   // public void on



}
