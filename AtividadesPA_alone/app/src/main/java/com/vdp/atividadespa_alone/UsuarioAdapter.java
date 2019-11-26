package com.vdp.atividadespa_alone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UsuarioAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Usuario> usuarios;
    private UsuarioDAO userDAO;

    public UsuarioAdapter(Context context) {
        this.context = context;
        userDAO = new UsuarioDAO(context);
        this.usuarios = userDAO.buscaUsuarios();
    }

    public static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        public EditText nome;
        public EditText email;
        public EditText senha;

        public UsuarioViewHolder(View view) {
            super(view);
            this.nome = view.findViewById(R.id.nome);
            this.email = view.findViewById(R.id.email);
            this.senha = view.findViewById(R.id.senha);
        }
    }

    public UsuarioAdapter() {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //Inflando o layout_item dentro de um objeto View
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_usuario, viewGroup, false);
        //Acessando a nossa classe do ViewHolder e atribuindo o objeto View ao seu construtor
        UsuarioViewHolder exemploVH = new UsuarioViewHolder(view);

        return exemploVH;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {

        UsuarioViewHolder exemploVH  = (UsuarioViewHolder) viewHolder;

        exemploVH.nome.setText(usuarios.get(i).getUser());
        exemploVH.email.setText(usuarios.get(i).getEmail());
        exemploVH.senha.setText(usuarios.get(i).getSenha());
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }
}