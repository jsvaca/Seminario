package control;

import modelo.Cuenca;
import modelo.DAO.CuencaDAO;
import modelo.DAO.DetalleInyDAO;
import modelo.DetalleNomIny;

import java.util.List;

public class ControlDetallleIny {
    private final DetalleInyDAO dao = new DetalleInyDAO();

    public List<DetalleNomIny> listar (){
        return dao.obtenerTodos();
    }

    public boolean agregar(int id, int nroNom, int nroCon, int nroPro, int nroCue, int pri,
                           int volSol, int volAut, String tipo, Double precio) {
        DetalleNomIny c = new DetalleNomIny(id, nroNom, nroCon, nroPro,nroCue, pri,volSol, volAut,tipo, precio);
        return dao.guardar(c);
    }

    public boolean modificar (int id, int nroNom, int nroCon, int nroPro, int nroCue, int pri,
                              int volSol, int volAut, String tipo, Double precio){
        DetalleNomIny c = new DetalleNomIny(id, nroNom, nroCon, nroPro,nroCue, pri,volSol, volAut,tipo, precio);
        return  dao.actualizar(c);
    }

    public boolean eliminar (int id){
        return dao.borrar(id);
    }
}
