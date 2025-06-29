package control;

import modelo.Cuenca;
import modelo.DAO.CuencaDAO;
import modelo.DAO.ReferenteCIDAO;
import modelo.ReferentesCI;

import java.util.List;

public class ControlReferenteCI {
    private final ReferenteCIDAO dao = new ReferenteCIDAO();

    public List<ReferentesCI> listar (){
        return dao.listar();
    }

    public boolean agregar(int id, String nombre, String ubicacion, int tel, String cel) {
        ReferentesCI c = new ReferentesCI(id,nombre, ubicacion, tel, cel);
       return dao.guardar(c);
    }

    public boolean modificar (int id, String nombre, String ubicacion, int tel, String cel){
        ReferentesCI c = new ReferentesCI(id, nombre, ubicacion, tel, cel);
        return  dao.actualizar(c);
    }

    public boolean eliminar (int id){
        return dao.borrar(id);
    }
}
