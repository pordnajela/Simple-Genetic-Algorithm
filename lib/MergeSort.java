package lib;

import java.util.ArrayList;
import logica.genotipo.Genotipo;

/**
 *
 * @author sperez
 */
public class MergeSort 
{
    private void mergeSort(ArrayList<Genotipo> arreglo, int ini, int fin) {
        int m = 0;
        if (ini < fin) {
            m = (ini + fin) / 2;
            mergeSort(arreglo, ini, m);
            mergeSort(arreglo, m + 1, fin);
            merge(arreglo, ini, m, fin);
        }
    }

    private void merge(ArrayList<Genotipo> arreglo, int ini, int m, int fin) {
        int k = 0;
        int i = ini;
        int j = m + 1;
        int n = fin - ini + 1;
        ArrayList<Genotipo> b = new ArrayList<>();

        while (i <= m && j <= fin) {
            if (arreglo.get(i).getFitness() < arreglo.get(j).getFitness()) {
                b.add(arreglo.get(i));
                i++;
                k++;
            } else {
                b.add(arreglo.get(j));
                j++;
                k++;
            }
        }
        while (i <= m) {
            b.add(arreglo.get(i));
            i++;
            k++;
        }
        while (j <= fin) {
            b.add(arreglo.get(j));
            j++;
            k++;
        }
        for (k = 0; k < n; k++) {
            arreglo.set(ini + k, b.get(k));
        }
    }

    public ArrayList<Genotipo> mergeSortTomaDatos(ArrayList<Genotipo> arregloSinOrdenar) {
        
        ArrayList<Genotipo> arreglo = new ArrayList<>();
        arreglo = darCopiaValores(arregloSinOrdenar);
        mergeSort(arreglo, 0, arreglo.size() - 1);
        return arreglo;
    }

    private ArrayList<Genotipo> darCopiaValores(ArrayList<Genotipo> arregloSinOrdenar) {
        ArrayList<Genotipo> arreglonuevo = new ArrayList<>();
        arreglonuevo = (ArrayList<Genotipo>) arregloSinOrdenar.clone();
        return arreglonuevo;
    }
}