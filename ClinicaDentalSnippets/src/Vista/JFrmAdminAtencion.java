
package Vista;

import Controlador.DaoAsistente;
import Controlador.DaoPaciente;
import Modelo.Asistente;
import Modelo.Atencion;
import Modelo.Doctor;
import Modelo.Paciente;
import controlador.DaoAtencion;
import controlador.DaoDoctor;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;


public class JFrmAdminAtencion extends javax.swing.JFrame {


    public JFrmAdminAtencion() {
        initComponents();
        
        
        //se llama al metodo de Listar ComboBox
        ListarCbo();
        //se llama al metodo de Listar el JFtable que muestra todas las atenciones que estan guardadas
        Listar();
        //posiciona la pantalla del programa en la parte central de la pantalla
        this.setLocationRelativeTo(null);
    }
    
    public void ListarCbo(){ 
        
        //Listar cbo de doctor
        //agregar item Seleccione para que sea lo primero que sale en el cbo
        cboDoctor.addItem("Seleccione");
        //se crea un arrayList para traer los datos de los doctores
        ArrayList<Doctor> doc= new ArrayList<>();
        //se hace la connexion del Dao al que se quiere hacer los datos
        DaoDoctor rg=new DaoDoctor();
        // se llama al metodo listar del Dao antes mencionado
        doc=rg.Listar();
        // se hace un for, dentro de este se le da a item (i) el valor de 0 " i=0 "
        //se hace la pregunta de que si i es menor al tamaño de los objetos que trae el arraylist " i<doc.size() "
        //se agregar un Item (en este caso un numero de rut del doctor) " i++ "
        for(int i=0;i<doc.size();i++)
        {
          //se llena el combobox CON cada item (i) que vendría siendo el numrut del doctor
          // hay un metodo de convertir el INT en String y es colocar comillas ("") y despues un +
          // así el cbo va a leer solo los datos del numero y los va  amostarr como texto
          cboDoctor.addItem(""+doc.get(i).getId_doctor());
          
        }
        
        cboPaciente.addItem("Seleccione");
        ArrayList<Paciente> pac= new ArrayList<>();
        DaoPaciente rc=new DaoPaciente();
        pac=rc.Listar();
        for(int i=0;i<pac.size();i++)
        {
            cboPaciente.addItem(""+pac.get(i).getId_paciente());
        }
        
        
        cboTratamiento.addItem("Seleccione");
        ArrayList<Atencion> aten= new ArrayList<>();
        DaoAtencion rgt=new DaoAtencion();
        aten=rgt.ListarServicio();
        for(int i=0;i<aten.size();i++){
            cboTratamiento.addItem(""+aten.get(i).getIdServicio());
        }
        
        
        cboAsistente.addItem("Seleccione");
        ArrayList<Asistente> asis =new ArrayList<>();
        DaoAsistente ras=new DaoAsistente();
        asis=ras.Listar();
        for(int i=0;i<asis.size();i++){
            cboAsistente.addItem(""+asis.get(i).getIdAsistente());
        }
        
        cboFiltroNombrePaciente.addItem("Seleccione");
        ArrayList<Paciente> paci= new ArrayList<>();
        DaoPaciente rfp=new DaoPaciente();
        paci=rfp.Listar();
        for(int i=0;i<paci.size();i++)
        {
            cboFiltroNombrePaciente.addItem(paci.get(i).getNombre());
        }
       
        cboFiltroNombreDoctor.addItem("Seleccione");
        ArrayList<Doctor> doct= new ArrayList<>();
        DaoDoctor rfd=new DaoDoctor();
        doct=rfd.Listar();
        for(int i=0;i<doct.size();i++)
        {
            cboFiltroNombreDoctor.addItem(doct.get(i).getNombre());
        }
        
        cboFiltroPrevision.addItem("Seleccione");
        cboFiltroPrevision.addItem("FONASA");
        cboFiltroPrevision.addItem("ISAPRE");
        cboFiltroPrevision.addItem("PARTICULAR");
        
    }


