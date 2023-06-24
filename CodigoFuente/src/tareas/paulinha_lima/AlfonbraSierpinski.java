import java.awt.*;
import javax.swing.*;
public class AlfonbraSierpinski extends JFrame {
    int nivel=2;

        public static void main(String[] args) {
            AlfonbraSierpinski alfonbra = new AlfonbraSierpinski();

            String n = JOptionPane.showInputDialog("Ingrese el nivel deseado ");
            JOptionPane.showMessageDialog(null, "El nivel es: " +n);
            int nivel_N = Integer.parseInt(n);
            alfonbra.setNivel(nivel_N);
            System.out.println(alfonbra.getNivel());


            //Menu
            JMenuBar menuBar = new JMenuBar();
            JMenu fileMenu = new JMenu("Opciones");
            JMenuItem newMenuItem = new JMenuItem("");
            JMenuItem openMenuItem = new JMenuItem("nivel");
            JMenuItem saveMenuItem = new JMenuItem("Salir");

            newMenuItem.addActionListener(e -> System.out.println("Haz seleccionado la opción 'Nuevo'"));
            openMenuItem.addActionListener(e -> System.out.println("Prueba"));
            saveMenuItem.addActionListener(e -> alfonbra.salir());

            fileMenu.add(newMenuItem);
            fileMenu.add(openMenuItem);
            fileMenu.add(saveMenuItem);
            menuBar.add(fileMenu);
            //  Ventana
            JFrame frame = new AlfonbraSierpinski();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setJMenuBar(menuBar);
            frame.setSize(400,440);
            frame.setVisible(true);
        }

        public AlfonbraSierpinski() {
            super("Alfonbra de Sierpinski");
            //se crea mi panel y grafica
            JPanel panel = new JPanel() {
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    int width = getWidth();
                    int height = getHeight();
                    int niveles =getNivel();
                    g.setColor(Color.orange);
                    g.fillRect(0, 0, width, height);
                    dibujarAlfombra(g, 0, 0, width, height,niveles);
                }

            };
            setContentPane(panel);
        }

        private void dibujarAlfombra(Graphics g, int x, int y, int ancho, int alto, int nivel) {
            if (nivel == 0) {
                g.setColor(Color.WHITE);
                g.fillRect(x, y, ancho, alto);
            } else {
                //en esta parte dividimos nuestro ancho en 3
                /**Este fractal se construye partiendo de un cuadrado de lado uno,
                 *  se divide en tres partes iguales cada lado y se extrae el cuadrado central.
                 *  En cada uno de los ocho cuadrados de lado  que forman la figura restante
                 *  se repite esta operación, y así sucesivamente.**/
                int particion = ancho / 3;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i != 1 || j != 1) {
                            dibujarAlfombra(g, x + i * particion, y + j * particion, particion, particion, nivel - 1);
                        }
                    }
                }
            }
        }
    public void salir() {
        dispose();
        System.exit(0);
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}

