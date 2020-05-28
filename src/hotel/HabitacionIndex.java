package hotel;

import datos.Habitacion;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HabitacionIndex extends javax.swing.JFrame {
    private DefaultTableModel modelo;
    ArrayList<Habitacion> listaHabitaciones;
    
    public HabitacionIndex() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = (DefaultTableModel) this.tableIndex.getModel();
        this.cargarTabla();
    }
    public HabitacionIndex(ArrayList<Habitacion> lista) {
        this.listaHabitaciones=lista;
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = (DefaultTableModel) this.tableIndex.getModel();
        this.cargarTabla();
    }
    
    public HabitacionIndex(ArrayList<Habitacion> lista,boolean band) {
        this.listaHabitaciones=lista;
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = (DefaultTableModel) this.tableIndex.getModel();
        this.btnAgregar.setVisible(false);
        this.btnMenu.setVisible(false);
        this.btnMostrar.setVisible(false);
        this.cargarTabla();
    }
    
    
    public void buscar(int id){
        String array[] = new String[6];
        
        for(Habitacion habitacion : listaHabitaciones){
            if(id==habitacion.getId() || id == habitacion.getNumero()){
                array[0] = String.valueOf(habitacion.getId());
                array[1] = String.valueOf(habitacion.getNumero());
                array[2] = String.valueOf(habitacion.getHabitaciones());
                array[3] = String.valueOf(habitacion.getBanios());
                array[4] = habitacion.isAmueblada() ? "Sí" : "No";
                array[5] = habitacion.isIntYcab() ? "Sí" : "No";
                modelo.addRow(array);
            }
        }
        //JOptionPane.showMessageDialog(null, "No se hayaron resultados");
    }
    
    public void cargarTabla(){
        eliminar();
        String array[] = new String[6];
        
        for(Habitacion habitacion : listaHabitaciones){
            array[0] = String.valueOf(habitacion.getId());
            array[1] = String.valueOf(habitacion.getNumero());
            array[2] = String.valueOf(habitacion.getHabitaciones());
            array[3] = String.valueOf(habitacion.getBanios());
            array[4] = habitacion.isAmueblada() ? "Sí" : "No";
            array[5] = habitacion.isIntYcab() ? "Sí" : "No";
            modelo.addRow(array);
        }
    }
    
    public void eliminar(){
        int i=0;
        while(i<modelo.getRowCount()){
            modelo.removeRow(i);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBase = new javax.swing.JPanel();
        panelNav = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textBuscar = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableIndex = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBase.setBackground(new java.awt.Color(249, 92, 73));
        panelBase.setMinimumSize(new java.awt.Dimension(800, 600));
        panelBase.setLayout(null);

        panelNav.setBackground(new java.awt.Color(242, 189, 61));
        panelNav.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cama.png"))); // NOI18N
        panelNav.add(jLabel2);
        jLabel2.setBounds(30, 10, 40, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("HABITACIONES");
        panelNav.add(jLabel9);
        jLabel9.setBounds(70, 10, 170, 29);

        textBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelNav.add(textBuscar);
        textBuscar.setBounds(430, 10, 260, 30);

        jbBuscar.setBackground(new java.awt.Color(255, 153, 0));
        jbBuscar.setForeground(new java.awt.Color(230, 163, 9));
        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa.png"))); // NOI18N
        jbBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });
        panelNav.add(jbBuscar);
        jbBuscar.setBounds(690, 10, 30, 30);

        panelBase.add(panelNav);
        panelNav.setBounds(0, 0, 800, 50);

        tableIndex.setBackground(new java.awt.Color(192, 187, 60));
        tableIndex.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableIndex.setForeground(new java.awt.Color(250, 250, 250));
        tableIndex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NÚMERO", "HABITACIONES", "BAÑOS", "AMUEBLADA", "INTERNET Y CABLE"
            }
        ));
        tableIndex.setRowHeight(50);
        tableIndex.setSelectionBackground(new java.awt.Color(20, 215, 81));
        jScrollPane1.setViewportView(tableIndex);
        if (tableIndex.getColumnModel().getColumnCount() > 0) {
            tableIndex.getColumnModel().getColumn(0).setMinWidth(100);
            tableIndex.getColumnModel().getColumn(0).setMaxWidth(100);
            tableIndex.getColumnModel().getColumn(1).setMinWidth(150);
            tableIndex.getColumnModel().getColumn(1).setMaxWidth(150);
        }

        panelBase.add(jScrollPane1);
        jScrollPane1.setBounds(60, 120, 660, 400);

        btnAgregar.setBackground(new java.awt.Color(71, 71, 255));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("AÑADIR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        panelBase.add(btnAgregar);
        btnAgregar.setBounds(60, 540, 100, 35);

        btnMenu.setBackground(new java.awt.Color(71, 71, 255));
        btnMenu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        panelBase.add(btnMenu);
        btnMenu.setBounds(620, 540, 100, 35);

        btnMostrar.setBackground(new java.awt.Color(71, 71, 255));
        btnMostrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrar.setText("MOSTRAR");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        panelBase.add(btnMostrar);
        btnMostrar.setBounds(340, 540, 100, 35);

        btnAceptar.setBackground(new java.awt.Color(71, 71, 255));
        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        panelBase.add(btnAceptar);
        btnAceptar.setBounds(340, 540, 100, 35);

        btnRefrescar.setBackground(new java.awt.Color(71, 71, 255));
        btnRefrescar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRefrescar.setForeground(new java.awt.Color(255, 255, 255));
        btnRefrescar.setText("REFRESCAR");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });
        panelBase.add(btnRefrescar);
        btnRefrescar.setBounds(60, 70, 100, 35);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        new HabitacionForm().show();
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        new Menu().show();
        this.dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        if(tableIndex.getSelectedRow()==-1){
            return;
        }
        new HabitacionForm(Integer.valueOf(tableIndex.getValueAt(tableIndex.getSelectedRow(),0).toString())).show();
        this.dispose();
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if(tableIndex.getSelectedRow()==-1){
            return;
        }
        ReservacionForm.idHabitacion = Integer.valueOf(tableIndex.getValueAt(tableIndex.getSelectedRow(),0).toString());
        //new HabitacionForm(Integer.valueOf(tableIndex.getValueAt(tableIndex.getSelectedRow(),0).toString())).show();
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        eliminar();
        
        if(this.textBuscar.getText().matches("[0-9]+")){
            this.buscar(Integer.valueOf(this.textBuscar.getText()));
        } 
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        this.cargarTabla();
    }//GEN-LAST:event_btnRefrescarActionPerformed

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
            java.util.logging.Logger.getLogger(HabitacionIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HabitacionIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HabitacionIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HabitacionIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HabitacionIndex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JPanel panelBase;
    private javax.swing.JPanel panelNav;
    private javax.swing.JTable tableIndex;
    private javax.swing.JTextField textBuscar;
    // End of variables declaration//GEN-END:variables
}
