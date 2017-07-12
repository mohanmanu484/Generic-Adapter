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
import android.widget.Toast;

import com.example.mohang.genericadapterexample.databinding.FragmentGridAdapterBinding;
import com.example.mohang.genericadapterexample.model.Bus;
import com.example.mohang.genericadapterexample.model.Car;
import com.mohang.genericadapter.RecyclerConfiguration;
import com.mohang.genericadapter.ViewListener;
import com.mohang.genericadapter.ViewTypeHandler;

/**
 * Created by mohang on 11/7/17.
 */

public class GridAdapterFragment extends Fragment {


    public ObservableList<Object> observableList=new ObservableArrayList<>();
    public RecyclerConfiguration recyclerConfiguration;

    ViewTypeHandler viewTypeHandler=new ViewTypeHandler() {
        @Override
        public int getViewType(int pos, Object item) {
            if(item instanceof Car){
                return R.layout.adapter_car_view_type;
            }
            return R.layout.adapter_bus_view_type;
        }
    };

    public ViewListener viewListener=new ViewListener() {
        @Override
        public void onClick(View v, int pos, Object object) {

            if(object instanceof Car) {
                Toast.makeText(getActivity(), "item @ pos " + pos + " is " + ((Car)object).getName(), Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getActivity(), "item @ pos " + pos + " is " +  ((Bus)object).getName(), Toast.LENGTH_SHORT).show();
            }
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        FragmentGridAdapterBinding fragmentSingleViewtypeBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_grid_adapter,container,false);
        recyclerConfiguration=new GridRecyclerConfig(container.getContext());
        fragmentSingleViewtypeBinding.setList(observableList);
        fragmentSingleViewtypeBinding.setViewTypeHandler(viewTypeHandler);
        fragmentSingleViewtypeBinding.setRecyclerConfig(recyclerConfiguration);
        fragmentSingleViewtypeBinding.setVariable(BR.viewListener,viewListener);
        observableList.addAll(DataSource.getMultiViewTypeData());
        return fragmentSingleViewtypeBinding.getRoot();
    }
}
