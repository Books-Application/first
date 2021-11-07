package com.example.book.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.book.entities.Book;

import java.util.List;

@Dao
public interface BookDAO {
    @Insert
    void AddBook(Book book);
    @Query("SELECT * FROM table_Book")
    List<Book> Getallbook();
    @Update
    void updatebook(Book book);


}
