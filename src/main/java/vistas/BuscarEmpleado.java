/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controlador.Reporte;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import newpackage.Empleado;
import newpackage.Menu;
import newpackage.Sucursal;

/**
 *
 * @author bajog
 */
public class BuscarEmpleado extends javax.swing.JFrame {

    /**
     * Creates new form BuscarEmpleado
     */
    public BuscarEmpleado() {
        initComponents();
        llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBuscarEmpleado = new javax.swing.JLabel();
        txtBuscarEmpleado = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmpleados = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        lblMensajeEmergente = new javax.swing.JLabel();
        btnEditarEmpleado = new javax.swing.JButton();
        btnEliminarEmpleado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblBuscarEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblBuscarEmpleado.setText("Buscar Empleado");

        txtBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarEmpleadoActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        tableEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableEmpleados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableEmpleados);

        btnVolver.setText("Volver");
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });

        btnEditarEmpleado.setText("Editar");
        btnEditarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarEmpleadoMouseClicked(evt);
            }
        });

        btnEliminarEmpleado.setText("Eliminar");
        btnEliminarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarEmpleadoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMensajeEmergente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(btnEditarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(btnEliminarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBuscarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblMensajeEmergente)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnCerrar)
                    .addComponent(btnEditarEmpleado)
                    .addComponent(btnEliminarEmpleado))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarEmpleadoActionPerformed

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        // TODO add your handling code here:
        // Capturar el valor de búsqueda
        String criterioBusqueda = txtBuscarEmpleado.getText().trim().toLowerCase();

        // Crear un modelo nuevo para la tabla
        DefaultTableModel modeloDefault = new DefaultTableModel(new String[] {"Rut", "Nombre", "Ministerio", "Cargo"}, 0);
        tableEmpleados.setModel(modeloDefault);

        // Buscar empleados que coincidan con el criterio de búsqueda
        for (int i = 0; i < Menu.getSizeEmpleados(); i++) {
            Empleado empleado = Menu.getEmpleados(i);
            String rut = empleado.getRut().toLowerCase();
            String nombre = empleado.getNombre().toLowerCase();

            // Si el nombre o rut del empleado contiene el criterio de búsqueda
            if (rut.contains(criterioBusqueda) || nombre.contains(criterioBusqueda)) {
                // Agregar la fila al modelo de la tabla
                modeloDefault.addRow(new Object[]{
                    empleado.getRut(),
                    empleado.getNombre(),
                    empleado.getDepartamento(),
                    empleado.getCargo()
                });
            }
        }

        // Si no se encuentra ningún empleado, mostrar un mensaje emergente
        if (modeloDefault.getRowCount() == 0) {
            lblMensajeEmergente.setText("No se encontraron empleados con ese criterio de búsqueda.");
            lblMensajeEmergente.setForeground(Color.red);
        } else {
            lblMensajeEmergente.setText(""); // Limpiar mensaje si encuentra resultados
        }
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        // TODO add your handling code here:
        this.dispose();
        MenuEmpleados.iniciar();
    }//GEN-LAST:event_btnVolverMouseClicked

    private void btnEditarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarEmpleadoMouseClicked
        // TODO add your handling code here:
        this.dispose();
        int fila = tableEmpleados.getSelectedRow(); // Obtener el índice de la fila seleccionada

        if (fila == -1) {
            // Si no hay ninguna fila seleccionada, mostrar un mensaje de error
            lblMensajeEmergente.setText("Por favor, seleccione un empleado para editar.");
            lblMensajeEmergente.setForeground(Color.red);
            return;
        }

        // Obtener los datos del empleado seleccionado
        String rutSeleccionado = tableEmpleados.getValueAt(fila, 0).toString(); // Obtener el RUT del empleado

        // Llamar a la función para abrir la ventana de edición
        mostrarVentanaEdicion(rutSeleccionado);
    }//GEN-LAST:event_btnEditarEmpleadoMouseClicked

    private void btnEliminarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarEmpleadoMouseClicked
        // TODO add your handling code here:
        int fila = tableEmpleados.getSelectedRow();
        
        if (fila == -1){
            
            lblMensajeEmergente.setText("Por favor, seleccione un empleado para eliminar.");
            lblMensajeEmergente.setForeground(Color.red.darker().darker());
        }
        
        String rutSeleccionado = tableEmpleados.getValueAt(fila, 0).toString();
        
        if (Menu.eliminarEmpleado(rutSeleccionado)!=null){
            //Actualizar csv con los nuevos datos
            Menu.ActualizarCSVEmpleados();
            lblMensajeEmergente.setText("Empleado eliminado");
        }
    }//GEN-LAST:event_btnEliminarEmpleadoMouseClicked

    private void mostrarVentanaEdicion(String rutEmpleado) {
    // Buscar al empleado por el RUT
        Empleado empleado = Menu.getEmpleadoPorRut(rutEmpleado);

        if (empleado != null) {
            // Crear la ventana
            EditarEmpleado.iniciar(empleado);
            
        } else {
            lblMensajeEmergente.setText("Empleado no encontrado.");
            lblMensajeEmergente.setForeground(Color.red);
    }
}

    
    
    private void llenarTabla(){
        DefaultTableModel modeloDefault = new DefaultTableModel(new String[] {"Rut", "Nombre", "Ministerio", "Cargo"}, Menu.getSizeEmpleados());
        tableEmpleados.setModel(modeloDefault);
        
        TableModel modeloDatos = tableEmpleados.getModel();
        for (int i = 0; i<Menu.getSizeEmpleados();i++){
            Empleado empleado = Menu.getEmpleados(i);
            modeloDatos.setValueAt(Menu.getRutEmpleado(i), i, 0);
            modeloDatos.setValueAt(Menu.getNombreEmpleado(i), i, 1);
            modeloDatos.setValueAt(Menu.getMinisterioEmpleado(i), i, 2);
            modeloDatos.setValueAt(Menu.getCargoEmpleado(i), i, 3);
        }
    }
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void iniciar() {
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
            java.util.logging.Logger.getLogger(BuscarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditarEmpleado;
    private javax.swing.JButton btnEliminarEmpleado;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscarEmpleado;
    private javax.swing.JLabel lblMensajeEmergente;
    private javax.swing.JTable tableEmpleados;
    private javax.swing.JTextField txtBuscarEmpleado;
    // End of variables declaration//GEN-END:variables
}
