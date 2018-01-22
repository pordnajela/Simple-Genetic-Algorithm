package logica.genotipo;

import java.util.ArrayList;

/**
 * @author sperez
 * @param <T>
 */
public abstract class Genotipo  implements Cloneable
{
    protected ArrayList gen;
    protected int fitness;

    

    public ArrayList getGen() {
        return gen;
    }

    public void setGen(ArrayList gen) {
        this.gen = gen;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }
    
    public Genotipo clone(){
        Genotipo obj = null;
        try {
            obj = (Genotipo)super.clone();
            obj.setGen((ArrayList) obj.getGen().clone());
        } catch (CloneNotSupportedException e) {
            System.out.println("Error al clonar genotipo");
        }
        return obj;
    }
    
}