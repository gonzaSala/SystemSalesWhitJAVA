package interfaz;

import conexion.Conexion;
import static interfaz.MenuIG.jDesktopPaneMenu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GraficasShowIG extends javax.swing.JInternalFrame {

    ArrayList<Integer> listaCantidad = new ArrayList<>();
    ArrayList<String> listaFechas = new ArrayList<>();

    int cantidadResultados = 0;
    String[] vFechaVenta;
    int[] vStatucCantidad;

    Font font2 = new Font("Montserrat", Font.BOLD, 22);
    Font font = new Font("Montserrat", Font.BOLD, 14);

    public GraficasShowIG() {
        initComponents();
        setSize(new Dimension(550, 650));
        setTitle("Historial de Ventas");
        contador();
        vFechaVenta = new String[cantidadResultados];
        vStatucCantidad = new int[cantidadResultados];
        AlmacenamientoDeDatos();
        jLabel1.setFont(font2);
        jLabel1.setForeground(new Color(221, 221, 221));
        kGradientPanel1.setPreferredSize(new Dimension(550, 650));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 102, 255));
        kGradientPanel1.setkGradientFocus(60);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 153, 255));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(550, 650));
        kGradientPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Historial de las fechas seleccionadas");
        kGradientPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables

    private void AlmacenamientoDeDatos() {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select fechaVenta, count(fechaVenta) as ventas from tb_cabecera_venta"
                    + " where fechaVenta BETWEEN '" + GraficasIG.fechaInicio + "' and '" + GraficasIG.fechaFin + "' group by fechaVenta;");
            ResultSet rs = ps.executeQuery();

            int contador = 0;
            while (rs.next()) {
                vFechaVenta[contador] = rs.getString("fechaVenta");
                listaFechas.add(vFechaVenta[contador]);
                vStatucCantidad[contador] = rs.getInt("ventas");
                listaCantidad.add(vStatucCantidad[contador]);
                contador++;
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Error en: " + e);
        }
    }

    private int contador() {
        try {

            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("select fechaVenta, count(fechaVenta) as ventas from tb_cabecera_venta"
                    + " where fechaVenta BETWEEN '" + GraficasIG.fechaInicio + "' and '" + GraficasIG.fechaFin + "' group by fechaVenta;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cantidadResultados++;
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return cantidadResultados;
    }

    public int diaMayorVenta(ArrayList<Integer> listaCantidad) {
        int mayor = 0;
        for (int i = 0; i < listaCantidad.size(); i++) {
            if (listaCantidad.get(i) > mayor) {
                mayor = listaCantidad.get(i);
            }
        }

        return mayor;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int mayorVenta = diaMayorVenta(listaCantidad);
        int largoNuevoIngreso = 0;
        int parametro1 = 133;
        int parametroFecha = 118;
        int parametro3 = 100;

        Color[] colores = {Color.ORANGE, Color.RED, Color.BLUE, Color.BLACK, Color.WHITE, Color.GREEN, Color.MAGENTA, Color.CYAN};

        for (int i = 0; i < listaCantidad.size(); i++) {
            largoNuevoIngreso = listaCantidad.get(i) * 400 / mayorVenta;
            if (i < colores.length) {
                g.setColor(colores[i]);
            } else {
                // Generar un color aleatorio si se agotan los colores predefinidos
                g.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
            }
            g.setFont(font);
            g.fillRect(100, parametro3, largoNuevoIngreso, 40);
            g.drawString(listaFechas.get(i), 10, parametroFecha);
            g.drawString("Cantidad: " + listaCantidad.get(i), 10, parametro1);
            parametro1 += 50;
            parametro3 += 50;
            parametroFecha += 50;
        }

    }
    
    public void centrarEnDesktopPane() {
        Dimension desktopSize = jDesktopPaneMenu.getSize();
        Dimension frameSize = getSize();
        setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
    }
}
