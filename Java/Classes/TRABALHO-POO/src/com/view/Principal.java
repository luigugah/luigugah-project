/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.view;

import com.controller.UserController;
import com.domain.Consulta;
import com.domain.Medico;
import com.domain.Secretaria;
import com.repository.UserRepository;
import com.security.UserManager;
import com.utils.CollectionUtils;
import com.view.controller.ConsultaViewController;
import com.view.controller.PacienteViewController;
import com.view.controller.ProntuarioViewController;
import java.awt.Component;
import java.util.Collection;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class Principal extends javax.swing.JFrame {

    private PacienteViewController pacienteViewController;
    private ProntuarioViewController prontuarioViewController;
    private ConsultaViewController consultaViewController;
    private UserManager userManager;
    
    GerenciamentoConsulta gerenciamentoConsulta;
    GerenciarPaciente gerenciarPaciente;
    GerenciarProntuario gerenciarProntuario;
    BuscarPaciente buscarPaciente;
    BuscaConsulta buscarConsulta;
    BuscaProntuario buscaProntuario;

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public PacienteViewController getPacienteViewController() {
        return pacienteViewController;
    }

    public void setPacienteViewController(PacienteViewController pacienteViewController) {
        this.pacienteViewController = pacienteViewController;
    }

    public ProntuarioViewController getProntuarioViewController() {
        return prontuarioViewController;
    }

    public void setProntuarioViewController(ProntuarioViewController prontuarioViewController) {
        this.prontuarioViewController = prontuarioViewController;
    }

    public ConsultaViewController getConsultaViewController() {
        return consultaViewController;
    }

    public void setConsultaViewController(ConsultaViewController consultaViewController) {
        this.consultaViewController = consultaViewController;
    }
    
    
    
    /**
     * Creates new form Principal
     */
    public Principal(ConsultaViewController consultaViewController, 
                     PacienteViewController pacienteViewController, 
                     ProntuarioViewController prontuarioViewController, 
                     UserManager userManager) {
        
        this.consultaViewController = consultaViewController;
        this.pacienteViewController = pacienteViewController;
        this.prontuarioViewController = prontuarioViewController;
        
        this.userManager = userManager;
        
        initComponents();
        buildMenuItens();
        setLocationRelativeTo(null);
        disableMenuItemForLoggedCustomer();

    }

    
    
    private void buildMenuItens(){        
        
        gerenciamentoConsulta = new GerenciamentoConsulta(new UserController(userManager), pacienteViewController.getController(), consultaViewController);
        try{gerenciamentoConsulta.setMaximum(true);}catch(Exception e){}
        this.container.add(gerenciamentoConsulta);
        
        gerenciarPaciente = new GerenciarPaciente(pacienteViewController);
        try{gerenciarPaciente.setMaximum(true);}catch(Exception e){}
        this.container.add(gerenciarPaciente);
        
        gerenciarProntuario = new GerenciarProntuario(prontuarioViewController);
        try{gerenciarProntuario.setMaximum(true);}catch(Exception e){}
        this.container.add(gerenciarProntuario);
        
        buscarPaciente = new BuscarPaciente(pacienteViewController, gerenciarPaciente);
        try{buscarPaciente.setMaximum(true);}catch(Exception e){}
        this.container.add(buscarPaciente);
        
        buscarConsulta = new BuscaConsulta(consultaViewController, gerenciamentoConsulta);
        try{buscarConsulta.setMaximum(true);}catch(Exception e){}
        this.container.add(buscarConsulta);
        
        buscaProntuario = new BuscaProntuario(gerenciarProntuario, prontuarioViewController);
        try{buscaProntuario.setMaximum(true);}catch(Exception e){}
        this.container.add(buscaProntuario);        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        container = new javax.swing.JPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        gerenciamentoDePacienteMenuItem = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        gerenciamentoDeConsultaMenuItem = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        buscarProntuarioMenuItem = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenuItem2.setText("jMenuItem2");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 689, Short.MAX_VALUE)
        );

        jMenu3.setText("Paciente");

        jMenuItem1.setText("Pesquisar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        gerenciamentoDePacienteMenuItem.setText("Cadastrar");
        gerenciamentoDePacienteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerenciamentoDePacienteMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(gerenciamentoDePacienteMenuItem);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Consulta");

        jMenuItem3.setText("Pesquisar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        gerenciamentoDeConsultaMenuItem.setText("Cadastrar");
        gerenciamentoDeConsultaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerenciamentoDeConsultaMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(gerenciamentoDeConsultaMenuItem);

        jMenuItem4.setText("Enviar emails");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar2.add(jMenu4);

        jMenu5.setText("Prontuario");

        buscarProntuarioMenuItem.setText("Buscar Prontuario");
        buscarProntuarioMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarProntuarioMenuItemActionPerformed(evt);
            }
        });
        jMenu5.add(buscarProntuarioMenuItem);

        jMenuBar2.add(jMenu5);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gerenciamentoDeConsultaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenciamentoDeConsultaMenuItemActionPerformed
        closeAllInternalFrames();
        gerenciamentoConsulta.cadastrarConsulta();
    }//GEN-LAST:event_gerenciamentoDeConsultaMenuItemActionPerformed

    private void gerenciamentoDePacienteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenciamentoDePacienteMenuItemActionPerformed
        closeAllInternalFrames();
        gerenciarPaciente.cadastrarPaciente();
    }//GEN-LAST:event_gerenciamentoDePacienteMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        closeAllInternalFrames();
        buscarPaciente.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        closeAllInternalFrames();
        buscarConsulta.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void buscarProntuarioMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarProntuarioMenuItemActionPerformed
        closeAllInternalFrames();
        buscaProntuario.setVisible(true);
    }//GEN-LAST:event_buscarProntuarioMenuItemActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Collection<Consulta> consultasDiaSeguinte = consultaViewController.getController().getAllConsultasDiaSeguinte();
        int numeroConsultas = 0;
        
        if(CollectionUtils.isNotEmpty(consultasDiaSeguinte)){numeroConsultas = consultasDiaSeguinte.size();}
        if(numeroConsultas != 0){
            int opt = JOptionPane.showConfirmDialog(this, "Você tem " + numeroConsultas + " consultas para amanhã\n Deseja enviar um aviso?");
        
            if(opt == 0){
                JOptionPane.showMessageDialog(this, "Emails enviados!");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Você não tem consultas para amanhã!");
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem buscarProntuarioMenuItem;
    private javax.swing.JPanel container;
    private javax.swing.JMenuItem gerenciamentoDeConsultaMenuItem;
    private javax.swing.JMenuItem gerenciamentoDePacienteMenuItem;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    // End of variables declaration//GEN-END:variables

    private void closeAllInternalFrames(){
        for(Component component : this.container.getComponents()){
            if(component instanceof JInternalFrame){
                component.setVisible(false);
            }
        }
    }

    private void disableMenuItemForLoggedCustomer() {
        if(prontuarioViewController.getSessionUser() instanceof Secretaria){
            buscarProntuarioMenuItem.setEnabled(false);
        }
    }

}
