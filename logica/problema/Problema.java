/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.problema;

import java.util.ArrayList;
import logica.genotipo.Genotipo;

/**
 *
 * @author Sahydo
 */
public abstract class Problema 
{
    protected ArrayList<Genotipo> poblacion;
    
    public abstract int evaluar(Genotipo gen);
    public abstract ArrayList<Genotipo> generarPoblacion(int cantidad);
    public abstract void motrarPoblacion(ArrayList<Genotipo> lista);
    
    public ArrayList<Genotipo> getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(ArrayList<Genotipo> poblacion) {
        this.poblacion = poblacion;
    }
}
