package model;

public class Estudiante {
    private static int contadorId = 0; // contador estático para autogenerar IDs
    private int id = 0;
    private String nombre;
    private double nota;
    private int asistencia;

    // Constructor
    public Estudiante(String nombre, double nota, int asistencia) {
        setId(); // asigna un ID único al estudiante
        setNombre(nombre);
        setNota(nota);
        setAsistencia(asistencia);
    }

    public void setId () {
        this.id = ++contadorId; // incrementa el contador y asigna el nuevo ID  
    }
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }
    public void setNota (double nota) {
        this.nota = nota;
    }
    public void setAsistencia (int asistencia) {
        this.asistencia = asistencia;
    }

    public int getId () {
        return id;
    }
    public String getNombre () {
        return nombre;
    }
    public double getNota () {
        return nota;
    }
    public int getAsistencia () {
        return asistencia;
    }

    public boolean esAprobado () {
        return (this.nota >= 6 && this.asistencia >= 75);
    }

    public String toString () {
        return "{" +
                "id= " + id +
                ", nombre= " + nombre + '\'' +
                ", nota= " + nota +
                ", asistencia= " + asistencia +
                '}';
    }

    public String toJson () {
        return "  {\n" +
                "    \"id\": " + id + ",\n" +
                "    \"nombre\": \"" + nombre + "\",\n" +
                "    \"nota\": " + nota + ",\n" +
                "    \"asistencia\": " + asistencia + ",\n" +
                "    \"esAprobado\": " + esAprobado() + "\n" +
                "  }";
    }    
}