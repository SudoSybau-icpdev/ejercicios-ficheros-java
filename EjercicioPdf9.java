package EjerBinarios_IsmaelCano;

import java.io.*;

public class EjercicioPdf9 {
    public static void main(String[] args) {
        File file = new File("Septemp.dat");

        if (!file.exists()) {
            System.err.println("El fichero 'Septemp.dat' no existe. Ejecuta el Ejercicio 8 primero.");
            return;
        }

        int maxTemp = Integer.MIN_VALUE;
        int minTemp = Integer.MAX_VALUE;
        String horaMasCalurosa = "";
        String horaMasFria = "";
        int sumaTemp = 0;
        int contador = 0;
        int dia = 0;

        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            while (dis.available() > 0) {
                dia = dis.readInt();
                String hora = dis.readUTF();
                int temp = dis.readInt();

                sumaTemp += temp;
                contador++;

                if (temp > maxTemp) {
                    maxTemp = temp;
                    horaMasCalurosa = hora;
                }
                if (temp < minTemp) {
                    minTemp = temp;
                    horaMasFria = hora;
                }
            }

            if (contador > 0) {
                double media = (double) sumaTemp / contador;
                System.out.println("================ ESTADÍSTICAS DEL DÍA " + dia + " DE SEPTIEMBRE ================");
                System.out.printf("Temperatura Máxima : %d °C (a las %s)%n", maxTemp, horaMasCalurosa);
                System.out.printf("Temperatura Mínima : %d °C (a las %s)%n", minTemp, horaMasFria);
                System.out.printf("Temperatura Media  : %.2f °C%n", media);
            }
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }
}
