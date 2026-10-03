package EjerBinarios_IsmaelCano;

import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

public class EjercicioPdf8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el día de septiembre a filtrar (1-30): ");
        int diaBuscado = sc.nextInt();

        String diaStr = String.format("%02d", diaBuscado);
        File fTexto = new File("temperaturas.txt");
        File fBinario = new File("Septemp.dat");

        if (!fTexto.exists()) {
            System.err.println("No se encuentra el fichero 'temperaturas.txt'.");
            return;
        }

        Pattern pattern = Pattern.compile("Día (\\d+), Hora (\\d{2}:\\d{2}), Temperatura (\\d+)°C");

        try (BufferedReader br = new BufferedReader(new FileReader(fTexto));
             DataOutputStream dos = new DataOutputStream(new FileOutputStream(fBinario))) {

            String linea;
            int registrosGuardados = 0;

            while ((linea = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(linea);
                if (matcher.find()) {
                    String dia = matcher.group(1);
                    if (dia.equals(diaStr)) {
                        String hora = matcher.group(2);
                        int temp = Integer.parseInt(matcher.group(3));

                        dos.writeInt(Integer.parseInt(dia));
                        dos.writeUTF(hora);
                        dos.writeInt(temp);
                        registrosGuardados++;
                    }
                }
            }
            System.out.printf("Se han guardado %d registros del día %s en 'Septemp.dat'.%n", registrosGuardados, diaStr);
        } catch (IOException e) {
            System.err.println("Error en el procesamiento: " + e.getMessage());
        }
    }
}
