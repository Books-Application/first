package com.example.book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.book.entities.Book;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Bookadapter adap;
    List<Book> books = new ArrayList<>();
    Button home;
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setbooks();
        home=findViewById(R.id.homebtn);
        search=findViewById(R.id.Serachbtn);

        recyclerView = findViewById(R.id.bookr);
        adap = new Bookadapter(books,this);
        recyclerView.setAdapter(adap);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        search.setOnClickListener(view -> {


            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);

        });
        home.setOnClickListener(view -> {


            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);

        });
    }
    private void setbooks()
        {
            books.add(new Book( "book","action",1.0,R.drawable.bg,"omar" ));
            books.add(new Book( "book","drama",2.0,R.drawable.bg,"wassim" ));
            books.add(new Book( "book","action",1.0,R.drawable.bg,"mahdi" ));
            books.add(new Book( "book4","drama",2.0,R.drawable.bg,"ahmed" ));
            books.add(new Book( "book5","action",1.0,R.drawable.bg,"firas" ));
            books.add(new Book( "book6","drama",2.0,R.drawable.bg,"salah" ));
            books.add(new Book( "book1","action",1.0,R.drawable.bg,"omar" ));
            books.add(new Book( "book2","drama",2.0,R.drawable.bg,"wassim" ));
            books.add(new Book( "book3","action",1.0,R.drawable.bg,"mahdi" ));
            books.add(new Book( "book4","drama",2.0,R.drawable.bg,"ahmed" ));
            books.add(new Book( "book5","action",1.0,R.drawable.bg,"firas" ));
            books.add(new Book( "book6","drama",2.0,R.drawable.bg,"salah" ));
        }


}