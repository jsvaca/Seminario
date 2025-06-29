package control;

import modelo.Cuenca;
import modelo.DAO.CuencaDAO;
import modelo.DAO.DetalleTpteDAO;
import modelo.DetalleNomTpte;

import java.util.List;

public class ControlDetalleTpte {
    private final DetalleTpteDAO dao = new DetalleTpteDAO();

    public List<DetalleNomTpte> listar (){
        return dao.obtenerTodos();
    }

    public boolean agregar(int id, int nroNom, int pri, int nroCon, int volSol, int codPro) {
        DetalleNomTpte c = new DetalleNomTpte(id, nroNom, pri, nroCon, volSol, codPro);
        return dao.guardar(c);
    }

    public boolean modificar (int id, int nroNom, int pri, int nroCon, int volSol, int codPro){
        DetalleNomTpte c = new DetalleNomTpte(id, nroNom, pri, nroCon, volSol, codPro);
        return  dao.actualizar(c);
    }

    public boolean eliminar (int id){
        return dao.borrar(id);
    }
}
