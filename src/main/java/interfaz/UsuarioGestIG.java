package interfaz;

import controlador.ControladorUsuario;
import static interfaz.ClienteGestIG.tableCliente;
import static interfaz.MenuIG.jDesktopPaneMenu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;

public class UsuarioGestIG extends javax.swing.JInternalFrame {

    private int idUsuario = 0;
    Font font = new Font("Montserrat", Font.BOLD, 14);
    Font font1 = new Font("Montserrat", Font.PLAIN, 12);
    Font font2 = new Font("Montserrat", Font.BOLD, 22);

    public UsuarioGestIG() {
        initComponents();
        setSize(new Dimension(900, 500));
        setTitle("Gestionar Usuarios");
        cargarTablaUsuario();

        jLabel1.setFont(font2);
        jLabel1.setForeground(new Color(221, 221, 221));
        jLabel2.setFont(font1);
        jLabel2.setForeground(new Color(221, 221, 221));
        jLabel3.setFont(font1);
        jLabel3.setForeground(new Color(221, 221, 221));
        jLabel4.setFont(font1);
        jLabel4.setForeground(new Color(221, 221, 221));
        jLabel5.setFont(font1);
        jLabel5.setForeground(new Color(221, 221, 221));
        jLabel7.setFont(font1);
        jLabel7.setForeground(new Color(221, 221, 221));

        btnEliminar.setFont(font);
        btnEliminar.setForeground(new Color(202, 102, 255));
        btnActualizar.setFont(font);
        btnActualizar.setForeground(new Color(102, 102, 255));

        txtApellido.setOpaque(true);
        txtApellido.setBackground(new Color(51, 102, 255));
        txtApellido.setFont(font);
        txtApellido.setForeground(new Color(221, 221, 221));
        txtNombre.setOpaque(true);
        txtNombre.setBackground(new Color(51, 102, 255));
        txtNombre.setFont(font);
        txtNombre.setForeground(new Color(221, 221, 221));
        txtPassword.setOpaque(true);
        txtPassword.setBackground(new Color(51, 102, 255));
        txtPassword.setFont(font);
        txtPassword.setForeground(new Color(221, 221, 221));
        txtTelefono.setOpaque(true);
        txtTelefono.setBackground(new Color(51, 102, 255));
        txtTelefono.setFont(font);
        txtTelefono.setForeground(new Color(221, 221, 221));
        txtUsuario.setOpaque(true);
        txtUsuario.setBackground(new Color(51, 102, 255));
        txtUsuario.setFont(font);
        txtUsuario.setForeground(new Color(221, 221, 221));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuario = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 250));

        tableUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Categoria", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableUsuario);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 600, 250));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 20, 80, 20));

        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        jPanel3.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 170, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Apellido");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 50, 80, 20));

        txtApellido.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        jPanel3.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 170, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Password");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 80, 20));

        txtUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        jPanel3.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 170, -1));

        txtTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        jPanel3.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 170, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Telefono");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 80, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Usuario");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 80, 20));

        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        jPanel3.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 170, -1));

        btnActualizar.setBackground(new java.awt.Color(204, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.setToolTipText("");
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel3.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 170, 20));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 850, 80));

        kGradientPanel1.setkGradientFocus(1);
        kGradientPanel1.setkStartColor(new java.awt.Color(205, 10, 155));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setBackground(new java.awt.Color(204, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, -1));

        kGradientPanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 130, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Administrador de Usuarios");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 310, 20));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        Usuario usuario = new Usuario();
        ControladorUsuario controlUsuario = new ControladorUsuario();

        if (idUsuario == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario");

        } else {
            if (txtNombre.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtPassword.getText().isEmpty() || txtTelefono.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Complete los campos!");

            } else {
                usuario.setNombre(txtNombre.getText().trim());
                usuario.setApellido(txtApellido.getText().trim());
                usuario.setUsuario(txtUsuario.getText().trim());
                usuario.setPassword(txtPassword.getText().trim());
                usuario.setTelefono(txtTelefono.getText().trim());
                usuario.setEstado(1);
                if (controlUsuario.actualizar(usuario, idUsuario)) {
                    JOptionPane.showMessageDialog(null, "Actualización de usuario completada");
                    this.cargarTablaUsuario();
                    this.limpiar();
                    idUsuario = 0;

                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el usuario!");
                }
            }

        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Usuario usuario = new Usuario();
        ControladorUsuario controlUsuario = new ControladorUsuario();

        if (idUsuario == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario");
        } else {
            if (!controlUsuario.eliminar(idUsuario)) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito");
                this.cargarTablaUsuario();
                this.limpiar();
                idUsuario = 0;
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el usuario");

            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    public void centrarEnDesktopPane() {
        Dimension desktopSize = jDesktopPaneMenu.getSize();
        Dimension frameSize = getSize();
        setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    public static javax.swing.JTable tableUsuario;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaUsuario() {
        Connection con = conexion.Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);
        String sql = "select * from tb_usuario";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            UsuarioGestIG.tableUsuario = new JTable(model);
            UsuarioGestIG.jScrollPane1.setViewportView(UsuarioGestIG.tableUsuario);

            model.addColumn("N°");
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("Usuario");
            model.addColumn("Password");
            model.addColumn("Telefono");
            model.addColumn("Estado");

            while (rs.next()) {

                Object fila[] = new Object[7];

                for (int i = 0; i < 7; i++) {

                    fila[i] = rs.getObject(i + 1);

                }

                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla usuario" + e);
        }

        tableUsuario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tableUsuario.rowAtPoint(e.getPoint());
                int col_point = 0;

                if (fila_point > -1) {
                    idUsuario = (int) model.getValueAt(fila_point, col_point);
                    EnviarDatosClienteSeleccionado(idUsuario);
                }
            }

        });
    }

    private void EnviarDatosClienteSeleccionado(int idCliente) {
        try {
            Connection con = conexion.Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select * from tb_usuario where idUsuario = '" + idUsuario + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtNombre.setText(rs.getString("nombre"));
                txtApellido.setText(rs.getString("apellido"));
                txtUsuario.setText(rs.getString("usuario"));
                txtPassword.setText(rs.getString("password"));
                txtTelefono.setText(rs.getString("telefono"));

            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Error seleccioanr usuario" + e);
        }
    }

    private void limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtUsuario.setText("");
        txtPassword.setText("");
    }
}
