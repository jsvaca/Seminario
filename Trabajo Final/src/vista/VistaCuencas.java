package vista;

import control.ControlCuenca;
import control.ControlMixCuenca;
import modelo.Cuenca;
import modelo.DAO.CuencaDAO;
import modelo.DAO.ProveedorDAO;
import modelo.MixCuenca;
import modelo.Proveedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VistaCuencas extends JFrame {

    private final ControlCuenca control = new ControlCuenca();
    private final ControlMixCuenca controlMix = new ControlMixCuenca();
    private final JTable tabla;
    private final JTable tabla2;
    private final DefaultTableModel modeloTabla;
    private final DefaultTableModel modeloTabla2;
    private int valorSelPro;
    private int valorSelCue;

    public VistaCuencas (){
        setTitle("Gestion de Cuencas");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelContenedor = new JPanel();
        JPanel panelContenedor2 = new JPanel();
        JPanel panelDatosMix = new JPanel();
        JPanel panelBotonesMix = new JPanel();
        JPanel panelDatos = new JPanel();
        JPanel panelBotones = new JPanel();
        JPanel panelPrincipal = new JPanel();

        JTextField txtCodigo = new JTextField(5);
        JTextField txtDenominacion = new JTextField(15);
        JTextField txtSigla = new JTextField(5);
        JTextField txtPorcentaje = new JTextField(5);

        JButton btnAgregar = new JButton("Agregar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnListar = new JButton("Listar");

        JButton btnAgregarMix = new JButton("Agregar");
        JButton btnActualizarMix = new JButton("Actualizar");
        JButton btnEliminarMix = new JButton("Eliminar");
        JButton btnListarMix = new JButton("Listar");

        JComboBox<Proveedor> cboProveedor = new JComboBox<>();
        JComboBox<Cuenca> cboCuenca = new JComboBox<>();

        ProveedorDAO daoPRO = new ProveedorDAO();
        List<Proveedor> listaPro = daoPRO.obtenerTodos();

        for (Proveedor p : listaPro){
            cboProveedor.addItem(p);
        }

        CuencaDAO daoCuenca = new CuencaDAO();
        List<Cuenca> listaCuenca = daoCuenca.obtenerTodos();

        for (Cuenca c : listaCuenca){
            cboCuenca.addItem(c);
        }

        panelDatos.add(new JLabel("Codigo de Cuenca"));
        panelDatos.add(txtCodigo);
        panelDatos.add(new JLabel("Denominación"));
        panelDatos.add(txtDenominacion);
        panelDatos.add(new JLabel("Sigla"));
        panelDatos.add(txtSigla);

        panelDatosMix.add(new JLabel("Proveedor"));
        panelDatosMix.add(cboProveedor);
        panelDatosMix.add(new JLabel("Cuenca"));
        panelDatosMix.add(cboCuenca);
        panelDatosMix.add(new JLabel("Porcentaje"));
        panelDatosMix.add(txtPorcentaje);

        panelBotones.add(btnAgregar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnListar);

        panelBotonesMix.add(btnAgregarMix);
        panelBotonesMix.add(btnActualizarMix);
        panelBotonesMix.add(btnEliminarMix);
        panelBotonesMix.add(btnListarMix);

        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
        panelContenedor.add(panelDatos);
        panelContenedor.add(panelBotones);

        modeloTabla = new DefaultTableModel(new String[]{"Cuenca Nro", "Denominación", "Sigla"}, 0);
        tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setPreferredSize(new Dimension(600, 80));

        panelContenedor2.setLayout(new BoxLayout(panelContenedor2, BoxLayout.Y_AXIS));
        panelContenedor2.add(panelDatosMix);
        panelContenedor2.add(panelBotonesMix);

        modeloTabla2 = new DefaultTableModel(new String[]{"Proveedor", "Cuenca", "Porcentaje"}, 0);
        tabla2 = new JTable(modeloTabla2);
        JScrollPane scrollPane2 = new JScrollPane(tabla2);
        scrollPane2.setPreferredSize(new Dimension(600, 80));

        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.add(panelContenedor);
        panelPrincipal.add(new JLabel("Tabla de cuencas"));
        panelPrincipal.add(scrollPane);
        panelPrincipal.add(panelContenedor2);
        panelPrincipal.add(new JLabel("Tabla de Mix de cuencas"));
        panelPrincipal.add(scrollPane2);

        add(panelPrincipal);

        btnListar.addActionListener(e -> {
            modeloTabla.setRowCount(0);
            List<Cuenca> lista = control.listar();
            for (Cuenca c : lista){
                modeloTabla.addRow(new Object[]{c.getCodigo(), c.getDenominacion(), c.getSigla()});
            }
        });

        btnAgregar.addActionListener(e -> {
            int id = Integer.parseInt(txtCodigo.getText().trim());
            String denominacion = txtDenominacion.getText().trim();
            String sigla = txtSigla.getText().trim();

            if (!denominacion.isEmpty() && !(id == 0) && !sigla.isEmpty()){
                if (control.agregar(id, denominacion, sigla)){
                    JOptionPane.showMessageDialog(this, "Cuenca agregado");

                    txtCodigo.setText("");
                    txtDenominacion.setText("");
                    txtSigla.setText("");

                }else {
                    JOptionPane.showMessageDialog(this, "No se pudo agregar la Cuenca, ocurrio un error");
                }
            }
        });

        btnActualizar.addActionListener(e -> {
            int id = Integer.parseInt(txtCodigo.getText().trim());
            String denominacion = txtDenominacion.getText().trim();
            String sigla = txtSigla.getText().trim();

            if (!denominacion.isEmpty() && !(id == 0) && !sigla.isEmpty()){
                if (control.modificar(id, denominacion, sigla)){
                    JOptionPane.showMessageDialog(this, "Cuenca modificado");
                    txtDenominacion.setText("");
                    txtCodigo.setText("");
                    txtSigla.setText("");

                }else {
                    JOptionPane.showMessageDialog(this, "No se pudo modificar La cuenca, ocurrio un error");
                }
            }
        });

        btnEliminar.addActionListener(e -> {
            int id = Integer.parseInt(txtCodigo.getText().trim());
            if (!(id == 0)){
                if (control.eliminar(id)){
                    JOptionPane.showMessageDialog(this, "Cuenca eliminado");
                    txtCodigo.setText("");
                }else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar la cuenca, ocurrio un error");
                }
            }
        });

        btnListarMix.addActionListener(e -> {
            modeloTabla2.setRowCount(0);
            List<MixCuenca> lista = controlMix.listar();

            for (MixCuenca m : lista){
                modeloTabla2.addRow(new Object[]{m.getCodigoProveedor(), m.getCodigoCuenca(), m.getPorcentaje()});
            }
        });

        btnAgregarMix.addActionListener(e -> {
            int idPro= valorSelPro;
            int idCue = valorSelCue;
            double porcentaje = Double.parseDouble(txtPorcentaje.getText().trim());

            if (!(idCue == 0) && !(idPro == 0) && !(porcentaje == 0.0)){
                if (controlMix.agregar(idPro, idCue, porcentaje)){
                    JOptionPane.showMessageDialog(this, "Mix de Cuenca Registrado");

                    txtPorcentaje.setText("");
                    valorSelCue = 0;
                    valorSelPro = 0;
                }else {
                    JOptionPane.showMessageDialog(this, "No se pudo agregar el Mix de cuenca, ocurrio un error");
                }
            }
        });

        btnActualizarMix.addActionListener(e -> {
            int idPro = valorSelPro;
            int idCue = valorSelCue;
            double porcentaje = Double.parseDouble(txtPorcentaje.getText().trim());

            if (!(idPro == 0) && !(idCue == 0) && !(porcentaje == 0.0)){
                if (controlMix.modificar(idPro, idCue, porcentaje)){
                    JOptionPane.showMessageDialog(this, "Cuenca Actualizada");

                    txtPorcentaje.setText("");
                    valorSelPro = 0;
                    valorSelCue = 0;
                }else {
                    JOptionPane.showMessageDialog(this, "No se pudo Modificar el mix de cuenca, ocurrio un error");
                }
            }
        });

        btnEliminarMix.addActionListener(e -> {
            int idPro = valorSelPro;
            int idCue = valorSelCue;
            if (!(idPro == 0) && !(idCue == 0)){
                if (controlMix.eliminar(idPro, idCue)){
                    JOptionPane.showMessageDialog(this, "Mix de Cuenca eliminado");
                    valorSelCue = 0;
                    valorSelPro = 0;
                }else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el mix de cuenca, ocurrio un error");
                }
            }
        });

        cboProveedor.addActionListener(e -> {
            Proveedor seleccionado = (Proveedor) cboProveedor.getSelectedItem();
            if (seleccionado != null){
                valorSelPro = seleccionado.getId();
            }
        });

        cboCuenca.addActionListener(e -> {
            Cuenca seleccionado = (Cuenca) cboCuenca.getSelectedItem();
            if (seleccionado != null){
                valorSelCue = seleccionado.getCodigo();
            }
        });
    }
}
