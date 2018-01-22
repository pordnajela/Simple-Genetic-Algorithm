package logica.Busqueda;

import logica.Operadores.Seleccion.Seleccion;
import java.util.ArrayList;
import logica.Operadores.Cruce.Cruce;
import logica.Operadores.Mutacion.Mutacion;
import logica.genotipo.Genotipo;
import logica.problema.Problema;


/**
 *
 * @author fietp
 */
public abstract class AlgoritmoGenetico 
{
    protected Problema _problema;
    protected Seleccion _seleccionOp;
    protected Mutacion _mutacionOp;
    protected Cruce _cruceOp;

    public AlgoritmoGenetico(Problema _problema, Seleccion _seleccionOp, Mutacion _mutacionOp, Cruce _cruceOp) {
        this._problema = _problema;
        this._seleccionOp = _seleccionOp;
        this._mutacionOp = _mutacionOp;
        this._cruceOp = _cruceOp;
    }

    public Problema getProblema() {
        return _problema;
    }

    public void setProblema(Problema _problema) {
        this._problema = _problema;
    }
    
    public abstract ArrayList<Genotipo> obtenerSolucion(int numeroIteraciones, int tamanioPoblacion);
    public void computar(ArrayList<Genotipo> lista) 
    {
        for (Genotipo genotipo : lista)
            genotipo.setFitness(_problema.evaluar(genotipo));
    }     
}