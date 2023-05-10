package ProyectoExplorador;

import javax.swing.*;
import java.util.ArrayList;

public class PanelCreadora extends JPanel {
    ArrayList<JButton> listaBotones = new ArrayList<>(); /////////***************
    String ubicacion= "C:/Users/Clases de jose/Downloads/ExploradorArchivos/";
    String extension= ".txt";
    CreadorArchivos crearTxt= new CreadorArchivos();
    JLabel lblnombre, lblcontenido;
    JTextField txtnombre,  txtcontenido;
    JButton btncrear ;
    public PanelCreadora(){
        //this.setTitle("Crear Documento");
        this.setLayout(null);
        this.setSize(250, 250);
        this.setLocation(100,100);
        //this.setLocationRelativeTo(null);

        lblnombre = new JLabel("Nombre");
        lblnombre.setBounds(10, 10, 70, 20);
        this.add(lblnombre);
        lblcontenido = new JLabel("contenido");
        lblcontenido.setBounds(10,40, 70, 20 );
        this.add(lblcontenido);
        txtnombre= new JTextField();
        txtnombre.setBounds(85,10,145,20);
        this.add(txtnombre);
        txtcontenido= new JTextField();
        txtcontenido.setBounds(10,60,220,100);
        this.add(txtcontenido);
        /*btncrear= new JButton("crear");
        btncrear.setBounds(10, 180,100, 30);
        btncrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creardora();
            }
        });
        this.add(btncrear);*/
    }

    /*public void creardora(){
        String contenidodoc= txtcontenido.getText();
        String nombredoc= txtnombre.getText();
        String ruta = ubicacion+nombredoc+extension;

        crearTxt.escribirArchivo(ruta, contenidodoc);
        this.obtenerBoton();
    }*/
    public void  agregarBoton(){
        String nombreboton= txtnombre.getText();
        JButton boton= new JButton(nombreboton);
        boton.setBounds(10,10,100,30);
        listaBotones.add(boton);
        add(boton);

    }
}