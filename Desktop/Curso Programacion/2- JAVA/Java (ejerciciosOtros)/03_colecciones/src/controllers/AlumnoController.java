package controllers;

import entidades.Alumno;
import java.util.*;
import javax.swing.JOptionPane;

public class AlumnoController {
    List<Alumno> as = new ArrayList();
    Iterator<Alumno> it;
    public String crearAlumno(){
        String retorno = "",nombre;
        ArrayList<Integer> notas = new ArrayList();
        nombre = JOptionPane.showInputDialog("Ingrese nombre del alumno a crear ('s' para salir): ");
        if(!nombre.equals("s")){
            for (int i = 0; i < 3; i++) {
                notas.add(Integer.parseInt(JOptionPane.showInputDialog("Ingrese nota "+(i+1)+" de 3, del alumno '"+nombre+"': ")));
            }
            as.add(new Alumno(nombre,notas));
        }else{
            retorno = "s";
        }
        return retorno;
    }
    
    public String buscarAlumno(){
        String retorno = "",nombre;
        boolean existe = false;
        nombre = JOptionPane.showInputDialog(this.listadoAlumnos()+"Ingrese nombre del alumno a buscar nota ('s' para salir): ");
        if(!nombre.equals("s")){
            it = as.iterator();
            while (it.hasNext()) {
                Alumno a = it.next();
                if(a.getNombre().equals(nombre)){
                    JOptionPane.showMessageDialog(null,"Nota final del alumno '"+nombre+"': "+a.notaFinal());
                    existe = true;
                }
            }
            if(!existe){
                JOptionPane.showMessageDialog(null,"El alumno '"+nombre+"' no se encuentra en la lista");
            }
        }else{
            retorno = "s";
        }
        return retorno;
    }
    
    public String listadoAlumnos(){
        String retorno = "";
        it = as.iterator();
        while (it.hasNext()) {
            Alumno a = it.next();
            retorno += a.getNombre()+"\n";
        }
        return retorno;
    }
}
