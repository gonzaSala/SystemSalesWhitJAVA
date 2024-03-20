package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.CabeceraVenta;
import modelo.DetalleVenta;
import modelo.Producto;

public class ControladorRegistroVenta {

    public static int idCabeceraRegistrada;
    java.math.BigDecimal IDColVar;

    public boolean guardarCabecera(CabeceraVenta obj) {

        boolean resp = false;
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("insert into tb_cabecera_venta values (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            consulta.setInt(1, 0);
            consulta.setInt(2, obj.getIdCliente());
            consulta.setString(3, obj.getFechaVenta());
            consulta.setDouble(4, obj.getValorPagar());
            consulta.setInt(5, obj.getEstado());

            if (consulta.executeUpdate() > 0) {
                resp = true;
            }

            ResultSet rs = consulta.getGeneratedKeys();
            while (rs.next()) {
                IDColVar = rs.getBigDecimal(1);
                idCabeceraRegistrada = IDColVar.intValue();
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar la venta: " + e);
        }

        return resp;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean guardarDetalle(DetalleVenta obj) {

        boolean resp = false;
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("insert into detalle values (?,?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);
            consulta.setInt(2, idCabeceraRegistrada);
            consulta.setInt(3, obj.getIdProducto());
            consulta.setInt(4, obj.getCantidad());
            consulta.setDouble(5, obj.getPrecioUnitario());
            consulta.setDouble(6, obj.getSubtotal());
            consulta.setDouble(7, obj.getIva());
            consulta.setDouble(8, obj.getDescuento());
            consulta.setDouble(9, obj.getTotalPagar());
            consulta.setInt(10, obj.getEstado());

            if (consulta.executeUpdate() > 0) {
                resp = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar el detalle de la venta: " + e);
        }

        return resp;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean actualizar(CabeceraVenta obj, int idCabeceraVenta) {

        boolean resp = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_cabecera_venta set idCliente=?, estado=? where idCabeceraVenta='" + idCabeceraVenta + "'");
            consulta.setInt(1, obj.getIdCliente());
            consulta.setInt(2, obj.getEstado());

            if (consulta.executeUpdate() > 0) {
                resp = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la cabecera: " + e);
        }

        return resp;
    }

}
