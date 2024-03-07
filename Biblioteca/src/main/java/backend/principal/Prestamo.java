package backend.principal;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
    private int costoPorMora = 0;
    private int monto = 0;

    public Prestamo(Libro libro, Estudiante estudiante, LocalDate fechaPrestamo, LocalDate fechaDevolucion, int monto) {
        this.libro = libro;
        this.estudiante = estudiante;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.monto = monto;
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
        LocalDate fechaActual = LocalDate.now();
        diasConMora = (int) ChronoUnit.DAYS.between(fechaPrestamo, fechaActual);
        if (diasConMora < 0) {
            return 0;
        } else {
            return diasConMora;
        }
    }

    public void setDiasConMora(int diasConMora) {
        this.diasConMora = diasConMora;
    }

    public int getCostoPorMora() {
        return costoPorMora + this.getMonto();
    }

    public void setCostoPorMora(int costoPorMora) {
        this.costoPorMora = costoPorMora;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
}
