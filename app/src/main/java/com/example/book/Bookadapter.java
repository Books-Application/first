package com.example.book;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book.database.MyDataBase;
import com.example.book.entities.Book;

import java.util.List;

public class Bookadapter extends RecyclerView.Adapter<Bookadapter.MyViewHolder> {

    resultFragment resultFragment ;
    List<Book> books;
    Context context;
    MyDataBase db;
    public Bookadapter(List<Book> books, Context context)
    {
        this.books = books;
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itembook,parent,false);
        Context context = view.getContext();
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Book b =books.get(position) ;
        holder.bookimage.setImageResource(R.drawable.book);
        holder.bookname.setText(b.getNom());
        holder.auteurname.setText(b.getAuteur());
        holder.buttonViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creating a popup menu
                PopupMenu popup = new PopupMenu(context, holder.buttonViewOption);
                //inflating menu from xml resource
                popup.inflate(R.menu.pop_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {


                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.menu1) {
                            Book b =books.get(position) ;
                            b.setFav(1);
                            db = MyDataBase.getDatabase(context);
                            db.bookDAO().updatebook(b);

                            System.out.println( b.getAuteur());
                        }
                        return false;
                    }
                });
                //displaying the popup
                popup.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView bookimage;
        TextView bookname;
        TextView auteurname;
        TextView buttonViewOption;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bookimage=itemView.findViewById(R.id.bookimage);
            bookname=itemView.findViewById(R.id.bookname);
            auteurname=itemView.findViewById(R.id.auteurname);
            buttonViewOption =itemView.findViewById(R.id.textViewOptions);

        }
    }
}
