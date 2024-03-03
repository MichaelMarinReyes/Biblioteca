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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ryoumen_kyoma
 */
public class HacerPrestamo extends JPanel {
    private FuncionamientoAplicacion app = new FuncionamientoAplicacion();

    public HacerPrestamo() {
        initComponents();
        this.setBackground(new java.awt.Color(251, 250, 248));
        Font font = new Font("Bitstream Charter", Font.BOLD, 30);
        jLabel1.setFont(font);
        jLabel2.setFont(font);
        jLabel3.setFont(font);
        jLabel4.setFont(font);
        jLabel5.setFont(font);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
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

        jLabel4.setText("Fecha de Préstamo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        add(jLabel4, gridBagConstraints);

        fechaPrestamoText.setColumns(15);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 20, 0, 0);
        add(fechaPrestamoText, gridBagConstraints);

        jLabel5.setText("yyyy-mm-dd");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        add(jLabel5, gridBagConstraints);

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
        Libro libro = app.buscarLibroPorCodigo(codigoLibro);
        if (libro != null) {
            informacionLibroTextArea.setText("Título: " + libro.getTitulo() + "\n" +
                                              "Autor: " + libro.getAutor() + "\n" +
                                              "Editorial: " + libro.getEditorial() + "\n" +
                                              "Fecha de Publicación: " + libro.getFechaPublicacion() + "\n" +
                                              "Cantidad Disponible: " + libro.getCantidadCopias());
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
        // Lógica para realizar el préstamo
        // Puedes llamar al método prestarLibro de FuncionamientoAplicacion pasando el código del libro y el estudiante
        // Ejemplo: app.prestarLibro(codigoLibroText.getText(), estudiante);
    } else {
        // Si el estudiante no existe, mostrar un mensaje
        JOptionPane.showMessageDialog(this, "El estudiante no existe.");
        // Limpiar los campos
        limpiarCampos();
    }
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton realizarPrestamoButton;
    // End of variables declaration
}