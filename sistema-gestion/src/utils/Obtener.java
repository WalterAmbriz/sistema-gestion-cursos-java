package utils;
import java.util.Scanner;
public class Obtener {
    Scanner s = new Scanner(System.in);
    public String obtenerDato(String mensaje) {
        System.out.print(mensaje);
        return s.nextLine();
    }
}
