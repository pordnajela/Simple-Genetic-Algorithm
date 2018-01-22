package logica.problema;

import logica.genotipo.Genotipo;
import java.util.ArrayList;
import lib.NumeroAleatorio;
import logica.genotipo.GenotipoInteger;

/**
 *
 * @author sperez
 */
public class nReinas extends Problema 
{
    private int numeroReinas;

    public nReinas(int numeroReinas) {
        this.poblacion = new ArrayList<>();
        this.numeroReinas = numeroReinas;
    }

    public int getNumeroReinas() {
        return numeroReinas;
    }

    public void setNumeroReinas(int numeroReinas) {
        this.numeroReinas = numeroReinas;
    }
    @Override
    public int evaluar(Genotipo gen)
    {
        ArrayList<Integer> array = gen.getGen();
        int i, j, c = 0;
        for (i = 0; i < array.size(); i++) 
        {
            for (j = i+1; j < array.size(); j++) 
            {
                if( (Math.abs(array.get(i) - array.get(j)) == Math.abs(j-i) ))
                    c++;
            }
        }
        gen.setFitness(c);
        return c;
    }
    @Override
    public ArrayList<Genotipo> generarPoblacion(int cantidad)
    {
        int tamanioFenotipo = this.getNumeroReinas();
        ArrayList<Genotipo> listaCompleta= new ArrayList();
        for (int i = 0; i < cantidad; i++) 
        {
            ArrayList<Integer> listaNumeros = new ArrayList();
            NumeroAleatorio _aleatorio = new NumeroAleatorio(0, tamanioFenotipo);
            
            for (int j = 0; j < tamanioFenotipo; j++)
                listaNumeros.add(_aleatorio.generar());
            
            Genotipo gen = new GenotipoInteger();
            gen.setGen(listaNumeros);
            listaCompleta.add(gen);
        }
        return listaCompleta;
    }
    @Override
    public void motrarPoblacion(ArrayList<Genotipo> lista)
    {
        
        for (Genotipo arrayList : lista) {
            ArrayList<Integer> valores = (ArrayList<Integer>) arrayList.getGen();
            if(arrayList.getFitness() == 0){
                    System.out.println("Evaluacion: "+arrayList.getFitness());
                for (Integer valor : valores)
                {
                    System.out.print(valor+",");
                }
                System.out.println("");
                
            }
            
        }
        
    }
}
