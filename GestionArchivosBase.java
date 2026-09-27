package EjerciciosJava;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GestionArchivosBase {
    public static void main(String[] args) {
        // 1. Crear directorio 'copias'
        File carpeta = new File("copias");
        if (carpeta.exists()) {
            System.out.println("El directorio '" + carpeta.getName() + "' ya existe.");
        } else {
            if (carpeta.mkdir()) {
                System.out.println("Carpeta '" + carpeta.getName() + "' creada con éxito.");
            }
        }

        // 2. Crear archivo 'config.txt' dentro del directorio
        File archivoCfg = new File(carpeta, "config.txt");
        if (archivoCfg.exists()) {
            System.out.println("El archivo '" + archivoCfg.getName() + "' ya existe en el sistema.");
        } else {
            try (FileWriter writer = new FileWriter(archivoCfg)) {
                writer.write("# Configuracion inicial\n");
                System.out.println("Fichero '" + archivoCfg.getName() + "' generado correctamente.");
            } catch (IOException e) {
                System.err.println("Excepción al crear el archivo: " + e.getMessage());
            }
        }

        // 3. Listar contenido de la carpeta
        System.out.println("\n--- Elementos dentro de '" + carpeta.getName() + "' ---");
        File[] lista = carpeta.listFiles();
        if (lista != null) {
            for (File item : lista) {
                String categoria = item.isDirectory() ? "Directorio" : "Fichero";
                System.out.println(" -> " + item.getName() + " [" + categoria + "]");
            }
        }
    }
}
