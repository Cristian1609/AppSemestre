package VistasV1;

import BD.Conexion;
import Clases.CConcretaAlumno;
import Clases.CConcretaDocente;
import Clases.CLlenarCombo;
import Clases.CSexo;
import Clases.IUsuario;
import Factory.SQLUsuarioFactory;
import Factory.UsuarioFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Admin_Docentes extends javax.swing.JFrame {

    CLlenarCombo Lc = new CLlenarCombo();
    SQLUsuarioFactory sq = new SQLUsuarioFactory();
    CSexo s = new CSexo();
    private String dato;

    public Admin_Docentes() {
        initComponents();
        sq.MostrarDocente(jTable1);
        Lc.LlenarCombo("Programa", "nombre", comboPrograma);
        Lc.LlenarCombo("eps", "nombre", comboEps);
        Lc.LlenarCombo("sexo", "nombre", comboSexo);
        Lc.LlenarCombo("tipo_identificacion", "nombre", comboTipoIdentificacion);
        Lc.LlenarCombo("Especialidad", "nombre", comboEspecialidad);
    }

    public void setDato(String dato) {
        this.dato = dato;
        lblDato.setText("Bienvenido: " + dato);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblDato = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtNumeroIdentificacion = new javax.swing.JTextField();
        txtCorreoPersonal = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCodigoInstitucional = new javax.swing.JTextField();
        txtCorreoInstitucional = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        txtRol = new javax.swing.JTextField();
        comboTipoIdentificacion = new javax.swing.JComboBox<>();
        comboPrograma = new javax.swing.JComboBox<>();
        comboEps = new javax.swing.JComboBox<>();
        comboSexo = new javax.swing.JComboBox<>();
        jcalendarNacimiento = new com.toedter.calendar.JDateChooser();
        comboEspecialidad = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        lblDato.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        lblDato.setForeground(new java.awt.Color(255, 255, 255));
        lblDato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDato.setText("Codigo Institucional");
        lblDato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDatoMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Bienvenido");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Alumnos");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Docentes");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel6.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Programa Academico");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Semestre Academico");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Asignaturas");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel9.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Cursos");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Pensum");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 0, 0));
        jLabel11.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Salir");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Usuarios");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDato)
                .addGap(74, 74, 74)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(408, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 520));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Registro");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1086, 20));

        jLabel20.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Docentes");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 22, 1086, -1));

        jButton2.setBackground(new java.awt.Color(255, 204, 0));
        jButton2.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 204, 0));
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButton2.setText("Modificar");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 204, 0), new java.awt.Color(255, 204, 0)));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(839, 315, 148, 37));

        jButton1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 255));
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButton1.setText("Registrar");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 204), new java.awt.Color(0, 0, 204)));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 315, 148, 37));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 94, 80, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Tipo Identificación:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 128, -1, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Numero Identificación:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 161, -1, -1));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Correo:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 195, 80, -1));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Telefono:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 227, 140, -1));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Fecha Nacimiento:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 268, 140, -1));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Sexo:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 303, 140, -1));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Eps:");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 335, 140, -1));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Programa:");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 100, -1));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Especialidad:");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, -1, -1));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Correo Institucional:");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 154, -1));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Contraseña:");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 120, -1));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Rol:");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 80, -1));

        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setBorder(null);
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 95, 237, 18));

        txtNumeroIdentificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroIdentificacion.setBorder(null);
        jPanel2.add(txtNumeroIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 162, 237, 18));

        txtCorreoPersonal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCorreoPersonal.setBorder(null);
        jPanel2.add(txtCorreoPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 196, 237, 18));

        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.setBorder(null);
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 228, 237, 18));

        txtCodigoInstitucional.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigoInstitucional.setBorder(null);
        jPanel2.add(txtCodigoInstitucional, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, 237, 18));

        txtCorreoInstitucional.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCorreoInstitucional.setBorder(null);
        jPanel2.add(txtCorreoInstitucional, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, 237, 18));

        txtContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContraseña.setBorder(null);
        jPanel2.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, 237, 18));

        txtRol.setEditable(false);
        txtRol.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRol.setText("Docente");
        jPanel2.add(txtRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 270, 237, -1));

        jPanel2.add(comboTipoIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 127, 237, -1));

        comboPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProgramaActionPerformed(evt);
            }
        });
        jPanel2.add(comboPrograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 237, -1));

        jPanel2.add(comboEps, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 330, 237, -1));

        jPanel2.add(comboSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 298, 237, -1));
        jPanel2.add(jcalendarNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 264, 237, -1));

        comboEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEspecialidadActionPerformed(evt);
            }
        });
        jPanel2.add(comboEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, 237, -1));

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setAutoscrolls(false);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setDragEnabled(true);
        jTable1.setInheritsPopupMenu(true);
        jTable1.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 371, 1074, 121));

        jButton3.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButton3.setText("Eliminar");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 0, 0), new java.awt.Color(255, 0, 0)));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 315, 148, 37));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Codigo Institucional:");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1090, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        AdminUsuarios adminU = new AdminUsuarios();
        this.setVisible(false);
        adminU.setVisible(true);
        adminU.setDato(dato);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            Conexion conexion = new Conexion();
            Connection conn = conexion.conectar();

            if (conn == null) {
                throw new SQLException("No se pudo establecer la conexión a la base de datos.");
            }
            UsuarioFactory factory = new UsuarioFactory();
            int nuevoIdUsuario = SQLUsuarioFactory.RegistrarUsuario(
                    txtNombre,
                    comboTipoIdentificacion,
                    txtNumeroIdentificacion,
                    txtCorreoPersonal, txtTelefono,
                    jcalendarNacimiento, comboSexo,
                    comboEps,
                    factory,
                    txtRol,
                    comboPrograma
            );
            if (nuevoIdUsuario != -1) {
                IUsuario usuario = new CConcretaDocente();
                SQLUsuarioFactory.RegistrarDocente(conn, nuevoIdUsuario, factory, comboEspecialidad, comboPrograma, txtCodigoInstitucional, txtCorreoInstitucional, txtContraseña, usuario);

                sq.MostrarDocente(jTable1);
            } else {
                throw new SQLException("No se pudo obtener el ID del nuevo usuario.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Admin_Docentes.class.getName()).log(Level.SEVERE, "Error al registrar usuario", ex);
        }

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        try {
            int filaSeleccionada = jTable1.getSelectedRow();

            if (filaSeleccionada >= 0) {
                int docenteId = Integer.parseInt(jTable1.getValueAt(filaSeleccionada, 0).toString());

                boolean resultado = SQLUsuarioFactory.modificarDocente(docenteId, txtNombre, comboTipoIdentificacion, txtCorreoPersonal, txtNumeroIdentificacion, txtTelefono, jcalendarNacimiento, comboSexo, comboEps, comboPrograma, txtCodigoInstitucional, txtCorreoInstitucional, txtContraseña);

                if (resultado) {
                    JOptionPane.showMessageDialog(null, "docente modificado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo modificar el docente.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        sq.MostrarDocente(jTable1);

    }//GEN-LAST:event_jButton2MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        VistaIniciarSesion vi = new VistaIniciarSesion();
        JOptionPane.showMessageDialog(null, "Hata pronto!! " + dato + ".");
        this.setVisible(false);
        vi.setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int filaSeleccionada = jTable1.getSelectedRow();

        if (filaSeleccionada >= 0) {
            try {

                int DocenteId = Integer.parseInt(jTable1.getValueAt(filaSeleccionada, 0).toString());

                SQLUsuarioFactory.CargarDocente(DocenteId, txtNombre, comboTipoIdentificacion, txtNumeroIdentificacion, txtCorreoPersonal, txtTelefono, jcalendarNacimiento, comboSexo, comboEspecialidad, comboEps, comboPrograma, txtCodigoInstitucional, txtCorreoInstitucional, txtContraseña);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error al obtener el ID del docente: " + e.getMessage());
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cargar datos del docente: " + e.getMessage());
            }
        } else {

            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún registro.");
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void lblDatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDatoMouseClicked
        Admin_InformacionPersonal adminIP = new Admin_InformacionPersonal();
        adminIP.setVisible(true);
        this.setVisible(false);
        adminIP.setDato(dato);
    }//GEN-LAST:event_lblDatoMouseClicked

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

    private void comboEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEspecialidadActionPerformed

    private void comboProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProgramaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProgramaActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        AdminUsuarios_Programa adminP = new AdminUsuarios_Programa();
        adminP.setDato(dato);
        adminP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Admin_Alumnos adminA = new Admin_Alumnos();
        this.setVisible(false);
        adminA.setDato(dato);
        adminA.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        AdminUsuarios_Semestre adminS = new AdminUsuarios_Semestre();
        adminS.setDato(dato);
        adminS.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        Admin_Pensum adminP = new Admin_Pensum();
        adminP.setDato(dato);
        adminP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        Admin_Curso adminC = new Admin_Curso();
        adminC.setDato(dato);
        adminC.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel9MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Admin_Docentes().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboEps;
    private javax.swing.JComboBox<String> comboEspecialidad;
    private javax.swing.JComboBox<String> comboPrograma;
    private javax.swing.JComboBox<String> comboSexo;
    private javax.swing.JComboBox<String> comboTipoIdentificacion;
    private javax.swing.JLabel jButton1;
    private javax.swing.JLabel jButton2;
    private javax.swing.JLabel jButton3;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser jcalendarNacimiento;
    private javax.swing.JLabel lblDato;
    private javax.swing.JTextField txtCodigoInstitucional;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtCorreoInstitucional;
    private javax.swing.JTextField txtCorreoPersonal;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroIdentificacion;
    private javax.swing.JTextField txtRol;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
