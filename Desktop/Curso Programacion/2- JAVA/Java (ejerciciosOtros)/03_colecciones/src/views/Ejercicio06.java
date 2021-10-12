/*
Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos productos que venderemos
y el precio que tendrán. Además, se necesita que la aplicación cuente con las funciones básicas.
Estas las realizaremos en el main. Como, introducir un elemento, modificar su precio, eliminar un producto y mostrar
los productos que tenemos con su precio (Utilizar Hashmap). El HashMap tendrá de llave el nombre del producto y de valor
el precio. Realizar un menú para lograr todas las acciones previamente mencionadas
 */
package views;

import entidades.Producto;
import java.util.*;
import javax.swing.JOptionPane;
import static java.util.Objects.isNull;

public class Ejercicio06 {

    public static void main(String[] args) {
        HashMap<String, Producto> lp = new HashMap();
        String menu, seleccion;
        do {
            menu = "";
            menu += "a- Agregar Productos\n";
            menu += "b- Actualizar Precio de Producto\n";
            menu += "c- Eliminar Producto\n";
            menu += "d- Listar Productos\n";
            menu += "s- Salir\n";
            seleccion = JOptionPane.showInputDialog(menu + "Seleccione una opcion:");
            switch (seleccion) {
                case "a":
                    AgregarProductos(lp);
                    break;
                case "b":
                    ActualizarPrecioProducto(lp);
                    break;
                case "c":
                    EliminarProducto(lp);
                    break;
                case "d":
                    JOptionPane.showMessageDialog(null, ListSortByKey(lp));
                    break;
                case "s":
                    break;
            }
        } while (!seleccion.equals("s"));
        /*
        for (Map.Entry<String, Producto> entry : lp.entrySet()) {
            String key = entry.getKey();
            Producto value = entry.getValue();

        }        
        //lp.remove(lp);//Eliminar
        //lp.replace(nombre, oldValue, newValue);//actualizar
         */
        System.gc();
        System.exit(0);
    }

    public static String ListSortByKey(HashMap<String, Producto> lp) {
        String lista = "";
        TreeMap<String, Producto> sorted = new TreeMap<>();
        sorted.putAll(lp);
        /*
        for (HashMap.Entry<String, Producto> entry : sorted.entrySet()) {
            lista += "Producto: " + entry.getKey() + " | Precio: " + entry.getValue().getValor() + "\n";
        }
         */
        lista = sorted.entrySet().stream().map((entry) -> "Producto: " + entry.getKey() + " | Precio: " + entry.getValue().getValor() + "\n").reduce(lista, String::concat);
        return lista;
    }

    public static void AgregarProductos(HashMap<String, Producto> lp) {
        String nombre;
        float valor;
        do {
            nombre = JOptionPane.showInputDialog(ListSortByKey(lp) + "Ingrese nombre del producto:");
            valor = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio del producto '" + nombre + "'").replaceAll(",","."));
            lp.put(nombre, new Producto(nombre, valor));
        } while (!"s".equals(JOptionPane.showInputDialog("'s' para volver al menu, o continuar agregando presione 'enter")));
    }

    public static void ActualizarPrecioProducto(HashMap<String, Producto> lp) {
        Producto producto_old;
        String nombre;
        float valor;
        do {
            nombre = JOptionPane.showInputDialog("Ingrese nombre del producto");
            producto_old = lp.get(nombre);
            if (!isNull(producto_old)) {
                valor = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio del producto '" + nombre + "'").replaceAll(",","."));
                if (lp.replace(nombre, producto_old, new Producto(nombre, valor))) {
                    JOptionPane.showMessageDialog(null, "Producto '" + nombre + "' actualizado correctamente.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El producto '" + nombre + "' no se encuentra en la lista.");
            }
        } while (!"s".equals(JOptionPane.showInputDialog("'s' para volver al menu, o continuar actualizando presione 'enter")));
    }

    public static void EliminarProducto(HashMap<String, Producto> lp) {
        Producto producto;
        String nombre;
        do {
            nombre = JOptionPane.showInputDialog("Ingrese nombre del producto");
            producto = lp.get(nombre);
            if (!isNull(producto)) {
                if (lp.remove(nombre, producto)) {
                    JOptionPane.showMessageDialog(null, "El producto '" + nombre + "' se elimino correctamente.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El producto '" + nombre + "' no se encuentra en la lista.");
            }
        } while (!"s".equals(JOptionPane.showInputDialog("'s' para volver al menu, o continuar eliminando presione 'enter")));
    }
}
