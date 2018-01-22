package logica.Operadores.Mutacion;

import java.util.ArrayList;
import logica.genotipo.Genotipo;

/**
 *
 * @author Sahydo
 */
public class SwapMutacion implements Mutacion{
    
    //SWAP MUTATION AZAR
    @Override
    public  Genotipo mutar(Genotipo gen)
    {
        ArrayList<Integer> array = gen.getGen();
        int tamanioIndividuo = array.size() -1;
        int iniArea, finArea;
        int vini, vfin;
        do{
            iniArea = (int) (Math.random()*tamanioIndividuo+1);
            finArea = (int) (Math.random()*tamanioIndividuo+1);
        }while(iniArea == finArea);
        vini = array.get(iniArea);
        vfin = array.get(finArea);
        
        array.set(iniArea, vfin);
        array.set(finArea, vini);
        
        return gen;
    }
}
