package com.example.book.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.book.entities.Book;
import com.example.book.entities.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void AddUser(User user);
    @Query("SELECT * FROM table_User")
    List<User> GetallUsers();
}
