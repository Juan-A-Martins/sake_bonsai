/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.util;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Usuario;

/**
 *
 * @author aluno
 */
public class UsuarioTableModel extends AbstractTableModel{
    private ArrayList<Usuario> listaUsuarios;
    
    public UsuarioTableModel(ArrayList<Usuario> listaUsuarios){
        this.listaUsuarios = listaUsuarios;
    }
    
    @Override
    public int getRowCount() {
        return listaUsuarios.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario user = listaUsuarios.get(rowIndex);
        switch (columnIndex) {
            case 0: return user.getCodUsuario();
            case 1: return user.getNomeUsuario();
            case 2: return user.getLogin();
            
            default: return "[ERRO]";
        }
    }
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Código:";
                    case 1: return "Nome:";
                    case 2: return "Login";
                    
            default: return "[ERRO!]";
              
        }
    }
    public Usuario getUsuario(int linha){
        return listaUsuarios.get(linha);
    }
    
}
