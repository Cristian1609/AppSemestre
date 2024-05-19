package VistasDocente;

import vistasAlumno.*;
import vistasAdministrador.*;
import Main.VistaIniciarSesion;
import Clases.CLlenarCombo;
import Clases.SQLUsuarios;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Docente_InformacionPersonal extends javax.swing.JFrame {
    
    private String dato;
    CLlenarCombo Lc = new CLlenarCombo();
    SQLUsuarios sql = new SQLUsuarios();
    
    public Docente_InformacionPersonal() {
        initComponents();
        Lc.LlenarCombo("Eps", "nombre", ComboEps);
        Lc.LlenarCombo("Sexo", "nombre", comboSexo);
        Lc.LlenarCombo("Tipo_identificacion ", "nombre", comboIdentificacion);
    }
    
    public void setDato(String dato) {
        this.dato = dato;
        lblDato.setText(dato);
        sql.mostrarDatos(dato, lblDato, lblNombre, lblTidentificacion, lblNidentificacion1, lblCorreo, lblTelefono, lblFnacimiento, lblSexo, lblEps, lblCodigoInstitucional, lblCoreoInstitucional, lblContraseña, txtNombre, comboIdentificacion, txtNumeroIdentificacion, txtCorreoPersonal, txtTelefono, comboSexo, ComboEps,"Docente");
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblDato = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        lblTidentificacion = new javax.swing.JLabel();
        comboIdentificacion = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        lblNidentificacion1 = new javax.swing.JLabel();
        txtNumeroIdentificacion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtCorreoPersonal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lblFnacimiento = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        comboSexo = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        lblEps = new javax.swing.JLabel();
        ComboEps = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        lblCodigoInstitucional = new javax.swing.JLabel();
        lblCoreoInstitucional = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        lblDato.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        lblDato.setForeground(new java.awt.Color(255, 255, 255));
        lblDato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDato.setText("Codigo Institucional");
        lblDato.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lblDato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDatoMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Bienvenido");

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

        jLabel3.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Horario");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cursos");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255)));
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Alumnos");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
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
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDato)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 540));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Información Personal");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 8, 756, -1));

        jLabel24.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Nombre:");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 76, 120, -1));

        lblNombre.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombre.setText("Nombre:");
        jPanel2.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 76, 220, -1));
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 76, 220, -1));

        jLabel25.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Tipo identificación:");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 116, 140, -1));

        lblTidentificacion.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        lblTidentificacion.setForeground(new java.awt.Color(255, 255, 255));
        lblTidentificacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTidentificacion.setText("Nombre:");
        jPanel2.add(lblTidentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 116, 220, -1));

        jPanel2.add(comboIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 116, 220, -1));

        jLabel26.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Numero Identificación:");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 156, 160, -1));

        lblNidentificacion1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        lblNidentificacion1.setForeground(new java.awt.Color(255, 255, 255));
        lblNidentificacion1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNidentificacion1.setText("Nombre:");
        jPanel2.add(lblNidentificacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 156, 220, -1));
        jPanel2.add(txtNumeroIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 156, 220, -1));

        jLabel13.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Correo Personal:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 196, 140, -1));

        lblCorreo.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCorreo.setText("Nombre:");
        jPanel2.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 196, 220, -1));

        txtCorreoPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoPersonalActionPerformed(evt);
            }
        });
        jPanel2.add(txtCorreoPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 196, 220, -1));

        jLabel14.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Telefono:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 236, 130, -1));

        lblTelefono.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefono.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTelefono.setText("Nombre:");
        jPanel2.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 236, 220, -1));
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 236, 220, -1));

        jLabel15.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Fecha Nacimiento:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 276, 140, -1));

        lblFnacimiento.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        lblFnacimiento.setForeground(new java.awt.Color(255, 255, 255));
        lblFnacimiento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFnacimiento.setText("Nombre:");
        jPanel2.add(lblFnacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 276, 220, -1));

        jLabel16.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Sexo:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 314, 100, 30));

        lblSexo.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        lblSexo.setForeground(new java.awt.Color(255, 255, 255));
        lblSexo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSexo.setText("Nombre:");
        jPanel2.add(lblSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 314, 220, 30));

        jPanel2.add(comboSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 314, 220, -1));

        jLabel23.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Eps:");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 362, 100, 30));

        lblEps.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        lblEps.setForeground(new java.awt.Color(255, 255, 255));
        lblEps.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEps.setText("Nombre:");
        jPanel2.add(lblEps, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 362, 220, 30));

        jPanel2.add(ComboEps, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 372, 220, -1));

        jLabel21.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Codigo Institucional:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 404, 150, -1));

        lblCodigoInstitucional.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        lblCodigoInstitucional.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoInstitucional.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCodigoInstitucional.setText("Nombre:");
        jPanel2.add(lblCodigoInstitucional, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 399, 220, 30));

        lblCoreoInstitucional.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        lblCoreoInstitucional.setForeground(new java.awt.Color(255, 255, 255));
        lblCoreoInstitucional.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCoreoInstitucional.setText("Nombre:");
        jPanel2.add(lblCoreoInstitucional, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 435, 220, 30));

        jLabel22.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Correo Institucional:");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 150, -1));

        jLabel27.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Constraseña:");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 150, -1));

        lblContraseña.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        lblContraseña.setForeground(new java.awt.Color(255, 255, 255));
        lblContraseña.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblContraseña.setText("Nombre:");
        jPanel2.add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 474, 220, 30));

        jLabel17.setBackground(new java.awt.Color(51, 255, 51));
        jLabel17.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 255, 51));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Editar");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 255, 0), new java.awt.Color(51, 255, 0)));
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 471, 158, 32));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 760, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        VistaIniciarSesion vi = new VistaIniciarSesion();
        JOptionPane.showMessageDialog(null, "Hata pronto!! " + dato + ".");
        this.setVisible(false);
        vi.setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void lblDatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDatoMouseClicked
        Docente_InformacionPersonal adminIP = new Docente_InformacionPersonal();
        adminIP.setVisible(true);
        this.setVisible(false);
        adminIP.setDato(dato);
    }//GEN-LAST:event_lblDatoMouseClicked

    private void txtCorreoPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoPersonalActionPerformed
        AdminUsuarios adminU = new AdminUsuarios();
        this.setVisible(false);
        adminU.setVisible(true);
        adminU.setDato(dato);
    }//GEN-LAST:event_txtCorreoPersonalActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        try {
            sql.ModificarDatos(txtNombre, comboIdentificacion, txtNumeroIdentificacion, txtCorreoPersonal, txtTelefono, comboSexo, ComboEps, dato,"Docente");
            JOptionPane.showMessageDialog(null, "Datos modificados correctamente");
            sql.mostrarDatos(dato, lblDato, lblNombre, lblTidentificacion, lblNidentificacion1, lblCorreo, lblTelefono, lblFnacimiento, lblSexo, lblEps, lblCodigoInstitucional, lblCoreoInstitucional, lblContraseña, txtNombre, comboIdentificacion, txtNumeroIdentificacion, txtCorreoPersonal, txtTelefono, comboSexo, ComboEps,"Docente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
         Docente_Horario doH = new Docente_Horario();
        doH.setDato(dato);
        doH.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
       Docente_Cursos doC = new Docente_Cursos();
        doC.setDato(dato);
        this.setVisible(false);
        doC.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        Docente_Alumnos doA = new Docente_Alumnos();
        doA.setVisible(true);
        doA.setDato(dato);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new Docente_InformacionPersonal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboEps;
    private javax.swing.JComboBox<String> comboIdentificacion;
    private javax.swing.JComboBox<String> comboSexo;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCodigoInstitucional;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblCoreoInstitucional;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDato;
    private javax.swing.JLabel lblEps;
    private javax.swing.JLabel lblFnacimiento;
    private javax.swing.JLabel lblNidentificacion1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTidentificacion;
    private javax.swing.JTextField txtCorreoPersonal;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroIdentificacion;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
