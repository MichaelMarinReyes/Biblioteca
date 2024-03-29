package backend.principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michael
 *
 * Esta clase se encarga del funcionamiento de la aplicación.
 */
public class FuncionamientoAplicacion {

    public static ArrayList<Prestamo> listaPrestamos = new ArrayList<>();
    public static ArrayList<Prestamo> listaDevoluciones = new ArrayList<>();
    public static ArrayList<Libro> listaLibros = new ArrayList<>();
    public static ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
    private static String pathCarpeta = "./base_de_datos";
    private Map<String, Integer> librosPrestadosPorEstudiante = new HashMap<>();

    public FuncionamientoAplicacion() {
        abrirSerializableEstudiantes();
        abrirSerializableLibros();
        abrirSerializablePrestamos();
    }

    /**
     * Sirve para agregar un nuevo libro a la base de datos.
     */
    public void agregarNuevoLibro(String codigo, String autor, String titulo, int cantidadCopias, LocalDate fechaPublicación, String editorial) {
        listaLibros.add(new Libro(titulo, autor, codigo, cantidadCopias, fechaPublicación, editorial));
        FuncionamientoAplicacion.guardarSerializableLibros();
    }

    /**
     * Sirve para actualizar los datos de un libro específico.
     */
    public void actualizarLibro(Libro libroActualizado) {
        // Buscar el libro en la lista de libros
        for (int i = 0; i < listaLibros.size(); i++) {
            Libro libro = listaLibros.get(i);
            if (libro.getCodigo().equals(libroActualizado.getCodigo())) {
                // Actualizar los campos del libro con los nuevos valores
                libro.setTitulo(libroActualizado.getTitulo());
                libro.setAutor(libroActualizado.getAutor());
                libro.setEditorial(libroActualizado.getEditorial());
                libro.setFechaPublicacion(libroActualizado.getFechaPublicacion());
                libro.setCantidadCopias(libroActualizado.getCantidadCopias());
                return;
            }
        }
    }

    /**
     * Sirve para agregar a un nuevo estudiante en la base de datos.
     */
    public void agregarNuevoEstudiante(int carnet, String nombre, int codigoCarrera, LocalDate fechaNacimiento) {
        listaEstudiantes.add(new Estudiante(carnet, nombre, codigoCarrera, fechaNacimiento));
        FuncionamientoAplicacion.guardarSerializableEstudiantes();
    }

    /**
     * Método que gestionará los préstamos de los libros.
     */
    public void prestarLibro(Libro codigoLibro, Estudiante estudiante, LocalDate fechaPrestamo, LocalDate fechaDevolucion, int monto) {
        if (estudiante.getLibrosPrestados() < 4) {
            listaPrestamos.add(new Prestamo(codigoLibro, estudiante, fechaPrestamo, fechaDevolucion, monto));
            FuncionamientoAplicacion.guardarSerializablePrestamos();
        }
    }

    public void incrementarLibrosPrestadosPorEstudiante(String carnetEstudiante) {
        librosPrestadosPorEstudiante.put(carnetEstudiante, librosPrestadosPorEstudiante.getOrDefault(carnetEstudiante, 0) + 1);
    }

    public int getLibrosPrestadosPorEstudiante(int carnetEstudiante) {
        return librosPrestadosPorEstudiante.getOrDefault(carnetEstudiante, 0);
    }

    public void ordenarLibros() {
        Comparator<Libro> comparadorPorCodigo = new Comparator<Libro>() {
            @Override
            public int compare(Libro libro1, Libro libro2) {
                return libro1.getCodigo().compareTo(libro2.getCodigo());
            }
        };
        Collections.sort(listaLibros, comparadorPorCodigo);
    }
    
    public void agregarDevoluciones(Prestamo prestamo){
        listaDevoluciones.add(prestamo);
    }

