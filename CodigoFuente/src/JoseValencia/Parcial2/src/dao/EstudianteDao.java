package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class EstudianteDao implements Dao<Estudiante>{

    private Connection conexion ;
    private static final String tabla= "estudiantes";

    public EstudianteDao(){
        String host= "jdbc:mysql://localhost:3306/testDb";
        String user= "root";
        String paswoord= "super";
        /*
        try{
            this.conexion= DriverManager.getConnection(url,user,paswoord);
        }catch(IOException e){
            e.printStackTrace();
        }
        */
    }


    @Override
    public void insert(Estudiante object) {

    }

    @Override
    public void update(Estudiante object) {

    }

    @Override
    public void delete(Estudiante object) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Estudiante get(int id) {
        return null;
    }

    @Override
    public List<Estudiante> getAll() {
        return null;
    }
}
