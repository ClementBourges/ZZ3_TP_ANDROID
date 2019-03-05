package com.example.cinedome;
import android.util.Log;

import com.example.cinedome.model.Cinema;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CinemaApi {

    /**
     * Call a webservice with dynamic path
     * Exemple :
     * "https://api.myjson.com/bins/31245"
     * base url : https://api.myjson.com/
     * path : bins/{id}
     * where id = 31245
     * So the method will be called using getNews("31235");
     */

    @GET("pam/cine.json")
    Call<Cinema> getCinema();

    /**
     * Call a webservice with a static path
     */
    /*
    @GET("https://etudiants.openium.fr/pam/cine.json")
    Call<Cinema> getFile();
    */
}