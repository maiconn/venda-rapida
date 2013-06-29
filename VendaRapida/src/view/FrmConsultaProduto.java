package view;

import controller.ProdutoController;
import controller.dao.util.StringUtil;
import controller.impl.ProdutoControllerImpl;
import controller.impl.RegraNegocioException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Produto;
import net.sf.jasperreports.engine.JRException;
import view.util.ViewUtil;
import view.util.ViewUtil.GeradorNomePDF;

public class FrmConsultaProduto extends javax.swing.JDialog {

    private DefaultTableModel dtm;
    private Produto produto;
    private Produto produtoSelecionado;
    private List<Produto> listaProdutosBuscados;
    private ProdutoController produtoController = new ProdutoControllerImpl();

    public FrmConsultaProduto(java.awt.Frame parent, boolean modal, Produto produtoSelecionado) {
        super(parent, modal);
        this.produtoSelecionado = produtoSelecionado;
        listaProdutosBuscados = new ArrayList<Produto>();
        initComponents();
    }

    public void carregarProduto() {
        produto = new Produto();
        if (!edDescricao.getText().isEmpty()) {
            produto.setDescricao(edDescricao.getText());
        }
        try {
            double valorInicial = StringUtil.getValorR$(edValorInicial.getText());
            double valorFinal = StringUtil.getValorR$(edValorFinal.getText());
            if (!edValorInicial.getText().isEmpty()) {
                produto.setValor(valorInicial);
            }
            try {
                listaProdutosBuscados = produtoController.listar(produto, valorFinal);
                carregarGrid();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Valor inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void carregarGrid() {
        Vector<Vector> dados = new Vector<Vector>();

        for (Produto produto : listaProdutosBuscados) {
            Vector registroDb = new Vector();

            registroDb.add(produto.getReferencia());
            registroDb.add(produto.getCodigoBarrra());
            registroDb.add(produto.getDescricao());
            registroDb.add(StringUtil.getR$FormmatedFromDouble(produto.getValor()));

            dados.add(registroDb);
        }

        dtm = (DefaultTableModel) tabelaConsulta.getModel();
        dtm.setRowCount(0);

        for (Vector v : dados) {
            dtm.addRow(v);
        }
    }

    public void carregarEdicao() {
        try {
            if (tabelaConsulta.getSelectedRow() != -1) {
                setProdutoRetorno(listaProdutosBuscados.get(tabelaConsulta.getSelectedRow()));
                //telaPrincipal.editarCampos(transacaoSelecionada);
                this.dispose();
            } else {
                throw new RegraNegocioException("Favor selecionar um Produto.");
            }
        } catch (RegraNegocioException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setProdutoRetorno(Produto produto) {
        produtoSelecionado.setCodigoBarrra(produto.getCodigoBarrra());
        produtoSelecionado.setDescricao(produto.getDescricao());
        produtoSelecionado.setReferencia(produto.getReferencia());
        produtoSelecionado.setValor(produto.getValor());
    }

    private void limpar() {
        edDescricao.setText("");
        edValorFinal.setText("9999999999,99");
        edValorInicial.setText("0,00");
        listaProdutosBuscados = new ArrayList<Produto>();

        dtm = new DefaultTableModel();
        dtm = (DefaultTableModel) tabelaConsulta.getModel();

        dtm.setRowCount(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cadastroAluno = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaConsulta = new javax.swing.JTable();
        btConfirma = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        onibus = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        edDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        edValorInicial = new javax.swing.JFormattedTextField();
        edValorFinal = new javax.swing.JFormattedTextField();
        btGerarPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cadastroAluno.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        cadastroAluno.setText("Consulta de Produtos");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelaConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Referência", "Código de Barras", "Descrição", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaConsulta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaConsultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaConsulta);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
        );

        btConfirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirma.png"))); // NOI18N
        btConfirma.setToolTipText("Confirma");
        btConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmaActionPerformed(evt);
            }
        });

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sair.png"))); // NOI18N
        btSair.setToolTipText("Cancelar");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        btSair.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btSairKeyPressed(evt);
            }
        });

        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpar.png"))); // NOI18N
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-icon.png"))); // NOI18N
        btPesquisar.setToolTipText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        onibus.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        onibus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/product-icon.png"))); // NOI18N

        jLabel1.setText("Descrição:");

        jLabel2.setText("Valor Inicial:");

        jLabel3.setText("Valor Final:");

        edValorInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        edValorInicial.setText("0,00");
        edValorInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                edValorInicialFocusLost(evt);
            }
        });

        edValorFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        edValorFinal.setText("9999999999,99");
        edValorFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                edValorFinalFocusLost(evt);
            }
        });

        btGerarPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf_file.png"))); // NOI18N
        btGerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerarPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(onibus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cadastroAluno))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edValorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edValorFinal))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btSair)
                            .addComponent(btPesquisar)
                            .addComponent(btConfirma)
                            .addComponent(btLimpar)
                            .addComponent(btGerarPDF))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(cadastroAluno))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(onibus)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(edDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(edValorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edValorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btConfirma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btGerarPDF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmaActionPerformed
        carregarEdicao();
    }//GEN-LAST:event_btConfirmaActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btSairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btSairKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSairKeyPressed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btLimparActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        carregarProduto();
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void edValorFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edValorFinalFocusLost
        if (edValorFinal.getText().equals("")) {
            edValorFinal.setText("9999999999,99");
        }
    }//GEN-LAST:event_edValorFinalFocusLost

    private void edValorInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edValorInicialFocusLost
        if (edValorInicial.getText().equals("")) {
            edValorInicial.setText("0,00");
        }
    }//GEN-LAST:event_edValorInicialFocusLost

    private void btGerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerarPDFActionPerformed
        if (!listaProdutosBuscados.isEmpty()) {
            try {
                String path = null;
                try {
                    path = ViewUtil.createFileChooserToSavePDF(this, GeradorNomePDF.PRODUTOS);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
                if (path != null) {
                    produtoController.gerarRelatorio(listaProdutosBuscados, path);
                    int abrir = JOptionPane.showConfirmDialog(null, "PDF Gerado Com Sucesso em '" + path + "'. \nDeseja abrí-lo?", "Sucesso", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (abrir == JOptionPane.OK_OPTION) {
                        java.awt.Desktop.getDesktop().open(new File(path));
                    }
                }
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório, causa: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo, causa: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Necessita-se ao menos de um registro para gerar o PDF.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btGerarPDFActionPerformed

    private void tabelaConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaConsultaMouseClicked
        if (evt.getClickCount() == 2) {
            carregarEdicao();
        }
    }//GEN-LAST:event_tabelaConsultaMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirma;
    private javax.swing.JButton btGerarPDF;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel cadastroAluno;
    private javax.swing.JTextField edDescricao;
    private javax.swing.JFormattedTextField edValorFinal;
    private javax.swing.JFormattedTextField edValorInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel onibus;
    private javax.swing.JTable tabelaConsulta;
    // End of variables declaration//GEN-END:variables
}
