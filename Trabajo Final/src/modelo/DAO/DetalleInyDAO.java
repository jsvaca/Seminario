package modelo.DAO;

import modelo.DetalleNomIny;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetalleInyDAO {

    public boolean guardar (DetalleNomIny detalle){
        String sql = "INSERT INTO mydb.detallenominy (numeroiny, numeronom, numeroContrato, " +
                "codigoPrveedor, codigoCuenca, prioridad, volumenSolicitado, volumenAutorizado, " +
                "tipoGas, percio) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, String.valueOf(detalle.getNroIny()));
                stmt.setString(2, String.valueOf(detalle.getNroNominacion()));
                stmt.setString(3, String.valueOf(detalle.getNroContrato()));
                stmt.setString(4, String.valueOf(detalle.getNroProveedor()));
                stmt.setString(5, String.valueOf(detalle.getNroCuenca()));
                stmt.setString(6, String.valueOf(detalle.getPrioridad()));
                stmt.setString(7, String.valueOf(detalle.getVolSolicitado()));
                stmt.setString(8, String.valueOf(detalle.getVolAutorizado()));
                stmt.setString(9, detalle.getTipoGas());
                stmt.setString(10, String.valueOf(detalle.getPrecio()));

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
    public List<DetalleNomIny> obtenerTodos (){
        List<DetalleNomIny> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.detallenominy";
        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)){
                while (rs.next()){
                    lista.add(new DetalleNomIny(rs.getInt(1),rs.getInt(2),
                            rs.getInt(3),rs.getInt(4), rs.getInt(5),
                            rs.getInt(6), rs.getInt(7), rs.getInt(8),
                            rs.getString(9),rs.getDouble(10)));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
    //Metodo para eliminar un registro de la tabla complejos industriales segun id
    public boolean borrar (int id){
        String sql = "DELETE FROM mydb.detallenominy where numeronomIny = ?";

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
    public boolean actualizar (DetalleNomIny detalle){
        String sql = "UPDATE mydb.detallenominy SET numeronom = ? , numeroContrato = ?," +
                "codigoProveedor = ?, codigoCuenca = ?, prioridad = ?, volumenSolicitado = ?," +
                " volumentAutorizado = ?, tipoGas = ?, precio = ? WHERE numeronomIny = ?";

        try (Connection conn = Conexion.getConection()){
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1, detalle.getNroNominacion());
                stmt.setInt(2, detalle.getNroContrato());
                stmt.setInt(3, detalle.getNroProveedor());
                stmt.setInt(4, detalle.getNroCuenca());
                stmt.setInt(5, detalle.getPrioridad());
                stmt.setInt(6, detalle.getVolSolicitado());
                stmt.setInt(7, detalle.getVolAutorizado());
                stmt.setString(8, detalle.getTipoGas());
                stmt.setDouble(9, detalle.getPrecio());
                stmt.setInt(10, detalle.getNroIny());

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
