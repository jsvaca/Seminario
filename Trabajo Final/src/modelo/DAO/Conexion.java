package modelo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //Clase para lograr la comunicación con la base de datos MySQL
    //Datos necesarios para la comunicación modificar segun servidor que se este usando
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "NuevaContraseña";

    public static Connection getConection (){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //verificacion que esta instalado el driver para MySql
            return DriverManager.getConnection(URL, USER, PASS);
        }catch (SQLException e) {//Manejo de distintos errores en la comunicación
            System.out.println("Error de Conexion: " + e.getMessage());
            if (e.getMessage().contains("Access denied")){
                System.out.println("Usuario o contraseña incorrectos.");
            } else if (e.getMessage().contains("Unknown database")) {
                System.out.println("La base de datos no existe.");
            } else if (e.getMessage().contains("Communications link failure")) {
                System.out.println("Mo se pudo establecer la comunicación con el servidor MySQL");
            }
            return null;
        }catch (ClassNotFoundException e){
            System.out.println("No se encuentra el dirver necesario para trabajar con MySQL");
            return null;
        }
    }
}
