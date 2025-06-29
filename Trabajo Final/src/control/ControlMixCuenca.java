package control;

import modelo.Cuenca;
import modelo.DAO.CuencaDAO;
import modelo.DAO.MixCuencaDAO;
import modelo.MixCuenca;

import java.util.List;

public class ControlMixCuenca {
    private final MixCuencaDAO dao = new MixCuencaDAO();

    public List<MixCuenca> listar (){
        return dao.obtenerTodos();
    }

    public boolean agregar(int nroPro, int nroCue, Double por) {
        MixCuenca c = new MixCuenca(nroPro,nroCue, por);
        return dao.guardar(c);
    }

    public boolean modificar (int nroPro, int nroCue, Double por){
        MixCuenca c = new MixCuenca(nroPro,nroCue, por);
        return  dao.actualizar(c);
    }

    public boolean eliminar (int nroPro, int nroCue){
        return dao.borrar(nroPro, nroCue);
    }
}
