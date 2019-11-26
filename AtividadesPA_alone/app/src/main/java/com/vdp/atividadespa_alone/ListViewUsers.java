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

public class ListViewUsers extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

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
            nomes.add(user.getUser());
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, nomes);
        listViewUsers.setAdapter(adapter);
        listViewUsers.setOnItemSelectedListener(this);

        cadastrar.setOnClickListener(this);
        /*try {
            ConnectionAPI.readJsonFromUrl("/usuarios");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void onClick(View view) {
        Intent i;
        if(view.getId() == cadastrar.getId()){
            i = new Intent(this, Cadastro.class);
            startActivity(i);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
