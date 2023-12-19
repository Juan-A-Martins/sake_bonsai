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
public class Usuario implements Serializable{
    private static final long serialVersionUID = 123l;
    private int codUsuario;
    private String nomeUsuario;
    private String login;
    private String senha;
    private String email;
    private Date dataNascimento;

    public Usuario(int codUsuario, String nomeUsuario, Date dataNascimento, String login, String senha, String email) {
        this.codUsuario = codUsuario;
        this.nomeUsuario = nomeUsuario;
        this.dataNascimento = dataNascimento;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(String senha) {
        this.senha = senha;
    }
    public Usuario(int codUsuario, String senha) {
        this.codUsuario = codUsuario;
        this.senha = senha;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String nomeUsuario, Date dataNascimento, String login, String senha, String email) {
        this.nomeUsuario = nomeUsuario;
        this.dataNascimento = dataNascimento;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codUsuario=" + codUsuario + ", nomeUsuario=" + nomeUsuario + ", login=" + login + ", senha=" + senha + ", email=" + email + ", dataNascimento=" + dataNascimento + '}';
    }

   
    
}
