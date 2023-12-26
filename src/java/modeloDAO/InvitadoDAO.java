package modeloDAO;

import config.Conexion;
import interfaces.ICRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Invitado;

public class InvitadoDAO implements ICRUD {

    Connection conexion;

    public InvitadoDAO() {
        Conexion con = new Conexion();
        conexion = con.getConexion();
        if (conexion != null) {
            System.out.println("Conexión a la base de datos establecida con éxito.");
        } else {
            System.out.println("Error al establecer la conexión a la base de datos.");
        }
    }

    @Override
    public List<Invitado> listarInvitado() {
        PreparedStatement ps;
        ResultSet rs;
        List<Invitado> listainvitado = new ArrayList<>();
        try {
            ps = conexion.prepareStatement("SELECT invitado_id, invitado_nombre, invitado_estado FROM invitado WHERE invitado_estado = 'alta'");
            rs = ps.executeQuery();
            while (rs.next()) {
                int invitado_id = rs.getInt("invitado_id");
                String invitado_nombre = rs.getString("invitado_nombre");
                String invitado_estado = rs.getString("invitado_estado");
                Invitado invitado = new Invitado(invitado_id, invitado_nombre, invitado_estado);
                listainvitado.add(invitado);
            }
            return listainvitado;
        } catch (SQLException e) {
            System.out.println("Error al listar invitados dados de alta: " + e.toString());
            return null;
        }
    }

    @Override
    public Invitado mostrarInvitado(int _id) {
        PreparedStatement ps;
        ResultSet rs;
        Invitado invitado = null;

        List<Invitado> listainvitado = new ArrayList<>();
        try {
            ps = conexion.prepareStatement("SELECT invitado_id, invitado_nombre, invitado_estado FROM invitado WHERE invitado_id=?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int invitado_id = rs.getInt("invitado_id");
                String invitado_nombre = rs.getString("invitado_nombre");
                String invitado_estado = rs.getString("invitado_estado");
                invitado = new Invitado(invitado_id, invitado_nombre, invitado_estado);
            }
            return invitado;
        } catch (SQLException e) {
            System.out.println("Error al mostrar invitado: " + e.toString());
            return null;
        }
    }

    @Override
    public boolean agregarInvitado(Invitado invitado) {
        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("INSERT INTO invitado (invitado_nombre, invitado_estado) VALUES (?,?)");
            ps.setString(1, invitado.getInvitado_nombre());
            ps.setString(2, invitado.getInvitado_estado());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar invitado: " + e.toString());
            return false;
        }
    }

    @Override
    public boolean altaInvitado(String _id) {
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement("UPDATE invitado SET invitado_estado = 'alta' WHERE invitado_nombre = ?");
            ps.setString(1, _id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al dar de alta al invitado: " + e.toString());
            return false;
        }
    }

    @Override
    public boolean bajaInvitado(String _id) {
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement("UPDATE invitado SET invitado_estado = 'baja' WHERE invitado_nombre = ?");
            ps.setString(1, _id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al dar de baja al invitado: " + e.toString());
            return false;
        }
    }

    public List<Invitado> listarInvitadoBaja() {
        PreparedStatement ps;
        ResultSet rs;
        List<Invitado> listainvitado = new ArrayList<>();
        try {
            ps = conexion.prepareStatement("SELECT invitado_id, invitado_nombre, invitado_estado FROM invitado WHERE invitado_estado = 'baja'");
            rs = ps.executeQuery();
            while (rs.next()) {
                int invitado_id = rs.getInt("invitado_id");
                String invitado_nombre = rs.getString("invitado_nombre");
                String invitado_estado = rs.getString("invitado_estado");
                Invitado invitado = new Invitado(invitado_id, invitado_nombre, invitado_estado);
                listainvitado.add(invitado);
            }
            return listainvitado;
        } catch (SQLException e) {
            System.out.println("Error al listar invitados dados de baja: " + e.toString());
            return null;
        }
    }

    public boolean existeNombre(String nombre) {
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conexion.prepareStatement("SELECT COUNT(*) FROM invitado WHERE invitado_nombre = ?");
            ps.setString(1, nombre);
            rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Número de coincidencias para " + nombre + ": " + count);
                return count > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar si el nombre existe: " + e.toString());
        }
        return false;
    }

}
