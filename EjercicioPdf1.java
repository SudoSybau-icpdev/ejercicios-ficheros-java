package EjerBinarios_IsmaelCano;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class EjercicioPdf1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file = new File("num_aleat.bin");

        System.out.print("Cantidad de números a generar: ");
        int cant = sc.nextInt();
        System.out.print("Límite inferior del rango: ");
        int min = sc.nextInt();
        System.out.print("Límite superior del rango: ");
        int max = sc.nextInt();

        Random rand = new Random();

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file, true))) {
            for (int i = 0; i < cant; i++) {
                int num = rand.nextInt((max - min) + 1) + min;
                dos.writeInt(num);
            }
        } catch (IOException e) {
            System.err.println("Error al escribir: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            System.out.println("\n--- Contenido acumulado en 'num_aleat.bin' ---");
            while (dis.available() > 0) {
                System.out.print(dis.readInt() + " ");
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println("Error al leer: " + e.getMessage());
        }
    }
}