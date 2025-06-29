package modelo.DAO;

import modelo.CI;
import modelo.MixCuenca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MixCuencaDAO {
    public boolean guardar (MixCuenca mixCuenca){
        String sql = "INSERT INTO mydb.mixcuenca (codigoProveedor, codigoCuenca, porcentaje) VALUES (?,?,?)";
        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, String.valueOf(mixCuenca.getCodigoProveedor()));
                stmt.setString(2, String.valueOf(mixCuenca.getCodigoCuenca()));
                stmt.setString(3, String.valueOf(mixCuenca.getPorcentaje()));

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
    public List<MixCuenca> obtenerTodos (){
        List<MixCuenca> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.mixcuenca";
        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)){
                while (rs.next()){
                    lista.add(new MixCuenca(rs.getInt(1),rs.getInt(2),
                            rs.getDouble(3)));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
    //Metodo para eliminar un registro de la tabla complejos industriales segun id
    public boolean borrar (int idProveedor, int idCuenca){
        String sql = "DELETE FROM mydb.mixcuenca where codigoProveedor = ? AND codigoCuenca = ?";

        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1, idProveedor);
                stmt.setInt(2, idCuenca);

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
    public boolean actualizar (MixCuenca mixCuenca){
        String sql = "UPDATE mydb.mixcuenca SET porcentaje = ? WHERE codigoProveedor = ? AND codigoCuenca = ?";

        try (Connection conn = Conexion.getConection()){
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, String.valueOf(mixCuenca.getPorcentaje()));
                stmt.setString(2, String.valueOf(mixCuenca.getCodigoProveedor()));
                stmt.setString(3, String.valueOf(mixCuenca.getCodigoCuenca()));

                int filasAfectadas = stmt.executeUpdate();
                return filasAfectadas >0;
            }catch (SQLException e){
                System.out.println("No se pudo ejecutar la modificación de los registros en la base de datos");
                return false;
            }
        }catch (SQLException e){
            System.out.println("No se pudo establecer la Conexion a la base de datos");
            return false;
        }
    }
}
