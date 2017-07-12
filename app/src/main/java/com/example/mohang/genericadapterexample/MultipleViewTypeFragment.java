package com.example.mohang.genericadapterexample;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohang.genericadapterexample.databinding.FragmentMultipleViewTypeBinding;
import com.example.mohang.genericadapterexample.model.Car;
import com.mohang.genericadapter.ViewTypeHandler;

/**
 * Created by mohang on 11/7/17.
 */

public class MultipleViewTypeFragment extends Fragment {


    public ObservableList<Object> observableList=new ObservableArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        FragmentMultipleViewTypeBinding fragmentMultipleViewTypeBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_multiple_view_type,container,false);
        fragmentMultipleViewTypeBinding.setList(observableList);
        fragmentMultipleViewTypeBinding.setViewTypeHandler(viewTypeHandler);
        observableList.addAll(DataSource.getMultiViewTypeData());

        return fragmentMultipleViewTypeBinding.getRoot();
    }

    ViewTypeHandler viewTypeHandler=new ViewTypeHandler() {
        @Override
        public int getViewType(int pos, Object item) {
            if(item instanceof Car){
                return R.layout.adapter_car_view_type;
            }
            return R.layout.adapter_bus_view_type;
        }
    };
}
