/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import DAO.Conexao;
import DAO.FuncionarioDAO;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Euxz
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setLocationRelativeTo(this);
        setResizable(false);
        setSize(900, 500);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTF_usuario = new javax.swing.JTextField();
        jTF_senha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel5.setText("Login");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(160, 90, 150, 70);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Usuário:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 180, 170, 60);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Senha:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 240, 100, 60);
        getContentPane().add(jTF_usuario);
        jTF_usuario.setBounds(110, 200, 255, 34);
        getContentPane().add(jTF_senha);
        jTF_senha.setBounds(110, 250, 255, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(100, 330, 120, 32);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Cancelar");
        getContentPane().add(jButton2);
        jButton2.setBounds(260, 330, 120, 32);
        getContentPane().add(jProgressBar2);
        jProgressBar2.setBounds(110, 300, 255, 14);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Euxz\\Documents\\NetBeansProjects\\Trabalhos\\imagens\\cats-wallpaper1.jpg")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 960, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection con = Conexao.AbrirConexao();
        FuncionarioDAO sql = new FuncionarioDAO(con);
        String login = jTF_usuario.getText();
        String senha = jTF_senha.getText();

        if(login.equalsIgnoreCase("") || senha.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Nenhum campo pode esta Vazio","Video Locadora",JOptionPane.WARNING_MESSAGE);
            jTF_usuario.setText("");
            jTF_senha.setText("");
        }else if(sql.Logar_Funcionario(login, senha) == true){

            new Thread(){
                public void run(){
                    for(int i = 0;i < 110;i++){
                        jProgressBar2.setValue(i);
                        try{

                        }catch(Exception e){
                            e.getMessage();
                        }
                    }
                    new MenuFuncionario().setVisible(true);
                    dispose();
                }
            }
            .start();

        }else if(sql.Logar_Administrador(login, senha) == true){
            new Thread(){
                public void run(){
                    for(int i = 0;i < 110;i++){
                        jProgressBar2.setValue(i);
                        try{

                        }catch(Exception e){
                            e.getMessage();
                        }
                    }
                    new MenuAdministrador().setVisible(true);
                    dispose();
                }
            }
            .start();
            Conexao.FecharConexao(con);
        }else{
            JOptionPane.showMessageDialog(null, "Funcionario/Administrador não cadastrado ou login/senha incorretos");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JPasswordField jTF_senha;
    private javax.swing.JTextField jTF_usuario;
    // End of variables declaration//GEN-END:variables
}