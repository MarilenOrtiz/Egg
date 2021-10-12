/*
Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo
String. El programa pedirá una raza de perro en un bucle, el mismo se guardará
en la lista y después se le preguntará al usuario si quiere guardar otro perro o si
quiere salir. Si decide salir, se mostrará todos los perros guardados en el ArrayList.
 */
package views;

import controllers.MascotaController;
import javax.swing.JOptionPane;

public class Ejercicio01 {

    public static void main(String[] args) {
        MascotaController mc = new MascotaController();
        String ingreso, lista, tipo;
        tipo = JOptionPane.showInputDialog("Tipo de mascota a crear (perro/gato/etc..): ");
        do{
            ingreso = mc.crearMascota(tipo);
        }while(!ingreso.equals("s"));
        lista = mc.listaMascotasXRaza(tipo);
        JOptionPane.showMessageDialog(null,tipo.toUpperCase()+"S cargados:\n"+lista);
        System.gc();
        System.exit(0);
    }
    
}
