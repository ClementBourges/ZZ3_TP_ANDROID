package com.example.cinedome.model;

import java.io.Serializable;

public class Horaires implements Serializable {
    public OnShow onShow;
    public Horaires (OnShow o)
    {
        onShow=o;
    }
}
