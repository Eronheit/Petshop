/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Alterar;


import Visao.Cadastrar.*;
import DAO.AnimalDAO;
import DAO.Conexao;
import DAO.ServicoDAO;
import Modelo.Animal;
import Modelo.Servico;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Euxz
 */
public class AlterarServico extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarFuncionario
     */
    public AlterarServico() {
        initComponents();
        setSize(975, 575);
        AtualizaComboAnimal();
    }
    
    private void AtualizaComboAnimal(){
            Connection con = Conexao.AbrirConexao();
            AnimalDAO sql = new AnimalDAO(con);
            List<Animal> lista = new ArrayList<>();
            lista = sql.ListarComboAnimal();
            jCB_indicacao.addItem("");
            
            for(Animal b : lista){
                jCB_indicacao.addItem(b.getNome());
            }
            Conexao.FecharConexao(con);
    }

    private void InserirDados(int cod){
        
        Connection con = Conexao.AbrirConexao();
        ServicoDAO sql = new ServicoDAO(con);
        List<Servico> lista = new ArrayList<>();
        lista = sql.CapturarServico(cod);
        
        for(Servico s : lista){
            codigo.setText(""+ s.getCod());
            jTF_nome.setText(s.getNome());
            jTF_indicacao.setText(""+ s.getIndicacao());
            jTF_preco.setText(""+ s.getPreco());
            jTF_disponibilidade.setText(s.getDisponibilidade());
            zero.setText(""+ s.getDesconto());
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTF_preco = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTF_disponibilidade = new javax.swing.JTextField();
        jTF_nome = new javax.swing.JTextField();
        jCB_indicacao = new javax.swing.JComboBox<>();
        jTF_indicacao = new javax.swing.JTextField();
        jTF_cod = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        zero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Limpar");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(400, 380, 130, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(540, 380, 130, 30);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(680, 380, 130, 30);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Browallia New", 1, 48)); // NOI18N
        jLabel7.setText("Alterar Serviço");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(130, -10, 430, 90);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Indicação:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(420, 250, 100, 30);

        jTF_preco.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTF_preco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_preco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTF_preco);
        jTF_preco.setBounds(530, 300, 260, 23);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Nome:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(450, 220, 60, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Disponibilidade:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(380, 340, 144, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Preço:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(460, 290, 59, 30);

        jTF_disponibilidade.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTF_disponibilidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_disponibilidade.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTF_disponibilidade);
        jTF_disponibilidade.setBounds(530, 340, 260, 23);

        jTF_nome.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTF_nome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_nome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTF_nome);
        jTF_nome.setBounds(530, 220, 260, 23);

        jCB_indicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_indicacaoActionPerformed(evt);
            }
        });
        getContentPane().add(jCB_indicacao);
        jCB_indicacao.setBounds(580, 260, 210, 20);

        jTF_indicacao.setEditable(false);
        getContentPane().add(jTF_indicacao);
        jTF_indicacao.setBounds(530, 260, 40, 20);

        jTF_cod.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTF_cod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_cod.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTF_cod);
        jTF_cod.setBounds(530, 140, 70, 23);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Insira o código:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(380, 130, 141, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Cliente Nº:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(420, 180, 99, 20);

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
        codigo.setBounds(530, 180, 70, 23);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("OK");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(610, 140, 80, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Cute-puppy-dog-pet-face-hand_1920x1080.jpg"))); // NOI18N
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 818, 461);

        zero.setText("0");
        getContentPane().add(zero);
        zero.setBounds(780, 70, 6, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String codigooo = codigo.getText();
        String nome = jTF_nome.getText();
        String indicacao = jTF_indicacao.getText();
        String preco = jTF_preco.getText();
        String desconto = zero.getText();
        String disponibilidade = jTF_disponibilidade.getText();
        
        if (nome.equalsIgnoreCase("") || indicacao.equalsIgnoreCase("") || preco.equalsIgnoreCase("") || disponibilidade.equalsIgnoreCase("")) {
            
            JOptionPane.showMessageDialog(null,"Nenhum campo pode ficar vazio!!","Erro", JOptionPane.WARNING_MESSAGE);
            

        }
        else{
            Connection con = Conexao.AbrirConexao(); 
            ServicoDAO sql = new ServicoDAO(con);
            
            int indicacaoo = Integer.parseInt(indicacao);
            
            Double precoo = Double.parseDouble(preco);

            Double descontoo = Double.parseDouble(desconto);
            
            int cod = Integer.parseInt(codigooo);
            
            Servico s = new Servico();
            
            s.setCod(cod);
            s.setNome(nome);
            s.setIndicacao(indicacaoo);
            s.setPreco(precoo);
            s.setDisponibilidade(disponibilidade);
            s.setDesconto(descontoo);

            
            sql.Alterar_Servico(s);
            
            Conexao.FecharConexao(con);
            
            codigo.setText("");
            jTF_nome.setText("");
            jTF_indicacao.setText("");
            jTF_preco.setText("");
            jTF_disponibilidade.setText("");
            
            JOptionPane.showMessageDialog(null,"Serviço inserido com sucesso", "sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTF_nome.setText("");
        jTF_indicacao.setText("");
        jTF_preco.setText("");
        jTF_disponibilidade.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCB_indicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_indicacaoActionPerformed
        Connection con = Conexao.AbrirConexao();
        AnimalDAO sql = new AnimalDAO(con);
        List<Animal> lista = new ArrayList<>();
        String indicacao = jCB_indicacao.getSelectedItem().toString();
        
        lista = sql.ConsultarCodigoAnimal(indicacao);
        
        for(Animal a : lista){
            int b = a.getCod();
            jTF_indicacao.setText("" + b);
        }
        Conexao.FecharConexao(con);
    }//GEN-LAST:event_jCB_indicacaoActionPerformed

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String codigoo = jTF_cod.getText();
        Connection con = Conexao.AbrirConexao();
        ServicoDAO sql = new ServicoDAO(con);
        int cod = Integer.parseInt(codigoo);

        if (sql.Testar_Servico(cod) == false) {
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
        jTF_indicacao.setText("");
        jTF_preco.setText("");
        jTF_disponibilidade.setText("");

        InserirDados(cod);
        jTF_cod.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(AlterarServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AlterarServico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jCB_indicacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTF_cod;
    private javax.swing.JTextField jTF_disponibilidade;
    private javax.swing.JTextField jTF_indicacao;
    private javax.swing.JTextField jTF_nome;
    private javax.swing.JTextField jTF_preco;
    private javax.swing.JLabel zero;
    // End of variables declaration//GEN-END:variables
}
