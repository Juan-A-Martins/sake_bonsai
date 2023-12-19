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
                    userSel = new Administrador(
                            res.getInt("codUsuario"), res.getString("nomeUsuario"),
                            res.getDate("dataNascimento"),
                            res.getString("login"),
                            res.getString("senha"),
                            res.getString("email"));
                }else{
                    userSel = new Cliente(res.getString("endereco"), 
                            res.getInt("codUsuario"),
                            res.getString("nomeUsuario"), 
                            res.getDate("dataNascimento"),
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
                    userSel = new Administrador(res.getInt("codUsuario"),
                            res.getString("nomeUsuario"),
                            res.getDate("dataNascimento"),
                            res.getString("login"),
                            res.getString("senha"),
                            res.getString("email"));
                }else{
                    userSel = new Cliente(res.getString("endereco"), res.getInt("codUsuario"), 
                            res.getString("nomeUsuario"),
                            res.getDate("dataNascimento"),
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
            System.out.println(stmt);
            while (res.next()) {
                System.out.println(res.getInt("codUsuario")+ res.getString("nomeUsuario")+
                            res.getDate("dataNascimento")+
                            res.getString("login")+
                            res.getString("senha")+
                            res.getString("email"));
 
                Usuario user = new Usuario(res.getInt("codUsuario"),
                            res.getString("nomeUsuario"),
                            res.getDate("dataNascimento"),
                            res.getString("login"),
                            res.getString("senha"),
                            res.getString("email"));

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
    public boolean excluirUsuario(Usuario usuario){
            PreparedStatement stmt = null;
        try {
            con.setAutoCommit(false);
            String sql = "delete from usuario where codUsuario = ? ";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuario.getCodUsuario());
            stmt.execute();
            con.commit();
            return true;
        } catch (Exception e) {
            try {
                con.rollback();
                return false;
            } catch (Exception ex) {
                return false;
            }
        } finally {
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
}
     public int inserirUsuario(Cliente cliente) {
        PreparedStatement stmt = null;
        try {
            try {
                con.setAutoCommit(false);
                String sql = "insert into usuario(nomeUsuario, dataNascimento, login, senha, email, endereco, tipo) values(?, ?, ?, ?, ?, ?, 2)";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, cliente.getNomeUsuario());
                stmt.setDate(2, new java.sql.Date(cliente.getDataNascimento().getTime()));
                stmt.setString(3, cliente.getLogin());
                stmt.setString(4, cliente.getSenha());
                stmt.setString(5, cliente.getEmail());
                stmt.setString(6,cliente.getEndereco());
                stmt.execute();

                con.commit();
                return -1;//inidica que tudo deu CERTO

            } catch (SQLException e) {
                try {
                    con.rollback();
                    e.printStackTrace();
                    return e.getErrorCode();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    return ex.getErrorCode();
                }
            }
        } finally {
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return e.getErrorCode();
            }
        }
    }
     public Usuario verificarSenha(String senha){
         PreparedStatement stmt = null;
         Usuario user = null;
         try {
            String sql = "select * from usuario where senha = ? ";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, senha);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                    user = new Administrador(
                            res.getInt("codUsuario"),
                            res.getString("nomeUsuario"),
                            res.getDate("dataNascimento"),
                            res.getString("login"),
                            res.getString("senha"),
                            res.getString("email"));
                
            }
            System.out.println(user);
            
            //fechando conexões com o banco
            res.close();//fecha resultado
            stmt.close();//fecha statment
            con.close();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     public Usuario verificarEmail(String email){
         PreparedStatement stmt = null;
         Usuario user = null;
         try {
            String sql = "select * from usuario where email = ? ";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                    user = new Administrador(
                            res.getInt("codUsuario"),
                            res.getString("nomeUsuario"),
                            res.getDate("dataNascimento"),
                            res.getString("login"),
                            res.getString("senha"),
                            res.getString("email"));
                
            }
            System.out.println(user);
            
            //fechando conexões com o banco
            res.close();//fecha resultado
            stmt.close();//fecha statment
            con.close();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     public int novaSenha(Usuario usuario){
        PreparedStatement stmt = null;
        try {
            try {
                con.setAutoCommit(false);
                String sql = "update usuario set senha = ? where codUsuario = ? ";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, usuario.getSenha());
                stmt.setInt(2, usuario.getCodUsuario());
                System.out.println(""+usuario.getSenha());
                stmt.execute();
                con.commit();
                return -1;
            } catch (SQLException e) {
                try {
                    con.rollback();
                    return e.getErrorCode();
                } catch (SQLException ex) {
                    return ex.getErrorCode();
                }
            }
        } finally{
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return e.getErrorCode();
            }
        }
    }
}
