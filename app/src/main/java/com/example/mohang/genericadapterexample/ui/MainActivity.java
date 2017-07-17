package com.example.mohang.genericadapterexample.ui;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mohang.genericadapterexample.R;
import com.example.mohang.genericadapterexample.Utils;
import com.mohang.genericadapter.TestObject;

public class MainActivity extends AppCompatActivity {

    public ObservableList<TestObject> observableList=new ObservableArrayList<>();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void simpleExample(View view) {
        Utils.addFragment(this,ExampleActivity.SIMPLE_EXAMPLE);
    }

    public void multipleViewType(View view) {
        Utils.addFragment(this,ExampleActivity.MULTIPLE_VIEW_TYPE);
    }

    public void handleOnClickExample(View view) {
        Utils.addFragment(this,ExampleActivity.HANDLE_ONCLICK);
    }

    public void gridAdapterExample(View view) {
        Utils.addFragment(this,ExampleActivity.GRID_ADAPTER);
    }

    public void custumOnClickExample(View view) {
        Utils.addFragment(this,ExampleActivity.CUSTUM_ON_CLICK);
    }

    public void fetchDataFromHandlers(View view) {
        Utils.addFragment(this,ExampleActivity.FETCH_DATA_FROM_HANDLER);
    }

    public void dynamicListExample(View view) {
        Utils.addFragment(this,ExampleActivity.DYNAMIC_LIST_FRAGMENT);
    }
}
