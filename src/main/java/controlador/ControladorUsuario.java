package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Usuario;

public class ControladorUsuario {

    public boolean guardar(Usuario obj) {

        boolean resp = false;
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("insert into tb_usuario values (?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, obj.getNombre());
            consulta.setString(3, obj.getApellido());
            consulta.setString(4, obj.getUsuario());
            consulta.setString(5, obj.getPassword());
            consulta.setString(6, obj.getTelefono());
            consulta.setInt(7, obj.getEstado());

            if (consulta.executeUpdate() > 0) {
                resp = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar el usuario: " + e);
        }

        return resp;
    }
 ////////////////////////////////////////////////////////////////////////////
    public boolean existeUsuario(String usuario) {

        boolean resp = false;
        String sql = "select usuario from tb_usuario where usuario = '" + usuario + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                resp = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar el usuario: " + e);
        }

        return resp;
    }
//////////////////////////////////////
    public boolean loginUser(Usuario obj) {

        boolean respuesta = false;

        Connection cn = Conexion.conectar();
        String sql = "select usuario, password from tb_usuario where usuario= '" + obj.getUsuario() + "' and password= '" + obj.getPassword() + "'";
        Statement st;
        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al iniciar la sesion");
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión");
        }
        return respuesta;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    public boolean actualizar(Usuario obj, int idUsuario) {

        boolean resp = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_usuario set nombre=?, apellido=?,usuario=?,password=?,telefono=?,estado=? where idUsuario='" + idUsuario + "'");
            consulta.setString(1, obj.getNombre());
            consulta.setString(2, obj.getApellido());
            consulta.setString(3, obj.getUsuario());
            consulta.setString(4, obj.getPassword());
            consulta.setString(5, obj.getTelefono());
            consulta.setInt(6, obj.getEstado());

            if (consulta.executeUpdate() > 0) {
                resp = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el usuario: " + e);
        }

        return resp;
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    public boolean eliminar(int idUsuario) {

        boolean resp = false;
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("delete from tb_usuario where idUsuario='" + idUsuario + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                resp = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario: " + e);
        }

        return resp;
    }
}
