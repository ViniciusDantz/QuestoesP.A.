package com.vdp.atividadespa_alone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Cadastro extends AppCompatActivity implements View.OnClickListener{

    EditText edt1;
    EditText edt2;
    EditText edt3;
    Button cadastrar;
    UsuarioDAO user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cadastro);
        edt1 = findViewById(R.id.nome);
        edt2 = findViewById(R.id.email);
        edt3 = findViewById(R.id.senha);
        cadastrar = findViewById(R.id.cadastrar);
        user = new UsuarioDAO(this);

        cadastrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        if(cadastrar.getId() == view.getId()){
            Usuario usuario = new Usuario();
            usuario.setUser(edt1.getText().toString());
            usuario.setEmail(edt2.getText().toString());
            usuario.setSenha(edt3.getText().toString());

            user.cadastrar(usuario);

            startActivity(i = new Intent(this, ListViewUsers.class));
        }
    }
}
