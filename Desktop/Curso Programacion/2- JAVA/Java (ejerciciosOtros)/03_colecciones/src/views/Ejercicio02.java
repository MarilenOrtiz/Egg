/*
Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le
pedirá un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. 
Si el perro está en la lista, se eliminará el perro que ingresó el usuario y se mostrará
la lista ordenada. Si el perro no se encuentra en la lista, se le informará al usuario
y se mostrará la lista ordenada.

 */
package views;

import controllers.MascotaController;
import javax.swing.JOptionPane;

public class Ejercicio02 {

    public static void main(String[] args) {        
        MascotaController mc = new MascotaController();
        String ingreso, lista, tipo;
        tipo = JOptionPane.showInputDialog("Tipo de mascota a crear (perro/gato/etc..): ");
        do{
            ingreso = mc.crearMascota(tipo);
        }while(!ingreso.equals("s"));
        lista = mc.listaMascotasXRaza(tipo);
        JOptionPane.showMessageDialog(null,tipo.toUpperCase()+"S cargados:\n"+lista);
        do{
            ingreso = mc.seleccionarMascotaAEliminar();
            if(!ingreso.equals("s")){
                mc.eliminarMascotaXNombre(ingreso);
            }
        }while(!ingreso.equals("s"));
        System.gc();
        System.exit(0);
    }
}
