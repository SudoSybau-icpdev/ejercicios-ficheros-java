package EjerciciosJava;

import java.io.File;

public class BorradoArchivos {
    public static void main(String[] args) {
        File dirCopias = new File("copias");
        File docConfig = new File(dirCopias, "config.txt");

        // Borrar el archivo
        if (docConfig.exists()) {
            if (docConfig.delete()) {
                System.out.println("El fichero " + docConfig.getName() + " ha sido eliminado.");
            } else {
                System.out.println("No se pudo borrar el archivo.");
            }
        } else {
            System.out.println("El fichero " + docConfig.getName() + " no existe.");
        }

        // Intentar borrar la carpeta
        if (dirCopias.exists()) {
            if (dirCopias.delete()) {
                System.out.println("Directorio " + dirCopias.getName() + " borrado con éxito.");
            } else {
                System.out.println("Error: No se pudo eliminar la carpeta " + dirCopias.getName());
            }
        }
    }
}
