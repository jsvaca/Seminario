package control;

import modelo.Cuenca;
import modelo.DAO.CuencaDAO;

import java.util.List;

public class ControlCuenca {
    private final CuencaDAO dao = new CuencaDAO();

    public List<Cuenca> listar (){
        return dao.obtenerTodos();
    }

    public boolean agregar(int id, String nombre, String ubicacion) {
        Cuenca c = new Cuenca(id,nombre, ubicacion);
        return dao.guardar(c);
    }

    public boolean modificar (int id, String nombre, String ubicacion){
        Cuenca c = new Cuenca(id, nombre, ubicacion);
        return  dao.actualizar(c);
    }

    public boolean eliminar (int id){
        return dao.borrar(id);
    }
}
