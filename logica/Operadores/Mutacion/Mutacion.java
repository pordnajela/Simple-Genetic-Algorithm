/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Operadores.Mutacion;

import logica.genotipo.Genotipo;

/**
 *
 * @author fietp
 */
public interface Mutacion {
    public abstract Genotipo mutar(Genotipo genotipo);
}
