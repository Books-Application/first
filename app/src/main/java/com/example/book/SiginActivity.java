package com.example.book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.book.database.MyDataBase;
import com.example.book.entities.User;

public class SiginActivity extends AppCompatActivity {
    EditText usernamesi;
    EditText emailsi;
    EditText passwordsi;
    Button sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin);
        usernamesi = findViewById(R.id.usernameSI);
        emailsi = findViewById(R.id.emailSI);
        passwordsi = findViewById(R.id.passwordSI);
        sign_in = findViewById(R.id.signupBtn);

        sign_in.setOnClickListener(view -> {
            String username = usernamesi.getText().toString();
            String email = emailsi.getText().toString();
            String password = passwordsi.getText().toString();
            if (password.length()> 8) {
                MyDataBase db = MyDataBase.getDatabase(this);
                User u = new User(username, password, email);
                db.userDAO().AddUser(u);
                Toast.makeText(this, "sign up successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }else
             {
                 Toast.makeText(this, "sign up failed short password length ", Toast.LENGTH_SHORT).show();
            }


        });
    }
}