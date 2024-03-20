package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Reportes {

    public void reportesClientes() {
        Document doc = new Document();

        try {
            String ruta = System.getProperty("user.home");
            //PdfWriter.getInstance(doc, new FileOutputStream(ruta + "/Desktop/Reporte_Clientes.pdf"));
            String nombreArchivo = "/Desktop/Reporte_Clientes.pdf";
            File archivo = new File(ruta + nombreArchivo);
            int contador = 0;

            while (archivo.exists()) {
                nombreArchivo = "/Desktop/Reporte_Clientes_" + contador + ".pdf";
                archivo = new File(ruta + nombreArchivo);
                contador++;
            }

            PdfWriter.getInstance(doc, new FileOutputStream(archivo));

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nGonzaSakka\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Clientes \n\n");

            doc.open();

            doc.add(parrafo);

            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell(createCell("Codigo", BaseColor.YELLOW, true, PdfPCell.ALIGN_CENTER));
            tabla.addCell(createCell("Nombres", BaseColor.YELLOW, true, PdfPCell.ALIGN_CENTER));
            tabla.addCell(createCell("Cedula", BaseColor.YELLOW, true, PdfPCell.ALIGN_CENTER));
            tabla.addCell(createCell("Telefono", BaseColor.YELLOW, true, PdfPCell.ALIGN_CENTER));
            tabla.addCell(createCell("Dirección", BaseColor.YELLOW, true, PdfPCell.ALIGN_CENTER));
         

            try {
                Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement("select idCliente, concat(nombre,' ', apellido) as nombres, cedula, telefono, direccion from tb_cliente");
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    do {
                        tabla.addCell(createCell(rs.getString(1), null, false, PdfPCell.ALIGN_CENTER));
                        tabla.addCell(createCell(rs.getString(2), null, false, PdfPCell.ALIGN_CENTER));
                        tabla.addCell(createCell(rs.getString(3), null, false, PdfPCell.ALIGN_CENTER));
                        tabla.addCell(createCell(rs.getString(4), null, false, PdfPCell.ALIGN_CENTER));
                        tabla.addCell(createCell(rs.getString(5), null, false, PdfPCell.ALIGN_CENTER));
                        
                    } while (rs.next());
                    doc.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error en" + e);
            }
            doc.close();

            JOptionPane.showMessageDialog(null, "Reporte creado con éxito!");
                        Desktop.getDesktop().open(archivo);


        } catch (DocumentException e) {
            System.out.println("Error en: " + e);

        } catch (FileNotFoundException ex) {
            System.out.println("Error en: " + ex);

            // Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void reportesProductos()  {
        Document doc = new Document();

        try {
            String ruta = System.getProperty("user.home");
            //PdfWriter.getInstance(doc, new FileOutputStream(ruta + "/Desktop/Reporte_Clientes.pdf"));
            String nombreArchivo = "/Desktop/Reporte_Productos.pdf";
            File archivo = new File(ruta + nombreArchivo);
            int contador = 0;

            while (archivo.exists()) {
                nombreArchivo = "/Desktop/Reporte_Productos_" + contador + ".pdf";
                archivo = new File(ruta + nombreArchivo);
                contador++;
            }

            PdfWriter.getInstance(doc, new FileOutputStream(archivo));

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nGonzaSakka\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Productos \n\n");

            doc.open();
            doc.add(parrafo);

            float[] columnsWidths = {5, 11, 5, 5,11, 3, 6};

            PdfPTable tabla = new PdfPTable(columnsWidths);
            tabla.addCell(createCell("Codigo", BaseColor.YELLOW, true, PdfPCell.ALIGN_CENTER));
            tabla.addCell(createCell("Nombre", BaseColor.YELLOW, true, PdfPCell.ALIGN_CENTER));
            tabla.addCell(createCell("Cantidad", BaseColor.YELLOW, true, PdfPCell.ALIGN_CENTER));
            tabla.addCell(createCell("Precio", BaseColor.YELLOW, true, PdfPCell.ALIGN_CENTER));
            tabla.addCell(createCell("Descripción", BaseColor.YELLOW, true, PdfPCell.ALIGN_CENTER));
            tabla.addCell(createCell("IVA", BaseColor.YELLOW, true, PdfPCell.ALIGN_CENTER));
            tabla.addCell(createCell("Categoria", BaseColor.YELLOW, true, PdfPCell.ALIGN_CENTER));

            try {
                Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement("select p.idProducto, p.nombre, p.cantidad,p.precio,p.descripcion,p.porcentajeIva,c.descripcion as categoria,p.estado from tb_producto as p , tb_categoria as c where p.idCategoria = c.idCategoria;");
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    do {
                        tabla.addCell(createCell(rs.getString(1), null, false, PdfPCell.ALIGN_CENTER));
                        tabla.addCell(createCell(rs.getString(2), null, false, PdfPCell.ALIGN_LEFT));
                        tabla.addCell(createCell(rs.getString(3), null, false, PdfPCell.ALIGN_CENTER));
                        tabla.addCell(createCell(rs.getString(4), null, false, PdfPCell.ALIGN_CENTER));
                        tabla.addCell(createCell(rs.getString(5), null, false, PdfPCell.ALIGN_LEFT));
                        tabla.addCell(createCell(rs.getString(6), null, false, PdfPCell.ALIGN_CENTER));
                        tabla.addCell(createCell(rs.getString(7), null, false, PdfPCell.ALIGN_LEFT));
                    } while (rs.next());

                    doc.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error en" + e);
            }
            doc.close();

            JOptionPane.showMessageDialog(null, "Reporte creado con éxito!");

            Desktop.getDesktop().open(archivo);

        } catch (DocumentException e) {
            System.out.println("Error en: " + e);

        } catch (FileNotFoundException ex) {
            System.out.println("Error en: " + ex);

            // Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void reportesCategoria()  {
        Document doc = new Document();

        try {
            String ruta = System.getProperty("user.home");
            //PdfWriter.getInstance(doc, new FileOutputStream(ruta + "/Desktop/Reporte_Clientes.pdf"));
            String nombreArchivo = "/Desktop/Reporte_Categorias.pdf";
            File archivo = new File(ruta + nombreArchivo);
            int contador = 0;

            while (archivo.exists()) {
                nombreArchivo = "/Desktop/Reporte_Categorias_" + contador + ".pdf";
                archivo = new File(ruta + nombreArchivo);
                contador++;
            }

            PdfWriter.getInstance(doc, new FileOutputStream(archivo));

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nGonzaSakka\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Categorias \n\n");

            doc.open();
            doc.add(parrafo);

            float[] columnsWidths = {5, 7, 5};

            PdfPTable tabla = new PdfPTable(columnsWidths);
            tabla.addCell(createCell("Codigo", BaseColor.YELLOW, true, PdfPCell.ALIGN_CENTER));
            tabla.addCell(createCell("Descripción", BaseColor.YELLOW, true, PdfPCell.ALIGN_CENTER));
            tabla.addCell(createCell("Estado", BaseColor.YELLOW, true, PdfPCell.ALIGN_CENTER));
         

            try {
                Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement("select * from tb_categoria ");
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    do {
                        tabla.addCell(createCell(rs.getString(1), null, false, PdfPCell.ALIGN_CENTER));
                        tabla.addCell(createCell(rs.getString(2), null, false, PdfPCell.ALIGN_LEFT));
                        tabla.addCell(createCell(rs.getString(3), null, false, PdfPCell.ALIGN_CENTER));
                        
                    } while (rs.next());

                    doc.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error en" + e);
            }
            doc.close();

            JOptionPane.showMessageDialog(null, "Reporte creado con éxito!");

            Desktop.getDesktop().open(archivo);

        } catch (DocumentException e) {
            System.out.println("Error en: " + e);

        } catch (FileNotFoundException ex) {
            System.out.println("Error en: " + ex);

            // Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void reportesVentas()  {
        Document doc = new Document();

        try {
            String ruta = System.getProperty("user.home");
            //PdfWriter.getInstance(doc, new FileOutputStream(ruta + "/Desktop/Reporte_Clientes.pdf"));
            String nombreArchivo = "/Desktop/Reporte_Ventas.pdf";
            File archivo = new File(ruta + nombreArchivo);
            int contador = 0;

            while (archivo.exists()) {
                nombreArchivo = "/Desktop/Reporte_Ventas_" + contador + ".pdf";
                archivo = new File(ruta + nombreArchivo);
                contador++;
            }

            PdfWriter.getInstance(doc, new FileOutputStream(archivo));

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nGonzaSakka\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Ventas \n\n");

            doc.open();
            doc.add(parrafo);

            float[] columnsWidths = {5, 10, 5,6,3};

            PdfPTable tabla = new PdfPTable(columnsWidths);
            tabla.addCell(createCell("Codigo", BaseColor.YELLOW, true, PdfPCell.ALIGN_CENTER));
            tabla.addCell(createCell("Cliente", BaseColor.YELLOW, true, PdfPCell.ALIGN_CENTER));
            tabla.addCell(createCell("Fecha", BaseColor.YELLOW, true, PdfPCell.ALIGN_CENTER));
            tabla.addCell(createCell("Total Pagar", BaseColor.YELLOW, true, PdfPCell.ALIGN_CENTER));
            tabla.addCell(createCell("Estado", BaseColor.YELLOW, true, PdfPCell.ALIGN_CENTER));
         

            try {
                Connection con = Conexion.conectar();
PreparedStatement ps = con.prepareStatement("select cv.idCabeceraVenta, concat(c.nombre,' ',c.apellido) as cliente, cv.fechaVenta, cv.valorPagar, cv.estado from tb_cabecera_venta as cv,  tb_cliente as c where cv.idCliente = c.idCliente");
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    do {
                        tabla.addCell(createCell(rs.getString(1), null, false, PdfPCell.ALIGN_CENTER));
                        tabla.addCell(createCell(rs.getString(2), null, false, PdfPCell.ALIGN_CENTER));
                        tabla.addCell(createCell(rs.getString(3), null, false, PdfPCell.ALIGN_CENTER));
                        tabla.addCell(createCell(rs.getString(4), null, false, PdfPCell.ALIGN_CENTER));
                        tabla.addCell(createCell(rs.getString(5), null, false, PdfPCell.ALIGN_CENTER));
                        
                    } while (rs.next());

                    doc.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error en" + e);
            }
            doc.close();

            JOptionPane.showMessageDialog(null, "Reporte creado con éxito!");

            Desktop.getDesktop().open(archivo);

        } catch (DocumentException e) {
            System.out.println("Error en: " + e);

        } catch (FileNotFoundException ex) {
            System.out.println("Error en: " + ex);

            // Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    private PdfPCell createCell(String content, BaseColor bgColor, boolean isHeader, int alignment) {
        Font font = FontFactory.getFont("Tahoma", 12, isHeader ? Font.BOLD : Font.NORMAL, BaseColor.BLACK);
        PdfPCell cell = new PdfPCell(new Paragraph(content, font));
        if (bgColor != null) {
            cell.setBackgroundColor(bgColor);
        }
        cell.setHorizontalAlignment(alignment);
        return cell;
    }
}
