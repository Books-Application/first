package com.example.book;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book.entities.Book;

import java.util.List;

public class Bookadapter extends RecyclerView.Adapter<Bookadapter.MyViewHolder> {

    List<Book> books;
    Context context;
    public Bookadapter(List<Book> books, Context context)
    {
        this.books = books;
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itembook,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Book b =books.get(position) ;
        holder.bookimage.setImageResource(b.getImage());
        holder.bookname.setText(b.getNom());
        holder.auteurname.setText(b.getAuteur());

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView bookimage;
        TextView bookname;
        TextView auteurname;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bookimage=itemView.findViewById(R.id.bookimage);
            bookname=itemView.findViewById(R.id.bookname);
            auteurname=itemView.findViewById(R.id.auteurname);

        }
    }
}
