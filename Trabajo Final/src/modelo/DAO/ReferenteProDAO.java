package modelo.DAO;

import modelo.ReferentesPro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReferenteProDAO {

    public boolean guardar (ReferentesPro referente){
        String sql = "INSERT INTO mydb.referenteproveedor (codigoReferente, nombre, email, " +
                "telefono) VALUES (?,?,?,?)";
        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, String.valueOf(referente.getCodigo()));
                stmt.setString(2, referente.getNombre());
                stmt.setString(3, referente.getEmail());
                stmt.setString(4, referente.getTelefono());

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
    public List<ReferentesPro> obtenerTodos (){
        List<ReferentesPro> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.referenteproveedor";
        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)){
                while (rs.next()){
                    lista.add(new ReferentesPro(rs.getInt(1),rs.getString(2),
                            rs.getString(3),rs.getString(4)));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
    //Metodo para eliminar un registro de la tabla complejos industriales segun id
    public boolean borrar (int id){
        String sql = "DELETE FROM mydb.referenteproveedor where codigoReferente = ?";

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
    public boolean actualizar (ReferentesPro referente){
        String sql = "UPDATE mydb.referenteproveedor SET nombre = ? , email = ?," +
                "telefono = ? WHERE codigoReferente = ?";

        try (Connection conn = Conexion.getConection()){
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, referente.getNombre());
                stmt.setString(2, referente.getEmail());
                stmt.setString(3, referente.getTelefono());
                stmt.setInt(4, referente.getCodigo());

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
