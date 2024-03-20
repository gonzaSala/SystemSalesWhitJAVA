package interfaz;

import controlador.ControladorCategoria;
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
import modelo.Categoria;

public class CategoriaGestIG extends javax.swing.JInternalFrame {

    private int idCategoria;

    Font font = new Font("Montserrat", Font.BOLD, 14);
    Font font1 = new Font("Montserrat", Font.PLAIN, 12);
    Font font2 = new Font("Montserrat", Font.BOLD, 22);

    public CategoriaGestIG() {
        initComponents();
        this.setSize(new Dimension(600, 400));
        this.setTitle("Gestion de Categorias");
        this.cargarTablaCategoria();
        txtDescripcion.setBackground(new Color(100, 100, 255));
        txtDescripcion.setForeground(new Color(221, 221, 221));
        txtDescripcion.setFont(font);
        txtDescripcion.setAlignmentX(CENTER_ALIGNMENT);
        jLabel1.setFont(font2);
        jLabel1.setAlignmentX(CENTER_ALIGNMENT);
        jLabel2.setAlignmentX(CENTER_ALIGNMENT);
        jLabel1.setForeground(new Color(221, 221, 221));
        jLabel2.setForeground(new Color(221, 221, 221));
        jLabel2.setFont(font);
        btnActualizar.setForeground(new Color(102,102,255));
        btnEliminar.setForeground(new Color(202,102,255));
        btnActualizar.setFont(font);
        btnEliminar.setFont(font);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCategoria = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        kGradientPanel1 = new keeptoo.KGradientPanel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Administrar Categorias");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 310, 30));

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 250));

        tableCategoria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableCategoria);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 350, 250));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 130, 90));

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Descripción");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        txtDescripcion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescripcion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        jPanel3.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 170, 20));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 190, 80));

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 100, 255));
        kGradientPanel1.setkGradientFocus(1);
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (!txtDescripcion.getText().isEmpty()) {
            Categoria cat = new Categoria();
            ControladorCategoria controlCat = new ControladorCategoria();

            cat.setDescripcion(txtDescripcion.getText().trim());
            if (!controlCat.eliminar(idCategoria)) {
                JOptionPane.showMessageDialog(null, "Categoria eliminada");
                txtDescripcion.setText("");
                this.cargarTablaCategoria();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar la categoria");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una categoria");
        }

// TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (!txtDescripcion.getText().isEmpty()) {
            Categoria cat = new Categoria();
            ControladorCategoria controlCat = new ControladorCategoria();

            cat.setDescripcion(txtDescripcion.getText().trim());
            if (controlCat.actualizar(cat, idCategoria)) {
                JOptionPane.showMessageDialog(null, "Actualización realizada con éxito");
                txtDescripcion.setText("");
                this.cargarTablaCategoria();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar la categoria");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una categoria");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    public static javax.swing.JTable tableCategoria;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaCategoria() {
        Connection con = conexion.Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);
        String sql = "select idCategoria, descripcion, estado from tb_categoria";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            CategoriaGestIG.tableCategoria = new JTable(model);
            CategoriaGestIG.jScrollPane1.setViewportView(CategoriaGestIG.tableCategoria);

            model.addColumn("IdCategoria");
            model.addColumn("Descripción");
            model.addColumn("Estado");

            while (rs.next()) {
                Object fila[] = new Object[3];

                for (int i = 0; i < 3; i++) {
                    fila[i] = rs.getObject(i + 1);
                }

                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla categoria" + e);
        }

        tableCategoria.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tableCategoria.rowAtPoint(e.getPoint());
                int col_point = 0;

                if (fila_point > -1) {
                    idCategoria = (int) model.getValueAt(fila_point, col_point);
                    EnviarDatosCategoriaSeleccionada(idCategoria);
                }
            }

        });
    }

    private void EnviarDatosCategoriaSeleccionada(int idCategoria) {
        try {
            Connection con = conexion.Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select * from tb_categoria where idCategoria = '" + idCategoria + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtDescripcion.setText(rs.getString("descripcion"));
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
}
