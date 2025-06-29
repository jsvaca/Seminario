package control;

import modelo.DAO.ProveedorDAO;
import modelo.Proveedor;

import java.util.List;

public class ControlProveedor {
    private final ProveedorDAO dao = new ProveedorDAO();

    public List<Proveedor> listar(){
        return dao.obtenerTodos();
    }

    public boolean agregarProveedor(int id, String nombre, String tipo, int codigo) {
        Proveedor p = new Proveedor(id, nombre, tipo, codigo);
        return dao.guardar(p);
    }

    public boolean modificarProveedor (int id, String nombre, String tipo, int codigo){
        Proveedor p = new Proveedor(id, nombre, tipo, codigo);
        return  dao.actualizar(p);
    }

    public boolean eliminarProveedor (int id){
        return dao.borrar(id);
    }
}
