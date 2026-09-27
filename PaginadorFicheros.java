package EjerciciosJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PaginadorFicheros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la ruta/nombre del fichero: ");
        String ruta = sc.nextLine();

        try (BufferedReader lector = new BufferedReader(new FileReader(ruta))) {
            String linea;
            int numLinea = 0;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
                numLinea++;
                if (numLinea % 24 == 0) {
                    System.out.print("\n[Pausa - Pulsa ENTER para continuar]");
                    sc.nextLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }
}
