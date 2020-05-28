/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import datos.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author estebansg
 */
public class UsuarioIndex extends javax.swing.JFrame {
    private DefaultTableModel modelo;
    /**
     * Creates new form index
     */
    
    public UsuarioIndex() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = (DefaultTableModel) this.tableIndex.getModel();
        
        switch(Hotel.user.getTipo()){
            case "Administrador":
                this.btnBuscarClien.setVisible(false);
                this.btnRefrescarClien.setVisible(false);
                this.cargarTabla();
                break;
            case "Recepcionista":
                this.btnBuscar.setVisible(false);
                this.btnRefrescar.setVisible(false);
                cargarTablaRecep();
                break;
        }
    }
    
    public UsuarioIndex(boolean band, boolean band2) {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = (DefaultTableModel) this.tableIndex.getModel();
        this.btnMenu.setVisible(false);
        this.btnMostrar.setVisible(false);
        cargarTablaRecep();
    }
    
    public UsuarioIndex(boolean band) {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = (DefaultTableModel) this.tableIndex.getModel();
        
//        switch(Hotel.user.getTipo()){
//            case "Administrador":
//                this.btnBuscarClien.setVisible(false);
//                this.btnRefrescarClien.setVisible(false);
//                this.cargarTabla();
//                break;
//            case "Recepcionista":
//                this.btnBuscar.setVisible(false);
//                this.btnRefrescar.setVisible(false);
//                cargarTablaRecep();
//                break;
//        }
        this.btnMenu.setVisible(false);
        this.btnMostrar.setVisible(false);
        cargarTablaRecep();
    }
    
    public void cargarTablaRecep(){
        eliminar();
        String array[] = new String[4];
        
        for(Usuario user : Hotel.listaUsuarios){
            array[0] = String.valueOf(user.getId());
            array[1] = user.getNombre();
            array[2] = user.getCorreo();
            array[3] = user.getTipo();
            modelo.addRow(array);
        }
    }
    
    public void buscarClien(int id){
        String array[] = new String[4];
        
        for(Usuario user : Hotel.listaUsuarios){
            if(id==user.getId()){
                array[0] = String.valueOf(user.getId());
                array[1] = user.getNombre();
                array[2] = user.getCorreo();
                array[3] = user.getTipo();
                modelo.addRow(array);
                return; 
            }
        }
        JOptionPane.showMessageDialog(null, "No se hayaron resultados");
    }
    
    public void buscarClien(String nombre){
        String array[] = new String[4];
        boolean band=false;
        
        for(Usuario user : Hotel.listaUsuarios){
            if(nombre.equalsIgnoreCase(user.getNombre())){
                array[0] = String.valueOf(user.getId());
                array[1] = user.getNombre();
                array[2] = user.getCorreo();
                array[3] = user.getTipo();
                modelo.addRow(array);
                band=true;
            }
        }
        if(!band){
            JOptionPane.showMessageDialog(null, "No se hayaron resultados");
        }
    }
    
    public void buscar(int id){
        String array[] = new String[4];
        
        for(Usuario user : Hotel.listaUsuarios){
            if(id==user.getId()){
                array[0] = String.valueOf(user.getId());
                array[1] = user.getNombre();
                array[2] = user.getCorreo();
                array[3] = user.getTipo();
                modelo.addRow(array);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se hayaron resultados");
    }
    
    public void buscar(String nombre){
        String array[] = new String[4];
        boolean band=false;
        
        for(Usuario user : Hotel.listaUsuarios){
            if(nombre.equals(user.getNombre())){
                array[0] = String.valueOf(user.getId());
                array[1] = user.getNombre();
                array[2] = user.getCorreo();
                array[3] = user.getTipo();
                modelo.addRow(array);
                band=true;
            }
        }
        if(!band){
            JOptionPane.showMessageDialog(null, "No se hayaron resultados");
        }
    }
    
    public void cargarTabla(){
        eliminar();
        String array[] = new String[4];
        
        for(Usuario user : Hotel.listaUsuarios){
            array[0] = String.valueOf(user.getId());
            array[1] = user.getNombre();
            array[2] = user.getCorreo();
            array[3] = user.getTipo();
            modelo.addRow(array);
        }
    }
    
    public void eliminar(){
        int i=0;
        while(i<modelo.getRowCount()){
            modelo.removeRow(i);
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

        panelBase = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableIndex = new javax.swing.JTable();
        textBuscar = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnBuscarClien = new javax.swing.JButton();
        btnRefrescarClien = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));

        panelBase.setBackground(new java.awt.Color(249, 92, 73));
        panelBase.setMaximumSize(new java.awt.Dimension(800, 600));
        panelBase.setMinimumSize(new java.awt.Dimension(800, 600));
        panelBase.setLayout(null);

        tableIndex.setBackground(new java.awt.Color(192, 187, 60));
        tableIndex.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableIndex.setForeground(new java.awt.Color(250, 250, 250));
        tableIndex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "EMAIL", "TIPO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableIndex.setRowHeight(50);
        tableIndex.setSelectionBackground(new java.awt.Color(20, 215, 81));
        jScrollPane1.setViewportView(tableIndex);
        if (tableIndex.getColumnModel().getColumnCount() > 0) {
            tableIndex.getColumnModel().getColumn(0).setMinWidth(80);
            tableIndex.getColumnModel().getColumn(0).setMaxWidth(80);
            tableIndex.getColumnModel().getColumn(3).setMinWidth(150);
            tableIndex.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        panelBase.add(jScrollPane1);
        jScrollPane1.setBounds(53, 85, 700, 440);
        panelBase.add(textBuscar);
        textBuscar.setBounds(200, 30, 300, 30);

        btnNuevo.setBackground(new java.awt.Color(71, 71, 255));
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        panelBase.add(btnNuevo);
        btnNuevo.setBounds(670, 30, 80, 30);

        btnRefrescar.setBackground(new java.awt.Color(71, 71, 255));
        btnRefrescar.setForeground(new java.awt.Color(255, 255, 255));
        btnRefrescar.setText("REFRESCAR");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });
        panelBase.add(btnRefrescar);
        btnRefrescar.setBounds(50, 30, 110, 30);

        btnBuscar.setBackground(new java.awt.Color(71, 71, 255));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        panelBase.add(btnBuscar);
        btnBuscar.setBounds(500, 30, 80, 30);

        btnBuscarClien.setText("BUSCAR");
        btnBuscarClien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienActionPerformed(evt);
            }
        });
        panelBase.add(btnBuscarClien);
        btnBuscarClien.setBounds(500, 30, 80, 30);

        btnRefrescarClien.setText("Refrescar");
        btnRefrescarClien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarClienActionPerformed(evt);
            }
        });
        panelBase.add(btnRefrescarClien);
        btnRefrescarClien.setBounds(50, 30, 90, 30);

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
        btnMenu.setBounds(650, 540, 100, 35);

        btnMostrar.setBackground(new java.awt.Color(71, 71, 255));
        btnMostrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        panelBase.add(btnMostrar);
        btnMostrar.setBounds(360, 540, 100, 35);

        btnAceptar.setBackground(new java.awt.Color(71, 71, 255));
        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        panelBase.add(btnAceptar);
        btnAceptar.setBounds(360, 540, 100, 35);

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

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        new UsuarioForm(true).show();
        this.dispose();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        cargarTabla();
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        eliminar();
        if(!this.textBuscar.getText().matches("[0-9]+")){
            if(!this.textBuscar.getText().matches("^[a-z A-Z]+")){
                System.out.println("");
                cargarTabla();
                return;
            } else {
                buscar(textBuscar.getText());
            }
        } else {
            buscar(Integer.valueOf(textBuscar.getText()));
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRefrescarClienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarClienActionPerformed
        this.cargarTablaRecep();
    }//GEN-LAST:event_btnRefrescarClienActionPerformed

    private void btnBuscarClienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienActionPerformed
        eliminar();
        if(!this.textBuscar.getText().matches("[0-9]+")){
            if(!this.textBuscar.getText().matches("[a-z A-Z]+")){
                System.out.println("");
                cargarTabla();
                return;
            } else {
                buscarClien(textBuscar.getText());
            }
        } else {
            buscarClien(Integer.valueOf(textBuscar.getText()));
        }
    }//GEN-LAST:event_btnBuscarClienActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        new Menu().show();
        this.dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        if(tableIndex.getSelectedRow()==-1){
            return;
        }
        new UsuarioForm(Integer.valueOf(tableIndex.getValueAt(tableIndex.getSelectedRow(),0).toString()),true).show();
        this.dispose();
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if(tableIndex.getSelectedRow()==-1){
            return;
        }
        ReservacionForm.idCliente = Integer.valueOf(tableIndex.getValueAt(tableIndex.getSelectedRow(),0).toString());
        //new HabitacionForm(Integer.valueOf(tableIndex.getValueAt(tableIndex.getSelectedRow(),0).toString())).show();
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(UsuarioIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioIndex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarClien;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnRefrescarClien;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBase;
    private javax.swing.JTable tableIndex;
    private javax.swing.JTextField textBuscar;
    // End of variables declaration//GEN-END:variables
}
