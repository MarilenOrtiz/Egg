//Crear una clase llamada Alumno que mantenga información sobre las notas de distintos alumnos. 
//La clase Alumno tendrá como atributos, su nombre y una lista de tipo Integer con sus 3 notas.

package entidades;

import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private ArrayList<Integer> notas = new ArrayList();

    public Alumno(String nombre, ArrayList<Integer> notas) {
        this.nombre = nombre;
        this.notas = notas;
    }

    public void setNota(Integer nota) {
        this.notas.add(nota);
    }
    
    public Integer getNota(int indice) {
        return this.notas.get(indice);
    }

    public ArrayList<Integer> getNotas() {
        return notas;
    }
    
    public void setNotas(ArrayList<Integer> notas) {
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public float notaFinal(){
        Integer sumatoria=0;
        int cantidad = notas.size();
        sumatoria = notas.stream().map((nota) -> nota).reduce(sumatoria, Integer::sum);
        return Math.round(sumatoria/cantidad);
    }
}
