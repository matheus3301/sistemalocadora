/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locadora.view.locacao;

import com.locadora.DAO.AluguelDAO;
import com.locadora.DAO.ClienteDAO;
import com.locadora.DAO.Conexao;
import com.locadora.model.Aluguel;
import com.locadora.model.Cliente;
import com.locadora.model.Listar;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author matheus
 */
public class ConsultaDevolucao extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaDevolucao
     */
    public ConsultaDevolucao() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Sistema Locadora - Avaliação Banco de Dados");
        
        URL url = this.getClass().getResource("/com/locadora/imagens/icone.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        
        AtualizaCombo();
        
    }
    
    private void BuscaCodCliente(String cod){
        
        
        Connection con = Conexao.AbrirConexao();
        AluguelDAO bd = new AluguelDAO(con);
        List<Aluguel> lista = new ArrayList<>();
        lista = bd.PesquisarCodClienteID(cod);
        
        DefaultTableModel tbm =  (DefaultTableModel) jTable.getModel();
        
        while(tbm.getRowCount() > 0){
            tbm.removeRow(0);
        }
        
        int i = 0;
        for(Aluguel tab : lista){
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getCod(), i, 0);
            jTable.setValueAt(tab.getCoddvd(), i, 1);
            jTable.setValueAt(tab.getCodcliente(), i, 2);
            jTable.setValueAt(tab.getHorario(), i, 3);
            jTable.setValueAt(tab.getData_aluguel(), i, 4);
            jTable.setValueAt(tab.getData_devolucao(), i, 5);
            jTable.setValueAt(tab.getNomeFunc(), i, 6);
            i++;
        }
        
        Conexao.FecharConexao(con);
        
    }
    
    
    private void AtualizaCombo() {
        Connection con = Conexao.AbrirConexao();
        ClienteDAO sql = new ClienteDAO(con);
        List<Cliente> lista = new ArrayList<>();
        lista = sql.ListarComboCliente();
        combo.addItem("");

        for (Cliente b : lista) {
            combo.addItem(b.getNome());
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
        combo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cliente:");

        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "DVD", "Cliente", "Horário", "Locação", "Devolução", "Funcionario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        Connection con = Conexao.AbrirConexao();
        AluguelDAO sql = new AluguelDAO(con);

        List<Aluguel> lista = new ArrayList<>();
        String nome = combo.getSelectedItem().toString();

        lista = sql.PesquisarNomeFull(nome);
        

        for (Aluguel b : lista) {
            System.out.println(b.getCodcliente());
            BuscaCodCliente(b.getCodcliente());
        }

        Conexao.FecharConexao(con);
    }//GEN-LAST:event_comboActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        Integer linha = jTable.getSelectedRow();
        String idaluguel = jTable.getValueAt(linha, 0).toString();
        String idcliente =  jTable.getValueAt(linha, 2).toString();
        String iddvd =  jTable.getValueAt(linha, 1).toString();
        
        Listar a = new Listar();
        
        System.out.println("Clique");
        
        a.setCoddvd(iddvd);
        a.setCodaluguel(idaluguel);
        a.setCodcliente(idcliente);
        
        EfetuarDevolucao dev = new EfetuarDevolucao();
        dev.ReceberLista(a);
        dev.setVisible(true);
        dispose();
    }//GEN-LAST:event_jTableMouseClicked

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
            java.util.logging.Logger.getLogger(ConsultaDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaDevolucao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}