    public void ListarnombrePaciente(){
        //Se Instancia el nuevo modelo
        DefaultTableModel modelo = new DefaultTableModel();
        //Se completan los datos de las Jtable
        JTblMuestraDatosAtencion.setModel(modelo);
        //cada ADDCOLUMN crea un nuevo columna que se muestra en la Tabla
        modelo.addColumn("Id Atencion");
        modelo.addColumn("Nombre Paciente");
        modelo.addColumn("Direccion Paciente");
        modelo.addColumn("Prevision Paciente");
        modelo.addColumn("Nombre Doctor");
        modelo.addColumn("Rut Doctor");
        modelo.addColumn("Tipo Servicio");
        modelo.addColumn("Valor Atencion");
        modelo.addColumn("Fecha Atencion");
     /* Se hace un ArrayList para que traiga los datos del metodo Listar() que esta
        en el DAOAtencion  */
        ArrayList<Atencion> Listado = new DaoAtencion().Listar();
        //Se selecciona un ITEM que esté en el reflejado en el ComboBox
        String aten = cboFiltroNombrePaciente.getSelectedItem().toString();
        //Se Hace un FOR para buscar cada item que esté dentro del ArraYList
        for (Atencion atencion : Listado) {
            //Si Hay un objeto en este caso NombrePaciente() que sea igual ql ITEM del ComboBox entonces que llene los datos
            if(atencion.getNombrePaciente().equals(aten)){
         /* Se hace un Objeto llamado Fila y se escriben la cantidad de filas que se 
            van a traer */
            Object[] fila = new Object[9];
            //el numero de Objetos comienza en el 0
            fila[0] = atencion.getId_atencion();
            fila[1] = atencion.getNombrePaciente();
            fila[2] = atencion.getDireccionPaciente();
            fila[3] = atencion.getPrevisionPaciente();
            fila[4] = atencion.getNombreDoctor();
            fila[5] = atencion.getNumRutDoctor();
            fila[6] = atencion.getDescripcionServicio();
            fila[7] = atencion.getValorServicio();
            fila[8] = atencion.getFechaAtencion();
            modelo.addRow(fila);
            }
        }
    }
    
    public void ListarnombreDoctor(){
        DefaultTableModel modelo = new DefaultTableModel();
        JTblMuestraDatosAtencion.setModel(modelo);
        modelo.addColumn("Id Atencion");
        modelo.addColumn("Nombre Paciente");
        modelo.addColumn("Direccion Paciente");
        modelo.addColumn("Prevision Paciente");
        modelo.addColumn("Nombre Doctor");
        modelo.addColumn("Rut Doctor");
        modelo.addColumn("Tipo Servicio");
        modelo.addColumn("Valor Atencion");
        ArrayList<Atencion> Listado = new DaoAtencion().Listar();
        String aten = cboFiltroNombreDoctor.getSelectedItem().toString();
        for (Atencion atencion : Listado) {
            if(atencion.getNombreDoctor().equals(aten)){
            Object[] fila = new Object[9];
            fila[0] = atencion.getId_atencion();
            fila[1] = atencion.getNombrePaciente();
            fila[2] = atencion.getDireccionPaciente();
            fila[3] = atencion.getPrevisionPaciente();
            fila[4] = atencion.getNombreDoctor();
            fila[5] = atencion.getNumRutDoctor();
            fila[6] = atencion.getDescripcionServicio();
            fila[7] = atencion.getValorServicio();
            fila[8] = atencion.getFechaAtencion();
            modelo.addRow(fila);
            }
        }
    }
    
    public void ListarnombrePrevision(){
        DefaultTableModel modelo = new DefaultTableModel();
        JTblMuestraDatosAtencion.setModel(modelo);
        modelo.addColumn("Id Atencion");
        modelo.addColumn("Nombre Paciente");
        modelo.addColumn("Direccion Paciente");
        modelo.addColumn("Prevision Paciente");
        modelo.addColumn("Nombre Doctor");
        modelo.addColumn("Rut Doctor");
        modelo.addColumn("Tipo Servicio");
        modelo.addColumn("Valor Atencion");
        ArrayList<Atencion> Listado = new DaoAtencion().Listar();
        String prev = cboFiltroPrevision.getSelectedItem().toString();
        for (Atencion atencion : Listado) {
            if(atencion.getPrevisionPaciente().equals(prev)){
            Object[] fila = new Object[9];
            fila[0] = atencion.getId_atencion();
            fila[1] = atencion.getNombrePaciente();
            fila[2] = atencion.getDireccionPaciente();
            fila[3] = atencion.getPrevisionPaciente();
            fila[4] = atencion.getNombreDoctor();
            fila[5] = atencion.getNumRutDoctor();
            fila[6] = atencion.getDescripcionServicio();
            fila[7] = atencion.getValorServicio();
            fila[8] = atencion.getFechaAtencion();
            modelo.addRow(fila);
            }
        }
    }
    