    /**
     * Crea el archivo binario para guardar estudiantes
     */
    public static void guardarSerializableEstudiantes() {
        try {
            File directorio = new File(pathCarpeta);

            if (!directorio.exists()) {
                directorio.mkdir();
            }
            FileOutputStream archivo = new FileOutputStream(pathCarpeta + "/estudiantes.bin");
            ObjectOutputStream escribirProductos = new ObjectOutputStream(archivo);
            escribirProductos.writeObject(listaEstudiantes);
            escribirProductos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FuncionamientoAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FuncionamientoAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Lee el archivo binario que contiene información de estudiantes
     */
    public void abrirSerializableEstudiantes() {
        try {
            File file = new File(pathCarpeta + "/estudiantes.bin");
            if (file.exists()) {
                FileInputStream archivoEntrada = new FileInputStream(pathCarpeta + "/estudiantes.bin");
                ObjectInputStream leerEstudiantes = new ObjectInputStream(archivoEntrada);

                listaEstudiantes = (ArrayList<Estudiante>) leerEstudiantes.readObject();
            }
        } catch (IOException e) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionamientoAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Crea el archivo binario para guardar información de libros
     */
    public static void guardarSerializableLibros() {
        try {
            File directorio = new File(pathCarpeta);

            if (!directorio.exists()) {
                directorio.mkdir();
            }

            FileOutputStream archivo = new FileOutputStream(pathCarpeta + "/libros.bin");
            ObjectOutputStream escribirProductos = new ObjectOutputStream(archivo);
            escribirProductos.writeObject(listaLibros);
            escribirProductos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FuncionamientoAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FuncionamientoAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Lee el archivo binario que contiene información de los libros
     */
    public void abrirSerializableLibros() {
        try {
            File file = new File(pathCarpeta + "/libros.bin");
            if (file.exists()) {
                FileInputStream archivoEntrada = new FileInputStream(pathCarpeta + "/libros.bin");
                ObjectInputStream leerProductos = new ObjectInputStream(archivoEntrada);

                listaLibros = (ArrayList<Libro>) leerProductos.readObject();

            }
        } catch (IOException e) {
            Logger.getLogger(FuncionamientoAplicacion.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionamientoAplicacion.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Crea el archivo binario que contiene la información de los préstamos
     */
    public static void guardarSerializablePrestamos() {
        try {
            File directorio = new File(pathCarpeta);

            if (!directorio.exists()) {
                directorio.mkdir();
            }
            FileOutputStream archivo = new FileOutputStream(pathCarpeta + "/prestamos.bin");
            ObjectOutputStream escribirProductos = new ObjectOutputStream(archivo);
            escribirProductos.writeObject(listaPrestamos);
            escribirProductos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FuncionamientoAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FuncionamientoAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Lee el archivo binario para leer los préstamos
     */
    public void abrirSerializablePrestamos() {
        try {
            File file = new File(pathCarpeta + "/prestamos.bin");
            if (file.exists()) {
                FileInputStream archivoEntrada = new FileInputStream(pathCarpeta + "/prestamos.bin");
                ObjectInputStream leerProductos = new ObjectInputStream(archivoEntrada);

                listaPrestamos = (ArrayList<Prestamo>) leerProductos.readObject();

            }
        } catch (IOException e) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionamientoAplicacion.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

        public static void guardarSerializableDevoluciones() {
        try {
            File directorio = new File(pathCarpeta);

            if (!directorio.exists()) {
                directorio.mkdir();
            }
            FileOutputStream archivo = new FileOutputStream(pathCarpeta + "/devolucuiones.bin");
            ObjectOutputStream escribirProductos = new ObjectOutputStream(archivo);
            escribirProductos.writeObject(listaPrestamos);
            escribirProductos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FuncionamientoAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FuncionamientoAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Lee el archivo binario para leer los préstamos
     */
    public void abrirSerializableDevoluciones() {
        try {
            File file = new File(pathCarpeta + "/devolucuiones.bin");
            if (file.exists()) {
                FileInputStream archivoEntrada = new FileInputStream(pathCarpeta + "/devolucuiones.bin");
                ObjectInputStream leerProductos = new ObjectInputStream(archivoEntrada);

                listaPrestamos = (ArrayList<Prestamo>) leerProductos.readObject();

            }
        } catch (IOException e) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionamientoAplicacion.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean validarEstudiantesRepetidos(String carnet) {
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            if (listaEstudiantes.get(i).getCarnet() == Integer.parseInt(carnet)) {
                return true;
            }
        }
        return false;
    }

    public boolean validarLibroRepetido(String codigo) {
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public Libro buscarLibroPorCodigo(String codigoLibro) {
        for (Libro libro : listaLibros) {
            if (libro.getCodigo().equals(codigoLibro)) {
                return libro;
            }
        }
        return null; // Si no se encuentra el libro con el código especificado
    }

    public Estudiante buscarEstudiantePorCarnet(int carnetEstudiante) {
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            if (listaEstudiantes.get(i).getCarnet() == carnetEstudiante) {
                return listaEstudiantes.get(i);
            }

        }
        return null; // Si no se encuentra el estudiante con el carnet especificado
    }

    public void actualizarEstudiante(Estudiante estudianteActualizado) {
        // Buscar el estudiante en la lista de estudiantes
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            Estudiante estudiante = listaEstudiantes.get(i);
            if (estudiante.getCarnet() == estudianteActualizado.getCarnet()) {
                estudiante.setNombre(estudianteActualizado.getNombre());
                estudiante.setCodigoCarrera(estudianteActualizado.getCodigoCarrera());
                estudiante.setFechaNacimiento(estudianteActualizado.getFechaNacimiento());
                // System.out.println("El estudiante ha sido actualizado correctamente.");
                return;
            }
        }
    }

    public LocalDate obtenerFechaActual() {
        LocalDate fechaActual = LocalDate.now();
        return fechaActual;
    }

    public void restarUnaCopia(Libro libro) {
        libro.setCantidadCopias(libro.getCantidadCopias() - 1);
    }

    public void sumarUnaCopia(Libro libro) {
        libro.setCantidadCopias(libro.getCantidadCopias() + 1);
    }

    public void devolucionDeLibro(String codigoLibro, int carnetEstudiante) {
        for (int i = 0; i < listaPrestamos.size(); i++) {
            if (listaPrestamos.get(i).getLibro().getCodigo().equals(codigoLibro) && listaPrestamos.get(i).getEstudiante().getCarnet() == carnetEstudiante) {
                agregarDevoluciones(listaPrestamos.get(i));
                listaPrestamos.remove(i);
                FuncionamientoAplicacion.guardarSerializableDevoluciones();
            }
        }
    }

    public Prestamo obtenerPrestamo(String codigoLibro, int carnetEstudiante) {
        for (Prestamo prestamo : listaPrestamos) {
        if (prestamo.getLibro().getCodigo().equals(codigoLibro) && prestamo.getEstudiante().getCarnet() == carnetEstudiante) {
            return prestamo;
        }
    }
    return null; // Devolver null si no se encuentra ningún préstamo
    }
}
