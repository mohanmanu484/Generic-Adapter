package com.example.mohang.genericadapterexample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mohang on 11/7/17.
 */

public class ExampleActivity extends AppCompatActivity {

    public static final String FRAGMENT_TYPE="fragment_type";

    public static final int SIMPLE_EXAMPLE = 0;
    public static final int MULTIPLE_VIEW_TYPE=1;
    public static final int HANDLE_ONCLICK=2;
    public static final int GRID_ADAPTER=3;
    public static final int CUSTUM_ON_CLICK=4;
    public static final int FETCH_DATA_FROM_HANDLER=5;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);


        int fragmentType = getIntent().getExtras().getInt(FRAGMENT_TYPE,0);

        FragmentManager fragmentManager=getFragmentManager();
        Fragment fragment=fragmentManager.findFragmentById(R.id.container);


        if(fragment==null){
            fragment=getFragment(fragmentType);
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.container,fragment).commit();
        }
    }

    public Fragment getFragment(int type){

        Fragment fragment;

        switch (type){

            case SIMPLE_EXAMPLE:fragment=new SingleViewTypeFragment();
                break;
            case MULTIPLE_VIEW_TYPE:fragment=new MultipleViewTypeFragment();
                break;
            case HANDLE_ONCLICK:fragment=new ViewClickListenerFragment();
                break;
            case GRID_ADAPTER:fragment=new GridAdapterFragment();
                break;
            case CUSTUM_ON_CLICK:fragment=new ActionHandlerFragment();
                break;
            case FETCH_DATA_FROM_HANDLER:fragment=new DataFetchFragment();
                break;

            default:fragment=new SingleViewTypeFragment();
        }
        return fragment;
    }
}
