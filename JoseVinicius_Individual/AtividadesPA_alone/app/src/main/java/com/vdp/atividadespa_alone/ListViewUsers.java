package com.vdp.atividadespa_alone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class ListViewUsers extends AppCompatActivity implements View.OnClickListener{

    ListView listViewUsers;
    Button cadastrar;
    UsuarioDAO user;
    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_list_view_users);
        listViewUsers = findViewById(R.id.listviewUsers);
        cadastrar = findViewById(R.id.cadastrarbtn);
        voltar = findViewById(R.id.back);
        user = new UsuarioDAO(this);

        ArrayList<String> nomes = new ArrayList<>();
        for (Usuario user: user.buscaUsuarios()) {
            nomes.add(user.getNome());
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, nomes);
        listViewUsers.setAdapter(adapter);

        cadastrar.setOnClickListener(this);
        voltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        if(view.getId() == cadastrar.getId()){
            i = new Intent(this, Cadastro.class);
            startActivity(i);
        }
        if(view.getId() == voltar.getId()){
            i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}
