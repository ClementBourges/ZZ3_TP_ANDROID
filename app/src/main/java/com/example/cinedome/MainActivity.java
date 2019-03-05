package com.example.cinedome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.example.cinedome.adapter.*;
import android.util.Log;
import com.example.cinedome.model.Cinema;
import com.example.cinedome.model.Horaires;
import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends Activity implements MovieAdapter.OnContactClickedListener {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(false);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        List<Horaires> horaires = new ArrayList<Horaires>();
        ApiHelper.getInstance().getCinemaApi().getCinema().enqueue(new Callback<Cinema>() {
            @Override
            public void onResponse(Call<Cinema> call, Response<Cinema> response) {
                for (Horaires o : response.body().movieShowtimes) {
                    horaires.add(o);
                }
                mAdapter = new MovieAdapter(horaires, MainActivity.this::onContactClicked);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<Cinema> call, Throwable t) {
                Log.d("Appel", "erreur");
            }
        });
        // specify an adapter (see also next example)

    }

    @Override
    public void onContactClicked(Horaires movie) {
        // We want an app that display content
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        // That type of content (a contact)
        intent.putExtra("movie", movie); //second param is Serializable
        startActivity(intent);
    }

}




