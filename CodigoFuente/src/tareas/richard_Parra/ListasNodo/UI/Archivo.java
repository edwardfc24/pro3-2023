package ListasNodo.UI;

import ListasNodo.Lista;
import ListasNodo.ManejadorArchivos;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Archivo extends JPanel implements MouseListener {
    // objetos
    Lista lista ;

    Lista listasArchivos = new Lista();
    int indice = 0;
    ListasNodo.Modelo.Archivo mArchivo;
    String direcion = "raiz/";
    JLabel jlDirecion;
    JButton btnVolver;

    ManejadorArchivos manejadorArchivos = new ManejadorArchivos(); // manejar los archivos

    public Archivo() {
        setLayout(null);

        this.btnVolver = new JButton("Volver");
        this.btnVolver.setBounds(10, 400, 90, 40);
        this.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volver();
            }
        });
        this.btnVolver.setVisible(false);
        this.add(btnVolver);

        this.jlDirecion = new JLabel(direcion);
        this.jlDirecion.setBounds(10, 0, 300, 70);
        this.add(jlDirecion);


        this.lista = new Lista();

        this.mArchivo = new ListasNodo.Modelo.Archivo();

        this.mArchivo.setNombre("raiz");
        this.mArchivo.setTipo("file");
        this.lista.agregarNodo(mArchivo);

        this.listasArchivos.agregarNodo(lista);


        this.setSize(1030, 500);
        this.setPreferredSize(getSize());

    }
    //navegar directorio anterior
    private void volver() {
        this.listasArchivos.eliminarValorPorPosicion(indice);
        modificarTexto();
        indice-=1;
        if(indice == 0) this.btnVolver.setVisible(false);

        repaint();
    }

    //crea y escribe el tipo de archivo
    public void crearDirectorio(ListasNodo.Modelo.Archivo archivo) {
        if(archivo.getTipo() == "txt") {
            manejadorArchivos.escribirArchivo(direcion + "/" + archivo.getNombre() + "."  + archivo.getTipo(), archivo.getContenido());
            return;
        }
        manejadorArchivos.crearDirectorio(direcion + "/" + archivo.getNombre());
    }

    private void modificarTexto() {
        //construir una cadena de texto
        this.direcion = "";
        for (int i = 0; i < indice; i++) {
            Lista temp = ((Lista)this.listasArchivos.obtenerValor(i));
            this.direcion += ((ListasNodo.Modelo.Archivo)temp.obtenerValor(0)).getNombre() + "/" ;
        }

        this.jlDirecion.setText(direcion);
    }

    @Override
    public void paintComponent(Graphics gc) {
        //pintar todos los componentes de mi directorio
        super.paintComponent(gc);
        int x = 30;
        int y = 40;
        Lista list = (Lista) listasArchivos.obtenerValor(indice);

        for (int i = 1; i < list.getLongitud(); i++) {

            try {
                this.mArchivo =  (ListasNodo.Modelo.Archivo)list.obtenerValor(i);
            }catch (Exception e ) {
                Lista temp = (Lista)list.obtenerValor(i);
                this.mArchivo = (ListasNodo.Modelo.Archivo) temp.obtenerValor(0);
            }
            File file = new File("img\\" + mArchivo.getTipo() + ".png");

            try {
                BufferedImage img = ImageIO.read(file);
                gc.drawImage(img, x, y, 65, 70, null); // añadir imagen
                gc.drawString(mArchivo.getNombre(), x, y+80);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (i%10 == 0) {
                y += 90;
                x = 30;
            } else {
                x+=100;
            }
        }
    }
    // quitar archivo del directorio
    private void eliminar(Object obj) {
        repaint();
    }

    public void crearFile(Object obj) {
        Lista temp = (Lista) this.listasArchivos.obtenerValor(indice);
        temp.agregarNodo(obj);
        ListasNodo.Modelo.Archivo archivo;
        try {
            Lista obje = (Lista) obj;
            archivo = (ListasNodo.Modelo.Archivo) obje.obtenerValor(0);

        } catch (Exception ex) {
            archivo = (ListasNodo.Modelo.Archivo) obj;

        }
        crearDirectorio(archivo);
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(((Lista)this.listasArchivos.obtenerValor(indice)).getLongitud() == 1) return;
        int seleccion = JOptionPane.showOptionDialog(
                this,
                "Seleccione opcion",
                "Selector de opciones",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,    // null para icono por defecto.
                new Object[] { "Abrir", "Eliminar", "Cerrar"},   // null para YES, NO y CANCEL
                "Abrir");
        int x  = e.getX()/ 105;// calcular la posicion
        int y  = e.getY()/ 100;
        int num = Integer.parseInt(y-1 + "" + (x )) + 1;
        Lista ls = null ;
        if (seleccion == 0) {
            ls = (Lista) this.listasArchivos.obtenerValor(indice);
            try {
                this.mArchivo =  (ListasNodo.Modelo.Archivo)ls.obtenerValor(num);
                String contenidoMsj = "Titulo: " + this.mArchivo.getNombre() + "\n" + "Descripcion: " + this.mArchivo.getContenido();
                JOptionPane.showMessageDialog(this, contenidoMsj );
            }catch (Exception ex ) {

                Lista temp = (Lista)ls.obtenerValor(num);
                listasArchivos.agregarNodo(temp);
                indice += 1;
                this.direcion += ((ListasNodo.Modelo.Archivo)temp.obtenerValor(0)).getNombre() + "/";
                this.btnVolver.setVisible(true);

            }
        } else if (seleccion == 1){
            System.out.println(indice + "  ...   " + num);
            //elimina la posicion del valor
            ((Lista) this.listasArchivos.obtenerValor(indice)).eliminarValorPorPosicion(num);
        }
        this.jlDirecion.setText(direcion);
        repaint(); // actualice o pinte nuevamente el panel
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
