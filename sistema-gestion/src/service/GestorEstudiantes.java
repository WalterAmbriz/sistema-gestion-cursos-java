package service;
import utils.Mostrar;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import model.Estudiante;

public class GestorEstudiantes {
    private final Mostrar mostrar = new Mostrar();
    private final List<Estudiante> estudiantes;

    public GestorEstudiantes() {
        this.estudiantes = new ArrayList<>();
    }

    public void agregar(Estudiante estudiante) {
        estudiantes.add(estudiante);
        mostrar.mostrarMensaje("Estudiante agregado: " + estudiante.toJson());
    }

    // Método para agregar un estudiante con nombre, nota y asistencia (Para pruebas)
    // Este método no es necesario en la versión final, pero se deja para pruebas
    public void agregar(String nombre, double nota, int asistencia) {
        Estudiante estudiante = new Estudiante(nombre, nota, asistencia);
        estudiantes.add(estudiante);
    }

    
    public void eliminar(int id) {
        if (estudiantes.isEmpty()) {
            mostrar.mostrarMensaje("No hay estudiantes registrados.");
            return;
        }

        boolean encontrado = false;

        Iterator<Estudiante> iterator = estudiantes.iterator();
        while (iterator.hasNext()) {
            Estudiante estudiante = iterator.next();
            if (estudiante.getId() == id) {
                iterator.remove();
                mostrar.mostrarMensaje("Estudiante eliminado: " + estudiante.toString());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            mostrar.mostrarMensaje("Error: Estudiante no encontrado.");
        }
    }

    public void buscarPorNombre(String nombre) {
        if (estudiantes.isEmpty()) {
            mostrar.mostrarMensaje("No hay estudiantes registrados.");
            return;
        }

        boolean encontrado = false;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().equalsIgnoreCase(nombre)) {
                mostrar.mostrarMensaje(estudiante.toString());
                encontrado = true;
            }
        }
        if (!encontrado) {
            mostrar.mostrarMensaje("Error: Estudiante no encontrado.");
        }
    }

    public void listarTodos() {
        if (estudiantes.isEmpty()) {
            mostrar.mostrarMensaje("No hay estudiantes registrados.");
        } else {
            for (Estudiante estudiante : estudiantes) {
                mostrar.mostrarMensaje(estudiante.toString());
            }
        }
    }

    public void listarAprobados() {
        if (estudiantes.isEmpty()) {
            mostrar.mostrarMensaje("No hay estudiantes registrados.");
        } else {
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.esAprobado()) {
                    mostrar.mostrarMensaje(estudiante.toString());
                }
            }
        }
    }

    public void actualizarNota(int id, double nuevaNota) {
        if (estudiantes.isEmpty()) {
            mostrar.mostrarMensaje("No hay estudiantes registrados.");
            return;
        }

        boolean encontrado = false;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                estudiante.setNota(nuevaNota);
                mostrar.mostrarMensaje("Nota actualizada: " + estudiante.toString());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            mostrar.mostrarMensaje("Error: Estudiante no encontrado.");
        }
    }

    public void actualizarAsistencia(int id, int nuevaAsistencia) {
        if (estudiantes.isEmpty()) {
            mostrar.mostrarMensaje("No hay estudiantes registrados.");
            return;
        }

        boolean encontrado = false;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                estudiante.setAsistencia(nuevaAsistencia);
                mostrar.mostrarMensaje("Asistencia actualizada: " + estudiante.toString());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            mostrar.mostrarMensaje("Error: Estudiante no encontrado.");
        }
    }

    public static void main(String[] args) {
        GestorEstudiantes gestor = new GestorEstudiantes();
        gestor.agregar("Juan Perez", 5.9, 60);
        gestor.agregar("Pedro Martinez", 9.2, 95);
        gestor.agregar("Lucia Torres", 6.5, 70);
        gestor.agregar("Sofia Ramirez", 4.0, 40);
        gestor.agregar("Javier Gomez", 8.0, 85);
        gestor.agregar("Laura Fernandez", 7.5, 75);
        gestor.agregar("Diego Morales", 3.5, 30);
        gestor.agregar("Valentina Ruiz", 9.5, 100);
        gestor.agregar("Maria Lopez", 7.0, 80);
        gestor.agregar("Carlos Sanchez", 4.5, 50);
        gestor.agregar("Ana Garcia", 8.5, 90);

        gestor.listarTodos();
        System.out.println("Listar estudiantes aprobados:");
        gestor.listarAprobados();
        System.out.println("Buscando estudiante por nombre:");
        gestor.buscarPorNombre("Juan Perez");
        
    }
}
