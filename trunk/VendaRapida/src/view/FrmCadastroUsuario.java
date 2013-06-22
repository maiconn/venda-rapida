package view;

import controller.UsuarioController;
import controller.impl.RegraNegocioException;
import controller.impl.UsuarioControllerImpl;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Sessao;
import model.Usuario;

public class FrmCadastroUsuario extends javax.swing.JDialog {
    
    UsuarioController usuarioController = new UsuarioControllerImpl();
    Sessao sessao = Sessao.getInstance();

    /**
     * Creates new form FrmCadastroUsuario
     */
    public FrmCadastroUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNome = new javax.swing.JLabel();
        cbCadastraProduto = new javax.swing.JCheckBox();
        lbNovoUsuario = new javax.swing.JLabel();
        cbVendeProduto = new javax.swing.JCheckBox();
        lbLogin = new javax.swing.JLabel();
        cbAdministrador = new javax.swing.JCheckBox();
        edNome = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        edLogin = new javax.swing.JTextField();
        btOk = new javax.swing.JButton();
        lbSenha = new javax.swing.JLabel();
        btLimpar = new javax.swing.JButton();
        edSenha = new javax.swing.JPasswordField();
        lbConfirmarSenha = new javax.swing.JLabel();
        edConfirmarSenha = new javax.swing.JPasswordField();
        lbComissao = new javax.swing.JLabel();
        edComissao = new javax.swing.JTextField();
        btExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbNome.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lbNome.setText("Nome:");
        lbNome.setName(""); // NOI18N

        cbCadastraProduto.setText("Cadastra Produto");

        lbNovoUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNovoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cadastroCliente.png"))); // NOI18N
        lbNovoUsuario.setText("Cadastro de Usuários");

        cbVendeProduto.setText("Vende produto");

        lbLogin.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lbLogin.setText("Login:");

        cbAdministrador.setText("Administrador");

        edNome.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-icon.png"))); // NOI18N
        btPesquisar.setToolTipText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        edLogin.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        edLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                edLoginFocusLost(evt);
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

        lbSenha.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lbSenha.setText("Senha:");

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

        edSenha.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N

        lbConfirmarSenha.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lbConfirmarSenha.setText("Confirmar Senha:");

        edConfirmarSenha.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N

        lbComissao.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lbComissao.setText("Comissão (%):");

        edComissao.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove-icon.png"))); // NOI18N
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        btExcluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btExcluirKeyPressed(evt);
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
                        .addComponent(lbNovoUsuario)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cbAdministrador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbVendeProduto)
                                .addGap(12, 12, 12)
                                .addComponent(cbCadastraProduto))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btOk, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbSenha)
                            .addComponent(lbConfirmarSenha)
                            .addComponent(lbComissao)
                            .addComponent(lbNome)
                            .addComponent(lbLogin))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edComissao, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edNome, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(edLogin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNovoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbLogin)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbConfirmarSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edComissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbComissao))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAdministrador)
                    .addComponent(cbVendeProduto)
                    .addComponent(cbCadastraProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btOk)
                    .addComponent(btLimpar)
                    .addComponent(btExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getRootPane().setDefaultButton(btOk);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        pesquisar();
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void pesquisar() {
        if (edLogin.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Pesquisa específica em construção");
        } else {
            try {
                Usuario usuario = usuarioController.buscar(edLogin.getText());
                if (usuario != null) {
                    edLogin.setText(usuario.getLogin());
                    edLogin.setEditable(false);
                    edNome.setText(usuario.getNome());
                    edSenha.setText("");
                    edConfirmarSenha.setText("");
                    edComissao.setText(String.valueOf(usuario.getComissao()));
                    if (sessao.getUsuario().getLogin().equals(usuario.getLogin()))
                        cbAdministrador.setEnabled(false);
                    cbAdministrador.setSelected(usuario.isAdministrador());
                    cbCadastraProduto.setSelected(usuario.isCadastraProduto());
                    cbVendeProduto.setSelected(usuario.isVendeProduto());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed
        try {
            Usuario usuario = new Usuario();
            usuario.setNome(edNome.getText());
            usuario.setLogin(edLogin.getText());
            usuario.setSenha(new String(edSenha.getPassword()));

            //Tava dando erro "empty String" quando deixava o campo comissão vazio.
            if (edComissao.getText().trim().equals(""))
                usuario.setComissao(0);
            else
                usuario.setComissao(Double.parseDouble(edComissao.getText()));
            
            usuario.setAdministrador(cbAdministrador.isSelected());
            usuario.setVendeProduto(cbVendeProduto.isSelected());
            usuario.setCadastraProduto(cbCadastraProduto.isSelected());
            
            Usuario usuarioAux = usuarioController.buscar(edLogin.getText());
            if (usuarioAux == null) {
                usuarioController.salvar(usuario, new String(edConfirmarSenha.getPassword()));
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                usuarioController.editar(usuario, new String(edConfirmarSenha.getPassword()));
                JOptionPane.showMessageDialog(null, "Usuário editado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
            
            limpar();
            edNome.requestFocus();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btOkActionPerformed

    private void btOkKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btOkKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        btOkActionPerformed(null);
    }//GEN-LAST:event_btOkKeyPressed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btLimparActionPerformed

    private void btLimparKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btLimparKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        btLimparActionPerformed(null);
    }//GEN-LAST:event_btLimparKeyPressed

    private void edLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edLoginFocusLost
        pesquisar();
    }//GEN-LAST:event_edLoginFocusLost

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        try {
            usuarioController.excluir(edLogin.getText());
            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        limpar();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btExcluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btExcluirKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btExcluirKeyPressed

    private void limpar() {
        edNome.setText("");
        edLogin.setText("");
        edSenha.setText("");
        edConfirmarSenha.setText("");
        edComissao.setText("");
        cbAdministrador.setSelected(false);
        cbVendeProduto.setSelected(false);
        cbCadastraProduto.setSelected(false);
        edLogin.setEditable(true);
        cbAdministrador.setEnabled(true);
        edLogin.requestFocus();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btOk;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JCheckBox cbAdministrador;
    private javax.swing.JCheckBox cbCadastraProduto;
    private javax.swing.JCheckBox cbVendeProduto;
    private javax.swing.JTextField edComissao;
    private javax.swing.JPasswordField edConfirmarSenha;
    private javax.swing.JTextField edLogin;
    private javax.swing.JTextField edNome;
    private javax.swing.JPasswordField edSenha;
    private javax.swing.JLabel lbComissao;
    private javax.swing.JLabel lbConfirmarSenha;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNovoUsuario;
    private javax.swing.JLabel lbSenha;
    // End of variables declaration//GEN-END:variables
}