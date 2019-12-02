package com.vdp.atividadespa_alone.API;


import com.vdp.atividadespa_alone.Usuario;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Server {
    @POST("/login")
    Call<Usuario> login(@Body Usuario usuario);

    @GET("/existEmailORNome/{nome}/{email}")
    Call<String> existEmailORNome(@Path("nome") String nome, @Path("email") String email);

    @POST("/cadastrar")
    Call<String> cadastrar(@Body Usuario usuario);

    @GET("/usuario/{id}")
    Call<Usuario> usuarioById(@Path("id") int id);

    @GET("/usuarios")
    Call<ArrayList<Usuario>> usuarios();

    @PUT("/usuario/{id}/nome/{nome}")
    Call<List<Usuario>> atualizaNome(@Path("id") int id, @Path("nome") String nome);

    @PUT("/usuario/{id}/email/{email}")
    Call<Boolean> atualizaEmail(@Path("id") int id, @Path("email") String email);

    @PUT("/usuario/{id}/senha/{senha}")
    Call<Boolean> atualizaSenha(@Path("id") int id, @Path("senha") String senha);

}
