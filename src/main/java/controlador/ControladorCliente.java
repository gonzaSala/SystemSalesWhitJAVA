package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Cliente;

public class ControladorCliente {

    public boolean guardar(Cliente obj) {

        boolean resp = false;
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("insert into tb_cliente values (?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, obj.getNombre());
            consulta.setString(3, obj.getApellido());
            consulta.setString(4, obj.getCedula());
            consulta.setString(5, obj.getDireccion());
            consulta.setString(6, obj.getTelefono());
            consulta.setInt(7, obj.getEstado());

            if (consulta.executeUpdate() > 0) {
                resp = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar el cliente: " + e);
        }

        return resp;
    }

    ////////////////////////////////////////////////////////////////////////////
    public boolean existeCliente(String cedula) {

        boolean resp = false;
        String sql = "select cedula from tb_cliente where cedula = '" + cedula + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                resp = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar el cliente: " + e);
        }

        return resp;
    }

    ////////////////////////////////////////////////////////////////////////////
    public boolean actualizar(Cliente obj, int idCliente) {

        boolean resp = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_cliente set nombre=?, apellido=?,cedula=?,direccion=?,telefono=?,estado=? where idCliente='" + idCliente + "'");
            consulta.setString(1, obj.getNombre());
            consulta.setString(2, obj.getApellido());
            consulta.setString(3, obj.getCedula());
            consulta.setString(4, obj.getDireccion());
            consulta.setString(5, obj.getTelefono());
            consulta.setInt(6, obj.getEstado());

            if (consulta.executeUpdate() > 0) {
                resp = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente: " + e);
        }

        return resp;
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    public boolean eliminar(int idCliente) {

        boolean resp = false;
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("delete from tb_cliente where idCliente='" + idCliente + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                resp = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el cliente: " + e);
        }

        return resp;
    }
}
