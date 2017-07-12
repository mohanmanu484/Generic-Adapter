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

import com.example.mohang.genericadapterexample.databinding.FragmentSingleViewtypeBinding;

/**
 * Created by mohang on 11/7/17.
 */

public class SingleViewTypeFragment extends Fragment {

    public ObservableList<String> observableList=new ObservableArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        FragmentSingleViewtypeBinding fragmentSingleViewtypeBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_single_viewtype,container,false);
        fragmentSingleViewtypeBinding.setList(observableList);
        observableList.addAll(DataSource.getListOfNUmbers());
        return fragmentSingleViewtypeBinding.getRoot();
    }

}
