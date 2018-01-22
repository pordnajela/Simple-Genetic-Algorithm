package logica.Busqueda;

import logica.Operadores.Seleccion.Seleccion;
import java.util.ArrayList;
import lib.MergeSort;
import logica.Operadores.Cruce.Cruce;
import logica.Operadores.Mutacion.Mutacion;
import logica.genotipo.Genotipo;
import logica.problema.Problema;

/**
 * @author sperez
 */
public class AlgoritmoGenetico_Simple extends AlgoritmoGenetico
{
    public AlgoritmoGenetico_Simple(Problema _problema, Seleccion _seleccionOp, Mutacion _mutacionOp, Cruce _cruceOp) 
    {
        super(_problema, _seleccionOp, _mutacionOp, _cruceOp);
    }
    
   @Override
   public ArrayList<Genotipo> obtenerSolucion(int numeroIteraciones, int tamanioPoblacion)
   {
       MergeSort ms = new MergeSort();
       ArrayList<Genotipo> nuevaGeneracion = new ArrayList<>();
       
       int k=0;
       int porcentaje;
       int numero_aleatorio_generado;
       
       _problema.setPoblacion(_problema.generarPoblacion(tamanioPoblacion));
       computar(_problema.getPoblacion());
       porcentaje= (int) Math.round((0.1*_problema.getPoblacion().size()));
       int tamanio = _problema.getPoblacion().size();
       
       while (k < numeroIteraciones) 
       {
           ArrayList<Genotipo> descencientes;
           Genotipo padre;
           Genotipo madre;
           nuevaGeneracion.add(ms.mergeSortTomaDatos(_problema.getPoblacion()).get(0));
           nuevaGeneracion.add(ms.mergeSortTomaDatos(_problema.getPoblacion()).get(1));
           for (int i = 0; i < (tamanio/2)-1; i++) 
           {
               do{
                   padre=_seleccionOp.seleccion(_problema.getPoblacion());
                   madre=_seleccionOp.seleccion(_problema.getPoblacion());
               }while(padre.getGen().equals(madre.getGen()));//Asegurar que los padres no sean iguales
               descencientes = _cruceOp.cruzar(padre, madre);
               descencientes.get(0).setFitness(_problema.evaluar(descencientes.get(0)));
               descencientes.get(1).setFitness(_problema.evaluar(descencientes.get(1)));
               nuevaGeneracion.add(descencientes.get(0));
               nuevaGeneracion.add(descencientes.get(1));
               descencientes.clear();
            }
            for (int i = 0; i < porcentaje; i++) 
            {
                do{
                    numero_aleatorio_generado = (int) (Math.random()*(tamanio-1)+2);
                }while(numero_aleatorio_generado > tamanio-1);//Como se usa elitismo con los 2 mejores, se asegura que no sobrepase el límite del array
                _mutacionOp.mutar(nuevaGeneracion.get(numero_aleatorio_generado));
                nuevaGeneracion.get(numero_aleatorio_generado).setFitness(_problema.evaluar(nuevaGeneracion.get(numero_aleatorio_generado)));
            }
           _problema.setPoblacion((ArrayList<Genotipo>) nuevaGeneracion.clone());
           nuevaGeneracion.clear();
           k++;
       }
       return _problema.getPoblacion();
   }

    
}
