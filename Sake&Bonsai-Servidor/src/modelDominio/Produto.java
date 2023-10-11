/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.Serializable;
import java.util.Date;
import java. time. LocalDateTime;

import java.time.LocalDate;

/**
 *
 * @author aluno
 */
public class Produto implements Serializable {
   private static final long serialVersionUID = 123l;
    private int codProduto;
    private String nomeProduto;
    private String descricao;
    private float valor;
    private String tempo;
    private Date data;
    private byte[] imagem;
    private int tipo;

    //insert
    public Produto(String nomeProduto, String descricao, float valor, String tempo, Date data, byte[] imagem, int tipo) {
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.valor = valor;
        this.tempo = tempo;
        this.data = data;
        this.imagem = imagem;
        this.tipo = tipo;
    }

    //delete
    public Produto(int codProduto) {
        this.codProduto = codProduto;
    }
    //update select
    public Produto(int codProduto, String nomeProduto, String descricao, float valor, String tempo, Date data, byte[] imagem, int tipo) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.valor = valor;
        this.tempo = tempo;
        this.data = data;
        this.imagem = imagem;
        this.tipo = tipo;
    }
    

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
    
     
}
