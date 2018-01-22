package logica.Operadores.Cruce;

import java.util.ArrayList;
import logica.genotipo.Genotipo;
import logica.genotipo.GenotipoInteger;

/**
 *
 * @author fietp
 */
public class CruceUnPunto implements Cruce
{
    @Override
    public ArrayList<Genotipo> cruzar(Genotipo individuo1, Genotipo individuo2)
    {
        //BASADO EN 1 PUNTO
        ArrayList<Genotipo> hijos = new ArrayList<>();
        Genotipo hijo1;
        Genotipo hijo2;
        
        int i;
        int tamanio = individuo1.getGen().size();
        int cruce = 3;
        
        hijo1 = new GenotipoInteger();
        hijo2 = new GenotipoInteger();
        
        for (i = 0; i < cruce; i++) 
        {
            hijo1.getGen().add(individuo1.getGen().get(i));
            hijo2.getGen().add(individuo2.getGen().get(i));
        }
        while (true) 
        {
            if (cruce == tamanio)
                cruce = 0;

            if (hijo1.getGen().size() == tamanio)
                break;

            if (!hijo1.getGen().contains(individuo2.getGen().get(cruce))) 
            {
                hijo1.getGen().add(individuo2.getGen().get(cruce));
                cruce++;
            } else
                cruce++;
        }
        cruce = 3;
        while (true) 
        {
            if (cruce == tamanio)
                cruce = 0;

            if (hijo2.getGen().size() == tamanio)
                break;

            if (!hijo2.getGen().contains(individuo1.getGen().get(cruce))) 
            {
                hijo2.getGen().add(individuo1.getGen().get(cruce));
                cruce++;
            } else
                cruce++;
        }
        
        hijos.add(hijo1);
        hijos.add(hijo2);
        return hijos;
    }
}

