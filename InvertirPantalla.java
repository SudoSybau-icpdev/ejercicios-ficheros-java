package EjerciciosJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvertirPantalla {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Fichero a leer: ");
        String path = sc.nextLine();

        List<String> filas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String texto;
            while ((texto = reader.readLine()) != null) {
                filas.add(texto);
            }

            System.out.println("\nLíneas totales: " + filas.size());
            System.out.println("--- Orden inverso ---");
            for (int i = filas.size() - 1; i >= 0; i--) {
                System.out.println(filas.get(i));
            }
        } catch (IOException e) {
            System.err.println("Error de acceso al fichero: " + e.getMessage());
        }
    }
}
