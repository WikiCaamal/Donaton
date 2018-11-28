package com.dev.wiki.donaton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dev.wiki.donaton.Dao.DaoLogin;

public class LoginActivity extends AppCompatActivity {
    private EditText etUser, etPassword;
    private Button btnSignIn;
    private String user, password;
    private DaoLogin daoLogin;

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
        daoLogin = new DaoLogin(getApplicationContext()); 
        user = etUser.getText().toString().trim();
        password = etPassword.getText().toString();
        if (validarCampos()){
            if (daoLogin.validUser(user,password)){
                Intent main = new Intent(this,MainActivity.class);
                startActivity(main);
            }
            else {
                Toast.makeText(this, "No existe el usuario", Toast.LENGTH_SHORT).show();
            }
        }
        
    }
    
    public boolean validarCampos(){
        if (TextUtils.isEmpty(user) || TextUtils.isEmpty(password)){
            Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }

    public void register(View view){
        Intent register = new Intent(getApplicationContext(),RegisterActivity.class);
        startActivity(register);
    }

}
