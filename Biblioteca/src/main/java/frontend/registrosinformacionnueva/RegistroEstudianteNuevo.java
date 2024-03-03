/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend.registrosinformacionnueva;

import backend.principal.FuncionamientoAplicacion;
import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ryoumen_kyoma
 */
public class RegistroEstudianteNuevo extends javax.swing.JPanel {

    private FuncionamientoAplicacion app = new FuncionamientoAplicacion();

    public RegistroEstudianteNuevo() {
        initComponents();
        this.setBackground(new Color(251, 250, 248));
        // Agregamos números y nombres de carrera al combo box
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        modelo.addElement("1 - Ingeniería");
        modelo.addElement("2 - Medicina");
        modelo.addElement("3 - Derecho");
        modelo.addElement("4 - Arquitectura");
        modelo.addElement("5 - Administración");
        codigoCarreraComboBox.setModel(modelo);

        // Para ajustar el tamaño de los componentes y la fuente
        Font font = new Font("Bitstream Charter", Font.BOLD, 30);
        jLabel1.setFont(new Font("Bitstream Charter", Font.BOLD, 30));
        jLabel2.setFont(font);
        jLabel3.setFont(font);
        jLabel4.setFont(font);
        jLabel5.setFont(font);
        carnetText.setFont(font);
        nombreText.setFont(font);
        fechaText.setFont(font);
        codigoCarreraComboBox.setFont(font);
        guardarEstudianteBoton.setFont(font);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        carnetText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nombreText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fechaText = new javax.swing.JTextField();
        guardarEstudianteBoton = new javax.swing.JButton();
        codigoCarreraComboBox = new javax.swing.JComboBox<>();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("NUEVO ESTUDIANTE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 164, 0, 0);
        add(jLabel1, gridBagConstraints);

        jLabel2.setText("Carné:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 191, 0, 0);
        add(jLabel2, gridBagConstraints);

        carnetText.setColumns(15);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 191, 0, 0);
        add(carnetText, gridBagConstraints);

        jLabel3.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 191, 0, 0);
        add(jLabel3, gridBagConstraints);

        nombreText.setColumns(15);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 279;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 191, 0, 0);
        add(nombreText, gridBagConstraints);

        jLabel4.setText("Carrera:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 191, 0, 0);
        add(jLabel4, gridBagConstraints);

        codigoCarreraComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1 - Ingeniería", "2 - Medicina", "3 - Derecho", "4 - Arquitectura", "5 - Administración"}));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 191, 0, 0);
        add(codigoCarreraComboBox, gridBagConstraints);

        jLabel5.setText("Fecha de nacimiento (yyyy-mm-dd):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 191, 0, 0);
        add(jLabel5, gridBagConstraints);

        fechaText.setColumns(15);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 191, 0, 0);
        add(fechaText, gridBagConstraints);

        guardarEstudianteBoton.setText("Guardar Estudiante");
        guardarEstudianteBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    guardarEstudianteBotonActionPerformed(evt);
                } catch (ParseException ex) {
                    Logger.getLogger(RegistroEstudianteNuevo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 191, 0, 0);
        add(guardarEstudianteBoton, gridBagConstraints);
    }

    private void guardarEstudianteBotonActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {
        String carreraSeleccionada = codigoCarreraComboBox.getSelectedItem().toString();
        String[] partesCarrera = carreraSeleccionada.split(" ");
        String numeroCarrera = partesCarrera[0]; // Extraer el número de la carrera seleccionada

        if (verificarCamposObligatorios(carnetText.getText(), nombreText.getText(), numeroCarrera) && !fechaText.getText().isEmpty()) {
            try {
                verificarFormatoFecha(fechaText.getText());                
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate fecha = LocalDate.parse(fechaText.getText(), format);
                if (!app.validarEstudiantesRepetidos(carnetText.getText())) {
                    app.agregarNuevoEstudiante(Integer.parseInt(carnetText.getText()), nombreText.getText(), codigoCarreraComboBox.getSelectedIndex(), fecha);
                    guardarEstudianteBoton.setBackground(Color.green);
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "El estudiante ya se encuentra registrado en la base de datos");
                    guardarEstudianteBoton.setBackground(Color.red);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Código de carrera inválido.\n\nCódigos de carreras:\nIngeniería: 1\nMedicina: 2\nDerecho: 3\nArquitectura: 4\nAdministración: 5");
                guardarEstudianteBoton.setBackground(Color.red);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor llene los campos obligatorios.");
            guardarEstudianteBoton.setBackground(Color.red);
        }
    }

    private boolean verificarCamposObligatorios(String carnet, String nombre, String codigoCarrera) {
        return !(carnet.isEmpty() || nombre.isEmpty() || codigoCarrera.isEmpty());
    }

    private void verificarFormatoFecha(String texto) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        formato.parse(texto);
    }

    private void limpiarCampos() {
        carnetText.setText("");
        nombreText.setText("");
        fechaText.setText("");
    }

    // Variables declaration
    private javax.swing.JTextField carnetText;
    private javax.swing.JComboBox<String> codigoCarreraComboBox;
    private javax.swing.JTextField fechaText;
    private javax.swing.JButton guardarEstudianteBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nombreText;
    // End of variables declaration

}
