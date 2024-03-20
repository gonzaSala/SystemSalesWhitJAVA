package interfaz;

import controlador.Reportes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.UIDefaults;

public class MenuIG extends javax.swing.JFrame {

    public static JDesktopPane jDesktopPaneMenu;
    Font font = new Font("Montserrat", Font.BOLD, 12);

    private void initializeUI() {
        this.setSize(new Dimension(1200, 850));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Menu - SISTEMA DE VENTAS");

        jDesktopPaneMenu = new JDesktopPane();
        this.add(jDesktopPaneMenu, BorderLayout.CENTER);
    }

    public MenuIG() {
        initializeUI();

        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setLayout(null);
        jDesktopPaneMenu = new JDesktopPane();

        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.add(jDesktopPaneMenu);
        this.jDesktopPaneMenu.setBounds(0, 0, ancho, (alto - 110));
        kGradientPanel1.setBounds(0, 0, jDesktopPaneMenu.getWidth(), jDesktopPaneMenu.getHeight());
        kGradientPanel2.setBounds(0, 0, jDesktopPaneMenu.getWidth() * 80 / 100, jDesktopPaneMenu.getHeight() * 80 / 100);
        jDesktopPaneMenu.add(kGradientPanel1);
        jMenu1.setFont(font);
        jMenu2.setFont(font);
        jMenu3.setFont(font);
        jMenu4.setFont(font);
        jMenu5.setFont(font);
        jMenu6.setFont(font);
        jMenu7.setFont(font);
        jMenu_cerrarSesion.setFont(font);
        jMenuBar1.setFont(font);

        jLabel1.setFont(new Font("Arial",Font.BOLD,33));
        jLabel1.setForeground(new Color(221, 221, 221));
        jLabel2.setFont(font);
        jLabel2.setForeground(new Color(221, 221, 221));
        jLabel3.setFont(font);
        jLabel3.setForeground(new Color(221, 221, 221));

    }

