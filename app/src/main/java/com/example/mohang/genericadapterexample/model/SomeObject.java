package com.example.mohang.genericadapterexample.model;

/**
 * Created by mohang on 17/7/17.
 */

public class SomeObject {

    public Grades selectedGrade;

    public SomeObject(Grades selectedGrade) {
        this.selectedGrade = selectedGrade;
    }

    public Grades getSelectedGrade() {
        return selectedGrade;
    }

    public void setSelectedGrade(Grades selectedGrade) {
        this.selectedGrade = selectedGrade;
    }
}
