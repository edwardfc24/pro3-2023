package patrones.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDao implements Dao<Estudiante> {
    private Connection conexion;
    private static final String TABLA = "Estudiantes";

    public EstudianteDao() {
        String url = "jdbc:mysql://localhost:3306/testDb";
        String user = "root";
        String password = "SuperUsuar10";

        try {
            this.conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void insert(Estudiante object) {
        String query = "INSERT INTO " + this.TABLA + " (Nombres, Apellidos, Edad, CarnetIdentidad) VALUES (?, ?, ?, ?)";
        try (PreparedStatement declaracion = conexion.prepareStatement(query)) {
            declaracion.setString(1, object.getNombres());
            declaracion.setString(2, object.getApellidos());
            declaracion.setInt(3, object.getEdad());
            declaracion.setString(4, object.getCarnetIdentidad());
            declaracion.executeUpdate();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void update(Estudiante object) {
        String query = "UPDATE " + this.TABLA + " SET Nombres = ?, Apellidos = ?, Edad = ?, CarnetIdentidad = ? WHERE Id = ?";
        try (PreparedStatement declaracion = conexion.prepareStatement(query)) {
            declaracion.setString(1, object.getNombres());
            declaracion.setString(2, object.getApellidos());
            declaracion.setInt(3, object.getEdad());
            declaracion.setString(4, object.getCarnetIdentidad());
            declaracion.setInt(5, object.getId());
            declaracion.executeUpdate();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void delete(Estudiante object) {
        String query = "DELETE FROM " + this.TABLA + "WHERE Id = ?";
        try (PreparedStatement declaracion = conexion.prepareStatement(query)) {
            declaracion.setInt(1, object.getId());
            declaracion.executeUpdate();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        String query = "DELETE FROM " + this.TABLA + "WHERE Id = ?";
        try (PreparedStatement declaracion = conexion.prepareStatement(query)) {
            declaracion.setInt(1, id);
            declaracion.executeUpdate();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public Estudiante get(int id) {
        String query = "SELECT FROM " + this.TABLA + "WHERE Id = ?";
        Estudiante estudiante = null;
        try (PreparedStatement declaracion = conexion.prepareStatement(query)) {
            declaracion.setInt(1, id);
            ResultSet resultado = declaracion.executeQuery();
            if (resultado.next()) {
                estudiante = new Estudiante(
                        resultado.getInt("Id"),
                        resultado.getString("Nombres"),
                        resultado.getString("Apellidos"),
                        resultado.getInt("Edad"),
                        resultado.getString("CarnetIdentidad")
                );
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return estudiante;
    }

    @Override
    public List<Estudiante> getAll() {
        String query = "SELECT FROM " + this.TABLA;
        List<Estudiante> estudiantes = new ArrayList<>();
        try (PreparedStatement declaracion = conexion.prepareStatement(query)) {
            ResultSet resultado = declaracion.executeQuery();
            while (resultado.next()) {
                Estudiante estudiante = new Estudiante(
                        resultado.getInt("Id"),
                        resultado.getString("Nombres"),
                        resultado.getString("Apellidos"),
                        resultado.getInt("Edad"),
                        resultado.getString("CarnetIdentidad")
                );
                estudiantes.add(estudiante);
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return estudiantes;
    }

    @Override
    public void closeConnection() {
        try {
            conexion.close();
        } catch (SQLException exc) {
            exc.printStackTrace();
            ;
        }
    }
}
