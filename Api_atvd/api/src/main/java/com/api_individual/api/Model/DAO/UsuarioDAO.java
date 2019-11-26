package com.api_individual.api.Model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.api_individual.api.Model.*;

public class UsuarioDAO {

    public static boolean existEmail(String email){
        try {
            //BD.conectar();
            BD.ps = BD.conn.prepareStatement("Select count(*) from Usuario where email = ?");
            BD.ps.setString(1, email);
            BD.result = BD.ps.executeQuery();
            BD.result.first();
            if(BD.result.getInt("count(*)") != 0){
                return true;// tem outro usuário com o mesmo email
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao rodar existEmail: "+ex.getMessage());
        }finally{
            BD.closeResource(BD.conn, BD.ps, BD.result);
        }
        return false;// o email não foi cadastrado
    }

    public static boolean existNome(String nome){
        try {
            //BD.conectar();
            BD.ps = BD.conn.prepareStatement("Select count(*) from Usuario where nome = ?");
            BD.ps.setString(1, nome);
            BD.result = BD.ps.executeQuery();
            BD.result.first();
            if(BD.result.getInt("count(*)") != 0){
                return true;// tem outro usuário com o mesmo nome
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao rodar existNome: "+ex.getMessage());
        }finally{
            BD.closeResource(BD.conn, BD.ps, BD.result);
        }
        return false;// o nome não foi cadastrado
    }

    public static Usuario loginMatch(Usuario usuario) {
        try {
            //BD.conectar();
            BD.ps = BD.conn.prepareStatement("Select * from Usuario where nome = ? and senha = ?");
            BD.ps.setString(1, usuario.getNome());
            BD.ps.setString(2, usuario.getSenha());
            BD.result = BD.ps.executeQuery();
            if(BD.result.first()){
                Usuario user = new Usuario(Integer.parseInt(BD.result.getString("id")), 
                                            BD.result.getString("nome"), 
                                            BD.result.getString("email"),
                                            BD.result.getString("senha"));
                return user;// Nome e senha batem para o mesmo usuário
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao rodar loginMatch: "+ex.getMessage());
        }finally{
            BD.closeResource(BD.conn, BD.ps, BD.result);
        }
        return null;// Nome e senha não batem para nenhum usuário
    }
    
    public static boolean updateNome(int id, String newNome){
        try {
            //BD.conectar();
            if(UsuarioDAO.existNome(newNome) == false){
                int var = BD.decl.executeUpdate("update Usuario set nome = '"+newNome+"' where id = "+id);
                if(var == 0){
                    return false;
                }
            }else{
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao rodar updateNome: " +e.getMessage());
        }finally{
            BD.closeResource(BD.conn, BD.ps, BD.result);
        }
        return true;
    }
    
    public static boolean updateEmail(int id, String newEmail){
        try {
            //BD.conectar();
            if(UsuarioDAO.existEmail(newEmail) == false){
                int var = BD.decl.executeUpdate("update Usuario set email = '"+newEmail+"' where id = "+id);
                if(var == 0){
                    return false;
                }
            }else{
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao rodar updateEmail: " +e.getMessage());
        }finally{
            BD.closeResource(BD.conn, BD.ps, BD.result);
        }
        return true;
    }
    
    public static boolean updateSenha(int id, String newPass){
        try {
            //BD.conectar();
            int var = BD.decl.executeUpdate("update Usuario set senha = '"+newPass+"' where id = "+id);
            if(var == 0){
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao rodar updateSenha: " +e.getMessage());
        }finally{
            BD.closeResource(BD.conn, BD.ps, BD.result);
        }
        return true;
    }

    public static Usuario getUserById(int id){
        try {
            BD.ps = BD.conn.prepareStatement("Select * from Usuario where id = ?");
            BD.ps.setInt(1, id);
            BD.result = BD.ps.executeQuery();
            if(BD.result.first()){
                Usuario user = new Usuario(Integer.parseInt(BD.result.getString("id")), 
                                            BD.result.getString("nome"), 
                                            BD.result.getString("email"),
                                            BD.result.getString("senha"));
                return user;
            }
        } catch (Exception e) {
            System.out.println("Erro ao rodar getUserById: " +e.getMessage());
        }finally{
            BD.closeResource(BD.conn, BD.ps, BD.result);
        }
        return null;// Não existe esse usuário
    }

    public static boolean deleteUserById(int id){
        try {
            BD.ps = BD.conn.prepareStatement("Select * from Usuario where id = ?");
            BD.ps.setInt(1, id);
            BD.result = BD.ps.executeQuery();
            if(BD.result.first()){
                BD.ps = BD.conn.prepareStatement("delete from Usuario where id = ?");
                BD.ps.setInt(1, id);
                int var = BD.ps.executeUpdate();
                if(var == 0){
                    return false;// Não existe esse usuário
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao rodar deleteUserById: " +e.getMessage());
        }finally{
            BD.closeResource(BD.conn, BD.ps, BD.result);
        }
        return true;//apagou
    }

    public static boolean add(Usuario usuario){
        try {
            //BD.conectar();
            if(UsuarioDAO.existNome(usuario.getNome()) == false && UsuarioDAO.existEmail(usuario.getEmail()) == false){
                BD.ps = BD.conn.prepareStatement("insert into Usuario (Nome, email, senha) values (?, ?, ?)");
                BD.ps.setString(1, usuario.getNome());
                BD.ps.setString(2, usuario.getEmail());
                BD.ps.setString(3, usuario.getSenha());
                int var = BD.ps.executeUpdate();
                if(var == 0){
                    return false;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao rodar addC: " +ex.getMessage());
        }finally{
            BD.closeResource(BD.conn, BD.ps, BD.result);
        }
        return true;
    }

    public static ArrayList<Usuario> usuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario user;
        try {
            BD.ps = BD.conn.prepareStatement("select id, nome, email from Usuario");
            BD.result = BD.ps.executeQuery();
            if(BD.result.next()){
                do{
                    user = new Usuario();
                    user.setId(Integer.parseInt(BD.result.getString("id")));
                    user.setNome(BD.result.getString("nome"));
                    user.setEmail(BD.result.getString("email"));
                    usuarios.add(user);
                } while (BD.result.next());
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao rodar addC: " +ex.getMessage());
        }finally{
            BD.closeResource(BD.conn, BD.ps, BD.result);
        }
        return usuarios;
    }

}