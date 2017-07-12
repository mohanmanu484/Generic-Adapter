package com.example.mohang.genericadapterexample;

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

import com.example.mohang.genericadapterexample.databinding.FragmentDataFetchExampleBinding;
import com.example.mohang.genericadapterexample.model.Car;
import com.mohang.genericadapter.ActionHandler;
import com.mohang.genericadapter.RecyclerConfiguration;
import com.mohang.genericadapter.ViewTypeHandler;

/**
 * Created by mohang on 12/7/17.
 */

public class DataFetchFragment extends Fragment implements ActionHandler {

    public ObservableList<Car> observableList=new ObservableArrayList<>();



    ViewTypeHandler viewTypeHandler=new ViewTypeHandler() {
        @Override
        public int getViewType(int pos, Object item) {
            return R.layout.adapter_handler_data_fetch_example;
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        FragmentDataFetchExampleBinding fah=DataBindingUtil.inflate(inflater,R.layout.fragment_data_fetch_example,container,false);
        fah.setList(observableList);
        fah.setRecyclerConfig(recyclerConfiguration);
        fah.setViewTypeHandler(viewTypeHandler);
        fah.setActionHandler(this);

        observableList.addAll(DataSource.getCarItems());


        return fah.getRoot();
    }

    public void onCarImageItemClick(Car car, int pos){

        Toast.makeText(getActivity(), "Car's image  item clicked @ pos "+pos+" ="+car.getName(), Toast.LENGTH_SHORT).show();

    }

    public void onCarTextItemClick(View v,Car car,int pos){

        Toast.makeText(v.getContext(), "car's text item clicked @ pos "+pos+" ="+car.getName(), Toast.LENGTH_SHORT).show();
    }

    public String convertToUpperCase(String data){

        return "Appended String "+data.toUpperCase();

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
