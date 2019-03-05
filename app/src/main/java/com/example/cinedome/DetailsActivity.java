package com.example.cinedome;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.cinedome.model.Horaires;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends Activity {

    private Horaires movie;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_movie);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            movie = (Horaires) getIntent().getSerializableExtra("movie"); //Obtaining data
        }

        TextView textView = findViewById(R.id.textView5);
        textView.setText(movie.onShow.movie.title);
        TextView textView2 = findViewById(R.id.textView6);
        textView2.setText(movie.onShow.movie.genre.get(0).name);
        ImageView imageView = findViewById(R.id.image);
        Picasso.get().load(movie.onShow.movie.poster.href).into(imageView);

        Button clickButton = (Button) findViewById(R.id.button);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(movie.onShow.movie.trailer.href != null) {
                    Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(movie.onShow.movie.trailer.href));
                    startActivity(webIntent);
                }
            }
        });
    }
}
