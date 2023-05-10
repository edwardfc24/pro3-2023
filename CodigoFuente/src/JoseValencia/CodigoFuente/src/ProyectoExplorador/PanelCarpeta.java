package ProyectoExplorador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCarpeta extends JPanel {
    JButton btnAtras, btnEliminar;
    JPanel lbltitulo;

    public PanelCarpeta(){
        this.setLayout(null);
        this.setSize(250, 250);
        this.setLocation(100,100);

        btnAtras= new JButton("atrás");
        btnAtras.setBounds(135, 10, 70, 30);
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(135, 200, 70, 30);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
