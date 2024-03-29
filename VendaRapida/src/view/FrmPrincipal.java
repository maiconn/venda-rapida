package view;

import java.awt.Image;
import java.awt.Toolkit;
import model.Sessao;
import model.Usuario;

public class FrmPrincipal extends javax.swing.JFrame {

    private Usuario usuarioLogado;

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        usuarioLogado = Sessao.getInstance().getUsuario();
        lbUsuario.setText(usuarioLogado.getNome());
        setLocationRelativeTo(null);
        Image image = Toolkit.getDefaultToolkit().getImage("src/img/vendaRapida02.png");
        setIconImage(image);
        configurarTela();
    }

    private void configurarTela() {
        if (!usuarioLogado.isAdministrador()) {
            tabs.remove(3);
        }
        if (!usuarioLogado.isCadastraProduto()) {
            tabs.remove(1);
        }
        if (!usuarioLogado.isVendeProduto()) {
            btnEfetuarVenda.setVisible(false);
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

        btTrocarUsuario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        pnVendas = new javax.swing.JPanel();
        btnConsultaPrecos = new javax.swing.JButton();
        btnEfetuarVenda = new javax.swing.JButton();
        pnCadastros = new javax.swing.JPanel();
        btCadastroFornecedor = new javax.swing.JButton();
        btnCadastroClientes = new javax.swing.JButton();
        btnCadastroProdutos = new javax.swing.JButton();
        pnConsultas = new javax.swing.JPanel();
        btConsultaFornecedores = new javax.swing.JButton();
        btnConsultasClientes = new javax.swing.JButton();
        btnConsultaProdutos = new javax.swing.JButton();
        btnConsultarVendas = new javax.swing.JButton();
        pnAdministracao = new javax.swing.JPanel();
        btnCadastroUsuario = new javax.swing.JButton();
        lbUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Venda Rápida - Principal");
        setResizable(false);

        btTrocarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/http-__iconesbr.oficinadanet.com_8432_64x64.png"))); // NOI18N
        btTrocarUsuario.setPreferredSize(new java.awt.Dimension(20, 20));
        btTrocarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTrocarUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setText("Bem vindo(a), ");

        btnConsultaPrecos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cifrao.png"))); // NOI18N
        btnConsultaPrecos.setText("Consutar de Preços");
        btnConsultaPrecos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsultaPrecos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnConsultaPrecos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConsultaPrecos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaPrecosActionPerformed(evt);
            }
        });

        btnEfetuarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/venda.png"))); // NOI18N
        btnEfetuarVenda.setText("Efetuar Vendas");
        btnEfetuarVenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEfetuarVenda.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEfetuarVenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEfetuarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEfetuarVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnVendasLayout = new javax.swing.GroupLayout(pnVendas);
        pnVendas.setLayout(pnVendasLayout);
        pnVendasLayout.setHorizontalGroup(
            pnVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnVendasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConsultaPrecos, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEfetuarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnVendasLayout.setVerticalGroup(
            pnVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnVendasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEfetuarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultaPrecos, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(123, Short.MAX_VALUE))
        );

        tabs.addTab("Vendas", pnVendas);

        btCadastroFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/motorista.png"))); // NOI18N
        btCadastroFornecedor.setText("Fornecedor");
        btCadastroFornecedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCadastroFornecedor.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btCadastroFornecedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCadastroFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroFornecedorActionPerformed(evt);
            }
        });

        btnCadastroClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/passageiros.png"))); // NOI18N
        btnCadastroClientes.setText("Cliente");
        btnCadastroClientes.setActionCommand("Cadastro de Clientes");
        btnCadastroClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadastroClientes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCadastroClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCadastroClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroClientesActionPerformed(evt);
            }
        });

        btnCadastroProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/product-icon.png"))); // NOI18N
        btnCadastroProdutos.setText("Produto");
        btnCadastroProdutos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadastroProdutos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCadastroProdutos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCadastroProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroProdutosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCadastrosLayout = new javax.swing.GroupLayout(pnCadastros);
        pnCadastros.setLayout(pnCadastrosLayout);
        pnCadastrosLayout.setHorizontalGroup(
            pnCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCadastrosLayout.createSequentialGroup()
                        .addComponent(btCadastroFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCadastroClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCadastroProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnCadastrosLayout.setVerticalGroup(
            pnCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btCadastroFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastroClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCadastroProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Cadastros", pnCadastros);

        btConsultaFornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/motorista.png"))); // NOI18N
        btConsultaFornecedores.setText("Fornecedor");
        btConsultaFornecedores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btConsultaFornecedores.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btConsultaFornecedores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btConsultaFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultaFornecedoresActionPerformed(evt);
            }
        });

        btnConsultasClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/passageiros.png"))); // NOI18N
        btnConsultasClientes.setText("Cliente");
        btnConsultasClientes.setActionCommand("Cadastro de Clientes");
        btnConsultasClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsultasClientes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnConsultasClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConsultasClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasClientesActionPerformed(evt);
            }
        });

        btnConsultaProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/product-icon.png"))); // NOI18N
        btnConsultaProdutos.setText("Produto");
        btnConsultaProdutos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsultaProdutos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnConsultaProdutos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConsultaProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaProdutosActionPerformed(evt);
            }
        });

        btnConsultarVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/venda.png"))); // NOI18N
        btnConsultarVendas.setText("Vendas");
        btnConsultarVendas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsultarVendas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnConsultarVendas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConsultarVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarVendasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnConsultasLayout = new javax.swing.GroupLayout(pnConsultas);
        pnConsultas.setLayout(pnConsultasLayout);
        pnConsultasLayout.setHorizontalGroup(
            pnConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnConsultasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnConsultasLayout.createSequentialGroup()
                        .addComponent(btConsultaFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConsultasClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnConsultasLayout.createSequentialGroup()
                        .addComponent(btnConsultaProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConsultarVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnConsultasLayout.setVerticalGroup(
            pnConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConsultasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btConsultaFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultasClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConsultaProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Consultas", pnConsultas);

        btnCadastroUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cadastroCliente.png"))); // NOI18N
        btnCadastroUsuario.setText("Usuários");
        btnCadastroUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadastroUsuario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCadastroUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnAdministracaoLayout = new javax.swing.GroupLayout(pnAdministracao);
        pnAdministracao.setLayout(pnAdministracaoLayout);
        pnAdministracaoLayout.setHorizontalGroup(
            pnAdministracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAdministracaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastroUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(278, 278, 278))
        );
        pnAdministracaoLayout.setVerticalGroup(
            pnAdministracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAdministracaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastroUsuario)
                .addGap(183, 183, 183))
        );

        tabs.addTab("Administração", pnAdministracao);

        lbUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbUsuario.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btTrocarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btTrocarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lbUsuario)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Venda Rápida - Principal");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btTrocarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTrocarUsuarioActionPerformed
        this.setVisible(false);
        FrmTelaLogin.getInstance(true);
        //Runtime.getRuntime().exit(0);
    }//GEN-LAST:event_btTrocarUsuarioActionPerformed

    private void btnCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroUsuarioActionPerformed
        new FrmCadastroUsuario(this, true).setVisible(true);
    }//GEN-LAST:event_btnCadastroUsuarioActionPerformed

    private void btnCadastroProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroProdutosActionPerformed
        new FrmCadastroProduto(this, true).setVisible(true);
    }//GEN-LAST:event_btnCadastroProdutosActionPerformed

    private void btnCadastroClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroClientesActionPerformed
        new FrmCadastroCliente(this, true).setVisible(true);
    }//GEN-LAST:event_btnCadastroClientesActionPerformed

    private void btCadastroFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroFornecedorActionPerformed
        new FrmCadastroFornecedor(this, true).setVisible(true);
    }//GEN-LAST:event_btCadastroFornecedorActionPerformed

    private void btnEfetuarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEfetuarVendaActionPerformed
        new FrmSimulacaoVenda(this, true, false).setVisible(true);
    }//GEN-LAST:event_btnEfetuarVendaActionPerformed

    private void btnConsultaPrecosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaPrecosActionPerformed
        new FrmConsultaPreco(this, true).setVisible(true);
    }//GEN-LAST:event_btnConsultaPrecosActionPerformed

    private void btConsultaFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultaFornecedoresActionPerformed
        new FrmConsultaForncedor(this, true, null).setVisible(true);
    }//GEN-LAST:event_btConsultaFornecedoresActionPerformed

    private void btnConsultasClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasClientesActionPerformed
        new FrmConsultaCliente(this, true, null).setVisible(true);
    }//GEN-LAST:event_btnConsultasClientesActionPerformed

    private void btnConsultaProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaProdutosActionPerformed
        new FrmConsultaProduto(this, true, null).setVisible(true);
    }//GEN-LAST:event_btnConsultaProdutosActionPerformed

    private void btnConsultarVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarVendasActionPerformed
        new FrmConsultaVendas(this, true).setVisible(true);
    }//GEN-LAST:event_btnConsultarVendasActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastroFornecedor;
    private javax.swing.JButton btConsultaFornecedores;
    private javax.swing.JButton btTrocarUsuario;
    private javax.swing.JButton btnCadastroClientes;
    private javax.swing.JButton btnCadastroProdutos;
    private javax.swing.JButton btnCadastroUsuario;
    private javax.swing.JButton btnConsultaPrecos;
    private javax.swing.JButton btnConsultaProdutos;
    private javax.swing.JButton btnConsultarVendas;
    private javax.swing.JButton btnConsultasClientes;
    private javax.swing.JButton btnEfetuarVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPanel pnAdministracao;
    private javax.swing.JPanel pnCadastros;
    private javax.swing.JPanel pnConsultas;
    private javax.swing.JPanel pnVendas;
    private javax.swing.JTabbedPane tabs;
    // End of variables declaration//GEN-END:variables
}
