/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.util;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Produto;
import modelDominio.Usuario;

/**
 *
 * @author aluno
 */
public class ProdutoTableModel extends AbstractTableModel{
    private ArrayList<Produto> listaProdutos;

    public ProdutoTableModel (ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    
    @Override
    public int getRowCount() {
        return listaProdutos.size();
    }

    @Override
    public int getColumnCount() {
       return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = listaProdutos.get(rowIndex);
        int tipo = 0;
        switch (columnIndex) {
            case 0: return produto.getCodProduto();
            case 1: return produto.getNomeProduto();
            case 2: return produto.getDescricao();
            case 3: return produto.getValor();
            case 4: return produto.getTempo();
            case 5: return produto.getData();
            case 6: return produto.getTipoLiteral();
            case 7: return produto.getImagem();
            default: return "";    
        }
    }
    @Override
    public String getColumnName(int column){
        switch (column) {
            case 0: return "Código";
            case 1: return "Nome";
            case 2: return "Descrição";
            case 3: return "Valor";
            case 4: return "Tempo";
            case 5: return "Data";
            case 6: return "Tipo";
            case 7: return "Imagem";
            default: return "NoName";
                 
        }
    }
    public Produto getProduto(int linha){
        return listaProdutos.get(linha);
    }
}
