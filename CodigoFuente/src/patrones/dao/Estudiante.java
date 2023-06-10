package patrones.dao;

public class Estudiante {
    public int id;
    public String nombres;
    public String apellidos;
    public int edad;
    public String CarnetIdentidad;

    public Estudiante(int id, String nombres, String apellidos, int edad, String carnetIdentidad) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        CarnetIdentidad = carnetIdentidad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCarnetIdentidad() {
        return CarnetIdentidad;
    }

    public void setCarnetIdentidad(String carnetIdentidad) {
        CarnetIdentidad = carnetIdentidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
