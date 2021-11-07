package com.example.book;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.book.database.MyDataBase;
import com.example.book.entities.Book;
import java.util.ArrayList;
import java.util.List;

public class resultFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String rechercher,message;
    RecyclerView recyclerView;
    Bookadapter adap;
    List<Book> books = new ArrayList<>();
    MyDataBase db;
    


    public resultFragment() {
        // Required empty public constructor
    }


    public static resultFragment newInstance(String message, String s) {
        resultFragment fragment = new resultFragment();
        Bundle args = new Bundle();
        args.putString("ARG_PARAM1",message);
        args.putString("ARG_PARAM2",s);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            message = getArguments().getString("ARG_PARAM1");
            rechercher = getArguments().getString("ARG_PARAM2");
            System.out.println("filter "+message);
            System.out.println("resherch "+rechercher);



        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        Context context = view.getContext();
        db = MyDataBase.getDatabase(context);
        books = db.bookDAO().Getallbook();
        books = recherch(message,rechercher,books);
        recyclerView = view.findViewById(R.id.bookr);
        adap = new Bookadapter(books,context);
        recyclerView.setAdapter(adap);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL,false));
       return view ;
    }


    private List<Book> recherch(String m,String r,List<Book> books)
    {
        List<Book> bookr = new ArrayList<>();
        switch (m) {
            case "book name":
                   for (Book b :books)
                          {
                              if(b.getNom().equals(r))
                              {
                                  bookr.add(b);
                              }
                          }
                break;
            case "Author":
                for (Book b :books)
                {
                    if(b.getAuteur().equals(r))
                    {
                        bookr.add(b);
                    }
                }
                break;
            case "Category":
                for (Book b :books)
                {
                    if(b.getCategorie().equals(r))
                    {
                        bookr.add(b);
                    }
                }

                break;
        }
        return bookr;
    }
}