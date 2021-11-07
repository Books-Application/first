package com.example.book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.book.database.MyDataBase;
import com.example.book.entities.User;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    EditText usernamel;
    EditText passwordl;
    Button Login;
    Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernamel = findViewById(R.id.usernamel);
        passwordl = findViewById(R.id.passwordl);
        Login = findViewById(R.id.Login);
        signin = findViewById(R.id.signup);
        Login.setOnClickListener(view -> {
            String username = usernamel.getText().toString();
            String password = passwordl.getText().toString();
            MyDataBase db = MyDataBase.getDatabase(this);
            List<User> u= db.userDAO().GetallUsers();
            int v =0;
            for(User r:u) {
                if ((r.getNom().equals(username)) && (r.getPassword().equals(password))) {
                    v=1;
                    Intent intent = new Intent(this, HomeActivity.class);
                    startActivity(intent);
                    break;
                }
            }
            if(v ==0) {
                Toast.makeText(this, " login failed please verify username and password ", Toast.LENGTH_SHORT).show();
            }
        });
        signin.setOnClickListener(view -> {


                Intent intent = new Intent(this, SiginActivity.class);
                startActivity(intent);

        });
    }
}