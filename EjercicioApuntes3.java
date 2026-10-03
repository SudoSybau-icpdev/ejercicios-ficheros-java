package EjerBinarios_IsmaelCano;

import java.io.*;

class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("Producto: %-12s | Precio: %6.2f € | Stock: %d uds", nombre, precio, stock);
    }
}

public class EjercicioApuntes3 {
    public static void main(String[] args) {
        String archivo = "producto.dat";
        Producto p = new Producto("Teclado Mecánico", 79.99, 15);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(p);
            System.out.println("Objeto Producto guardado.");
        } catch (IOException e) {
            System.err.println("Error al serializar: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            Producto rec = (Producto) ois.readObject();
            System.out.println("\n--- Objeto Recuperado ---");
            System.out.println(rec);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar: " + e.getMessage());
        }
    }
}