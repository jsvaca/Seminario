package vista;

import control.ControlCI;
import modelo.CI;
import modelo.DAO.ReferenteCIDAO;
import modelo.ReferentesCI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VistaCI extends JFrame {
    private final ControlCI control = new ControlCI();
    private final JTable tabla;
    private final DefaultTableModel modeloTabla;
    private int valorSel = 0;

    public VistaCI (){
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
        JTextField txtUbiacion = new JTextField(50);
        JComboBox<ReferentesCI> cboReferente = new JComboBox<>();
        JButton btnAgregar = new JButton("Agregar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnListar = new JButton("Listar");

        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));

        panelID.add(new JLabel("Codigo CI"));
        panelID.add(txtID);
        panelRazonSocial.add(new JLabel("Razon Social"));
        panelRazonSocial.add(txtRazonSocial);
        panelUbiacion.add(new JLabel("Ubicacion"));
        panelUbiacion.add(txtUbiacion);
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

        ReferenteCIDAO dao = new ReferenteCIDAO();
        List<ReferentesCI> listaRef = dao.listar();

        for (ReferentesCI r : listaRef){
            cboReferente.addItem(r);
        }

        add(contenedor, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(new String[]{"Codigo CI", "Razon Social", "Ubicacion", "Codigo Referente"}, 0);
        tabla = new JTable(modeloTabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        setVisible(true);

        btnListar.addActionListener(e -> {
            modeloTabla.setRowCount(0);
            List<CI> lista = control.listarCI();
            for (CI c : lista){
                modeloTabla.addRow(new Object[]{c.getId(), c.getRazonSocial(), c.getUbicacion(), c.getReferente()});
            }
        });

        btnAgregar.addActionListener(e -> {
            int id = Integer.parseInt(txtID.getText().trim());
            String nombre = txtRazonSocial.getText().trim();
            String ubicacion = txtUbiacion.getText().trim();
            int codigo = valorSel;

            if (!nombre.isEmpty() && !ubicacion.isEmpty() && !(id == 0) && !(codigo == 0)){
                if (control.agregarCI(id, nombre, ubicacion, codigo)){
                    JOptionPane.showMessageDialog(this, "Complejo Industrial agregado");

                    txtID.setText("");
                    txtUbiacion.setText("");
                    txtRazonSocial.setText("");
                    valorSel = 0;
                }else {
                    JOptionPane.showMessageDialog(this, "No se pudo agregar el Complejo Industrial, ocurrio un error");
                }
            }
        });

        btnActualizar.addActionListener(e -> {
            int id = Integer.parseInt(txtID.getText().trim());
            String nombre = txtRazonSocial.getText().trim();
            String ubicacion = txtUbiacion.getText().trim();
            int codigo = valorSel;


            if (!nombre.isEmpty() && !ubicacion.isEmpty() && !(id == 0) && !(codigo == 0)){
                if (control.modificarCI(id, nombre, ubicacion, codigo)){
                    JOptionPane.showMessageDialog(this, "Complejo Industrial modificado");
                    txtID.setText("");
                    txtUbiacion.setText("");
                    txtRazonSocial.setText("");
                    valorSel = 0;
                }else {
                    JOptionPane.showMessageDialog(this, "No se pudo modificar el Complejo Industrial, ocurrio un error");
                }
            }
        });

        btnEliminar.addActionListener(e -> {
            int id = Integer.parseInt(txtID.getText().trim());
            if (!(id == 0)){
                if (control.eliminarCI(id)){
                    JOptionPane.showMessageDialog(this, "Complejo Industrial eliminado");
                    txtID.setText("");
                }else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el Complejo Industrial, ocurrio un error");
                }
            }
        });

        cboReferente.addActionListener(e -> {
            ReferentesCI seleccionado = (ReferentesCI) cboReferente.getSelectedItem();
            if (seleccionado != null){
                valorSel = seleccionado.getCodigo();
            }
        });
    }
}
