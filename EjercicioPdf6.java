package EjerBinarios_IsmaelCano;

import java.io.*;
import java.util.Scanner;

class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String apellidos;
    private int edad;
    private String telefono;
    private String email;
    private String ciudad;
    private String nacionalidad;
    private String profesion;

    public Persona(String nombre, String apellidos, int edad, String telefono, String email, String ciudad, String nacionalidad, String profesion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
        this.ciudad = ciudad;
        this.nacionalidad = nacionalidad;
        this.profesion = profesion;
    }

    public int getEdad() { return edad; }

    @Override
    public String toString() {
        return String.format("%s %s (%d años) - Tel: %s | Email: %s | %s (%s) - Prof: %s",
                nombre, apellidos, edad, telefono, email, ciudad, nacionalidad, profesion);
    }
}

public class EjercicioPdf6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file = new File("datospersonas.dat");

        System.out.print("¿Número de personas a almacenar?: ");
        int n = sc.nextInt();
        sc.nextLine();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < n; i++) {
                System.out.println("\n--- Persona #" + (i + 1) + " ---");
                System.out.print("Nombre: "); String nom = sc.nextLine();
                System.out.print("Apellidos: "); String ape = sc.nextLine();
                System.out.print("Edad: "); int edad = sc.nextInt(); sc.nextLine();
                System.out.print("Teléfono: "); String tel = sc.nextLine();
                System.out.print("Email: "); String email = sc.nextLine();
                System.out.print("Ciudad: "); String ciudad = sc.nextLine();
                System.out.print("Nacionalidad: "); String nac = sc.nextLine();
                System.out.print("Profesión: "); String prof = sc.nextLine();

                oos.writeObject(new Persona(nom, ape, edad, tel, email, ciudad, nac, prof));
            }
        } catch (IOException e) {
            System.err.println("Error de escritura: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            System.out.println("\n================ LISTADO DE PERSONAS ================");
            while (true) {
                try {
                    Persona p = (Persona) ois.readObject();
                    System.out.println(p);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }
}
