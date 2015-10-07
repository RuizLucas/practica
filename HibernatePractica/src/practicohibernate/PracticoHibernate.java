package practicohibernate;

import com.ctj.framework.model.entitie.Maestro;
import com.ctj.framework.model.entitie.Persona;
import com.ctj.framework.service.Service;
import com.ctj.framework.service.impl.ServiceImpl;
import java.util.Arrays;

/**
 *
 * @author Asus
 */
public class PracticoHibernate {

    private final static String ESTADO_ACTIVO = "ACTIVO";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        try {
            Maestro maestro = service.getMaestro(27);

            Persona persona = new Persona();
            String[] split = maestro.getLeApynom().split(" ");

            persona.setApellido(split[0]);
            persona.setNombre(armarNombre(split));
            persona.setCuilCuit(armarCuit(maestro.getLeCuilDav(), maestro.getLeCuilCod(), maestro.getLeDocNro()));
            persona.setEstado(ESTADO_ACTIVO);
            service.guardarPersona(persona);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }

    private static String armarNombre(String[] split) {
        String nombre = "";
        for (int i = 1; i < split.length; i++) {
            nombre = nombre.concat(split[i].trim()).concat(" ");
        }
        return nombre;
    }

    private static String armarCuit(Short cuilDav, Short cuilCod, Long dni) {
        return cuilCod.toString().concat("-")
                .concat(dni.toString())
                .concat("-")
                .concat(cuilDav.toString());
    }

}
