package com.example.recyclerview2.FirstFramgent;

import android.widget.ImageView;

public class Item_model {
 String name, number;
     int imageId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getImageId() {
        return imageId;
    }

    public Item_model(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Item_model(String name, String number, int imageId) {
        this.name = name;
        this.number = number;
        this.imageId = imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}

