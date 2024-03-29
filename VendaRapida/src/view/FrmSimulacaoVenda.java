/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClienteController;
import controller.ProdutoController;
import controller.VendaController;
import controller.dao.util.StringUtil;
import controller.impl.ClienteControllerImpl;
import controller.impl.ProdutoControllerImpl;
import controller.impl.RegraNegocioException;
import controller.impl.VendaControllerImpl;
import controller.relatorio.ComposicaoRelatorio;
import controller.relatorio.TipoRelatorio;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Item;
import model.Produto;
import model.Sessao;
import model.Venda;
import model.Venda.TipoDesconto;

/**
 *
 * @author Maicon
 */
public class FrmSimulacaoVenda extends javax.swing.JDialog {

    private DefaultTableModel dtm;
    private ProdutoController produtoController = new ProdutoControllerImpl();
    private ClienteController clienteController = new ClienteControllerImpl();
    private VendaController vendaController = new VendaControllerImpl();
    private Venda venda;
    private Produto produtoSelecionado;

    /**
     * Creates new form FrmSimulacaoVenda
     */
    public FrmSimulacaoVenda(java.awt.Frame parent, boolean modal, Item item) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        if (!Sessao.getInstance().getUsuario().isVendeProduto()) {
            btnFinalizarVenda.setVisible(false);
        }
        venda = new Venda();
        try {
            venda.setCodigoVenda(vendaController.incrementar());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        produtoSelecionado = new Produto();
        lbDescricaoItem.setText(" ");
        lbNomeCliente.setText(" ");
        venda.addItem(item);
        atualizaTela();
    }

    public FrmSimulacaoVenda(java.awt.Frame parent, boolean modal, boolean simular) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        if (!Sessao.getInstance().getUsuario().isVendeProduto()) {
            btnFinalizarVenda.setVisible(false);
        } else if (!simular) {
            setTitle("Efetuar Venda");
            jLabel7.setText("Efetuar Venda");
        }
        venda = new Venda();
        try {
            venda.setCodigoVenda(vendaController.incrementar());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        produtoSelecionado = new Produto();
        lbDescricaoItem.setText(" ");
        lbNomeCliente.setText(" ");
        atualizaTela();
    }

