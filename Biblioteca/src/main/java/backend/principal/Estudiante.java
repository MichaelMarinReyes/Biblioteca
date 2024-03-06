package backend.principal;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author michael
 */
public class Estudiante implements Serializable {

    private int carnet;
    private String nombre;
    private int codigoCarrera;
    private LocalDate fechaNacimiento;
    private int librosPrestados = 0;


    public Estudiante(int carnet, String nombre, int codigoCarrera, LocalDate fechaNacimiento) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.codigoCarrera = codigoCarrera;
        this.fechaNacimiento = fechaNacimiento;
        this.librosPrestados =+ 1;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;

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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getLibrosPrestados() {
        return librosPrestados;
    }

    public void setLibrosPrestados(int librosPrestados) {
        this.librosPrestados = librosPrestados;
    }
    
    public boolean puedePrestarLibros() {
        return this.getLibrosPrestados() <= 3;
    }
}
