package com.api_individual.api.Controller;

import java.util.ArrayList;

import com.api_individual.api.Model.Usuario;
import com.api_individual.api.Model.DAO.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class Controller{

    public Controller() {
        BD.conectar();
        if(BD.conexao()){
            System.out.println("Conectado");
        }else{
            System.out.println("desconectado");
        }
    }

    @RequestMapping(path = "/")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }

    //--------------------------------------------------------------------------------------------------
    // Usuário
    //--------------------------------------------------------------------------------------------------

    @PostMapping(path = "/login")
    public Usuario login(@RequestBody Usuario usuario) {
        return UsuarioDAO.loginMatch(usuario);
    }

    @PostMapping(path = "/cadastrar")
    public boolean cadastrar(@RequestBody Usuario usuario) {
        return UsuarioDAO.add(usuario);
    }

    @GetMapping(path = "/usuario/{id}")
    public Usuario usuarioById(@PathVariable("id") int id) {
        return UsuarioDAO.getUserById(id);
    }

    @GetMapping(path = "/usuarios")
    public ArrayList<Usuario> usuarios() {
        return UsuarioDAO.usuarios();
    }

    @PutMapping(path = "/usuario/{id}/nome/{nome}")
    public boolean atualizaNome(@PathVariable("id") int id, @PathVariable("nome") String nome) {
        return UsuarioDAO.updateNome(id, nome);
    }

    @PutMapping(path = "/usuario/{id}/email/{email}")
    public boolean atualizaEmail(@PathVariable("id") int id, @PathVariable("email") String email) {
        return UsuarioDAO.updateEmail(id, email);
    }

    @PutMapping(path = "/usuario/{id}/senha/{senha}")
    public boolean atualizaSenha(@PathVariable("id") int id, @PathVariable("senha") String senha) {
        return UsuarioDAO.updateSenha(id, senha);
    }

    @DeleteMapping(path = "/deleteUser/{id}")
    public boolean deleteUser(@PathVariable("id") int id){
        return UsuarioDAO.deleteUserById(id);
    }
}