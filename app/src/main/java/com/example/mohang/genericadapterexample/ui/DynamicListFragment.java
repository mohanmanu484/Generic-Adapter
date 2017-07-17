package com.example.mohang.genericadapterexample.ui;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohang.genericadapterexample.R;
import com.example.mohang.genericadapterexample.databinding.FragmentDynamicListBinding;

/**
 * Created by mohang on 16/7/17.
 */

public class DynamicListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        FragmentDynamicListBinding fragmentDynamicListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dynamic_list, container, false);
        fragmentDynamicListBinding.setModel(new DynamicListModel());
        return fragmentDynamicListBinding.getRoot();
    }

}
