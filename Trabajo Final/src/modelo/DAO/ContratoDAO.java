package modelo.DAO;

import modelo.CI;
import modelo.Contrato;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContratoDAO {
    public boolean guardar (Contrato contrato){
        String sql = "INSERT INTO mydb.contrato (numeroContrato, codigoCI, codigoProveedor, " +
                "tipoContrato, volumenMax, volumenMin, fechaDesde, fechaHasta, precio) VALUES (?,?,?,?,?,?,?,?,?)";
        java.sql.Date fechaD = new java.sql.Date(contrato.getFechaDesde().getTime());
        java.sql.Date fechaH = new java.sql.Date(contrato.getFechaHasta().getTime());

        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, String.valueOf(contrato.getNumero()));
                stmt.setString(2, String.valueOf(contrato.getCodigoCI()));
                stmt.setString(3, String.valueOf(contrato.getCodigoProveedor()));
                stmt.setString(4, contrato.getTipo());
                stmt.setString(5, String.valueOf(contrato.getVolMax()));
                stmt.setString(6, String.valueOf(contrato.getVolMin()));
                stmt.setString(7, String.valueOf(fechaD));
                stmt.setString(8, String.valueOf(fechaH));
                stmt.setString(9, String.valueOf(contrato.getPrecio()));

                stmt.executeUpdate();
                return true;
            }catch (SQLException e){
                System.out.println("No se pudo ejecutar la insercion del registro en la base de datos");
                System.out.println(Arrays.toString(e.getStackTrace()));
                return false;
            }
        } catch (SQLException e) {
            System.out.println("No se pudo establecer la Conexion a la base de datos");

            return false;
        }
    }

    //Metodo para listar todos los complejos industriales registrados
    public List<Contrato> obtenerTodos (){
        List<Contrato> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.contrato";
        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)){
                while (rs.next()){
                    lista.add(new Contrato(rs.getInt(1),rs.getInt(2),
                            rs.getInt(3),rs.getString(4), rs.getInt(5),
                            rs.getInt(6), (java.util.Date) rs.getDate(7), (java.util.Date) rs.getDate(8),
                            rs.getDouble(9)));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
    //Metodo para eliminar un registro de la tabla complejos industriales segun id
    public boolean borrar (int id){
        String sql = "DELETE FROM mydb.contrato WHERE numeroContrato = ?";

        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1, id);

                int filasAfectadas = stmt.executeUpdate();
                return filasAfectadas > 0;
            }catch (SQLException e){
                System.out.println("No se pudo ejecutar la eliminación de los registros en la base de datos");
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e){
            System.out.println("No se pudo establecer la Conexion a la base de datos");
            return false;
        }
    }
    //Metodo para actualizar un registro de la tabla complejo industrial indicado por el id
    public boolean actualizar (Contrato contrato){
        String sql = "UPDATE mydb.contrato SET codigoCI = ? , codigoProveedor = ?," +
                "tipoContrato = ?, volumenMax = ?, volumenMin = ?, fechaDesde = ?, fechaHasta = ?," +
                "precio = ? WHERE numeroContrato = ?";

        try (Connection conn = Conexion.getConection()){
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1, contrato.getCodigoCI());
                stmt.setInt(2, contrato.getCodigoProveedor());
                stmt.setString(3, contrato.getTipo());
                stmt.setInt(4, contrato.getVolMax());
                stmt.setInt(5, contrato.getVolMin());
                stmt.setDate(6, new java.sql.Date(contrato.getFechaDesde().getTime()));
                stmt.setDate(7, new java.sql.Date(contrato.getFechaHasta().getTime()));
                stmt.setDouble(8, contrato.getPrecio());
                stmt.setInt(9, contrato.getNumero());

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
