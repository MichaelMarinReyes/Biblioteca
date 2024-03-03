package backend.principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    private static String pathCarpeta;

    public FuncionamientoAplicacion() {
        guardarSerializableEstudiantes();
        guardarSerializableLibros();
        guardarSerializablePrestamos();
    }

    /**
     * Muestra los datos de que no pudieron ser ingresados al importar datos.
     */
    public void mostrarErroresDeImportacion() {

    }

    /**
     * Sirve para agregar un nuevo libro a la base de datos.
     */
    public void agregarNuevoLibro(String codigo, String autor, String titulo, int cantidadCopias, String fechaPublicación, String editorial) {
        listaLibros.add(new Libro(titulo, autor, codigo, cantidadCopias, fechaPublicación, editorial));
    }

    /**
     * Sirve para actualizar los datos de un libro específico.
     */
    public void actualizarLibro() {

    }

    /**
     * Sirve para agregar a un nuevo estudiante en la base de datos.
     */
    public void agregarNuevoEstudiante(int carnet, String nombre, int codigoCarrera, String fechaNacimiento) {
        listaEstudiantes.add(new Estudiante(carnet, nombre, codigoCarrera, fechaNacimiento));
    }

    /**
     * Método que gestionará los préstamos de los libros.
     */
    public void prestarLibro(String codigoLibro, Estudiante estudiante) {
        Libro libro = buscarLibroDisponible(codigoLibro);
        if (libro != null) {
            if (libro.getCantidadCopias() > 0) {
                estudiante.añadirLibro(libro);
            } else {

            }
        }
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

    public static void guardarSerializableEstudiantes() {
        try {
            File directorio = new File("base_de_datos");

            if (!directorio.exists()) {
                directorio.mkdir();
            }
            pathCarpeta = directorio.getAbsolutePath();
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

    public static void guardarSerializableLibros() {
        try {
            File directorio = new File("base_de_datos");

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

    public static void guardarSerializablePrestamos() {
        try {
            File directorio = new File("base_de_datos");

            if (!directorio.exists()) {
                directorio.mkdir();
            }
            FileOutputStream archivo = new FileOutputStream(pathCarpeta + "prestamos.bin");
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
}
