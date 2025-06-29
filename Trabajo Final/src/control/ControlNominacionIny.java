package control;

import modelo.Cuenca;
import modelo.DAO.CuencaDAO;
import modelo.DAO.NominInyDAO;
import modelo.NominacionInyeccion;

import java.util.Date;
import java.util.List;

public class ControlNominacionIny {
    private final NominInyDAO dao = new NominInyDAO();

    public List<NominacionInyeccion> listar (){
        return dao.obtenerTodos();
    }

    public boolean agregar(int id, Date fecha, int codCI) {
        NominacionInyeccion c = new NominacionInyeccion(id,fecha, codCI);
        return dao.guardar(c);
    }

    public boolean modificar (int id, Date fecha, int codCI){
        NominacionInyeccion c = new NominacionInyeccion(id, fecha, codCI);
        return  dao.actualizar(c);
    }

    public boolean eliminar (int id){
        return dao.borrar(id);
    }
}
