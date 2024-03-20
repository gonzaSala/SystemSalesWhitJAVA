package interfaz;

import conexion.Conexion;
import controlador.ControladorRegistroVenta;
import controlador.VentaPDF;
import static interfaz.MenuIG.jDesktopPaneMenu;
import java.awt.Dimension;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.CabeceraVenta;
import modelo.DetalleVenta;

public class FacturacionIG extends javax.swing.JInternalFrame {

    private DefaultTableModel modeloDatosProductos;

    ArrayList<DetalleVenta> listaProducto = new ArrayList<>();
    private DetalleVenta producto;

    private int idCliente = 0;

    private int idProducto = 0;
    private String nombre = "";
    private int cantidadProductoBBDD = 0;
    private double precioUnitario = 0.0;
    private int porcentajeIva = 0;

    private int cantidad = 0;
    private double subtotal = 0.0;
    private double descuento = 0.0;
    private double iva = 0.0;
    private double totalPagar = 0.0;

    private double subtotalGral = 0.0;
    private double descuentoGral = 0.0;
    private double ivaGral = 0.0;
    private double totalPagarGral = 0.0;

    private int auxIdDetalle = 1;

    Font font = new Font("Montserrat", Font.BOLD, 14);
    Font font1 = new Font("Montserrat", Font.PLAIN, 12);
    Font font2 = new Font("Montserrat", Font.BOLD, 22);

    public FacturacionIG() {
        initComponents();
        setSize(new Dimension(794, 650));
        setTitle("Facturación");
        cargarComboCliente();
        cargarComboProducto();
        inicializarTablaProdcuto();

        txtEfectivo.setEnabled(false);
        btnCalcularCambio.setEnabled(false);

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
        jLabel8.setFont(font1);
        jLabel8.setForeground(new Color(221, 221, 221));
        jLabel9.setFont(font1);
        jLabel9.setForeground(new Color(221, 221, 221));
        jLabel10.setFont(font1);
        jLabel10.setForeground(new Color(221, 221, 221));

        btnAnadir.setFont(font);
        btnAnadir.setForeground(new Color(102, 102, 255));
        btnBuscar.setFont(font);
        btnBuscar.setForeground(new Color(102, 102, 255));
        btnCalcularCambio.setFont(font);
        btnCalcularCambio.setForeground(new Color(102, 102, 255));
        btnRegistrar.setFont(font);

        CbCliente.setOpaque(true);
        CbCliente.setBackground(new Color(102, 102, 255));
        CbCliente.setFont(font);
        CbCliente.setForeground(new Color(221, 221, 221));
        CbProducto.setOpaque(true);
        CbProducto.setBackground(new Color(102, 102, 255));
        CbProducto.setFont(font);
        CbProducto.setForeground(new Color(221, 221, 221));

        txtBuscar.setOpaque(true);
        txtBuscar.setBackground(new Color(51, 102, 255));
        txtBuscar.setFont(font);
        txtCantidad.setOpaque(true);
        txtCantidad.setBackground(new Color(51, 102, 255));
        txtCantidad.setFont(font);
        txtCantidad.setForeground(new Color(221, 221, 221));
        txtBuscar.setForeground(new Color(221, 221, 221));

        txtCambio.setOpaque(true);
        txtCambio.setBackground(new Color(200, 0, 255));
        txtCambio.setFont(font);
        txtDescuento.setOpaque(true);
        txtDescuento.setBackground(new Color(200, 0, 255));
        txtDescuento.setFont(font);
        txtEfectivo.setOpaque(true);
        txtEfectivo.setBackground(new Color(200, 0, 255));
        txtEfectivo.setFont(font);
        txtEfectivo.setForeground(new Color(221, 221, 221));
        txtIva.setOpaque(true);
        txtIva.setBackground(new Color(200, 0, 255));
        txtIva.setFont(font);
        txtSubtotal.setOpaque(true);
        txtSubtotal.setBackground(new Color(200, 0, 255));
        txtSubtotal.setFont(font);
        txtTotal.setOpaque(true);
        txtTotal.setBackground(new Color(200, 0, 255));
        txtTotal.setFont(font);
    }

    private void listaTablaProductos() {
        modeloDatosProductos.setRowCount(listaProducto.size());
        for (int i = 0; i < listaProducto.size(); i++) {
            modeloDatosProductos.setValueAt(i + 1, i, 0);
            modeloDatosProductos.setValueAt(listaProducto.get(i).getNombre(), i, 1);
            modeloDatosProductos.setValueAt(listaProducto.get(i).getCantidad(), i, 2);
            modeloDatosProductos.setValueAt(listaProducto.get(i).getPrecioUnitario(), i, 3);
            modeloDatosProductos.setValueAt(listaProducto.get(i).getSubtotal(), i, 4);
            modeloDatosProductos.setValueAt(listaProducto.get(i).getDescuento(), i, 5);
            modeloDatosProductos.setValueAt(listaProducto.get(i).getIva(), i, 6);
            modeloDatosProductos.setValueAt(listaProducto.get(i).getTotalPagar(), i, 7);
            modeloDatosProductos.setValueAt("Eliminar", i, 8);
        }
        tableProducto.setModel(modeloDatosProductos);
    }

