/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author aluno
 */
public class Pedido implements Serializable{
    private static final long serialVersionUID = 123l;
    private int codPedido;
    ArrayList<ItemDoPedido> itens;
    Date data;
    Cliente cliente;
    float valorTotal;

    public Pedido(int codPedido, ArrayList<ItemDoPedido> itens, Date data, Cliente cliente, float valorTotal) {
        this.codPedido = codPedido;
        this.itens = itens;
        this.data = data;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
    }

    public Pedido(int codPedido) {
        this.codPedido = codPedido;
    }

    

    

    public ArrayList<ItemDoPedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemDoPedido> itens) {
        this.itens = itens;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Pedido{" + "itens=" + itens + ", data=" + data + ", cliente=" + cliente + ", valorTotal=" + valorTotal + '}';
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }
    
    
}

