package control;

import modelo.Cuenca;
import modelo.DAO.CuencaDAO;
import modelo.DAO.NominacionTpteDAO;
import modelo.NominacionTransporte;

import java.util.Date;
import java.util.List;

public class ControlNominacionTpte {
    private final NominacionTpteDAO dao = new NominacionTpteDAO();

    public List<NominacionTransporte> listar (){
        return dao.obtenerTodos();
    }

    public boolean agregar(int id, Date fecha, int codCI) {
        NominacionTransporte c = new NominacionTransporte(id, fecha, codCI);
        return dao.guardar(c);
    }

    public boolean modificar (int id, Date fecha, int codCI){
        NominacionTransporte c = new NominacionTransporte(id, fecha, codCI);
        return  dao.actualizar(c);
    }

    public boolean eliminar (int id){
        return dao.borrar(id);
    }
}
