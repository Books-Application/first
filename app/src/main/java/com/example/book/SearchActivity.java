package com.example.book;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class SearchActivity extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        btn = findViewById(R.id.button);
        getSupportFragmentManager().beginTransaction().replace(R.id.holder,filterFragment.newInstance()).commit();
    }
}