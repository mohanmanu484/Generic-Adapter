package com.example.mohang.genericadapterexample;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mohang.genericadapterexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public ObservableList<String> observableList=new ObservableArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setModel(this);
        observableList.add("mohan");
        observableList.add("anand");


    }
}
