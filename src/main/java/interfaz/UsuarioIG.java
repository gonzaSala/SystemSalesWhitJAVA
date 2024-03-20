package interfaz;

import controlador.ControladorUsuario;
import static interfaz.MenuIG.jDesktopPaneMenu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JOptionPane;
import modelo.Usuario;

public class UsuarioIG extends javax.swing.JInternalFrame {

    Font font = new Font("Montserrat", Font.BOLD, 14);
    Font font1 = new Font("Montserrat", Font.PLAIN, 12);
    Font font2 = new Font("Montserrat", Font.BOLD, 22);

    public UsuarioIG() {
        initComponents();
        setTitle("Nuevo Usuario");
        setSize(new Dimension(400, 300));
        txtPassword.setVisible(true);
        txtPasswordVisible.setVisible(false);

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

        txtApellido.setOpaque(true);
        txtApellido.setBackground(new Color(255, 0, 255));
        txtApellido.setFont(font);
        txtApellido.setForeground(new Color(221, 221, 221));
        txtPassword.setOpaque(true);
        txtPassword.setBackground(new Color(255, 0, 255));
        txtPassword.setFont(font);
        txtPassword.setForeground(new Color(221, 221, 221));
        txtNombre.setOpaque(true);
        txtNombre.setBackground(new Color(255, 0, 255));
        txtNombre.setFont(font);
        txtNombre.setForeground(new Color(221, 221, 221));
        txtTelefono.setOpaque(true);
        txtTelefono.setBackground(new Color(255, 0, 255));
        txtTelefono.setFont(font);
        txtTelefono.setForeground(new Color(221, 221, 221));
        txtUsuario.setOpaque(true);
        txtUsuario.setBackground(new Color(255, 0, 255));
        txtUsuario.setFont(font);
        txtUsuario.setForeground(new Color(221, 221, 221));
        txtPasswordVisible.setOpaque(true);
        txtPasswordVisible.setBackground(new Color(255, 0, 255));
        txtPasswordVisible.setFont(font);
        txtPasswordVisible.setForeground(new Color(221, 221, 221));
        
        btnCancelar.setFont(font);
        btnCancelar.setForeground(new Color(202, 102, 255));
        btnGuardar.setFont(font);
        btnGuardar.setForeground(new Color(102, 102, 255));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        ChBverPassword = new javax.swing.JCheckBox();
        txtPasswordVisible = new javax.swing.JTextField();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        txtPassword = new javax.swing.JPasswordField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nuevo Usuario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 160, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Apellido:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Usuario:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 90, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Password:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 90, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Telefono:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 90, 20));

        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 200, -1));

        txtApellido.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 200, -1));

        txtUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 200, -1));

        txtTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 200, -1));

        ChBverPassword.setBackground(new java.awt.Color(51, 153, 255));
        ChBverPassword.setText("dfsdf");
        ChBverPassword.setOpaque(true);
        ChBverPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChBverPasswordMouseClicked(evt);
            }
        });
        ChBverPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChBverPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(ChBverPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 20, -1));

        txtPasswordVisible.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        getContentPane().add(txtPasswordVisible, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 200, -1));

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 110, 155));
        kGradientPanel1.setkGradientFocus(20);
        kGradientPanel1.setkStartColor(new java.awt.Color(155, 0, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 255, 255)));
        kGradientPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 200, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 100, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 100, -1));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNombre.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtPassword.getText().isEmpty() || txtTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes rellenar los campos");
            txtNombre.setBackground(Color.red);
            txtUsuario.setBackground(Color.red);
            txtPassword.setBackground(Color.red);
            txtTelefono.setBackground(Color.red);

        } else {
            Usuario usuario = new Usuario();
            ControladorUsuario controlUsuario = new ControladorUsuario();

            if (!controlUsuario.existeUsuario(txtUsuario.getText().trim())) {
                usuario.setNombre(txtNombre.getText().trim());
                usuario.setApellido(txtApellido.getText().trim());
                usuario.setUsuario(txtUsuario.getText().trim());
                usuario.setPassword(txtPassword.getText().trim());
                usuario.setTelefono(txtTelefono.getText().trim());
                usuario.setEstado(1);

                if (controlUsuario.guardar(usuario)) {
                    JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
                    txtNombre.setText("");
                    txtUsuario.setText("");
                    txtApellido.setText("");
                    txtPassword.setText("");
                    txtTelefono.setText("");
                    txtNombre.setBackground(Color.white);
                    txtUsuario.setBackground(Color.white);
                    txtPassword.setBackground(Color.white);
                    txtTelefono.setBackground(Color.white);

                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar el usuario!");

                }
            } else {
                JOptionPane.showMessageDialog(null, "El usuario ingresado ya existe!");
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void ChBverPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChBverPasswordMouseClicked
        if (ChBverPassword.isSelected() == true) {
            String pass = "";
            char[] passIngresado = txtPassword.getPassword();
            for (int i = 0; i < passIngresado.length; i++) {
                pass += passIngresado[i];
            }
            txtPasswordVisible.setText(pass);
            txtPassword.setVisible(false);
            txtPasswordVisible.setVisible(true);
        } else {
            String passwordIngresado = txtPasswordVisible.getText().trim();
            txtPassword.setText(passwordIngresado);
            txtPassword.setVisible(true);
            txtPasswordVisible.setVisible(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_ChBverPasswordMouseClicked

    private void ChBverPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChBverPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChBverPasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ChBverPassword;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPasswordVisible;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    public void centrarEnDesktopPane() {
        Dimension desktopSize = jDesktopPaneMenu.getSize();
        Dimension frameSize = getSize();
        setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
    }
}
