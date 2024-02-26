package backend.principal;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author michael
 */
public class Prestamo implements Serializable {

    private Libro libro;
    private Estudiante estudiante;
    private Date fechaPrestamo;

}
