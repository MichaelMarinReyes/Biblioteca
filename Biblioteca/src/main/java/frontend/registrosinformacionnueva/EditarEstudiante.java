/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend.registrosinformacionnueva;

import backend.principal.Estudiante;
import backend.principal.FuncionamientoAplicacion;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
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
public class EditarEstudiante extends JPanel {

    private FuncionamientoAplicacion app = new FuncionamientoAplicacion();
    private JTextField codigoEstudianteText;
    private JTextArea informacionEstudianteTextArea;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;

    public EditarEstudiante() {
        initComponents();
        this.setBackground(new java.awt.Color(251, 250, 248));
        Font font = new Font("Bitstream Charter", Font.BOLD, 30);
        jLabel1.setFont(font);
        jLabel2.setFont(font);
    }

    private void initComponents() {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        codigoEstudianteText = new JTextField();
        JButton buscarEstudianteButton = new JButton("Buscar Estudiante");
        buscarEstudianteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buscarEstudianteButtonActionPerformed(evt);
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
        informacionEstudianteTextArea = new JTextArea();

        setLayout(new GridBagLayout());

        jLabel1.setText("Edición de Estudiantes Almacenados:");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(20, 20, 10, 0);
        add(jLabel1, gridBagConstraints);

        jLabel2.setText("Código del Estudiante:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(20, 20, 0, 0);
        add(jLabel2, gridBagConstraints);

        codigoEstudianteText.setColumns(15);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 20, 0, 0);
        add(codigoEstudianteText, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 20, 0, 0);
        add(buscarEstudianteButton, gridBagConstraints);

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

        informacionEstudianteTextArea.setEditable(false);
        informacionEstudianteTextArea.setColumns(20);
        informacionEstudianteTextArea.setRows(5);
        jScrollPane1.setViewportView(informacionEstudianteTextArea);

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

    private void buscarEstudianteButtonActionPerformed(ActionEvent evt) {
        Map<Integer, String> carreras = new HashMap<>();
        carreras.put(1, "Ingeniería");
        carreras.put(2, "Medicina");
        carreras.put(3, "Derecho");
        carreras.put(4, "Arquitectura");
        carreras.put(5, "Administración");
        String codigoEstudiante = codigoEstudianteText.getText();
        Estudiante estudiante = app.buscarEstudiantePorCarnet(codigoEstudiante);
        if (estudiante != null) {
            // Obtener el nombre de la carrera basado en el código de carrera
            String nombreCarrera = carreras.get(estudiante.getCodigoCarrera());

            informacionEstudianteTextArea.setText("Nombre: " + estudiante.getNombre() + "\n"
                    + "Carnet: " + estudiante.getCarnet() + "\n"
                    + "Código de Carrera: " + estudiante.getCodigoCarrera() + " - " + nombreCarrera + "\n"
                    + "Fecha de Nacimiento: " + estudiante.getFechaNacimiento() + "\n");
        } else {
            JOptionPane.showMessageDialog(this, "El estudiante no existe.");
            limpiarCampos();
        }
    }

    private void cambiosButtonActionPerformed(ActionEvent evt) {
        String codigoEstudiante = codigoEstudianteText.getText();
        Estudiante estudiante = app.buscarEstudiantePorCarnet(codigoEstudiante);
        if (estudiante != null) {
            String nuevoNombre = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre:", estudiante.getNombre());
            int nuevoCodigoCarrera = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el nuevo código de carrera:", estudiante.getCodigoCarrera()));
            String nuevaFechaNacimientoStr = JOptionPane.showInputDialog(this, "Ingrese la nueva fecha de nacimiento (yyyy-MM-dd):", estudiante.getFechaNacimiento());

            // Convertir la cadena a LocalDate
            LocalDate nuevaFechaNacimiento = LocalDate.parse(nuevaFechaNacimientoStr);

            // Mostrar los cambios en el JTextArea sin guardarlos en el array
            informacionEstudianteTextArea.setText("Nombre: " + nuevoNombre + "\n"
                    + "Carnet: " + estudiante.getCarnet() + "\n"
                    + "Código de Carrera: " + nuevoCodigoCarrera + "\n"
                    + "Fecha de Nacimiento: " + nuevaFechaNacimiento + "\n");

            // Mostrar los cambios en la consola
            System.out.println("Se han realizado cambios en el estudiante:");
            System.out.println("Nuevo nombre: " + nuevoNombre);
            System.out.println("Nuevo código de carrera: " + nuevoCodigoCarrera);
            System.out.println("Nueva fecha de nacimiento: " + nuevaFechaNacimiento);
        } else {
            JOptionPane.showMessageDialog(this, "El estudiante no existe.");
            limpiarCampos();
        }
    }

    private void guardarCambiosConfirmarButtonActionPerformed(ActionEvent evt) {
    String codigoEstudiante = codigoEstudianteText.getText();
    Estudiante estudiante = app.buscarEstudiantePorCarnet(codigoEstudiante);
    if (estudiante != null) {
        int option = JOptionPane.showConfirmDialog(this, "¿Desea guardar los cambios?", "Guardar Cambios", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            // Obtener el texto del JTextArea
            String textoEstudiante = informacionEstudianteTextArea.getText();
            String[] lineas = textoEstudiante.split("\\n");
            // Extraer los valores de cada línea
            String nuevoNombre = lineas[0].replace("Nombre: ", "");
            int nuevoCodigoCarrera = Integer.parseInt(lineas[2].replace("Código de Carrera: ", "").split(" - ")[0]);
            // Fecha de Nacimiento
            String fechaNacimientoStr = lineas[3].replace("Fecha de Nacimiento: ", "");
            LocalDate nuevaFechaNacimiento = LocalDate.parse(fechaNacimientoStr);
            
            // Actualizar el objeto estudiante con los nuevos valores
            estudiante.setNombre(nuevoNombre);
            estudiante.setCodigoCarrera(nuevoCodigoCarrera);
            estudiante.setFechaNacimiento(nuevaFechaNacimiento);
            app.actualizarEstudiante(estudiante);
            JOptionPane.showMessageDialog(this, "Cambios guardados exitosamente.");
            limpiarCampos();
        }
    } else {
        JOptionPane.showMessageDialog(this, "El estudiante no existe.");
        limpiarCampos();
    }
}

    private void limpiarCampos() {
        informacionEstudianteTextArea.setText("");
        codigoEstudianteText.setText("");
    }
}
