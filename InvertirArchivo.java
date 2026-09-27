package EjerciciosJava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvertirArchivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Fichero origen: ");
        String origenPath = sc.nextLine();

        List<String> lineasAlmacenadas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(origenPath))) {
            String temp;
            while ((temp = br.readLine()) != null) {
                lineasAlmacenadas.add(temp);
            }
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo de origen: " + e.getMessage());
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt"))) {
            for (int i = lineasAlmacenadas.size() - 1; i >= 0; i--) {
                bw.write(lineasAlmacenadas.get(i));
                bw.newLine();
            }
            System.out.println("Archivo 'salida.txt' generado exitosamente con el contenido invertido.");
        } catch (IOException e) {
            System.err.println("Error al escribir en 'salida.txt': " + e.getMessage());
        }
    }
}
