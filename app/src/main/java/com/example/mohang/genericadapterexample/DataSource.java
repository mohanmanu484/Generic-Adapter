package com.example.mohang.genericadapterexample;

import com.example.mohang.genericadapterexample.model.Bus;
import com.example.mohang.genericadapterexample.model.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohang on 11/7/17.
 */

public class DataSource {

    public static List<String> getListOfNUmbers(){

        List<String> list=new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");
        list.add("ten");
        return list;
    }


    public static List<Object> getMultiViewTypeData(){
        List<Object> list=new ArrayList<>();
        list.add(new Bus("volvo"));
        list.add(new Car("benz car"));
        list.add(new Bus("Bus 2"));
        list.add(new Car("mecedez"));


        return list;

    }


    public static List<Car> getCarItems() {
        List<Car> list=new ArrayList<>();
        list.add(new Car("benz"));
        list.add(new Car("mercedez"));
        list.add(new Car("maruti"));
        list.add(new Car("lamborgini"));
        return list;
    }
}
