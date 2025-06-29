package vista;

import javax.swing.*;
import java.awt.*;

public class FondoPanel extends JPanel {
    private Image imagen;

    public FondoPanel (String ruta){
        ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
        this.imagen = icono.getImage();
    }

    @Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        if (imagen != null){
            g.drawImage(imagen, 0,0, getWidth(), getHeight(), this);
        }
    }
}
