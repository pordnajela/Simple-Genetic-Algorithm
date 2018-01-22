/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.genotipo;

import java.util.ArrayList;

/**
 *
 * @author Sahydo
 */
public class GenotipoInteger extends Genotipo {
  
    public GenotipoInteger() {
        super.gen= new ArrayList<Integer>();
        super.fitness=0;
    }
    public GenotipoInteger(ArrayList<Integer> gen, int fitness){
        super.gen=gen;
        super.fitness=fitness;
    }
    
    
    
}
