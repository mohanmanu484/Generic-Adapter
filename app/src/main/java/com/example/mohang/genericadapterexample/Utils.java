package com.example.mohang.genericadapterexample;

import android.content.Context;
import android.content.Intent;

import com.example.mohang.genericadapterexample.ui.ExampleActivity;

/**
 * Created by mohang on 12/7/17.
 */

public class Utils {

    public static void addFragment(Context context,int fragmentType){
        Intent intent=new Intent(context,ExampleActivity.class);
        intent.putExtra(ExampleActivity.FRAGMENT_TYPE,fragmentType);
        context.startActivity(intent);
    }



}