    private void atualizaTela() {
        carregarGrid();
        txtQtdeItens.setText(venda.getQuantidadeItens() + "");
        try {
            atualizaValorTotal();
        } catch (RegraNegocioException ex) {
            txtDesconto.setText("0,00");
            venda.setDesconto(0);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizaValorTotal() throws RegraNegocioException {
        TipoDesconto tipo = cbTipoDesconto.getSelectedIndex() == 0 ? TipoDesconto.PORCENTAGEM : TipoDesconto.DINHEIRO;
        venda.setDesconto(tipo, StringUtil.getValorR$(txtDesconto.getText()));
        txtValorTotal.setText(StringUtil.getR$FormmatedFromDouble(venda.getValorTotalComDesconto()));
    }

    public void atualizaItem(Produto produto) {
        produtoSelecionado = produto;
        lbDescricaoItem.setText(produtoSelecionado.getDescricao());
        txtCodigoBarras.setText(produtoSelecionado.getCodigoBarrra());
    }

    public void limparTudo() {
        venda = new Venda();
        try {
            venda.setCodigoVenda(vendaController.incrementar());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        produtoSelecionado = new Produto();
        lbDescricaoItem.setText(" ");
        lbNomeCliente.setText(" ");
        txtCodigoCliente.setText("");
        txtQuantidadeItem.setText("1");
        txtDesconto.setText("0,00");
        cbTipoDesconto.setSelectedIndex(0);
        atualizaItem(produtoSelecionado);
        atualizaTela();
    }

    private void carregarGrid() {
        Vector<Vector> dados = new Vector<Vector>();
        for (Item item : venda.getItems()) {
            Vector registroDb = new Vector();
            registroDb.add(item.getProduto().getReferencia());
            registroDb.add(item.getProduto().getCodigoBarrra());
            registroDb.add(item.getProduto().getDescricao());
            registroDb.add(item.getValor());
            registroDb.add(item.getQuantidade());
            dados.add(registroDb);
        }

        dtm = (DefaultTableModel) tabela.getModel();
        dtm.setRowCount(0);

        for (Vector v : dados) {
            dtm.addRow(v);
        }
    }

    public void perguntarGerarPDFVenda() throws Exception {
        int gerarPDF = JOptionPane.showConfirmDialog(null, "Venda realizada com sucesso.\nDeseja gerar um relatorio da Venda?", "Sucesso", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (gerarPDF == JOptionPane.OK_OPTION) {
            List listaVenda = new ArrayList();
            listaVenda.add(venda);
            List listaRelatorio = vendaController.getListaVendaComItens(listaVenda);
            ComposicaoRelatorio composicao = new ComposicaoRelatorio(listaRelatorio, TipoRelatorio.VENDAS_COM_ITENS);

            new FrmGerarRelatorio((Frame) getParent(), true, composicao).setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFinalizarVenda = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnSubItem = new javax.swing.JButton();
        btnConsultaProdutos = new javax.swing.JButton();
        btnLimparVenda = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnAdicionarItem = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbDescricaoItem = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtQtdeItens = new javax.swing.JTextPane();
        btnAddItem = new javax.swing.JButton();
        btnRemoverItem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        cbTipoDesconto = new javax.swing.JComboBox();
        txtQuantidadeItem = new javax.swing.JFormattedTextField();
        txtDesconto = new javax.swing.JFormattedTextField();
        txtCodigoBarras = new javax.swing.JTextField();
        txtValorTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnConsultaClientes = new javax.swing.JButton();
        lbNomeCliente = new javax.swing.JLabel();
        txtCodigoCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Simulação de Venda");
        setResizable(false);

        btnFinalizarVenda.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        btnFinalizarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirma.png"))); // NOI18N
        btnFinalizarVenda.setText("Finalizar Venda");
        btnFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarVendaActionPerformed(evt);
            }
        });

        jLabel6.setText("Desconto");

        btnSubItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menos_icon.png"))); // NOI18N
        btnSubItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubItemActionPerformed(evt);
            }
        });

        btnConsultaProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_16.png"))); // NOI18N
        btnConsultaProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaProdutosActionPerformed(evt);
            }
        });

        btnLimparVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpar.png"))); // NOI18N
        btnLimparVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparVendaActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade");

        btnAdicionarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add_product.png"))); // NOI18N
        btnAdicionarItem.setText("Adicionar Item");
        btnAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarItemActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Valor total");

        jLabel5.setText("Qtde. Itens");

        lbDescricaoItem.setForeground(new java.awt.Color(0, 102, 102));
        lbDescricaoItem.setText("Descricao Produto");

        txtQtdeItens.setEditable(false);
        txtQtdeItens.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        txtQtdeItens.setText("1");
        txtQtdeItens.setFocusable(false);
        jScrollPane5.setViewportView(txtQtdeItens);

        btnAddItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mais_icon.png"))); // NOI18N
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        btnRemoverItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove-icon.png"))); // NOI18N
        btnRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverItemActionPerformed(evt);
            }
        });

        jLabel1.setText("Código de barras");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Referência", "Código de Barras", "Descrição", "Preço", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/venda.png"))); // NOI18N
        jLabel7.setText("Simulação de Venda");

        cbTipoDesconto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "%", "R$" }));
        cbTipoDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoDescontoActionPerformed(evt);
            }
        });

        txtQuantidadeItem.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtQuantidadeItem.setText("1");
        txtQuantidadeItem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtQuantidadeItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantidadeItemFocusLost(evt);
            }
        });

        txtDesconto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtDesconto.setText("0,00");
        txtDesconto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescontoFocusLost(evt);
            }
        });

        txtCodigoBarras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCodigoBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoBarrasActionPerformed(evt);
            }
        });
        txtCodigoBarras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoBarrasFocusLost(evt);
            }
        });
        txtCodigoBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoBarrasKeyPressed(evt);
            }
        });

        txtValorTotal.setEditable(false);
        txtValorTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtValorTotal.setFocusable(false);

        jLabel2.setText("Código do cliente");

        btnConsultaClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_16.png"))); // NOI18N
        btnConsultaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaClientesActionPerformed(evt);
            }
        });

        lbNomeCliente.setForeground(new java.awt.Color(0, 0, 102));
        lbNomeCliente.setText("NomeDoCliente");

        txtCodigoCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCodigoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoClienteFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNomeCliente)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnConsultaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnConsultaProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtQuantidadeItem, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAdicionarItem))
                                    .addComponent(lbDescricaoItem))
                                .addGap(6, 6, 6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnLimparVenda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(btnRemoverItem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(btnSubItem, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFinalizarVenda, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(135, 135, 135)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTipoDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConsultaProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtQuantidadeItem, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCodigoBarras)))
                    .addComponent(btnAdicionarItem)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConsultaClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodigoCliente))))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDescricaoItem)
                    .addComponent(lbNomeCliente))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSubItem, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoverItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimparVenda))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(txtDesconto)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbTipoDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinalizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubItemActionPerformed
        int itemSelecionado = tabela.getSelectedRow();
        if (itemSelecionado != -1) {
            int quantidade = venda.getItem(itemSelecionado).getQuantidade();
            if (quantidade - 1 > 0) {
                venda.getItem(itemSelecionado).setQuantidade(quantidade - 1);
            }
            atualizaTela();
            tabela.setRowSelectionInterval(itemSelecionado, itemSelecionado);
        }
    }//GEN-LAST:event_btnSubItemActionPerformed

    private void btnLimparVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparVendaActionPerformed
        limparTudo();
    }//GEN-LAST:event_btnLimparVendaActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        int itemSelecionado = tabela.getSelectedRow();
        if (itemSelecionado != -1) {
            int quantidade = venda.getItem(itemSelecionado).getQuantidade();
            venda.getItem(itemSelecionado).setQuantidade(quantidade + 1);
            atualizaTela();
            tabela.setRowSelectionInterval(itemSelecionado, itemSelecionado);
        }
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void btnRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverItemActionPerformed
        int itemSelecionado = tabela.getSelectedRow();
        if (itemSelecionado != -1) {
            venda.removerItem(itemSelecionado);
            atualizaTela();
        }
    }//GEN-LAST:event_btnRemoverItemActionPerformed

    private void cbTipoDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoDescontoActionPerformed
        int indexAtual = cbTipoDesconto.getSelectedIndex() == 1 ? 0 : 1;
        try {
            atualizaValorTotal();
        } catch (RegraNegocioException ex) {
            cbTipoDesconto.setSelectedIndex(indexAtual);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cbTipoDescontoActionPerformed

    private void txtQuantidadeItemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadeItemFocusLost
        try {
            if (Integer.parseInt(txtQuantidadeItem.getText()) < 1) {
                txtQuantidadeItem.setText("1");
            }
        } catch (NumberFormatException ex) {
            txtQuantidadeItem.setText("1");
        }
    }//GEN-LAST:event_txtQuantidadeItemFocusLost

    private void btnConsultaProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaProdutosActionPerformed
        Produto produto = new Produto();
        produto.setReferencia("");
        new FrmConsultaProduto((Frame) getParent(), rootPaneCheckingEnabled, produto).setVisible(true);
        if (!produto.getReferencia().isEmpty()) {
            atualizaItem(produto);
        }
    }//GEN-LAST:event_btnConsultaProdutosActionPerformed

    private void btnAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarItemActionPerformed
        if (!txtCodigoBarras.getText().trim().isEmpty()) {
            venda.addItem(new Item(produtoSelecionado, Integer.parseInt(txtQuantidadeItem.getText())));
            txtQuantidadeItem.setText("1");
            txtCodigoBarras.setText("");
            lbDescricaoItem.setText("");
            atualizaTela();
        }

    }//GEN-LAST:event_btnAdicionarItemActionPerformed

    private void txtDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescontoFocusLost
        try {
            double desconto = StringUtil.getValorR$(txtDesconto.getText());
            atualizaValorTotal();
        } catch (NumberFormatException ex) {
            txtDesconto.setText("0,00");
        } catch (RegraNegocioException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            txtDesconto.setText("0,00");
        }
    }//GEN-LAST:event_txtDescontoFocusLost

    private void buscarProdutoPeloCodigoBarra() {
        try {
            Produto prod = produtoController.buscarCodigoBarras(txtCodigoBarras.getText());
            if (prod != null) {
                atualizaItem(prod);
            } else {
                atualizaItem(new Produto());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void txtCodigoBarrasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoBarrasFocusLost
        buscarProdutoPeloCodigoBarra();
    }//GEN-LAST:event_txtCodigoBarrasFocusLost

    private void btnConsultaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaClientesActionPerformed
        Cliente cliente = new Cliente();
        cliente.setId(0);
        new FrmConsultaCliente((Frame) getParent(), rootPaneCheckingEnabled, cliente).setVisible(true);
        if (cliente.getId() != 0) {
            venda.setIdCliente(cliente.getId());
            txtCodigoCliente.setText(cliente.getId() + "");
            lbNomeCliente.setText(cliente.getNome());
        } else {
            venda.setIdCliente(0);
            txtCodigoCliente.setText("");
            lbNomeCliente.setText(" ");
        }
    }//GEN-LAST:event_btnConsultaClientesActionPerformed

    private void txtCodigoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoClienteFocusLost
        try {
            int codigoCliente = Integer.parseInt(txtCodigoCliente.getText());
            Cliente cliente = clienteController.buscar(codigoCliente);
            if (cliente != null) {
                venda.setIdCliente(cliente.getId());
                lbNomeCliente.setText(cliente.getNome());
            }
        } catch (NumberFormatException ex) {
            venda.setIdCliente(0);
            txtCodigoCliente.setText("");
            lbNomeCliente.setText(" ");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtCodigoClienteFocusLost

    private void btnFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarVendaActionPerformed
        try {
            venda.setDataVenda(new Date());
            venda.setCodigoPagSeguro("");
            venda.setLoginUsuario(Sessao.getInstance().getUsuario().getLogin());
            vendaController.salvar(venda);
            perguntarGerarPDFVenda();
            limparTudo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFinalizarVendaActionPerformed

    private void txtCodigoBarrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBarrasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarProdutoPeloCodigoBarra();
            btnAdicionarItemActionPerformed(null);
            txtCodigoBarras.selectAll();
        }
    }//GEN-LAST:event_txtCodigoBarrasKeyPressed

    private void txtCodigoBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoBarrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoBarrasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnAdicionarItem;
    private javax.swing.JButton btnConsultaClientes;
    private javax.swing.JButton btnConsultaProdutos;
    private javax.swing.JButton btnFinalizarVenda;
    private javax.swing.JButton btnLimparVenda;
    private javax.swing.JButton btnRemoverItem;
    private javax.swing.JButton btnSubItem;
    private javax.swing.JComboBox cbTipoDesconto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lbDescricaoItem;
    private javax.swing.JLabel lbNomeCliente;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtCodigoBarras;
    private javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JFormattedTextField txtDesconto;
    private javax.swing.JTextPane txtQtdeItens;
    private javax.swing.JFormattedTextField txtQuantidadeItem;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
