package com.vdp.atividadespa_alone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {
    private Context context;
    private ArrayList<Usuario> usuarios;
    private UsuarioDAO userDAO;

    public UsuarioAdapter(Context context) {
        this.context = context;
        userDAO = new UsuarioDAO(context);
        this.usuarios = userDAO.buscaUsuarios();
    }

    public static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        public TextView nome;
        public TextView email;
        public TextView senha;

        public UsuarioViewHolder(View view) {
            super(view);
            this.nome = view.findViewById(R.id.nometxt);
            this.email = view.findViewById(R.id.emailtxt);
            this.senha = view.findViewById(R.id.senhatxt);
        }
    }

    public UsuarioAdapter() {

    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //Inflando o layout_item dentro de um objeto View
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_usuario, viewGroup, false);
        //Acessando a nossa classe do ViewHolder e atribuindo o objeto View ao seu construtor
        UsuarioViewHolder exemploVH = new UsuarioViewHolder(view);

        return exemploVH;
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int i) {
        holder.nome.setText("Nome: "+usuarios.get(i).getUser());
        holder.email.setText("Email: "+usuarios.get(i).getEmail());
        holder.senha.setText("Senha: "+usuarios.get(i).getSenha());
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }
}