/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelDominio.Produto;
import modelDominio.Usuario;

/**
 *
 * @author aluno
 */
public class ConexaoController {
 private ObjectOutputStream out;
    private ObjectInputStream in;
    private Usuario usuario;

    public ConexaoController(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Usuario efetuarLogin(Usuario user){
        try {
            out.writeObject("efetuarLogin");
            String msg = (String) in.readObject();
            out.writeObject(user);
            return (Usuario) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
   /*public ArrayList<Produto> produtoLista(){
        String msg ="";
        try {
            out.writeObject("listaProduto");
            ArrayList<Produto> listaProdutos = (ArrayList<Produto>) in.readObject();
            return listaProdutos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/
   public ArrayList<Produto> listaProduto() {

        try {
            out.writeObject("listaProduto");
            return (ArrayList<Produto>) in.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    public boolean inserirProduto(Produto produto){
        String msg = "";
        try {
            out.writeObject("inserirProduto");
            msg = (String) in.readObject();
            out.writeObject(produto);
            return (boolean) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean excluirProduto(Produto produto){
        String msg = "";
        try {
            out.writeObject("excluirProduto");
            msg = (String) in.readObject();
            out.writeObject(produto);
            return (boolean) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean editarProduto(Produto produto){
        String msg = "";
        try {
            out.writeObject("editarProduto");
            msg = (String) in.readObject();
            out.writeObject(produto);
            return (boolean) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Usuario> listaUsuario() {

        try {
            out.writeObject("listaUsuario");
            return (ArrayList<Usuario>) in.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Usuario> listaUsuarioNome(String nome) {

        try {
            out.writeObject("listaUsuarioNome");
            in.readObject(); //lendo o ok do servidor
            out.writeObject(nome);
            return (ArrayList<Usuario>) in.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
    public ArrayList<Produto> listaProdutoNome(String nomeProduto) {

        try {
            out.writeObject("listaProdutoNome");
            in.readObject(); //lendo o ok do servidor
            out.writeObject(nomeProduto);
            return (ArrayList<Produto>) in.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    
    
}
}
