package com.zelenograd.android.helper.models;

import android.content.Intent;
import android.graphics.Color;

import java.util.Random;

/**
 * Created by _red_ on 01/09/2017.
 */

public class Product {
    private Long id;
    private int color;
    private String description;

    public Product(long id, String description) {
        Random rnd = new Random();
        this.color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
