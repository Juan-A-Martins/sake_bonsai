/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.util;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import modelDominio.Prato;

/**
 *
 * @author 2022
 */
public class ComboBoxPrato {
    private String value;
    private int key;
    
    public ComboBoxPrato(int key, String value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public int getKey() {
        return key;
    }
    public static int getSelectedIndex(JComboBox combo){
        Object obj = combo.getSelectedItem();
        if (obj == null){
            return -1;
        }else{
            return ((ComboBoxPrato) obj).getKey();
        }       
    }    
    public static void preencheComboBoxMarca(int SelCodigo, JComboBox combo, ArrayList<Prato> lista, Boolean addTodos){
        Vector vlista = new Vector();
        int x = 0;
        int selecionarCodigo = -1;
        
        if (addTodos) {
            vlista.add(new ComboBoxPrato(0, "Todas"));
        }
        for(Prato c: lista){
            ComboBoxPrato cmb = new ComboBoxPrato(c.getTipo(), c.getNomeProduto());
            vlista.add(cmb);
            if (cmb.getKey() == SelCodigo) {
                selecionarCodigo = x;
                x++;
            }
        }
        DefaultComboBoxModel modelocliente = new DefaultComboBoxModel(vlista);
        combo.setModel(modelocliente);
        if (selecionarCodigo >=0) {
            combo.setSelectedIndex(selecionarCodigo);
        }
    }
}
