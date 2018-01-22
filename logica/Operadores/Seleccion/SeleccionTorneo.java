package logica.Operadores.Seleccion;

import java.util.ArrayList;
import logica.genotipo.Genotipo;

/**
 *
 * @author fietp
 */
public class SeleccionTorneo implements Seleccion
{
    @Override
    public Genotipo seleccion(ArrayList<Genotipo> poblacion)
    {
        //TORNEO
        ArrayList<Genotipo> subconjunto = new ArrayList<>();
        
        int tamanio_poblacion = poblacion.size();
        
        while(true)
        {
            if(subconjunto.size() == 2)
                break;
            
            int numero_aleatorio_generado = (int) (Math.random()*(tamanio_poblacion-2));
            if (subconjunto.isEmpty()) 
                subconjunto.add(poblacion.get(numero_aleatorio_generado));
            else
                subconjunto.add(poblacion.get(numero_aleatorio_generado));
        }
        
        if(subconjunto.get(0).getFitness() > subconjunto.get(1).getFitness())
            return subconjunto.get(1);
        else
            return subconjunto.get(0);
    }
}
