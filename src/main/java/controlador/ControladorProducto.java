package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Producto;

public class ControladorProducto {

    public boolean guardar(Producto obj) {

        boolean resp = false;
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("insert into tb_producto values (?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, obj.getNombre());
            consulta.setInt(3, obj.getCantidad());
            consulta.setDouble(4, obj.getPrecio());
            consulta.setString(5, obj.getDesctripcion());
            consulta.setInt(6, obj.getPorcentajeIva());
            consulta.setInt(7, obj.getIdCategoria());
            consulta.setInt(8, obj.getEstado());

            if (consulta.executeUpdate() > 0) {
                resp = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar el producto: " + e);
        }

        return resp;
    }

    ////////////////////////////////////////////////////////////////////////////
    public boolean existeProducto(String producto) {

        boolean resp = false;
        String sql = "select nombre from tb_producto where nombre = '" + producto + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                resp = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar el prodcuto: " + e);
        }

        return resp;
    }

    ////////////////////////////////////////////////////////////////////////////
    public boolean actualizar(Producto obj, int idProducto) {

        boolean resp = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_producto set nombre=?, cantidad=?,precio=?,descripcion=?,porcentajeIva=?,idCategoria=?,estado=? where idProducto='" + idProducto + "'");
            consulta.setString(1, obj.getNombre());
            consulta.setInt(2, obj.getCantidad());
            consulta.setDouble(3, obj.getPrecio());
            consulta.setString(4, obj.getDesctripcion());
            consulta.setInt(5, obj.getPorcentajeIva());
            consulta.setInt(6, obj.getIdCategoria());
            consulta.setInt(7, obj.getEstado());

            if (consulta.executeUpdate() > 0) {
                resp = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e);
        }

        return resp;
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    public boolean eliminar(int idProducto) {

        boolean resp = false;
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("delete from tb_producto where idProducto='" + idProducto + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                resp = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e);
        }

        return resp;
    }
    
    //////////////////////////////////////////////////////////////////////
   public boolean actualizarStock(Producto producto,int idProducto) {

        boolean resp = false;
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_producto set cantidad=? where idProducto = '"+idProducto+"'");
            consulta.setInt(1, producto.getCantidad());

            if (consulta.executeUpdate() > 0) {
                resp = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el stock del producto: " + e);
        }

        return resp;
    }
    
}
