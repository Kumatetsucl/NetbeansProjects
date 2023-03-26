
package Vista;

import Controlador.DaoConductor;
import Enumeradores.EnumGenero;
import Modelo.Conductor;
import Modelo.Persona;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class JFrmConductor extends javax.swing.JFrame {


    public JFrmConductor() {
        initComponents();
        ListarConductor();
        ListarCbo();
        setLocationRelativeTo(null);
    }

    private void LimpiarConductor(){
        txtRutConductor.setText("");
        txtnombreConductor.setText("");
        txtDireccionConductor.setText("");
    
    }

    private void ListarConductor() {
        DefaultTableModel modelo=new DefaultTableModel();
        JTblListarConductores.setModel(modelo);
        modelo.addColumn("Rut");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Edad");
        modelo.addColumn("Genero");
        ArrayList<Conductor> listado=new DaoConductor().ListarConductor();
        for (Persona item : listado) {
            Object[] fila=new Object[5];
            fila[0]=item.getRut();
            fila[1]=item.getNombre();
            fila[2]=item.getDireccion();
            fila[3]=item.getEdad()+" AÑOS";
            fila[4]=item.getGenero();
            modelo.addRow(fila);
        }
    }

    
    private void ListarCbo(){
        cboGeneroConductor.setModel(new DefaultComboBoxModel(EnumGenero.values()));
    
    
        cboFiltroGenero.addItem("Seleccione");
        ArrayList<Conductor> cond= new ArrayList<>();
        DaoConductor rc=new DaoConductor();
        cond=rc.ListarConductor();
        for(int i=0;i<cond.size();i++)
        {
            cboFiltroGenero.addItem(cond.get(i).getGenero());
        }
    }

    public void ListarGeneroConductor() {
        DefaultTableModel modelo = new DefaultTableModel();
        JTblListarConductores.setModel(modelo);
        modelo.addColumn("Rut");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Edad");
        modelo.addColumn("Genero");
        ArrayList<Conductor> Listado=new DaoConductor().ListarConductor();
        String GenCon = cboFiltroGenero.getSelectedItem().toString();
        for (Persona item : Listado) {
            if(item.getGenero().equals(GenCon)){
                Object[] fila = new Object[7];
                fila[0]=item.getRut();
                fila[1]=item.getNombre();
                fila[2]=item.getDireccion();
                fila[3]=item.getEdad()+" AÑOS";
                fila[4]=item.getGenero();
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
        txtnombreConductor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRutConductor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDireccionConductor = new javax.swing.JTextField();
        spnEdadConductor = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        cboGeneroConductor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTblListarConductores = new javax.swing.JTable();
        cboFiltroGenero = new javax.swing.JComboBox<>();
        btnFiltrarGenero = new javax.swing.JButton();
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
        setTitle("Administar Conductor");
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

        txtnombreConductor.setMaximumSize(new java.awt.Dimension(200, 22));
        txtnombreConductor.setMinimumSize(new java.awt.Dimension(200, 22));
        txtnombreConductor.setPreferredSize(new java.awt.Dimension(200, 22));
        txtnombreConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreConductorActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre Conductor");

        jLabel2.setText("Rut Conductor");

        txtRutConductor.setMaximumSize(new java.awt.Dimension(200, 22));
        txtRutConductor.setMinimumSize(new java.awt.Dimension(200, 22));
        txtRutConductor.setPreferredSize(new java.awt.Dimension(200, 22));
        txtRutConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutConductorActionPerformed(evt);
            }
        });

        jLabel3.setText("Direccion Conductor");

        txtDireccionConductor.setMaximumSize(new java.awt.Dimension(200, 22));
        txtDireccionConductor.setMinimumSize(new java.awt.Dimension(200, 22));
        txtDireccionConductor.setPreferredSize(new java.awt.Dimension(200, 22));

        jLabel4.setText("Edad conductor");

        cboGeneroConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGeneroConductorActionPerformed(evt);
            }
        });

        jLabel5.setText("Genero Conductor");

        JTblListarConductores.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        JTblListarConductores.setModel(new javax.swing.table.DefaultTableModel(
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
        JTblListarConductores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTblListarConductoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTblListarConductores);

        cboFiltroGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFiltroGeneroActionPerformed(evt);
            }
        });

        btnFiltrarGenero.setText("Filtrar");
        btnFiltrarGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarGeneroActionPerformed(evt);
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

        jLabel7.setText("Id conductor:");

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
                                    .addComponent(txtRutConductor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDireccionConductor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3)
                                    .addComponent(spnEdadConductor)
                                    .addComponent(jLabel5)
                                    .addComponent(cboGeneroConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addComponent(txtnombreConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboFiltroGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFiltrarGenero)
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
                        .addComponent(txtRutConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnombreConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccionConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnEdadConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboGeneroConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(cboFiltroGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListar)
                            .addComponent(btnFiltrarGenero)
                            .addComponent(btnVolver1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreConductorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreConductorActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int fila=JTblListarConductores.getSelectedRow();
        String rut = JTblListarConductores.getValueAt(fila, 0).toString();
        Conductor cond = new DaoConductor().Buscar(rut);
        if (cond != null) {
            JOptionPane.showMessageDialog(null, "Existe Conductor ");      
            txtIdConductor.setText(""+cond.getIdConductor());
            txtRutConductor.setText(cond.getRut());          
            txtnombreConductor.setText(cond.getNombre());          
            txtDireccionConductor.setText(cond.getDireccion());          
            spnEdadConductor.setValue(cond.getEdad());
            cboGeneroConductor.setSelectedItem(EnumGenero.valueOf(cond.getGenero()));
        } else {
            JOptionPane.showMessageDialog(null, "No Existe Conductor");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String rut = txtRutConductor.getText();
        DaoConductor dao = new DaoConductor();
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
        String Rut_Conductor = txtRutConductor.getText();
        String Nombre_Conductor= txtnombreConductor.getText();
        String Direccion_Conductor = txtDireccionConductor.getText();
        int Edad_Conductor = Integer.parseInt(spnEdadConductor.getValue().toString());
        String Genero_Conductor= cboGeneroConductor.getSelectedItem().toString();

        try {
            ////////////////////////////////////////////////////////
            Conductor cond = new Conductor(idConductor, Rut_Conductor, Nombre_Conductor, Direccion_Conductor, WIDTH, Genero_Conductor);
            ////////////////////////////////////////////////////////

            boolean resp = new DaoConductor().GrabarConductor(cond);
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
        String Rut_Conductor = txtRutConductor.getText();
        String Nombre_Conductor= txtnombreConductor.getText();
        String Direccion_Conductor = txtDireccionConductor.getText();
        int Edad_Conductor = Integer.parseInt(spnEdadConductor.getValue().toString());
        String Genero_Conductor= cboGeneroConductor.getSelectedItem().toString();

        try {
            ////////////////////////////////////////////////////////
            Conductor cond = new Conductor(idConductor, Rut_Conductor, Nombre_Conductor, Direccion_Conductor, Edad_Conductor, Genero_Conductor);
            ////////////////////////////////////////////////////////

            boolean resp = new DaoConductor().modificar(cond);
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

    private void cboGeneroConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGeneroConductorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboGeneroConductorActionPerformed

    private void txtIdConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdConductorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdConductorActionPerformed

    private void btnFiltrarGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarGeneroActionPerformed
        ListarGeneroConductor();
    }//GEN-LAST:event_btnFiltrarGeneroActionPerformed

    private void cboFiltroGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFiltroGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboFiltroGeneroActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        ListarConductor();
    }//GEN-LAST:event_btnListarActionPerformed

    private void JTblListarConductoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTblListarConductoresMouseClicked
        int fila=JTblListarConductores.getSelectedRow();
        String rut = JTblListarConductores.getValueAt(fila, 0).toString();
        Conductor cond = new DaoConductor().Buscar(rut);
        if (cond != null) {  
            txtIdConductor.setText(""+cond.getIdConductor());
            txtRutConductor.setText(cond.getRut());          
            txtnombreConductor.setText(cond.getNombre());          
            txtDireccionConductor.setText(cond.getDireccion());          
            spnEdadConductor.setValue(cond.getEdad());
            cboGeneroConductor.setSelectedItem(EnumGenero.valueOf(cond.getGenero()));
        } else {
            JOptionPane.showMessageDialog(null, "No Existe Conductor");
        }
    
    }//GEN-LAST:event_JTblListarConductoresMouseClicked

    private void txtRutConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutConductorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutConductorActionPerformed

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
            java.util.logging.Logger.getLogger(JFrmConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmConductor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTblListarConductores;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFiltrarGenero;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btnVolver1;
    private javax.swing.JComboBox<String> cboFiltroGenero;
    private javax.swing.JComboBox<String> cboGeneroConductor;
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
    private javax.swing.JSpinner spnEdadConductor;
    private javax.swing.JTextField txtDireccionConductor;
    private javax.swing.JTextField txtIdConductor;
    private javax.swing.JTextField txtRutConductor;
    private javax.swing.JTextField txtnombreConductor;
    // End of variables declaration//GEN-END:variables
}
