package com.example.cinedome.model;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable {
    public String title;
    public List<Genre> genre;
    public Poster poster;
    public Trailer trailer;
    public Movie(String s)
    {
        title=s;
    }
}
