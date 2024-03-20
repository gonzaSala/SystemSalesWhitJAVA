package interfaz;

import conexion.Conexion;
import controlador.ControladorProducto;
import static interfaz.CategoriaGestIG.tableCategoria;
import static interfaz.MenuIG.jDesktopPaneMenu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
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
import modelo.Producto;

public class ProductoGestIG extends javax.swing.JInternalFrame {

    private int idProducto;
    int obtenterIdCategoriaCombo;

    Font font = new Font("Montserrat", Font.BOLD, 14);
    Font font1 = new Font("Montserrat", Font.PLAIN, 12);
    Font font2 = new Font("Montserrat", Font.BOLD, 22);

    public ProductoGestIG() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Geston de Productos");

        this.cargarTablaProductos();
        this.cargarComboCategoria();

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
        jLabel6.setFont(font1);
        jLabel6.setForeground(new Color(221, 221, 221));
        jLabel7.setFont(font1);
        jLabel7.setForeground(new Color(221, 221, 221));

        CbCategoria.setOpaque(true);
        CbCategoria.setBackground(new Color(255,0,255));
        CbCategoria.setFont(font);
        CbCategoria.setForeground(new Color(221, 221, 221));
        CbIVA.setOpaque(true);
        CbIVA.setBackground(new Color(255,0,255));
        CbIVA.setFont(font);
        CbIVA.setForeground(new Color(221, 221, 221));

        txtCantidad.setOpaque(true);
        txtCantidad.setBackground(new Color(255,0,255));
        txtCantidad.setFont(font);
        txtCantidad.setForeground(new Color(221, 221, 221));
        txtDescripcion.setOpaque(true);
        txtDescripcion.setBackground(new Color(255,0,255));
        txtDescripcion.setFont(font);
        txtDescripcion.setForeground(new Color(221, 221, 221));
        txtNombre.setOpaque(true);
        txtNombre.setBackground(new Color(255,0,255));
        txtNombre.setFont(font);
        txtNombre.setForeground(new Color(221, 221, 221));
        txtPrecio.setOpaque(true);
        txtPrecio.setBackground(new Color(255,0,255));
        txtPrecio.setFont(font);
        txtPrecio.setForeground(new Color(221, 221, 221));

