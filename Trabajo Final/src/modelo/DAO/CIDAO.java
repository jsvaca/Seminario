package modelo.DAO;

import modelo.CI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//En esta clase se centralizan las consultas a la base de datos para la insercion, el borrado,
//la consulta y la actualización de la tabla Complejos Industriales
public class CIDAO {
    //Metodo para insertar un nuevo registro a la tabla complejo industrial
    public boolean guardar (CI complejo){
        String sql = "INSERT INTO mydb.complejoindustrial (codigoci, razonSocial, ubicacion, " +
                "codReferente) VALUES (?,?,?,?)";
        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, String.valueOf(complejo.getId()));
                stmt.setString(2, complejo.getRazonSocial());
                stmt.setString(3, complejo.getUbicacion());
                stmt.setString(4, String.valueOf(complejo.getReferente()));

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
    public List<CI> obtenerTodos (){
        List<CI> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.complejoindustrial";
        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)){
                while (rs.next()){
                    lista.add(new CI(rs.getInt(1),rs.getString(2),
                            rs.getString(3),rs.getInt(4)));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
    //Metodo para eliminar un registro de la tabla complejos industriales segun id
    public boolean borrar (int id){
        String sql = "DELETE FROM mydb.complejoindustrial where codigoCI = ?";

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
    public boolean actualizar (CI complejo){
        String sql = "UPDATE mydb.complejoindustrial SET razonSocial = ? , ubicacion = ?," +
                "codReferente = ? WHERE codigoci = ?";

        try (Connection conn = Conexion.getConection()){
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, complejo.getRazonSocial());
                stmt.setString(2, complejo.getUbicacion());
                stmt.setInt(3, complejo.getReferente());
                stmt.setInt(4, complejo.getId());

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
