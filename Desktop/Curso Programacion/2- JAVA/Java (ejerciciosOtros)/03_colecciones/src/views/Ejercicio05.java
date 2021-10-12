/*
Se requiere un programa que lea y guarde países, y para evitar que se ingresen
repetidos usaremos un conjunto. El programa pedirá un país en un bucle, se
guardará el país en el conjunto y después se le preguntará al usuario si quiere
guardar otro país o si quiere salir, si decide salir, se mostrará todos los países
guardados en el conjunto.
Después deberemos mostrar el conjunto ordenado alfabéticamente para esto
recordar como se ordena un conjunto.
Y por ultimo, al usuario se le pedirá un país y se recorrerá el conjunto con un
Iterator, se buscará el país en el conjunto y si está en el conjunto se eliminará el
país que ingresó el usuario y se mostrará el conjunto. Si el país no se encuentra
en el conjunto se le informará al usuario
 */
package views;

import entidades.Pais;
import java.util.*;
import javax.swing.JOptionPane;

public class Ejercicio05 {

    public static void main(String[] args) {
        //Set<Pais> p = new Set();
        //Set<Pais> p = new HashSet();
        //HashSet<Pais> p = new HashSet();
        TreeSet<Pais> p = new TreeSet();
        Iterator<Pais> it;
        String ingreso, listado;
        boolean esta;
        do {//cargar
            ingreso = JOptionPane.showInputDialog("Ingrese un nombre de pais: ");
            if (!"s".equals(ingreso)) {
                p.add(new Pais(ingreso));
            }
        } while (!"s".equals(JOptionPane.showInputDialog("'s' para salir o continuar ingresando cualquier otra letra")));

        //listado = p.stream().map((pais) -> pais.getNombre() + "\n").reduce(listado, String::concat);
        //mostrar ordenado asc
        //JOptionPane.showMessageDialog(null, listado);
        do {//eliminar pais buscado y volver a mostrar
            listado = "";
            listado = p.stream().map((pais) -> pais.getNombre() + "\n").reduce(listado, String::concat);
            it = p.iterator();
            ingreso = JOptionPane.showInputDialog(listado + "Ingrese un nombre de pais a eliminar, 's' para salir: ");
            esta=false;
            if (!"s".equals(ingreso)) {
                while (it.hasNext()) {
                    Pais pais = it.next();
                    if (pais.getNombre().equals(ingreso)) {
                        JOptionPane.showMessageDialog(null, "Se ha eliminado el pais '" + pais.getNombre()+"'");
                        it.remove();
                        esta=true;
                    }
                }
                if(!esta){//sino esta informar
                    JOptionPane.showMessageDialog(null,"El nombre ingresado no existe");
                }
            }
        } while (!"s".equals(ingreso));

        System.gc();
        System.exit(0);        
    }
}
