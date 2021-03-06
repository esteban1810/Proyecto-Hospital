/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import hotel.UsuarioIndex;
import hotel.Hotel;

/**
 *
 * @author franc
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form menu
     */
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCerrarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblUsuarios = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnReservaciones = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnHabitaciones = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnClientes2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setBackground(new java.awt.Color(249, 92, 73));
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrarSesion.setBackground(new java.awt.Color(147, 7, 7));
        btnCerrarSesion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(250, 250, 250));
        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setMargin(new java.awt.Insets(500, 500, 500, 500));
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 150, 30));

        jLabel1.setBackground(new java.awt.Color(242, 189, 61));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 82));

        lblUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/users_2.png"))); // NOI18N
        getContentPane().add(lblUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 128, 128));

        btnUsuarios.setBackground(new java.awt.Color(0, 121, 254));
        btnUsuarios.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUsuarios.setForeground(new java.awt.Color(250, 250, 250));
        btnUsuarios.setText("Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/habitaciones.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 130, 110));

        btnReservaciones.setBackground(new java.awt.Color(0, 121, 254));
        btnReservaciones.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReservaciones.setForeground(new java.awt.Color(250, 250, 250));
        btnReservaciones.setText("Reservaciones");
        btnReservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservacionesActionPerformed(evt);
            }
        });
        getContentPane().add(btnReservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clientes.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 130, 130));

        btnHabitaciones.setBackground(new java.awt.Color(0, 121, 254));
        btnHabitaciones.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnHabitaciones.setForeground(new java.awt.Color(250, 250, 250));
        btnHabitaciones.setText("Habitaciones");
        btnHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabitacionesActionPerformed(evt);
            }
        });
        getContentPane().add(btnHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, -1, -1));

        btnClientes.setBackground(new java.awt.Color(0, 121, 254));
        btnClientes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(250, 250, 250));
        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reservacion.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 130, 120));

        btnClientes2.setBackground(new java.awt.Color(0, 121, 254));
        btnClientes2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnClientes2.setForeground(new java.awt.Color(250, 250, 250));
        btnClientes2.setText("Clientes");
        btnClientes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientes2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnClientes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, -1, -1));

        jLabel3.setBackground(new java.awt.Color(249, 92, 73));
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 800, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.setVisible(false);
        Hotel log = new Hotel();
        log.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        new UsuarioIndex().show();
        this.dispose();
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnReservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservacionesActionPerformed
        new ReservacionIndex().show();
        this.dispose();
    }//GEN-LAST:event_btnReservacionesActionPerformed

    private void btnHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabitacionesActionPerformed
        new HabitacionIndex(Hotel.listaHabitaciones).show();
        this.dispose();
    }//GEN-LAST:event_btnHabitacionesActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        new ClienteIndex().show();
        this.dispose();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnClientes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientes2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClientes2ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnClientes2;
    private javax.swing.JButton btnHabitaciones;
    private javax.swing.JButton btnReservaciones;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblUsuarios;
    // End of variables declaration//GEN-END:variables
}
