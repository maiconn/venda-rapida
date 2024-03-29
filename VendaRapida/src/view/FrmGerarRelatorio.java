/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.relatorio.ComposicaoRelatorio;
import controller.relatorio.GeradorRelatorio;
import controller.relatorio.Relatorio;
import controller.relatorio.formato.RelatorioHTML;
import controller.relatorio.formato.RelatorioPDF;
import controller.relatorio.formato.RelatorioXML;
import java.awt.Color;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import view.util.ViewUtil;

/**
 *
 * @author Maicon
 */
public class FrmGerarRelatorio extends javax.swing.JDialog {

    private static Color SELECIONADO = new java.awt.Color(102, 153, 255);
    private static Color NAO_SELECIONADO = new java.awt.Color(204, 204, 204);
    private Relatorio relatorioSelecionado;
    private ComposicaoRelatorio composicaoRelatorio;
    private GeradorRelatorio gerador = new GeradorRelatorio();
    private String extensaoArquivo;

    /**
     * Creates new form FrmGerarRelatorio
     */
    public FrmGerarRelatorio(java.awt.Frame parent, boolean modal, ComposicaoRelatorio composicaoRelatorio) {
        super(parent, modal);
        initComponents();
        relatorioSelecionado = new RelatorioPDF();
        extensaoArquivo = ".pdf";
        this.composicaoRelatorio = composicaoRelatorio;
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panelXML = new javax.swing.JPanel();
        relXML = new javax.swing.JLabel();
        panelHTML = new javax.swing.JPanel();
        relHTML = new javax.swing.JLabel();
        panelPDF = new javax.swing.JPanel();
        relPDF = new javax.swing.JLabel();
        btnGerar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerar Relatório");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/relatorio.png"))); // NOI18N
        jLabel1.setText("Gerar Relatório");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecione o Tipo de Relatório"));

        panelXML.setBackground(new java.awt.Color(204, 204, 204));
        panelXML.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelXMLMouseClicked(evt);
            }
        });

        relXML.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/relatorio_XML.png"))); // NOI18N

        javax.swing.GroupLayout panelXMLLayout = new javax.swing.GroupLayout(panelXML);
        panelXML.setLayout(panelXMLLayout);
        panelXMLLayout.setHorizontalGroup(
            panelXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelXMLLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(relXML)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelXMLLayout.setVerticalGroup(
            panelXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelXMLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(relXML)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelHTML.setBackground(new java.awt.Color(204, 204, 204));
        panelHTML.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelHTMLMouseClicked(evt);
            }
        });

        relHTML.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/relatorio_HTML.png"))); // NOI18N

        javax.swing.GroupLayout panelHTMLLayout = new javax.swing.GroupLayout(panelHTML);
        panelHTML.setLayout(panelHTMLLayout);
        panelHTMLLayout.setHorizontalGroup(
            panelHTMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHTMLLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(relHTML)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelHTMLLayout.setVerticalGroup(
            panelHTMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHTMLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(relHTML)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPDF.setBackground(new java.awt.Color(102, 153, 255));
        panelPDF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelPDFMouseClicked(evt);
            }
        });

        relPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/relatorio_PDF.png"))); // NOI18N

        javax.swing.GroupLayout panelPDFLayout = new javax.swing.GroupLayout(panelPDF);
        panelPDF.setLayout(panelPDFLayout);
        panelPDFLayout.setHorizontalGroup(
            panelPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPDFLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(relPDF)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelPDFLayout.setVerticalGroup(
            panelPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPDFLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(relPDF)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(panelPDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelHTML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelXML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelHTML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelXML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirma.png"))); // NOI18N
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sair.png"))); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGerar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGerar)
                    .addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelHTMLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHTMLMouseClicked
        panelHTML.setBackground(SELECIONADO);
        panelPDF.setBackground(NAO_SELECIONADO);
        panelXML.setBackground(NAO_SELECIONADO);
        relatorioSelecionado = new RelatorioHTML();
        extensaoArquivo = ".html";
    }//GEN-LAST:event_panelHTMLMouseClicked

    private void panelPDFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPDFMouseClicked
        panelHTML.setBackground(NAO_SELECIONADO);
        panelPDF.setBackground(SELECIONADO);
        panelXML.setBackground(NAO_SELECIONADO);
        relatorioSelecionado = new RelatorioPDF();
        extensaoArquivo = ".pdf";
    }//GEN-LAST:event_panelPDFMouseClicked

    private void panelXMLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelXMLMouseClicked
        panelHTML.setBackground(NAO_SELECIONADO);
        panelPDF.setBackground(NAO_SELECIONADO);
        panelXML.setBackground(SELECIONADO);
        relatorioSelecionado = new RelatorioXML();
        extensaoArquivo = ".xml";
    }//GEN-LAST:event_panelXMLMouseClicked

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        try {
            String path = ViewUtil.createFileChooserToSaveRelatorio(this);
            if (path != null) {
                gerador.setRelatorio(relatorioSelecionado);
                composicaoRelatorio.setLocalSalvar(path);
                new DialogGerandoRelatorio((Frame) getParent(), true, gerador, composicaoRelatorio, relatorioSelecionado).setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnGerarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelHTML;
    private javax.swing.JPanel panelPDF;
    private javax.swing.JPanel panelXML;
    private javax.swing.JLabel relHTML;
    private javax.swing.JLabel relPDF;
    private javax.swing.JLabel relXML;
    // End of variables declaration//GEN-END:variables
}
