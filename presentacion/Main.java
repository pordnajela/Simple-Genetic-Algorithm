package presentacion;

import java.util.Scanner;
import logica.Busqueda.AlgoritmoGenetico;
import logica.Busqueda.AlgoritmoGenetico_Simple;
import logica.Operadores.Cruce.*;
import logica.Operadores.Mutacion.*;
import logica.Operadores.Seleccion.*;
import logica.problema.nReinas;
import logica.problema.Problema;

/**
 *
 * @author sperez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int numeroReinas;
        int numeroIteraciones;
        int tamanioPoblacion;
        System.out.println("Introduzca el numero de iteraciones: ");
        numeroIteraciones=sc.nextInt();
        System.out.println("Introduzca el numero de reinas: ");
        numeroReinas=sc.nextInt();
        System.out.println("Introduzca la cantidad de la poblacion: ");
        tamanioPoblacion = sc.nextInt();
        System.out.println();
        System.out.println("Resultados: ");
        Seleccion _opeSeleccion =  new SeleccionTorneo();
        Cruce _opeCruce = new CruceUnPunto();
        Mutacion _opeMutacion= new SwapMutacion();
        Problema nReinas = new nReinas(numeroReinas);
        AlgoritmoGenetico algGen = new AlgoritmoGenetico_Simple(nReinas, _opeSeleccion, _opeMutacion, _opeCruce);
        nReinas.motrarPoblacion(algGen.obtenerSolucion(numeroIteraciones,tamanioPoblacion));
        System.out.println("Finalizado");
    }
}
