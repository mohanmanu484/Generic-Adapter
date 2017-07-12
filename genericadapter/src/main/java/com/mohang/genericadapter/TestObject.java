package com.mohang.genericadapter;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by mohang on 10/7/17.
 */

public class TestObject extends BaseObservable{

    public String name;


    public TestObject(String name) {
        this.name = name;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public void setName(String name) {
        this.name = name;
    }
}
