package com.example.cinedome.model;

import java.io.Serializable;

public class OnShow implements Serializable {
    public Movie movie;

    public OnShow(Movie m)
    {
        movie=m;
    }
}
