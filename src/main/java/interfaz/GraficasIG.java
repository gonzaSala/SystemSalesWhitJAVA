package interfaz;

import static interfaz.MenuIG.jDesktopPaneMenu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;

public class GraficasIG extends javax.swing.JInternalFrame {

    public static String fechaInicio = "", fechaFin = "";

    Font font = new Font("Montserrat", Font.BOLD, 14);
    Font font1 = new Font("Montserrat", Font.PLAIN, 12);
    Font font2 = new Font("Montserrat", Font.BOLD, 22);

    public GraficasIG() {
        initComponents();
        setSize(new Dimension(450, 300));
        setTitle("Historial de Ventas");
        jLabel1.setFont(font2);
        jLabel1.setForeground(new Color(221, 221, 221));
        jLabel3.setForeground(new Color(221, 221, 221));
        jLabel4.setForeground(new Color(221, 221, 221));
        jLabel3.setFont(font1);
        jLabel4.setFont(font1);
        btnGraficar.setFont(font);
        btnGraficar.setBackground(new Color(204, 255, 255));
        btnGraficar.setForeground(new Color(102, 102, 255));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        dateFechaFin = new com.toedter.calendar.JDateChooser();
        btnGraficar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(450, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 153, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(102, 102, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seleccione fechas para gráficar");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Fecha inicio");
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 80, -1));

        dateFechaInicio.setDateFormatString("yyyy-MM-dd");
        kGradientPanel1.add(dateFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 200, 30));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha fin");
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 80, -1));

        dateFechaFin.setDateFormatString("yyyy-MM-dd");
        kGradientPanel1.add(dateFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 200, 30));

        btnGraficar.setText("Graficar ventas");
        btnGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnGraficar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 200, 40));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarActionPerformed
        // TODO add your handling code here:

        fechaInicio = ((JTextField) dateFechaInicio.getDateEditor().getUiComponent()).getText();
        fechaFin = ((JTextField) dateFechaFin.getDateEditor().getUiComponent()).getText();

        GraficasShowIG grs = new GraficasShowIG();
        jDesktopPaneMenu.add(grs);
        grs.setVisible(true);
        grs.centrarEnDesktopPane();
        
        
        this.dispose();
    }//GEN-LAST:event_btnGraficarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGraficar;
    private com.toedter.calendar.JDateChooser dateFechaFin;
    private com.toedter.calendar.JDateChooser dateFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables

    public void centrarEnDesktopPane() {
        Dimension desktopSize = jDesktopPaneMenu.getSize();
        Dimension frameSize = getSize();
        setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
    }

}
