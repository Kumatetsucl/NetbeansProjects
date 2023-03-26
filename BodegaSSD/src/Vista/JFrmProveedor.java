
package Vista;

import Controlador.DaoProveedor;
import Enumeradores.EnumPaises;
import Modelo.Proveedor;
import Modelo.Persona;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class JFrmProveedor extends javax.swing.JFrame {


    public JFrmProveedor() {
        initComponents();
        ListarConductor();
        ListarCbo();
        setLocationRelativeTo(null);
    }

    private void LimpiarConductor(){
        txtRutProveedor.setText("");
        txtnombreProveedor.setText("");
        txtDireccionProveedor.setText("");
    
    }

    private void ListarConductor() {
        DefaultTableModel modelo=new DefaultTableModel();
        JTblListarProveedor.setModel(modelo);
        modelo.addColumn("Rut");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Edad");
        modelo.addColumn("Genero");
        ArrayList<Proveedor> listado=new DaoProveedor().ListarConductor();
        for (Persona item : listado) {
            Object[] fila=new Object[5];
            fila[0]=item.getRut();
            fila[1]=item.getNombre();
            fila[2]=item.getDireccion();
            fila[3]=item.getEdad()+" AÑOS";
            fila[4]=item.getNacionalidad();
            modelo.addRow(fila);
        }
    }

    
    private void ListarCbo(){
        cboGeneroProveedor.setModel(new DefaultComboBoxModel(EnumPaises.values()));
    
    
        cboFiltro.addItem("Seleccione");
        ArrayList<Proveedor> cond= new ArrayList<>();
        DaoProveedor rc=new DaoProveedor();
        cond=rc.ListarConductor();
        for(int i=0;i<cond.size();i++)
        {
            cboFiltro.addItem(cond.get(i).getNacionalidad());
        }
    }

    public void ListarGeneroConductor() {
        DefaultTableModel modelo = new DefaultTableModel();
        JTblListarProveedor.setModel(modelo);
        modelo.addColumn("Rut");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Edad");
        modelo.addColumn("Genero");
        ArrayList<Proveedor> Listado=new DaoProveedor().ListarConductor();
        String GenCon = cboFiltro.getSelectedItem().toString();
        for (Persona item : Listado) {
            if(item.getNacionalidad().equals(GenCon)){
                Object[] fila = new Object[7];
                fila[0]=item.getRut();
                fila[1]=item.getNombre();
                fila[2]=item.getDireccion();
                fila[3]=item.getEdad()+" AÑOS";
                fila[4]=item.getNacionalidad();
                modelo.addRow(fila);
            }
        }
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVolver = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtnombreProveedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRutProveedor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDireccionProveedor = new javax.swing.JTextField();
        spnEdadProveedor = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        cboGeneroProveedor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTblListarProveedor = new javax.swing.JTable();
        cboFiltro = new javax.swing.JComboBox<>();
        btnFiltrar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnVolver1 = new javax.swing.JButton();
        txtIdConductor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(691, 480));
        setResizable(false);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtnombreProveedor.setMaximumSize(new java.awt.Dimension(200, 22));
        txtnombreProveedor.setMinimumSize(new java.awt.Dimension(200, 22));
        txtnombreProveedor.setPreferredSize(new java.awt.Dimension(200, 22));
        txtnombreProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreProveedorActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre Proveedor");

        jLabel2.setText("Rut Proveedor");

        txtRutProveedor.setMaximumSize(new java.awt.Dimension(200, 22));
        txtRutProveedor.setMinimumSize(new java.awt.Dimension(200, 22));
        txtRutProveedor.setPreferredSize(new java.awt.Dimension(200, 22));

        jLabel3.setText("Direccion Proveedor");

        txtDireccionProveedor.setMaximumSize(new java.awt.Dimension(200, 22));
        txtDireccionProveedor.setMinimumSize(new java.awt.Dimension(200, 22));
        txtDireccionProveedor.setPreferredSize(new java.awt.Dimension(200, 22));

        jLabel4.setText("Edad Proveedor");

        cboGeneroProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGeneroProveedorActionPerformed(evt);
            }
        });

        jLabel5.setText("Genero Proveedor");

        JTblListarProveedor.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        JTblListarProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(JTblListarProveedor);

        cboFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFiltroActionPerformed(evt);
            }
        });

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnVolver1.setText("Volver");
        btnVolver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolver1ActionPerformed(evt);
            }
        });

        txtIdConductor.setText("00");
        txtIdConductor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtIdConductor.setEnabled(false);
        txtIdConductor.setMaximumSize(new java.awt.Dimension(64, 22));
        txtIdConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdConductorActionPerformed(evt);
            }
        });

        jLabel7.setText("Id Proveedor:");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(23, 23, 23)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(btnModificar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addComponent(txtRutProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3)
                                    .addComponent(spnEdadProveedor)
                                    .addComponent(jLabel5)
                                    .addComponent(cboGeneroProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addComponent(txtnombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFiltrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnListar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(btnVolver1))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRutProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnEdadProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboGeneroProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar)
                            .addComponent(btnGuardar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListar)
                            .addComponent(btnFiltrar)
                            .addComponent(btnVolver1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreProveedorActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int fila=JTblListarProveedor.getSelectedRow();
        String rut = JTblListarProveedor.getValueAt(fila, 0).toString();
        Proveedor cond = new DaoProveedor().Buscar(rut);
        if (cond != null) {
            JOptionPane.showMessageDialog(null, "Existe Conductor ");      
            txtIdConductor.setText(""+cond.getIdConductor());
            txtRutProveedor.setText(cond.getRut());          
            txtnombreProveedor.setText(cond.getNombre());          
            txtDireccionProveedor.setText(cond.getDireccion());          
            spnEdadProveedor.setValue(cond.getEdad());
            cboGeneroProveedor.setSelectedItem(EnumPaises.valueOf(cond.getNacionalidad()));
        } else {
            JOptionPane.showMessageDialog(null, "No Existe Conductor");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String rut = txtRutProveedor.getText();
        DaoProveedor dao = new DaoProveedor();
        boolean resp = dao.Eliminar(rut);
        if (resp == true) {
            JOptionPane.showMessageDialog(null, "Elimino");
            ListarConductor();
            LimpiarConductor();
        } else {
            JOptionPane.showMessageDialog(null, "No Elimino");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int idConductor= Integer.parseInt(txtIdConductor.getText());
        String Rut_Conductor = txtRutProveedor.getText();
        String Nombre_Conductor= txtnombreProveedor.getText();
        String Direccion_Conductor = txtDireccionProveedor.getText();
        int Edad_Conductor = Integer.parseInt(spnEdadProveedor.getValue().toString());
        String Genero_Conductor= cboGeneroProveedor.getSelectedItem().toString();

        try {
            ////////////////////////////////////////////////////////
            Proveedor cond = new Proveedor(idConductor, Rut_Conductor, Nombre_Conductor, Direccion_Conductor, WIDTH, Genero_Conductor);
            ////////////////////////////////////////////////////////

            boolean resp = new DaoProveedor().GrabarConductor(cond);
            if (resp == true) {
                JOptionPane.showMessageDialog(null, "Grabo");
                ListarConductor();
                LimpiarConductor();
            } else {
                JOptionPane.showMessageDialog(null, "No Grabo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int idConductor= Integer.parseInt(txtIdConductor.getText());
        String Rut_Conductor = txtRutProveedor.getText();
        String Nombre_Conductor= txtnombreProveedor.getText();
        String Direccion_Conductor = txtDireccionProveedor.getText();
        int Edad_Conductor = Integer.parseInt(spnEdadProveedor.getValue().toString());
        String Genero_Conductor= cboGeneroProveedor.getSelectedItem().toString();

        try {
            ////////////////////////////////////////////////////////
            Proveedor cond = new Proveedor(idConductor, Rut_Conductor, Nombre_Conductor, Direccion_Conductor, Edad_Conductor, Genero_Conductor);
            ////////////////////////////////////////////////////////

            boolean resp = new DaoProveedor().modificar(cond);
            if (resp == true) {
                JOptionPane.showMessageDialog(null, "Modificó");
                ListarConductor();
            } else {
                JOptionPane.showMessageDialog(null, "No Modificó");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        JfrmMenu menu= new JfrmMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnVolver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolver1ActionPerformed
        JfrmMenu menu= new JfrmMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolver1ActionPerformed

    private void cboGeneroProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGeneroProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboGeneroProveedorActionPerformed

    private void txtIdConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdConductorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdConductorActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        ListarGeneroConductor();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void cboFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboFiltroActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        ListarConductor();
    }//GEN-LAST:event_btnListarActionPerformed

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
            java.util.logging.Logger.getLogger(JFrmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTblListarProveedor;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btnVolver1;
    private javax.swing.JComboBox<String> cboFiltro;
    private javax.swing.JComboBox<String> cboGeneroProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spnEdadProveedor;
    private javax.swing.JTextField txtDireccionProveedor;
    private javax.swing.JTextField txtIdConductor;
    private javax.swing.JTextField txtRutProveedor;
    private javax.swing.JTextField txtnombreProveedor;
    // End of variables declaration//GEN-END:variables
}
