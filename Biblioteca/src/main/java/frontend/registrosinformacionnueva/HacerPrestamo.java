/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend.registrosinformacionnueva;

import backend.principal.Estudiante;
import backend.principal.FuncionamientoAplicacion;
import backend.principal.Libro;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ryoumen_kyoma
 */
public class HacerPrestamo extends JPanel {

    private FuncionamientoAplicacion app = new FuncionamientoAplicacion();
    private Libro libro;
    private JComboBox<String> fechaDevolucionBox;

    public HacerPrestamo() {
        initComponents();
        this.setBackground(new java.awt.Color(251, 250, 248));
        Font font = new Font("Bitstream Charter", Font.BOLD, 30);
        jLabel1.setFont(font);
        jLabel2.setFont(font);
        jLabel3.setFont(font);
        jLabel4.setFont(font);
        jLabel5.setFont(font);
        jLabel6.setFont(font);
        this.app = app;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        fechaDevolucionBox = new JComboBox<>();
        agregarFechasLimiteComboBox();
        fechaDevolucionBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = fechaDevolucionBox.getSelectedIndex();
                int monto = (selectedIndex + 1) * 5;
                jLabel6.setText("Monto: Q. " + monto + ".00");
            }
        });
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codigoLibroText = new javax.swing.JTextField();
        buscarLibroButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        informacionLibroTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        carnetEstudianteText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fechaPrestamoText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        realizarPrestamoButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Registro de Préstamo Nuevo");
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 10, 0);
        add(jLabel1, gridBagConstraints);

        jLabel2.setText("Código del Libro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        add(jLabel2, gridBagConstraints);

        codigoLibroText.setColumns(15);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 20, 0, 0);
        add(codigoLibroText, gridBagConstraints);

        buscarLibroButton.setText("Buscar Libro");
        buscarLibroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarLibroButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 20, 0, 0);
        add(buscarLibroButton, gridBagConstraints);

        informacionLibroTextArea.setEditable(false);
        informacionLibroTextArea.setColumns(20);
        informacionLibroTextArea.setRows(5);
        jScrollPane1.setViewportView(informacionLibroTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 20, 0, 0);
        add(jScrollPane1, gridBagConstraints);

        jLabel3.setText("Carnet del Estudiante:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        add(jLabel3, gridBagConstraints);

        carnetEstudianteText.setColumns(15);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 20, 0, 0);
        add(carnetEstudianteText, gridBagConstraints);

        jLabel4.setText("Fecha de Devolución:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; // Se ajusta la posición X para que esté en la misma columna que el JComboBox
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        add(jLabel4, gridBagConstraints);

        agregarFechasLimiteComboBox();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2; // Se ajusta el ancho para que ocupe dos columnas
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 20, 0, 0);
        add(fechaDevolucionBox, gridBagConstraints);

        jLabel6.setText("Monto: Q. 0.00"); // Puedes establecer un valor inicial
        GridBagConstraints gridBagConstraints6 = new java.awt.GridBagConstraints();
        gridBagConstraints6.gridx = 1; // Ajusta la posición X para que esté en la columna derecha
        gridBagConstraints6.gridy = 9; // Ajusta la posición Y para que esté en la misma fila que el botón
        gridBagConstraints6.anchor = java.awt.GridBagConstraints.NORTHEAST; // Alinea el JLabel a la derecha
        gridBagConstraints6.insets = new java.awt.Insets(20, 20, 20, 20); // Agrega márgenes
        add(jLabel6, gridBagConstraints6);

        realizarPrestamoButton.setText("Realizar Préstamo");
        realizarPrestamoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realizarPrestamoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 0);
        add(realizarPrestamoButton, gridBagConstraints);
    }

    private void buscarLibroButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String codigoLibro = codigoLibroText.getText();
        libro = app.buscarLibroPorCodigo(codigoLibro);
        if (libro != null) {
            if (libro.getCantidadCopias() > 0) { // Verificar si hay copias disponibles
                Font font = new Font("Bitstream Charter", Font.BOLD, 20);
                informacionLibroTextArea.setFont(font);
                informacionLibroTextArea.setText("Título: " + libro.getTitulo() + "\n"
                        + "Autor: " + libro.getAutor() + "\n"
                        + "Editorial: " + libro.getEditorial() + "\n"
                        + "Fecha de Publicación: " + libro.getFechaPublicacion() + "\n"
                        + "Cantidad Disponible: " + libro.getCantidadCopias());
            } else {
                JOptionPane.showMessageDialog(this, "No hay copias en existencia de este libro. No se puede realizar el préstamo.");
                limpiarCampos();
            }
        } else {
            JOptionPane.showMessageDialog(this, "El libro no existe.");
            limpiarCampos();
        }
    }

    private void realizarPrestamoButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String carnetEstudiante = carnetEstudianteText.getText();

        // Buscar al estudiante por su carnet
        Estudiante estudiante = app.buscarEstudiantePorCarnet(carnetEstudiante);

        // Verificar si el estudiante existe
        if (estudiante != null) {

            String formatoEsperado = "yyyy-MM-dd";

            // Parsear el texto a LocalDate con el formato deseado
            LocalDate fechaPrestamo = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            LocalDate fechaDevolucion = LocalDate.parse(fechaDevolucionBox.getSelectedItem().toString(), formatter);

            // Restar una copia del libro prestado
            app.restarUnaCopia(libro);

            // Realizar el préstamo
            app.prestarLibro(libro, estudiante, fechaPrestamo, fechaDevolucion);
            JOptionPane.showMessageDialog(this, "Préstamo realizado con éxito");
            limpiarCampos();

        } else {
            JOptionPane.showMessageDialog(this, "El estudiante no existe.");
            limpiarCampos();
        }
    }

    private void agregarFechasLimiteComboBox() {
        DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<>();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaActual = app.obtenerFechaActual();
        // Agrega las fechas límite (3 días a partir de la fecha actual) al JComboBox
        for (int i = 1; i < 4; i++) {
            LocalDate fechaLimite = fechaActual.plusDays(i);
            modeloCombo.addElement(fechaLimite.format(formato));
        }
        fechaDevolucionBox.setModel(modeloCombo);
    }

    private void limpiarCampos() {
        informacionLibroTextArea.setText("");
        carnetEstudianteText.setText("");
        fechaPrestamoText.setText("");
    }

    // Variables declaration
    private javax.swing.JButton buscarLibroButton;
    private javax.swing.JTextField carnetEstudianteText;
    private javax.swing.JTextField codigoLibroText;
    private javax.swing.JTextField fechaPrestamoText;
    private javax.swing.JTextArea informacionLibroTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton realizarPrestamoButton;
    // End of variables declaration
}
