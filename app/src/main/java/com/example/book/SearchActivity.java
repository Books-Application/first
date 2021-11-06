package com.example.book;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class SearchActivity extends AppCompatActivity {
    Button home;
    Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        home=findViewById(R.id.homebtn);
        search=findViewById(R.id.Serachbtn);

        getSupportFragmentManager().beginTransaction().replace(R.id.holder,filterFragment.newInstance()).commit();
    }
}