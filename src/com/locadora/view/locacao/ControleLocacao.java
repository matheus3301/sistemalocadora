/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locadora.view.locacao;

import com.locadora.DAO.AluguelDAO;
import com.locadora.DAO.ClienteDAO;
import com.locadora.DAO.Conexao;
import com.locadora.DAO.DVDDAO;
import com.locadora.DAO.FilmeDAO;
import com.locadora.model.Aluguel;
import com.locadora.model.Cliente;
import com.locadora.model.Dvd_Filme;
import com.locadora.model.Funcionario;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author matheus
 */
public class ControleLocacao extends javax.swing.JFrame {

    Funcionario logado = new Funcionario();

    /**
     * Creates new form ControleLocacao
     */

    public void ReceberFunc(Funcionario a) {
        logado.setCod(a.getCod());
        logado.setNome(a.getNome());

        System.out.println(logado.getCod());
        System.out.println(logado.getNome());
    }

    public ControleLocacao() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Sistema Locadora - Avaliação Banco de Dados");
        
        URL url = this.getClass().getResource("/com/locadora/imagens/icone.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);

        AtualizaDate();
        AtualizaCombo();
        AtualizaTable();
    }

    public void AtualizaDate() {
        Date date = new Date();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
        iptData.setText(data.format(date));
        iptHora.setText(hora.format(date));
    }

    private void InserirDados(int cod) {
        Connection con = Conexao.AbrirConexao();
        DVDDAO sql = new DVDDAO(con);
        List<Dvd_Filme> lista = new ArrayList<>();
        lista = sql.CapturarLoca(cod);

        for (Dvd_Filme a : lista) {
            iptCodDvd.setText(a.getIddvd());
            iptTitulo.setText(a.getTitulo());
            iptCategoria.setText(a.getCategoria());
            iptClassificacao.setText(a.getClassificacao());
            iptValor.setText(a.getPreco());
            fotoCapa.setIcon(new ImageIcon("/home/matheus/Imagens/Video Locadora/Pictures/" + a.getCapa() + "/"));
        }
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

    private void AtualizaTable() {
        Connection con = Conexao.AbrirConexao();
        AluguelDAO bd = new AluguelDAO(con);
        List<Aluguel> lista = new ArrayList<>();
        lista = bd.ListarAluguel();

        DefaultTableModel tbm = (DefaultTableModel) jTable.getModel();

        while (tbm.getRowCount() > 0) {
            tbm.removeRow(0);
        }

        int i = 0;
        for (Aluguel tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getCod(), i, 0);
            jTable.setValueAt(tab.getCoddvd(), i, 1);
            jTable.setValueAt(tab.getCodcliente(), i, 2);
            jTable.setValueAt(tab.getHorario(), i, 3);
            jTable.setValueAt(tab.getData_aluguel(), i, 4);
            jTable.setValueAt(tab.getData_devolucao(), i, 5);
            jTable.setValueAt(tab.getNomeFunc(), i, 6);
            jTable.setValueAt(tab.getStatus(), i, 7);
            i++;
        }

        Conexao.FecharConexao(con);

    }

    private void BuscaCodAluguel() {
        int cod = Integer.parseInt(buscaCodAluguel.getText());

        Connection con = Conexao.AbrirConexao();
        AluguelDAO bd = new AluguelDAO(con);
        List<Aluguel> lista = new ArrayList<>();
        lista = bd.PesquisarCodAluguel(cod);

        DefaultTableModel tbm = (DefaultTableModel) jTable.getModel();

        while (tbm.getRowCount() > 0) {
            tbm.removeRow(0);
        }

        int i = 0;
        for (Aluguel tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getCod(), i, 0);
            jTable.setValueAt(tab.getCoddvd(), i, 1);
            jTable.setValueAt(tab.getCodcliente(), i, 2);
            jTable.setValueAt(tab.getHorario(), i, 3);
            jTable.setValueAt(tab.getData_aluguel(), i, 4);
            jTable.setValueAt(tab.getData_devolucao(), i, 5);
            jTable.setValueAt(tab.getNomeFunc(), i, 6);
            jTable.setValueAt(tab.getStatus(), i, 7);
            i++;
        }

