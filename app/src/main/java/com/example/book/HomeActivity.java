package com.example.book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.book.database.MyDataBase;
import com.example.book.entities.Book;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Bookadapter adap;
    List<Book> books = new ArrayList<>();
    Button home;
    Button search , fav;
    TextView option;
    MyDataBase db;
    SharedPreferences s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        home=findViewById(R.id.homebtn);
        search=findViewById(R.id.Serachbtn);
        fav=findViewById(R.id.favbtn);
        option=findViewById(R.id.textViewOptions);
        db = MyDataBase.getDatabase(this);
        books = db.bookDAO().Getallbook();
        recyclerView = findViewById(R.id.bookr);
        adap = new Bookadapter(books,this);
        recyclerView.setAdapter(adap);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
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