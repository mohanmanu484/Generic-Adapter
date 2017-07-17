package com.example.mohang.genericadapterexample;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.example.mohang.genericadapterexample.model.Grades;
import com.example.mohang.genericadapterexample.model.SomeObject;
import com.mohang.genericadapter.ActionHandler;

/**
 * Created by mohang on 17/7/17.
 */

public class GradesViewModel implements ActionHandler {


    public ObservableList<SomeObject> observableList=new ObservableArrayList<>();

    public GradesViewModel() {
        addSomeData();
    }

    public void addSomeData(){

        for (int i = 0; i < 15; i++) {

            int x=i%3;

            if(x==0){
                observableList.add(new SomeObject(Grades.FIRST));
            }else if(x==1){
                observableList.add(new SomeObject(Grades.SECOND));
            }else {
                observableList.add(new SomeObject(Grades.THIRD));
            }

        }


    }



    public void onGradeSelect(int pos,Grades grades){
        observableList.get(pos).setSelectedGrade(grades);

    }


}
