package com.example.book.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.book.dao.BookDAO;
import com.example.book.dao.UserDAO;
import com.example.book.entities.Book;
import com.example.book.entities.User;

@Database(entities = {Book.class , User.class} ,version = 1 , exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {
    private static MyDataBase instance;

    public abstract BookDAO bookDAO();
    public abstract UserDAO userDAO();

    public static MyDataBase getDatabase(Context context)
    {
        if(instance ==null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),MyDataBase.class, "my_db")
                   .allowMainThreadQueries()
                    .build();

        }
        return instance;
    }
}
