package modelo.DAO;

import modelo.Proveedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//En esta clase se centralizan las consultas a la base de datos para la insercion, el borrado,
//la consulta y la actualización de la tabla Proveedores
public class ProveedorDAO {

    //Metodo de insersion de un nuevo registro
    public boolean guardar (Proveedor proveedor){
        String sql = "INSERT INTO mydb.proveedor (codigoProveedor, razonSocial, tipoProveedor, " +
                "codigoReferente) VALUES (?,?,?,?)";
        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, String.valueOf(proveedor.getId()));
                stmt.setString(2, proveedor.getRazonSocial());
                stmt.setString(3, proveedor.getTipo());
                stmt.setString(4, String.valueOf(proveedor.getReferente()));

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
    //Metodo para listar todos los proveedores registrados
    public List<Proveedor> obtenerTodos (){
        List<Proveedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.proveedor";
        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)){
                while (rs.next()){
                    lista.add(new Proveedor(rs.getInt(1),rs.getString(2),
                            rs.getString(3),rs.getInt(4)));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    //Metodo para eliminar un registro de la tabla proveedor segun id
    public boolean borrar (int id){
        String sql = "DELETE FROM mydb.proveedor where codigoProveedor = ?";

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
    //Metodo para actualizar un registro de la tabla proveedor indicado por el codigo
    public boolean actualizar (Proveedor proveedor){
        String sql = "UPDATE mydb.proveedor SET razonSocial = ? , tipoProveedor = ?," +
                "codigoReferente = ? WHERE codigoProveedor = ?";

        try (Connection conn = Conexion.getConection()){
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, proveedor.getRazonSocial());
                stmt.setString(2, proveedor.getTipo());
                stmt.setInt(3, proveedor.getReferente());
                stmt.setInt(4, proveedor.getId());

                int filasAfectadas = stmt.executeUpdate();
                return filasAfectadas >0;
            }catch (SQLException e){
                System.out.println("No se pudo ejecutar la actualizacion de los registros en la base de datos");
                return false;
            }
        }catch (SQLException e){
            System.out.println("No se pudo establecer la Conexion a la base de datos");
            return false;
        }
    }
}
