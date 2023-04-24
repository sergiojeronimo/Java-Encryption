import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MainClass {
    public static void main(String[]args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int altura = pantalla.height;
                int ancho = pantalla.width;
                JFrame frame = new MenuPrincipal();
                frame.setSize(ancho/4, altura/2);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public void enlace (String enlaceAAceder){
        Desktop enlace=Desktop.getDesktop();
        try {
            enlace.browse(new URI(enlaceAAceder));
        } catch (IOException | URISyntaxException e) {
            e.getMessage();
        }
    }
}
