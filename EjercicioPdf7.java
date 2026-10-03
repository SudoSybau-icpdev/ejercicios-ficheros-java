package EjerBinarios_IsmaelCano;

import java.io.*;

public class EjercicioPdf7 {
    public static void main(String[] args) {
        File origen = new File("muchosdatos.dat");

        if (!origen.exists()) {
            origen = new File("datospersonas.dat");
        }

        if (!origen.exists()) {
            System.err.println("No se encontró el fichero de origen 'muchosdatos.dat'.");
            return;
        }

        File fMenores = new File("menores.dat");
        File fAdultos = new File("adultos.dat");
        File fMayores = new File("mayores.dat");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(origen));
             ObjectOutputStream oosMenores = new ObjectOutputStream(new FileOutputStream(fMenores));
             ObjectOutputStream oosAdultos = new ObjectOutputStream(new FileOutputStream(fAdultos));
             ObjectOutputStream oosMayores = new ObjectOutputStream(new FileOutputStream(fMayores))) {

            while (true) {
                try {
                    Persona p = (Persona) ois.readObject();
                    if (p.getEdad() < 18) {
                        oosMenores.writeObject(p);
                    } else if (p.getEdad() <= 65) {
                        oosAdultos.writeObject(p);
                    } else {
                        oosMayores.writeObject(p);
                    }
                } catch (EOFException e) {
                    break;
                }
            }
            System.out.println("Proceso de clasificación completado.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error procesando archivos: " + e.getMessage());
        }

        mostrarFicheroPersona("MENORES DE EDAD (<18)", fMenores);
        mostrarFicheroPersona("ADULTOS (18-65)", fAdultos);
        mostrarFicheroPersona("MAYORES DE 65 ANOS", fMayores);
    }

    private static void mostrarFicheroPersona(String titulo, File f) {
        System.out.println("\n=== " + titulo + " ===");
        if (!f.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            while (true) {
                try {
                    Persona p = (Persona) ois.readObject();
                    System.out.println(p);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error leyendo " + f.getName() + ": " + e.getMessage());
        }
    }
}
