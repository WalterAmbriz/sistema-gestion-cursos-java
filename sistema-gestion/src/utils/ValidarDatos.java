package utils;

public class ValidarDatos {
    Mostrar mostrar = new Mostrar();

    public boolean esNombreValido(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            mostrar.mostrarMensaje("El nombre no puede estar vacío.");
            return false;
        }
        if (nombre.length() < 3) {
            mostrar.mostrarMensaje("El nombre debe tener al menos 3 caracteres.");
            return false;
        }
        if (!nombre.matches("[a-zA-Z ]+")) {
            mostrar.mostrarMensaje("El nombre solo puede contener letras y espacios.");
            return false;
        }
        return true;
    }

    public boolean esNotaValida(double nota) {
        if (nota < 0 || nota > 10) {
            mostrar.mostrarMensaje("La nota debe estar entre 0 y 10.");
            return false;
        }
        return true;
    }

    public boolean esAsistenciaValida(int asistencia) {
        if (asistencia < 0 || asistencia > 100) {
            mostrar.mostrarMensaje("La asistencia debe estar entre 0 y 100.");
            return false;
        }
        return true;
    }
}
