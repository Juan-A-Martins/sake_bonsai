/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelDominio.ItemDoPedido;
import modelDominio.Pedido;
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
        try {
            out.writeObject("excluirProduto");
            in.readObject();
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

   public ArrayList<Usuario> getUsuarioListaNome(String nome){
        try {
            out.writeObject("usuarioListaNome");
            in.readObject();
            out.writeObject(nome);
            return (ArrayList<Usuario>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Produto> getProdutoListaNome(String nome){
        try {
            out.writeObject("produtoListaNome");
            in.readObject();
            out.writeObject(nome);
            return (ArrayList<Produto>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean excluirUsuario(Usuario user){
        try {
            out.writeObject("excluirUsuario");
            in.readObject();
            out.writeObject(user);
            return (boolean) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public ArrayList<Pedido> listaPedido() {

        try {
            out.writeObject("listaPedido");
            return (ArrayList<Pedido>) in.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    public boolean inserirUsuario(Usuario user){
        String msg = "";
        try {
            out.writeObject("inserirUsuario");
            msg = (String) in.readObject();
            out.writeObject(user);
            return (boolean) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public ArrayList<ItemDoPedido> getItensDoPedido(int codPedido){
        try {
            out.writeObject("listarItemDoPedido");
            out.writeObject(codPedido);
            return (ArrayList<ItemDoPedido>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
   public Usuario verificarSenha(String senha){
        try {
            out.writeObject("verificarSenha");
            String msg = (String) in.readObject();
            out.writeObject(senha);
            return (Usuario) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
   public Usuario verificarEmail(String email){
        try {
            out.writeObject("verificarEmail");
            String msg = (String) in.readObject();
            out.writeObject(email);
            return (Usuario) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
   public boolean novaSenha(Usuario usuario){
        String msg = "";
        try {
            out.writeObject("criarNovaSenha");
            msg = (String) in.readObject();
            out.writeObject(usuario);
            return (boolean) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean inserirPedido(Pedido pedido){
        String msg = "";
        try {
            out.writeObject("inserirPedido");
            msg = (String) in.readObject();
            out.writeObject(pedido);
            return (boolean) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//
}
