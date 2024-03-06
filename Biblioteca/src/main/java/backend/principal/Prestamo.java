package backend.principal;

import frontend.Principal;
import java.io.Serializable;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author michael
 */
public class Prestamo implements Serializable {

    private Libro libro;
    private Estudiante estudiante;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private int diasConMora = 0;
    private int librosMaximosPrestados;

    public Prestamo(Libro libro, Estudiante estudiante, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.libro = libro;
        this.estudiante = estudiante;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    public int getDiasConMora() {
        return diasConMora;
    }

    public void setDiasConMora(int diasConMora) {
        this.diasConMora = diasConMora;
    }

    public int getLibrosMaximosPrestados() {
        return librosMaximosPrestados;
    }

    public void setLibrosMaximosPrestados(int librosMaximosPrestados) {
        this.librosMaximosPrestados = librosMaximosPrestados;
    }


    public boolean puedePrestarLibros() {
        return librosMaximosPrestados < 3;
    }
}
