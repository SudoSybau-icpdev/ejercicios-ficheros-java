package EjerciciosJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContadorLineasBase {
    public static void main(String[] args) {
        int totalLineas = 0;
        try (BufferedReader lector = new BufferedReader(new FileReader("datos.txt"))) {
            while (lector.readLine() != null) {
                totalLineas++;
            }
            System.out.println("Número total de líneas registradas: " + totalLineas);
        } catch (IOException e) {
            System.err.println("Error durante la lectura de datos.txt: " + e.getMessage());
        }
    }
}