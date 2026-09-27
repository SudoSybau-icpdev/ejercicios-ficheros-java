package EjerciciosJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ContadorLineasDinamico {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Nombre del archivo a analizar: ");
        String nombreArchivo = in.nextLine();

        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            while (br.readLine() != null) {
                contador++;
            }
            System.out.println("El archivo '" + nombreArchivo + "' consta de " + contador + " líneas.");
        } catch (IOException e) {
            System.err.println("No se pudo leer el archivo: " + e.getMessage());
        }
    }
}