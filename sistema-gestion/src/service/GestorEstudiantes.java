package service;

import utils.Obtener;
import utils.Mostrar;
import utils.ValidadorDatos;
import utils.ResultadoValidacion;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import model.Estudiante;

public class GestorEstudiantes {
    private final Mostrar mostrar = new Mostrar();
    private final Obtener obtener = new Obtener();
    private final ValidadorDatos validador = new ValidadorDatos();
    private final List<Estudiante> estudiantes;

    public GestorEstudiantes() {
        this.estudiantes = new ArrayList<>();
    }

    public void agregar() {
        String nombre;
        double nota;
        int asistencia;

        // Validar nombre
        while (true) {
            nombre = obtener.obtenerDato("Ingrese el nombre del alumno: ");
            ResultadoValidacion resultado = validador.validarNombre(nombre);
            if (resultado.esValido()) break;
            mostrar.mostrarMensaje("Error: " + resultado.getMensaje());
        }

        // Validar nota
        while (true) {
            try {
                nota = Double.parseDouble(obtener.obtenerDato("Ingrese la nota del alumno (0-10): "));
                ResultadoValidacion resultado = validador.validarNota(nota);
                if (resultado.esValido()) break;
                mostrar.mostrarMensaje("Error: " + resultado.getMensaje());
            } catch (NumberFormatException e) {
                mostrar.mostrarMensaje("Error: ingrese un número decimal válido para la nota.");
            }
        }

        // Validar asistencia
        while (true) {
            try {
                asistencia = Integer.parseInt(obtener.obtenerDato("Ingrese la asistencia del alumno (%): "));
                ResultadoValidacion resultado = validador.validarAsistencia(asistencia);
                if (resultado.esValido()) break;
                mostrar.mostrarMensaje("Error: " + resultado.getMensaje());
            } catch (NumberFormatException e) {
                mostrar.mostrarMensaje("Error: ingrese un número entero válido para la asistencia.");
            }
        }

        Estudiante estudiante = new Estudiante(nombre, nota, asistencia);
        estudiantes.add(estudiante);
        mostrar.mostrarMensaje("Estudiante agregado: " + estudiante.toJson());
    }

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

    public static void main(String[] args) {
        GestorEstudiantes gestor = new GestorEstudiantes();
        gestor.agregar("Juan Perez", 5.9, 60);
        gestor.agregar("Maria Lopez", 7.0, 80);
        gestor.agregar("Carlos Sanchez", 4.5, 50);
        gestor.agregar("Ana Garcia", 8.5, 90);
        gestor.listarTodos();
        // gestor.eliminar(3);
        gestor.listarTodos();
        gestor.listarAprobados();
    }
}
