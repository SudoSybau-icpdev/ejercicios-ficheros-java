package EjerciciosJava;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GuardarFrases {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String ficheroDestino = "frases_usuario.txt";

        System.out.println("Escribe las frases deseadas (pulse ENTER en vacío para finalizar):");

        try (PrintWriter escritor = new PrintWriter(new FileWriter(ficheroDestino, true))) {
            while (true) {
                System.out.print("-> ");
                String entrada = teclado.nextLine();
                if (entrada.isEmpty()) {
                    break;
                }
                escritor.println(entrada);
            }
            System.out.println("Información almacenada en " + ficheroDestino);
        } catch (IOException e) {
            System.err.println("Excepción al escribir datos: " + e.getMessage());
        }
    }
}
