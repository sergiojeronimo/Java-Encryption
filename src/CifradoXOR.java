import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CifradoXOR extends JFrame{
    private JPanel Main2;
    private JTextField textField1;
    private JTextField textField2;
    private JButton CIFRARButton;
    private JTextField textField3;

    private JMenuBar menuBar;
    private JMenu opciones;
    private JMenuItem salir;
    private JMenuItem volverAlMenu;

    public CifradoXOR(){
        super("Cifrando en Java - Cifrado XOR");
        setContentPane(Main2);
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

        CIFRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mensaje = textField1.getText();
                int clave = Integer.parseInt(textField2.getText());
                XORCifrado nuevo = new XORCifrado();
                String mensajeCifrado = nuevo.procesoCifrado(mensaje, clave);
                textField3.setText(mensajeCifrado);
            }
        });
    }
}
