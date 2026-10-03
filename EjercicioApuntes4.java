package EjerBinarios_IsmaelCano;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EjercicioApuntes4 {
    public static void main(String[] args) {
        String archivo = "productos.dat";
        List<Producto> lista = new ArrayList<>();
        lista.add(new Producto("Monitor 27\"", 249.99, 8));
        lista.add(new Producto("Ratón Gamer", 39.90, 25));
        lista.add(new Producto("Alfombrilla XL", 14.50, 40));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(lista);
            System.out.println("Los 3 productos se han guardado correctamente.");
        } catch (IOException e) {
            System.err.println("Error de escritura: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            @SuppressWarnings("unchecked")
            List<Producto> listaRecuperada = (List<Producto>) ois.readObject();
            System.out.println("\n--- Lista de Productos Almacenados ---");
            for (Producto p : listaRecuperada) {
                System.out.println(p);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }
}