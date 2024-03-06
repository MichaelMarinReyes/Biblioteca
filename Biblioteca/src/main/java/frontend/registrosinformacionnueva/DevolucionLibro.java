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
public class DevolucionLibro extends JPanel {

    private FuncionamientoAplicacion app = new FuncionamientoAplicacion();
    private Libro libro;
    private Estudiante estudiante;
    private JLabel carnetLabel, codigoLibroLabel, fechaDevolucionLabel, informacionLabel;
    private JTextField carnetText, codigoLibroText, fechaDevolucionText;
    private JTextArea informacionTextArea;
    private JButton verificarPrestamoButton, finalizarTransaccionButton;

    public DevolucionLibro() {
        initComponents();
        setFontStyle();
    }

    private void initComponents() {
        this.setBackground(new java.awt.Color(251, 250, 248));
        setLayout(new java.awt.GridBagLayout());

        carnetLabel = new JLabel("Carnet del Estudiante:");
        codigoLibroLabel = new JLabel("Código del Libro:");
        fechaDevolucionLabel = new JLabel("Fecha de Devolución:");
        informacionLabel = new JLabel("Información del Préstamo:");

        carnetText = new JTextField(15);
        codigoLibroText = new JTextField(15);
        fechaDevolucionText = new JTextField(15);

        informacionTextArea = new JTextArea(10, 30);
        informacionTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(informacionTextArea);

        verificarPrestamoButton = new JButton("Verificar Préstamo");
        verificarPrestamoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarPrestamo();
            }
        });

        finalizarTransaccionButton = new JButton("Finalizar Transacción");
        finalizarTransaccionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarTransaccion();
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Agregar elementos al panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(carnetLabel, gbc);

        gbc.gridx = 1;
        add(carnetText, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(codigoLibroLabel, gbc);

        gbc.gridx = 1;
        add(codigoLibroText, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(fechaDevolucionLabel, gbc);

        gbc.gridx = 1;
        add(fechaDevolucionText, gbc);

        gbc.gridx = 2;
        add(verificarPrestamoButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 3;
        add(informacionLabel, gbc);

        gbc.gridy++;
        add(scrollPane, gbc);

        gbc.gridy++;
        gbc.gridwidth = 3;
        add(finalizarTransaccionButton, gbc);
    }

    private void verificarPrestamo() {
        String carnet = carnetText.getText().trim();
        String codigoLibro = codigoLibroText.getText().trim();
        String fechaDevolucionString = fechaDevolucionText.getText().trim();

        // Verificar si algún campo está vacío
        if (carnet.isEmpty() || codigoLibro.isEmpty() || fechaDevolucionString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campos faltantes por llenar");
            limpiarCampos();
            return;
        }

        try {
            // Verificar si el estudiante existe
            estudiante = app.buscarEstudiantePorCarnet(Integer.parseInt(carnet));
            if (estudiante == null) {
                JOptionPane.showMessageDialog(this, "El estudiante no existe.");
                return;
            }

            // Verificar si el libro existe
            libro = app.buscarLibroPorCodigo(codigoLibro);
            if (libro == null) {
                JOptionPane.showMessageDialog(this, "El libro no existe.");
                return;
            }

            // Verificar formato de fecha de devolución
            if (!fechaDevolucionString.matches("\\d{4}-\\d{2}-\\d{2}")) {
                JOptionPane.showMessageDialog(this, "Formato de fecha de devolución inválido. Utilice el formato yyyy-mm-dd.");
                return;
            }
            LocalDate fechaDevolucion = LocalDate.parse(fechaDevolucionString);

            // Obtener la fecha actual
            LocalDate fechaActual = LocalDate.now();

            // Calcular días de préstamo desde la fecha de inicio hasta la fecha de devolución
            long diasPrestamo = fechaActual.until(fechaDevolucion).getDays();

            // Variable para almacenar la fecha de devolución tardía del libro
            LocalDate fechaDevolucionTardia;

            // Verificar si la fecha de devolución ya pasó
            if (fechaActual.isAfter(fechaDevolucion)) {
                // La fecha de devolución tardía es la fecha actual
                fechaDevolucionTardia = fechaActual;
            } else {
                // La fecha de devolución tardía es la fecha de devolución seleccionada
                fechaDevolucionTardia = fechaDevolucion;
            }

            // Calcular días de mora si la fecha de devolución tardía es posterior a la fecha límite
            long diasMora = 0;
            if (fechaDevolucionTardia.isAfter(fechaDevolucion)) {
                diasMora = fechaDevolucion.until(fechaDevolucionTardia).getDays();
            }

            // Calcular monto del préstamo
            double monto = (5 * diasPrestamo) + (10 * diasMora);

            // Mostrar información del préstamo en el TextArea
            informacionTextArea.setText("Carnet del Estudiante: " + estudiante.getCarnet() + "\n"
                    + "Nombre del Estudiante: " + estudiante.getNombre() + "\n"
                    + "Código del Libro: " + libro.getCodigo() + "\n"
                    + "Nombre del Libro: " + libro.getTitulo() + "\n"
                    + "Fecha de Préstamo: " + fechaActual + "\n"
                    + "Fecha de Devolución: " + fechaDevolucion + "\n"
                    + "Días de Préstamo: " + diasPrestamo + "\n"
                    + "Días de Mora: " + diasMora + "\n"
                    + "Monto del Préstamo: Q. " + monto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error.\nVerifique que haya ingresado correctamente los datos");
        }

    }

    private void finalizarTransaccion() {
        app.sumarUnaCopia(libro);
        app.devolucionDeLibro(codigoLibroText.getText(), Integer.parseInt(carnetText.getText()));
        JOptionPane.showMessageDialog(this, "Transacción finalizada. ¡Gracias por su visita!");
        limpiarCampos();
    }

    private void limpiarCampos() {
        carnetText.setText("");
        codigoLibroText.setText("");
        fechaDevolucionText.setText("");
        informacionTextArea.setText("");
    }

    private void setFontStyle() {
        Font font = new Font("Bitstream Charter", Font.BOLD, 20);
        carnetLabel.setFont(font);
        codigoLibroLabel.setFont(font);
        fechaDevolucionLabel.setFont(font);
        informacionLabel.setFont(font);
        verificarPrestamoButton.setFont(font);
        finalizarTransaccionButton.setFont(font);
        informacionTextArea.setFont(font);
    }
}
