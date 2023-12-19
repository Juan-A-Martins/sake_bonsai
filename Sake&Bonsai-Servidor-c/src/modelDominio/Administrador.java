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
public class Administrador extends Usuario implements Serializable{
    private static final long serialVersionUID = 123l;

    public Administrador(int codUsuario, String nomeUsuario, Date dataNascimento, String login, String senha, String email) {
        super(codUsuario, nomeUsuario, dataNascimento, login, senha, email);
    }

    public Administrador(String login, String senha) {
        super(login, senha);
    }

    public Administrador(String nomeUsuario, Date dataNascimento, String login, String senha, String email) {
        super(nomeUsuario, dataNascimento, login, senha, email);
    }

    
    
    

    @Override
    public String toString() {
        return "Administrador{" + '}';
    }
    
    
}
