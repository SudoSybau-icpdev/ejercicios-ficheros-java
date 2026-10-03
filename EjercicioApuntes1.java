package EjerBinarios_IsmaelCano;

import java.io.*;

public class EjercicioApuntes1 {
    public static void main(String[] args) {
        String archivo = "enteros.bin";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(archivo))) {
            for (int i = 1; i <= 50; i++) {
                dos.writeInt(i);
            }
            System.out.println("Archivo binario creado correctamente.");
        } catch (IOException e) {
            System.err.println("Error de escritura: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(archivo))) {
            System.out.println("--- Contenido del archivo ---");
            while (dis.available() > 0) {
                System.out.print(dis.readInt() + " ");
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }
}
