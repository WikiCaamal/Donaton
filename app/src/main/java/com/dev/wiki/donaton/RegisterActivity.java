package com.dev.wiki.donaton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dev.wiki.donaton.Dao.DaoPerson;
import com.dev.wiki.donaton.Models.Person;

public class RegisterActivity extends AppCompatActivity {

    private EditText etName, etLastName, etUser, etEmail, etPassword, etPasswordConfirm;
    private String name, lastName, user, email, password, passwordConfirm;
    DaoPerson daoPerson;
    Person person;

    private void initComponents(){
        etName = findViewById(R.id.etName);
        etLastName = findViewById(R.id.etLastname);
        etUser = findViewById(R.id.etUser);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etPasswordConfirm = findViewById(R.id.etPasswordConfirm);
        daoPerson = new DaoPerson(getApplicationContext());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initComponents();
    }

    public void registerNewUser(View view){
        if (VericarCampos()){
            person = new Person(name,lastName,user,email,password);
            if (daoPerson.insert(person)) {
                Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Algo Salio mal", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean VericarCampos(){
        name = etName.getText().toString().trim();
        lastName = etLastName.getText().toString().trim();
        user = etUser.getText().toString().trim();
        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString();
        passwordConfirm = etPasswordConfirm.getText().toString();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(lastName) || TextUtils.isEmpty(user) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(passwordConfirm)){
            Toast.makeText(this, "Verifique los campos", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            if (password.equals(passwordConfirm)){
                return true;
            }
            else {
                Toast.makeText(this, "Las contraseñas no son iguales", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
    }

    public void cancel(View view){
        finish();
    }
}
