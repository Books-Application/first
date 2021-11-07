package com.example.book;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {
    Button home;
    Button search , fav;
    TextView option;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        home=findViewById(R.id.homebtn);
        search=findViewById(R.id.Serachbtn);
        fav=findViewById(R.id.favbtn);
        option=findViewById(R.id.textViewOptions);

        getSupportFragmentManager().beginTransaction().replace(R.id.holder,filterFragment.newInstance()).commit();
        search.setOnClickListener(view -> {


            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);

        });
        fav.setOnClickListener(view -> {


            Intent intent = new Intent(this, FavActivity.class);
            startActivity(intent);

        });
        home.setOnClickListener(view -> {


            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);

        });
    }
}