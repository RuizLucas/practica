package com.ctj.framework.service;

import com.ctj.framework.model.entitie.Maestro;
import com.ctj.framework.model.entitie.Persona;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface Service {

    void guardarPersona(Persona persona);

    List<Maestro> listarMaestro();
    /**
     * Devuelvo un Meastro de acuerdo a los Parametros
     * @param leNumero
     * @return 
     */
    Maestro getMaestro(int leNumero);
    
}
