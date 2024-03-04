/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend.registrosinformacionnueva;

import backend.principal.FuncionamientoAplicacion;
import backend.principal.Libro;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ryoumen_kyoma
 */
public class EditarLibro extends JPanel {

    private FuncionamientoAplicacion app = new FuncionamientoAplicacion();
    private JTextField codigoLibroText;
    private JTextArea informacionLibroTextArea;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;

    public EditarLibro() {
        initComponents();
        this.setBackground(new java.awt.Color(251, 250, 248));
        Font font = new Font("Bitstream Charter", Font.BOLD, 30);
        jLabel1.setFont(font);
        jLabel2.setFont(font);
    }

    private void initComponents() {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        codigoLibroText = new JTextField();
        JButton buscarLibroButton = new JButton("Buscar Libro");
        buscarLibroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buscarLibroButtonActionPerformed(evt);
            }
        });
        JButton cambiosButton = new JButton("Editar");
        cambiosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cambiosButtonActionPerformed(evt);
            }
        });
        JButton guardarCambiosConfirmarButton = new JButton("Guardar Cambios");
        guardarCambiosConfirmarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                guardarCambiosConfirmarButtonActionPerformed(evt);
            }
        });
        jScrollPane1 = new JScrollPane();
        informacionLibroTextArea = new JTextArea();

        setLayout(new GridBagLayout());

        jLabel1.setText("Edición de Libros Almacenados:");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(20, 20, 10, 0);
        add(jLabel1, gridBagConstraints);

        jLabel2.setText("Código del Libro:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(20, 20, 0, 0);
        add(jLabel2, gridBagConstraints);

        codigoLibroText.setColumns(15);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 20, 0, 0);
        add(codigoLibroText, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 20, 0, 0);
        add(buscarLibroButton, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 20, 0, 0);
        add(cambiosButton, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 20, 0, 0);
        add(guardarCambiosConfirmarButton, gridBagConstraints);

        informacionLibroTextArea.setEditable(false);
        informacionLibroTextArea.setColumns(20);
        informacionLibroTextArea.setRows(5);
        jScrollPane1.setViewportView(informacionLibroTextArea);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 20, 0, 0);
        add(jScrollPane1, gridBagConstraints);
    }

    private void buscarLibroButtonActionPerformed(ActionEvent evt) {
        String codigoLibro = codigoLibroText.getText();
        Libro libro = app.buscarLibroPorCodigo(codigoLibro);
        if (libro != null) {
            informacionLibroTextArea.setText("Título: " + libro.getTitulo() + "\n"
                    + "Autor: " + libro.getAutor() + "\n"
                    + "Editorial: " + libro.getEditorial() + "\n"
                    + "Fecha de Publicación: " + libro.getFechaPublicacion() + "\n"
                    + "Cantidad Disponible: " + libro.getCantidadCopias() + "\n");
        } else {
            JOptionPane.showMessageDialog(this, "El libro no existe.");
            limpiarCampos();
        }
    }

    private void cambiosButtonActionPerformed(ActionEvent evt) {
        String codigoLibro = codigoLibroText.getText();
        Libro libro = app.buscarLibroPorCodigo(codigoLibro);
        if (libro != null) {
            String nuevoTitulo = JOptionPane.showInputDialog(this, "Ingrese el nuevo título:", libro.getTitulo());
            String nuevoAutor = JOptionPane.showInputDialog(this, "Ingrese el nuevo autor:", libro.getAutor());
            String nuevaEditorial = JOptionPane.showInputDialog(this, "Ingrese la nueva editorial:", libro.getEditorial());
            String nuevaFechaStr = JOptionPane.showInputDialog(this, "Ingrese la nueva fecha de publicación (yyyy-MM-dd):", libro.getFechaPublicacion());

            // Convertir la cadena a LocalDate
            LocalDate nuevaFechaPublicacion = LocalDate.parse(nuevaFechaStr);
            int nuevaCantidadCopias = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la nueva cantidad de copias:", libro.getCantidadCopias()));

            // Mostrar los cambios en el JTextArea sin guardarlos en el array
            informacionLibroTextArea.setText("Título: " + nuevoTitulo + "\n"
                    + "Autor: " + nuevoAutor + "\n"
                    + "Editorial: " + nuevaEditorial + "\n"
                    + "Fecha de Publicación: " + nuevaFechaPublicacion + "\n"
                    + "Cantidad Disponible: " + nuevaCantidadCopias + "\n");

            // Mostrar los cambios en la consola
            System.out.println("Se han realizado cambios en el libro:");
            System.out.println("Nuevo título: " + nuevoTitulo);
            System.out.println("Nuevo autor: " + nuevoAutor);
            System.out.println("Nueva editorial: " + nuevaEditorial);
            System.out.println("Nueva fecha de publicación: " + nuevaFechaPublicacion);
            System.out.println("Nueva cantidad de copias: " + nuevaCantidadCopias);
        } else {
            JOptionPane.showMessageDialog(this, "El libro no existe.");
            limpiarCampos();
        }
    }

    private void guardarCambiosConfirmarButtonActionPerformed(ActionEvent evt) {
        String codigoLibro = codigoLibroText.getText();
        Libro libro = app.buscarLibroPorCodigo(codigoLibro);
        if (libro != null) {
            int option = JOptionPane.showConfirmDialog(this, "¿Desea guardar los cambios?", "Guardar Cambios", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                // Obtener el texto del JTextArea
                String textoLibro = informacionLibroTextArea.getText();
                String[] lineas = textoLibro.split("\\n");
                // Extraer los valores de cada línea
                String nuevoTitulo = lineas[0].replace("Título: ", "");
                String nuevoAutor = lineas[1].replace("Autor: ", "");
                String nuevaEditorial = lineas[2].replace("Editorial: ", "");
                LocalDate nuevaFechaPublicacion = LocalDate.parse(lineas[3].replace("Fecha de Publicación: ", ""));
                int nuevaCantidadCopias = Integer.parseInt(lineas[4].replace("Cantidad Disponible: ", ""));
                // Actualizar el objeto libro con los nuevos valores
                libro.setTitulo(nuevoTitulo);
                libro.setAutor(nuevoAutor);
                libro.setEditorial(nuevaEditorial);
                libro.setFechaPublicacion(nuevaFechaPublicacion);
                libro.setCantidadCopias(nuevaCantidadCopias);
                app.actualizarLibro(libro);
                JOptionPane.showMessageDialog(this, "Cambios guardados exitosamente.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "El libro no existe.");
            limpiarCampos();
        }
    }

    private void limpiarCampos() {
        informacionLibroTextArea.setText("");
        codigoLibroText.setText("");
    }
}
