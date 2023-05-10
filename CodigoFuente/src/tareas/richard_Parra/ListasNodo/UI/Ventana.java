package ListasNodo.UI;

import ListasNodo.Lista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    Archivo panel;

    public Ventana(){
        init();
        menuBar();
    }

    public void menuBar() {
        // Crear barra menu
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        // Crear menu Ficheros
        JMenu m1 = new JMenu("Ficheros");
        mb.add(m1);
        JMenuItem mi = new JMenuItem("Crear carpeta");
        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearArchivo();
            }
        });
        m1.add(mi);
        mi = new JMenuItem("Crear fichero");
        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearTexto();
            }
        });
        m1.add(mi);

        m1.addSeparator();

        mi = new JMenuItem("Salir");
        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salir();
            }
        });
        m1.add(mi);
    }

    private void crearTexto() {
        String titulo = JOptionPane.showInputDialog("Nombre del archivo");
        String descripcion = JOptionPane.showInputDialog("descripcion del archivo");
        ListasNodo.Modelo.Archivo archivo= new ListasNodo.Modelo.Archivo();
        archivo.setTipo("txt");
        archivo.setNombre(titulo);
        archivo.setContenido(descripcion);
        panel.crearFile(archivo); //agremamos en el panel de archivos
    }
    // tamaño y comportamiento de cierre
    public void init(){
        panel = new Archivo();
        this.setSize(2000, 2000);
        this.setTitle("Ficheros");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addMouseListener(panel);
    }

    private void salir() {
        dispose();
        System.exit(0);
    }

    private void crearArchivo() {
        String titulo = JOptionPane.showInputDialog("Nombre del archivo");
        ListasNodo.Modelo.Archivo archivo;
        Lista newList = new Lista();
        archivo = new ListasNodo.Modelo.Archivo();
        archivo.setTipo("file");
        archivo.setNombre(titulo);
        newList.agregarNodo(archivo);// agregar a la lista
        panel.crearFile(newList);//agregamos al panel de archivos
    }
}
