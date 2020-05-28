/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import archivo.Archivo;
import datos.Habitacion;
import datos.Reservacion;
import datos.Usuario;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author franc
 */
public class Hotel extends javax.swing.JFrame {
    public static ArrayList<Usuario> listaClientes;
    //Usuario 
    public static Usuario user;
    public static Archivo archivoUsuario;
    public static ArrayList<Usuario> listaUsuarios;
    //Fin Usuario
    
    //Habitacion
    public static Archivo archivoHabitacion;
    public static ArrayList<Habitacion> listaHabitaciones;
    //Fin Habitacion
    
    //Reservaciones
    public static Archivo archivoReservacion;
    public static ArrayList<Reservacion> listaReservaciones;
    //Fin Reservacion
    
    
    
    //Admin
    private final String nomAdmin;
    private final String passAdmin;
    //Fin Admin
    private Image imgHotel;
    private Image imgEnter;
    
    public Hotel() {
        nomAdmin = "admin";
        passAdmin = "admin";
        //Usuario
        try {
            archivoUsuario = new Archivo("usuarios");
        } catch (IOException ex) {
            System.out.println("Error carga archivo usuarios");
        }
        try {
            listaUsuarios = archivoUsuario.Read();
        } catch (IOException ex) {
            System.out.println("Error carga de listaUsuarios");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error carga de listaUsuarios");
        }
        //Fin Usuario
        
        //Habitacion
        try {
            archivoHabitacion = new Archivo("habitaciones");
        } catch (IOException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            listaHabitaciones = archivoHabitacion.Read();
        } catch (IOException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fin Habitacion

        //Reservacion
        try {
            archivoReservacion = new Archivo("reservaciones");
        } catch (IOException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            listaReservaciones = archivoReservacion.Read();
        } catch (IOException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fin Reservacion
        
        //Cliente
        this.cargarListaClientes();
        //Fin Cliente
        
        initComponents();
        this.setLocationRelativeTo(null);
        cargarImagenes();
    }
    
    public static void cargarListaClientes(){
        listaClientes = null;
        listaClientes = new ArrayList();
        for(Usuario usuario : listaUsuarios){
            if(usuario.getTipo().equalsIgnoreCase("Cliente")){
                listaClientes.add(usuario);
            }
        }
    }
    
    //Métodos De Habitacion
    public static Habitacion buscarHabitacion(int id){
        int i=0;
        while(i<listaHabitaciones.size()){
            if(listaHabitaciones.get(i).getId()==id){
                return listaHabitaciones.get(i);
            }
            i++;
        }
        return null;
    }
    
    public static int nuevoIdHabitacion(){
        return listaHabitaciones.size()==0?1:
                Hotel.listaHabitaciones.get(listaHabitaciones.size()-1).getId()+1;
    }
    //Métodos De Habitacion
    
    //Métodos De Reservacion
    public static Reservacion buscarReservacion(int id){
        int i=0;
        while(i<listaReservaciones.size()){
            if(listaReservaciones.get(i).getId()==id){
                return listaReservaciones.get(i);
            }
            i++;
        }
        return null;
    }
    
    public static int nuevoIdReservacion(){
        return listaReservaciones.size()==0?1:
                Hotel.listaReservaciones.get(listaReservaciones.size()-1).getId()+1;
    }
    
    public static Usuario buscarUsuario(int id){
        int i=0;
        while(i<listaUsuarios.size()){
            if(listaUsuarios.get(i).getId()==id){
                return listaUsuarios.get(i);
            }
            i++;
        }
        return null;
    }
    
    public static int nuevoIdUsuario(){
        return Hotel.listaUsuarios.size()==0?1:Hotel.listaUsuarios.get(Hotel.listaUsuarios.size()-1).getId()+1;
    }
    //Fin Métodos De Usuario
   
    public void cargarImagenes(){
        ImageIcon iconHotel = new ImageIcon(this.getClass().getResource("/img/backgroundLogin.PNG"));
        imgHotel = iconHotel.getImage();
        lblBacgroundLogin.setIcon(new ImageIcon(imgHotel.getScaledInstance(lblBacgroundLogin.getWidth(), lblBacgroundLogin.getHeight(), Image.SCALE_DEFAULT)));
        this.repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUserName = new javax.swing.JLabel();
        txtUsuarioLogin = new javax.swing.JTextField();
        lblUserName1 = new javax.swing.JLabel();
        fldPassword = new javax.swing.JPasswordField();
        btnIniciarSesión = new javax.swing.JButton();
        lblUserIcon = new javax.swing.JLabel();
        lblBacgroundLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(45, 219, 218));
        setMinimumSize(new java.awt.Dimension(640, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUserName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUserName.setText("UserName");
        getContentPane().add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 100, 50));
        getContentPane().add(txtUsuarioLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 300, 50));

        lblUserName1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUserName1.setText("Contraseña");
        getContentPane().add(lblUserName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 100, 50));

        fldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(fldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 300, 50));

        btnIniciarSesión.setBackground(new java.awt.Color(20, 215, 81));
        btnIniciarSesión.setText("Iniciar sesión");
        btnIniciarSesión.setBorder(null);
        btnIniciarSesión.setMargin(new java.awt.Insets(500, 500, 500, 500));
        btnIniciarSesión.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesiónActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciarSesión, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 140, 40));

        lblUserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_orange.png"))); // NOI18N
        getContentPane().add(lblUserIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 130, 120));

        lblBacgroundLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/backgroundLogin.PNG"))); // NOI18N
        lblBacgroundLogin.setMinimumSize(new java.awt.Dimension(650, 450));
        lblBacgroundLogin.setPreferredSize(new java.awt.Dimension(640, 450));
        getContentPane().add(lblBacgroundLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesiónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesiónActionPerformed
        String pass = new String(fldPassword.getPassword());
        
        if(txtUsuarioLogin.getText().equals(nomAdmin)){
            if(pass.equals(passAdmin)){
                user = new Usuario();
                user.setTipo("Administrador");
                new Menu().show();
                //new UsuarioIndex().show();
                this.setVisible(false);
                return;
            }
        }
        
        for(Usuario user : listaUsuarios){
            if(this.txtUsuarioLogin.getText().equals(user.getCorreo())){
                if(pass.equals(user.getPassword())){
                    Hotel.user = user;
                    switch(user.getTipo()){
                        case "Administrador":
                            new Menu().show();
                            //new UsuarioIndex().show();
                        break;
                        case "Recepcionista":
                            new Menu().show();
                            //new UsuarioIndex().show();
                        break;
                        case "Cliente":
                            new ReservacionIndex(true).show();
                        break;
                    }
                    this.setVisible(false);
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Verifica tus datos");
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Verifica tus datos");
        return;
        
//        this.setVisible(false);
//        menu men = new menu();
//        men.setVisible(true);
    }//GEN-LAST:event_btnIniciarSesiónActionPerformed

    private void fldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldPasswordActionPerformed
        
    }//GEN-LAST:event_fldPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(Hotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hotel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesión;
    private javax.swing.JPasswordField fldPassword;
    private javax.swing.JLabel lblBacgroundLogin;
    private javax.swing.JLabel lblUserIcon;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUserName1;
    private javax.swing.JTextField txtUsuarioLogin;
    // End of variables declaration//GEN-END:variables
}
