package com.example.Kraken_C2.API.GOContact;

import java.util.ArrayList;

public class DataReceiver {

    static ArrayList<DataReceiver> Data = new ArrayList<>();

    private String data;

    public DataReceiver() {}

    public DataReceiver(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}