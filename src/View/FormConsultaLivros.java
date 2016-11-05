/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.DAOS.EmprestimosDAO;
import modelo.Livro;
import modelo.DAOS.LivrosDAO;
import modelo.DAOS.UsuariosDAO;
import View.FormNovoEmprestimo;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class FormConsultaLivros extends javax.swing.JDialog {
    Livro livro = new Livro();
    
    public Livro getLivroSelecionado(){
        return livro;
    }
        
    LivrosDAO daoLivros = new LivrosDAO();
    EmprestimosDAO daoEmp = new EmprestimosDAO();
    UsuariosDAO daoUser = new UsuariosDAO();

    public void atualizaTabela() throws SQLException {
        listResultadoConsultas.clear();
        listResultadoConsultas.addAll(daoLivros.buscar());
        int linha = listResultadoConsultas.size() - 1; // retorna o numero de linhas
        if (linha >= 0) {
            tblResultadoConsultas.setRowSelectionInterval(linha, linha);
            tblResultadoConsultas.scrollRectToVisible(
                    tblResultadoConsultas.getCellRect(linha, linha, true));
        }else{
            JOptionPane.showMessageDialog(this, "Nenhum livro encontrado");
        }
    }
    
    /**
     * Creates new form FormConsultaLivros
     * @param parent
     * @param modal
     * @throws java.sql.SQLException
     */
    public FormConsultaLivros(java.awt.Frame parent, boolean modal, int x) throws SQLException {
        super(parent, modal);
        initComponents();
        //atualizaTabela();
        if(x == 0 ){
            btnLivroSelecionado.setVisible(false);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        listResultadoConsultas = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Livro>())  ;
        painelConsultas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtConsultaISBN = new javax.swing.JTextField();
        txtConsultaParteTitulo = new javax.swing.JTextField();
        txtConsultaEditora = new javax.swing.JTextField();
        btnOkISBN = new javax.swing.JButton();
        btnOkTitulo = new javax.swing.JButton();
        btnOkEditora = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnLivroSelecionado = new javax.swing.JButton();
        painelResultadoConsultas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultadoConsultas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelConsultas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setText("Consulta por ISBN:");

        jLabel2.setText("Consulta por Titulo:");

        jLabel3.setText("Consulta Por Editora");

        txtConsultaISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsultaISBNActionPerformed(evt);
            }
        });

        txtConsultaParteTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsultaParteTituloActionPerformed(evt);
            }
        });

        txtConsultaEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsultaEditoraActionPerformed(evt);
            }
        });

        btnOkISBN.setText("Ok");
        btnOkISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkISBNActionPerformed(evt);
            }
        });

        btnOkTitulo.setText("Ok");
        btnOkTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkTituloActionPerformed(evt);
            }
        });

        btnOkEditora.setText("Ok");
        btnOkEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkEditoraActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnLivroSelecionado.setText("Livro Selecionado");
        btnLivroSelecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLivroSelecionadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelConsultasLayout = new javax.swing.GroupLayout(painelConsultas);
        painelConsultas.setLayout(painelConsultasLayout);
        painelConsultasLayout.setHorizontalGroup(
            painelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultasLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(painelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(painelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtConsultaISBN, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(txtConsultaParteTitulo)
                    .addComponent(txtConsultaEditora))
                .addGap(18, 18, 18)
                .addGroup(painelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOkTitulo)
                    .addComponent(btnOkEditora)
                    .addComponent(btnOkISBN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(painelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLivroSelecionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelConsultasLayout.setVerticalGroup(
            painelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultasLayout.createSequentialGroup()
                .addGroup(painelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelConsultasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConsultaISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOkISBN)))
                    .addComponent(btnFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(painelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtConsultaParteTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOkTitulo)
                    .addComponent(btnLivroSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtConsultaEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOkEditora))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        painelResultadoConsultas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultados das consultas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        painelResultadoConsultas.setLayout(new java.awt.BorderLayout());

        tblResultadoConsultas.getTableHeader().setReorderingAllowed(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listResultadoConsultas, tblResultadoConsultas);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${isbn}"));
        columnBinding.setColumnName("Isbn");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${titulo}"));
        columnBinding.setColumnName("Titulo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${autores}"));
        columnBinding.setColumnName("Autores");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${editora}"));
        columnBinding.setColumnName("Editora");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${edicao}"));
        columnBinding.setColumnName("Edicao");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ano}"));
        columnBinding.setColumnName("Ano");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${emprestado}"));
        columnBinding.setColumnName("Emprestado");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${reservado}"));
        columnBinding.setColumnName("Reservado");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tblResultadoConsultas);

        painelResultadoConsultas.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelResultadoConsultas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelResultadoConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtConsultaISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsultaISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConsultaISBNActionPerformed

    private void txtConsultaParteTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsultaParteTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConsultaParteTituloActionPerformed

    private void txtConsultaEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsultaEditoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConsultaEditoraActionPerformed

    private void btnOkISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkISBNActionPerformed
        daoLivros.setSqlBusca("SELECT * FROM livros WHERE CAST(isbn as text) ILIKE " + "'%" + txtConsultaISBN.getText() + "%'");
        try {
            atualizaTabela();
            txtConsultaISBN.setText("");          
        } catch (SQLException ex) {
            Logger.getLogger(FormConsultaLivros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOkISBNActionPerformed

    private void btnOkTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkTituloActionPerformed
        String stringBusca = "SELECT * FROM livros WHERE titulo ILIKE " + "'%" + txtConsultaParteTitulo.getText() + "%'";
        daoLivros.setSqlBusca(stringBusca);
        try {
            atualizaTabela();
            txtConsultaParteTitulo.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(FormConsultaLivros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOkTituloActionPerformed

    private void btnOkEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkEditoraActionPerformed
        daoLivros.setSqlBusca("SELECT * FROM livros WHERE editora ILIKE " + "'%" + txtConsultaEditora.getText() + "%'");
        try {
            atualizaTabela();
            txtConsultaEditora.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(FormConsultaLivros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOkEditoraActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnLivroSelecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLivroSelecionadoActionPerformed
        int linhaSelecionada = tblResultadoConsultas.getSelectedRow();
        livro = listResultadoConsultas.get(linhaSelecionada);
        dispose();
    }//GEN-LAST:event_btnLivroSelecionadoActionPerformed

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
            java.util.logging.Logger.getLogger(FormConsultaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormConsultaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormConsultaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormConsultaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormConsultaLivros dialog = null;
                try {
                    dialog = new FormConsultaLivros(new javax.swing.JFrame(), true, 0);
                } catch (SQLException ex) {
                    Logger.getLogger(FormConsultaLivros.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnFechar;
    protected javax.swing.JButton btnLivroSelecionado;
    protected javax.swing.JButton btnOkEditora;
    protected javax.swing.JButton btnOkISBN;
    protected javax.swing.JButton btnOkTitulo;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    protected javax.swing.JLabel jLabel3;
    protected javax.swing.JScrollPane jScrollPane1;
    public java.util.List<Livro> listResultadoConsultas;
    protected javax.swing.JPanel painelConsultas;
    protected javax.swing.JPanel painelResultadoConsultas;
    public javax.swing.JTable tblResultadoConsultas;
    protected javax.swing.JTextField txtConsultaEditora;
    protected javax.swing.JTextField txtConsultaISBN;
    protected javax.swing.JTextField txtConsultaParteTitulo;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
