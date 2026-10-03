package EjerBinarios_IsmaelCano;

import java.io.*;

public class EjercicioPdf10 {
    public static void main(String[] args) {
        File fOriginal = new File("nominas.dat");
        File fTemporal = new File("nominas_temp.dat");

        if (!fOriginal.exists()) {
            crearNominasPrueba(fOriginal);
        }

        int eliminados = 0;

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fOriginal));
             DataOutputStream dos = new DataOutputStream(new FileOutputStream(fTemporal))) {

            while (dis.available() > 0) {
                String nombre = dis.readUTF();
                int diasBaja = dis.readInt();
                double nomina = dis.readDouble();

                if (diasBaja == 0) {
                    nomina *= 1.05;
                    dos.writeUTF(nombre);
                    dos.writeInt(diasBaja);
                    dos.writeDouble(nomina);
                } else if (diasBaja >= 1 && diasBaja <= 3) {
                    dos.writeUTF(nombre);
                    dos.writeInt(diasBaja);
                    dos.writeDouble(nomina);
                } else if (diasBaja >= 4 && diasBaja <= 10) {
                    nomina *= 0.90;
                    dos.writeUTF(nombre);
                    dos.writeInt(diasBaja);
                    dos.writeDouble(nomina);
                } else {
                    eliminados++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al procesar las nóminas: " + e.getMessage());
        }

        if (fOriginal.delete()) {
            fTemporal.renameTo(fOriginal);
        }

        System.out.println("================ NÓMINAS ACTUALIZADAS ================");
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fOriginal))) {
            while (dis.available() > 0) {
                String nombre = dis.readUTF();
                int diasBaja = dis.readInt();
                double nomina = dis.readDouble();
                System.out.printf("Empleado: %-15s | Días baja: %2d | Nómina: %8.2f €%n", nombre, diasBaja, nomina);
            }
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }

        System.out.println("------------------------------------------------------");
        System.out.println("Empleados dados de baja del fichero: " + eliminados);
    }

    private static void crearNominasPrueba(File f) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(f))) {
            dos.writeUTF("Juan Pérez"); dos.writeInt(0); dos.writeDouble(2000.0);
            dos.writeUTF("María Gómez"); dos.writeInt(2); dos.writeDouble(2200.0);
            dos.writeUTF("Carlos Ruiz"); dos.writeInt(5); dos.writeDouble(1800.0);
            dos.writeUTF("Laura Sanz"); dos.writeInt(12); dos.writeDouble(2500.0);
        } catch (IOException e) {
            System.err.println("Error creando datos de prueba: " + e.getMessage());
        }
    }
}
