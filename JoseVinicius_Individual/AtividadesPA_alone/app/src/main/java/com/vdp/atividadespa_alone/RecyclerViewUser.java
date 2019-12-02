package com.vdp.atividadespa_alone;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vdp.atividadespa_alone.API.Internet;
import com.vdp.atividadespa_alone.API.RetrofitClient;
import com.vdp.atividadespa_alone.API.Server;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewUser extends AppCompatActivity {
    RecyclerView rv;
    TextView noUsu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.recycleview);

        rv = findViewById(R.id.rv);
        noUsu = findViewById(R.id.txtNoUsu);

        if(Internet.isConnected(this)){
            UsuariosAPI(this, rv, noUsu);
        }else{
            UsuarioDAO userDAO = new UsuarioDAO(this);
            ArrayList<Usuario> usuarios = userDAO.buscaUsuarios();

            UsuarioAdapter adapter = new UsuarioAdapter(this, usuarios);

            RecyclerView.LayoutManager layout = new LinearLayoutManager(this);
            rv.setLayoutManager(layout);
            rv.setHasFixedSize(true);
            rv.setAdapter(adapter);

            if(usuarios.isEmpty()){
                noUsu.setVisibility(View.VISIBLE);
            }
        }

    }

    public void UsuariosAPI(final Context ct, final RecyclerView recyclerView, final TextView noUsu){
        Server service = RetrofitClient.getRetrofitInstance().create(Server.class);
        Call<ArrayList<Usuario>> call = service.usuarios();

        call.enqueue(new Callback<ArrayList<Usuario>>() {
            @Override
            public void onResponse(Call<ArrayList<Usuario>> call, Response<ArrayList<Usuario>> response) {
                ArrayList<Usuario> usuarios = new ArrayList<>();
                if(response.isSuccessful()){
                    usuarios = response.body();
                }else{
                    int teste = response.code();
                    String message = response.message();
                    String teste2 = response.toString();
                }
                final ArrayList<Usuario> usuariosFinal = usuarios;

                UsuarioDAO dao = new UsuarioDAO(ct);
                ArrayList<Usuario> usuariosBanco = dao.buscaUsuarios();

                if(!usuariosFinal.isEmpty()){
                    for (final Usuario usuario: usuariosFinal) {
                        if(!usuariosBanco.contains(usuario)){
                            usuariosBanco.add(usuario);
                            //dao.cadastrar(projeto);
                        }
                    }
                }

                if(usuariosBanco.isEmpty()){
                    noUsu.setText("Não existem usuariosFinal cadastrados");
                    noUsu.setVisibility(View.VISIBLE);
                }

                UsuarioAdapter adapter = new UsuarioAdapter(ct, usuariosBanco);
                RecyclerView.LayoutManager layout = new LinearLayoutManager(ct);
                recyclerView.setLayoutManager(layout);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Usuario>> call, Throwable t) {
                Log.e("OSFAILURE", "Erro em:" + t);
            }
        });
    }
}