        Conexao.FecharConexao(con);

    }

    private void BuscaCodDVD() {
        int cod = Integer.parseInt(buscaCodDvd.getText());

        Connection con = Conexao.AbrirConexao();
        AluguelDAO bd = new AluguelDAO(con);
        List<Aluguel> lista = new ArrayList<>();
        lista = bd.PesquisarCodDVD(cod);

        DefaultTableModel tbm = (DefaultTableModel) jTable.getModel();

        while (tbm.getRowCount() > 0) {
            tbm.removeRow(0);
        }

        int i = 0;
        for (Aluguel tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getCod(), i, 0);
            jTable.setValueAt(tab.getCoddvd(), i, 1);
            jTable.setValueAt(tab.getCodcliente(), i, 2);
            jTable.setValueAt(tab.getHorario(), i, 3);
            jTable.setValueAt(tab.getData_aluguel(), i, 4);
            jTable.setValueAt(tab.getData_devolucao(), i, 5);
            jTable.setValueAt(tab.getNomeFunc(), i, 6);
            jTable.setValueAt(tab.getStatus(), i, 7);
            i++;
        }

        Conexao.FecharConexao(con);

    }

    private void BuscaNomeCliente() {
        String nome = buscaNome.getText();

        Connection con = Conexao.AbrirConexao();
        AluguelDAO bd = new AluguelDAO(con);
        List<Aluguel> lista = new ArrayList<>();
        lista = bd.PesquisarNomeCliente(nome);

        DefaultTableModel tbm = (DefaultTableModel) jTable.getModel();

        while (tbm.getRowCount() > 0) {
            tbm.removeRow(0);
        }

        int i = 0;
        for (Aluguel tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getCod(), i, 0);
            jTable.setValueAt(tab.getCoddvd(), i, 1);
            jTable.setValueAt(tab.getCodcliente(), i, 2);
            jTable.setValueAt(tab.getHorario(), i, 3);
            jTable.setValueAt(tab.getData_aluguel(), i, 4);
            jTable.setValueAt(tab.getData_devolucao(), i, 5);
            jTable.setValueAt(tab.getNomeFunc(), i, 6);
            jTable.setValueAt(tab.getStatus(), i, 7);
            i++;
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        fotoCapa = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnAlugar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        iptCodDvd = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        iptHora = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        iptTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        iptCategoria = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        iptClassificacao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        iptValor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        iptCodCliente = new javax.swing.JTextField();
        combo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        iptData = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        iptDevolucao = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        buscaCodAluguel = new javax.swing.JTextField();
        buscaCodDvd = new javax.swing.JTextField();
        buscaNome = new javax.swing.JTextField();
        btnBuscaCodAluguel = new javax.swing.JButton();
        btnBuscaCodDvd = new javax.swing.JButton();
        btnBuscaNome = new javax.swing.JButton();
        btnTodos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fotoCapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/locadora/imagens/dvd.png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(192, 190, 190));

        btnAlugar.setText("Alugar");
        btnAlugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153)
                .addComponent(btnAlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnAlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel1.setText("Cód do DVD:");

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        jLabel6.setText("Horário:");

        iptHora.setEditable(false);

        jLabel2.setText("Título:");

        iptTitulo.setEnabled(false);

        jLabel3.setText("Categoria:");

        iptCategoria.setEnabled(false);

        jLabel7.setText("Classificação:");

        iptClassificacao.setEnabled(false);
        iptClassificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iptClassificacaoActionPerformed(evt);
            }
        });

        jLabel8.setText("Valor do Aluguel:");

        iptValor.setEnabled(false);

        jLabel4.setText("Cliente:");

        iptCodCliente.setEditable(false);

        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        jLabel5.setText("Data da Locação:");

        iptData.setEditable(false);

        jLabel9.setText("Data da Devolução:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iptCodDvd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iptHora))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(iptTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(iptCodCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                    .addComponent(iptCategoria))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(iptClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(iptValor, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iptData, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iptDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(iptCodDvd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOK)
                    .addComponent(jLabel6)
                    .addComponent(iptHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(iptTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(iptCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(iptClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(iptValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(iptCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel9)
                        .addComponent(iptData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(iptDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addComponent(fotoCapa)
                .addGap(482, 482, 482))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(fotoCapa)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("CADASTRAR", jPanel1);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "DVD", "Cliente", "Horário", "Locação", "Devolução", "Funcionário", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);

        jLabel11.setText("Pesquisa por Cód:");

        jLabel12.setText("Pesquisa por DVD:");

        jLabel13.setText("Pesquisa por Cliente:");

        btnBuscaCodAluguel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/locadora/imagens/lupa.png"))); // NOI18N
        btnBuscaCodAluguel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaCodAluguelActionPerformed(evt);
            }
        });

        btnBuscaCodDvd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/locadora/imagens/lupa.png"))); // NOI18N
        btnBuscaCodDvd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaCodDvdActionPerformed(evt);
            }
        });

        btnBuscaNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/locadora/imagens/lupa.png"))); // NOI18N
        btnBuscaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaNomeActionPerformed(evt);
            }
        });

        btnTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/locadora/imagens/lupa.png"))); // NOI18N
        btnTodos.setText("      TODOS ");
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(buscaCodAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscaCodAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buscaCodDvd, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(buscaNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscaCodDvd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)
                        .addComponent(buscaCodAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buscaCodDvd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscaCodAluguel))
                    .addComponent(btnBuscaCodDvd))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(buscaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnBuscaNome))
                    .addComponent(btnTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("CONSULTAR", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 794, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iptClassificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iptClassificacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iptClassificacaoActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        String pesquisa = iptCodDvd.getText();
        Connection con = Conexao.AbrirConexao();
        if (pesquisa.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o Código do DVD", "Video Locadora", JOptionPane.ERROR_MESSAGE);
        } else {

            DVDDAO sql = new DVDDAO(con);
            int cod = Integer.parseInt(pesquisa);
            if (sql.TestarDVD(cod) == false) {
                JOptionPane.showMessageDialog(null, "Código do DVD não Encontrado!", "Video Locadora", JOptionPane.ERROR_MESSAGE);

                iptCodDvd.setText("");
                iptTitulo.setText("");
                iptValor.setText("");
                iptCategoria.setText("");
                iptClassificacao.setText("");

                iptCodCliente.setText("");
            } else {
                if (sql.TestarSituacao(cod) == false) {
                    JOptionPane.showMessageDialog(null, "O DVD de Código (" + cod + ") já está alugado!", "Video Locadora", JOptionPane.INFORMATION_MESSAGE);

                    iptCodDvd.setText("");
                    iptTitulo.setText("");
                    iptValor.setText("");
                    iptCategoria.setText("");
                    iptClassificacao.setText("");

                    iptCodCliente.setText("");

                } else {
                    InserirDados(cod);
                }
            }
        }
        Conexao.FecharConexao(con);
    }//GEN-LAST:event_btnOKActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        Connection con = Conexao.AbrirConexao();
        ClienteDAO sql = new ClienteDAO(con);

        List<Cliente> lista = new ArrayList<>();
        String nome = combo.getSelectedItem().toString();

        lista = sql.ConsultaCodigoCliente(nome);

        for (Cliente b : lista) {
            int a = b.getCodigo();
            iptCodCliente.setText("" + a);
        }

        Conexao.FecharConexao(con);
    }//GEN-LAST:event_comboActionPerformed

    private void btnAlugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarActionPerformed
        String dvd = iptCodDvd.getText();
        String cliente = iptCodCliente.getText();
        String horario = iptHora.getText();
        String aluguel = iptData.getText();

        if (dvd.equals("") || cliente.equals("") || iptDevolucao.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Nenhum Campo pode estar Vazio!", "Video Locadora", JOptionPane.WARNING_MESSAGE);

        } else {
            String devolucao = new SimpleDateFormat("dd/MM/yyyy").format(iptDevolucao.getDate());

            Connection con = Conexao.AbrirConexao();

            AluguelDAO sql = new AluguelDAO(con);
            int coddvd = Integer.parseInt(dvd);
            String codcli = cliente;

            Aluguel a = new Aluguel();

            a.setCoddvd(coddvd);
            a.setCodcliente(codcli);
            a.setHorario(horario);
            a.setData_aluguel(aluguel);
            a.setData_devolucao(devolucao);
            a.setCodfunc(logado.getCod());

            String res = sql.Inserir_Aluguel(a);
            System.out.println(res);

            if (res.equals("Inserido com Sucesso!")) {
                String situacao = "Emprestado";

                JOptionPane.showMessageDialog(null, "Locação realizada com Sucesso!", "Video Locadora", JOptionPane.INFORMATION_MESSAGE);

                sql.AtualizarSituacao(situacao, coddvd);
            }
            Conexao.FecharConexao(con);
            dispose();

        }

    }//GEN-LAST:event_btnAlugarActionPerformed

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        AtualizaTable();
    }//GEN-LAST:event_btnTodosActionPerformed

    private void btnBuscaCodAluguelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaCodAluguelActionPerformed
        BuscaCodAluguel();
        buscaCodAluguel.setText("");
    }//GEN-LAST:event_btnBuscaCodAluguelActionPerformed

    private void btnBuscaCodDvdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaCodDvdActionPerformed
        BuscaCodDVD();
        buscaCodDvd.setText("");
    }//GEN-LAST:event_btnBuscaCodDvdActionPerformed

    private void btnBuscaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaNomeActionPerformed
        BuscaNomeCliente();
        buscaNome.setText("");
    }//GEN-LAST:event_btnBuscaNomeActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        iptCodDvd.setText("");
        iptTitulo.setText("");
        iptValor.setText("");
        iptCategoria.setText("");
        iptClassificacao.setText("");
        iptDevolucao.setDate(null);
        iptCodCliente.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

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
            java.util.logging.Logger.getLogger(ControleLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleLocacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlugar;
    private javax.swing.JButton btnBuscaCodAluguel;
    private javax.swing.JButton btnBuscaCodDvd;
    private javax.swing.JButton btnBuscaNome;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnTodos;
    private javax.swing.JTextField buscaCodAluguel;
    private javax.swing.JTextField buscaCodDvd;
    private javax.swing.JTextField buscaNome;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel fotoCapa;
    private javax.swing.JTextField iptCategoria;
    private javax.swing.JTextField iptClassificacao;
    private javax.swing.JTextField iptCodCliente;
    private javax.swing.JTextField iptCodDvd;
    private javax.swing.JTextField iptData;
    private com.toedter.calendar.JDateChooser iptDevolucao;
    private javax.swing.JTextField iptHora;
    private javax.swing.JTextField iptTitulo;
    private javax.swing.JTextField iptValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
