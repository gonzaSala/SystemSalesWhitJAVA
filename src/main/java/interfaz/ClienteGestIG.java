package interfaz;

import controlador.ControladorCliente;
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
import modelo.Cliente;

public class ClienteGestIG extends javax.swing.JInternalFrame {

    private int idCliente;

    Font font = new Font("Montserrat", Font.BOLD, 14);
    Font font1 = new Font("Montserrat", Font.PLAIN, 12);
    Font font2 = new Font("Montserrat", Font.BOLD, 22);

    public ClienteGestIG() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Gestion de Clientes");

        this.cargarTablaClientes();

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

        btnActualizar.setFont(font);
        btnActualizar.setForeground(new Color(102, 102, 255));
        btnEliminar.setFont(font);
        btnEliminar.setForeground(new Color(202, 102, 255));

        txtApellido.setOpaque(true);
        txtApellido.setBackground(new Color(51, 102, 255));
        txtApellido.setFont(font);
        txtApellido.setForeground(new Color(221, 221, 221));
        txtCedula.setOpaque(true);
        txtCedula.setBackground(new Color(51, 102, 255));
        txtCedula.setFont(font);
        txtCedula.setForeground(new Color(221, 221, 221));
        txtDireccion.setOpaque(true);
        txtDireccion.setBackground(new Color(51, 102, 255));
        txtDireccion.setFont(font);
        txtDireccion.setForeground(new Color(221, 221, 221));
        txtNombre.setOpaque(true);
        txtNombre.setBackground(new Color(51, 102, 255));
        txtNombre.setFont(font);
        txtNombre.setForeground(new Color(221, 221, 221));
        txtTelefono.setOpaque(true);
        txtTelefono.setBackground(new Color(51, 102, 255));
        txtTelefono.setFont(font);
        txtTelefono.setForeground(new Color(221, 221, 221));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCliente = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Administrar Clientes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 310, 20));

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 250));

        tableCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableCliente);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 600, 250));

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        jPanel3.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 170, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Apellido");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, 30));

        txtApellido.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        jPanel3.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 170, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cedula");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 80, 30));

        txtDireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        jPanel3.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 170, -1));

        txtTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        jPanel3.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 170, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Telefono");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 80, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Dirección");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 80, 30));

        txtCedula.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        jPanel3.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 850, 80));

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 153, 255));
        kGradientPanel1.setkGradientFocus(-100);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 102, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnActualizar.setBackground(new java.awt.Color(204, 255, 255));
        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setText("Actualizar");
        btnActualizar.setToolTipText("");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, -1));

        btnEliminar.setBackground(new java.awt.Color(204, 255, 255));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, -1));

        kGradientPanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 130, 90));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        if (txtNombre.getText().isEmpty() && txtTelefono.getText().isEmpty() && txtCedula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        } else {
            Cliente cliente = new Cliente();
            ControladorCliente controlCliente = new ControladorCliente();

            cliente.setNombre(txtNombre.getText().trim());
            cliente.setApellido(txtApellido.getText().trim());
            cliente.setDireccion(txtDireccion.getText().trim());
            cliente.setTelefono(txtTelefono.getText().trim());
            cliente.setCedula(txtCedula.getText().trim());

            if (controlCliente.actualizar(cliente, idCliente)) {
                JOptionPane.showMessageDialog(null, "Datos del cliente actualizados");
                this.cargarTablaClientes();
                this.limpiar();

            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar");

            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Cliente cliente = new Cliente();
        ControladorCliente controlCliente = new ControladorCliente();

        if (idCliente == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente");
        } else {
            if (!controlCliente.eliminar(idCliente)) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito");
                this.cargarTablaClientes();
                this.limpiar();
                idCliente = 0;

            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el cliente");
                this.limpiar();

            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed


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
    public static javax.swing.JTable tableCliente;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaClientes() {
        Connection con = conexion.Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);
        String sql = "select * from tb_cliente";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ClienteGestIG.tableCliente = new JTable(model);
            ClienteGestIG.jScrollPane1.setViewportView(ClienteGestIG.tableCliente);

            model.addColumn("N°");
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("Cedula");
            model.addColumn("Direccion");
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
            System.out.println("Error al llenar la tabla cliente" + e);
        }

        tableCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tableCliente.rowAtPoint(e.getPoint());
                int col_point = 0;

                if (fila_point > -1) {
                    idCliente = (int) model.getValueAt(fila_point, col_point);
                    EnviarDatosClienteSeleccionado(idCliente);
                }
            }

        });
    }

    private void EnviarDatosClienteSeleccionado(int idCliente) {
        try {
            Connection con = conexion.Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select * from tb_cliente where idCliente = '" + idCliente + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtNombre.setText(rs.getString("nombre"));
                txtApellido.setText(rs.getString("apellido"));
                txtCedula.setText(rs.getString("cedula"));
                txtDireccion.setText(rs.getString("direccion"));
                txtTelefono.setText(rs.getString("telefono"));

            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Error seleccioanr categoria" + e);
        }
    }

    public void centrarEnDesktopPane() {
        Dimension desktopSize = jDesktopPaneMenu.getSize();
        Dimension frameSize = getSize();
        setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
    }

    private void limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");

    }
}
