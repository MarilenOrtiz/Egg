/*
Un cine necesita implementar un sistema en el que se puedan cargar peliculas. 
Para esto, tendremos una clase Pelicula con el titulo, director y duración de la
película (en horas). Implemente las clases y métodos necesarios para esta
situación, teniendo en cuenta lo que se pide a continuación:
En el main deberemos tener un bucle que crea un objeto Pelicula pidiéndole al
usuario todos sus datos y guardándolos en el objeto Pelicula.
Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario
si quiere crear otra Pelicula o no.
Después de ese bucle realizaremos las siguientes acciones:

•a- Mostrar en pantalla todas las películas.
•b- Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
•c- Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo
en pantalla.
•d- Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo
en pantalla.
•e- Ordenar las películas por titulo, alfabéticamente y mostrarlo en pantalla.
•f- Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.

Nota: recordar el uso del Comparator para ordenar colecciones con objetos
 */
package views;

import controllers.PeliculaController;
import javax.swing.JOptionPane;

public class Ejercicio04 {

    public static void main(String[] args) {
        PeliculaController pc = new PeliculaController();
        String menu,seleccion;
        do{
            pc.crearPelicula();
        }while(!"s".equals(JOptionPane.showInputDialog("'s' para salir o continuar ingresando cualquier otra letra")));
        do{
            menu="";
            menu += "a- Listar películas cargadas.\n";
            menu += "b- Listar películas con una duración mayor a 1 hora.\n";
            menu += "c- Listar películas de acuerdo a su duración (de mayor a menor).\n";
            menu += "d- Listar películas de acuerdo a su duración (de menor a mayor).\n";
            menu += "e- Listar películas ordenado alfabéticamente por titulo.\n";
            menu += "f- Listar películas ordenado alfabéticamente por director.\n";
            menu += "s- Salir.\n";
            seleccion = JOptionPane.showInputDialog("MENU:\n"+menu);
            switch(seleccion){
                case "a":pc.listaPeliculasCargadas();break;
                case "b":pc.listaPeliculasDuracionMayorUnaHora();break;
                case "c":pc.listaPeliculasDuracionDesc();break;
                case "d":pc.listaPeliculasDuracionAsc();break;
                case "e":pc.listaPeliculasPorTituloAsc();break;
                case "f":pc.listaPeliculasPorDirectorAsc();break;
                case "s":break;
                default: JOptionPane.showMessageDialog(null,"Seleccion Incorrecta");break;
            }        
        }while(!"s".equals(seleccion));
        System.gc();
        System.exit(0);
    }
    
}
