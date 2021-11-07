package com.example.book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.book.database.MyDataBase;
import com.example.book.entities.Book;

import java.util.ArrayList;
import java.util.List;

public class FavActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Bookadapter adap;
    List<Book> books = new ArrayList<>();
    Button home;
    Button search , fav;
    TextView option;
    MyDataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        fav=findViewById(R.id.favbtn);
        home=findViewById(R.id.homebtn);
        search=findViewById(R.id.Serachbtn);
        db = MyDataBase.getDatabase(this);
        books = db.bookDAO().Getallbook();
        books = recherch(books);
        recyclerView = findViewById(R.id.bookr);
        option=findViewById(R.id.textViewOptions);
        adap = new Bookadapter(books,this);
        recyclerView.setAdapter(adap);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
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
    private List<Book> recherch(List<Book> books)
    {
        List<Book> bookr = new ArrayList<>();

                for (Book b :books)
                {
                    if(b.getFav() == 1)
                    {
                        bookr.add(b);
                    }
                }

        return bookr;
    }

}