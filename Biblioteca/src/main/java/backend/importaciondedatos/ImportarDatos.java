package backend.importaciondedatos;

import backend.principal.FuncionamientoAplicacion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author michael
 */
public class ImportarDatos {

    private FuncionamientoAplicacion clasificar = new FuncionamientoAplicacion();
    private String path;

    public void abrirArchivo(String ruta) {
        String texto = "";
        path = ruta;
        try {
            File archivo = new File(ruta);
            FileReader lector = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(lector);
            String linea;
            while ((linea = buffer.readLine()) != null) {
                if (linea.startsWith("LIBRO")) {
                    importarLibro(buffer);
                } else if (linea.startsWith("ESTUDIANTE")) {
                    importarEstudiante(buffer);
                } else if (linea.startsWith("PRESTAMO")) {
                    importarPrestamo(buffer);
                } else {

                }
                texto += linea + "\n";
            }
            buffer.close();
            lector.close();
        } catch (IOException error) {
            System.out.println(error);
        }
    }

    private void importarLibro(BufferedReader br) throws IOException {
        String titulo = br.readLine().substring("TITULO:".length());
        String autor = br.readLine().substring("AUTOR:".length());
        String codigo = br.readLine().substring("CODIGO:".length());
        int cantidad = Integer.parseInt(br.readLine().substring("CANTIDAD:".length()));
        if (!clasificar.validarLibroRepetido(codigo)) {
            clasificar.agregarNuevoLibro(codigo, autor, titulo, cantidad, null, " ");
        }

    }

    private void importarEstudiante(BufferedReader br) throws IOException {
        String carnet = br.readLine().substring("CARNET:".length());
        String nombre = br.readLine().substring("NOMBRE:".length());
        int numeroCarrera = Integer.parseInt(br.readLine().substring("CARRERA:".length()));
        if (!clasificar.validarEstudiantesRepetidos(carnet)) {

            clasificar.agregarNuevoEstudiante(Integer.parseInt(carnet), nombre, numeroCarrera, null);

        }
    }

    private void importarPrestamo(BufferedReader br) throws IOException {
        String codigoLibro = br.readLine().substring("CODIGOLIBRO:".length());
        String carnet = br.readLine().substring("CARNET:".length());
        String fecha = br.readLine().substring("FECHA:".length());

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaFormateada = LocalDate.parse(fecha, format);
        clasificar.prestarLibro(clasificar.buscarLibroPorCodigo(codigoLibro), clasificar.buscarEstudiantePorCarnet(carnet), fechaFormateada);
    }
}
