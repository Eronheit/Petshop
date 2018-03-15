/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Alterar;

import Visao.Cadastrar.*;
import DAO.Conexao;
import DAO.ClienteDAO;
import Modelo.Cliente;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Euxz
 */
public class AlterarCliente extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarFuncionario
     */
    public AlterarCliente() {
        initComponents();
        setSize(975, 575);
    }
    
    private void InserirDados(int cod){
        
        Connection con = Conexao.AbrirConexao();
        ClienteDAO sql = new ClienteDAO(con);
        List<Cliente> lista = new ArrayList<>();
        lista = sql.CapturarCliente(cod);
        
        for(Cliente a : lista){
            codigo.setText(""+ a.getCod());
            jTF_nome.setText(a.getNome());
            jTF_email.setText(a.getEmail());
            jTF_cpf.setText(a.getCpf());
            jTF_telefone.setText(a.getTelefone());
            jTF_endereco.setText(a.getEndereco());
        }
        Conexao.FecharConexao(con);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTF_endereco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTF_nome = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTF_cpf = new javax.swing.JFormattedTextField();
        jTF_telefone = new javax.swing.JFormattedTextField();
        jTF_email = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTF_cod = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Endereço:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 410, 120, 20);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Limpar");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 460, 130, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(170, 460, 130, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(310, 460, 130, 40);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Browallia New", 1, 48)); // NOI18N
        jLabel7.setText("Alterar Cliente");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(130, -10, 430, 90);

        jTF_endereco.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTF_endereco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_endereco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTF_endereco);
        jTF_endereco.setBounds(150, 410, 250, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Email:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(60, 260, 75, 30);

        jTF_nome.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTF_nome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_nome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTF_nome);
        jTF_nome.setBounds(150, 210, 250, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("Nome:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(60, 210, 80, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setText("Telefone:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 360, 112, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setText("CPF:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(80, 310, 55, 30);

        jTF_cpf.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            jTF_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTF_cpf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_cpf.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        getContentPane().add(jTF_cpf);
        jTF_cpf.setBounds(150, 310, 250, 30);

        jTF_telefone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            jTF_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTF_telefone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_telefone.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        getContentPane().add(jTF_telefone);
        jTF_telefone.setBounds(150, 360, 250, 30);

        jTF_email.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTF_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_email.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTF_email);
        jTF_email.setBounds(150, 260, 250, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setText("Insira o código:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(10, 110, 188, 30);

        jTF_cod.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTF_cod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_cod.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTF_cod);
        jTF_cod.setBounds(210, 110, 70, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setText("Cliente Nº:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(160, 160, 131, 30);

        codigo.setEditable(false);
        codigo.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codigo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });
        getContentPane().add(codigo);
        codigo.setBounds(300, 160, 70, 30);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("OK");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(290, 110, 80, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cats-wallpaper1.jpg"))); // NOI18N
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 960, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String codigooo = codigo.getText();
        String nome = jTF_nome.getText();
        String email = jTF_email.getText();
        String cpf = jTF_cpf.getText();
        String telefone = jTF_telefone.getText();
        String endereco = jTF_endereco.getText();
        
        if (nome.equalsIgnoreCase("") || email.equalsIgnoreCase("") || cpf.equalsIgnoreCase("") || telefone.equalsIgnoreCase("") || endereco.equalsIgnoreCase("")) {
            
            JOptionPane.showMessageDialog(null,"Nenhum campo pode ficar vazio!!","Erro", JOptionPane.WARNING_MESSAGE);
            

        }
        else{
            Connection con = Conexao.AbrirConexao(); 
            ClienteDAO sql = new ClienteDAO(con);
            
            int cod = Integer.parseInt(codigooo);
            Cliente a = new Cliente();
            
            a.setCod(cod);
            a.setNome(nome);
            a.setEmail(email);
            a.setCpf(cpf);
            a.setTelefone(telefone);
            a.setEndereco(endereco);
            
            sql.Alterar_Cliente(a);
            
            Conexao.FecharConexao(con);
            
            jTF_nome.setText("");
            jTF_email.setText("");
            jTF_cpf.setText("");
            jTF_telefone.setText("");
            jTF_endereco.setText("");
            codigo.setText("");
            
            JOptionPane.showMessageDialog(null,"Cliente alterado com sucesso", "sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTF_nome.setText("");
        jTF_email.setText("");
        jTF_cpf.setText("");
        jTF_telefone.setText("");
        jTF_endereco.setText("");
        codigo.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String codigoo = jTF_cod.getText();
        Connection con = Conexao.AbrirConexao();
        ClienteDAO sql = new ClienteDAO(con);
        int cod = Integer.parseInt(codigoo);
        
        if (sql.Testar_Cliente(cod) == false) {
            JOptionPane.showMessageDialog(null,"Codigo não encontrado no banco",
                    "Locadora", JOptionPane.ERROR_MESSAGE);
            Conexao.FecharConexao(con);
        }
        if (codigo.equals("")) {
            JOptionPane.showMessageDialog(null,"Digite um codigo para atualizar",
                    "Locadora", JOptionPane.WARNING_MESSAGE);
        }
        
        codigo.setText("");
        jTF_nome.setText("");
        jTF_email.setText("");
        jTF_cpf.setText("");
        jTF_telefone.setText("");
        jTF_endereco.setText("");
        
        InserirDados(cod);
        jTF_cod.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed

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
            java.util.logging.Logger.getLogger(AlterarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTF_cod;
    private javax.swing.JFormattedTextField jTF_cpf;
    private javax.swing.JTextField jTF_email;
    private javax.swing.JTextField jTF_endereco;
    private javax.swing.JTextField jTF_nome;
    private javax.swing.JFormattedTextField jTF_telefone;
    // End of variables declaration//GEN-END:variables
}