    public void Listar() {
        DefaultTableModel modelo = new DefaultTableModel();
        JTblMuestraDatosAtencion.setModel(modelo);
        modelo.addColumn("Id Atencion");
        modelo.addColumn("Nombre Paciente");
        modelo.addColumn("Direccion Paciente");
        modelo.addColumn("Prevision Paciente");
        modelo.addColumn("Nombre Doctor");
        modelo.addColumn("Rut Doctor");
        modelo.addColumn("Tipo Servicio");
        modelo.addColumn("Valor Atencion");
        modelo.addColumn("Fecha Atencion");
        ArrayList<Atencion> Listado = new DaoAtencion().Listar();
        for (Atencion atencion : Listado) {
            Object[] fila = new Object[9];
            fila[0] = atencion.getId_atencion();
            fila[1] = atencion.getNombrePaciente();
            fila[2] = atencion.getDireccionPaciente();
            fila[3] = atencion.getPrevisionPaciente();
            fila[4] = atencion.getNombreDoctor();
            fila[5] = atencion.getNumRutDoctor();
            fila[6] = atencion.getDescripcionServicio();
            fila[7] = atencion.getValorServicio();
            fila[8] = atencion.getFechaAtencion();
            modelo.addRow(fila);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTblMuestraDatosAtencion = new javax.swing.JTable();
        BtnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtIdAtencion = new javax.swing.JTextField();
        cboPaciente = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtNombrePaciente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDireccionPaciente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrevisionPaciente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRutAsistente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboAsistente = new javax.swing.JComboBox<>();
        cboDoctor = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboTratamiento = new javax.swing.JComboBox<>();
        txtValorTratamiento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cboFiltroNombrePaciente = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        btnFiltroPaciente = new javax.swing.JButton();
        cboFiltroNombreDoctor = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        btnNombreDoctor = new javax.swing.JButton();
        cboFiltroPrevision = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        btnFiltroPrevision = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnOkpaciente = new javax.swing.JButton();
        txtNombreAsistente = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnOkAsistente = new javax.swing.JButton();
        btnOkDoctor1 = new javax.swing.JButton();
        txtRutDoctor = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtRutPaciente = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtNombreDoctor = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btnOkTratamiento = new javax.swing.JButton();
        txtNombreTratamiento = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MnnuVolver = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Atencion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Counter-Strike", 0, 24))); // NOI18N

        JTblMuestraDatosAtencion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(JTblMuestraDatosAtencion);

        BtnVolver.setText("Volver");
        BtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVolverActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel1.setText("Id Atencion");

        txtIdAtencion.setText("0");
        txtIdAtencion.setMaximumSize(new java.awt.Dimension(91, 30));
        txtIdAtencion.setMinimumSize(new java.awt.Dimension(91, 30));
        txtIdAtencion.setPreferredSize(new java.awt.Dimension(91, 30));
        txtIdAtencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdAtencionActionPerformed(evt);
            }
        });

        cboPaciente.setMaximumSize(new java.awt.Dimension(100, 30));
        cboPaciente.setMinimumSize(new java.awt.Dimension(100, 30));
        cboPaciente.setPreferredSize(new java.awt.Dimension(100, 30));
        cboPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPacienteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel2.setText("Direccion Paciente");

        txtNombrePaciente.setEditable(false);
        txtNombrePaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombrePaciente.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtNombrePaciente.setEnabled(false);
        txtNombrePaciente.setMaximumSize(new java.awt.Dimension(300, 30));
        txtNombrePaciente.setMinimumSize(new java.awt.Dimension(300, 30));
        txtNombrePaciente.setPreferredSize(new java.awt.Dimension(300, 30));
        txtNombrePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombrePacienteActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel3.setText("Seleccione Id Paciente");

        txtDireccionPaciente.setEditable(false);
        txtDireccionPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDireccionPaciente.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtDireccionPaciente.setEnabled(false);
        txtDireccionPaciente.setMaximumSize(new java.awt.Dimension(300, 30));
        txtDireccionPaciente.setMinimumSize(new java.awt.Dimension(300, 30));
        txtDireccionPaciente.setPreferredSize(new java.awt.Dimension(300, 30));

        jLabel4.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel4.setText("Nombre Paciente");

        txtPrevisionPaciente.setEditable(false);
        txtPrevisionPaciente.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtPrevisionPaciente.setEnabled(false);
        txtPrevisionPaciente.setMaximumSize(new java.awt.Dimension(180, 30));
        txtPrevisionPaciente.setMinimumSize(new java.awt.Dimension(180, 30));
        txtPrevisionPaciente.setPreferredSize(new java.awt.Dimension(180, 30));

        jLabel5.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel5.setText("Prevision Paciente");

        jLabel6.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel6.setText("Seleccione Asistete");

        txtRutAsistente.setEditable(false);
        txtRutAsistente.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtRutAsistente.setEnabled(false);
        txtRutAsistente.setMaximumSize(new java.awt.Dimension(200, 30));
        txtRutAsistente.setMinimumSize(new java.awt.Dimension(200, 30));
        txtRutAsistente.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel7.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel7.setText("Rut Doctor");

        cboAsistente.setMaximumSize(new java.awt.Dimension(100, 30));
        cboAsistente.setMinimumSize(new java.awt.Dimension(100, 30));
        cboAsistente.setPreferredSize(new java.awt.Dimension(100, 30));

        cboDoctor.setMaximumSize(new java.awt.Dimension(100, 30));
        cboDoctor.setMinimumSize(new java.awt.Dimension(100, 30));
        cboDoctor.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel8.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel8.setText("Seleccione ID Doctor");

        jLabel9.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel9.setText("sleccione Id Tratamiento");

        cboTratamiento.setMaximumSize(new java.awt.Dimension(100, 30));
        cboTratamiento.setMinimumSize(new java.awt.Dimension(100, 30));
        cboTratamiento.setPreferredSize(new java.awt.Dimension(100, 30));

        txtValorTratamiento.setMaximumSize(new java.awt.Dimension(180, 30));
        txtValorTratamiento.setMinimumSize(new java.awt.Dimension(180, 30));
        txtValorTratamiento.setPreferredSize(new java.awt.Dimension(180, 30));

        jLabel10.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel10.setText("Valor Tratamiento");

        jLabel11.setFont(new java.awt.Font("Counter-Strike", 0, 24)); // NOI18N
        jLabel11.setText("Buscar Atencion");

        cboFiltroNombrePaciente.setMaximumSize(new java.awt.Dimension(72, 30));
        cboFiltroNombrePaciente.setMinimumSize(new java.awt.Dimension(72, 30));
        cboFiltroNombrePaciente.setPreferredSize(new java.awt.Dimension(72, 30));
        cboFiltroNombrePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFiltroNombrePacienteActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel13.setText("Seleccione Nombre Paciente");

        btnFiltroPaciente.setText("Filtrar");
        btnFiltroPaciente.setMaximumSize(new java.awt.Dimension(72, 30));
        btnFiltroPaciente.setMinimumSize(new java.awt.Dimension(72, 30));
        btnFiltroPaciente.setPreferredSize(new java.awt.Dimension(72, 30));
        btnFiltroPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroPacienteActionPerformed(evt);
            }
        });

        cboFiltroNombreDoctor.setMaximumSize(new java.awt.Dimension(72, 30));
        cboFiltroNombreDoctor.setMinimumSize(new java.awt.Dimension(72, 30));
        cboFiltroNombreDoctor.setPreferredSize(new java.awt.Dimension(72, 30));

        jLabel14.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel14.setText("Seleccione Nombre Doctor");

        btnNombreDoctor.setText("Filtrar");
        btnNombreDoctor.setMaximumSize(new java.awt.Dimension(72, 30));
        btnNombreDoctor.setMinimumSize(new java.awt.Dimension(72, 30));
        btnNombreDoctor.setPreferredSize(new java.awt.Dimension(72, 30));
        btnNombreDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNombreDoctorActionPerformed(evt);
            }
        });

        cboFiltroPrevision.setMaximumSize(new java.awt.Dimension(72, 30));
        cboFiltroPrevision.setMinimumSize(new java.awt.Dimension(72, 30));
        cboFiltroPrevision.setPreferredSize(new java.awt.Dimension(72, 30));

        jLabel15.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel15.setText("Seleccione Prevision");

        btnFiltroPrevision.setText("Filtrar");
        btnFiltroPrevision.setMaximumSize(new java.awt.Dimension(72, 30));
        btnFiltroPrevision.setMinimumSize(new java.awt.Dimension(72, 30));
        btnFiltroPrevision.setPreferredSize(new java.awt.Dimension(72, 30));
        btnFiltroPrevision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroPrevisionActionPerformed(evt);
            }
        });

        BtnGuardar.setText("Guardar");
        BtnGuardar.setMaximumSize(new java.awt.Dimension(90, 30));
        BtnGuardar.setMinimumSize(new java.awt.Dimension(90, 30));
        BtnGuardar.setPreferredSize(new java.awt.Dimension(90, 30));
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setMaximumSize(new java.awt.Dimension(90, 30));
        btnEliminar.setMinimumSize(new java.awt.Dimension(90, 30));
        btnEliminar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setMaximumSize(new java.awt.Dimension(90, 30));
        btnModificar.setMinimumSize(new java.awt.Dimension(90, 30));
        btnModificar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.setMaximumSize(new java.awt.Dimension(90, 30));
        btnBuscar.setMinimumSize(new java.awt.Dimension(90, 30));
        btnBuscar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnOkpaciente.setText("OK");
        btnOkpaciente.setMaximumSize(new java.awt.Dimension(75, 30));
        btnOkpaciente.setMinimumSize(new java.awt.Dimension(75, 30));
        btnOkpaciente.setPreferredSize(new java.awt.Dimension(75, 30));
        btnOkpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkpacienteActionPerformed(evt);
            }
        });

        txtNombreAsistente.setEditable(false);
        txtNombreAsistente.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtNombreAsistente.setEnabled(false);
        txtNombreAsistente.setMaximumSize(new java.awt.Dimension(300, 30));
        txtNombreAsistente.setMinimumSize(new java.awt.Dimension(300, 30));
        txtNombreAsistente.setPreferredSize(new java.awt.Dimension(300, 30));

        jLabel16.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel16.setText("Nombre Asistente");

        btnOkAsistente.setText("OK");
        btnOkAsistente.setMaximumSize(new java.awt.Dimension(91, 30));
        btnOkAsistente.setMinimumSize(new java.awt.Dimension(91, 30));
        btnOkAsistente.setPreferredSize(new java.awt.Dimension(91, 30));
        btnOkAsistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkAsistenteActionPerformed(evt);
            }
        });

        btnOkDoctor1.setText("OK");
        btnOkDoctor1.setMaximumSize(new java.awt.Dimension(91, 30));
        btnOkDoctor1.setMinimumSize(new java.awt.Dimension(91, 30));
        btnOkDoctor1.setPreferredSize(new java.awt.Dimension(91, 30));
        btnOkDoctor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkDoctor1ActionPerformed(evt);
            }
        });

        txtRutDoctor.setEditable(false);
        txtRutDoctor.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtRutDoctor.setEnabled(false);
        txtRutDoctor.setMaximumSize(new java.awt.Dimension(200, 30));
        txtRutDoctor.setMinimumSize(new java.awt.Dimension(200, 30));
        txtRutDoctor.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel17.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel17.setText("Rut Paciente");

        txtRutPaciente.setEditable(false);
        txtRutPaciente.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtRutPaciente.setEnabled(false);
        txtRutPaciente.setMaximumSize(new java.awt.Dimension(200, 30));
        txtRutPaciente.setMinimumSize(new java.awt.Dimension(200, 30));
        txtRutPaciente.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel18.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel18.setText("rut Asistente");

        txtNombreDoctor.setEditable(false);
        txtNombreDoctor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombreDoctor.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtNombreDoctor.setEnabled(false);
        txtNombreDoctor.setMaximumSize(new java.awt.Dimension(300, 30));
        txtNombreDoctor.setMinimumSize(new java.awt.Dimension(300, 30));
        txtNombreDoctor.setPreferredSize(new java.awt.Dimension(300, 30));
        txtNombreDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreDoctorActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel19.setText("Nombre Doctor");

        btnOkTratamiento.setText("OK");
        btnOkTratamiento.setMaximumSize(new java.awt.Dimension(75, 30));
        btnOkTratamiento.setMinimumSize(new java.awt.Dimension(75, 30));
        btnOkTratamiento.setPreferredSize(new java.awt.Dimension(75, 30));
        btnOkTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkTratamientoActionPerformed(evt);
            }
        });

        txtNombreTratamiento.setEditable(false);
        txtNombreTratamiento.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtNombreTratamiento.setEnabled(false);
        txtNombreTratamiento.setMaximumSize(new java.awt.Dimension(300, 30));
        txtNombreTratamiento.setMinimumSize(new java.awt.Dimension(300, 30));
        txtNombreTratamiento.setPreferredSize(new java.awt.Dimension(300, 30));

        jLabel20.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel20.setText("Nombre Tratamiento");

        jLabel12.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        jLabel12.setText("fecha Tratamiento");

        jdcFecha.setDateFormatString("dd-MM-yyyy hh:mm");
        jdcFecha.setMaximumSize(new java.awt.Dimension(160, 30));
        jdcFecha.setMinSelectableDate(new java.util.Date(-62135751506000L));
        jdcFecha.setMinimumSize(new java.awt.Dimension(160, 30));
        jdcFecha.setPreferredSize(new java.awt.Dimension(160, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdAtencion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPrevisionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addContainerGap(550, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(2, 2, 2)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(cboDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnOkDoctor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(cboPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnOkpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(jLabel8))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel7)
                                                            .addComponent(txtRutDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel17)
                                                            .addComponent(txtRutPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel4)
                                                    .addComponent(txtNombreDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel19)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(cboAsistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btnOkAsistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel6))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel18)
                                                    .addComponent(txtRutAsistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel16)
                                                    .addComponent(txtNombreAsistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(56, 56, 56)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(cboTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnOkTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtNombreTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel9)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel20))
                                                    .addComponent(txtDireccionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel2)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel10)
                                                            .addComponent(txtValorTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(47, 47, 47)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jdcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                .addGap(0, 120, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(BtnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 19, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cboFiltroNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnFiltroPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cboFiltroNombreDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnNombreDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel14))
                                .addGap(134, 134, 134)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cboFiltroPrevision, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnFiltroPrevision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(206, 206, 206))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrevisionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOkpaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel20)))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtRutPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOkDoctor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRutDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTratamiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOkTratamiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombreTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRutAsistente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboAsistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnOkAsistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombreAsistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49)
                        .addComponent(jLabel11)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboFiltroNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnFiltroPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboFiltroPrevision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnFiltroPrevision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboFiltroNombreDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnNombreDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValorTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(153, 153, 153)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jMenu1.setText("Inicio");

        MnnuVolver.setText("Volver");
        MnnuVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnnuVolverActionPerformed(evt);
            }
        });
        jMenu1.add(MnnuVolver);

        jMenuItem1.setText("Cerrar Sesion");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkTratamientoActionPerformed
        int id_servicio = Integer.parseInt(cboTratamiento.getSelectedItem().toString());
        Atencion aten = new DaoAtencion().BuscarServicio(id_servicio);
        if (aten != null) {
            cboTratamiento.setSelectedItem(String.valueOf(aten.getIdServicio()));
            txtNombreTratamiento.setText(aten.getDescripcionServicio());

        } else {
            JOptionPane.showMessageDialog(null, "No se puedo Encontrar");
            Listar();
        }
    }//GEN-LAST:event_btnOkTratamientoActionPerformed

    private void txtNombreDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreDoctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreDoctorActionPerformed

    private void btnOkpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkpacienteActionPerformed

        int IdPaciente = Integer.parseInt(cboPaciente.getSelectedItem().toString());
        Paciente pac = new DaoPaciente().BuscarIdPaciente(IdPaciente);
        if (pac != null) {
            txtNombrePaciente.setText(pac.getNombre());
            txtDireccionPaciente.setText(pac.getDireccion());
            txtPrevisionPaciente.setText(pac.getPrevision().toString());
            txtRutPaciente.setText(String.valueOf(pac.getNum_rut()));

        } else {
            JOptionPane.showMessageDialog(null, "No Existe Paciente");
            Listar();
        }
    }//GEN-LAST:event_btnOkpacienteActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int id_atencion = Integer.parseInt(txtIdAtencion.getText());
        Atencion ate = new DaoAtencion().Buscar(id_atencion);
        if (ate != null) {
            JOptionPane.showMessageDialog(null, "Existe Atencion");
            txtIdAtencion.setText(String.valueOf(ate.getId_atencion()));
            txtPrevisionPaciente.setText(ate.getPrevisionPaciente());
            cboPaciente.setSelectedItem(String.valueOf(ate.getIdPaciente()));
            txtRutPaciente.setText(String.valueOf(ate.getNumRutPaciente()));
            txtNombrePaciente.setText(ate.getNombrePaciente());
            txtDireccionPaciente.setText(ate.getDireccionPaciente());
            cboDoctor.setSelectedItem(String.valueOf(ate.getIdDoctor()));
            txtRutDoctor.setText(String.valueOf(ate.getNumRutDoctor()));
            txtNombreDoctor.setText(ate.getNombreDoctor());
            cboAsistente.setSelectedItem(String.valueOf(ate.getIdAsistente()));
            txtRutAsistente.setText(String.valueOf(ate.getRutAsistente()));
            txtNombreAsistente.setText(ate.getNombreAsistente());
            cboTratamiento.setSelectedItem(String.valueOf(ate.getIdServicio()));
            txtNombreTratamiento.setText(ate.getDescripcionServicio());
            txtValorTratamiento.setText(String.valueOf(ate.getValorServicio()));
            jdcFecha.setDate(ate.getFechaAtencion());
            

        } else {
            JOptionPane.showMessageDialog(null, "No Existe Atencion");
            Listar();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
             
        int id_atencion = Integer.parseInt(txtIdAtencion.getText());
        int valorAtencion = Integer.parseInt(txtValorTratamiento.getText());
        int idDoctor = Integer.parseInt(cboDoctor.getSelectedItem().toString());
        int idPaciente = Integer.parseInt(cboPaciente.getSelectedItem().toString());
        int idAsistente = Integer.parseInt(cboAsistente.getSelectedItem().toString());
        int idServicio = Integer.parseInt(cboTratamiento.getSelectedItem().toString());
        java.util.Date fechaAtencion = jdcFecha.getDate();

        

        try {
            ////////////////////////////////////////////////////////
            Atencion ate = new Atencion(id_atencion, valorAtencion, idDoctor, idPaciente, idAsistente, idServicio, fechaAtencion);
            ////////////////////////////////////////////////////////

            DaoAtencion dao = new DaoAtencion();
            boolean resp = dao.Modificar(ate);
            if (resp == true) {
                JOptionPane.showMessageDialog(null, "Modifico");
                Listar();
            } else {
                JOptionPane.showMessageDialog(null, "No Modifico");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int id_atencion = Integer.parseInt(txtIdAtencion.getText());
        DaoAtencion ate = new DaoAtencion();
        boolean resp = ate.Eliminar(id_atencion);
        if (resp == true) {
            JOptionPane.showMessageDialog(null, "Elimino");
            Listar();
        } else {
            JOptionPane.showMessageDialog(null, "No Elimino");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed

        int idDoctor = Integer.valueOf(cboDoctor.getSelectedItem().toString());
        int idPaciente = Integer.valueOf(cboPaciente.getSelectedItem().toString());
        int idAsistente = Integer.valueOf(cboAsistente.getSelectedItem().toString());
        int idServicio = Integer.valueOf(cboTratamiento.getSelectedItem().toString());
        String ValorAtencion = txtValorTratamiento.toString();
        java.util.Date fechaAtencion = jdcFecha.getDate();

        try {
            ////////////////////////////////////////////////////////
            Atencion ate = new Atencion(idServicio, idServicio, idDoctor, idPaciente, idAsistente, idServicio, fechaAtencion);
            ////////////////////////////////////////////////////////

            DaoAtencion dao = new DaoAtencion();
            boolean resp = dao.Grabar(ate);
            if (resp == true) {
                JOptionPane.showMessageDialog(null, "Grabo");
                Listar();
            } else {
                JOptionPane.showMessageDialog(null, "No Grabo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void txtNombrePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombrePacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombrePacienteActionPerformed

    private void txtIdAtencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdAtencionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdAtencionActionPerformed

    private void BtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVolverActionPerformed
        JFrmMainMenu mainmenu=new JFrmMainMenu();
        mainmenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnVolverActionPerformed

    private void btnOkDoctor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkDoctor1ActionPerformed
        int IdDoctor = Integer.parseInt(cboDoctor.getSelectedItem().toString());
        Doctor doc = new DaoDoctor().Buscar(IdDoctor);
        if (doc != null) {
            txtNombreDoctor.setText(doc.getNombre());
            txtRutDoctor.setText(String.valueOf(doc.getNum_rut()));

        } else {
            JOptionPane.showMessageDialog(null, "No Existe Doctor");
            Listar();
        }
    }//GEN-LAST:event_btnOkDoctor1ActionPerformed

    private void btnFiltroPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroPacienteActionPerformed
        ListarnombrePaciente();
    }//GEN-LAST:event_btnFiltroPacienteActionPerformed

    private void btnNombreDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNombreDoctorActionPerformed
        ListarnombreDoctor();
    }//GEN-LAST:event_btnNombreDoctorActionPerformed

    private void btnFiltroPrevisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroPrevisionActionPerformed
        ListarnombrePrevision();
    }//GEN-LAST:event_btnFiltroPrevisionActionPerformed

    private void btnOkAsistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkAsistenteActionPerformed
        int Idasistente = Integer.parseInt(cboAsistente.getSelectedItem().toString());
        Asistente asist = new DaoAsistente().Buscar(Idasistente);
        if (asist != null) {
            txtNombreAsistente.setText(asist.getNombre());
            txtRutAsistente.setText(String.valueOf(asist.getNum_rut()));

        } else {
            JOptionPane.showMessageDialog(null, "No Existe Doctor");
            Listar();
        }
    }//GEN-LAST:event_btnOkAsistenteActionPerformed

    private void MnnuVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnnuVolverActionPerformed
        JFrmMainMenu mainmenu=new JFrmMainMenu();
        mainmenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MnnuVolverActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFrmLogin login= new JFrmLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void cboFiltroNombrePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFiltroNombrePacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboFiltroNombrePacienteActionPerformed

    private void cboPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPacienteActionPerformed


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
            java.util.logging.Logger.getLogger(JFrmAdminAtencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmAdminAtencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmAdminAtencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmAdminAtencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmAdminAtencion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnVolver;
    private javax.swing.JTable JTblMuestraDatosAtencion;
    private javax.swing.JMenuItem MnnuVolver;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFiltroPaciente;
    private javax.swing.JButton btnFiltroPrevision;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNombreDoctor;
    private javax.swing.JButton btnOkAsistente;
    private javax.swing.JButton btnOkDoctor1;
    private javax.swing.JButton btnOkTratamiento;
    private javax.swing.JButton btnOkpaciente;
    private javax.swing.JComboBox<String> cboAsistente;
    private javax.swing.JComboBox<String> cboDoctor;
    private javax.swing.JComboBox<String> cboFiltroNombreDoctor;
    private javax.swing.JComboBox<String> cboFiltroNombrePaciente;
    private javax.swing.JComboBox<String> cboFiltroPrevision;
    private javax.swing.JComboBox<String> cboPaciente;
    private javax.swing.JComboBox<String> cboTratamiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTextField txtDireccionPaciente;
    private javax.swing.JTextField txtIdAtencion;
    private javax.swing.JTextField txtNombreAsistente;
    private javax.swing.JTextField txtNombreDoctor;
    private javax.swing.JTextField txtNombrePaciente;
    private javax.swing.JTextField txtNombreTratamiento;
    private javax.swing.JTextField txtPrevisionPaciente;
    private javax.swing.JTextField txtRutAsistente;
    private javax.swing.JTextField txtRutDoctor;
    private javax.swing.JTextField txtRutPaciente;
    private javax.swing.JTextField txtValorTratamiento;
    // End of variables declaration//GEN-END:variables
}
