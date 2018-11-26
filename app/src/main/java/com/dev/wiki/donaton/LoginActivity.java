package com.dev.wiki.donaton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText etUser, etPassword;
    private Button btnSignIn;
    private String user, password;

    private void initComponents(){
        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = findViewById(R.id.btn_singin);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponents();
    }

    public void signIn(View view){
        user = etUser.getText().toString().trim();
        password = etPassword.getText().toString();
        Toast.makeText(getApplicationContext(), "User: "+user+"Password: "+password,Toast.LENGTH_SHORT).show();
    }

    public void register(){
        Intent register = new Intent(getApplicationContext(),RegisterActivity.class);
        startActivity(register);
    }

}
