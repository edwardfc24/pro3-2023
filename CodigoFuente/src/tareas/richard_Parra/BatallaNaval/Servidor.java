package Sockets.BatallaNaval;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Servidor extends JFrame {
    private JLabel lbMovimiento = new JLabel();
    private JLabel participantes = new JLabel();
    private JTextArea panel_movimiento = new JTextArea();
    private JTextArea panel_Participa = new JTextArea();

    int port = 0;
    ServerSocket servidor;
    // almacena clave - valor
    HashMap cliente = new HashMap();

    public Servidor() {
        setTitle("Servidor");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(700, 250);
        setLayout(null);
        setSize(545, 520);
        init();
        try {
            servidor = new ServerSocket(8181);
            new ClienteAcepta().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init() {
        panel_Participa.setBackground(new java.awt.Color(0, 0, 0));
        panel_Participa.setBounds(370, 50, 150, 400);
        panel_Participa.setEditable(false);
        panel_Participa.setForeground(Color.white);

        participantes.setFont(new java.awt.Font("cooper black", 0, 24));
        participantes.setText("Participante");
        participantes.setBounds(400, -20, 100, 100);

        panel_movimiento.setBackground(new java.awt.Color(0, 0, 0));
        panel_movimiento.setBounds(10, 50, 350, 400);
        panel_movimiento.setEditable(false);
        panel_movimiento.setForeground(Color.white);

        lbMovimiento.setFont(new java.awt.Font("cooper black", 0, 24));
        lbMovimiento.setText("Movimientos");
        lbMovimiento.setBounds(170, -20, 100, 100);

        add(panel_movimiento, null);
        add(panel_Participa, null);
        add(participantes, null);
        add(lbMovimiento, null);

    }

    public class ClienteAcepta extends Thread {
        // cliente conectados
        public void run() {
            while (true) {
                try {
                    Socket socket = servidor.accept();
                    String entrada = new DataInputStream(socket.getInputStream()).readUTF();
                    if (cliente.containsKey(entrada)) {
                        DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
                        salida.writeUTF("Ya estas registrado");

                    } else {
                        cliente.put(entrada, socket);
                        panel_Participa.append(entrada + " Se unio\n");
                        DataOutputStream salida = new DataOutputStream((socket.getOutputStream()));
                        salida.writeUTF("");
                        new leerMensaje(socket, entrada).start();
                        new listaClientes().start();
                    }
                } catch (Exception e) {
                }
            }
        }
    }
    //leer mensajes del cliente
    class leerMensaje extends Thread {
        Socket socket;
        String ID;

        leerMensaje(Socket s, String ID) {
            this.socket = s;
            this.ID = ID;
        }

        public void run() {
            while (!cliente.isEmpty()) {
                try {
                    String i = new DataInputStream(socket.getInputStream()).readUTF();
                    // cliente cola
                    Set k = cliente.keySet();
                    // iterador tipo lista
                    Iterator itr = k.iterator();
                    while (itr.hasNext()) {
                        String key = (String) itr.next();
                        if (!key.equalsIgnoreCase(ID)) {
                            try {
                                new DataOutputStream(((Socket) cliente.get(key)).getOutputStream()).writeUTF("Jugador: "+ ID + ","+ i);
                            } catch (Exception e) {
                                // Manejo de errores al enviar mensajes a los clientes
                            }
                        }
                    }
                    panel_movimiento.append("Jugador: "+ ID + ","+ i + "\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // Clase interna para preparar la lista de clientes conectados
    class listaClientes extends Thread {
        public void run() {
            try {
                String ids = "";
                Set k = cliente.keySet();
                Iterator itr = k.iterator();
                while (itr.hasNext()) {
                    String key = (String) itr.next();
                    ids += key + ",";
                }
                if (ids.length() != 0) {
                    ids = ids.substring(0, ids.length() - 1);
                }

                itr = k.iterator();

                while (itr.hasNext()) {
                    String key = (String) itr.next();
                    try {
                        new DataOutputStream(((Socket) cliente.get(key)).getOutputStream()).writeUTF(":;.,/=" + ids);
                    } catch (Exception e) {
                        cliente.remove(key);
                        panel_Participa.append(key + ":Salio" + "\n");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Servidor serv = new Servidor();
        serv.setVisible(true);
    }
}
