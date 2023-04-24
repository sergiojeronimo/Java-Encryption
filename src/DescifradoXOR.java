import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DescifradoXOR extends JFrame{
    private JPanel Main3;
    private JTextField textField1;
    private JTextField textField3;
    private JButton DESCIFRARButton;
    private JTextField textField2;

    private JMenuBar menuBar;
    private JMenu opciones;
    private JMenuItem salir;
    private JMenuItem volverAlMenu;

    public DescifradoXOR(){
        super("Cifrando en Java - Descifrado XOR");
        setContentPane(Main3);
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/73465.png")));
        menuBar = new JMenuBar();
        opciones = new JMenu("Opciones");
        volverAlMenu = new JMenuItem("Volver al Menu Principal");
        salir = new JMenuItem("Salir");

        menuBar.add(opciones);
        opciones.add(volverAlMenu);
        opciones.add(salir);

        setJMenuBar(menuBar);

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        volverAlMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
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
        });
        DESCIFRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mensaje = textField1.getText();
                int clave = Integer.parseInt(textField2.getText());
                XORDescifrado nuevo = new XORDescifrado();
                String mensajeCifrado = nuevo.procesoDescifrado(mensaje, clave);
                textField3.setText(mensajeCifrado);
            }
        });
    }
}
