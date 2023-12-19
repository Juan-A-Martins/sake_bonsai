/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.ConexaoController;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author aluno
 */
public class SakeBonsaiCliente {
    public static ConexaoController ccont;
    
    
    
    public static void main(String[] args) {
        Socket socket;
        ObjectInputStream in;
        ObjectOutputStream out;
        
        try {
            System.out.println("Tentando conectar no servidor");
            socket = new Socket("127.0.0.1",12345);
            System.out.println("Conectado com sucesso!");
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            
            ccont = new ConexaoController(out, in);
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
