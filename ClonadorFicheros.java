package EjerciciosJava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ClonadorFicheros {
    public static void main(String[] args) {
        try (
                BufferedReader origen = new BufferedReader(new FileReader("datos.txt"));
                BufferedWriter destino = new BufferedWriter(new FileWriter("copia.txt"))
        ) {
            String contenido;
            while ((contenido = origen.readLine()) != null) {
                destino.write(contenido);
                destino.newLine();
            }
            System.out.println("Proceso de duplicado finalizado con éxito.");
        } catch (IOException e) {
            System.err.println("Fallo al duplicar datos: " + e.getMessage());
        }
    }
}
