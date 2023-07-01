
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends JFrame implements Observer, Observable {
    private static final Logger logger = LogManager.getLogger(Cliente.class);
    private String nombre;
    public List<Observer> observadores;
    private JTextArea area;
    private JTextField texto;
    private  JButton btnenviar;
    /*private String enviador;
    boolean chatPropio;*/


    public Cliente(String nombre){
        this.nombre = nombre;
        this.observadores = new ArrayList<>();

        //JFrame
        setTitle("Pantalla de : " + nombre);  // personalizado
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);

        area= new JTextArea(20,20);
        area.setEditable(false);

        JPanel panel = new JPanel(new BorderLayout()); //creacion de los paneles para los usuarios--------panel princ. va contener todo lo de panelE

        texto = new JTextField(30); //muestran los mensajes --- ingresa, ejecuta , captura

        btnenviar = new JButton("Enviar");
        btnenviar.addActionListener(new ActionListener() { //proceso del boton....
            @Override
            public void actionPerformed(ActionEvent e) {
                String mensaje = texto.getText();
                enviarMensaje(mensaje);
                texto.setText("");
            }
        });

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mensaje = texto.getText();
                enviarMensaje(mensaje);
                texto.setText("");
            }
        };
        texto.addActionListener(actionListener);

        JPanel panelE = new JPanel(new BorderLayout()); //conf, posesionar area y texto, anidados al panel princ
        panelE.add(area, BorderLayout.CENTER);
        panelE.add(texto, BorderLayout.SOUTH);
        panel.add(panelE, BorderLayout.SOUTH);
        add(panel);

        //boton
        panelE.add(btnenviar,BorderLayout.NORTH);
        JPanel panelBoton = new JPanel(new FlowLayout());
        panelBoton.add(texto);
        panelBoton.add(btnenviar);
        panel.add(panelBoton, BorderLayout.NORTH);



    }


    @Override
    public void suscribir(Observer observer) {
        this.observadores.add(observer);

    }

    @Override
    public void desuscribir(Observer observe) {
        this.observadores.remove(observe);
    }

    @Override
    public void notificarObservadores(String mensaje) {
        for (Observer observer : observadores) {
            observer.actualizar(nombre, mensaje); //notifica a todos los observadores
        }
    }

    @Override
    public void actualizar(String enviador, String mensaje) { //mostrar mensaje consola/grafica
        //System.out.println( enviador + " ha enviado este mensaje " + " a "+ nombre + ": " + mensaje );
        logger.info(enviador + " ha enviado este mensaje " + " a "+ nombre + ": " + mensaje );
        area.append(enviador + " : " + mensaje + "\n");

        VentanaMensaje(enviador,nombre,mensaje);
       /* if(!enviador.equals(nombre)){
            VentanaMensaje(enviador,nombre,mensaje);
        } else{
            VentanaMensaje(nombre,enviador,mensaje);
        }
*/

    }

    public void escribir (Observer observer) {
        this.observadores.add(observer);
    }

    public void enviarMensaje(String mensaje) {
        notificarObservadores(mensaje);

        //chatPropio= false;  //chat proprio null
        /*if(chatPropio){
            System.out.println("-------------------sdasd---------------------------");
            System.out.println("ENVIA:" + nombre);
            System.out.println("RECIBE:" + nombre);
            System.out.println("MENSAJE: " + mensaje);
            System.out.println("-----------------------------------------------");
            VentanaMensaje( enviador,nombre, mensaje);
        }
*/
    }


    public void VentanaMensaje( String QEnvia, String QRecibe, String mensaje){
        System.out.println("----------------------------------------------");
        logger.info("ENVIA:" + QEnvia);
        logger.info("RECIBE:" + QRecibe);
        logger.info("MENSAJE: " + mensaje);
        System.out.println("-----------------------------------------------");

        //System.out.println("ENVIA:" + QEnvia);
        /*System.out.println("RECIBE:" + QRecibe);
        System.out.println("MENSAJE: " + mensaje);*/


        //logger.info("----------------------------------------------");
        //logger.info("----------------------------------------------");
    }

    /*public void agregarObservadores(Observer observer){

    }
    public void eliminarObservador(Observer observer) {

    }*/

   /* botonEnviar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String mensaje = campoTexto.getText();
            enviarMensaje(mensaje);
            campoTexto.setText("");
*/
}

