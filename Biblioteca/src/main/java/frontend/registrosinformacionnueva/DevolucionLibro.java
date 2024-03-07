/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend.registrosinformacionnueva;

import backend.principal.Estudiante;
import backend.principal.FuncionamientoAplicacion;
import backend.principal.Libro;
import backend.principal.Prestamo;
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
    private String codigoLibro;

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
        Estudiante estudiante = app.buscarEstudiantePorCarnet(Integer.parseInt(carnet));
        if (estudiante == null) {
            JOptionPane.showMessageDialog(this, "El estudiante no existe.");
            limpiarCampos();
            return;
        }

        // Verificar si el libro existe
        Libro libro = app.buscarLibroPorCodigo(codigoLibro);
        if (libro == null) {
            JOptionPane.showMessageDialog(this, "El libro no existe.");
            limpiarCampos();
            return;
        }

        // Verificar formato de fecha de devolución
        if (!fechaDevolucionString.matches("\\d{4}-\\d{2}-\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Formato de fecha de devolución inválido. Utilice el formato yyyy-mm-dd.");
            limpiarCampos();
            return;
        }
        LocalDate fechaDevolucion = LocalDate.parse(fechaDevolucionString);
        LocalDate fechaActual = LocalDate.now();
        long diasPrestamo = fechaActual.until(fechaDevolucion).getDays();
        LocalDate fechaDevolucionTardia;
        if (fechaActual.isAfter(fechaDevolucion)) {
            fechaDevolucionTardia = fechaActual;
        } else {
            fechaDevolucionTardia = fechaDevolucion;
        }

        long diasMora = 0;
        if (fechaDevolucionTardia.isAfter(fechaDevolucion)) {
            diasMora = fechaDevolucion.until(fechaDevolucionTardia).getDays();
        }
        double monto = (5 * diasPrestamo) + (10 * diasMora);

        // Buscar el préstamo correspondiente
        Prestamo prestamo = app.obtenerPrestamo(codigoLibro, Integer.parseInt(carnet));
        if (prestamo == null) {
            JOptionPane.showMessageDialog(this, "No se encontró ningún préstamo con las características especificadas.");
            limpiarCampos();
            return;
        }

        // Mostrar información del préstamo en el TextArea
        informacionTextArea.setText("Carnet del Estudiante: " + estudiante.getCarnet() + "\n"
                + "Nombre del Estudiante: " + estudiante.getNombre() + "\n"
                + "Código del Libro: " + libro.getCodigo() + "\n"
                + "Nombre del Libro: " + libro.getTitulo() + "\n"
                + "Fecha de Préstamo: " + prestamo.getFechaPrestamo() + "\n"
                + "Fecha de Devolución: " + prestamo.getFechaDevolucion() + "\n"
                + "Días de Préstamo: " + diasPrestamo + "\n"
                + "Días de Mora: " + diasMora + "\n"
                + "Monto del Préstamo: Q. " + monto);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El carné debe ser un número entero.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error.\nVerifique que haya ingresado correctamente los datos");
    }
}

    private void finalizarTransaccion() {
        String codigoLibro = codigoLibroText.getText();
        int carnetEstudiante = Integer.parseInt(carnetText.getText());

        // Obtener el préstamo correspondiente
        Prestamo prestamo = app.obtenerPrestamo(codigoLibro, carnetEstudiante);

        if (prestamo != null) {
            // Agregar detalles de la devolución a listaDevolucion
            app.agregarDevoluciones(prestamo);
            JOptionPane.showMessageDialog(this, "Transacción finalizada. ¡Gracias por su visita!");
        } else {
            JOptionPane.showMessageDialog(this, "No hay ningún préstamo con estas características.");
        }

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
