package backend.principal;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author michael
 */
public class Libro implements Serializable {

    private String titulo;
    private String autor;
    private String codigo;
    private int cantidadCopias;
    private Date fechaPublicacion;
    private String editorial;

    public Libro(String titulo, String autor, String codigo, int cantidadCopias, Date fechaPublicacion, String editorial) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.cantidadCopias = cantidadCopias;
        this.fechaPublicacion = fechaPublicacion;
        this.editorial = editorial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidadCopias() {
        return cantidadCopias;
    }

    public void setCantidadCopias(int cantidadCopias) {
        this.cantidadCopias = cantidadCopias;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

}
