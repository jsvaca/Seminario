import vista.VistaPrincipal;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new VistaPrincipal().setVisible(true));
    }
}