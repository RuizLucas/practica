package com.ctj.framework.model.dao;

import com.ctj.framework.model.entitie.Maestro;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface MaestroDAO {

    List<Maestro> getListMaestro();

    Maestro getMaestro(int leNumero);

}
