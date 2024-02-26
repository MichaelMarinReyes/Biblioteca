package backend.principal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author michael
 */
public class Estudiante implements Serializable {
    private String carne;
    private String nombre;
    private int codigoCarrera;
    private Date fechaNacimiento;
    private ArrayList<Libro> librosPrestados = new ArrayList<>();

    public Estudiante(String carne, String nombre, int codigoCarrera, Date fechaNacimiento) {
        this.carne = carne;
        this.nombre = nombre;
        this.codigoCarrera = codigoCarrera;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(int codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void añadirLibro(Libro libro) {
        librosPrestados.add(libro);
    }
}
