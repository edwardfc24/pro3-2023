package dao;

public class Estudiante {
    public String nombre;
    public String apellido;
    public int edad;
    public String carnetId;

    public Estudiante(String nombre, String apellido, int edad,String carnetId){
        this.nombre= nombre;
        this.apellido= apellido;
        this.edad= edad;
        this.carnetId= carnetId;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCarnetId() {
        return carnetId;
    }

    public void setCarnetId(String carnetId) {
        this.carnetId = carnetId;
    }
}
