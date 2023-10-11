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
public class Cliente extends Usuario implements Serializable{
    private static final long serialVersionUID = 123l;
 
    String endereco;

    public Cliente(String endereco, int codUsuario, String nomeUsuario, String login, String senha, String email) {
        super(codUsuario, nomeUsuario, login, senha, email);
        this.endereco = endereco;
    }

    public Cliente(String endereco, String login, String senha) {
        super(login, senha);
        this.endereco = endereco;
    }

    public Cliente(String endereco, String nomeUsuario, String login, String senha, String email) {
        super(nomeUsuario, login, senha, email);
        this.endereco = endereco;
    }
    
   

    @Override
    public String toString() {
        return "Cliente{" + '}';
    }

    
    
}
