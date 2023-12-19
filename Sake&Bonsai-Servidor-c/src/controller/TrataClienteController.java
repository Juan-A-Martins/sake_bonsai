/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import model.PedidoDao;
import model.ProdutoDao;
import model.UsuarioDao;
import modelDominio.Cliente;
import modelDominio.Pedido;
import modelDominio.Produto;
import modelDominio.Usuario;

/**
 *
 * @author aluno
 */
public class TrataClienteController extends Thread{
   
    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;
    int idUnico;
    
    public TrataClienteController(Socket socket, int idUnico){
        this.idUnico = idUnico;
        this.socket = socket;
        try {
            this.in = new ObjectInputStream(this.socket.getInputStream());
            this.out = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String comando;
        System.out.println("Esperando conexão do cliente..");
        try {
            comando = (String) in.readObject();
            while (!comando.equalsIgnoreCase("fim")) {
                System.out.println("Cliente: "+idUnico+ " enviou o comando: "+ comando);
                //comandos
                if (comando.equalsIgnoreCase("efetuarLogin")) {
                    out.writeObject("MandaAíMano");
                    Usuario user = (Usuario) in.readObject();
                    System.out.println(user);
                    UsuarioDao userDao = new UsuarioDao();
                    out.writeObject(userDao.efetuarLogin(user));
                }else if (comando.equalsIgnoreCase("listaUsuario")) {
                    System.out.println("entrei aqui");
                    UsuarioDao userDao = new UsuarioDao();
                    ArrayList<Usuario> listaUsuarios = userDao.usuarioLista();
                    out.writeObject(listaUsuarios);
                } else if (comando.equalsIgnoreCase("usuarioListaNome")) {
                    out.writeObject("ok");
                    String nome = (String) in.readObject();
                    UsuarioDao userDao = new UsuarioDao();
                    out.writeObject(userDao.usuarioListaNome(nome));
                }else if (comando.equalsIgnoreCase("listaProduto")) {
                    System.out.println("entrei aqui");
                    ProdutoDao produtoDao = new ProdutoDao();
                    ArrayList<Produto> listaUsuarios = produtoDao.getListaProduto();
                    out.writeObject(listaUsuarios);
                }else if (comando.equalsIgnoreCase("produtoListaNome")) {
                    out.writeObject("ok");
                    System.out.println("entrei aqui");
                    String nome = (String) in.readObject();
                    ProdutoDao pdao = new ProdutoDao();
                    out.writeObject(pdao.getProdutoListaNome(nome));
                }else if (comando.equalsIgnoreCase("excluirUsuario")) {
                    out.writeObject("ok");
                    Usuario user = (Usuario) in.readObject();
                    UsuarioDao userDao = new UsuarioDao();
                    out.writeObject(userDao.excluirUsuario(user));
                }else if (comando.equalsIgnoreCase("inserirProduto")) {
                    out.writeObject("ok");
                    Produto produto = (Produto) in.readObject();
                    ProdutoDao produtoDao = new ProdutoDao();
                    out.writeObject(produtoDao.inserirProduto(produto) == -1);
                }else if (comando.equalsIgnoreCase("excluirProduto")) {
                    System.out.println("entreiaqui");
                    out.writeObject("ok");
                    Produto p = (Produto) in.readObject();
                    ProdutoDao pDao = new ProdutoDao();
                    out.writeObject(pDao.excluirProduto(p));
                }else if(comando.equalsIgnoreCase("editarProduto")){
                    System.out.println("cheguei aqui");
                    out.writeObject("ok");
                    Produto produto = (Produto) in.readObject();
                    ProdutoDao pDao = new ProdutoDao();
                    out.writeObject(pDao.editarProduto(produto) == -1);
                }else if(comando.equalsIgnoreCase("listarPedido")){
                    System.out.println("cheguei aqui");
                    out.writeObject("ok");
                    PedidoDao pDao = new PedidoDao();
                    out.writeObject(pDao.getPedidoLista());
                }else if(comando.equalsIgnoreCase("listarItemDoPedido")){
                    System.out.println("cheguei aqui");
                    int codPedido =  (int) in.readObject(); // recebendo o código do pedido
                    PedidoDao pDao = new PedidoDao();
                    out.writeObject(pDao.getItensDoPedido(codPedido));
                } else if (comando.equalsIgnoreCase("listaPedido")) {
                    System.out.println("entrei aqui");
                    PedidoDao pedidoDao = new PedidoDao();
                    ArrayList<Pedido> listaPedido = pedidoDao.getPedidoLista();
                    out.writeObject(listaPedido);
                }else if (comando.equalsIgnoreCase("inserirUsuario")) {
                    out.writeObject("ok");
                    Cliente user = (Cliente) in.readObject();
                    UsuarioDao userDao = new UsuarioDao();
                    out.writeObject(userDao.inserirUsuario((Cliente) user) == -1);
                }else if(comando.equalsIgnoreCase("verificarSenha")) {
                    out.writeObject("MandaAíMano");
                    String senha = (String) in.readObject();
                    System.out.println(senha);
                    UsuarioDao userDao = new UsuarioDao();
                    out.writeObject(userDao.verificarSenha(senha));
                }else if(comando.equalsIgnoreCase("verificarEmail")) {
                    out.writeObject("MandaAíMano");
                    String email = (String) in.readObject();
                    System.out.println(email);
                    UsuarioDao userDao = new UsuarioDao();
                    out.writeObject(userDao.verificarEmail(email));
                }else if(comando.equalsIgnoreCase("criarNovaSenha")){
                    System.out.println("cheguei aqui");
                    out.writeObject("ok");
                    Usuario usuario = (Usuario) in.readObject();
                    UsuarioDao usuarioDao = new UsuarioDao();
                    out.writeObject(usuarioDao.novaSenha(usuario) == -1);
                }else if (comando.equalsIgnoreCase("inserirPedido")) {
                    out.writeObject("ok");
                    Pedido pedido = (Pedido) in.readObject();
                    PedidoDao pedidoDao = new PedidoDao();
                    out.writeObject(pedidoDao.inserirPedido(pedido) == -1);
                }
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                //comandos
                comando = (String) in.readObject();
                
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Cliente: " + idUnico + " finalizou a conexão");

        try {
            this.in.close();
            this.out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
