package backend.reportes;

import java.time.LocalDate;

/**
 *
 * @author michael
 */
public class MoraPorDevolucionTarde {
    LocalDate fechaInicio;
    LocalDate fechaEntrega;

    public MoraPorDevolucionTarde(LocalDate fechaInicio, LocalDate fechaEntrega) {
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    
    
}
