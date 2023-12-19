package view;

import controller.TrataClienteController;
import factory.Conector;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author aluno
 */
public class SakeBonsaiServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket servidor;
        int idUnico=0;
        
        try {
            servidor = new ServerSocket(12345);
            System.out.println("Servidor inicializado, aguardando clientes..");
            if (Conector.getConnection() !=null) {
                System.out.println("Conectado com sucesso no banco.");
            }
            while (true) {                
                Socket cliente = servidor.accept();
                System.out.println("Cliente novo conectado: "+cliente);
                idUnico++;
                System.out.println("Iniciando thread para o novo cliente: "+idUnico);
                TrataClienteController trataCliente = new TrataClienteController(cliente, idUnico);
                trataCliente.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
