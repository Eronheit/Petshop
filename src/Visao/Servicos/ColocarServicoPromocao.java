/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Servicos;

import DAO.Conexao;
import DAO.ServicoDAO;
import Modelo.Servico;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Euxz
 */
public class ColocarServicoPromocao extends javax.swing.JFrame {

    /**
     * Creates new form ColocarServicoPromocao
     */
    public ColocarServicoPromocao() {
        initComponents();
        AtualizaComboServico();
        setSize(905, 520);
        setLocationRelativeTo(this);
        setResizable(false);
    }

    private void AtualizaComboServico(){
            Connection con = Conexao.AbrirConexao();
            ServicoDAO sql = new ServicoDAO(con);
            List<Servico> lista = new ArrayList<>();
            lista = sql.ListarComboServico();
            jCB_servico.addItem("");
            
            for(Servico b : lista){
                jCB_servico.addItem(b.getNome());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCB_servico = new javax.swing.JComboBox<>();
        jTF_codservico = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTF_desconto = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTF_preco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/7541bd14c8337132e493fcb0b21eec64.jpg"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel8.setText("Fazer Promoção");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Selecione o serviço desejado");

        jCB_servico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_servicoActionPerformed(evt);
            }
        });

        jTF_codservico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTF_codservico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_codservico.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Desconto:");

        jTF_desconto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTF_desconto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_desconto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Promoção");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTF_preco.setEditable(false);
        jTF_preco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTF_preco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_preco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Preço:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addComponent(jTF_codservico, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCB_servico, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(jLabel6)
                .addGap(5, 5, 5)
                .addComponent(jTF_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(jTF_desconto, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(373, 373, 373)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(249, 249, 249)
                    .addComponent(jLabel8)
                    .addContainerGap(315, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCB_servico, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTF_codservico, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_desconto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 55, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(200, 200, 200)
                    .addComponent(jLabel8)
                    .addContainerGap(205, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCB_servicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_servicoActionPerformed
        Connection con = Conexao.AbrirConexao();
        ServicoDAO sql = new ServicoDAO(con);
        List<Servico> lista = new ArrayList<>();
        String servico = jCB_servico.getSelectedItem().toString();

        lista = sql.ConsultarDescontoECodServico(servico);

        for(Servico a : lista){
            int cod = a.getCod();
            Double desconto = a.getDesconto();
            Double preco = a.getPreco();
            jTF_codservico.setText("" + cod);
            jTF_desconto.setText("" + desconto);
            jTF_preco.setText("" + preco);
        }
        Conexao.FecharConexao(con);
    }//GEN-LAST:event_jCB_servicoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String cod = jTF_codservico.getText();
        String desconto = jTF_desconto.getText();

        if (desconto.equalsIgnoreCase("")) {

            jTF_desconto.setText("0");

        }
        else{
            Connection con = Conexao.AbrirConexao();
            ServicoDAO sql = new ServicoDAO(con);

            int codd = Integer.parseInt(cod);
            
            Double descontoo = Double.parseDouble(desconto);
            
            Servico s = new Servico();
            
            s.setCod(codd);
            s.setDesconto(descontoo);

            sql.Promocao(s);

            Conexao.FecharConexao(con);

            jTF_codservico.setText("");
            jTF_desconto.setText("");
            jTF_preco.setText("");
            
            JOptionPane.showMessageDialog(null,"Promoção feita com sucesso", "sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ColocarServicoPromocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColocarServicoPromocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColocarServicoPromocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColocarServicoPromocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColocarServicoPromocao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCB_servico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTF_codservico;
    private javax.swing.JTextField jTF_desconto;
    private javax.swing.JTextField jTF_preco;
    // End of variables declaration//GEN-END:variables
}
