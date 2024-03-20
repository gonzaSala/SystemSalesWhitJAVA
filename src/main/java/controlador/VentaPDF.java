package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import interfaz.FacturacionIG;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VentaPDF {

    private String nombreCliente;
    private String cedulaCliente;
    private String telefonoCliente;
    private String direccionCliente;

    private String fechaActual = "";
    private String nombreArchivoPDFVenta = "";

    public void DatosCliente(int idCliente) {

        Connection con = conexion.Conexion.conectar();
        String sql = "select  * from tb_cliente where idCliente= '" + idCliente + "'";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                nombreCliente = rs.getString("nombre") + " " + rs.getString("apellido");
                cedulaCliente = rs.getString("cedula");
                telefonoCliente = rs.getString("telefono");
                direccionCliente = rs.getString("direccion");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar los datos del cliente" + e);
        }

    }

    private String fechaUltimoArchivo = ""; 
    private int contadorArchivos = 0;

    public void generarFacturaPDF() {
        try {

             Date date = new Date();
            String fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            String fechaNueva = fechaActual.replace("/", "_");

            int contador = 0;

            String nombreArchivoPDFVenta = "Venta_" + nombreCliente + "_" + fechaNueva + ".pdf";

            String ruta = "src/main/java/pdf/";
            File archivo = new File(ruta + nombreArchivoPDFVenta);

            // Verificar si el archivo ya existe
            while (archivo.exists()) {
                nombreArchivoPDFVenta = "Venta_" + nombreCliente + "_" + fechaNueva + "_" + contador + ".pdf";
                archivo = new File(ruta + nombreArchivoPDFVenta);
                contador++;
            }

            FileOutputStream archivoSalida = new FileOutputStream(archivo);
            Document doc = new Document();

            PdfWriter.getInstance(doc, archivoSalida);
            doc.open();
            
            //ENCABEZADO
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE);
            fecha.add("Factura: 001" + "\nFecha: " + fechaActual + "\n\n");
            String ruc = "0123456789";
            String nombre = "Salas";
            String telefono = "0978654321";
            String direccion = "Sucre 15";
            String razonSocial = "Oh my god!";
            PdfPTable encabezado = new PdfPTable(4);
            encabezado.setWidthPercentage(100);
            encabezado.getDefaultCell().setBorder(0);
            float[] columnaEncabezado = new float[]{15f, 45f, 15f, 20f};
            encabezado.setWidths(columnaEncabezado);
            encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            encabezado.addCell("");
            Phrase phrase = new Phrase();
            Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            phrase.add(new Chunk("RUC: " + ruc + "\nNOMBRE: " + nombre + "\nTELEFONO: " + telefono + "\nDIRECCION: " + direccion + "\nRAZON SOCIAL: " + razonSocial, font));
            encabezado.addCell(phrase);
            encabezado.addCell("");
            encabezado.addCell(fecha);
            doc.add(encabezado);
            //ESPACIO EN BLANCO
            Paragraph espacio1 = new Paragraph();
            espacio1.add(Chunk.NEWLINE);
            espacio1.add("\n");
            espacio1.add("\n");
            espacio1.add("\n");
            espacio1.add("\n");
            espacio1.add("");
            espacio1.add("");
            espacio1.add("");
            espacio1.add("");

            espacio1.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio1);

            //CUERPO
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);
            cliente.add("Datos del cliente: " + "\n\n");

            //DATOS DEL CLIENTE
            PdfPTable tablaCliente = new PdfPTable(4);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(1);
            //Tamaño de las celdas
            float[] colCliente = new float[]{25f, 45f, 30f, 40f};
            tablaCliente.setWidths(colCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("Cedula/RUC: ", negrita));
            PdfPCell cliente2 = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell cliente3 = new PdfPCell(new Phrase("Telefono: ", negrita));
            PdfPCell cliente4 = new PdfPCell(new Phrase("Dirección: ", negrita));
            //Bordes
            cliente1.setBorder(2);
            cliente2.setBorder(2);
            cliente3.setBorder(2);
            cliente4.setBorder(2);
            //Add celda a la tabla
            tablaCliente.addCell(cliente1);
            tablaCliente.addCell(cliente2);
            tablaCliente.addCell(cliente3);
            tablaCliente.addCell(cliente4);
            tablaCliente.addCell(cedulaCliente);
            tablaCliente.addCell(nombreCliente);
            tablaCliente.addCell(telefonoCliente);
            tablaCliente.addCell(direccionCliente);
            //Agregar al doc
            doc.add(tablaCliente);

            //ESPACIO EN BLANCO
            Paragraph espacio2 = new Paragraph();
            espacio2.add(Chunk.NEWLINE);
            espacio2.add("");
            espacio2.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio2);

            //AGREGAR LOS PRODUCTOS
            PdfPTable tablaProductos = new PdfPTable(4);
            tablaProductos.setWidthPercentage(100);
            tablaProductos.getDefaultCell().setBorder(1);
            //Tamaño de las cell
            float[] colProducto = new float[]{30f, 10f, 15f, 15f};
            tablaProductos.setWidths(colProducto);
            tablaProductos.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1 = new PdfPCell(new Phrase("Descripción: ", negrita));
            PdfPCell producto2 = new PdfPCell(new Phrase("Cantidad: ", negrita));
            PdfPCell producto3 = new PdfPCell(new Phrase("Precio Unitario: ", negrita));
            PdfPCell producto4 = new PdfPCell(new Phrase("Precio Total: ", negrita));
            //Quitar Border
            producto1.setBorder(1);
            producto2.setBorder(1);
            producto3.setBorder(1);
            producto4.setBorder(1);
            //Agregar color al encabezado del producto
            producto1.setBackgroundColor(BaseColor.YELLOW);
            producto2.setBackgroundColor(BaseColor.YELLOW);
            producto3.setBackgroundColor(BaseColor.YELLOW);
            producto4.setBackgroundColor(BaseColor.YELLOW);
            //Agregar cell a la table
            tablaProductos.addCell(producto1);
            tablaProductos.addCell(producto2);
            tablaProductos.addCell(producto3);
            tablaProductos.addCell(producto4);

            for (int i = 0; i < FacturacionIG.tableProducto.getRowCount(); i++) {
                String producto = FacturacionIG.tableProducto.getValueAt(i, 1).toString();
                String cantidad = FacturacionIG.tableProducto.getValueAt(i, 2).toString();
                String precio = FacturacionIG.tableProducto.getValueAt(i, 3).toString();
                String total = FacturacionIG.tableProducto.getValueAt(i, 7).toString();

                tablaProductos.addCell(producto);
                tablaProductos.addCell(cantidad);
                tablaProductos.addCell(precio);
                tablaProductos.addCell(total);
            }
            //Agregar al doc
            doc.add(tablaProductos);

            //TOTAL PAGAR
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a pagar: " + FacturacionIG.txtTotal.getText());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);

            //FIRMA
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Cancelación y firma\n\n");
            firma.add("______________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);

            //MENSAJE
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("GRACIAS POR SU COMRPA!\n\n");
            mensaje.add("______________________");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);

            //CERRAR EL DOC Y EL FILE
            doc.close();
            archivoSalida.close();

            //ABRIR EL DOC AL SER GENERADO AUTOMATICAMENTE
            Desktop.getDesktop().open(archivo);

        } catch (DocumentException | IOException e) {
            System.out.println("Error en generar PDF: " + e);
        }
    }

}
