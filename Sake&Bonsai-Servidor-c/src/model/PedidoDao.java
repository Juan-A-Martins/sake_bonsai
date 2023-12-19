/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import factory.Conector;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import modelDominio.*;

/**
 *
 * @author aluno
 */
public class PedidoDao {

    private Connection con;

    public PedidoDao() {
        con = Conector.getConnection();
    }

    public ArrayList<Pedido> getPedidoLista() {
        Statement stmt = null;
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        try {
            String sql = "select * from pedido "
                    + "join usuario on (usuario.codUsuario = pedido.cliente) ";
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(sql);
            ArrayList itemPedido = new ArrayList();
            while (res.next()) {
                Pedido pedido = new Pedido(res.getInt("codPedido"),
                        res.getDate("data"),
                        new Cliente(res.getString("endereco"), res.getInt("codUsuario"), res.getString("nomeUsuario"), res.getDate("dataNascimento"), res.getString("login"), res.getString("senha"), res.getString("email")),
                        res.getFloat("valorTotal"));

                listaPedidos.add(pedido);
                System.out.println(pedido);
            }

            res.close(); //fecha o resultado
            stmt.close(); //fecha o statement
            con.close(); //fecha a conexão
            return listaPedidos;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<ItemDoPedido> getItensDoPedido(int codPedido) {
        Statement stmt = null;
        ArrayList<ItemDoPedido> listaItem = new ArrayList<>();
        try {
            String sql = "select * from itensdopedido "
                    + "join produto on (produto.codProduto = itensdopedido.codProduto) where codPedido = " + codPedido;
            System.out.println("fasfas" + sql);
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                ItemDoPedido item = new ItemDoPedido(new Produto(res.getInt("codProduto"), res.getString("nomeProduto"), res.getString("descricao"), res.getFloat("valor"), res.getString("tempo"), res.getDate("data"), res.getBytes("imagem"), res.getInt("tipo")),
                        res.getInt("quantidade"),
                        res.getFloat("valorUnitario"),
                        res.getFloat("valorDoItem")
                );

                listaItem.add(item);
                System.out.println(item);
            }

            res.close(); //fecha o resultado
            stmt.close(); //fecha o statement
            con.close(); //fecha a conexão
            System.out.println("dsad" + listaItem);
            return listaItem;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int inserirPedido(Pedido pedido) {
        PreparedStatement stmt = null;
        try {
            try {
                con.setAutoCommit(false);
                String sql = "insert into pedido(data, cliente, valorTotal) values (?, ?, ?)";
                stmt = con.prepareStatement(sql);
                stmt.setDate(1, new java.sql.Date(pedido.getData().getTime()));
                stmt.setFloat(3, pedido.getValorTotal());
                stmt.setInt(2, pedido.getCliente().getCodUsuario());
                stmt.execute();

                con.commit();
                String sql2 = "select LAST_INSERT_ID() as last_id";
                stmt = con.prepareStatement(sql2);
                ResultSet res = stmt.executeQuery();
                int codPedido = -1;  // Inicialize com um valor padrão

                if (res.next()) {
                    codPedido = res.getInt("last_id");
                }
                String sql3 = "insert into itensdopedido(quantidade, valorUnitario, valorDoItem, codProduto, codPedido) values (?, ?, ?, ?, ?)";
                ArrayList<ItemDoPedido> itens = pedido.getItens();
                for (int i = 0; i < itens.size(); i++) {
                    stmt = con.prepareStatement(sql3);
                    stmt.setInt(1, itens.get(i).getQuantidade());
                    stmt.setFloat(2, itens.get(i).getValorUnitario());
                    stmt.setFloat(3, itens.get(i).getValorDoItem());
                    stmt.setInt(4, itens.get(i).getProduto().getCodProduto());
                    stmt.setFloat(5, codPedido);
                    stmt.execute();
                    con.commit();
                }
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

    public boolean excluirPedido(Pedido pedido) {
        PreparedStatement stmt = null;
        try {
            con.setAutoCommit(false);
            String sql = "delete from pedido where codPedido = ? ";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pedido.getCodPedido());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            try {
                con.rollback();
                return false;
            } catch (SQLException ex) {
                return false;
            }
        } finally {
            try {
                stmt.close();
                con.setAutoCommit(true);
                return false;
            } catch (SQLException e) {
                return false;
            }
        }
    }

}
