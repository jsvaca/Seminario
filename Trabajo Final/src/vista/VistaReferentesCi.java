package vista;

import control.ControlReferenteCI;
import control.ControlReferentePro;
import modelo.ReferentesCI;
import modelo.ReferentesPro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VistaReferentesCi extends JFrame {
    private final ControlReferenteCI control = new ControlReferenteCI();
    private final JTable tabla;
    private final DefaultTableModel modeloTabla;

    public VistaReferentesCi (){
        setTitle("Gestion de Referentes de Complejos Industriales");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelContenedor = new JPanel();
        JPanel panelID = new JPanel();
        JPanel panelNombre = new JPanel();
        JPanel panelEmail = new JPanel();
        JPanel panelTelefono = new JPanel();
        JPanel panelCelular = new JPanel();
        JPanel panelBotones = new JPanel();
        JTextField txtID = new JTextField(5);
        JTextField txtNombre = new JTextField(25);
        JTextField txtEmail = new JTextField(25);
        JTextField txtTelefono = new JTextField(15);
        JTextField txtCelular = new JTextField(15);
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
        panelTelefono.add(new JLabel("Telefono Interno"));
        panelTelefono.add(txtTelefono);
        panelCelular.add(new JLabel("Telefono Celular"));
        panelCelular.add(txtCelular);
        panelBotones.add(btnAgregar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnListar);

        panelContenedor.add(panelID);
        panelContenedor.add(panelNombre);
        panelContenedor.add(panelEmail);
        panelContenedor.add(panelTelefono);
        panelContenedor.add(panelCelular);
        panelContenedor.add(panelBotones);

        add(panelContenedor, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(new String[]{"Nro Referente", "Nombre", "Email", "Telefono Interno", "Telefono Celular"}, 0);
        tabla = new JTable(modeloTabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        setVisible(true);

        btnListar.addActionListener(e -> {
            modeloTabla.setRowCount(0);
            List<ReferentesCI> lista = control.listar();
            for (ReferentesCI c : lista){
                modeloTabla.addRow(new Object[]{c.getCodigo(), c.getNombre(), c.getEmail(), c.getInterno(), c.getCelular()});
            }
        });

        btnAgregar.addActionListener(e -> {
            int id = Integer.parseInt(txtID.getText().trim());
            String nombre = txtNombre.getText().trim();
            String email = txtEmail.getText().trim();
            int telefono = Integer.parseInt(txtTelefono.getText().trim());
            String celular = txtCelular.getText().trim();


            if (!nombre.isEmpty() && !email.isEmpty() && !(id == 0) && !(telefono == 0) && !celular.isEmpty()){
                if (control.agregar(id, nombre, email, telefono, celular)){
                    JOptionPane.showMessageDialog(this, "Referente agregado");

                    txtID.setText("");
                    txtNombre.setText("");
                    txtEmail.setText("");
                    txtTelefono.setText("");
                    txtCelular.setText("");
                }else {
                    JOptionPane.showMessageDialog(this, "No se pudo agregar el Referente, ocurrio un error");
                }
            }
        });

        btnActualizar.addActionListener(e -> {
            int id = Integer.parseInt(txtID.getText().trim());
            String nombre = txtNombre.getText().trim();
            String email = txtEmail.getText().trim();
            int Telefono = Integer.parseInt(txtTelefono.getText().trim());
            String celular = txtCelular.getText().trim();


            if (!nombre.isEmpty() && !email.isEmpty() && !(id == 0) && !(Telefono == 0) && !celular.isEmpty()){
                if (control.modificar(id, nombre, email, Telefono, celular)){
                    JOptionPane.showMessageDialog(this, "Referente modificado");
                    txtID.setText("");
                    txtNombre.setText("");
                    txtEmail.setText("");
                    txtTelefono.setText("");
                    txtCelular.setText("");
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