    @Override
    public Image getIconImage() {
        try {
            // Cargar la imagen desde el directorio de recursos del proyecto
            InputStream inputStream = getClass().getResourceAsStream("/img/icon.png");
            if (inputStream != null) {
                return ImageIO.read(inputStream);
            } else {
                System.err.println("No se pudo cargar la imagen del ícono.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem_nuevoUsuario = new javax.swing.JMenuItem();
        jMenuItem_gestUsuario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem_nuevoProd = new javax.swing.JMenuItem();
        jMenuItem_gestProd = new javax.swing.JMenuItem();
        jMenuItem_actProd = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem_nuevoCliente = new javax.swing.JMenuItem();
        jMenuItem_gestCliente = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem_nuevaCategoria = new javax.swing.JMenuItem();
        jMenuItem_gestCategoria = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem_nuevoFact = new javax.swing.JMenuItem();
        jMenuItem_gestFact = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem_reportClientes = new javax.swing.JMenuItem();
        jMenuItem_reportCat = new javax.swing.JMenuItem();
        jMenuItem_reportProd = new javax.swing.JMenuItem();
        jMenuItem_reportVentas = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem_verHistorial = new javax.swing.JMenuItem();
        jMenu_cerrarSesion = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu - SISTEMA DE VENTAS");
        setBackground(new java.awt.Color(204, 204, 255));
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(1200, 750));
        setPreferredSize(new java.awt.Dimension(1200, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        kGradientPanel2.setkEndColor(new java.awt.Color(220, 0, 255));
        kGradientPanel2.setkGradientFocus(250);
        kGradientPanel2.setkStartColor(new java.awt.Color(55, 0, 255));
        kGradientPanel2.setPreferredSize(new java.awt.Dimension(1200, 700));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("SISTEMA DE VENTAS");
        kGradientPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));

        jLabel2.setText("IG@gonzasalaa");
        kGradientPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, -1, -1));

        jLabel3.setText("github.com/gonzasala");
        kGradientPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon.png"))); // NOI18N
        kGradientPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 9, -1, -1));

        kGradientPanel1.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 42, 1200, 700));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 700));

        jMenuBar1.setBackground(new java.awt.Color(204, 255, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jMenuBar1.setForeground(new java.awt.Color(0, 153, 255));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.setMaximumSize(new java.awt.Dimension(20000, 32768));
        jMenuBar1.setMinimumSize(new java.awt.Dimension(1250, 51));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(1250, 51));

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 255)));
        jMenu1.setForeground(new java.awt.Color(102, 102, 255));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        jMenu1.setText("Usuario");
        jMenu1.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_nuevoUsuario.setBackground(new java.awt.Color(102, 102, 255));
        jMenuItem_nuevoUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem_nuevoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_nuevoUsuario.setText("Nuevo Usuario");
        jMenuItem_nuevoUsuario.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_nuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nuevoUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_nuevoUsuario);

        jMenuItem_gestUsuario.setBackground(new java.awt.Color(102, 102, 255));
        jMenuItem_gestUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem_gestUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_gestUsuario.setText("Gestionar Usuarios");
        jMenuItem_gestUsuario.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_gestUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_gestUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_gestUsuario);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(255, 255, 255));
        jMenu2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 255)));
        jMenu2.setForeground(new java.awt.Color(102, 102, 255));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/packing.png"))); // NOI18N
        jMenu2.setText("Producto");
        jMenu2.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_nuevoProd.setBackground(new java.awt.Color(102, 102, 255));
        jMenuItem_nuevoProd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem_nuevoProd.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_nuevoProd.setText("Nuevo Producto");
        jMenuItem_nuevoProd.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_nuevoProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nuevoProdActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_nuevoProd);

        jMenuItem_gestProd.setBackground(new java.awt.Color(102, 102, 255));
        jMenuItem_gestProd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem_gestProd.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_gestProd.setText("Gestionar Productos");
        jMenuItem_gestProd.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_gestProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_gestProdActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_gestProd);

        jMenuItem_actProd.setBackground(new java.awt.Color(102, 102, 255));
        jMenuItem_actProd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem_actProd.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_actProd.setText("Actualizar Stock");
        jMenuItem_actProd.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_actProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_actProdActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_actProd);

        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(255, 255, 255));
        jMenu3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 255)));
        jMenu3.setForeground(new java.awt.Color(102, 102, 255));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-users.png"))); // NOI18N
        jMenu3.setText("Cliente");
        jMenu3.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_nuevoCliente.setBackground(new java.awt.Color(102, 102, 255));
        jMenuItem_nuevoCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem_nuevoCliente.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_nuevoCliente.setText("Nuevo Cliente");
        jMenuItem_nuevoCliente.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_nuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nuevoClienteActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem_nuevoCliente);

        jMenuItem_gestCliente.setBackground(new java.awt.Color(102, 102, 255));
        jMenuItem_gestCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem_gestCliente.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_gestCliente.setText("Gestionar Clientes");
        jMenuItem_gestCliente.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_gestCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_gestClienteActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem_gestCliente);

        jMenuBar1.add(jMenu3);

        jMenu4.setBackground(new java.awt.Color(255, 255, 255));
        jMenu4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 255)));
        jMenu4.setForeground(new java.awt.Color(102, 102, 255));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tag.png"))); // NOI18N
        jMenu4.setText("Categoria");
        jMenu4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu4.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_nuevaCategoria.setBackground(new java.awt.Color(102, 102, 255));
        jMenuItem_nuevaCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem_nuevaCategoria.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_nuevaCategoria.setText("Nueva Categoria");
        jMenuItem_nuevaCategoria.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_nuevaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nuevaCategoriaActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem_nuevaCategoria);

        jMenuItem_gestCategoria.setBackground(new java.awt.Color(102, 102, 255));
        jMenuItem_gestCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem_gestCategoria.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_gestCategoria.setText("Gestionar Categorias");
        jMenuItem_gestCategoria.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_gestCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_gestCategoriaActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem_gestCategoria);

        jMenuBar1.add(jMenu4);

        jMenu5.setBackground(new java.awt.Color(255, 255, 255));
        jMenu5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 255)));
        jMenu5.setForeground(new java.awt.Color(102, 102, 255));
        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/coin-pay.png"))); // NOI18N
        jMenu5.setText("Facturar");
        jMenu5.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_nuevoFact.setBackground(new java.awt.Color(102, 102, 255));
        jMenuItem_nuevoFact.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem_nuevoFact.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_nuevoFact.setText("Nueva Venta");
        jMenuItem_nuevoFact.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_nuevoFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nuevoFactActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem_nuevoFact);

        jMenuItem_gestFact.setBackground(new java.awt.Color(102, 102, 255));
        jMenuItem_gestFact.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem_gestFact.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_gestFact.setText("Gestionar Ventas");
        jMenuItem_gestFact.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_gestFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_gestFactActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem_gestFact);

        jMenuBar1.add(jMenu5);

        jMenu6.setBackground(new java.awt.Color(255, 255, 255));
        jMenu6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 255)));
        jMenu6.setForeground(new java.awt.Color(102, 102, 255));
        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/report.png"))); // NOI18N
        jMenu6.setText("Reportes");
        jMenu6.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_reportClientes.setBackground(new java.awt.Color(102, 102, 255));
        jMenuItem_reportClientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem_reportClientes.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_reportClientes.setText("Reportes Clientes");
        jMenuItem_reportClientes.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_reportClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_reportClientesActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem_reportClientes);

        jMenuItem_reportCat.setBackground(new java.awt.Color(102, 102, 255));
        jMenuItem_reportCat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem_reportCat.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_reportCat.setText("Reportes Categorias");
        jMenuItem_reportCat.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_reportCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_reportCatActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem_reportCat);

        jMenuItem_reportProd.setBackground(new java.awt.Color(102, 102, 255));
        jMenuItem_reportProd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem_reportProd.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_reportProd.setText("Reportes Productos");
        jMenuItem_reportProd.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_reportProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_reportProdActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem_reportProd);

        jMenuItem_reportVentas.setBackground(new java.awt.Color(102, 102, 255));
        jMenuItem_reportVentas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem_reportVentas.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_reportVentas.setText("Reportes Ventas");
        jMenuItem_reportVentas.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_reportVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_reportVentasActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem_reportVentas);

        jMenuBar1.add(jMenu6);

        jMenu7.setBackground(new java.awt.Color(255, 255, 255));
        jMenu7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 255)));
        jMenu7.setForeground(new java.awt.Color(102, 102, 255));
        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/history.png"))); // NOI18N
        jMenu7.setText("Historial");
        jMenu7.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_verHistorial.setBackground(new java.awt.Color(102, 102, 255));
        jMenuItem_verHistorial.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem_verHistorial.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_verHistorial.setText("Ver Historial");
        jMenuItem_verHistorial.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_verHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_verHistorialActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem_verHistorial);

        jMenuBar1.add(jMenu7);

        jMenu_cerrarSesion.setBackground(new java.awt.Color(255, 255, 255));
        jMenu_cerrarSesion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 255)));
        jMenu_cerrarSesion.setForeground(new java.awt.Color(102, 102, 255));
        jMenu_cerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/door.png"))); // NOI18N
        jMenu_cerrarSesion.setText("Cerrar Sesión");
        jMenu_cerrarSesion.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem17.setBackground(new java.awt.Color(102, 102, 255));
        jMenuItem17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem17.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem17.setText("Cerrar Sesión");
        jMenuItem17.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu_cerrarSesion.add(jMenuItem17);

        jMenuBar1.add(jMenu_cerrarSesion);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_nuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nuevoUsuarioActionPerformed
        UsuarioIG usuario = new UsuarioIG();

        jDesktopPaneMenu.add(usuario);
        usuario.setVisible(true);
        usuario.centrarEnDesktopPane();
        jDesktopPaneMenu.setComponentZOrder(usuario, 0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem_nuevoUsuarioActionPerformed

    private void jMenuItem_nuevaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nuevaCategoriaActionPerformed

        CategoriaIG catIG = new CategoriaIG();
        jDesktopPaneMenu.add(catIG);
        catIG.setVisible(true);
        catIG.centrarEnDesktopPane();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem_nuevaCategoriaActionPerformed


    private void jMenuItem_gestCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_gestCategoriaActionPerformed
        CategoriaGestIG catGest = new CategoriaGestIG();

        jDesktopPaneMenu.add(catGest);
        catGest.setVisible(true);
        catGest.centrarEnDesktopPane();

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem_gestCategoriaActionPerformed

    private void jMenuItem_nuevoProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nuevoProdActionPerformed
        // TODO add your handling code here:
        ProductoIG prod = new ProductoIG();

        jDesktopPaneMenu.add(prod);
        prod.setVisible(true);
        prod.centrarEnDesktopPane();
    }//GEN-LAST:event_jMenuItem_nuevoProdActionPerformed

    private void jMenuItem_gestProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_gestProdActionPerformed
        // TODO add your handling code here:
        ProductoGestIG prodGest = new ProductoGestIG();

        jDesktopPaneMenu.add(prodGest);
        prodGest.setVisible(true);
        prodGest.centrarEnDesktopPane();
    }//GEN-LAST:event_jMenuItem_gestProdActionPerformed

    private void jMenuItem_nuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nuevoClienteActionPerformed
        // TODO add your handling code here:
        ClienteIG cliente = new ClienteIG();

        jDesktopPaneMenu.add(cliente);
        cliente.setVisible(true);
        cliente.centrarEnDesktopPane();
    }//GEN-LAST:event_jMenuItem_nuevoClienteActionPerformed

    private void jMenuItem_gestClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_gestClienteActionPerformed
        // TODO add your handling code here
        ClienteGestIG clienteGest = new ClienteGestIG();

        jDesktopPaneMenu.add(clienteGest);
        clienteGest.setVisible(true);
        clienteGest.centrarEnDesktopPane();
    }//GEN-LAST:event_jMenuItem_gestClienteActionPerformed

    private void jMenuItem_actProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_actProdActionPerformed
        StockProductoIG stockProd = new StockProductoIG();

        jDesktopPaneMenu.add(stockProd);
        stockProd.setVisible(true);
        stockProd.centrarEnDesktopPane();        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem_actProdActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem_gestUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_gestUsuarioActionPerformed
        // TODO add your handling code here:
        UsuarioGestIG usuarioGest = new UsuarioGestIG();

        jDesktopPaneMenu.add(usuarioGest);
        usuarioGest.setVisible(true);
        usuarioGest.centrarEnDesktopPane();
    }//GEN-LAST:event_jMenuItem_gestUsuarioActionPerformed

    private void jMenuItem_nuevoFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nuevoFactActionPerformed
        FacturacionIG facturacion = new FacturacionIG();

        jDesktopPaneMenu.add(facturacion);
        facturacion.setVisible(true);
        facturacion.centrarEnDesktopPane();

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem_nuevoFactActionPerformed

    private void jMenuItem_gestFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_gestFactActionPerformed
        // TODO add your handling code here:
        VentasGestIG ventas = new VentasGestIG();

        jDesktopPaneMenu.add(ventas);
        ventas.setVisible(true);
        ventas.centrarEnDesktopPane();
    }//GEN-LAST:event_jMenuItem_gestFactActionPerformed

    private void jMenuItem_reportClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_reportClientesActionPerformed
        // TODO add your handling code here:
        Reportes repor = new Reportes();
        repor.reportesClientes();

    }//GEN-LAST:event_jMenuItem_reportClientesActionPerformed

    private void jMenuItem_reportCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_reportCatActionPerformed
        // TODO add your handling code here:+
        Reportes repor = new Reportes();
        repor.reportesCategoria();

    }//GEN-LAST:event_jMenuItem_reportCatActionPerformed

    private void jMenuItem_reportProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_reportProdActionPerformed
        // TODO add your handling code here:
        Reportes repor = new Reportes();
        repor.reportesProductos();
    }//GEN-LAST:event_jMenuItem_reportProdActionPerformed

    private void jMenuItem_reportVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_reportVentasActionPerformed
        // TODO add your handling code here:
        Reportes repor = new Reportes();
        repor.reportesVentas();
    }//GEN-LAST:event_jMenuItem_reportVentasActionPerformed

    private void jMenuItem_verHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_verHistorialActionPerformed

        GraficasIG graph = new GraficasIG();
        jDesktopPaneMenu.add(graph);
        graph.centrarEnDesktopPane();
        graph.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem_verHistorialActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem_actProd;
    private javax.swing.JMenuItem jMenuItem_gestCategoria;
    private javax.swing.JMenuItem jMenuItem_gestCliente;
    private javax.swing.JMenuItem jMenuItem_gestFact;
    private javax.swing.JMenuItem jMenuItem_gestProd;
    private javax.swing.JMenuItem jMenuItem_gestUsuario;
    private javax.swing.JMenuItem jMenuItem_nuevaCategoria;
    private javax.swing.JMenuItem jMenuItem_nuevoCliente;
    private javax.swing.JMenuItem jMenuItem_nuevoFact;
    private javax.swing.JMenuItem jMenuItem_nuevoProd;
    private javax.swing.JMenuItem jMenuItem_nuevoUsuario;
    private javax.swing.JMenuItem jMenuItem_reportCat;
    private javax.swing.JMenuItem jMenuItem_reportClientes;
    private javax.swing.JMenuItem jMenuItem_reportProd;
    private javax.swing.JMenuItem jMenuItem_reportVentas;
    private javax.swing.JMenuItem jMenuItem_verHistorial;
    private javax.swing.JMenu jMenu_cerrarSesion;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    // End of variables declaration//GEN-END:variables

}
