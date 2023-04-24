import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame{
    private JButton cifradoXORButton;
    private JPanel Main;
    private JButton descifradoXORButton;
    private JButton cifradoCESARButton;
    private JButton descifradoCESARButton;
    private JButton fuerzaBRUTAButton;

    private JMenuBar menuBar;
    private JMenu opciones;
    private JMenuItem masInfo;
    private JMenuItem salir;

    public MenuPrincipal() {
       super("Cifrando en Java - Menu");
       setContentPane(Main);
        MainClass enlace = new MainClass();

        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/73465.png")));

        menuBar = new JMenuBar();
       opciones = new JMenu("Opciones");
       masInfo = new JMenuItem("Más Info del Proyecto");
       salir = new JMenuItem("Salir");

       menuBar.add(opciones);
       opciones.add(masInfo);
       opciones.add(salir);

       setJMenuBar(menuBar);

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        masInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enlace.enlace("https://github.com/xjepp/Python-Encryption");
            }
        });
        cifradoXORButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                        int altura = pantalla.height;
                        int ancho = pantalla.width;
                        JFrame frame = new CifradoXOR();
                        frame.setSize(ancho/3, altura/2);
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    }
                });
            }
        });
        descifradoXORButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                        int altura = pantalla.height;
                        int ancho = pantalla.width;
                        JFrame frame = new DescifradoXOR();
                        frame.setSize(ancho/3, altura/2);
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    }
                });
            }
        });
        cifradoCESARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                        int altura = pantalla.height;
                        int ancho = pantalla.width;
                        JFrame frame = new CifradoCesar();
                        frame.setSize(ancho/3, altura/2);
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    }
                });
            }
        });
        descifradoCESARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                        int altura = pantalla.height;
                        int ancho = pantalla.width;
                        JFrame frame = new DescifradoCesar();
                        frame.setSize(ancho/3, altura/2);
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    }
                });
            }
        });
        fuerzaBRUTAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                        int altura = pantalla.height;
                        int ancho = pantalla.width;
                        JFrame frame = new DescifradoCesarFB();
                        frame.setSize(ancho/3, altura/2);
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    }
                });
            }
        });
    }
}
