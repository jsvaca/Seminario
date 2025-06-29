package vista;

import control.ControlContrato;
import modelo.CI;
import modelo.Contrato;
import modelo.DAO.CIDAO;
import modelo.DAO.ProveedorDAO;
import modelo.Proveedor;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import recursos.DateLabelFromatter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class VistaContratos extends JFrame {
    private final ControlContrato control = new ControlContrato();
    private final JTable tabla;
    private final DefaultTableModel modeloTabla;
    private int valorCIsel = 0;
    private int valorProsel = 0;
    private String valorTipoSel = "";
    private final static String[] TIPO = {"Firme", "City Gate", "Interrumpible","SPOT"};

    public VistaContratos(){
        setTitle("Gestion de Contratos de Gas natural");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextField txtNroContrato = new JTextField(5);
        JComboBox<String> cboTipoContrato = new JComboBox<>(TIPO);
        JComboBox<CI> cbocodigoCI = new JComboBox<>();
        JComboBox<Proveedor> cboProveedor = new JComboBox<>();
        JTextField txtVolMin = new JTextField(10);
        JTextField txtVolMax = new JTextField(10);
        JTextField txtPrecio = new JTextField(5);
        JButton btnAgregar = new JButton("Agregar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnListar = new JButton("Listar");

        UtilDateModel model = new UtilDateModel();
        UtilDateModel model1 = new UtilDateModel();
        Properties p = new Properties();
        p.put("Text.today", "hoy");
        p.put("Text.month", "Mes");
        p.put("Text.year", "Año");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p);
        JDatePickerImpl dateFechaDesde = new JDatePickerImpl(datePanel, new DateLabelFromatter());
        JDatePickerImpl dateFechaHasta = new JDatePickerImpl(datePanel1, new DateLabelFromatter());

        JPanel panelContenedor = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        panel1.add(new JLabel("Numero de Contrato"));
        panel1.add(txtNroContrato);
        panel1.add(new JLabel("Tipo de Contrato"));
        panel1.add(cboTipoContrato);
        panel1.add(new JLabel("Precio Fijado"));
        panel1.add(txtPrecio);

        panel2.add(new JLabel("Complejo Industrial"));
        panel2.add(cbocodigoCI);
        panel2.add(new JLabel("Proveedor"));
        panel2.add(cboProveedor);

        panel3.add(new JLabel("Volumen Maximo Contratado"));
        panel3.add(txtVolMax);
        panel3.add(new JLabel("Volumen Minimo Contratado"));
        panel3.add(txtVolMin);

        panel4.add(new JLabel("Fecha de Inicio"));
        panel4.add(dateFechaDesde);
        panel4.add(new JLabel("Fecha de Fin"));
        panel4.add(dateFechaHasta);

        panel5.add(btnAgregar);
        panel5.add(btnActualizar);
        panel5.add(btnEliminar);
        panel5.add(btnListar);

        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
        panelContenedor.add(panel1);
        panelContenedor.add(panel2);
        panelContenedor.add(panel3);
        panelContenedor.add(panel4);
        panelContenedor.add(panel5);

        CIDAO daoCI = new CIDAO();
        ProveedorDAO daoPRO = new ProveedorDAO();
        List<CI> listaCI = daoCI.obtenerTodos();
        List<Proveedor> listaPRO = daoPRO.obtenerTodos();

        for (CI c : listaCI){
            cbocodigoCI.addItem(c);
        }

        for (Proveedor proveedor : listaPRO){
            cboProveedor.addItem(proveedor);
        }

        add(panelContenedor, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(new String[]{"Nro Contrato", "Codigo CI", "Codigo Proveedor", "Tipo contrato",
                "Volumen Max", "Volumen Min", "Fecha desde", "Fecha hasta", "Precio"}, 0);
        tabla = new JTable(modeloTabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        setVisible(true);

        btnListar.addActionListener(e -> {
            modeloTabla.setRowCount(0);
            List<Contrato> lista = control.listar();
            for (Contrato c : lista){
                modeloTabla.addRow(new Object[]{c.getNumero(), c.getCodigoCI(), c.getCodigoProveedor(), c.getTipo(),
                c.getVolMax(), c.getVolMin(), c.getFechaDesde(), c.getFechaHasta(), c.getPrecio()});
            }
        });

        btnAgregar.addActionListener(e -> {
            int id = Integer.parseInt(txtNroContrato.getText().trim());
            int idCI = valorCIsel;
            int idPro = valorProsel;
            String tipo = valorTipoSel;
            int volMax = Integer.parseInt(txtVolMax.getText().trim());
            int volMin = Integer.parseInt(txtVolMin.getText().trim());
            Date fechaDesde = (Date) dateFechaDesde.getModel().getValue();
            Date fechaHasta = (Date) dateFechaHasta.getModel().getValue();
            double precio = Double.parseDouble(txtPrecio.getText().trim());

            if (!tipo.isEmpty() && !(idCI == 0) && !(id == 0) && !(volMin == 0) && !(idPro == 0) && !(volMax == 0) &&
            !(precio == 0.0) && fechaDesde != null && fechaHasta != null){
                if (control.agregar(id, idCI, idPro, tipo, volMax, volMin, fechaDesde, fechaHasta, precio)){
                    JOptionPane.showMessageDialog(this, "Contrato agregado");

                    txtNroContrato.setText("");
                    txtPrecio.setText("");
                    txtVolMax.setText("");
                    txtVolMin.setText("");
                    valorCIsel = 0;
                    valorProsel = 0;
                    valorTipoSel = "";
                }else {
                    JOptionPane.showMessageDialog(this, "No se pudo agregar el Contrato, ocurrio un error");
                }
            }
        });

        btnActualizar.addActionListener(e -> {
            int id = Integer.parseInt(txtNroContrato.getText().trim());
            int idCI = valorCIsel;
            int idPro = valorProsel;
            String tipo = valorTipoSel;
            int volMax = Integer.parseInt(txtVolMax.getText().trim());
            int volMin = Integer.parseInt(txtVolMin.getText().trim());
            Date fechaDesde = (Date) dateFechaDesde.getModel().getValue();
            Date fechaHasta = (Date) dateFechaHasta.getModel().getValue();
            double precio = Double.parseDouble(txtPrecio.getText().trim());


            if (!tipo.isEmpty() && !(idCI == 0) && !(id == 0) && !(volMin == 0) && !(idPro == 0) && !(volMax == 0) &&
                    !(precio == 0.0) && !(fechaDesde == null) && !(fechaHasta == null)){
                if (control.modificar(id, idCI, idPro, tipo, volMax, volMin, fechaDesde, fechaHasta, precio)){
                    JOptionPane.showMessageDialog(this, "Contrato modificado");
                    txtNroContrato.setText("");
                    txtPrecio.setText("");
                    txtVolMax.setText("");
                    txtVolMin.setText("");
                    valorCIsel = 0;
                    valorProsel = 0;
                    valorTipoSel = "";
                }else {
                    JOptionPane.showMessageDialog(this, "No se pudo modificar el Contrato, ocurrio un error");
                }
            }
        });

        btnEliminar.addActionListener(e -> {
            int id = Integer.parseInt(txtNroContrato.getText().trim());
            if (!(id == 0)){
                if (control.eliminar(id)){
                    JOptionPane.showMessageDialog(this, "Contrato eliminado");
                    txtNroContrato.setText("");
                }else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el Contrato, ocurrio un error");
                }
            }
        });

        cboTipoContrato.addActionListener(e -> {
            String seleccionado =  (String) cboTipoContrato.getSelectedItem();
            if (seleccionado != null){
                valorTipoSel = seleccionado;
            }
        });

        cbocodigoCI.addActionListener(e -> {
            CI seleccionado = (CI) cbocodigoCI.getSelectedItem();
            if (seleccionado != null){
                valorCIsel = seleccionado.getId();
            }
        });

        cboProveedor.addActionListener(e -> {
            Proveedor seleccionado = (Proveedor) cboProveedor.getSelectedItem();
            if (seleccionado != null){
                valorProsel = seleccionado.getId();
            }
        });
    }
}
