/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import factory.Conector;
import java.sql.*;
import java.util.ArrayList;
import modelDominio.Produto;
import modelDominio.Usuario;

/**
 *
 * @author aluno
 */
public class ProdutoDao {

    private Connection con;

    public ProdutoDao() {
        con = Conector.getConnection();

    }

    public ArrayList<Produto> getListaProduto() {
        Statement stmt = null;
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
        try {
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("select * from produto");
            while (res.next()) {
                Produto produto = new Produto(res.getInt("codProduto"),
                        res.getString("nomeProduto"),
                        res.getString("descricao"),
                        res.getFloat("valor"),
                        res.getString("tempo"),
                        res.getDate("data"),
                        res.getBytes("imagem"),
                        res.getInt("tipo"));

                listaProdutos.add(produto);
            }
            res.close();
            stmt.close();
            return listaProdutos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int inserirProduto(Produto produto) {
        PreparedStatement stmt = null;
        try {
            try {
                con.setAutoCommit(false);
                String sql = "insert into produto(codProduto, nomeProduto, descricao, valor, tempo, imagem, data, tipo) values(?, ?, ?, ?, ?, ?, ?, ?)";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, produto.getCodProduto());
                stmt.setString(2, produto.getNomeProduto());
                stmt.setString(3, produto.getDescricao());
                stmt.setFloat(4, produto.getValor());
                stmt.setString(5, produto.getTempo());
                stmt.setBytes(6, produto.getImagem());
                stmt.setDate(7, new java.sql.Date(produto.getData().getTime()));
                stmt.setInt(8, produto.getTipo());
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

    public boolean excluirProduto(Produto produto) {
        PreparedStatement stmt = null;
        try {
            con.setAutoCommit(false);
            String sql = "delete from produto where codProduto = ? ";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, produto.getCodProduto());
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

    public int editarProduto(Produto produto){
        PreparedStatement stmt = null;
      
        try {
            try {
                con.setAutoCommit(false);
                    String sql = "update produto set nomeProduto = ?, descricao = ?, valor = ?, tempo= ?, imagem = ?, data = ?, tipo = ? where codProduto = ? ";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, produto.getNomeProduto());
                stmt.setString(2, produto.getDescricao());
                stmt.setFloat(3, produto.getValor());
                stmt.setString(4, produto.getTempo());
                stmt.setBytes(5, produto.getImagem());
                stmt.setDate(6, new java.sql.Date(produto.getData().getTime()));
                stmt.setInt(7, produto.getTipo());
                stmt.setInt(8, produto.getCodProduto());
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

    public ArrayList<Produto> getProdutoListaNome(String nome) {
        PreparedStatement stmt = null;
        ArrayList<Produto> lista = new ArrayList<>();
        try {
            String sql = "select * from produto where nomeProduto like ? ";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            ResultSet res = stmt.executeQuery();
            System.out.println(stmt);
            while (res.next()) {
                Produto produto = new Produto(res.getInt("codProduto"),
                        res.getString("nomeProduto"),
                        res.getString("descricao"),
                        res.getFloat("valor"),
                        res.getString("tempo"),
                        res.getDate("data"),
                        res.getBytes("imagem"),
                        res.getInt("tipo"));

                lista.add(produto);
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
     public ArrayList<Produto> getProdutoEspecifico(String nome) {
        PreparedStatement stmt = null;
        ArrayList<Produto> lista = new ArrayList<>();
        try {
            String sql = "select * from produto where nomeProduto like ? ";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            ResultSet res = stmt.executeQuery();
            System.out.println(stmt);
            while (res.next()) {
                Produto produto = new Produto(res.getInt("codProduto"),
                        res.getString("nomeProduto"),
                        res.getString("descricao"),
                        res.getFloat("valor"),
                        res.getString("tempo"),
                        res.getDate("data"),
                        res.getBytes("imagem"),
                        res.getInt("tipo"));

                lista.add(produto);
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
