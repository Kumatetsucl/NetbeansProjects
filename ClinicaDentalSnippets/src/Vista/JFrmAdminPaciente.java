
package Vista;


import Controlador.DaoPaciente;
import Enumeradores.EnumPrevision;
import Modelo.Atencion;
import Modelo.Paciente;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;


public class JFrmAdminPaciente extends javax.swing.JFrame {


    public JFrmAdminPaciente() {
        initComponents();
        cboPrevisionPaciente.setModel(new DefaultComboBoxModel(EnumPrevision.values()));
        cboPrevision.setModel(new DefaultComboBoxModel(EnumPrevision.values()));
        Listar();
        this.setLocationRelativeTo(null);

    }
    
    
    public void holders(){};
    
    public void ListarPrevisionPaciente(){
        DefaultTableModel modelo = new DefaultTableModel();
        JTblListaPaciente.setModel(modelo);
        modelo.addColumn("Id Paciente");
        modelo.addColumn("Rut Paciente");
        modelo.addColumn("Nombre Paciente");
        modelo.addColumn("Celular Paciente");
        modelo.addColumn("Direccion Paciente");
        modelo.addColumn("Prevision Paciente");
        ArrayList<Paciente> Listado = new DaoPaciente().Listar();
        String prev = cboPrevisionPaciente.getSelectedItem().toString();
        for (Paciente paciente : Listado) {
            if(paciente.getPrevision().toString().equals(prev)){
                Object[] fila = new Object[7];
                fila[0] = paciente.getId_paciente();
                fila[1] = paciente.getNum_rut();
                fila[2] = paciente.getNombre();
                fila[4] = paciente.getCelular();
                fila[5] = paciente.getDireccion();
                fila[6] = paciente.getPrevision().toString();
                modelo.addRow(fila);
            }
        }
    }
    
    
    public void Listar() {
        DefaultTableModel modelo = new DefaultTableModel();
        JTblListaPaciente.setModel(modelo);
        modelo.addColumn("Id Paciente");
        modelo.addColumn("Rut Paciente");
        modelo.addColumn("Nombre Paciente");
        modelo.addColumn("Celular Paciente");
        modelo.addColumn("Direccion Paciente");
        modelo.addColumn("Prevision Paciente");
        ArrayList<Paciente> Listado = new DaoPaciente().Listar();
        for (Paciente paciente : Listado) {
            Object[] fila = new Object[6];
            fila[0] = paciente.getId_paciente();
            fila[1] = paciente.getNum_rut();
            fila[2] = paciente.getNombre();
            fila[3] = paciente.getCelular();
            fila[4] = paciente.getDireccion();
            fila[5] = paciente.getPrevision().toString();
            modelo.addRow(fila);
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        bntModificar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtNombrePaciente = new javax.swing.JTextField();
        txtRutPaciente = new javax.swing.JTextField();
        txtDireccionPaciente = new javax.swing.JTextField();
        txtTelefonoPaciente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtIdPaciente = new javax.swing.JTextField();
        cboPrevision = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cboPrevisionPaciente = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTblListaPaciente = new javax.swing.JTable();
        btnAplicarFiltro = new javax.swing.JButton();
        btnListarTodo = new javax.swing.JButton();
        BtnVolver = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuVolver = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        MnnuCerrarSesion = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ADMINISTRAR PACIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Counter-Strike", 0, 24))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel1.setText("Nombre del Paciente");

        jLabel2.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel2.setText("Rut del Paciente");

        jLabel3.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel3.setText("Direccion del Paciente");

        jLabel4.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel4.setText("Telefono del Paciente");

        btnGuardar.setText("Grabar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        bntModificar.setText("Modificar");
        bntModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntModificarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtNombrePaciente.setMaximumSize(new java.awt.Dimension(300, 30));
        txtNombrePaciente.setMinimumSize(new java.awt.Dimension(300, 30));
        txtNombrePaciente.setPreferredSize(new java.awt.Dimension(300, 30));
        txtNombrePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombrePacienteActionPerformed(evt);
            }
        });

