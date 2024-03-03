package backend.principal;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author michael
 */
public class Estudiante implements Serializable {
    private int carne;
    private String nombre;
    private int codigoCarrera;
    private String fechaNacimiento;
    private ArrayList<Libro> librosPrestados = new ArrayList<>();

    public Estudiante(int carne, String nombre, int codigoCarrera, String fechaNacimiento) {
        this.carne = carne;
        this.nombre = nombre;
        this.codigoCarrera = codigoCarrera;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCarne() {
        return carne;
    }

    public void setCarne(int carne) {
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void añadirLibro(Libro libro) {
        librosPrestados.add(libro);
    }
}
