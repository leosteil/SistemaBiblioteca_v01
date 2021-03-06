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
import javax.swing.JOptionPane;
import modelo.Livro;
import modelo.DAOS.LivrosDAO;
import modelo.DAOS.UsuariosDAO;
import modelo.Usuario;

/**
 *
 * @author Leonardo
 */
public class FormConsultaUser extends javax.swing.JDialog {

    UsuariosDAO daoUser = new UsuariosDAO();
    Usuario user = new Usuario();    

    public Usuario getUserSelecionado(){
        return user;
    }
    
    public void atualizaTabela() throws SQLException {
        listResultadoConsultas.clear();
        listResultadoConsultas.addAll(daoUser.buscar());
        int linha = listResultadoConsultas.size() - 1; // retorna o numero de linhas
        if (linha >= 0) {
            tblResultadoConsultas.setRowSelectionInterval(linha, linha);
            tblResultadoConsultas.scrollRectToVisible(
                    tblResultadoConsultas.getCellRect(linha, linha, true));
        }
    }

    /**
     * Creates new form FormConsultaLivros
     */
    public FormConsultaUser(java.awt.Frame parent, boolean modal, int x) throws SQLException {
        super(parent, modal = true);
        initComponents();
        
        if(x == 0){
            btnUserSelecionado.setVisible(false);
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        listResultadoConsultas = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Usuario>())  ;
        jPanel1 = new javax.swing.JPanel();
        painelConsultas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtConsultaNome = new javax.swing.JTextField();
        txtConsultaLogin = new javax.swing.JTextField();
        btnOKNome = new javax.swing.JButton();
        btnOkLogin = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnUserSelecionado = new javax.swing.JButton();
        btnPagarMulta = new javax.swing.JButton();
        painelResultadoConsultas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultadoConsultas = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelConsultas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setText("Consulta por Nome:");

        jLabel2.setText("Consulta por Login:");

        txtConsultaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsultaNomeActionPerformed(evt);
            }
        });

        txtConsultaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsultaLoginActionPerformed(evt);
            }
        });

        btnOKNome.setText("Ok");
        btnOKNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKNomeActionPerformed(evt);
            }
        });

        btnOkLogin.setText("Ok");
        btnOkLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkLoginActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnUserSelecionado.setText("Usuario Selecionado");
        btnUserSelecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserSelecionadoActionPerformed(evt);
            }
        });

        btnPagarMulta.setText("Pagar Multa");
        btnPagarMulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarMultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelConsultasLayout = new javax.swing.GroupLayout(painelConsultas);
        painelConsultas.setLayout(painelConsultasLayout);
        painelConsultasLayout.setHorizontalGroup(
            painelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultasLayout.createSequentialGroup()
                .addGroup(painelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelConsultasLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(painelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(painelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtConsultaNome, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .addComponent(txtConsultaLogin))
                        .addGap(18, 18, 18)
                        .addGroup(painelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOkLogin)
                            .addComponent(btnOKNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFechar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPagarMulta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelConsultasLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUserSelecionado)))
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
                            .addComponent(txtConsultaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOKNome)))
                    .addComponent(btnFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(painelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelConsultasLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(painelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(btnOkLogin))
                            .addComponent(txtConsultaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelConsultasLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnPagarMulta, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUserSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelResultadoConsultas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultados das consultas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        painelResultadoConsultas.setLayout(new java.awt.BorderLayout());

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listResultadoConsultas, tblResultadoConsultas);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${login}"));
        columnBinding.setColumnName("Login");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${telefone}"));
        columnBinding.setColumnName("Telefone");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${n_exemplares}"));
        columnBinding.setColumnName("N° de exemplares");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${multa}"));
        columnBinding.setColumnName("Multa");
        columnBinding.setColumnClass(Integer.class);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelResultadoConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtConsultaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsultaNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConsultaNomeActionPerformed

    private void txtConsultaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsultaLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConsultaLoginActionPerformed

    private void btnOKNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKNomeActionPerformed
        /*String sql = "select * from usuarios where 1=1 ";
        if(campoPreenchido)
            sql += "and nome like " + nome;*/
        
        daoUser.setSqlBusca("SELECT * FROM usuarios WHERE nome ILIKE "+"'%"+txtConsultaNome.getText()+"%'");
        try {
            atualizaTabela();
            txtConsultaNome.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(FormConsultaUser.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_btnOKNomeActionPerformed

    private void btnOkLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkLoginActionPerformed
        daoUser.setSqlBusca("SELECT * FROM usuarios WHERE login ILIKE "+"'%"+txtConsultaLogin.getText()+"%'");
        try {
            atualizaTabela();
            txtConsultaNome.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(FormConsultaUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOkLoginActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnUserSelecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserSelecionadoActionPerformed
        int linhaSelecionada = tblResultadoConsultas.getSelectedRow();
        user = listResultadoConsultas.get(linhaSelecionada);
        dispose();
    }//GEN-LAST:event_btnUserSelecionadoActionPerformed

    private void btnPagarMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarMultaActionPerformed
        int linhaSelecionada = tblResultadoConsultas.getSelectedRow();
        Usuario u = listResultadoConsultas.get(linhaSelecionada);
        int valor = u.getMulta();
        u.setMulta(0);
        daoUser.alterar(u);
        JOptionPane.showMessageDialog(this, "Multa de " + valor + " paga."
                +" Usuario" + u.getNome()+ " está liberado para outros emprestimos");
        
        try {
            atualizaTabela();
        } catch (SQLException ex) {
            Logger.getLogger(FormConsultaUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPagarMultaActionPerformed

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
            java.util.logging.Logger.getLogger(FormConsultaUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormConsultaUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormConsultaUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormConsultaUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormConsultaUser dialog = null;
                try {
                    dialog = new FormConsultaUser(new javax.swing.JFrame(), true, 0);
                } catch (SQLException ex) {
                    Logger.getLogger(FormConsultaUser.class.getName()).log(Level.SEVERE, null, ex);
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
    protected javax.swing.JButton btnOKNome;
    protected javax.swing.JButton btnOkLogin;
    protected javax.swing.JButton btnPagarMulta;
    protected javax.swing.JButton btnUserSelecionado;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    protected javax.swing.JPanel jPanel1;
    protected javax.swing.JScrollPane jScrollPane1;
    protected java.util.List<Usuario> listResultadoConsultas;
    protected javax.swing.JPanel painelConsultas;
    protected javax.swing.JPanel painelResultadoConsultas;
    protected javax.swing.JTable tblResultadoConsultas;
    protected javax.swing.JTextField txtConsultaLogin;
    protected javax.swing.JTextField txtConsultaNome;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
