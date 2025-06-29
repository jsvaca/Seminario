package control;

import modelo.CI;
import modelo.Contrato;
import modelo.DAO.ContratoDAO;

import java.util.Date;
import java.util.List;

public class ControlContrato {
    private final ContratoDAO dao = new ContratoDAO();

    public List<Contrato> listar (){
        return dao.obtenerTodos();
    }

    public boolean agregar(int id, int ci, int cp, String tipo, int vmax, int vmin, Date fd, Date fh, Double precio) {
        Contrato c = new Contrato(id,ci, cp,  tipo, vmax, vmin, fd, fh, precio);
        return dao.guardar(c);
    }

    public boolean modificar (int id, int ci, int cp, String tipo, int vmax, int vmin, Date fd, Date fh, Double precio){
        Contrato c = new Contrato(id, ci, cp, tipo, vmax, vmin, fd, fh, precio);
        return  dao.actualizar(c);
    }

    public boolean eliminar (int id){
        return dao.borrar(id);
    }
}
