
package Vista;

import Controlador.DaoAsistente;
import Modelo.Asistente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrmAdminAsistente extends javax.swing.JFrame {


    public JFrmAdminAsistente() {
        
        initComponents();
        Listar();
        ListarCbo();
        this.setLocationRelativeTo(null);
    }
    
    public void ListarCbo(){
        cboRutAsistente.addItem("Seleccione");
        ArrayList<Asistente> e= new ArrayList<>();
        DaoAsistente rg=new DaoAsistente();
        e=rg.ListarNombreAsistente();
        for(int i=0;i<e.size();i++)
        {
          cboRutAsistente.addItem(e.get(i).getNombre());
        }
    }

    public void ListarNombreAsistente() {
        DefaultTableModel modelo = new DefaultTableModel();
        JTblListaAsistente.setModel(modelo);
        modelo.addColumn("Id Asistente");
        modelo.addColumn("Rut Doctor");
        modelo.addColumn("Nombre Doctor");
        modelo.addColumn("Especialidad");
        modelo.addColumn("Celular Doctor");
        modelo.addColumn("Direccion Doctor");
        modelo.addColumn("Sueldo Doctor");
        ArrayList<Asistente> Listado = new DaoAsistente().Listar();
        String nomasis = cboRutAsistente.getSelectedItem().toString();
        for (Asistente asistente : Listado) {
            if(asistente.getNombre().equals(nomasis)){
                Object[] fila = new Object[7];
                fila[0] = asistente.getIdAsistente();
                fila[1] = asistente.getNum_rut();
                fila[2] = asistente.getNombre();
                fila[4] = asistente.getCelular();
                fila[5] = asistente.getDireccion();
                fila[6] = asistente.getSueldo();
                modelo.addRow(fila);
            }
        }
    }
    
    public void Listar() {
        DefaultTableModel modelo = new DefaultTableModel();
        JTblListaAsistente.setModel(modelo);
        modelo.addColumn("Id Asistente");
        modelo.addColumn("Rut Asistente");
        modelo.addColumn("Nombre Asistente");
        modelo.addColumn("Celular Asistente");
        modelo.addColumn("Direccion Asistente");
        modelo.addColumn("Sueldo Asistente");
        ArrayList<Asistente> Listado = new DaoAsistente().Listar();
        for (Asistente asistente : Listado) {
            Object[] fila = new Object[6];
            fila[0] = asistente.getIdAsistente();
            fila[1] = asistente.getNum_rut();
            fila[2] = asistente.getNombre();
            fila[3] = asistente.getCelular();
            fila[4] = asistente.getDireccion();
            fila[5] = asistente.getSueldo();
            modelo.addRow(fila);
        }

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnGrabarAsistente = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnBuscar = new javax.swing.JButton();
        BtnBorrar = new javax.swing.JButton();
        txtRutAsistente = new javax.swing.JTextField();
        txtDireccionAsistente = new javax.swing.JTextField();
        txtSueldoAsistente = new javax.swing.JTextField();
        txtNombreAsistente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCelularAsistente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtIdAsistente = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        cboRutAsistente = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTblListaAsistente = new javax.swing.JTable();
        BtnFiltrar = new javax.swing.JButton();
        BtnListarTodo = new javax.swing.JButton();
        BtnVolver = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuVolver = new javax.swing.JMenuItem();
        MnnuCerrarSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ADMINISTRAR ASISTENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Counter-Strike", 0, 24))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel2.setText("Rut del Asistente");

        jLabel3.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel3.setText("Direccion del Asistente");

        jLabel4.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel4.setText("Sueldo Asistente");

        btnGrabarAsistente.setText("Grabar");
        btnGrabarAsistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarAsistenteActionPerformed(evt);
            }
        });

        BtnModificar.setText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        BtnBorrar.setText("Eliminar");
        BtnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBorrarActionPerformed(evt);
            }
        });

        txtRutAsistente.setMaximumSize(new java.awt.Dimension(300, 30));
        txtRutAsistente.setMinimumSize(new java.awt.Dimension(300, 30));
        txtRutAsistente.setPreferredSize(new java.awt.Dimension(300, 30));

        txtDireccionAsistente.setMaximumSize(new java.awt.Dimension(635, 30));
        txtDireccionAsistente.setMinimumSize(new java.awt.Dimension(635, 30));
        txtDireccionAsistente.setPreferredSize(new java.awt.Dimension(635, 30));
        txtDireccionAsistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionAsistenteActionPerformed(evt);
            }
        });

        txtSueldoAsistente.setMaximumSize(new java.awt.Dimension(300, 30));
        txtSueldoAsistente.setMinimumSize(new java.awt.Dimension(300, 30));
        txtSueldoAsistente.setPreferredSize(new java.awt.Dimension(300, 30));

        txtNombreAsistente.setMaximumSize(new java.awt.Dimension(300, 30));
        txtNombreAsistente.setMinimumSize(new java.awt.Dimension(300, 30));
        txtNombreAsistente.setPreferredSize(new java.awt.Dimension(300, 30));

        jLabel6.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel6.setText("Nombre del Asistente");

        txtCelularAsistente.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCelularAsistente.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCelularAsistente.setPreferredSize(new java.awt.Dimension(300, 30));
        txtCelularAsistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularAsistenteActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel8.setText("Celular Asistente");

        jLabel7.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel7.setText("ID Asistente");

        TxtIdAsistente.setText("0");
        TxtIdAsistente.setMaximumSize(new java.awt.Dimension(71, 30));
        TxtIdAsistente.setMinimumSize(new java.awt.Dimension(71, 30));
        TxtIdAsistente.setPreferredSize(new java.awt.Dimension(71, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtDireccionAsistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtSueldoAsistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGrabarAsistente)
                                .addGap(12, 12, 12)
                                .addComponent(BtnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnBorrar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TxtIdAsistente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRutAsistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreAsistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCelularAsistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))))))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRutAsistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreAsistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelularAsistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtIdAsistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccionAsistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSueldoAsistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabarAsistente)
                    .addComponent(BtnModificar)
                    .addComponent(BtnBuscar)
                    .addComponent(BtnBorrar))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado Asistente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Counter-Strike", 0, 24))); // NOI18N
        jPanel2.setMaximumSize(new java.awt.Dimension(1366, 768));

        jLabel5.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel5.setText("Seleccione Nombre");

        JTblListaAsistente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(JTblListaAsistente);

        BtnFiltrar.setText("Aplicar Filtro");
        BtnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFiltrarActionPerformed(evt);
            }
        });

        BtnListarTodo.setText("Listar Todo");
        BtnListarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnListarTodoActionPerformed(evt);
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboRutAsistente, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnListarTodo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboRutAsistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(BtnFiltrar)
                    .addComponent(BtnListarTodo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BtnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jMenu1.setText("INICIO");

        mnuVolver.setText("Volver");
        mnuVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVolverActionPerformed(evt);
            }
        });
        jMenu1.add(mnuVolver);

        MnnuCerrarSesion.setText("Cerrar Sesion");
        MnnuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnnuCerrarSesionActionPerformed(evt);
            }
        });
        jMenu1.add(MnnuCerrarSesion);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVolverActionPerformed
        JFrmMainMenu mainmenu=new JFrmMainMenu();
        mainmenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnuVolverActionPerformed

    private void btnGrabarAsistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarAsistenteActionPerformed
        
        int id_asistente =Integer.parseInt(TxtIdAsistente.getText());
        String nombre = txtNombreAsistente.getText();
        int num_rut = Integer.parseInt(txtRutAsistente.getText());
        String direccion = txtDireccionAsistente.getText();
        int celular = Integer.parseInt(txtRutAsistente.getText());
        int sueldo = Integer.parseInt(txtSueldoAsistente.getText());
        
        
        try {
            ////////////////////////////////////////////////////////
            Asistente asis = new Asistente(id_asistente, sueldo, nombre, num_rut, direccion, celular);
            ////////////////////////////////////////////////////////

            DaoAsistente dao = new DaoAsistente();
            boolean resp = dao.Grabar(asis);
            if (resp == true) {
                JOptionPane.showMessageDialog(null, "Grabo");
                Listar();
            } else {
                JOptionPane.showMessageDialog(null, "No Grabo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnGrabarAsistenteActionPerformed

    private void txtDireccionAsistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionAsistenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionAsistenteActionPerformed

    private void txtCelularAsistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularAsistenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularAsistenteActionPerformed

    private void BtnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFiltrarActionPerformed
        ListarNombreAsistente();
    }//GEN-LAST:event_BtnFiltrarActionPerformed

    private void BtnListarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnListarTodoActionPerformed
        Listar();
    }//GEN-LAST:event_BtnListarTodoActionPerformed

    private void BtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVolverActionPerformed
        JFrmMainMenu mainmenu=new JFrmMainMenu();
        mainmenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnVolverActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        int id_asistente = Integer.parseInt(TxtIdAsistente.getText());
        Asistente asis = new DaoAsistente().Buscar(id_asistente);
        if (asis != null) {
            JOptionPane.showMessageDialog(null, "Existe Asistente");
            TxtIdAsistente.setText(String.valueOf(asis.getIdAsistente()));
            txtRutAsistente.setText(String.valueOf(asis.getNum_rut()));
            txtNombreAsistente.setText("" + asis.getNombre());
            txtCelularAsistente.setText(String.valueOf(asis.getCelular()));
            txtDireccionAsistente.setText("" + asis.getDireccion());
            txtSueldoAsistente.setText(String.valueOf(asis.getSueldo()));

        } else {
            JOptionPane.showMessageDialog(null, "No Existe Asistente");
            Listar();
        }
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void BtnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBorrarActionPerformed
        int id_Asistente = Integer.parseInt(TxtIdAsistente.getText());
        DaoAsistente dao = new DaoAsistente();
        boolean resp = dao.Eliminar(id_Asistente);
        if (resp == true) {
            JOptionPane.showMessageDialog(null, "Elimino");
            Listar();
        } else {
            JOptionPane.showMessageDialog(null, "No Elimino");
        }
    }//GEN-LAST:event_BtnBorrarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        int id_Asistente = Integer.parseInt(TxtIdAsistente.getText());
        int num_rut = Integer.parseInt(txtRutAsistente.getText());
        int celular = Integer.parseInt(txtCelularAsistente.getText());
        int sueldo = Integer.parseInt(txtSueldoAsistente.getText());
        String nombre = txtNombreAsistente.getText();
        String direccion = txtDireccionAsistente.getText();

        try {
            ////////////////////////////////////////////////////////
            Asistente asis = new Asistente(id_Asistente,sueldo, nombre, num_rut, direccion, celular);
            ////////////////////////////////////////////////////////

            DaoAsistente dao = new DaoAsistente();
            boolean resp = dao.Modificar(asis);
            if (resp == true) {
                JOptionPane.showMessageDialog(null, "Modifico");
                Listar();
            } else {
                JOptionPane.showMessageDialog(null, "No Modifico");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_BtnModificarActionPerformed

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
            java.util.logging.Logger.getLogger(JFrmAdminAsistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmAdminAsistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmAdminAsistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmAdminAsistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmAdminAsistente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBorrar;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnFiltrar;
    private javax.swing.JButton BtnListarTodo;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnVolver;
    private javax.swing.JTable JTblListaAsistente;
    private javax.swing.JMenuItem MnnuCerrarSesion;
    private javax.swing.JTextField TxtIdAsistente;
    private javax.swing.JButton btnGrabarAsistente;
    private javax.swing.JComboBox<String> cboRutAsistente;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnuVolver;
    private javax.swing.JTextField txtCelularAsistente;
    private javax.swing.JTextField txtDireccionAsistente;
    private javax.swing.JTextField txtNombreAsistente;
    private javax.swing.JTextField txtRutAsistente;
    private javax.swing.JTextField txtSueldoAsistente;
    // End of variables declaration//GEN-END:variables
}
