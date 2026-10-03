package EjerBinarios_IsmaelCano;

import java.io.*;

public class EjercicioPdf5 {
    public static void main(String[] args) {
        File file = new File("datosbeca.bin");

        if (!file.exists()) {
            System.err.println("El archivo 'datosbeca.bin' no existe. Ejecuta el Ejercicio 4 primero.");
            return;
        }

        System.out.println("================ CÁLCULO DE CUANTÍAS DE BECA ================");

        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            while (dis.available() > 0) {
                String nombre = dis.readUTF();
                char sexo = dis.readChar();
                int edad = dis.readInt();
                int suspensos = dis.readInt();
                String resFam = dis.readUTF();
                double ingresos = dis.readDouble();
                String tieneBeca = dis.readUTF();

                if (suspensos >= 2 || tieneBeca.equalsIgnoreCase("NO")) {
                    continue;
                }

                double cuantia = 1500; // Base fija

                if (ingresos <= 12000) {
                    cuantia += 500;
                }

                if (edad < 23) {
                    cuantia += 200;
                }

                if (suspensos == 0) {
                    cuantia += 500;
                } else if (suspensos == 1) {
                    cuantia += 200;
                }

                if (resFam.equalsIgnoreCase("NO")) {
                    cuantia += 1000;
                }

                System.out.printf("Becario: %-25s | Cuantía Total: %.2f €%n", nombre, cuantia);
            }
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }
}
