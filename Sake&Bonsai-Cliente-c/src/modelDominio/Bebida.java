/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author aluno
 */
public class Bebida extends Produto implements Serializable{
    private static final long serialVersionUID = 123l;

    public Bebida(String nomeProduto, String descricao, float valor, String tempo, Date data, byte[] imagem, int tipo) {
        super(nomeProduto, descricao, valor, tempo, data, imagem, tipo);
    }

    public Bebida(int codProduto) {
        super(codProduto);
    }

    public Bebida(int codProduto, String nomeProduto, String descricao, float valor, String tempo, Date data, byte[] imagem, int tipo) {
        super(codProduto, nomeProduto, descricao, valor, tempo, data, imagem, tipo);
    }

    
    
}
