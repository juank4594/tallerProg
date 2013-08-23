package co.edu.um.tallerProg.Vista;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que permite agregar una imagen de fondo a las ventanas del programa
 */
public class DesktopConFondo  extends JDesktopPane {

    private Image imagen;

    /**
     * Constructor vacio de la clase Desktop con Fondo (Imágen del fondo)
     */
    public DesktopConFondo() {
    }

    /**
     * Funcion que asigna una imagen a la variable imagen, a partir del nombre de la misma
     * @param nombreImagen
     */
    public void setImagen(String nombreImagen) {
        if (nombreImagen != null) {
            imagen = new ImageIcon(getClass().getResource(nombreImagen)).getImage();
        } else {
            imagen = null;
        }

        repaint();
    }

    /**
     * Método que dibuja la imagen designada según los atributos de tamaño y de transparencia.
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
        } else {
            setOpaque(true);
        }

        super.paint(g);
    }
}