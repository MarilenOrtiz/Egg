package controllers;

import entidades.Pelicula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class PeliculaController {

    ArrayList<Pelicula> lp = new ArrayList();
    Iterator<Pelicula> it;

    public void crearPelicula() {
        String titulo = JOptionPane.showInputDialog("Ingrese titulo de la pelicula:");
        String director = JOptionPane.showInputDialog("Ingrese nombre del director de la pelicula:");
        Integer duracion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese horas de duracion de la pelicula:"));
        lp.add(new Pelicula(titulo, director, duracion));
    }

    public void listaPeliculasCargadas() {
        String listado = "";
        it = lp.iterator();
        while (it.hasNext()) {
            Pelicula p = it.next();
            listado = listado + p.getTitulo() + "\n";
        }
        JOptionPane.showMessageDialog(null, listado);
    }

    public void listaPeliculasDuracionMayorUnaHora() {
        String listado = "";
        it = lp.iterator();
        while (it.hasNext()) {
            Pelicula p = it.next();
            if (p.getDuracion() > 1) {
                listado = listado + p.getTitulo() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, listado);
    }

    public void listaPeliculasDuracionDesc() {
        String listado = "";
        Collections.sort(lp, Comparadores.PeliculaPorDuracionDesc);
        it = lp.iterator();
        while (it.hasNext()) {
            Pelicula p = it.next();
            listado = listado + p.getTitulo() + " | Duracion("+p.getDuracion()+"hs.)\n";
        }
        JOptionPane.showMessageDialog(null, listado);
    }

    public void listaPeliculasDuracionAsc() {
        String listado = "";
        Collections.sort(lp, Comparadores.PeliculaPorDuracionAsc);
        it = lp.iterator();
        while (it.hasNext()) {
            Pelicula p = it.next();
            listado = listado + p.getTitulo() + " | Duracion("+p.getDuracion()+"hs.)\n";
        }
        JOptionPane.showMessageDialog(null, listado);
    }
    
    public void listaPeliculasPorTituloAsc() {
        String listado = "";
        Collections.sort(lp, Comparadores.PeliculaPorTituloAsc);
        it = lp.iterator();
        while (it.hasNext()) {
            Pelicula p = it.next();
            listado = listado + p.getTitulo() + " | Director("+p.getDirector()+")\n";
        }
        JOptionPane.showMessageDialog(null, listado);
    }
    
    public void listaPeliculasPorDirectorAsc() {
        String listado = "";
        Collections.sort(lp, Comparadores.PeliculaPorDirectorAsc);
        it = lp.iterator();
        while (it.hasNext()) {
            Pelicula p = it.next();
            listado = listado + p.getDirector() + " | Titulo("+p.getTitulo()+")\n";
        }
        JOptionPane.showMessageDialog(null, listado);
    }
}
