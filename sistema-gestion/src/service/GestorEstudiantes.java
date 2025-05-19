package service;

import utils.Obtener;
import utils.Mostrar;
import utils.ValidadorDatos;
import utils.ResultadoValidacion;
import model.Estudiante;

public class GestorEstudiantes {
    private final Mostrar mostrar = new Mostrar();
    private final Obtener obtener = new Obtener();
    private final ValidadorDatos validador = new ValidadorDatos();

    public void agregar() {
        String nombre;
        double nota;
        int asistencia;

        // Validar nombre
        while (true) {
            nombre = obtener.obtenerDato("Ingrese el nombre del alumno: ");
            ResultadoValidacion resultado = validador.validarNombre(nombre);
            if (resultado.esValido()) {
                break;
            } else {
                mostrar.mostrarMensaje("Error: " + resultado.getMensaje());
            }
        }

        // Validar nota
        while (true) {
            try {
                nota = Double.parseDouble(obtener.obtenerDato("Ingrese la nota del alumno (0-10): "));
                ResultadoValidacion resultado = validador.validarNota(nota);
                if (resultado.esValido()) {
                    break;
                } else {
                    mostrar.mostrarMensaje("Error: " + resultado.getMensaje());
                }
            } catch (NumberFormatException e) {
                mostrar.mostrarMensaje("Error: ingrese un número decimal válido para la nota.");
            }
        }

        // Validar asistencia
        while (true) {
            try {
                asistencia = Integer.parseInt(obtener.obtenerDato("Ingrese la asistencia del alumno (%): "));
                ResultadoValidacion resultado = validador.validarAsistencia(asistencia);
                if (resultado.esValido()) {
                    break;
                } else {
                    mostrar.mostrarMensaje("Error: " + resultado.getMensaje());
                }
            } catch (NumberFormatException e) {
                mostrar.mostrarMensaje("Error: ingrese un número entero válido para la asistencia.");
            }
        }

        Estudiante estudiante = new Estudiante(nombre, nota, asistencia);
        mostrar.mostrarMensaje("Estudiante agregado: " + estudiante.toJson());
    }

    public static void main(String[] args) {
        GestorEstudiantes gestor = new GestorEstudiantes();
        gestor.agregar();
    }
}
