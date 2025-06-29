package vista;

import control.ControlReferentePro;
import modelo.ReferentesPro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VistaReferentesPro extends JFrame {
    private final ControlReferentePro control = new ControlReferentePro();
    private final JTable tabla;
    private final DefaultTableModel modeloTabla;

    public VistaReferentesPro (){
        setTitle("Gestion de Referentes de Proveedores");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelContenedor = new JPanel();
        JPanel panelID = new JPanel();
        JPanel panelNombre = new JPanel();
        JPanel panelEmail = new JPanel();
        JPanel panelTelefono = new JPanel();
        JPanel panelBotones = new JPanel();
        JTextField txtID = new JTextField(5);
        JTextField txtNombre = new JTextField(25);
        JTextField txtEmail = new JTextField(25);
        JTextField txtTelefono = new JTextField(15);
        JButton btnAgregar = new JButton("Agregar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnListar = new JButton("Listar");

        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));

        panelID.add(new JLabel("Codigo de Referente"));
        panelID.add(txtID);
        panelNombre.add(new JLabel("Nombre:"));
        panelNombre.add(txtNombre);
        panelEmail.add(new JLabel("EMAIL"));
        panelEmail.add(txtEmail);
        panelTelefono.add(new JLabel("Telefono"));
        panelTelefono.add(txtTelefono);
        panelBotones.add(btnAgregar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnListar);

        panelContenedor.add(panelID);
        panelContenedor.add(panelNombre);
        panelContenedor.add(panelEmail);
        panelContenedor.add(panelTelefono);
        panelContenedor.add(panelBotones);

        add(panelContenedor, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(new String[]{"Nro Referente", "Nombre", "Email", "Telefono"}, 0);
        tabla = new JTable(modeloTabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        setVisible(true);

        btnListar.addActionListener(e -> {
            modeloTabla.setRowCount(0);
            List<ReferentesPro> lista = control.listar();
            for (ReferentesPro c : lista){
                modeloTabla.addRow(new Object[]{c.getCodigo(), c.getNombre(), c.getEmail(), c.getTelefono()});
            }
        });

        btnAgregar.addActionListener(e -> {
            int id = Integer.parseInt(txtID.getText().trim());
            String nombre = txtNombre.getText().trim();
            String email = txtEmail.getText().trim();
            String telefono = txtTelefono.getText().trim();

            if (!nombre.isEmpty() && !email.isEmpty() && !(id == 0) && !telefono.isEmpty()){
                if (control.agregar(id, nombre, email, telefono)){
                    JOptionPane.showMessageDialog(this, "Referente agregado");

                    txtID.setText("");
                    txtNombre.setText("");
                    txtEmail.setText("");
                    txtTelefono.setText("");
                }else {
                    JOptionPane.showMessageDialog(this, "No se pudo agregar el Referente, ocurrio un error");
                }
            }
        });

        btnActualizar.addActionListener(e -> {
            int id = Integer.parseInt(txtID.getText().trim());
            String nombre = txtNombre.getText().trim();
            String email = txtEmail.getText().trim();
            String Telefono = txtTelefono.getText().trim();


            if (!nombre.isEmpty() && !email.isEmpty() && !(id == 0) && !Telefono.isEmpty()){
                if (control.modificar(id, nombre, email, Telefono)){
                    JOptionPane.showMessageDialog(this, "Referente modificado");
                    txtID.setText("");
                    txtNombre.setText("");
                    txtEmail.setText("");
                    txtTelefono.setText("");
                }else {
                    JOptionPane.showMessageDialog(this, "No se pudo modificar el Referente, ocurrio un error");
                }
            }
        });

        btnEliminar.addActionListener(e -> {
            int id = Integer.parseInt(txtID.getText().trim());
            if (!(id == 0)){
                if (control.eliminar(id)){
                    JOptionPane.showMessageDialog(this, "Referente eliminado");
                    txtID.setText("");
                }else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el referente, ocurrio un error");
                }
            }
        });
    }
}
