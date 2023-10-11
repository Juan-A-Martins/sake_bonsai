/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import factory.Conector;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import modelDominio.Pedido;

/**
 *
 * @author aluno
 */
public class PedidoDao{
    private Connection con;

    public PedidoDao() {
        con = Conector.getConnection();
    }
    public ArrayList<Pedido> getPedidoLista(){
        Statement stmt = null;
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        try {
            String sql = "select * from pedidos";
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                Pedido pedido = new Pedido(res.getInt("codPedido"));
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
    public boolean excluirPedido(Pedido pedido){
        PreparedStatement stmt = null;
        try {
            con.setAutoCommit(false);
            String sql = "delete from pedido where codpedido = ? ";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,pedido.getCodPedido());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            try {
                con.rollback();
                return false;
            } catch (SQLException ex) {
                return false;
            }
        }finally{
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
