package EjerBinarios_IsmaelCano;

import java.io.*;
import java.util.Scanner;

public class EjercicioPdf3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== INTRODUCIR DATOS BECA ===");
        System.out.print("Nombre y Apellidos: ");
        String nombre = sc.nextLine();
        System.out.print("Sexo (H/M): ");
        char sexo = sc.nextLine().toUpperCase().charAt(0);
        System.out.print("Edad (20-60): ");
        int edad = sc.nextInt();
        System.out.print("Número de suspensos (0-4): ");
        int suspensos = sc.nextInt();
        sc.nextLine();
        System.out.print("Residencia familiar (SI/NO): ");
        String resFam = sc.nextLine().toUpperCase();
        System.out.print("Ingresos anuales de la familia (€): ");
        double ingresos = sc.nextDouble();
        sc.nextLine();
        System.out.print("¿Tiene beca? (SI/NO): ");
        String tieneBeca = sc.nextLine().toUpperCase();

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("datosbeca.bin"))) {
            dos.writeUTF(nombre);
            dos.writeChar(sexo);
            dos.writeInt(edad);
            dos.writeInt(suspensos);
            dos.writeUTF(resFam);
            dos.writeDouble(ingresos);
            dos.writeUTF(tieneBeca);
            System.out.println("\nDatos guardados correctamente en 'datosbeca.bin'.");
        } catch (IOException e) {
            System.err.println("Error de escritura: " + e.getMessage());
        }
    }
}