/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ProdutoController;
import controller.dao.util.StringUtil;
import controller.impl.ProdutoControllerImpl;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import model.Item;
import model.Produto;
import view.util.ThreadLimpaComponentesFrmConsultaPreco;

/**
 *
 * @author reinoldo
 */
public class FrmConsultaPreco extends javax.swing.JDialog {

    private ProdutoController produtoController = new ProdutoControllerImpl();
    private Produto produto;
    ThreadLimpaComponentesFrmConsultaPreco threadLimpaComponentesFrmConsultaPreco;

    /**
     * Creates new form FrmConsultaPreco
     */
    public FrmConsultaPreco(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F10"), "checkout");
        getRootPane().getActionMap().put("checkout", new AbstractAction("checkout") {
            // The next two lines should be in one line              
            public void actionPerformed(ActionEvent evt) {
                if (btSimula.isEnabled()) {
                    btSimulaActionPerformed(evt);
                }
            }
        });

        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F11"), "plussCount");
        getRootPane().getActionMap().put("plussCount", new AbstractAction("plussCount") {
            // The next two lines should be in one line              
            public void actionPerformed(ActionEvent evt) {
                btMaisActionPerformed(evt);
            }
        });

        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F12"), "minusCount");
        getRootPane().getActionMap().put("minusCount", new AbstractAction("minusCount") {
            // The next two lines should be in one line              
            public void actionPerformed(ActionEvent evt) {
                btMenosActionPerformed(evt);
            }
        });
        threadLimpaComponentesFrmConsultaPreco = new ThreadLimpaComponentesFrmConsultaPreco(this);

    }

    private void buscar() {
        try {
            produto = new Produto();
            produto.setCodigoBarrra(edCodigoBarras.getText());
            produto = produtoController.buscarCodigoBarras(produto.getCodigoBarrra());
            if (produto != null) {
                edCodigoBarras.setText(produto.getCodigoBarrra());
                lbDescricao.setText(produto.getDescricao());
                calcular(0);
            } else {
                lbDescricao.setText("Produto não encontrado!");
                edCodigoBarras.setText("");
                edPrecoTotal.setText(StringUtil.getR$FormmatedFromDouble(0.0));
                edCodigoBarras.requestFocus(true);
            }
            contarTempoLimpar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void contarTempoLimpar() {
        threadLimpaComponentesFrmConsultaPreco.interrupt();
        threadLimpaComponentesFrmConsultaPreco = new ThreadLimpaComponentesFrmConsultaPreco(this);
        threadLimpaComponentesFrmConsultaPreco.start();
    }

    private void calcular(int quantidade) {
        int i = Integer.parseInt(edQuantidade.getText()) + quantidade;
        if (i > 0) {
            edQuantidade.setText(String.valueOf(i));
            double valor = 0;
            if (produto != null) {
                valor = (i * produto.getValor());
            }

            edPrecoTotal.setText(StringUtil.getR$FormmatedFromDouble(valor));
        } /*else {
         JOptionPane.showMessageDialog(null, "A Quantidade não pode ser menor que 1(um)!", "Erro", JOptionPane.ERROR_MESSAGE);
         edQuantidade.setText("1");
         }*/
    }

    public void limpar() {
        edCodigoBarras.setText("");
        edPrecoTotal.setText("0,00");
        edQuantidade.setText("1");
        lbDescricao.setText("Descrição do produto");
        produto = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbHeader = new javax.swing.JLabel();
        lbCodigoBarras = new javax.swing.JLabel();
        btSimula = new javax.swing.JButton();
        lbDescricao = new javax.swing.JLabel();
        lbQuantidade = new javax.swing.JLabel();
        btMais = new javax.swing.JButton();
        btMenos = new javax.swing.JButton();
        lbPrecoTotal = new javax.swing.JLabel();
        edCodigoBarras = new javax.swing.JTextField();
        edPrecoTotal = new javax.swing.JTextField();
        edQuantidade = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Preços");
        setResizable(false);

        lbHeader.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        lbHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cifrao.png"))); // NOI18N
        lbHeader.setText("Consulta de Preços");
        lbHeader.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lbHeaderKeyTyped(evt);
            }
        });

        lbCodigoBarras.setText("Código de barras");

