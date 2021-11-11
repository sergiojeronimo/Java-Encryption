import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PipedInputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class DescifradoCesarFB extends  JFrame{
    private JPanel Main6;
    private JTextField textField1;
    private JButton DESCIFRARButton;

    private JMenuBar menuBar;
    private JMenu opciones;
    private JMenuItem salir;
    private JMenuItem volverAlMenu;

    public DescifradoCesarFB() {
        super("Cifrando en Java - Descifrado por Fuerza Bruta CESAR");
        setContentPane(Main6);
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
                CesarDescifrado nuevo = new CesarDescifrado();
                try {
                    String homeUsuario = System.getProperty("user.home");
                    String ruta = homeUsuario+"\\Documents\\Comprobar.txt";
                    File file = new File(ruta);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter escribir = new BufferedWriter(fw);
                    for(int i=1; i<26; i++){
                        escribir.write("Clave: "+i+"\t"+"MCD: "+nuevo.descifradoCesar(mensaje, i));
                        escribir.write("\n");
                    }
                    escribir.close();
                } catch (Exception e1){
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null,"El archivo 'Comprobar.txt' se ha creado en Documentos");
            }
        });
    }
}
