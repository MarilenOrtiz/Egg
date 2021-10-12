package controllers;

import entidades.Mascota;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class MascotaController {
    ArrayList<Mascota> rm = new ArrayList();
    Iterator<Mascota> it;    
    Mascota m;
    String nombre,raza;
    public String crearMascota(String tipo){
            String retorno = "";
            nombre = JOptionPane.showInputDialog("Ingrese nombre de la mascota, 's' para salir: ");
            if(!nombre.equals("s")){
                raza = JOptionPane.showInputDialog("Ingrese nombre de Raza, 's' para salir: ");
                if(!raza.equals("s")){
                    rm.add(new Mascota(nombre,raza,tipo));
                }else{
                    retorno = "s";
                }
            }else{
                retorno = "s";
            }
            return retorno;
    }
    public String listaMascotasXRaza(String tipo){
        String listado = "";
        it = rm.iterator();
        while (it.hasNext()) {
            m = it.next();
            if(tipo.equals(m.getTipo())){
                listado = listado + "Nombre: " + m.getNombre()+" Raza: "+m.getRaza()+"\n";
            }
        }
        return listado+"\nCantidad creada: "+rm.size();
    }
    public String seleccionarMascotaAEliminar(){
        String listado="",nombre_local;
        Collections.sort(rm, Comparadores.MascotaPorNombreAsc);
        it = rm.iterator();
        while (it.hasNext()) {
            m = it.next();
            listado = listado + "Nombre: " + m.getNombre()+" Raza: "+m.getRaza()+"\n";
        }
        nombre_local = JOptionPane.showInputDialog(listado+"Ingrese nombre de mascota a eliminar, 's' para salir: ");
        return nombre_local;
    }
    public void eliminarMascotaXNombre(String nombre){
        it = rm.iterator();
        boolean esta=false;
        while (it.hasNext()) {
            m = it.next();
            if(m.getNombre().equals(nombre)){
                JOptionPane.showMessageDialog(null,"Se ha eliminado a '"+m.getNombre()+"' raza: "+m.getRaza()+" tipo: "+m.getTipo());
                it.remove();
                esta=true;
            }
        }
        if(!esta){
            JOptionPane.showMessageDialog(null,"El nombre ingresado no existe");
        }
    }
    public void eliminarMascotaXNombre2(String nombre){
        boolean esta=false;
        for (int i = 0; i < rm.size()-1; i++) {
            m = rm.get(i);
            if(m.getNombre().equals(nombre)){
                rm.remove(i);
                esta=true;
            }
        }
        if(!esta){
            JOptionPane.showMessageDialog(null,"El nombre ingresado no existe");
        }
    }
    public void actualizar(int posicion){
        if(posicion <= rm.size()-1){
            rm.set(posicion,new Mascota(nombre,raza,raza));
        }else{
            JOptionPane.showMessageDialog(null,"Error de indice al actualizar");
        }
    }
    public void eliminar(int posicion){
        if(posicion <= rm.size()-1){
            rm.remove(posicion);
        }else{
            JOptionPane.showMessageDialog(null,"Error de indice al eliminar");
        }
    }    
}
