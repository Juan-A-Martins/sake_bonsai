/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.util;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Pedido;
import modelDominio.Usuario;

/**
 *
 * @author aluno
 */
public class PedidoTableModel extends AbstractTableModel {
    private ArrayList<Pedido> listaPedidos;
    
    public PedidoTableModel(ArrayList<Pedido> listaPedidos){
        this.listaPedidos = listaPedidos;
    }
    
    @Override
    public int getRowCount() {
        return listaPedidos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pedido pedido = listaPedidos.get(rowIndex);
        switch (columnIndex) {
            case 0: return pedido.getCodPedido();
            case 1: return pedido.getData();
            case 2: return pedido.getValorTotal();
            case 3: return pedido.getCliente();
            
            default: return "[ERRO]";
        }
    }
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Código:";
                    case 1: return "Data:";
                    case 2: return "Valor total";
                    case 3: return "Cliente";
                    
            default: return "[ERRO!]";
              
        }
    }
    public Pedido getPedido(int linha){
        return listaPedidos.get(linha);
    }
}
