package com.dev.wiki.donaton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private EditText etName, etLastName, etUser, etEmail, etPassword, etPasswordConfirm;

    private void initComponents(){
        etName = findViewById(R.id.etName);
        etLastName = findViewById(R.id.etLastname);
        etUser = findViewById(R.id.etUser);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etPasswordConfirm = findViewById(R.id.etPasswordConfirm);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initComponents();
    }

    public void registerNewUser(){

    }

    public void cancel(){

    }
}
