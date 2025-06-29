package vista;

import control.ControlProveedor;
import modelo.DAO.ReferenteProDAO;
import modelo.Proveedor;
import modelo.ReferentesPro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VistaProveedores extends JFrame {
    private final ControlProveedor control = new ControlProveedor();
    private final JTable tabla;
    private final DefaultTableModel modeloTabla;
    private int valorSel = 0;

    public VistaProveedores (){
        setTitle("Gestion de Complejos Industriales");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel contenedor = new JPanel();
        JPanel panelID = new JPanel();
        JPanel panelRazonSocial = new JPanel();
        JPanel panelUbiacion = new JPanel();
        JPanel panelReferente = new JPanel();
        JPanel panelBotones = new JPanel();
        JTextField txtID = new JTextField(10);
        JTextField txtRazonSocial = new JTextField(50);
        JTextField txtTipo = new JTextField(50);
        JComboBox<ReferentesPro> cboReferente = new JComboBox<>();
        JButton btnAgregar = new JButton("Agregar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnListar = new JButton("Listar");

        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));

        panelID.add(new JLabel("Codigo Proveedor"));
        panelID.add(txtID);
        panelRazonSocial.add(new JLabel("Razon Social"));
        panelRazonSocial.add(txtRazonSocial);
        panelUbiacion.add(new JLabel("Tipo Proveedor"));
        panelUbiacion.add(txtTipo);
        panelReferente.add(new JLabel("Referente"));
        panelReferente.add(cboReferente);
        panelBotones.add(btnAgregar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnListar);

        contenedor.add(panelID);
        contenedor.add(panelRazonSocial);
        contenedor.add(panelUbiacion);
        contenedor.add(panelReferente);
        contenedor.add(panelBotones);

        ReferenteProDAO dao = new ReferenteProDAO();
        List<ReferentesPro> listaRef = dao.obtenerTodos();

        for (ReferentesPro r : listaRef){
            cboReferente.addItem(r);
        }

        add(contenedor, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(new String[]{"Codigo Proveedor", "Razon Social", "Tipo Proveedor", "Codigo Referente"}, 0);
        tabla = new JTable(modeloTabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        setVisible(true);

        btnAgregar.addActionListener(e -> {
            int id = Integer.parseInt(txtID.getText().trim());
            String nombre = txtRazonSocial.getText().trim();
            String tipo = txtTipo.getText().trim();
            int codigo = valorSel;

            if (!nombre.isEmpty() && !tipo.isEmpty() && !(id == 0) && !(codigo == 0)){
                if (control.agregarProveedor(id, nombre, tipo, codigo)){
                    JOptionPane.showMessageDialog(this, "Proveedor agregado");
                    txtID.setText("");
                    txtTipo.setText("");
                    txtRazonSocial.setText("");
                    valorSel = 0;
                }else {
                    JOptionPane.showMessageDialog(this, "No se pudo agregar el Proveedor, ocurrio un error");
                }
            }
        });

        btnListar.addActionListener(e -> {
            modeloTabla.setRowCount(0);
            List<Proveedor> lista = control.listar();
            for (Proveedor c : lista){
                modeloTabla.addRow(new Object[]{c.getId(), c.getRazonSocial(), c.getTipo(), c.getReferente()});
            }
        });

        btnActualizar.addActionListener(e -> {
            int id = Integer.parseInt(txtID.getText().trim());
            String nombre = txtRazonSocial.getText().trim();
            String tipo = txtTipo.getText().trim();
            int codigo = valorSel;

            if (!nombre.isEmpty() && !tipo.isEmpty() && !(id == 0) && !(codigo == 0)){
                if (control.modificarProveedor(id, nombre, tipo, codigo)){
                    JOptionPane.showMessageDialog(this, "Proveedor modificado");
                    txtID.setText("");
                    txtTipo.setText("");
                    txtRazonSocial.setText("");
                    valorSel = 0;
                }else {
                    JOptionPane.showMessageDialog(this, "No se pudo modificar el Proveedor, ocurrio un error");
                }
            }
        });

        btnEliminar.addActionListener(e -> {
            int id = Integer.parseInt(txtID.getText().trim());
            if (!(id == 0)){
                if (control.eliminarProveedor(id)){
                    JOptionPane.showMessageDialog(this, "Proveedor eliminado");
                    txtID.setText("");
                }else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el Proveedor, ocurrio un error");
                }
            }
        });

        cboReferente.addActionListener(e -> {
            ReferentesPro seleccionado = (ReferentesPro) cboReferente.getSelectedItem();
            if (seleccionado != null){
                valorSel = seleccionado.getCodigo();
            }
        });
    }
}
