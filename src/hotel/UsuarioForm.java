package hotel;

import datos.Habitacion;
import datos.Reservacion;
import datos.Usuario;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioForm extends javax.swing.JFrame {
    private Usuario user;
    private boolean band;
    private SimpleDateFormat fechaF;
    
    public UsuarioForm() {
        initComponents();
    }
    
    public UsuarioForm(boolean band) {
        fechaF = new SimpleDateFormat("dd/MM/YYYY");
        this.band=band;
        user = new Usuario();
        initComponents();
        this.setLocationRelativeTo(null);
        this.txtId.setEnabled(false);
        this.btnModificar.setVisible(false);
        this.txtId.setText(String.valueOf(Hotel.nuevoIdUsuario()));
        
        if(Hotel.user.getTipo().equalsIgnoreCase("Recepcionista")){
            this.cmbTipo.setEnabled(false);
        }
        
        if(!band){
            this.cmbTipo.setEnabled(false);
        }
    }
    
    public UsuarioForm(int id, boolean band) {
        fechaF = new SimpleDateFormat("dd/MM/YYYY");
        this.band=band;
        user = Hotel.buscarUsuario(id);
        initComponents();
        setDatosForm();
        
        this.setLocationRelativeTo(null);
        this.txtId.setText(String.valueOf(id));
        this.btnRegistrar.setVisible(false);
        
        if(Hotel.user.getTipo().equalsIgnoreCase("Recepcionista")){
            this.cmbTipo.setEnabled(false);
            this.lblContrasenia.setVisible(false);
            this.txtPass.setVisible(false);
            if(Hotel.user.getId()==id){
                this.lblContrasenia.setVisible(true);
                this.txtPass.setVisible(true);
            }
            if(user.getTipo().equalsIgnoreCase("Administrador")||user.getTipo().equalsIgnoreCase("Recepcionista")){
                this.btnEliminar.setVisible(false);
                this.btnModificar.setVisible(false);
            }
        }
        
        if(!band){
            this.cmbTipo.setEnabled(false);
        }
    }
    
    public boolean validarEmail(String email, int id){
        for(Usuario user : Hotel.listaUsuarios){
            if(user.getCorreo().equals(email)){
                if(user.getId()==id){
                    return true;
                }
                return false;
            }
        }
        return true;
    }
    
    public void setDatosForm(){
        txtNombre.setText(user.getNombre());
        txtApellidos.setText(user.getApellidos());
        txtDireccion.setText(user.getDireccion());
        txtTelefono.setText(user.getTelefono());
        txtCorreo.setText(user.getCorreo());
        this.selectorFecha.setDate(user.getFechNac());
        cmbTipo.setSelectedItem(user.getTipo());
        txtPass.setText(user.getPassword());
    }
    
    public void capturarDatos(){
        user.setId(Integer.valueOf(this.txtId.getText()));
        user.setNombre(txtNombre.getText().trim());
        user.setApellidos(txtApellidos.getText().trim());
        user.setDireccion(txtDireccion.getText().trim());
        user.setTelefono(txtTelefono.getText().trim());
        user.setCorreo(txtCorreo.getText().trim());
        user.setFechNac(this.selectorFecha.getDate());
//        user.setFechNac(selectorFecha.getDateFormatString());
        user.setTipo(cmbTipo.getSelectedItem().toString());
        user.setPassword(txtPass.getText());
    }
    
    public Date fechaMínima(){
        Date date = new Date();
        date.setTime(01-01-1900);
        return date;
    }
    
    public Date fechaMaxima(){
        Date date = new Date();
        date.setTime(25-05-2002);
        return date;
    }
    
    public boolean validarCampos(){
        Date fecha = selectorFecha.getDate();
        Date fecha2 = new Date();
        fecha2.setYear(fecha2.getYear()-18);
        
        if(!this.txtNombre.getText().matches("^([A-Za-záéíóúÑÁÉÍÓÚñ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+)$")){
            JOptionPane.showMessageDialog(null, "Error al capturar el nombre, inténtelo de nuevo.");
            return false;
        }
        
        if(!this.txtApellidos.getText().matches("^([A-Za-záéíóúÑÁÉÍÓÚñ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+)$")){
            JOptionPane.showMessageDialog(null, "Error al capturar el apellido, inténtelo de nuevo.");
            return false;
        }
        
        if(!this.txtDireccion.getText().matches("^.*(?=.*[0-9])(?=.*[a-zA-ZñÑ\\s]).*$")){
            JOptionPane.showMessageDialog(null, "Error al capturar la dirección, inténtelo de nuevo.");
            return false;
        }
        
        if(fecha==null){
            JOptionPane.showMessageDialog(null, "Error al capturar la fecha, inténtelo de nuevo.");
            
            return false;
        }
        
        if(fecha.after(fecha2)){
            JOptionPane.showMessageDialog(null, "Error al capturar la fecha, menor a la permitida.");
            return false;
        }
        
        fecha2.setYear(fecha2.getYear()-100);
        if(fecha.before(fecha2)){
            JOptionPane.showMessageDialog(null, "Error al capturar la fecha, mayor a la permitida.");
            return false;
        }
        
        if(this.txtTelefono.getText().length() == 10){
            if(!this.txtTelefono.getText().matches("[0-9]+")){
                JOptionPane.showMessageDialog(null, "Error al capturar el teléfono, inténtelo de nuevo.");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error al capturar el teléfono, inténtelo de nuevo.");
            return false;
        }
        
        if(!this.txtCorreo.getText().matches("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")){
            JOptionPane.showMessageDialog(null, "Error al capturar el correo, inténtelo de nuevo.");
            return false;
        }
        System.out.println(this.txtPass.getText().length());
        if(this.txtPass.getText().length()<8){
            JOptionPane.showMessageDialog(null, "Error al capturar la contraseña, minimo 8 caracteres.");
            return false;
        }
        
        if(!this.validarEmail(this.txtCorreo.getText(), Integer.valueOf(this.txtId.getText()))){
            JOptionPane.showMessageDialog(null, "Ese correo ya existe");
            return false;
        }
        
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblUserIcon = new javax.swing.JLabel();
        lblCabecera = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblFechaNacimiento = new javax.swing.JLabel();
        selectorFecha = new com.toedter.calendar.JDateChooser();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblTipoUsuario = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        lblContrasenia = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        lblCuerpo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro");
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitulo.setText("Bienvenido");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 120, 50));

        txtId.setEnabled(false);
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 80, 30));

        lblUserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_orange.png"))); // NOI18N
        getContentPane().add(lblUserIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 100));

        lblCabecera.setBackground(new java.awt.Color(242, 189, 61));
        lblCabecera.setOpaque(true);
        getContentPane().add(lblCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        lblId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblId.setForeground(new java.awt.Color(250, 250, 250));
        lblId.setText("ID");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 40, 30));

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(250, 250, 250));
        lblNombre.setText("Nombre");
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, 30));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 270, 30));

        lblApellidos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblApellidos.setForeground(new java.awt.Color(250, 250, 250));
        lblApellidos.setText("Apellidos");
        getContentPane().add(lblApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 100, 30));
        getContentPane().add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 270, 30));

        lblDireccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(250, 250, 250));
        lblDireccion.setText("Direccion");
        getContentPane().add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 100, 30));
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 270, 30));

        lblFechaNacimiento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblFechaNacimiento.setForeground(new java.awt.Color(250, 250, 250));
        lblFechaNacimiento.setText("Fecha de nacimiento");
        getContentPane().add(lblFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 180, 30));
        getContentPane().add(selectorFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 180, 30));

        lblTelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(250, 250, 250));
        lblTelefono.setText("Teléfono");
        getContentPane().add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 100, 30));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 270, 30));

        lblCorreo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(250, 250, 250));
        lblCorreo.setText("Correo");
        getContentPane().add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 100, 30));

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 270, 30));

        lblTipoUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTipoUsuario.setForeground(new java.awt.Color(250, 250, 250));
        lblTipoUsuario.setText("Tipo de usuario");
        getContentPane().add(lblTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 130, 30));

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Recepcionista", "Administrador" }));
        getContentPane().add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 230, 30));

        lblContrasenia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblContrasenia.setForeground(new java.awt.Color(250, 250, 250));
        lblContrasenia.setText("Contraseña");
        getContentPane().add(lblContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 100, 30));

        btnRegistrar.setBackground(new java.awt.Color(20, 215, 81));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(null);
        btnRegistrar.setMargin(new java.awt.Insets(500, 500, 500, 500));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 90, 40));

        btnRegresar.setBackground(new java.awt.Color(0, 121, 254));
        btnRegresar.setText("Regresar");
        btnRegresar.setBorder(null);
        btnRegresar.setMargin(new java.awt.Insets(500, 500, 500, 500));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 520, 90, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hoteles2.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 410, 350));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 90, 40));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 520, 90, 40));
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 430, 230, 30));

        lblCuerpo.setBackground(new java.awt.Color(249, 92, 73));
        lblCuerpo.setOpaque(true);
        getContentPane().add(lblCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 800, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        if(band){
            new UsuarioIndex().show();
        } else {
            new ClienteIndex().show();
        }
        
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(!this.validarCampos()){
            return;
        }
        
        capturarDatos();
        Hotel.listaUsuarios.add(user);
        try {
            Hotel.archivoUsuario.Save(Hotel.listaUsuarios);
        } catch (IOException ex) {
            Logger.getLogger(UsuarioForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(user.getTipo().equalsIgnoreCase("cliente")){
            Hotel.listaClientes.add(user);
        }
        if(band){
            new UsuarioIndex().show();
        } else {
            new ClienteIndex().show();
        }
        this.dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(!this.validarCampos()){
            return;
        }
        
        this.capturarDatos();
        try {
            Hotel.archivoUsuario.Save(Hotel.listaUsuarios);
        } catch (IOException ex) {
            Logger.getLogger(UsuarioForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(band){
            new UsuarioIndex().show();
        } else {
            new ClienteIndex().show();
        }
        this.dispose();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Hotel.listaUsuarios.remove(user);
        try {
            Hotel.archivoUsuario.Save(Hotel.listaUsuarios);
        } catch (IOException ex) {
            Logger.getLogger(UsuarioForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(band){
            new UsuarioIndex().show();
        } else {
            new ClienteIndex().show();
        }
        this.dispose();
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(UsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new UsuarioForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCabecera;
    private javax.swing.JLabel lblContrasenia;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblCuerpo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUserIcon;
    private com.toedter.calendar.JDateChooser selectorFecha;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
