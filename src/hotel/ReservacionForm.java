package hotel;

import datos.Habitacion;
import datos.Reservacion;
import datos.Usuario;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ReservacionForm extends javax.swing.JFrame {

    private Reservacion reser;
    public static int idHabitacion;
    public static int idCliente;
    private SimpleDateFormat fechaF;
    private DateFormat df = DateFormat.getDateInstance();

    public ReservacionForm() {
        reser = new Reservacion();
        fechaF = new SimpleDateFormat("dd/MM/YYYY");
        initComponents();
        this.setLocationRelativeTo(null);
        this.txtId.setEnabled(false);
        this.dcFechaReser.setEnabled(false);
        this.txtHora.setEnabled(false);
        this.txtIdClien.setEnabled(false);
        this.txtIdHab.setEnabled(false);
        this.dcFechaReser.setDate(new Date());
        this.txtHora.setText(horaActual());
        this.txtId.setText(String.valueOf(Hotel.nuevoIdReservacion()));
        this.btnModificar.setVisible(false);
        this.btnEliminar.setVisible(false);
    }

    public ReservacionForm(int id) {
        reser = Hotel.buscarReservacion(id);
        fechaF = new SimpleDateFormat("dd/MM/YYYY");
        initComponents();
        setDatos();
        this.setLocationRelativeTo(null);
        this.txtId.setEnabled(false);
        this.dcFechaReser.setEnabled(false);
        this.txtHora.setEnabled(false);
        this.txtIdClien.setEnabled(false);
        this.txtIdHab.setEnabled(false);
        this.txtId.setText(String.valueOf(id));
        //this.setVisible(false);
        this.btnRegistrar.setVisible(false);
    }

    public void setDatos() {
        this.txtId.setText(String.valueOf(reser.getId()));
        this.dcFechaReser.setDate(reser.getFechaReservacion());
        this.dcFechaEntrada.setDate(reser.getFechaEntrada());
        this.dcFechaSalida.setDate(reser.getFechaSalida());
        this.txtHora.setText(reser.getHoraReservacion());
        this.txtIdHab.setText(String.valueOf(reser.getId_habitacion()));
        this.txtIdClien.setText(String.valueOf(reser.getId_cliente()));
    }

    public String fechaActual() {
        Date fecha = new Date();
        return fechaF.format(fecha);
    }

    public String horaActual() {
        Date fecha = new Date();
        SimpleDateFormat formaFecha = new SimpleDateFormat("hh:mm");
        return formaFecha.format(fecha);
    }

    public boolean validacion() {
        fechaF = new SimpleDateFormat("dd/MM/YYYY");
        if (this.dcFechaEntrada.getDate() == null
                && this.dcFechaSalida.getDate() == null
                && this.txtIdHab.getText().equals("")
                && this.txtIdClien.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campos vacios");
            return false;
        }

        if (this.dcFechaEntrada.getDate() == null) {
            JOptionPane.showMessageDialog(null, "La fecha de ingreso esta vacia");
            return false;
        }

        if (this.dcFechaSalida.getDate() == null) {
            JOptionPane.showMessageDialog(null, "La fecha de salida esta vacia");
            return false;
        }

        if (this.dcFechaEntrada.getDate().before(this.dcFechaReser.getDate())) {
            JOptionPane.showMessageDialog(null, "No se pueden ingresar fechas anteriores a la actual");
            return false;
        }
        if (this.dcFechaSalida.getDate().before(this.dcFechaReser.getDate())) {
            JOptionPane.showMessageDialog(null, "No se pueden ingresar fechas anteriores a la actual");
            return false;
        }

        if (this.dcFechaSalida.getDate().before(this.dcFechaEntrada.getDate())) {
            JOptionPane.showMessageDialog(null, "No se puede ingresar fecha antierior a la de entrada");
            return false;
        }

        if (this.txtIdHab.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No hay ID de habitacion");
            return false;
        }

        if (this.txtIdClien.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No hay ID de cliente");
            return false;
        }

        for (int i = 0; i < Hotel.listaReservaciones.size(); i++) {
            if (this.dcFechaEntrada.getDate().equals(Hotel.listaReservaciones.get(i).getFechaEntrada())) {
                if (this.txtIdHab.getText().equals(String.valueOf(Hotel.listaReservaciones.get(i).getId_habitacion()))) {
                    JOptionPane.showMessageDialog(null, "Habitación ya reservada");
                    return false;
                }
                
                if (this.txtIdClien.getText().equals(String.valueOf(Hotel.listaReservaciones.get(i).getId_cliente()))) {
                    JOptionPane.showMessageDialog(null, "El cliente ya esta hospedado");
                    return false;
                }
            }
        }

        return true;
    }
    
    public boolean validacionModificar(){
        fechaF = new SimpleDateFormat("dd/MM/YYYY");
        if (this.dcFechaEntrada.getDate() == null
                && this.dcFechaSalida.getDate() == null
                && this.txtIdHab.getText().equals("")
                && this.txtIdClien.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campos vacios");
            return false;
        }

        if (this.dcFechaEntrada.getDate() == null) {
            JOptionPane.showMessageDialog(null, "La fecha de ingreso esta vacia");
            return false;
        }

        if (this.dcFechaSalida.getDate() == null) {
            JOptionPane.showMessageDialog(null, "La fecha de salida esta vacia");
            return false;
        }

        if (this.dcFechaEntrada.getDate().before(this.dcFechaReser.getDate())) {
            JOptionPane.showMessageDialog(null, "No se pueden ingresar fechas anteriores a la actual");
            return false;
        }
        if (this.dcFechaSalida.getDate().before(this.dcFechaReser.getDate())) {
            JOptionPane.showMessageDialog(null, "No se pueden ingresar fechas anteriores a la actual");
            return false;
        }

        if (this.dcFechaSalida.getDate().before(this.dcFechaEntrada.getDate())) {
            JOptionPane.showMessageDialog(null, "No se puede ingresar fecha antierior a la de entrada");
            return false;
        }

        if (this.txtIdHab.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No hay ID de habitacion");
            return false;
        }

        if (this.txtIdClien.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No hay ID de cliente");
            return false;
        }

        for (int i = 0; i < Hotel.listaReservaciones.size(); i++) {
            if (this.dcFechaEntrada.getDate().equals(Hotel.listaReservaciones.get(i).getFechaEntrada())) {
                if (this.txtIdHab.getText().equals(String.valueOf(Hotel.listaReservaciones.get(i).getId_habitacion()))) {
                    JOptionPane.showMessageDialog(null, "Habitación ya reservada");
                    return false;
                }
            }
        }

        return true;
    }
    public void capturarDatos() {
        reser.setId_habitacion(Integer.valueOf(this.txtIdHab.getText()));
        reser.setId_cliente(Integer.valueOf(this.txtIdClien.getText()));
        reser.setId(Integer.valueOf(txtId.getText()));
        reser.setFechaReservacion(this.dcFechaReser.getDate());
        reser.setFechaEntrada(this.dcFechaEntrada.getDate());
        reser.setFechaSalida(this.dcFechaSalida.getDate());
        reser.setHoraReservacion(this.txtHora.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUserIcon = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblCabecera = new javax.swing.JLabel();
        lblIdCliente = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        lblFechaSalida = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        lblIdHabitacion = new javax.swing.JLabel();
        lblFechaResaervacion = new javax.swing.JLabel();
        lblHoraReservacion = new javax.swing.JLabel();
        dcFechaSalida = new com.toedter.calendar.JDateChooser();
        lblFechaEntrada = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        dcFechaEntrada = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtHora1 = new javax.swing.JTextField();
        btnSelecClien = new javax.swing.JButton();
        btnSelecHab = new javax.swing.JButton();
        dcFechaReser = new com.toedter.calendar.JDateChooser();
        txtIdHab = new javax.swing.JTextField();
        txtIdClien = new javax.swing.JTextField();
        btnRefClien = new javax.swing.JButton();
        btnRefHab = new javax.swing.JButton();
        btnRefClien1 = new javax.swing.JButton();
        lblCuerpo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reservaciones");
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check (1).png"))); // NOI18N
        getContentPane().add(lblUserIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 100));

        btnRegresar.setBackground(new java.awt.Color(0, 121, 254));
        btnRegresar.setText("REGRESAR");
        btnRegresar.setBorder(null);
        btnRegresar.setMargin(new java.awt.Insets(500, 500, 500, 500));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 540, 100, 40));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitulo.setText("Reserva ya tu habitación");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 290, 50));

        lblCabecera.setBackground(new java.awt.Color(242, 189, 61));
        lblCabecera.setOpaque(true);
        getContentPane().add(lblCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        lblIdCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblIdCliente.setForeground(new java.awt.Color(250, 250, 250));
        lblIdCliente.setText("ID Cliente");
        getContentPane().add(lblIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 130, 30));
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 100, 30));

        lblId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblId.setForeground(new java.awt.Color(250, 250, 250));
        lblId.setText("ID");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 40, 30));

        lblFechaSalida.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblFechaSalida.setForeground(new java.awt.Color(250, 250, 250));
        lblFechaSalida.setText("Fecha de salida");
        getContentPane().add(lblFechaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 130, 30));

        txtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraActionPerformed(evt);
            }
        });
        getContentPane().add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 160, 30));

        lblIdHabitacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblIdHabitacion.setForeground(new java.awt.Color(250, 250, 250));
        lblIdHabitacion.setText("ID Habitacion");
        getContentPane().add(lblIdHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 130, 30));

        lblFechaResaervacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblFechaResaervacion.setForeground(new java.awt.Color(250, 250, 250));
        lblFechaResaervacion.setText("Fecha de reservacion");
        getContentPane().add(lblFechaResaervacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 170, 30));

        lblHoraReservacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblHoraReservacion.setForeground(new java.awt.Color(250, 250, 250));
        lblHoraReservacion.setText("Hora de reservacion");
        getContentPane().add(lblHoraReservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 170, 30));

        dcFechaSalida.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcFechaSalidaPropertyChange(evt);
            }
        });
        getContentPane().add(dcFechaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 160, 30));

        lblFechaEntrada.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblFechaEntrada.setForeground(new java.awt.Color(250, 250, 250));
        lblFechaEntrada.setText("Fecha de entrada");
        getContentPane().add(lblFechaEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 160, 30));

        btnRegistrar.setBackground(new java.awt.Color(20, 215, 81));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(null);
        btnRegistrar.setMargin(new java.awt.Insets(500, 500, 500, 500));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 480, 140, 40));

        dcFechaEntrada.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcFechaEntradaPropertyChange(evt);
            }
        });
        getContentPane().add(dcFechaEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 160, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hotelCrud.PNG"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 320, 290));

        btnModificar.setBackground(new java.awt.Color(20, 215, 81));
        btnModificar.setText("Modificar");
        btnModificar.setBorder(null);
        btnModificar.setMargin(new java.awt.Insets(500, 500, 500, 500));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 140, 40));

        btnEliminar.setBackground(new java.awt.Color(20, 215, 81));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setMargin(new java.awt.Insets(500, 500, 500, 500));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 480, 140, 40));

        txtHora1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHora1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtHora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 160, 30));

        btnSelecClien.setText("Seleccionar");
        btnSelecClien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecClienActionPerformed(evt);
            }
        });
        getContentPane().add(btnSelecClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, -1, -1));

        btnSelecHab.setText("Seleccionar");
        btnSelecHab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecHabActionPerformed(evt);
            }
        });
        getContentPane().add(btnSelecHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, -1, -1));
        getContentPane().add(dcFechaReser, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 240, 160, 30));
        getContentPane().add(txtIdHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 80, -1));
        getContentPane().add(txtIdClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 80, -1));

        btnRefClien.setText("R");
        btnRefClien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefClienActionPerformed(evt);
            }
        });
        getContentPane().add(btnRefClien, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, -1, -1));

        btnRefHab.setText("R");
        btnRefHab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefHabActionPerformed(evt);
            }
        });
        getContentPane().add(btnRefHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, -1, -1));

        btnRefClien1.setText("R");
        btnRefClien1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefClien1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnRefClien1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, -1, -1));

        lblCuerpo.setBackground(new java.awt.Color(249, 92, 73));
        lblCuerpo.setOpaque(true);
        getContentPane().add(lblCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 800, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        new ReservacionIndex().show();
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (!validacionModificar()) {
            return;
        }
        this.capturarDatos();
        try {
            Hotel.archivoReservacion.Save(Hotel.listaReservaciones);

//        try {
//            Hotel.archivoReservacion.Save(Hotel.listaReservaciones);
//        } catch (IOException ex) {
//            Logger.getLogger(ReservacionForm.class.getName()).log(Level.SEVERE, null, ex);
//            Logger.getLogger(HabitacionForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        new ReservacionIndex(Hotel.listaReservaciones).show();
//        this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(ReservacionForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        new ReservacionIndex().show();
        this.dispose();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Hotel.listaReservaciones.remove(reser);
        try {
            Hotel.archivoReservacion.Save(Hotel.listaReservaciones);
        } catch (IOException ex) {
            Logger.getLogger(UsuarioForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        new ReservacionIndex().show();
        this.dispose();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (!validacion()) {
            return;
        }
        try {
            capturarDatos();
            Hotel.listaReservaciones.add(reser);
            Hotel.archivoReservacion.Save(Hotel.listaReservaciones);
            new ReservacionIndex().show();
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(ReservacionForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraActionPerformed

    private void txtHora1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHora1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHora1ActionPerformed

    private void btnSelecHabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecHabActionPerformed
        if (this.dcFechaEntrada.getDate() == null || this.dcFechaSalida.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Primero selecciona una Una fecha");
            return;
        }
        ArrayList<Habitacion> lista = new ArrayList();
        Date FechaE = this.dcFechaEntrada.getDate();
        Date FechaS = this.dcFechaSalida.getDate();
        boolean band = true;
        Hotel.cargarListaClientes();

        for (Habitacion hab : Hotel.listaHabitaciones) {
            for (Reservacion reser : Hotel.listaReservaciones) {
                if (hab.getId() == reser.getId_habitacion()) {
                    if (FechaE.after(reser.getFechaEntrada())
                            && FechaE.before(reser.getFechaSalida())) {
                        band = false;
                        break;
                    }
                    if (FechaS.after(reser.getFechaEntrada())
                            && FechaS.before(reser.getFechaSalida())) {
                        band = false;
                        break;
                    }
                }
            }
            if (band) {
                lista.add(hab);
            }
            band = true;
        }
        if (lista.size() == 0) {
            JOptionPane.showMessageDialog(null, "No tiene ninguna habitacion disponible");
            return;
        }
        new HabitacionIndex(lista, true).show();
    }//GEN-LAST:event_btnSelecHabActionPerformed

    private void btnRefClienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefClienActionPerformed
        if(idCliente==0){
            JOptionPane.showMessageDialog(null, "No has seleccionado cliente");
            return;
        }
        this.txtIdClien.setText(String.valueOf(idCliente));
    }//GEN-LAST:event_btnRefClienActionPerformed

    private void btnRefHabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefHabActionPerformed
        if(idHabitacion==0){
            JOptionPane.showMessageDialog(null, "No has seleccionado habitacion");
            return;
        }
        this.txtIdHab.setText(String.valueOf(idHabitacion));
    }//GEN-LAST:event_btnRefHabActionPerformed

    private void btnRefClien1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefClien1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRefClien1ActionPerformed

    private void btnSelecClienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecClienActionPerformed
        if (this.dcFechaEntrada.getDate() == null || this.dcFechaSalida.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Primero selecciona una Una fecha");
            return;
        }
        ArrayList<Usuario> lista = new ArrayList();
        Date FechaE = this.dcFechaEntrada.getDate();
        Date FechaS = this.dcFechaSalida.getDate();
        boolean band = true;
        Hotel.cargarListaClientes();

        for (Usuario user : Hotel.listaClientes) {
            for (Reservacion reser : Hotel.listaReservaciones) {
                if (user.getId() == reser.getId_cliente()) {
                    if (FechaE.after(reser.getFechaEntrada())
                            && FechaE.before(reser.getFechaSalida())) {
                        band = false;
                        break;
                    }
                    if (FechaS.after(reser.getFechaEntrada())
                            && FechaS.before(reser.getFechaSalida())) {
                        band = false;
                        break;
                    }
                }

            }
            if (band) {
                lista.add(user);
            }
            band = true;
        }
        if (lista.size() == 0) {
            JOptionPane.showMessageDialog(null, "No tiene ninguna habitacion disponible");
            return;
        }
        new ClienteIndex(lista).show();
    }//GEN-LAST:event_btnSelecClienActionPerformed

    private void dcFechaEntradaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcFechaEntradaPropertyChange
        try {
            this.txtIdHab.setText("");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_dcFechaEntradaPropertyChange

    private void dcFechaSalidaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcFechaSalidaPropertyChange
        try {
            this.txtIdHab.setText("");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_dcFechaSalidaPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservacionForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRefClien;
    private javax.swing.JButton btnRefClien1;
    private javax.swing.JButton btnRefHab;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSelecClien;
    private javax.swing.JButton btnSelecHab;
    private com.toedter.calendar.JDateChooser dcFechaEntrada;
    private com.toedter.calendar.JDateChooser dcFechaReser;
    private com.toedter.calendar.JDateChooser dcFechaSalida;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblCabecera;
    private javax.swing.JLabel lblCuerpo;
    private javax.swing.JLabel lblFechaEntrada;
    private javax.swing.JLabel lblFechaResaervacion;
    private javax.swing.JLabel lblFechaSalida;
    private javax.swing.JLabel lblHoraReservacion;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdCliente;
    private javax.swing.JLabel lblIdHabitacion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUserIcon;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtHora1;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdClien;
    private javax.swing.JTextField txtIdHab;
    // End of variables declaration//GEN-END:variables
}
