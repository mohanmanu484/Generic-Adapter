package com.example.mohang.genericadapterexample.ui;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohang.genericadapterexample.GradesViewModel;
import com.example.mohang.genericadapterexample.R;
import com.example.mohang.genericadapterexample.databinding.FragmentHandleViewStatesBinding;

/**
 * Created by mohang on 16/7/17.
 */

public class HandleViewStatesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        FragmentHandleViewStatesBinding fragmentHandleViewStatesBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_handle_view_states, container, false);
        fragmentHandleViewStatesBinding.setModel(new GradesViewModel());
        return fragmentHandleViewStatesBinding.getRoot();
    }

}
