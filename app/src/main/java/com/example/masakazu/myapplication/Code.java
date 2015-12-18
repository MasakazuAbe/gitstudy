package com.example.masakazu.myapplication;

/**
 * Created by Masakazu on 15/12/18.
 */
public enum Code {

    JPY("円"),
    USD("$");

    private String mUnit;

    private Code(String unit) {
        mUnit = unit;
    }

    public String getUnit() {
        return mUnit;
    }

}
