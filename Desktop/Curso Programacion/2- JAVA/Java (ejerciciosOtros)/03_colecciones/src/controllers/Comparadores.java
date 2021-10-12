package controllers;

import entidades.Mascota;
import entidades.Pelicula;
import java.util.Comparator;

public class Comparadores {
//        public static Comparator<Mascota> MascotaPorNombreDesc = new Comparator<Mascota>() {
//            @Override
//            public int compare(Mascota m1, Mascota m2) {
//               return m2.getNombre().compareTo(m1.getNombre());
//            }
//        };
    public static Comparator<Mascota> MascotaPorNombreDesc = (Mascota m1, Mascota m2) -> m2.getNombre().compareTo(m1.getNombre());
    public static Comparator<Mascota> MascotaPorNombreAsc = (Mascota m1, Mascota m2) -> m1.getNombre().compareTo(m2.getNombre());
    
    public static Comparator<Pelicula> PeliculaPorDuracionDesc = (Pelicula p1, Pelicula p2) -> p2.getDuracion().compareTo(p1.getDuracion());
    public static Comparator<Pelicula> PeliculaPorDuracionAsc = (Pelicula p1, Pelicula p2) -> p1.getDuracion().compareTo(p2.getDuracion());
    public static Comparator<Pelicula> PeliculaPorTituloAsc = (Pelicula p1, Pelicula p2) -> p1.getTitulo().compareTo(p2.getTitulo());
    public static Comparator<Pelicula> PeliculaPorDirectorAsc = (Pelicula p1, Pelicula p2) -> p1.getDirector().compareTo(p2.getDirector());
}
