package vista;

import javax.swing.*;
import java.awt.*;

public class VistaPrincipal extends JFrame {
    public VistaPrincipal(){
        setTitle("Sistema de Gestión de Nominaciones");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        FondoPanel fondo = new FondoPanel("/recursos/logo.jpg");
        fondo.setLayout(new BorderLayout());
        setContentPane(fondo);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuCI = new JMenu("Complejos Industriales");
        JMenu menuProveedores = new JMenu("Proveedores");
        JMenu menuContratos = new JMenu("Contratos");
        JMenu menuNominaciones = new JMenu("Nominaciones");

        JMenuItem itemCuencas = new JMenuItem("Cuencas");
        JMenuItem itemContratos = new JMenuItem("Contratos");
        JMenuItem itemCI = new JMenuItem("Complejos Industriales");
        JMenuItem itemRefCI = new JMenuItem("Referentes");
        JMenuItem itemProveedores = new JMenuItem("Proveedores");
        JMenuItem itemRefPro = new JMenuItem("Referentes");
        JMenuItem itemNominacionTpte = new JMenuItem("Nominación Transporte");
        JMenuItem itemNominacionIny = new JMenuItem("Nominación Inyección");

        itemCI.addActionListener(e -> new VistaCI().setVisible(true));
        itemProveedores.addActionListener(e -> new VistaProveedores().setVisible(true));
        itemContratos.addActionListener(e -> new VistaContratos().setVisible(true));
        itemNominacionIny.addActionListener(e -> new VistaNominacionIny().setVisible(true));
        itemNominacionTpte.addActionListener(e -> new VistaNominacionTpte().setVisible(true));
        itemCuencas.addActionListener(e -> new VistaCuencas().setVisible(true));
        itemRefCI.addActionListener(e -> new VistaReferentesCi().setVisible(true));
        itemRefPro.addActionListener(e -> new VistaReferentesPro().setVisible(true));

        menuCI.add(itemCI);
        menuCI.add(itemRefCI);
        menuProveedores.add(itemProveedores);
        menuProveedores.add(itemRefPro);
        menuContratos.add(itemContratos);
        menuContratos.add(itemCuencas);
        menuNominaciones.add(itemNominacionIny);
        menuNominaciones.add(itemNominacionTpte);

        menuBar.add(menuCI);
        menuBar.add(menuProveedores);
        menuBar.add(menuContratos);
        menuBar.add(menuNominaciones);

        setJMenuBar(menuBar);
    }
}
