package com.example.nochiketa.hey;

/**
 * Created by Nochiketa on 8/2/2017.
 */
public class Country {
    private String name;
    private int icon;


    public Country (int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }
}
