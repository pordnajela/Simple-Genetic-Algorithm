/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Operadores.Cruce;

import java.util.ArrayList;
import logica.genotipo.Genotipo;

/**
 *
 * @author fietp
 */
public interface Cruce {
    public abstract ArrayList<Genotipo> cruzar(Genotipo individuo1, Genotipo individuo2);
}
