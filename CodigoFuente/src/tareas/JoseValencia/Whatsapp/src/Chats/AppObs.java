package Chats;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AppObs {
    public static void main(String[] args) {
        ArrayList<Persona> personas= new ArrayList<>();
        Persona pepe = new Persona("Pepe");
        Persona tito = new Persona("tito");
        Persona maria = new Persona("maria");
        /*
        personas.add(pepe);
        personas.add(tito);
        personas.add(maria);
        personas.add(lucia);
        personas.add(mario);
         */
        ////pepe suscriptores///
        pepe.suscribir(tito);
        pepe.suscribir(maria);

        /////tito
        tito.suscribir(pepe);
        tito.suscribir(maria);

        ////maria
        tito.suscribir(pepe);
        tito.suscribir(tito);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FrameConObserver ventanapepe = new FrameConObserver(pepe, tito, maria);
                FrameConObserver ventanatito = new FrameConObserver(tito, pepe, maria);
                FrameConObserver ventanamaria = new FrameConObserver(maria, pepe, tito);

                /////pepe
                ventanapepe.getBtnenviar().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ventanapepe.getChats().add(tito.mostrarMensaje(pepe.getNombre()+" : "+ventanapepe.getTxtnotificar().getText()+"                                                                    "));

                        ventanatito.getChats().add(tito.mostrarMensaje(pepe.getNombre()+" : "+ventanapepe.getTxtnotificar().getText()+"                                                                    "));
                        ventanamaria.getChats().add(maria.mostrarMensaje(pepe.getNombre()+" : "+ventanapepe.getTxtnotificar().getText()+"                                                                    "));

                        ventanamaria.getChats().repaint();
                        ventanapepe.getTxtnotificar().setText("");
                        ventanapepe.repaint();
                        ventanatito.repaint();
                    }
                });
                /////tito
                ventanatito.getBtnenviar().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ventanatito.getChats().add(pepe.mostrarMensaje(tito.getNombre()+" : "+ventanatito.getTxtnotificar().getText()+"                                                                     "));

                        ventanapepe.getChats().add(pepe.mostrarMensaje(tito.getNombre()+" : "+ventanatito.getTxtnotificar().getText()+"                                                                     "));
                        ventanamaria.getChats().add(maria.mostrarMensaje(tito.getNombre()+" : "+ventanatito.getTxtnotificar().getText()+"                                                                    "));

                        ventanatito.getTxtnotificar().setText("");
                    }
                });
                /////maria
                ventanamaria.getBtnenviar().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ventanamaria.getChats().add(maria.mostrarMensaje(maria.getNombre()+" : "+ventanamaria.getTxtnotificar().getText()+"                                                                     "));

                        ventanapepe.getChats().add(pepe.mostrarMensaje(maria.getNombre()+" : "+ventanamaria.getTxtnotificar().getText()+"                                                                     "));
                        ventanatito.getChats().add(tito.mostrarMensaje(maria.getNombre()+" : "+ventanamaria.getTxtnotificar().getText()+"                                                                    "));

                        maria.notificarObservadores(ventanamaria.getTxtnotificar().getText());

                        ventanamaria.getTxtnotificar().setText("");

                    }
                });

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        ventanamaria.repaint();
                        ventanatito.repaint();
                        ventanapepe.repaint();
                    }
                }, 10, 1000);
            }
        });

    }
}
