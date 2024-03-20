package interfaz;

import conexion.Conexion;
import controlador.ControladorRegistroVenta;
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
import modelo.CabeceraVenta;

public class VentasGestIG extends javax.swing.JInternalFrame {

    private int idCliente = 0;
    private int idVenta;

    Font font = new Font("Montserrat", Font.BOLD, 14);
    Font font1 = new Font("Montserrat", Font.PLAIN, 12);
    Font font2 = new Font("Montserrat", Font.BOLD, 22);

    public VentasGestIG() {
        initComponents();
        setSize(900, 500);
        setTitle("Gestión de Ventas");
        cargarTablaVentas();
        cargarComboCliente();
        fuentes();

    }

    private void fuentes() {
        txtFecha.setOpaque(true);
        txtFecha.setBackground(new Color(102, 102, 255));
        txtFecha.setFont(font);
        txtTotalPagar.setOpaque(true);
        txtTotalPagar.setBackground(new Color(102, 102, 255));
        txtTotalPagar.setFont(font);
        CbCliente.setOpaque(true);
        CbCliente.setBackground(new Color(102, 102, 255));
        CbCliente.setFont(font);
        CbCliente.setForeground(new Color(221, 221, 221));
        CbEstado.setForeground(new Color(221, 221, 221));
        CbEstado.setOpaque(true);
        CbEstado.setBackground(new Color(102, 102, 255));
        CbEstado.setFont(font);
        jLabel1.setFont(font2);
        jLabel1.setForeground(new Color(221, 221, 221));
         btnActualizar.setFont(font);
        btnActualizar.setForeground(new Color(102,102,255));
        jLabel2.setFont(font1);
        jLabel2.setForeground(new Color(221, 221, 221));
        jLabel3.setFont(font1);
        jLabel3.setForeground(new Color(221, 221, 221));
        jLabel4.setFont(font1);
        jLabel4.setForeground(new Color(221, 221, 221));
        jLabel5.setFont(font1);
        jLabel5.setForeground(new Color(221, 221, 221));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVentas = new javax.swing.JTable();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CbEstado = new javax.swing.JComboBox<>();
        CbCliente = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestionar Ventas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 310, 40));

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 250));

        tableVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        tableVentas.setGridColor(new java.awt.Color(51, 0, 51));
        jScrollPane1.setViewportView(tableVentas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 850, 280));

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 102, 255));
        kGradientPanel1.setkGradientFocus(10);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 153, 255));

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Total Pagar");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 80, 30));

        txtTotalPagar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTotalPagar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 255)));
        txtTotalPagar.setEnabled(false);
        txtTotalPagar.setOpaque(true);
        jPanel3.add(txtTotalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 170, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 80, 30));

        txtFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtFecha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 255)));
        txtFecha.setEnabled(false);
        txtFecha.setOpaque(true);
        jPanel3.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 170, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cliente");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 80, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Estado");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 80, 30));

        CbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        CbEstado.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(CbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 170, 30));

        CbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:", "Item 2", "Item 3", "Item 4" }));
        CbCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(CbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 170, 30));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnActualizar.setBackground(new java.awt.Color(204, 255, 255));
        btnActualizar.setForeground(new java.awt.Color(102, 102, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.setToolTipText("");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 40));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 130, 60));

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(369, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        CabeceraVenta cv = new CabeceraVenta();
        ControladorRegistroVenta controlRV = new ControladorRegistroVenta();

        String cliente, estado;
        cliente = CbCliente.getSelectedItem().toString().trim();
        estado = CbEstado.getSelectedItem().toString().trim();

        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select idCliente, concat(nombre,' ', apellido) as cliente from tb_cliente where concat(nombre,' ', apellido) ='" + cliente + "'");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                idCliente = rs.getInt("IdCliente");
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar el ID CLIENTE: " + e);
        }

        if (!cliente.equalsIgnoreCase("Seleccione cliente:")) {
            cv.setIdCliente(idCliente);
            if (estado.equalsIgnoreCase("Activo")) {
                cv.setEstado(1);
            } else {
                cv.setEstado(0);
            }

            if (controlRV.actualizar(cv, idVenta)) {
                JOptionPane.showMessageDialog(null, "Registro actualizado correctamente!");
                cargarTablaVentas();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el registro exitosamente, revise lo datos!");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro para actualizar!");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbCliente;
    private javax.swing.JComboBox<String> CbEstado;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    public static javax.swing.JTable tableVentas;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        txtFecha.setText("");
        txtTotalPagar.setText("");
        CbCliente.setSelectedItem("Seleccione cliente:");
        CbEstado.setSelectedItem("Activo");
        idCliente = 0;
    }

    private void cargarTablaVentas() {
        Connection con = conexion.Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel() {
            // Establecer el comparador para la columna de fecha
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3) { // Indica la columna de la fecha (índice 3)
                    return java.sql.Timestamp.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
        model.setRowCount(0);
        String sql = "SELECT cv.idCabeceraVenta AS id, CONCAT(c.nombre,' ',c.apellido) AS cliente, cv.valorPagar AS total, cv.fechaVenta AS fecha, cv.estado FROM tb_cabecera_venta AS cv, tb_cliente AS c WHERE cv.idCliente = c.idCliente ORDER BY cv.fechaVenta;"; // Modificar la consulta SQL para ordenar por fecha
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            VentasGestIG.tableVentas = new JTable(model);
            VentasGestIG.jScrollPane1.setViewportView(VentasGestIG.tableVentas);

            model.addColumn("N°");
            model.addColumn("Cliente");
            model.addColumn("Total a Pagar");
            model.addColumn("Fecha");
            model.addColumn("Estado");

            while (rs.next()) {
                Object fila[] = new Object[5];
                for (int i = 0; i < 5; i++) {
                    if (i == 4) {
                        String estado = String.valueOf(rs.getObject(i + 1));
                        if (estado.equalsIgnoreCase("1")) {
                            fila[i] = "Activo";
                        } else {
                            fila[i] = "Inactivo";
                        }
                    } else {
                        fila[i] = rs.getObject(i + 1);
                    }
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla ventas" + e);
        }

        tableVentas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tableVentas.rowAtPoint(e.getPoint());
                int col_point = 0;
                if (fila_point > -1) {
                    idVenta = (int) model.getValueAt(fila_point, col_point);
                    EnviarDatosVentaSeleccionado(idVenta);
                }
            }
        });
    }

    private void EnviarDatosVentaSeleccionado(int idVenta) {
        try {
            Connection con = conexion.Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select cv.idCabeceraVenta, cv.idCliente, concat(c.nombre,' ', c.apellido) as cliente, cv.valorPagar, cv.fechaVenta, cv.estado from tb_cabecera_venta as cv, tb_cliente as c where idCabeceraVenta = '" + idVenta + "' and cv.idCliente = c.idCliente ORDER BY cv.fechaVenta;");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                CbCliente.setSelectedItem(rs.getString("cliente"));
                txtTotalPagar.setText(rs.getString("valorPagar"));
                txtFecha.setText(rs.getString("fechaVenta"));
                int estado = rs.getInt("estado");
                if (estado == 1) {
                    CbEstado.setSelectedItem("Activo");
                } else {
                    CbEstado.setSelectedItem("Inactivo");
                }
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Error seleccioanr vehnna" + e);
        }
    }

    private void cargarComboCliente() {

        Connection con = Conexion.conectar();
        String sql = "select * from tb_cliente";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            CbCliente.removeAllItems();
            CbCliente.addItem("Seleccione cliente:");

            while (rs.next()) {
                CbCliente.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar cliente/s" + e);
        }
    }

    public void centrarEnDesktopPane() {
        Dimension desktopSize = jDesktopPaneMenu.getSize();
        Dimension frameSize = getSize();
        setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
    }

}
