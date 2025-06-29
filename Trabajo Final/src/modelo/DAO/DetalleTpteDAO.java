package modelo.DAO;

import modelo.CI;
import modelo.DetalleNomTpte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetalleTpteDAO {
    public boolean guardar (DetalleNomTpte detlle){
        String sql = "INSERT INTO mydb.detallenomtpte (idDetalleNomTpte, numeroNom, prioridad, " +
                "numeroContrato, volumenSolicitado, codigoProveedor) VALUES (?,?,?,?,?,?)";
        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, String.valueOf(detlle.getCodigoDetalle()));
                stmt.setString(2, String.valueOf(detlle.getNroNominacion()));
                stmt.setString(3, String.valueOf(detlle.getPrioridad()));
                stmt.setString(4, String.valueOf(detlle.getNroContrato()));
                stmt.setString(5, String.valueOf(detlle.getVolSolicitado()));
                stmt.setString(6, String.valueOf(detlle.getCodigoProveedor()));

                stmt.executeUpdate();
                return true;
            }catch (SQLException e){
                System.out.println("No se pudo ejecutar la insercion del registro en la base de datos");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("No se pudo establecer la Conexion a la base de datos");
            return false;
        }
    }

    //Metodo para listar todos los complejos industriales registrados
    public List<DetalleNomTpte> obtenerTodos (){
        List<DetalleNomTpte> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.detallenomtote";
        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)){
                while (rs.next()){
                    lista.add(new DetalleNomTpte(rs.getInt(1),rs.getInt(2), rs.getInt(3),
                            rs.getInt(4), rs.getInt(5), rs.getInt(6)));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
    //Metodo para eliminar un registro de la tabla complejos industriales segun id
    public boolean borrar (int id){
        String sql = "DELETE FROM mydb.detallenomtpte where idDetalleNomTpte = ?";

        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1, id);

                int filasAfectadas = stmt.executeUpdate();
                return filasAfectadas > 0;
            }catch (SQLException e){
                System.out.println("No se pudo ejecutar la eliminación de los registros en la base de datos");
                return false;
            }
        } catch (SQLException e){
            System.out.println("No se pudo establecer la Conexion a la base de datos");
            return false;
        }
    }
    //Metodo para actualizar un registro de la tabla complejo industrial indicado por el id
    public boolean actualizar (DetalleNomTpte detalle){
        String sql = "UPDATE mydb.detallenomtpte SET numeroNom = ? , prioridad = ?," +
                "numeroContrato = ?, volumenSolicitado = ?, codigoProveedor = ? WHERE idDetalleNomTpte = ?";

        try (Connection conn = Conexion.getConection()){
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1, detalle.getNroNominacion());
                stmt.setInt(2, detalle.getPrioridad());
                stmt.setInt(3, detalle.getNroContrato());
                stmt.setInt(4, detalle.getVolSolicitado());
                stmt.setInt(5, detalle.getCodigoProveedor());
                stmt.setInt(6, detalle.getCodigoDetalle());

                int filasAfectadas = stmt.executeUpdate();
                return filasAfectadas >0;
            }catch (SQLException e){
                System.out.println("No se pudo ejecutar la eliminación de los registros en la base de datos");
                return false;
            }
        }catch (SQLException e){
            System.out.println("No se pudo establecer la Conexion a la base de datos");
            return false;
        }
    }
}
