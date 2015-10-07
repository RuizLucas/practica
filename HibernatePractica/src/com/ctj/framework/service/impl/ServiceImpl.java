package com.ctj.framework.service.impl;

import com.ctj.framework.model.dao.MaestroDAO;
import com.ctj.framework.model.dao.PersonaDAO;
import com.ctj.framework.model.dao.impl.MaestroDAOImpl;
import com.ctj.framework.model.dao.impl.PersonaDAOImpl;
import com.ctj.framework.model.entitie.Maestro;
import com.ctj.framework.model.entitie.Persona;
import com.ctj.framework.service.Service;
import java.util.List;

/**
 *
 * @author Ruizhe
 */
public class ServiceImpl implements Service {

    private final PersonaDAO personaDAO = new PersonaDAOImpl();
    private final MaestroDAO maestroDAO = new MaestroDAOImpl();

    /**
     * Guarda la Entidad Persona
     *
     * @param persona
     */
    @Override
    public void guardarPersona(Persona persona) {
        personaDAO.guardarPersona(persona);
    }

    /**
     * Devuelve un listado completo sin restricciones de la Entidad Maestro
     * @return
     */
    @Override
    public List<Maestro> listarMaestro() {
        return maestroDAO.getListMaestro();
    }
    @Override
    public Maestro getMaestro(int leNumero) {
        return maestroDAO.getMaestro(leNumero);
    }
}
