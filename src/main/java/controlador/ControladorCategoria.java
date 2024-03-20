package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Categoria;

public class ControladorCategoria {

    public boolean guardar(Categoria obj) {

        boolean resp = false;
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("insert into tb_categoria values (?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, obj.getDescripcion());
            consulta.setInt(3, obj.getEstado());

            if (consulta.executeUpdate() > 0) {
                resp = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar la categoria: " + e);
        }

        return resp;
    }

    ////////////////////////////////////////////////////////////////////////////
    public boolean existeCategoria(String categoria) {

        boolean resp = false;
        String sql = "select descripcion from tb_categoria where descripcion = '" + categoria + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                resp = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar categoria: " + e);
        }

        return resp;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    public boolean actualizar(Categoria obj, int idCategoria) {

        boolean resp = false;
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_categoria set descripcion=? where idCategoria='" + idCategoria + "'");
            consulta.setString(1, obj.getDescripcion());

            if (consulta.executeUpdate() > 0) {
                resp = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la categoria: " + e);
        }

        return resp;
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    public boolean eliminar(int idCategoria) {

        boolean resp = false;
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("delete from tb_categoria where idCategoria='" + idCategoria + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                resp = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar la categoria: " + e);
        }

        return resp;
    }

}
