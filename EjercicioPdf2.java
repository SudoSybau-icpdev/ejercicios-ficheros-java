package EjerBinarios_IsmaelCano;

import java.io.*;
import java.util.Scanner;

public class EjercicioPdf2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file = new File("vehiculos.bin");

        System.out.print("¿Cuántos vehículos deseas introducir?: ");
        int n = sc.nextInt();
        sc.nextLine();

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file, true))) {
            for (int i = 0; i < n; i++) {
                System.out.println("\n--- Datos Coche #" + (i + 1) + " ---");
                System.out.print("Matrícula: ");
                String mat = sc.nextLine();
                System.out.print("Marca: ");
                String marca = sc.nextLine();
                System.out.print("Modelo: ");
                String modelo = sc.nextLine();
                System.out.print("Tamaño depósito (L): ");
                double dep = sc.nextDouble();
                sc.nextLine();

                dos.writeUTF(mat);
                dos.writeUTF(marca);
                dos.writeUTF(modelo);
                dos.writeDouble(dep);
            }
        } catch (IOException e) {
            System.err.println("Error de escritura: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            System.out.println("\n================ LISTADO COMPLETO DE VEHÍCULOS ================");
            while (dis.available() > 0) {
                String mat = dis.readUTF();
                String marca = dis.readUTF();
                String modelo = dis.readUTF();
                double dep = dis.readDouble();
                System.out.printf("Matrícula: %-9s | Marca: %-10s | Modelo: %-10s | Depósito: %.1f L%n", mat, marca, modelo, dep);
            }
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }
}
