package Vista;

import Controlador.DaoEmpleado;
import Enumeradores.EnumPaises;
import Modelo.Empleado;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrmEmpleado extends javax.swing.JFrame {


    public JFrmEmpleado() {
        initComponents();
        Listar();
        ListarCbo();
        setLocationRelativeTo(null);
    }
    private void Limpiar(){
        txtRutEmpleado.setText("");
        txtNombreEmpleado.setText("");
        txtDireccionEmpleado.setText("");
    
    }
    private void Listar() {
        DefaultTableModel modelo=new DefaultTableModel();
        JtbListarEmpleado.setModel(modelo);
        modelo.addColumn("Rut");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Edad");
        modelo.addColumn("Genero");
        ArrayList<Empleado> listado=new DaoEmpleado().Listar();
        for (Empleado item : listado) {
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
        cboGeneroEmpleado.setModel(new DefaultComboBoxModel(EnumPaises.values()));
    
    
        cboFiltroEmpleado.addItem("Seleccione");
        ArrayList<Empleado> pers= new ArrayList<>();
        DaoEmpleado rc=new DaoEmpleado();
        pers=rc.Listar();
        for(int i=0;i<pers.size();i++)
        {
            cboFiltroEmpleado.addItem(pers.get(i).getNacionalidad());
        }
    }
    public void ListarGeneroCliente() {
        DefaultTableModel modelo = new DefaultTableModel();
        JtbListarEmpleado.setModel(modelo);
        modelo.addColumn("Rut");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Edad");
        modelo.addColumn("Genero");
        ArrayList<Empleado> Listado=new DaoEmpleado().Listar();
        String GenCli = cboFiltroEmpleado.getSelectedItem().toString();
        for (Empleado item : Listado) {
            if(item.getNacionalidad().equals(GenCli)){
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

        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtNombreEmpleado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRutEmpleado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDireccionEmpleado = new javax.swing.JTextField();
        spnEdadEmpleado = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        cboGeneroEmpleado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtbListarEmpleado = new javax.swing.JTable();
        cboFiltroEmpleado = new javax.swing.JComboBox<>();
        btnFiltrar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        txtIdCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuVolver = new javax.swing.JMenuItem();
        mnuCerrarSesion = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuSalir = new javax.swing.JMenuItem();

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

        txtNombreEmpleado.setMaximumSize(new java.awt.Dimension(200, 22));
        txtNombreEmpleado.setMinimumSize(new java.awt.Dimension(200, 22));
        txtNombreEmpleado.setPreferredSize(new java.awt.Dimension(200, 22));
        txtNombreEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEmpleadoActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre Empleado");

        jLabel2.setText("Rut Empleado");

        txtRutEmpleado.setMaximumSize(new java.awt.Dimension(200, 22));
        txtRutEmpleado.setMinimumSize(new java.awt.Dimension(200, 22));
        txtRutEmpleado.setPreferredSize(new java.awt.Dimension(200, 22));
        txtRutEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutEmpleadoActionPerformed(evt);
            }
        });

        jLabel3.setText("Direccion Empleado");

        txtDireccionEmpleado.setMaximumSize(new java.awt.Dimension(200, 22));
        txtDireccionEmpleado.setMinimumSize(new java.awt.Dimension(200, 22));
        txtDireccionEmpleado.setPreferredSize(new java.awt.Dimension(200, 22));

        spnEdadEmpleado.setModel(new javax.swing.SpinnerNumberModel(18, 18, 99, 1));

        jLabel4.setText("Edad Empleado");

        cboGeneroEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGeneroEmpleadoActionPerformed(evt);
            }
        });

        jLabel5.setText("Nacionalidad Empleado");

        JtbListarEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        JtbListarEmpleado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(JtbListarEmpleado);

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

        jLabel6.setText("Años");

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        txtIdCliente.setText("00");
        txtIdCliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtIdCliente.setEnabled(false);
        txtIdCliente.setMaximumSize(new java.awt.Dimension(64, 22));
        txtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteActionPerformed(evt);
            }
        });

        jLabel7.setText("Id  Empleado");

        jMenu1.setText("Inicio");

        mnuVolver.setText("Volver al Menu");
        mnuVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVolverActionPerformed(evt);
            }
        });
        jMenu1.add(mnuVolver);

        mnuCerrarSesion.setText("Cerrar Sesion");
        mnuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCerrarSesionActionPerformed(evt);
            }
        });
        jMenu1.add(mnuCerrarSesion);
        jMenu1.add(jSeparator1);

        mnuSalir.setText("Cerrar Programa");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSalir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDireccionEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(spnEdadEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6))
                                .addComponent(cboGeneroEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtRutEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboFiltroEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboFiltroEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFiltrar)
                            .addComponent(btnListar)
                            .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(btnVolver, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRutEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(7, 7, 7)
                        .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccionEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnEdadEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboGeneroEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar)
                            .addComponent(btnGuardar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEmpleadoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int fila=JtbListarEmpleado.getSelectedRow();
        String rut = JtbListarEmpleado.getValueAt(fila, 0).toString();
        Empleado pers = new DaoEmpleado().Buscar(rut);
        if (pers != null) {
            
            JOptionPane.showMessageDialog(null, "Existe Usuario ");          
            txtIdCliente.setText(""+pers.getIdCliente());
            txtRutEmpleado.setText(pers.getRut());          
            txtNombreEmpleado.setText(pers.getNombre());          
            txtDireccionEmpleado.setText(pers.getDireccion());          
            spnEdadEmpleado.setValue(pers.getEdad());
            cboGeneroEmpleado.setSelectedItem(EnumPaises.valueOf(pers.getNacionalidad()));
        } else {
            JOptionPane.showMessageDialog(null, "No Existe Usuario");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int idCliente = Integer.parseInt(txtIdCliente.getText());
        String Rut = txtRutEmpleado.getText();
        String Nombre= txtNombreEmpleado.getText();
        String Direccion = txtDireccionEmpleado.getText();
        int Edad = Integer.parseInt(spnEdadEmpleado.getValue().toString());
        String Genero= cboGeneroEmpleado.getSelectedItem().toString();

        try {
            ////////////////////////////////////////////////////////
                Empleado usu = new Empleado(idCliente, Rut, Nombre, Direccion, Edad, Genero);
            ////////////////////////////////////////////////////////

            boolean resp = new DaoEmpleado().Grabar(usu);
            if (resp == true) {
                JOptionPane.showMessageDialog(null, "Grabo");
                Limpiar();
                Listar();
            } else {
                JOptionPane.showMessageDialog(null, "No Grabo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int idCliente= Integer.parseInt(txtIdCliente.getText());
        String Rut_persona = txtRutEmpleado.getText();
        String Nombre_persona= txtNombreEmpleado.getText();
        String Direccion_persona = txtDireccionEmpleado.getText();
        int Edad_persona = Integer.parseInt(spnEdadEmpleado.getValue().toString());
        String Genero_persona= cboGeneroEmpleado.getSelectedItem().toString();

        try {
            ////////////////////////////////////////////////////////
            Empleado pers = new Empleado(idCliente, Rut_persona, Nombre_persona, Direccion_persona, Edad_persona, Genero_persona);
            ////////////////////////////////////////////////////////

            DaoEmpleado dao = new DaoEmpleado();
            boolean resp = dao.modificar(pers);
            if (resp == true) {
                JOptionPane.showMessageDialog(null, "Modificó");
                Limpiar();
                Listar();
            } else {
                JOptionPane.showMessageDialog(null, "No Modificó");
            }
        } catch (Exception e) {
            System.out.println("no modifico por: "+e.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed


    
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String rut = txtRutEmpleado.getText();
        DaoEmpleado dao = new DaoEmpleado();
        boolean resp = dao.Eliminar(rut);
        if (resp == true) {
            JOptionPane.showMessageDialog(null, "Elimino");
            Listar();
            Limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "No Elimino");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        ListarGeneroCliente();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        Listar();
    }//GEN-LAST:event_btnListarActionPerformed

    private void cboGeneroEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGeneroEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboGeneroEmpleadoActionPerformed

    private void txtRutEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutEmpleadoActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        JfrmMenu menu= new JfrmMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteActionPerformed

    }//GEN-LAST:event_txtIdClienteActionPerformed

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVolverActionPerformed
        JfrmMenu menu= new JfrmMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnuVolverActionPerformed

    private void mnuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCerrarSesionActionPerformed
        JfrmLogin login= new JfrmLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnuCerrarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(JFrmEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JtbListarEmpleado;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cboFiltroEmpleado;
    private javax.swing.JComboBox<String> cboGeneroEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mnuCerrarSesion;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenuItem mnuVolver;
    private javax.swing.JSpinner spnEdadEmpleado;
    private javax.swing.JTextField txtDireccionEmpleado;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JTextField txtRutEmpleado;
    // End of variables declaration//GEN-END:variables
}
