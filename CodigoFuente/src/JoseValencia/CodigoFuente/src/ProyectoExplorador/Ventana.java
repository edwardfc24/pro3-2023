package ProyectoExplorador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class Ventana extends JFrame {
    ListaNodos lista= new ListaNodos();
    int contadorx=10;
    int contadory= 25;
    ArrayList<JButton> btnsAcceso = new ArrayList<JButton>();
    JTextField txtbucador;
    JButton btnBuscar;
    PanelCreadora paneltxt;
    PanelCreadora panelCarpeta;
    JMenu menuOpciones;
    JMenuBar mimenubar;
    JMenuItem menucreartxt;
    JMenuItem menucrearCarpeta;
    CreadorArchivos nuevoArchivo = new CreadorArchivos();

    public Ventana(){
        this.setTitle("Explorador de Archivos :)");
        this.setLayout(null);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        ////panel para buscar ////////////////
        JPanel panelbuscador= new JPanel();
        this.add(panelbuscador);
        setVisible(false);
        //////////////////////////////////

        txtbucador= new JTextField();
        txtbucador.setBounds(280,25,100, 30);
        this.add(txtbucador);
        btnBuscar= new JButton("o");
        btnBuscar.setBounds(230,25,45,30);


        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JButton boton : btnsAcceso) {
                    if (boton.getText().equals(txtbucador.getText())) {
                        System.out.println("Se encontró el botón " + boton.getText());
                        panelbuscador.add(boton);
                        panelbuscador.setVisible(true);
                        break;
                    }
                }
            }
        });
        this.add(btnBuscar);


        //*********panel txt esta aqui*****************************************
        paneltxt = new PanelCreadora();
        paneltxt.setVisible(false);
        this.add(paneltxt);
        ///////////////////////boton de cancelar de txt*********
        JButton btncancelar= new JButton("Cancelar");
        btncancelar.setBounds(115, 200,100, 30);
        btncancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paneltxt.setVisible(false);
                paneltxt.txtcontenido.setText("");
                paneltxt.txtnombre.setText("");
            }
        });
        paneltxt.add(btncancelar);
        /////////////////////**********boton de crar txt
        JButton btncrearTxt= new JButton("CrearTxt");
        btncrearTxt.setBounds(10, 200,100, 30);
        btncrearTxt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creardoraTxt();
                agregarBotonTxt();
                paneltxt.txtcontenido.setText("");
                paneltxt.txtnombre.setText("");
                paneltxt.setVisible(false);
            }
        });
        paneltxt.add(btncrearTxt);

        menucreartxt = new JMenuItem("Crear txt");
        menucreartxt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paneltxt.setVisible(true);
                panelCarpeta.setVisible(false);
            }
        });


        //*********panel carpeta************
        panelCarpeta = new PanelCreadora();
        panelCarpeta.setVisible(false);
        this.add(panelCarpeta);
        ///////////////////////boton de cancelar carpeta*********
        JButton btncancelarCarpeta= new JButton("Cancelar");
        btncancelarCarpeta.setBounds(115, 200,100, 30);
        btncancelarCarpeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCarpeta.setVisible(false);
                panelCarpeta.txtcontenido.setText("");
                panelCarpeta.txtnombre.setText("");
            }
        });
        panelCarpeta.add(btncancelarCarpeta);
        JButton btncrearCarpeta= new JButton("CrearCarpeta");
        btncrearCarpeta.setBounds(10, 200,100, 30);
        btncrearCarpeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creardoraCarpeta();
                agregarBotonCarpeta();
                panelCarpeta.txtcontenido.setText("");
                panelCarpeta.txtnombre.setText("");
                paneltxt.setVisible(false);
                panelCarpeta.setVisible(false);

            }
        });
        panelCarpeta.add(btncrearCarpeta);

        menucreartxt = new JMenuItem("Crear txt");
        menucreartxt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCarpeta.setVisible(false);
                paneltxt.setVisible(true);

            }
        });

        menucrearCarpeta= new JMenuItem("Crear Carpeta");
        menucrearCarpeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCarpeta.txtcontenido.setEnabled(false);
                paneltxt.setVisible(false);
                panelCarpeta.setVisible(true);
            }
        });

        menuOpciones = new JMenu("opciones");
        menuOpciones.add(menucreartxt);
        menuOpciones.add(menucrearCarpeta);

        mimenubar= new JMenuBar();
        setJMenuBar(mimenubar);

        mimenubar.add(menuOpciones);
        add(mimenubar);


        this.setVisible(true);
    }

    public void buscardocs(){
        /*File carpeta = new File("C:/Users/Clases de jose/Downloads/ExploradorArchivos");
        File [] archivos = carpeta.listFiles();
        for (File archivo: archivos ) {
            lista.agregarNodoAlFinal(archivo);
        }*/

    }

    public void creardoraTxt(){
        String contenidodoc= paneltxt.txtcontenido.getText();
        String nombredoc= paneltxt.txtnombre.getText();
        String ruta = paneltxt.ubicacion+nombredoc+ paneltxt.extension;

        paneltxt.crearTxt.escribirArchivo(ruta, contenidodoc);
        File carpeta = new File("C:\\mi_carpeta");
        if (carpeta.exists()) {
            System.out.println("La carpeta existe");
        }
    }
    public void creardoraCarpeta(){
        String contenidodoc= null;
        String nombredoc= panelCarpeta.txtnombre.getText();
        String ruta = panelCarpeta.ubicacion+nombredoc;

        paneltxt.crearTxt.escribirArchivo(ruta, contenidodoc);
        File carpeta = new File(ruta);
        if (carpeta.exists()) {
            lista.agregarNodoAlPrincipio(carpeta);
            System.out.println("se añadio el file a la listya");
        }
        ;
    }
    public void agregarBotonTxt() {
        JButton boton = new JButton();
        boton= this.obtenerBotontxt();
        boton.setBounds(contadorx, contadory, 70, 30);
        btnsAcceso.add(boton);
        this.add(boton);
        this.repaint();
        contadorx=contadorx+75;
        contadory= contadory+0;
    }

    public JButton obtenerBotontxt(){
        String nombreboton= paneltxt.txtnombre.getText();
        JButton boton= new JButton(nombreboton);
        boton.setSize(20, 20);
        return boton;

    }
    public void agregarBotonCarpeta() {
        JButton boton = new JButton();
        boton= this.obtenerBotonCarpeta();
        boton.setBounds(contadorx, contadory, 70, 30);
        btnsAcceso.add(boton);
        this.add(boton);
        this.repaint();
    }
    public JButton obtenerBotonCarpeta(){
        String nombreboton= paneltxt.txtnombre.getText();
        JButton boton= new JButton(nombreboton);
        boton.setSize(20, 20);
        return boton;
    }
}