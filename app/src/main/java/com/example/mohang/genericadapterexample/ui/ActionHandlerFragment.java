package com.example.mohang.genericadapterexample.ui;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mohang.genericadapterexample.DataSource;
import com.example.mohang.genericadapterexample.LinearLayoutItemDecoration;
import com.example.mohang.genericadapterexample.R;
import com.example.mohang.genericadapterexample.databinding.FragmentActionHandleExampleBinding;
import com.example.mohang.genericadapterexample.model.Bus;
import com.example.mohang.genericadapterexample.model.Car;
import com.mohang.genericadapter.ActionHandler;
import com.mohang.genericadapter.RecyclerConfiguration;
import com.mohang.genericadapter.ViewTypeHandler;

/**
 * Created by mohang on 12/7/17.
 */

public class ActionHandlerFragment extends Fragment implements ActionHandler {

    public ObservableList<Object> observableList=new ObservableArrayList<>();

    ViewTypeHandler viewTypeHandler=new ViewTypeHandler() {
        @Override
        public int getViewType(int pos, Object item) {
            if(item instanceof Car){
                return R.layout.adapter_handler_car_type_example;
            }
            return R.layout.adapter_handler_bus_type_example;
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        FragmentActionHandleExampleBinding fah=DataBindingUtil.inflate(inflater,R.layout.fragment_action_handle_example,container,false);
        fah.setList(observableList);
        fah.setRecyclerConfig(recyclerConfiguration);
        fah.setViewTypeHandler(viewTypeHandler);
        fah.setActionHandler(this);

        observableList.addAll(DataSource.getMultiViewTypeData());


        return fah.getRoot();
    }

    public void onCarImageItemClick(Car car, int pos){

        Toast.makeText(getActivity(), "Car's image  item clicked @ pos "+pos+" ="+car.getName(), Toast.LENGTH_SHORT).show();

    }

    public void onCarTextItemClick(View v,Car car,int pos){

        Toast.makeText(v.getContext(), "car's text item clicked @ pos "+pos+" ="+car.getName(), Toast.LENGTH_SHORT).show();
    }

    public void onBusImageItemClick(Bus bus, int pos){

        Toast.makeText(getActivity(), "Bus's image  item clicked @ pos "+pos+" ="+bus.getName(), Toast.LENGTH_SHORT).show();

    }

    public void onBusTextItemClick(Bus bus,int pos){

        Toast.makeText(getActivity(), "Bus's text item clicked @ pos "+pos+" ="+bus.getName(), Toast.LENGTH_SHORT).show();
    }

    RecyclerConfiguration recyclerConfiguration=new RecyclerConfiguration() {
        @Override
        public RecyclerView.LayoutManager layoutManager() {
            return new LinearLayoutManager(getActivity());
        }

        @Override
        public boolean hasFixedSize() {
            return true;
        }

        @Override
        public RecyclerView.ItemDecoration itemDecoration() {
            return new LinearLayoutItemDecoration();
        }

        @Override
        public RecyclerView.ItemAnimator itemAnimator() {
            return new DefaultItemAnimator();
        }
    };
}
