package modelo.DAO;

import modelo.CI;
import modelo.NominacionTransporte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NominacionTpteDAO {

    public boolean guardar (NominacionTransporte nominacion){
        String sql = "INSERT INTO mydb.nominaciontpte (numero, fecha, codigoCI) VALUES (?,?,?)";
        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, String.valueOf(nominacion.getNumero()));
                stmt.setString(2, String.valueOf(nominacion.getFecha()));
                stmt.setString(3, String.valueOf(nominacion.getCodigoCI()));

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
    public List<NominacionTransporte> obtenerTodos (){
        List<NominacionTransporte> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.nominaciontpte";
        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)){
                while (rs.next()){
                    lista.add(new NominacionTransporte(rs.getInt(1),rs.getDate(2),
                            rs.getInt(3)));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
    //Metodo para eliminar un registro de la tabla complejos industriales segun id
    public boolean borrar (int id){
        String sql = "DELETE FROM mydb.nominaciontpte where numero = ?";

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
    public boolean actualizar (NominacionTransporte nominacion){
        String sql = "UPDATE mydb.nominaciontpte SET fecha = ? , codigoCI = ? WHERE numero = ?";

        try (Connection conn = Conexion.getConection()){
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setDate(1, (java.sql.Date) nominacion.getFecha());
                stmt.setInt(2, nominacion.getCodigoCI());
                stmt.setInt(3, nominacion.getNumero());

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
