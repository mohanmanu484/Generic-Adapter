package com.example.mohang.genericadapterexample.ui;

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

import com.example.mohang.genericadapterexample.DataSource;
import com.example.mohang.genericadapterexample.R;
import com.example.mohang.genericadapterexample.databinding.FragmentViewListenerBinding;
import com.mohang.genericadapter.ViewListener;

/**
 * Created by mohang on 11/7/17.
 */

public class ViewClickListenerFragment extends Fragment {

    public ObservableList observableList=new ObservableArrayList();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        FragmentViewListenerBinding fragmentSingleViewtypeBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_view_listener,container,false);
        fragmentSingleViewtypeBinding.setList(observableList);
        observableList.addAll(DataSource.getListOfNUmbers());
        fragmentSingleViewtypeBinding.setViewListener(viewListener);
        return fragmentSingleViewtypeBinding.getRoot();
    }

    public ViewListener viewListener=new ViewListener() {
        @Override
        public void onClick(View v, int pos, Object object) {

            Toast.makeText(getActivity(), "item @ pos "+pos+" is "+((String)object), Toast.LENGTH_SHORT).show();
        }
    };
}