        txtRutPaciente.setMaximumSize(new java.awt.Dimension(300, 30));
        txtRutPaciente.setMinimumSize(new java.awt.Dimension(300, 30));
        txtRutPaciente.setPreferredSize(new java.awt.Dimension(300, 30));

        txtDireccionPaciente.setMaximumSize(new java.awt.Dimension(600, 30));
        txtDireccionPaciente.setMinimumSize(new java.awt.Dimension(600, 30));
        txtDireccionPaciente.setPreferredSize(new java.awt.Dimension(600, 30));
        txtDireccionPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionPacienteActionPerformed(evt);
            }
        });

        txtTelefonoPaciente.setMaximumSize(new java.awt.Dimension(300, 30));
        txtTelefonoPaciente.setMinimumSize(new java.awt.Dimension(300, 30));
        txtTelefonoPaciente.setPreferredSize(new java.awt.Dimension(300, 30));

        jLabel6.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel6.setText("ID Paciente");

        TxtIdPaciente.setText("0");
        TxtIdPaciente.setMaximumSize(new java.awt.Dimension(71, 30));
        TxtIdPaciente.setMinimumSize(new java.awt.Dimension(71, 30));
        TxtIdPaciente.setPreferredSize(new java.awt.Dimension(71, 30));
        TxtIdPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdPacienteActionPerformed(evt);
            }
        });

        cboPrevision.setMaximumSize(new java.awt.Dimension(200, 30));
        cboPrevision.setMinimumSize(new java.awt.Dimension(200, 30));
        cboPrevision.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel7.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel7.setText("Prevision Paciente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(12, 12, 12)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRutPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addContainerGap(218, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(cboPrevision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRutPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPrevision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(bntModificar)
                    .addComponent(btnBuscar)
                    .addComponent(btnEliminar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado Pacientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Counter-Strike", 0, 24))); // NOI18N
        jPanel2.setMaximumSize(new java.awt.Dimension(1366, 768));

        cboPrevisionPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPrevisionPacienteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel5.setText("Seleccione Prevision");

        JTblListaPaciente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(JTblListaPaciente);

        btnAplicarFiltro.setText("Aplicar Filtro");
        btnAplicarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarFiltroActionPerformed(evt);
            }
        });

        btnListarTodo.setText("Listar Todo");
        btnListarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarTodoActionPerformed(evt);
            }
        });

        BtnVolver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BtnVolver.setText("Volver");
        BtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cboPrevisionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAplicarFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListarTodo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPrevisionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btnAplicarFiltro)
                    .addComponent(btnListarTodo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BtnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jMenu1.setText("INICIO");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        mnuVolver.setText("Volver");
        mnuVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVolverActionPerformed(evt);
            }
        });
        jMenu1.add(mnuVolver);
        jMenu1.add(jSeparator2);

        MnnuCerrarSesion.setText("Cerrar Sesion");
        MnnuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnnuCerrarSesionActionPerformed(evt);
            }
        });
        jMenu1.add(MnnuCerrarSesion);
        jMenu1.add(jSeparator1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAplicarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarFiltroActionPerformed
        ListarPrevisionPaciente();
    }//GEN-LAST:event_btnAplicarFiltroActionPerformed

    private void btnListarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarTodoActionPerformed
        Listar();
    }//GEN-LAST:event_btnListarTodoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        int id_Paciente =Integer.parseInt(TxtIdPaciente.getText());
        String nombre = txtNombrePaciente.getText();
        int num_rut = Integer.parseInt(txtRutPaciente.getText());
        String direccion = txtDireccionPaciente.getText();
        int celular = Integer.parseInt(txtTelefonoPaciente.getText());
        String prevision = cboPrevision.getSelectedItem().toString();
        EnumPrevision enum_Prevision = EnumPrevision.valueOf(prevision);
        
        try {
            ////////////////////////////////////////////////////////
            Paciente pac = new Paciente(id_Paciente, enum_Prevision, nombre, num_rut, direccion, celular);
            ////////////////////////////////////////////////////////

            DaoPaciente dao = new DaoPaciente();
            boolean resp = dao.Grabar(pac);
            if (resp == true) {
                JOptionPane.showMessageDialog(null, "Grabo");
                Listar();
            } else {
                JOptionPane.showMessageDialog(null, "No Grabo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombrePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombrePacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombrePacienteActionPerformed

    private void BtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVolverActionPerformed
        JFrmMainMenu mainmenu=new JFrmMainMenu();
        mainmenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnVolverActionPerformed

    private void txtDireccionPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionPacienteActionPerformed

    private void mnuVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVolverActionPerformed
        JFrmMainMenu mainmenu=new JFrmMainMenu();
        mainmenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnuVolverActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int id_paciente = Integer.parseInt(TxtIdPaciente.getText());
        Paciente pac = new DaoPaciente().Buscar(id_paciente);
        if (pac != null) {
            JOptionPane.showMessageDialog(null, "Existe Paciente");
            TxtIdPaciente.setText(String.valueOf(pac.getId_paciente()));
            txtRutPaciente.setText(String.valueOf(pac.getNum_rut()));
            txtNombrePaciente.setText("" + pac.getNombre());
            txtTelefonoPaciente.setText(String.valueOf(pac.getCelular()));
            txtDireccionPaciente.setText("" + pac.getDireccion());
            cboPrevision.setSelectedItem(pac.getPrevision());

        } else {
            JOptionPane.showMessageDialog(null, "No Existe Paciente");
            Listar();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int id_Paciente = Integer.parseInt(TxtIdPaciente.getText());
        DaoPaciente pac = new DaoPaciente();
        boolean resp = pac.Eliminar(id_Paciente);
        if (resp == true) {
            JOptionPane.showMessageDialog(null, "Elimino");
            Listar();
        } else {
            JOptionPane.showMessageDialog(null, "No Elimino");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void bntModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntModificarActionPerformed
        int id_Paciente = Integer.parseInt(TxtIdPaciente.getText());
        int num_rut = Integer.parseInt(txtRutPaciente.getText());
        int celular = Integer.parseInt(txtTelefonoPaciente.getText());
        String nombre = txtNombrePaciente.getText();
        String direccion = txtDireccionPaciente.getText();
        String prevision = cboPrevision.getSelectedItem().toString();
        EnumPrevision enum_Prevision = EnumPrevision.valueOf(prevision);
        

        try {
            ////////////////////////////////////////////////////////
            
            Paciente pac = new Paciente(id_Paciente, enum_Prevision, nombre, num_rut, direccion, celular);
            ////////////////////////////////////////////////////////

            DaoPaciente dao = new DaoPaciente();
            boolean resp = dao.Modificar(pac);
            if (resp == true) {
                JOptionPane.showMessageDialog(null, "Modifico");
                Listar();
            } else {
                JOptionPane.showMessageDialog(null, "No Modifico");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_bntModificarActionPerformed

    private void TxtIdPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdPacienteActionPerformed

    }//GEN-LAST:event_TxtIdPacienteActionPerformed

    private void cboPrevisionPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPrevisionPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPrevisionPacienteActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void MnnuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnnuCerrarSesionActionPerformed
        JFrmLogin login= new JFrmLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MnnuCerrarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(JFrmAdminPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmAdminPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmAdminPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmAdminPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmAdminPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnVolver;
    private javax.swing.JTable JTblListaPaciente;
    private javax.swing.JMenuItem MnnuCerrarSesion;
    private javax.swing.JTextField TxtIdPaciente;
    private javax.swing.JButton bntModificar;
    private javax.swing.JButton btnAplicarFiltro;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnListarTodo;
    private javax.swing.JComboBox<String> cboPrevision;
    private javax.swing.JComboBox<String> cboPrevisionPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem mnuVolver;
    private javax.swing.JTextField txtDireccionPaciente;
    private javax.swing.JTextField txtNombrePaciente;
    private javax.swing.JTextField txtRutPaciente;
    private javax.swing.JTextField txtTelefonoPaciente;
    // End of variables declaration//GEN-END:variables
}
