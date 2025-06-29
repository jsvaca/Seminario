package modelo.DAO;

import modelo.ReferentesCI;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReferenteCIDAO {

    public boolean guardar (ReferentesCI referente) {
        String sql = "INSERT INTO mydb.referenteCI (codReferente, nombre, email, " +
                "telefonoInterno, celular) VALUES (?,?,?,?,?)";
        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, String.valueOf(referente.getCodigo()));
                stmt.setString(2, referente.getNombre());
                stmt.setString(3, referente.getEmail());
                stmt.setString(4, String.valueOf(referente.getInterno()));
                stmt.setString(5, referente.getCelular());

                stmt.executeUpdate();
                return true;
            }catch (SQLException e){
                System.out.println("No se pudo ejecutar la insercion del registro en la base de datos");
                return false;
            }
        }catch (SQLException e){
            System.out.println("No se pudo establecer la Conexion a la base de datos");
            return false;
        }
    }

    public List<ReferentesCI> listar (){
        List<ReferentesCI> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.referenteCI";
        try (Connection conn = Conexion.getConection()) {
            assert conn != null;
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)){
                while (rs.next()){
                    lista.add(new ReferentesCI(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getInt(4), rs.getString(5)));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public boolean borrar (int id){
        String sql = "DELETE FROM mydb.referenteCI where codReferente = ?";

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
    //Metodo para actualizar un registro de la tabla referente industrial indicado por el id
    public boolean actualizar (ReferentesCI referente){
        String sql = "UPDATE mydb.referenteCI SET nombre = ? , email = ?," +
                "telefonoInterno = ?, celular = ? WHERE codReferente = ?";

        try (Connection conn = Conexion.getConection()){
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(5, referente.getCodigo());
                stmt.setString(1, referente.getNombre());
                stmt.setString(2, referente.getEmail());
                stmt.setInt(3, referente.getInterno());
                stmt.setString(4, referente.getCelular());

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
