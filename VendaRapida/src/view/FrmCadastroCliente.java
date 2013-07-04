/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClienteController;
import controller.impl.ClienteControllerImpl;
import controller.impl.RegraNegocioException;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import model.Cliente;

/**
 *
 * @author Maicon
 */
public class FrmCadastroCliente extends javax.swing.JDialog {

    private ClienteController clienteController = new ClienteControllerImpl();

    /**
     * Creates new form FrmCadastroCliente
     */
    public FrmCadastroCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        edEndereco = new javax.swing.JTextField();
        edNome = new javax.swing.JTextField();
        btExcluir = new javax.swing.JButton();
        lbCodigo = new javax.swing.JLabel();
        edCodigo = new javax.swing.JTextField();
        edCpfCnpj = new javax.swing.JTextField();
        lbCpfCnpj = new javax.swing.JLabel();
        lbNovoFornecedor = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lbContato = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        edTelefone = new javax.swing.JTextField();
        btLimpar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        btOk = new javax.swing.JButton();
        edEmail = new javax.swing.JTextField();
        lbTelefone = new javax.swing.JLabel();
        lbEndereco = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Clientes");
        setResizable(false);

        edEndereco.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N

        edNome.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove-icon.png"))); // NOI18N
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        lbCodigo.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lbCodigo.setText("Código:");

        edCodigo.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        edCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edCodigoActionPerformed(evt);
            }
        });
        edCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                edCodigoFocusLost(evt);
            }
        });

        edCpfCnpj.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N

        lbCpfCnpj.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lbCpfCnpj.setText("CPF/CNPJ:");

        lbNovoFornecedor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNovoFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/passageiros.png"))); // NOI18N
        lbNovoFornecedor.setText("Cadastro de Cliente");

        lbEmail.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lbEmail.setText("E-mail:");

        lbContato.setText("Contato:");

        lbNome.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lbNome.setText("Nome:");
        lbNome.setName(""); // NOI18N

        edTelefone.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        edTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edTelefoneActionPerformed(evt);
            }
        });

        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpar.png"))); // NOI18N
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });
        btLimpar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btLimparKeyPressed(evt);
            }
        });

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_16.png"))); // NOI18N
        btPesquisar.setToolTipText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        btOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirma.png"))); // NOI18N
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });
        btOk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btOkKeyPressed(evt);
            }
        });

        edEmail.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N

        lbTelefone.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lbTelefone.setText("Telefone:");

        lbEndereco.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lbEndereco.setText("Endereço:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btOk, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lbContato))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbNovoFornecedor))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbCpfCnpj)
                            .addComponent(lbNome)
                            .addComponent(lbCodigo)
                            .addComponent(lbEmail)
                            .addComponent(lbTelefone)
                            .addComponent(lbEndereco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edTelefone)
                            .addComponent(edEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(edCpfCnpj, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(edEndereco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(edCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(edNome))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNovoFornecedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edCodigo)
                        .addComponent(lbCodigo))
                    .addComponent(btPesquisar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edNome)
                    .addComponent(lbNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCpfCnpj))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEndereco))
                .addGap(18, 18, 18)
                .addComponent(lbContato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEmail))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTelefone))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(btOk);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        try {
            int excluir = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este cliente?", "Excluir", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (excluir == JOptionPane.OK_OPTION) {
                clienteController.excluir(Integer.parseInt(edCodigo.getText()));
                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                limpar();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void edCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edCodigoActionPerformed

    private void edCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edCodigoFocusLost
        if (edCodigo.getText().isEmpty()) {
            try {
                edCodigo.setText(String.valueOf(clienteController.incrementar()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
            edCodigo.setEnabled(false);
        } else {
            pesquisar(Integer.parseInt(edCodigo.getText()));
        }
    }//GEN-LAST:event_edCodigoFocusLost

    private void edTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edTelefoneActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btLimparActionPerformed

    private void limpar() {
        edCodigo.setText("");
        edNome.setText("");
        edCpfCnpj.setText("");
        edEndereco.setText("");
        edEmail.setText("");
        edTelefone.setText("");
        edCodigo.requestFocus();
        edCodigo.setEnabled(true);
    }
    private void btLimparKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btLimparKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
//        btLimparActionPerformed(null);
    }//GEN-LAST:event_btLimparKeyPressed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        carregarTransacao();
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void carregarTransacao(){
        try {
            Cliente cliente = new Cliente();            
            new FrmConsultaCliente((Frame) this.getParent(), true, cliente).setVisible(true);                        
            pesquisar(cliente.getId());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    private void pesquisar(int id) {
        try {
            Cliente cliente = clienteController.buscar(id);
            if (cliente == null)
                throw new RegraNegocioException("Cliente não encontrado");
            edCodigo.setText(cliente.getId() + "");
            edNome.setText(cliente.getNome());
            edCpfCnpj.setText(cliente.getCpfCnpj());
            edEndereco.setText(cliente.getEndereco());
            edEmail.setText(cliente.getEmail());
            edTelefone.setText(cliente.getTelefone());
            edCodigo.setEnabled(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed
        try {
            int id = Integer.parseInt(edCodigo.getText());
            Cliente cliente = new Cliente();
            cliente.setId(id);
            cliente.setNome(edNome.getText());
            cliente.setCpfCnpj(edCpfCnpj.getText());
            cliente.setEndereco(edEndereco.getText());
            cliente.setEmail(edEmail.getText());
            cliente.setTelefone(edTelefone.getText());
            Cliente clienteAux = null;
            try {
                clienteAux = clienteController.buscar(id);
            } catch (Exception ex) {
            }
            if (clienteAux == null) {
                clienteController.salvar(cliente);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                clienteController.editar(cliente);
                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }

            limpar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btOkActionPerformed

    private void btOkKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btOkKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btOkActionPerformed(null);
        }
    }//GEN-LAST:event_btOkKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btOk;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JTextField edCodigo;
    private javax.swing.JTextField edCpfCnpj;
    private javax.swing.JTextField edEmail;
    private javax.swing.JTextField edEndereco;
    private javax.swing.JTextField edNome;
    private javax.swing.JTextField edTelefone;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbContato;
    private javax.swing.JLabel lbCpfCnpj;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEndereco;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNovoFornecedor;
    private javax.swing.JLabel lbTelefone;
    // End of variables declaration//GEN-END:variables
}