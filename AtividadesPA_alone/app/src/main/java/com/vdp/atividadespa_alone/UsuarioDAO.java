package com.vdp.atividadespa_alone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class UsuarioDAO {

    private BD conexao;
    private SQLiteDatabase banco;

    public UsuarioDAO(Context context){
        conexao = new BD((context));
        banco = conexao.getWritableDatabase();
    }

    public void cadastrar(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put("user", usuario.getUser());
        values.put("senha", usuario.getSenha());
        values.put("email", usuario.getEmail());


        banco.insert("usuario", null, values);
    }

    public ArrayList<Usuario> buscaUsuarios(){
        ArrayList<Usuario> lista = new ArrayList<>();
        String[] colunas = new String[]{"id", "user", "senha", "email"};
        Cursor cursor = banco.query("usuario", colunas, null, null, null, null, "user ASC");
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                Usuario user = new Usuario();
                user.setId(cursor.getInt(0));
                user.setUser(cursor.getString(1));
                user.setSenha(cursor.getString(2));
                user.setEmail(cursor.getString(3));

                lista.add(user);
            }while(cursor.moveToNext());
        }
        return lista;

    }
}