    private void inicializarTablaProdcuto() {
        modeloDatosProductos = new DefaultTableModel();

        modeloDatosProductos.addColumn("N°");
        modeloDatosProductos.addColumn("Nombre");
        modeloDatosProductos.addColumn("Cantidad");
        modeloDatosProductos.addColumn("P. Unitario");
        modeloDatosProductos.addColumn("SubTotal");
        modeloDatosProductos.addColumn("Descuento");
        modeloDatosProductos.addColumn("IVA");
        modeloDatosProductos.addColumn("Total Pagar");
        modeloDatosProductos.addColumn("Accion");

        tableProducto.setModel(modeloDatosProductos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CbProducto = new javax.swing.JComboBox<>();
        CbCliente = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnAnadir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProducto = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();
        txtSubtotal = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtIva = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtEfectivo = new javax.swing.JTextField();
        btnCalcularCambio = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(850, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("FACTURACIÓN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        CbProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione producto:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(CbProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 170, -1));

        CbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(CbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 170, -1));

        txtBuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 160, 30));

        txtCantidad.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 80, 30));

        btnAnadir.setBackground(new java.awt.Color(204, 255, 255));
        btnAnadir.setForeground(new java.awt.Color(102, 102, 255));
        btnAnadir.setText("Añadir productos");
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 220, -1));

        btnBuscar.setBackground(new java.awt.Color(204, 255, 255));
        btnBuscar.setForeground(new java.awt.Color(102, 102, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 130, -1));

        tableProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        tableProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProducto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 740, 180));

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 760, 200));

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Cambio:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 80, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Subtotal:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 80, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Descuento:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 80, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("IVA:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 80, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Total a pagar:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 110, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Efectivo:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 80, -1));

        txtCambio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        txtCambio.setEnabled(false);
        jPanel3.add(txtCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 180, -1));

        txtSubtotal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        txtSubtotal.setEnabled(false);
        jPanel3.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 150, -1));

        txtDescuento.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        txtDescuento.setEnabled(false);
        jPanel3.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 150, -1));

        txtIva.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        txtIva.setEnabled(false);
        jPanel3.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 150, -1));

        txtTotal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        txtTotal.setEnabled(false);
        jPanel3.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 150, -1));

        txtEfectivo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        jPanel3.add(txtEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 180, -1));

        btnCalcularCambio.setBackground(new java.awt.Color(204, 255, 255));
        btnCalcularCambio.setForeground(new java.awt.Color(102, 102, 255));
        btnCalcularCambio.setText("Calcular cambio");
        btnCalcularCambio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCalcularCambio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCalcularCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularCambioActionPerformed(evt);
            }
        });
        jPanel3.add(btnCalcularCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 190, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 490, 200));

        btnRegistrar.setBackground(new java.awt.Color(204, 255, 255));
        btnRegistrar.setForeground(new java.awt.Color(102, 102, 255));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/print.png"))); // NOI18N
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 520, 140, 70));

        kGradientPanel1.setkEndColor(new java.awt.Color(200, 0, 255));
        kGradientPanel1.setkGradientFocus(1);
        kGradientPanel1.setkStartColor(new java.awt.Color(51, 102, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Cliente:");
        kGradientPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 80, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Producto:");
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 80, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cantidad:");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 80, -1));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        CabeceraVenta cabeVenta = new CabeceraVenta();
        DetalleVenta detalleVenta = new DetalleVenta();
        ControladorRegistroVenta regiVenta = new ControladorRegistroVenta();

        String fechaActual = "";
        Date date = new Date();
        fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);

        if (!CbCliente.getSelectedItem().equals("Seleccione cliente:")) {
            if (!listaProducto.isEmpty()) {
                obtenerIdCliente();
                cabeVenta.setIdCabeceraVenta(0);
                cabeVenta.setIdCliente(idCliente);
                cabeVenta.setValorPagar(Double.parseDouble(txtTotal.getText().trim()));
                cabeVenta.setFechaVenta(fechaActual);
                cabeVenta.setEstado(1);

                if (regiVenta.guardarCabecera(cabeVenta)) {
                    JOptionPane.showMessageDialog(null, "Venta registrada con éxito!");

                    //GENERAR FACTURA
                    VentaPDF pdf = new VentaPDF();
                    pdf.DatosCliente(idCliente);
                    pdf.generarFacturaPDF();

                    for (DetalleVenta elemento : listaProducto) {
                        detalleVenta.setIdDetalleVenta(0);
                        detalleVenta.setIdCabeceraVenta(0);
                        detalleVenta.setIdProducto(elemento.getIdProducto());
                        detalleVenta.setCantidad(elemento.getCantidad());
                        detalleVenta.setNombre(elemento.getNombre());
                        detalleVenta.setDescuento(elemento.getDescuento());
                        detalleVenta.setIva(elemento.getIva());
                        detalleVenta.setPrecioUnitario(elemento.getPrecioUnitario());
                        detalleVenta.setSubtotal(elemento.getSubtotal());
                        detalleVenta.setTotalPagar(elemento.getTotalPagar());
                        detalleVenta.setEstado(1);

                        if (regiVenta.guardarDetalle(detalleVenta)) {
                            //  System.out.println("Detalle de venta registrado!");

                            txtSubtotal.setText("0.0");
                            txtDescuento.setText("0.0");
                            txtTotal.setText("0.0");
                            txtEfectivo.setEnabled(false);
                            txtEfectivo.setText("");
                            btnCalcularCambio.setEnabled(false);
                            txtCambio.setText("");
                            auxIdDetalle = 1;
                            txtIva.setText("0.0");

                            cargarComboCliente();
                            restarStockProductos(elemento.getIdProducto(), elemento.getCantidad());

                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo registrar el detalle del producto!");

                        }

                    }
                    listaProducto.clear();
                    listaTablaProductos();

                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo registrar la cabecera de venta");

                }

            } else {
                JOptionPane.showMessageDialog(null, "Debe tener al menos 1(un) producto en la lista para poder seguir con el registro!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente para poder registrar la venta!");
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCalcularCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularCambioActionPerformed

        if (!txtEfectivo.getText().isEmpty()) {
            boolean validacion = validarDouble(txtEfectivo.getText());
            if (validacion == true) {
                double efe = Double.parseDouble(txtEfectivo.getText().trim());
                double tot = Double.parseDouble(txtTotal.getText().trim());

                if (efe > 0 && efe >= tot) {
                    double cambio = (efe - tot);
                    double cam = (double) Math.round(cambio * 100d) / 100;
                    String c = String.valueOf(cam);
                    txtCambio.setText(c);
                } else {
                    JOptionPane.showMessageDialog(null, "El dinero en efectivo no es suficiente!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un valor numérico!");

            }

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad para calcular el cambio!");
        }
    }//GEN-LAST:event_btnCalcularCambioActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String clienteBuscar = txtBuscar.getText().trim();
        Connection con = Conexion.conectar();
        Statement st;
        String sql = "select nombre, apellido from tb_cliente where cedula='" + clienteBuscar + "'";

        try {

            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                CbCliente.setSelectedItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            } else {
                CbCliente.setSelectedItem("Seleccione cliente:");
                JOptionPane.showMessageDialog(null, "Cedula de cliente inexistente/no encontrada, vuelva a revisar el dato proporcioando!");
            }
            txtBuscar.setText("");

            con.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar el cliente" + e);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
        String combo = CbProducto.getSelectedItem().toString();

        if (combo.equalsIgnoreCase("Seleccion producto:")) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        } else {
            if (!txtCantidad.getText().isEmpty()) {
                boolean validacion = validar(txtCantidad.getText());
                if (validacion == true) {
                    if (Integer.parseInt(txtCantidad.getText()) > 0) {
                        cantidad = Integer.parseInt(txtCantidad.getText());
                        datosDelProducto();
                        if (cantidad <= cantidadProductoBBDD) {
                            subtotal = precioUnitario * cantidad;
                            totalPagar = subtotal + iva + descuento;

                            subtotal = (double) Math.round(subtotal * 100) / 100;
                            iva = (double) Math.round(iva * 100) / 100;
                            descuento = (double) Math.round(descuento * 100) / 100;
                            totalPagar = (double) Math.round(totalPagar * 100) / 100;

                            producto = new DetalleVenta(auxIdDetalle, 1, idProducto, nombre, Integer.parseInt(txtCantidad.getText()), precioUnitario, subtotal, descuento, iva, totalPagar, 1);

                            listaProducto.add(producto);

                            JOptionPane.showMessageDialog(null, "Producto Agregado");
                            auxIdDetalle++;
                            txtCantidad.setText("");
                            cargarComboProducto();
                            listaTablaProductos();
                            calcularTotalPagar();

                            txtEfectivo.setEnabled(true);
                            btnCalcularCambio.setEnabled(true);

                        } else {
                            JOptionPane.showMessageDialog(null, "Cantidad mayor al stock disponible!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingrese una cantidad mayor a 0!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese caracteres numericos en cantidad!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad de productos!");
            }
        }
    }//GEN-LAST:event_btnAnadirActionPerformed

    int idArrayList = 0;
    private void tableProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductoMouseClicked
        int filaPoint = tableProducto.rowAtPoint(evt.getPoint());
        int colPoint = 0;

        if (filaPoint > -1) {
            idArrayList = (int) modeloDatosProductos.getValueAt(filaPoint, colPoint);
        }

        int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere eliminar producto?");

        switch (opcion) {
            case 0:
                listaProducto.remove(idArrayList - 1);
                calcularTotalPagar();
                listaTablaProductos();
                break;
            case 1:
                break;
            default:
                break;
        }
    }//GEN-LAST:event_tableProductoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbCliente;
    private javax.swing.JComboBox<String> CbProducto;
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCalcularCambio;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    public static javax.swing.JTable tableProducto;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtSubtotal;
    public static javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

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

    private void cargarComboProducto() {
        Connection con = Conexion.conectar();
        String sql = "select * from tb_producto";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            CbProducto.removeAllItems();
            CbProducto.addItem("Seleccione producto:");

            while (rs.next()) {
                CbProducto.addItem(rs.getString("nombre"));
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al cargar los productos" + e);
        }
    }

    public void centrarEnDesktopPane() {
        Dimension desktopSize = jDesktopPaneMenu.getSize();
        Dimension frameSize = getSize();
        setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
    }

    private boolean validar(String valor) {
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validarDouble(String valor) {
        try {
            double num = Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void datosDelProducto() {

        try {
            String sql = "select * from tb_producto where nombre = '" + CbProducto.getSelectedItem() + "'";
            Connection con = Conexion.conectar();
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                idProducto = rs.getInt("idProducto");
                nombre = rs.getString("nombre");
                cantidadProductoBBDD = rs.getInt("cantidad");
                precioUnitario = rs.getDouble("precio");
                porcentajeIva = rs.getInt("porcentajeIva");
                CalcularIva(precioUnitario, porcentajeIva);

            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del producto");
        }

    }

    private double CalcularIva(double precioUnitario, int porcentajeIva) {
        int p_iva = porcentajeIva;

        switch (p_iva) {
            case 0:
                iva = 0.0;
                break;
            case 10:
                iva = (precioUnitario * cantidad) * 0.10;
                break;
            case 21:
                iva = (precioUnitario * cantidad) * 0.21;
                break;
            default:
                break;

        }
        return iva;

    }

    private void calcularTotalPagar() {
        subtotalGral = 0;
        descuentoGral = 0;
        ivaGral = 0;
        totalPagarGral = 0;

        for (DetalleVenta elemento : listaProducto) {
            subtotalGral += elemento.getSubtotal();
            descuentoGral += elemento.getDescuento();
            ivaGral += elemento.getIva();
            totalPagarGral += elemento.getTotalPagar();
        }

        txtSubtotal.setText(String.valueOf(subtotalGral));
        txtDescuento.setText(String.valueOf(descuentoGral));
        txtIva.setText(String.valueOf(ivaGral));
        txtTotal.setText(String.valueOf(totalPagarGral));
    }

    private void obtenerIdCliente() {

        try {
            Connection con = Conexion.conectar();
            String sql = "select * from tb_cliente where concat(nombre, ' ',apellido) ='" + CbCliente.getSelectedItem() + "'";
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                idCliente = rs.getInt("idCliente");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el IDCliente" + e);
        }
    }

    private void restarStockProductos(int idProducto, int cantidad) {
        int cantidadProd = 0;
        try {
            Connection con = Conexion.conectar();
            String sql = "select idProducto, cantidad from tb_producto where idProducto='" + idProducto + "'";
            Statement st;
            st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cantidadProd = rs.getInt("cantidad");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al restar la cantidad de prodcutos del stock" + e);
        }

        try {
            Connection con = Conexion.conectar();
            PreparedStatement consulta = con.prepareStatement("update tb_producto set cantidad=? where idProducto='" + idProducto + "'");
            int cantidadNueva = cantidadProd - cantidad;
            consulta.setInt(1, cantidadNueva);

            if (consulta.executeUpdate() > 0) {
                System.out.println("todobien");

            } else {
                System.out.println("No se pudo actualizar la cantidad de stock del prodcuto");
            }

        } catch (SQLException e) {
            System.out.println("Error al restar la cantidad de prodcutos del stock 2" + e);
        }
    }

}
