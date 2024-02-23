package backend.principal;

/**
 *
 * @author michael
 */
public class Libro {
    private String titulo;
    private String autor;
    private String codigo;
    private int cantidadCopias;

    public Libro(String titulo, String autor, String codigo, int cantidadCopias) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.cantidadCopias = cantidadCopias;
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
    
    
}
