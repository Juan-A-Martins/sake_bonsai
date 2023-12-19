/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelDominio.Bebida;
import modelDominio.Prato;
import modelDominio.Produto;
import view.util.ComboBoxPrato;
import view.util.Imagem;

/**
 *
 * @author aluno
 */
public class TelaAdicionarProduto extends javax.swing.JFrame {

    private Imagem imagem = null;
    
    
    public void limpaCampos() {
        jTFNome.requestFocus();
        jTxtADescricao.setText("");
        jTFTempo.setText("");
        jFTData.setText("");
        jblImagem.setIcon(null);
        imagem = null;
    }

    /**
     * Creates new form TelaAdicionarProduto
     */
    public TelaAdicionarProduto() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JBAdicionar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTFTempo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jFTValor = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtADescricao = new javax.swing.JTextArea();
        jFTData = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jblImagem = new javax.swing.JButton();
        jTFNome = new javax.swing.JTextField();
        jCBTipo = new javax.swing.JComboBox<>();
        jtxtImagem = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jBVoltar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(241, 237, 237));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Descrição:");

        JBAdicionar.setText("Adicionar");
        JBAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAdicionarActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Valor:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tempo:");

        jFTValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jTxtADescricao.setColumns(20);
        jTxtADescricao.setRows(5);
        jScrollPane1.setViewportView(jTxtADescricao);

        jFTData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Data:");

        jblImagem.setText("Carregar Imagem");
        jblImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jblImagemActionPerformed(evt);
            }
        });

        jCBTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Selecionar>>", "Prato", "Bebida" }));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nome:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Tipo:");

        jPanel2.setBackground(new java.awt.Color(238, 58, 58));

        jBVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/left-arrow.png"))); // NOI18N
        jBVoltar.setText("Voltar");
        jBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVoltarActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/logo certa.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFTData, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFTValor, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jblImagem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                                .addComponent(jtxtImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(88, 88, 88)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jFTValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jFTData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jblImagem)
                    .addComponent(jtxtImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(JBAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBVoltarActionPerformed

    private void JBAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAdicionarActionPerformed
        // TODO add your handling code here:
        float valor;
        Date data;
        try {
            valor = ((Number) jFTValor.getValue()).floatValue();
            System.out.println(valor);
        } catch (Exception e) {
            valor = 0;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            data = sdf.parse(jFTData.getText());

        } catch (Exception e) {
            data = null;
            e.printStackTrace();
        }
        if (jTFNome.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha o campo Nome.",
                    this.getTitle(), JOptionPane.ERROR_MESSAGE);
            jTFNome.requestFocus();
        } else if (jTxtADescricao.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha o campo Descrição.",
                    this.getTitle(), JOptionPane.ERROR_MESSAGE);
            jTxtADescricao.requestFocus();
        } else if (valor <= 0) {
            JOptionPane.showMessageDialog(this, "Preencha o campo Valor.", this.getTitle(), JOptionPane.ERROR_MESSAGE);
            jFTValor.requestFocus();
        } else if (jTFTempo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha o campo Tempo.",
                    this.getTitle(), JOptionPane.ERROR_MESSAGE);
            jTFTempo.requestFocus();
        } else if (data == null) {
            JOptionPane.showMessageDialog(this, "Preencha o campo Data",
                    this.getTitle(), JOptionPane.ERROR_MESSAGE);
            jFTData.requestFocus();
        } else {
            String nomeProduto = jTFNome.getText();
            String descricao = jTxtADescricao.getText();
            String tempo = jTFTempo.getText();
            int tipo = jCBTipo.getSelectedIndex();
            
            if (jCBTipo.getSelectedIndex() == 1) {

               
                Prato prato = new Prato(nomeProduto, descricao, valor, tempo, data, imagem.getImagem(), tipo);
                Boolean ok = SakeBonsaiCliente.ccont.inserirProduto(prato);

                if (!ok) {
                    JOptionPane.showMessageDialog(this,
                            "Ocorreu um erro",
                            this.getTitle(),
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Prato inserido com sucesso!",
                            this.getTitle(),
                            JOptionPane.INFORMATION_MESSAGE);
                    limpaCampos();
                    TelaProduto telaProduto = new TelaProduto();
                    telaProduto.setVisible(true);
                    dispose();

                }
            } else if (jCBTipo.getSelectedIndex() == 2) {
                    Bebida bebida = new Bebida(nomeProduto, descricao, valor, tempo, data, imagem.getImagem(), tipo);
               
                Boolean ok = SakeBonsaiCliente.ccont.inserirProduto(bebida);

                if (!ok) {
                    JOptionPane.showMessageDialog(this,
                            "Ocorreu um erro",
                            this.getTitle(),
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Bebida inserida com sucesso!",
                            this.getTitle(),
                            JOptionPane.INFORMATION_MESSAGE);
                    limpaCampos();
                    TelaProduto telaProduto = new TelaProduto();
                    telaProduto.setVisible(true);
                    dispose();
                    
                    
                }
            }
        }


    }//GEN-LAST:event_JBAdicionarActionPerformed

    private void jblImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jblImagemActionPerformed
        // TODO add your handling code here:
        JFileChooser jFileChooser1 = new JFileChooser();
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        if (jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            imagem = new Imagem(jFileChooser1.getSelectedFile());
            jtxtImagem.setIcon(imagem.getImageIcon());
        }
    }//GEN-LAST:event_jblImagemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdicionarProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAdicionar;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JComboBox<String> jCBTipo;
    private javax.swing.JFormattedTextField jFTData;
    private javax.swing.JFormattedTextField jFTValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFTempo;
    private javax.swing.JTextArea jTxtADescricao;
    private javax.swing.JButton jblImagem;
    private javax.swing.JLabel jtxtImagem;
    // End of variables declaration//GEN-END:variables
}
