package com.example.mattias.assignment4;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by Mattias on 15-04-22.
 */
public class Book implements Serializable {
    String name;
    String radie;
    String medeltemp;
    String info;
    Drawable image;

    public Book(String name, String info, String radie, String medeltemp, Drawable image) {
        this.name = name;
        this.info = info;
        this.radie = radie;
        this.medeltemp = medeltemp;
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String isbn) {
        this.info = isbn;
    }

    public Drawable getImage() {
        return image;
    }

    public void setName(Drawable image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getMedeltemp() {
        return medeltemp;
    }

    public String getRadie() {
        return radie;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getSummary() {
        return "Radie: "+radie+"\n"+"Medeltemp: "+medeltemp;
    }
}