        btnActualizar.setFont(font);
        btnActualizar.setForeground(new Color(102, 102, 255));
        btnEliminar.setFont(font);
        btnEliminar.setForeground(new Color(202, 102, 255));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProducto = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CbCategoria = new javax.swing.JComboBox<>();
        CbIVA = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Administrar Productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 310, 20));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 250));

        tableProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableProducto);

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
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        jPanel3.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 170, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cantidad");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, 30));

        txtCantidad.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        txtCantidad.setEnabled(false);
        jPanel3.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 170, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Descripción");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 80, 30));

        txtDescripcion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        jPanel3.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 170, -1));

        txtPrecio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        jPanel3.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 170, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Precio");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 80, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Categoria");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 80, 30));

        CbCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione categoria:" }));
        jPanel3.add(CbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 200, -1));

        CbIVA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CbIVA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione IVA:", "No grava IVA", "21%", "10.5%" }));
        jPanel3.add(CbIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 200, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("IVA");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 80, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 850, 80));

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 0, 255));
        kGradientPanel1.setkGradientFocus(320);
        kGradientPanel1.setkStartColor(new java.awt.Color(25, 0, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Producto prod = new Producto();
        ControladorProducto conProd = new ControladorProducto();

        String iva = "";
        String categoria = "";
        iva = CbIVA.getSelectedItem().toString().trim();
        categoria = CbCategoria.getSelectedItem().toString().trim();

        if (txtNombre.getText().isEmpty() || txtCantidad.getText().isEmpty() || txtPrecio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione todos los campos");
            txtNombre.setBackground(Color.red);
            txtCantidad.setBackground(Color.red);
            txtPrecio.setBackground(Color.red);
            txtDescripcion.setBackground(Color.red);
            txtNombre.setForeground(Color.white);
            txtCantidad.setForeground(Color.white);
            txtPrecio.setForeground(Color.white);
            txtDescripcion.setForeground(Color.white);

        } else {

            if (iva.equalsIgnoreCase("Seleccione IVA:")) {
                JOptionPane.showMessageDialog(null, "Seleccione IVA");
            } else if (categoria.equalsIgnoreCase("Seleccione categoria:")) {
                JOptionPane.showMessageDialog(null, "Seleccione una categoria");
            } else {
                try {

                    prod.setNombre(txtNombre.getText().trim());
                    prod.setCantidad(Integer.parseInt(txtCantidad.getText().trim()));
                    String precioTXT = "";
                    double Precio = 0.0;
                    precioTXT = txtPrecio.getText().trim();
                    boolean aux = false;
                    for (int i = 0; i < precioTXT.length(); i++) {
                        if (precioTXT.charAt(i) == ',') {
                            String precioNuevo = precioTXT.replace(",", ".");
                            Precio = Double.parseDouble(precioNuevo);
                            aux = true;
                        }
                    }

                    if (aux == true) {
                        prod.setPrecio(Precio);
                    } else {
                        Precio = Double.parseDouble(precioTXT);
                        prod.setPrecio(Precio);
                    }

                    prod.setDesctripcion(txtDescripcion.getText().trim());
                    if (iva.equalsIgnoreCase("No grava IVA")) {
                        prod.setPorcentajeIva(0);
                    } else if (iva.equalsIgnoreCase("21%")) {
                        prod.setPorcentajeIva(21);
                    } else if (iva.equalsIgnoreCase("10.5%")) {
                        prod.setPorcentajeIva(10);
                    }

                    this.idCategoria();
                    prod.setIdCategoria(obtenterIdCategoriaCombo);

                    prod.setEstado(1);

                    if (conProd.actualizar(prod, idProducto)) {
                        JOptionPane.showMessageDialog(null, "Producto atualizado con éxito");
                        txtNombre.setBackground(Color.green);
                        txtCantidad.setBackground(Color.green);
                        txtPrecio.setBackground(Color.green);
                        txtDescripcion.setBackground(Color.green);

                        this.cargarComboCategoria();
                        this.cargarTablaProductos();
                        CbIVA.setSelectedItem("Seleccione IVA:");
                        this.limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al actualizar");
                    }

                } catch (HeadlessException | NumberFormatException e) {
                    System.out.println("Error en: " + e);
                }
            }

        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Producto prod = new Producto();
        ControladorProducto controlProd = new ControladorProducto();

        if (idProducto == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        } else {
            if (!controlProd.eliminar(idProducto)) {
                JOptionPane.showMessageDialog(null, "Producto eliminado con éxito");
                this.cargarTablaProductos();
                this.cargarComboCategoria();
                this.limpiar();
                idProducto = 0;

            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el producto");

            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbCategoria;
    private javax.swing.JComboBox<String> CbIVA;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    public static javax.swing.JTable tableProducto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    private void cargarComboCategoria() {
        Connection con = conexion.Conexion.conectar();
        String sql = "select * from tb_categoria";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            CbCategoria.removeAllItems();
            CbCategoria.addItem("Seleccione categoria:");
            while (rs.next()) {
                CbCategoria.addItem(rs.getString("descripcion"));
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar el combo" + e);
        }
    }

    String descripcionCategoria = "";
    double precio = 0.0;
    int porcentajeIva = 0;
    double IVA = 0;

    private void cargarTablaProductos() {
        Connection con = conexion.Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);
        String sql = "select p.idProducto, p.nombre, p.cantidad, p.precio,p.descripcion, p.porcentajeIva, c.descripcion,p.estado  from tb_producto As p, tb_categoria As c where p.idCategoria = c.idCategoria";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ProductoGestIG.tableProducto = new JTable(model);
            ProductoGestIG.jScrollPane1.setViewportView(ProductoGestIG.tableProducto);

            model.addColumn("N°");
            model.addColumn("Nombre");
            model.addColumn("Cantidad");
            model.addColumn("Precio");
            model.addColumn("Descripción");
            model.addColumn("IVA");
            model.addColumn("Categoria");
            model.addColumn("Estado");

            while (rs.next()) {

                precio = rs.getDouble("precio");
                porcentajeIva = rs.getInt("porcentajeIva");
                Object fila[] = new Object[8];

                for (int i = 0; i < 8; i++) {

                    if (i == 5) {
                        this.calcularIVA(precio, porcentajeIva);
                        fila[i] = IVA;
                        rs.getObject(i + 1);
                    } else {
                        fila[i] = rs.getObject(i + 1);
                    }

                }

                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla producto" + e);
        }

        tableProducto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tableProducto.rowAtPoint(e.getPoint());
                int col_point = 0;

                if (fila_point > -1) {
                    idProducto = (int) model.getValueAt(fila_point, col_point);
                    EnviarDatosProductosSeleccionados(idProducto);
                }
            }

        });
    }

    private void EnviarDatosProductosSeleccionados(int idProducto) {
        try {
            Connection con = conexion.Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select * from tb_producto where idProducto = '" + idProducto + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtNombre.setText(rs.getString("nombre"));
                txtCantidad.setText(rs.getString("cantidad"));
                txtDescripcion.setText(rs.getString("descripcion"));
                txtPrecio.setText(rs.getString("precio"));
                int iva = rs.getInt("porcentajeIva");
                switch (iva) {
                    case 0:
                        CbIVA.setSelectedItem("No grava IVA");
                        break;
                    case 21:
                        CbIVA.setSelectedItem("21%");
                        break;
                    case 10:
                        CbIVA.setSelectedItem("10.5%");
                        break;
                    default:
                        CbIVA.setSelectedItem("Seleccione IVA:");
                        break;
                }

                int idCate = rs.getInt("idCategoria");
                CbCategoria.setSelectedItem(relacionarCategoria(idCate));

            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Error seleccionar producto" + e);
        }
    }

    public void centrarEnDesktopPane() {
        Dimension desktopSize = jDesktopPaneMenu.getSize();
        Dimension frameSize = getSize();
        setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
    }

    private double calcularIVA(double precio, int porcentajeIva) {

        int p_iva = porcentajeIva;
        switch (p_iva) {
            case 0:
                IVA = 0.0;
                break;
            case 21:
                IVA = precio * 0.21;
                break;
            case 10:
                IVA = precio * 0.10;
                break;
            default:
                break;
        }

        IVA = (double) Math.round(IVA * 100) / 100;
        return IVA;
    }

    private String relacionarCategoria(int idCategoria) {
        String sql = "select descripcion from tb_categoria where idCategoria='" + idCategoria + "'";
        Statement st;

        try {
            Connection con = conexion.Conexion.conectar();

            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                descripcionCategoria = rs.getString("descripcion");
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener  el id de la Categoria" + e);
        }
        return descripcionCategoria;
    }

    private void limpiar() {
        txtNombre.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        txtDescripcion.setText("");
        CbCategoria.setSelectedItem("Seleccione categoria:");
        CbIVA.setSelectedItem("Seleccione IVA:");
    }

    private int idCategoria() {
        String sql = "select * from tb_categoria where descripcion ='" + this.CbCategoria.getSelectedItem() + "'";
        Statement st;

        try {
            Connection con = Conexion.conectar();
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                obtenterIdCategoriaCombo = rs.getInt("idCategoria");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar la categoria" + e);
        }

        return obtenterIdCategoriaCombo;
    }

}
