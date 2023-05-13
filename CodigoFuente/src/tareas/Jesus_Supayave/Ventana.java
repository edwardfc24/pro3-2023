package tareas.Jesus_Supayave;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class Ventana extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L; //Para leer un objeto, se leen las cadenas de bytes y se reconstruye el objeto a partir de ellos.
    private JTextArea descripcionTextArea, contenidoTextArea;
    private JTextField Busqueda;
    private JButton crearCarpetaButton, crearArchivoButton, eliminarButton, buscarbtn;

    public Ventana() {
        super("Crear carpeta y archivo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 900);


        descripcionTextArea = new JTextArea();
        add(descripcionTextArea, BorderLayout.NORTH);

        Busqueda = new JTextField();
        add(Busqueda,BorderLayout.NORTH);
        Busqueda.addActionListener(this);

        contenidoTextArea = new JTextArea();
        add(contenidoTextArea, BorderLayout.CENTER);

        crearCarpetaButton = new JButton("Crear carpeta");
        crearCarpetaButton.addActionListener(this);
        crearArchivoButton = new JButton("Crear archivo txt");
        crearArchivoButton.addActionListener(this);
        eliminarButton = new JButton("Eliminar");
        eliminarButton.addActionListener(this);
        /*buscarbtn = new JButton("Buscar");
        buscarbtn.addActionListener(this);*/

        JPanel panel = new JPanel();
        panel.add(crearCarpetaButton);
        panel.add(crearArchivoButton);
        panel.add(eliminarButton);
       /* panel.add(Busqueda);
        panel.add(buscarbtn);*/
        add(panel, BorderLayout.SOUTH);

        setVisible(true);


    }

    //todo el proceso de la creacion
    //para que el achivo se cree y se guarde donde se selecciona utilizo el metodo JFileChooser.
    //el "Jfilechooser" permite abrir un cuadro de diálogo donde el usuario puede seleccionar un archivo usando el explorador de archivos de su computadora.

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == crearCarpetaButton) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int seleccion = fileChooser.showSaveDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {          //Si el usuario le ha dado al botón aceptar
                File carpeta = fileChooser.getSelectedFile();

                if (carpeta.exists()) {
                    JOptionPane.showMessageDialog(this, "La carpeta ya existe");
                } else {
                    if (carpeta.mkdirs()) {
                        JOptionPane.showMessageDialog(this, "Carpeta creada correctamente");
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al crear la carpeta");
                    }
                }
            }
        } else if (e.getSource() == crearArchivoButton) {

            /*if(e.getSource() == Busqueda){
                String busqueda = Busqueda.getText().toLowerCase();
                File Directorio = new File(".");
                File [] archivos = Directorio.listFiles();
                ArrayList<File> resultados = new ArrayList<File>();
                for(File archivo : archivos){
                    if (archivo.getName().toLowerCase().contains(busqueda)) {
                        resultados.add(archivo);
                    }
                }
                if(resultados.isEmpty()){
                    JOptionPane.showMessageDialog(this,"No se encontro el elemento de la busqueda");
                }else {
                    StringBuilder mensaje = new StringBuilder("Resultado de la busqueda: \n");
                    for (File resultado : resultados){
                        mensaje.append(resultado.getName()).append("\n");
                    }
                    JOptionPane.showMessageDialog(this,mensaje.toString());
                }
            }*/

            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File archivo = fileChooser.getSelectedFile();
                String descripcion = descripcionTextArea.getText();
                String contenido = contenidoTextArea.getText();
                try {
                    FileWriter writer = new FileWriter(archivo);
                    writer.write(descripcion + "\n\n" + contenido);
                    writer.close();
                    JOptionPane.showMessageDialog(this, "Archivo creado correctamente");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al crear el archivo");
                }
            }
        }

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

                int seleccion = fileChooser.showSaveDialog(Ventana.this);
                if(seleccion == JFileChooser.APPROVE_OPTION){
                    File archivoCarpeta = fileChooser.getSelectedFile();
                    try{
                        Files.delete(archivoCarpeta.toPath());
                        JOptionPane.showMessageDialog(Ventana.this,"Elemento eliminado correctamente");
                    }catch (IOException ex){
                        ex.printStackTrace();

                        JOptionPane.showMessageDialog(Ventana.this,"Error al eliminar el elemento");
                    }
                }
            }
        });

        /*buscarbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == buscarbtn){
                    String busqueda = Busqueda.getText();
                    File file  = new File(busqueda);

                    if(file.exists()){
                        if(file.isDirectory()){
                            JOptionPane.showMessageDialog(Ventana.this,"la carpeta existe en la ruta: " + file.getAbsolutePath());

                        }else if (file.isFile() && file.getName().endsWith(".txt")){
                            JOptionPane.showMessageDialog(Ventana.this, "el archivo txt existe en la ruta : " + file.getAbsolutePath());
                        }else{
                            JOptionPane.showMessageDialog(Ventana.this,"No se encontro ninguna carpeta o archivo txt con el nombre ingresado");
                        }
                    }else if(e.getSource()== crearCarpetaButton){

                    } else if (e.getSource() ==  crearArchivoButton) {

                    } else if (e.getSource() == eliminarButton) {

                    }
                }
            }
        });*/
    }
}

