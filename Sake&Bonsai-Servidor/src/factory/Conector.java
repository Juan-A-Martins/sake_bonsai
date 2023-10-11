/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author aluno
 */
public class Conector {
    public static Connection getConnection(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String banco = "sakebonsai";
             String usuario = "root";
            String senha = "";
            
            return DriverManager.getConnection(url+banco, usuario, senha);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

