package EjerciciosJava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ClonadorSinVacias {
    public static void main(String[] args) {
        try (
                BufferedReader in = new BufferedReader(new FileReader("datos.txt"));
                BufferedWriter out = new BufferedWriter(new FileWriter("copia.txt"))
        ) {
            String fila;
            while ((fila = in.readLine()) != null) {
                if (!fila.trim().isEmpty()) {
                    out.write(fila);
                    out.newLine();
                }
            }
            System.out.println("Copia generada excluyendo líneas en blanco.");
        } catch (IOException e) {
            System.err.println("Error en la operación de copia: " + e.getMessage());
        }
    }
}
