/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.Serializable;

/**
 *
 * @author aluno
 */
class itemDoPedido implements Serializable{
    private static final long serialVersionUID = 123l;
    Produto produto;
    int quantidade;
    float valorUnitario;
    float valorDoItem;

    public itemDoPedido(Produto produto, int quantidade, float valorUnitario, float valorDoItem) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorDoItem = valorDoItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public float getValorDoItem() {
        return valorDoItem;
    }

    public void setValorDoItem(float valorDoItem) {
        this.valorDoItem = valorDoItem;
    }
    
    
}
