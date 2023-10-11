/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import factory.Conector;
import java.sql.*;
import java.util.ArrayList;
import modelDominio.Administrador;
import modelDominio.Cliente;
import modelDominio.Produto;
import modelDominio.Usuario;
/**
 *
 * @author aluno
 */
public class UsuarioDao {
    private Connection con;
    
    public UsuarioDao(){
        con = Conector.getConnection();
    }
    public Usuario efetuarLogin(Usuario user){
       PreparedStatement stmt = null;
       Usuario userSel = null;
        try {
            String sql = "select * from usuario where login = ? and senha = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getSenha());
            
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                if (res.getInt("tipo")==1) {
                    userSel = new Administrador(res.getInt("codUsuario") ,
                            res.getString("nomeUsuario"),
                            res.getString("login"),
                            res.getString("senha"),
                            res.getString("email"));
                }else{
                    userSel = new Cliente(res.getString("endereco"), res.getInt("codUsuario"), 
                            res.getString("nomeUsuario"), 
                            res.getString("login"),
                            res.getString("senha"), 
                            res.getString("email"));
                }
            }
            System.out.println(userSel);
            //fechando conexões com o banco
            res.close();//fecha resultado
            stmt.close();//fecha statment
            con.close();
            return userSel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Usuario> usuarioLista() {
        Statement stmt = null;
        ArrayList<Usuario> lista = new ArrayList<>();

        try {
            String sql = "select * from usuario";
            //criando o statment
            stmt = con.createStatement();
            //executando o script sql acima e guardando o resultado dentro da variavel res
            ResultSet res = stmt.executeQuery(sql);
            //percorrendo o res com o looping while
            while (res.next()) {
                Usuario userSel = null;
                 if (res.getInt("tipo")==1) {
                    userSel = new Administrador(res.getInt("codUsuario") ,
                            res.getString("nomeUsuario"),
                            res.getString("login"),
                            res.getString("senha"),
                            res.getString("email"));
                }else{
                    userSel = new Cliente(res.getString("endereco"), res.getInt("codUsuario"), 
                            res.getString("nomeUsuario"), 
                            res.getString("login"),
                            res.getString("senha"), 
                            res.getString("email"));
                }
                //adicionar o objeto na lista
                lista.add(userSel);
                //imprimindo o objeto marca
                System.out.println(userSel);
            }
            //fechar as conexoes
            res.close();//fecha o resultado
            stmt.close(); //fecha o statment
            con.close();//fecha a conexão com o banco :(
            return lista;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Usuario> usuarioListaNome(String nome) {
        PreparedStatement stmt = null;
        ArrayList<Usuario> lista = new ArrayList<>();

        try {
            String sql = "select * from usuario where nomeUsuario like ? ";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Usuario user = new Usuario(res.getString("codmarca"), res.getString("nomemarca"));

                lista.add(user);

                System.out.println(user);
            }

            res.close();
            stmt.close();
            con.close();
            return lista;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
