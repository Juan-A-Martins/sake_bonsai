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
public class Prato extends Produto implements Serializable{
    private static final long serialVersionUID = 123l;

    public Prato(String nomeProduto, String descricao, float valor, String tempo, Date data, byte[] imagem, int tipo) {
        super(nomeProduto, descricao, valor, tempo, data, imagem, tipo);
    }

    public Prato(int codProduto) {
        super(codProduto);
    }

    public Prato(int codProduto, String nomeProduto, String descricao, float valor, String tempo, Date data, byte[] imagem, int tipo) {
        super(codProduto, nomeProduto, descricao, valor, tempo, data, imagem, tipo);
    }
    
    
}
