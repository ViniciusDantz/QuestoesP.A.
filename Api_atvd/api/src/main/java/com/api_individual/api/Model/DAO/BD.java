package com.api_individual.api.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BD {

    public static Connection conn = null;
    public static Statement decl = null;
    public static ResultSet result = null;
    public static PreparedStatement ps = null;

    public static void conectar(){
        String servidor = "jdbc:mysql://localhost:3306/Api_Android?useSSL=false&useTimezone=true&serverTimezone=GMT";
        String usuario = "root";
        String senha = "eit8wrailwiOl=";
        String driver = "com.mysql.jdbc.Driver";
        //CREATE USER 'vinic'@'localhost' IDENTIFIED WITH mysql_native_password BY 'senha'; Entrar no mysql-->administation-->User and Privileges-->vinic-->schema privileges-->all
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(servidor, usuario, senha);
            decl = (Statement) conn.createStatement();
        } catch (Exception e) {
            System.out.println("Erro: " +e.getMessage());
        }
    }

    public static boolean conexao(){
        if(BD.conn != null){
            return true;
        }
        return false;
    }
    
    public static void closeResource(Connection conn, PreparedStatement ps, ResultSet result){
         if(result != null){
            try {
                result.close();
            } catch (Exception e) {
            }
        }
        if(ps != null){
            try {
                ps.close();
            } catch (Exception e) {
            }
        }
        /*if(conn != null){
            try {
                conn.close();
            } catch (Exception e) {
            }
        }*/
    }
}