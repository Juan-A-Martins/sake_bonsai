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
import model.ProdutoDao;
import model.UsuarioDao;
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
                    ArrayList<Produto> listaUsuarios = produtoDao.getLista();
                    out.writeObject(listaUsuarios);
                }else if (comando.equalsIgnoreCase("produtoListaNome")) {
                    out.writeObject("ok");
                    String nome = (String) in.readObject();
                    ProdutoDao produtoDao = new ProdutoDao();
                    out.writeObject(produtoDao.listarPNomeProduto(nome));
                    
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
