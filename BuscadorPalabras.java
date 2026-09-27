package EjerciciosJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BuscadorPalabras {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese la palabra clave a buscar: ");
        String objetivo = entrada.nextLine().trim().toLowerCase();
        int coincidencias = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("datos.txt"))) {
            String lineaTexto;
            while ((lineaTexto = reader.readLine()) != null) {
                if (lineaTexto.toLowerCase().contains(objetivo)) {
                    coincidencias++;
                }
            }
            System.out.println("La palabra '" + objetivo + "' aparece en " + coincidencias + " línea(s).");
        } catch (IOException e) {
            System.err.println("Error al procesar el archivo datos.txt: " + e.getMessage());
        }
    }
}
