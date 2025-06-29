package control;

import modelo.Cuenca;
import modelo.DAO.CuencaDAO;
import modelo.DAO.ReferenteProDAO;
import modelo.ReferentesPro;

import java.util.List;

public class ControlReferentePro {
    private final ReferenteProDAO dao = new ReferenteProDAO();

    public List<ReferentesPro> listar (){
        return dao.obtenerTodos();
    }

    public boolean agregar(int id, String nombre, String email, String tel) {
        ReferentesPro c = new ReferentesPro(id,nombre, email, tel);
        return dao.guardar(c);
    }

    public boolean modificar (int id, String nombre, String email, String tel){
        ReferentesPro c = new ReferentesPro(id, nombre, email, tel);
        return  dao.actualizar(c);
    }

    public boolean eliminar (int id){
        return dao.borrar(id);
    }
}
