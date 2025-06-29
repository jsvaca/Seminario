package control;

import modelo.CI;
import modelo.DAO.CIDAO;

import java.util.List;

public class ControlCI {
    private final CIDAO dao = new CIDAO();

    public List<CI> listarCI (){
        return dao.obtenerTodos();
    }

    public boolean agregarCI(int id, String nombre, String ubicacion, int codigo) {
        CI c = new CI(id,nombre, ubicacion, codigo);
        return dao.guardar(c);
    }

    public boolean modificarCI (int id, String nombre, String ubicacion, int codigo){
        CI ci = new CI(id, nombre, ubicacion, codigo);
        return  dao.actualizar(ci);
    }

    public boolean eliminarCI (int id){
        return dao.borrar(id);
    }
}
