/*
En el main deberemos tener un bucle que crea un objeto Alumno. Se pide toda la
información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
pregunta al usuario si quiere crear otro Alumno o no. 
Despues de ese bluce tendremos el siguiente método en la clase Alumno: 
Metodo notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular
su nota final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al
método. Dentro del método se usará la lista notas para calcular el promedio final
de alumno. Siendo este promedio final, devuelto por el método y mostrado en el
main. 
 */
package views;

import controllers.AlumnoController;

public class Ejercicio03 {

    public static void main(String[] args) {
        AlumnoController ac = new AlumnoController();
        String resultado;
        do{
            resultado = ac.crearAlumno();
        }while(!resultado.equals("s"));
        do{
            resultado = ac.buscarAlumno();
        }while(!resultado.equals("s"));
        System.gc();
        System.exit(0);
    }
    
}