        btSimula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/shopping_cart.png"))); // NOI18N
        btSimula.setText("Simulação de Venda");
        btSimula.setAlignmentY(0.0F);
        btSimula.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btSimula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimulaActionPerformed(evt);
            }
        });

        lbDescricao.setBackground(java.awt.SystemColor.activeCaption);
        lbDescricao.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        lbDescricao.setForeground(java.awt.SystemColor.activeCaption);
        lbDescricao.setText("Descrição do produto");

        lbQuantidade.setText("Quantidade");

        btMais.setText("+");
        btMais.setPreferredSize(new java.awt.Dimension(35, 35));
        btMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMaisActionPerformed(evt);
            }
        });
        btMais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btMaisKeyTyped(evt);
            }
        });

        btMenos.setText("-");
        btMenos.setPreferredSize(new java.awt.Dimension(35, 35));
        btMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenosActionPerformed(evt);
            }
        });

        lbPrecoTotal.setText("Preço total");

        edCodigoBarras.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        edCodigoBarras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                edCodigoBarrasFocusLost(evt);
            }
        });
        edCodigoBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edCodigoBarrasKeyPressed(evt);
            }
        });

        edPrecoTotal.setEditable(false);
        edPrecoTotal.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        edPrecoTotal.setText("0,00");

        edQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        edQuantidade.setText("1");
        edQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                edQuantidadeFocusLost(evt);
            }
        });
        edQuantidade.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                edQuantidadePropertyChange(evt);
            }
        });
        edQuantidade.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                edQuantidadeInputMethodTextChanged(evt);
            }
        });
        edQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edQuantidadeKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(edQuantidade, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btMais, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSimula, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbCodigoBarras)
                        .addGap(7, 7, 7)
                        .addComponent(edCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDescricao))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbQuantidade)
                        .addGap(7, 7, 7)
                        .addComponent(edQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btMenos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btMais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbPrecoTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSimula, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btMaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMaisActionPerformed
        calcular(1);
        contarTempoLimpar();
    }//GEN-LAST:event_btMaisActionPerformed

    private void btMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenosActionPerformed
        calcular(-1);
        contarTempoLimpar();
    }//GEN-LAST:event_btMenosActionPerformed

    private void edCodigoBarrasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edCodigoBarrasFocusLost
        buscar();
    }//GEN-LAST:event_edCodigoBarrasFocusLost

    private void edQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edQuantidadeFocusLost
        if (edQuantidade.getText().isEmpty()) {
            edQuantidade.setText("1");
        }
        calcular(0);
    }//GEN-LAST:event_edQuantidadeFocusLost

    private void lbHeaderKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbHeaderKeyTyped
    }//GEN-LAST:event_lbHeaderKeyTyped

    private void btMaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btMaisKeyTyped
    }//GEN-LAST:event_btMaisKeyTyped

    private void btSimulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimulaActionPerformed
        int qtd = Integer.parseInt(edQuantidade.getText());
        if (produto == null) {
            new FrmSimulacaoVenda((Frame) getParent(), true, true).setVisible(true);
        } else {
            Item item = new Item(produto, qtd);
            new FrmSimulacaoVenda((Frame) getParent(), true, item).setVisible(true);
        }
    }//GEN-LAST:event_btSimulaActionPerformed

    private void edCodigoBarrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edCodigoBarrasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            edQuantidade.setText("1");
            buscar();
            edCodigoBarras.selectAll();
        }
    }//GEN-LAST:event_edCodigoBarrasKeyPressed

    private void edQuantidadeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_edQuantidadeInputMethodTextChanged
    }//GEN-LAST:event_edQuantidadeInputMethodTextChanged

    private void edQuantidadePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_edQuantidadePropertyChange
    }//GEN-LAST:event_edQuantidadePropertyChange

    private void edQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edQuantidadeKeyPressed
        contarTempoLimpar();
    }//GEN-LAST:event_edQuantidadeKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMais;
    private javax.swing.JButton btMenos;
    private javax.swing.JButton btSimula;
    private javax.swing.JTextField edCodigoBarras;
    private javax.swing.JTextField edPrecoTotal;
    private javax.swing.JFormattedTextField edQuantidade;
    private javax.swing.JLabel lbCodigoBarras;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbHeader;
    private javax.swing.JLabel lbPrecoTotal;
    private javax.swing.JLabel lbQuantidade;
    // End of variables declaration//GEN-END:variables
}
