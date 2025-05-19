package utils;

public class ValidadorDatos {

    public ResultadoValidacion validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return new ResultadoValidacion(false, "El nombre no puede estar vacío.");
        }
        if (nombre.length() < 3) {
            return new ResultadoValidacion(false, "Debe tener al menos 3 caracteres.");
        }
        if (!nombre.matches("[a-zA-Z ]+")) {
            return new ResultadoValidacion(false, "Solo letras y espacios.");
        }
        return new ResultadoValidacion(true, "");
    }

    public ResultadoValidacion validarNota(double nota) {
        if (nota < 0 || nota > 10) {
            return new ResultadoValidacion(false, "La nota debe estar entre 0 y 10.");
        }
        return new ResultadoValidacion(true, "");
    }

    public ResultadoValidacion validarAsistencia(int asistencia) {
        if (asistencia < 0 || asistencia > 100) {
            return new ResultadoValidacion(false, "La asistencia debe estar entre 0 y 100.");
        }
        return new ResultadoValidacion(true, "");
    }
}
