package EjerBinarios_IsmaelCano;

import java.io.*;
import java.util.Scanner;

public class EjercicioPdf4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file = new File("datosbeca.bin");

        System.out.print("¿Cuántos becarios vas a registrar?: ");
        int n = sc.nextInt();
        sc.nextLine();

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file, true))) {
            for (int i = 0; i < n; i++) {
                System.out.println("\n--- Becario #" + (i + 1) + " ---");
                System.out.print("Nombre y Apellidos: ");
                String nombre = sc.nextLine();
                System.out.print("Sexo (H/M): ");
                char sexo = sc.nextLine().toUpperCase().charAt(0);
                System.out.print("Edad: ");
                int edad = sc.nextInt();
                System.out.print("Número de suspensos: ");
                int suspensos = sc.nextInt();
                sc.nextLine();
                System.out.print("Residencia familiar (SI/NO): ");
                String resFam = sc.nextLine().toUpperCase();
                System.out.print("Ingresos anuales: ");
                double ingresos = sc.nextDouble();
                sc.nextLine();
                System.out.print("¿Tiene beca? (SI/NO): ");
                String tieneBeca = sc.nextLine().toUpperCase();

                dos.writeUTF(nombre);
                dos.writeChar(sexo);
                dos.writeInt(edad);
                dos.writeInt(suspensos);
                dos.writeUTF(resFam);
                dos.writeDouble(ingresos);
                dos.writeUTF(tieneBeca);
            }
        } catch (IOException e) {
            System.err.println("Error al escribir: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            System.out.println("\n================ LISTADO COMPLETO DE BECARIOS ================");
            while (dis.available() > 0) {
                String nombre = dis.readUTF();
                char sexo = dis.readChar();
                int edad = dis.readInt();
                int susp = dis.readInt();
                String resFam = dis.readUTF();
                double ingresos = dis.readDouble();
                String tieneBeca = dis.readUTF();

                System.out.printf("Nombre: %-20s | Sexo: %c | Edad: %2d | Susp: %d | Res.Fam: %-2s | Ingresos: %8.2f€ | Beca: %s%n",
                        nombre, sexo, edad, susp, resFam, ingresos, tieneBeca);
            }
        } catch (IOException e) {
            System.err.println("Error al leer: " + e.getMessage());
        }
    }
}
