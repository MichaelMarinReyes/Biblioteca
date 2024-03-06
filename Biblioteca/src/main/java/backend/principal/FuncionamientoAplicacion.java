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
    public static ArrayList<Libro> listaLibros = new ArrayList<>();
    public static ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
    private static String pathCarpeta = "./base_de_datos";

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
                // Mostrar mensaje de éxito o realizar otras acciones necesarias
                System.out.println("El libro ha sido actualizado correctamente.");
                return; // Salir del bucle una vez que se ha actualizado el libro
            }
        }
        // Si el libro no se encuentra en la lista, mostrar mensaje de error
        System.out.println("El libro no se encuentra en la base de datos.");
    }

    /**
     * Sirve para agregar a un nuevo estudiante en la base de datos.
     */
    public void agregarNuevoEstudiante(int carnet, String nombre, int codigoCarrera, LocalDate fechaNacimiento) {
        listaEstudiantes.add(new Estudiante(carnet, nombre, codigoCarrera, fechaNacimiento));
    }

    /**
     * Método que gestionará los préstamos de los libros.
     */
    public void prestarLibro(Libro codigoLibro, Estudiante estudiante, LocalDate fecha) {
        /* Libro libro = buscarLibroDisponible(codigoLibro.getCodigo());
        if (libro != null) {*/
        listaPrestamos.add(new Prestamo(codigoLibro, estudiante, fecha));

        //}
    }

    private Libro buscarLibroDisponible(String codigoLibro) {
        ordenarLibros();
        for (int i = 0; i < listaLibros.size(); i++) {
            if (!listaLibros.isEmpty()) {
                if (listaLibros.get(i).getCodigo().equals(codigoLibro)) {
                    return listaLibros.get(i);
                } else {
                    return null;
                }
            }
        }
        return null;
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

            } else {
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

            } else {

            }

        } catch (IOException e) {

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

            } else {

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

    public Estudiante buscarEstudiantePorCarnet(String carnetEstudiante) {
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            if (listaEstudiantes.get(i).getCarnet() == Integer.parseInt(carnetEstudiante)) {
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
        //System.out.println("El estudiante no se encuentra en la base de datos.");
    }

    public LocalDate obtenerFechaActual() {
        LocalDate fechaActual = LocalDate.now();
    System.out.println("Fecha actual: " + fechaActual);
    return fechaActual;
    }

}
