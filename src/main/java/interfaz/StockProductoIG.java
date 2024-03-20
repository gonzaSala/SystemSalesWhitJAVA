package interfaz;

import controlador.ControladorProducto;
import static interfaz.MenuIG.jDesktopPaneMenu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Producto;

public class StockProductoIG extends javax.swing.JInternalFrame {

    int idProducto = 0;
    int cantidad = 0;

    Font font = new Font("Montserrat", Font.BOLD, 14);
    Font font1 = new Font("Montserrat", Font.PLAIN, 12);
    Font font2 = new Font("Montserrat", Font.BOLD, 22);

    public StockProductoIG() {
        initComponents();
        this.setTitle("Actualizar Stock");
        this.setSize(new Dimension(400, 300));
        this.CargarComboProductos();

        jLabel1.setFont(font2);
        jLabel1.setForeground(new Color(221, 221, 221));
        jLabel2.setFont(font1);
        jLabel2.setForeground(new Color(221, 221, 221));
        jLabel3.setFont(font1);
        jLabel3.setForeground(new Color(221, 221, 221));
        jLabel4.setFont(font1);
        jLabel4.setForeground(new Color(221, 221, 221));

        CbProdcuto.setOpaque(true);
        CbProdcuto.setBackground(new Color(102, 102, 255));
        CbProdcuto.setFont(font);
        CbProdcuto.setForeground(new Color(221, 221, 221));

        btnCancelar.setFont(font);
        btnCancelar.setForeground(new Color(102, 102, 255));
        btnActualizar.setFont(font);
        btnActualizar.setForeground(new Color(102, 102, 255));

        txtStockActual.setOpaque(true);
        txtStockActual.setBackground(new Color(51, 102, 255));
        txtStockActual.setFont(font);
        txtStockActual.setForeground(new Color(221, 221, 221));
        txtStockNuevo.setOpaque(true);
        txtStockNuevo.setBackground(new Color(51, 102, 255));
        txtStockNuevo.setFont(font);
        txtStockNuevo.setForeground(new Color(221, 221, 221));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CbProdcuto = new javax.swing.JComboBox<>();
        txtStockNuevo = new javax.swing.JTextField();
        txtStockActual = new javax.swing.JTextField();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nuevo Stock:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 110, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Producto:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 110, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Stock Actual:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 110, -1));

        CbProdcuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un producto:", "Item 2", "Item 3", "Item 4" }));
        CbProdcuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbProdcutoActionPerformed(evt);
            }
        });
        getContentPane().add(CbProdcuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 200, 20));

        txtStockNuevo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        txtStockNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(txtStockNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 200, -1));

        txtStockActual.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtStockActual.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        txtStockActual.setEnabled(false);
        txtStockActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActualActionPerformed(evt);
            }
        });
        getContentPane().add(txtStockActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 200, -1));

        kGradientPanel1.setkGradientFocus(5);
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Actualizar Stock");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(204, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 100, 30));

        btnActualizar.setBackground(new java.awt.Color(204, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 120, 30));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtStockNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockNuevoActionPerformed

    private void txtStockActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActualActionPerformed

    private void CbProdcutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbProdcutoActionPerformed

        this.mostrarStock();        // TODO add your handling code here:
    }//GEN-LAST:event_CbProdcutoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        if (!CbProdcuto.getSelectedItem().equals("Seleccione un producto:")) {
            if (!txtStockNuevo.getText().isEmpty()) {
                boolean validacion = validacionDeCaracteres(txtStockNuevo.getText().trim());
                if (validacion == true) {
                    if (Integer.parseInt(txtStockNuevo.getText()) > 0) {
                        ControladorProducto controlProd = new ControladorProducto();
                        Producto prod = new Producto();

                        int stockActual = Integer.parseInt(txtStockActual.getText().trim());
                        int stockNuevo = Integer.parseInt(txtStockNuevo.getText().trim());
                        stockNuevo += stockActual;
                        prod.setCantidad(stockNuevo);
                        if (controlProd.actualizarStock(prod, idProducto)) {
                            JOptionPane.showMessageDialog(null, "Stock actualizado");
                            CbProdcuto.setSelectedItem("Seleccione un producto:");
                            txtStockActual.setText("");
                            txtStockNuevo.setText("");
                            this.CargarComboProductos();

                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo actualizar el stock");

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingrese un valor mayor a 0");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese solo valores numericos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una cantidad para actualizar el stock del producto!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto!");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbProdcuto;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField txtStockActual;
    private javax.swing.JTextField txtStockNuevo;
    // End of variables declaration//GEN-END:variables

    private void CargarComboProductos() {
        Connection con = conexion.Conexion.conectar();
        String sql = "select * from tb_producto";

        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            CbProdcuto.removeAllItems();
            CbProdcuto.addItem("Seleccione un producto:");
            while (rs.next()) {
                CbProdcuto.addItem(rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar el comboBox para los productos" + e);
        }
    }

    private void mostrarStock() {

        try {
            Connection con = conexion.Conexion.conectar();
            String sql = "select * from tb_producto where nombre = '" + this.CbProdcuto.getSelectedItem() + "'";

            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                idProducto = rs.getInt("idProducto");
                cantidad = rs.getInt("cantidad");
                txtStockActual.setText(String.valueOf(cantidad));
            } else {
                txtStockActual.setText("");

            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos" + e);
        }

    }

    public void centrarEnDesktopPane() {
        Dimension desktopSize = jDesktopPaneMenu.getSize();
        Dimension frameSize = getSize();
        setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
    }

    private boolean validacionDeCaracteres(String valor) {
        int num;

        try {
            num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

}
