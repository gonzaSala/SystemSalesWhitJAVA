package interfaz;

import conexion.Conexion;
import controlador.ControladorProducto;
import static interfaz.MenuIG.jDesktopPaneMenu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Producto;

public class ProductoIG extends javax.swing.JInternalFrame {

    int obtenerIdCategoriaCombo = 0;

    Font font = new Font("Montserrat", Font.BOLD, 14);
    Font font1 = new Font("Montserrat", Font.PLAIN, 12);
    Font font2 = new Font("Montserrat", Font.BOLD, 22);

    public ProductoIG() {
        initComponents();
        this.setSize(new Dimension(400, 350));
        this.setVisible(true);
        this.setTitle("Nuevo Producto");

        this.cargarComboCategoria();

        jLabel1.setFont(font1);
        jLabel1.setForeground(new Color(221, 221, 221));
        jLabel2.setFont(font2);
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

        txtCantidad.setOpaque(true);
        txtCantidad.setBackground(new Color(51, 102, 255));
        txtCantidad.setFont(font);
        txtCantidad.setForeground(new Color(221, 221, 221));
        txtDescripcion.setOpaque(true);
        txtDescripcion.setBackground(new Color(51, 102, 255));
        txtDescripcion.setFont(font);
        txtDescripcion.setForeground(new Color(221, 221, 221));
        txtNombre.setOpaque(true);
        txtNombre.setBackground(new Color(51, 102, 255));
        txtNombre.setFont(font);
        txtNombre.setForeground(new Color(221, 221, 221));
        txtPrecio.setOpaque(true);
        txtPrecio.setBackground(new Color(51, 102, 255));
        txtPrecio.setFont(font);
        txtPrecio.setForeground(new Color(221, 221, 221));

        CbCategoria.setOpaque(true);
        CbCategoria.setBackground(new Color(102, 102, 255));
        CbCategoria.setFont(font);
        CbCategoria.setForeground(new Color(221, 221, 221));
        CbIVA.setOpaque(true);
        CbIVA.setBackground(new Color(102, 102, 255));
        CbIVA.setFont(font);
        CbIVA.setForeground(new Color(221, 221, 221));

        btnCancelar.setFont(font);
        btnCancelar.setForeground(new Color(102, 102, 255));
        btnGuardar.setFont(font);
        btnGuardar.setForeground(new Color(102, 102, 255));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        CbCategoria = new javax.swing.JComboBox<>();
        CbIVA = new javax.swing.JComboBox<>();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 90, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 90, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Precio:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 90, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Descripción:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 90, 20));

        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 200, -1));

        txtCantidad.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 200, -1));

        txtPrecio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 200, -1));

        txtDescripcion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        getContentPane().add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 200, -1));

        CbCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione categoria:" }));
        getContentPane().add(CbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 200, 20));

        CbIVA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CbIVA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione IVA:", "No grava IVA", "21%", "10.5%" }));
        getContentPane().add(CbIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 200, 20));

        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nuevo Producto");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 190, -1));

        btnCancelar.setBackground(new java.awt.Color(204, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(204, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Categoria:");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 90, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("IVA:");
        kGradientPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 90, -1));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        Producto prod = new Producto();
        ControladorProducto conProd = new ControladorProducto();

        String iva = "";
        String categoria = "";
        iva = CbIVA.getSelectedItem().toString().trim();
        categoria = CbCategoria.getSelectedItem().toString().trim();

        if (txtNombre.getText().equals("") || txtCantidad.getText().equals("") || txtPrecio.getText().equals("")) {
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
            if (!conProd.existeProducto(txtNombre.getText().trim())) {

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
                        prod.setIdCategoria(obtenerIdCategoriaCombo);

                        prod.setEstado(1);

                        if (conProd.guardar(prod)) {
                            JOptionPane.showMessageDialog(null, "Producto guardado con éxito");
                            txtNombre.setBackground(Color.green);
                            txtCantidad.setBackground(Color.green);
                            txtPrecio.setBackground(Color.green);
                            txtDescripcion.setBackground(Color.green);

                            this.cargarComboCategoria();
                            CbIVA.setSelectedItem("Seleccione IVA:");
                            this.limpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al guardar");
                        }

                    } catch (HeadlessException | NumberFormatException e) {
                        System.out.println("Error en: " + e);
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "El producto ya existe en la base de datos");
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbCategoria;
    private javax.swing.JComboBox<String> CbIVA;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        txtPrecio.setText("");
        txtNombre.setText("");
        txtCantidad.setText("");
        txtDescripcion.setText("");
    }

    private int idCategoria() {
        String sql = "select * from tb_categoria where descripcion ='" + this.CbCategoria.getSelectedItem() + "'";
        Statement st;

        try {
            Connection con = Conexion.conectar();
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                obtenerIdCategoriaCombo = rs.getInt("idCategoria");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar la categoria" + e);
        }

        return obtenerIdCategoriaCombo;
    }

    private void cargarComboCategoria() {
        Connection con = Conexion.conectar();
        String sql = "select * from tb_categoria ";
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
            System.out.println("Error al cargar las categorias " + e);
        }
    }

    public void centrarEnDesktopPane() {
        Dimension desktopSize = jDesktopPaneMenu.getSize();
        Dimension frameSize = getSize();
        setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
    }
}
