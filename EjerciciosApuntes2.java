package EjerBinarios_IsmaelCano;

import java.io.*;

public class EjerciciosApuntes2 {
    public static void main(String[] args) {
        String archivo = "alumnos.bin";

        String[] nombres = {"Ana", "Carlos", "Elena", "David", "Beatriz"};
        double[] notas = {8.5, 6.2, 9.4, 7.0, 5.8};

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(archivo))) {
            for (int i = 0; i < 5; i++) {
                dos.writeUTF(nombres[i]);
                dos.writeDouble(notas[i]);
            }
            System.out.println("Datos de alumnos guardados exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(archivo))) {
            System.out.println("\n--- Alumnos Registrados ---");
            while (dis.available() > 0) {
                String nombre = dis.readUTF();
                double nota = dis.readDouble();
                System.out.printf("Alumno: %-10s | Nota Media: %.2f%n", nombre, nota);
            }
        } catch (IOException e) {
            System.err.println("Error al leer: " + e.getMessage());
        }
    }
}
