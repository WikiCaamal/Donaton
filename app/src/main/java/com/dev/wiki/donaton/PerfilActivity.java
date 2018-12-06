package com.dev.wiki.donaton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dev.wiki.donaton.Dao.DaoLogin;
import com.dev.wiki.donaton.Dao.DaoPerson;
import com.dev.wiki.donaton.DataBase.Personas;
import com.dev.wiki.donaton.Models.Person;

public class PerfilActivity extends AppCompatActivity {

    //Variables
    private EditText etNombre,etApellido,etCorreo,etUsuario;
    DaoPerson daoPerson;
    private String name, lastName, user, email, password, passwordConfirm;
    private Person person;

    private void initComponents(){
        etNombre = findViewById(R.id.nombre);
        etApellido = findViewById(R.id.apellido);
        etUsuario = findViewById(R.id.ususario);
        etCorreo = findViewById(R.id.correo);
        daoPerson = new DaoPerson(this);
        person = new Person();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        initComponents();
        loadData();
    }

    public void loadData(){
        int id = getIntent().getExtras().getInt(Personas.COLUMN_ID);
        Person person = daoPerson.getById(id);
        this.person.setId(person.getId());
        etNombre.setText(person.getName());
        etApellido.setText(person.getLastName());
        etUsuario.setText(person.getUser());
        etCorreo.setText(person.getEmail());
        this.person.setPassword(person.getPassword());
    }

    public void update(View view){
        if (VericarCampos()){
            if (daoPerson.update(person)){
                Toast.makeText(this, "Registro actualizado", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "El registro no se pudo actualizar", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void close(View view){
        finish();
    }

    public boolean VericarCampos() {
        name = etNombre.getText().toString().trim();
        person.setName(name);
        lastName = etApellido.getText().toString().trim();
        person.setLastName(lastName);
        user = etUsuario.getText().toString().trim();
        person.setUser(user);
        email = etCorreo.getText().toString().trim();
        person.setEmail(email);
        password = person.getPassword();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(lastName) || TextUtils.isEmpty(user) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Verifique los campos", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}
