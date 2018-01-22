package logica.Operadores.Seleccion;

import java.util.ArrayList;
import logica.genotipo.Genotipo;

/**
 *
 * @author fietp
 */
public interface Seleccion {
    public abstract Genotipo seleccion(ArrayList<Genotipo> poblacion);
}
