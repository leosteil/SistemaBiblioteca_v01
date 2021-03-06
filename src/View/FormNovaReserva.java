/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.DAOS.EmprestimosDAO;
import modelo.DAOS.LivrosDAO;
import modelo.DAOS.ReservasDAO;
import modelo.DAOS.UsuariosDAO;
import modelo.Emprestimo;
import modelo.Livro;
import modelo.Reserva;
import modelo.Usuario;
import negocio.Negocios;

/**
 *
 * @author Leonardo
 */
public class FormNovaReserva extends javax.swing.JFrame {

    Livro livro = new Livro();
    LivrosDAO daoLivro = new LivrosDAO();
    Usuario user = new Usuario();
    UsuariosDAO daoUser = new UsuariosDAO();
    Reserva res = new Reserva();
    ReservasDAO daoRes = new ReservasDAO();
    Negocios negocio = new Negocios();
    
    SimpleDateFormat formato = new SimpleDateFormat( "dd/MM/yyyy" );  
    Date data = new Date();
    
    /**
     * Creates new form FormNovoEmprestimo2
     */
    public FormNovaReserva() {
        initComponents();
        txtDataRetirada.setText(formato.format(data));
    }     
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnProcuraLivro = new javax.swing.JButton();
        btnProcuraUsuario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDataRetirada = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNomeLivro = new javax.swing.JTextField();
        txtNomeUser = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnProcuraLivro.setText("Livro");
        btnProcuraLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcuraLivroActionPerformed(evt);
            }
        });

        btnProcuraUsuario.setText("Usuário");
        btnProcuraUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcuraUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setText("Selecione o Livro:");

        jLabel2.setText("Selecione o Usuário:");

        jLabel3.setText("Data de Reserva:");

        txtDataRetirada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataRetiradaActionPerformed(evt);
            }
        });

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtNomeLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeLivroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNomeUser)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeLivro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnProcuraLivro, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(btnProcuraUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDataRetirada))
                        .addGap(64, 64, 64)
                        .addComponent(btnCancelar))
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProcuraLivro)
                    .addComponent(jLabel1)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProcuraUsuario)
                    .addComponent(jLabel2))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDataRetirada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcuraLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcuraLivroActionPerformed
        FormConsultaLivros form = null;
        try {
            form = new FormConsultaLivros(this, true, 1);
        } catch (SQLException ex) {
            Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        form.setTitle("Consulta de Livros");
        form.setLocationRelativeTo(null);
        form.setResizable(false);
        form.setVisible(true);
        livro = form.getLivroSelecionado();
        txtNomeLivro.setText(livro.getTitulo());
        
        System.out.println("Livro" + livro.getTitulo());
    }//GEN-LAST:event_btnProcuraLivroActionPerformed

    private void btnProcuraUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcuraUsuarioActionPerformed
        FormConsultaUser form = null;
        try {
            form = new FormConsultaUser(this, true, 1);
        } catch (SQLException ex) {
            Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        form.setTitle("Consulta de Usuarios");
        form.setLocationRelativeTo(null);
        form.setResizable(false);
        form.setVisible(true);
        user = form.getUserSelecionado();
        txtNomeUser.setText(user.getNome());       
    }//GEN-LAST:event_btnProcuraUsuarioActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if(negocio.verificaReserva(livro)){
            if(!negocio.verificaMulta(user)){
                livro.setReservado(true);

                /*Adiciona data de reserva no reserva.data_reserva*/
                java.sql.Date dt = negocio.dataRetirada(txtDataRetirada.getText(), formato);
                res.setDt_reserva(dt);
                /*Adiciona data de entrada no emprestimo.data_entrada*/
                
                daoLivro.alterar(livro);
                daoRes.inserirEmpRes(res, livro.getId_livro(), user.getId_usuario());
            
            }else{
                JOptionPane.showMessageDialog(this, "Este usuário ultrapassou o limite de imprestimos");
            }                     
        }else{
            JOptionPane.showMessageDialog(this, "Este livro está emprestado ou reservado");
        }
        dispose();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txtDataRetiradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataRetiradaActionPerformed
   
    }//GEN-LAST:event_txtDataRetiradaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNomeLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeLivroActionPerformed

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
            java.util.logging.Logger.getLogger(FormNovaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormNovaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormNovaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormNovaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormNovaReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnCancelar;
    protected javax.swing.JButton btnConfirmar;
    protected javax.swing.JButton btnProcuraLivro;
    protected javax.swing.JButton btnProcuraUsuario;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    protected javax.swing.JLabel jLabel3;
    protected javax.swing.JTextField txtDataRetirada;
    protected javax.swing.JTextField txtNomeLivro;
    protected javax.swing.JTextField txtNomeUser;
    // End of variables declaration//GEN-END:variables
}
