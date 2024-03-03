package frontend.registrosinformacionnueva;

import backend.principal.FuncionamientoAplicacion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author ryoumen_kyoma
 */
public class RegistroLibroNuevo extends javax.swing.JPanel {

    private FuncionamientoAplicacion app = new FuncionamientoAplicacion();

    public RegistroLibroNuevo() {
        initComponents();
        this.setBackground(new Color(251, 250, 248)); // Establecer el color de fondo del panel
        // Ajustar el tamaño de los componentes y la fuente
        Font font = new Font("Bitstream Charter", Font.BOLD, 25);
        jLabel1.setFont(new Font("Bitstream Charter", Font.BOLD, 25));
        jLabel2.setFont(font);
        jLabel3.setFont(font);
        jLabel4.setFont(font);
        jLabel5.setFont(font);
        jLabel6.setFont(font);
        jLabel7.setFont(font);
        codigoLibroText.setFont(font);
        autorLibroText.setFont(font);
        tituloLibroText.setFont(font);
        copiasText.setFont(font);
        fechaText.setFont(font);
        editorialText.setFont(font);
        guardarLibroBoton.setFont(font);

        // Configurar el diseño del panel
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets.top = 10;
        gbc.insets.left = 10;
        gbc.insets.right = 10;

        // Agregar componentes al panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridy++;
        add(jLabel7, gbc); // Ajustar la posición de jLabel7
        gbc.gridy++;
        add(jLabel1, gbc);
        gbc.gridy++;
        add(codigoLibroText, gbc);

        gbc.gridy++;
        add(jLabel2, gbc);
        gbc.gridy++;
        add(autorLibroText, gbc);

        gbc.gridy++;
        add(jLabel3, gbc);
        gbc.gridy++;
        add(tituloLibroText, gbc);

        gbc.gridy++;
        add(jLabel4, gbc);
        gbc.gridy++;
        add(copiasText, gbc);

        gbc.gridy++;
        add(jLabel5, gbc);
        gbc.gridy++;
        add(fechaText, gbc);

        gbc.gridy++;
        add(jLabel6, gbc);
        gbc.gridy++;
        add(editorialText, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        add(guardarLibroBoton, gbc);

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        codigoLibroText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        autorLibroText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tituloLibroText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        copiasText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fechaText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        editorialText = new javax.swing.JTextField();
        guardarLibroBoton = new javax.swing.JButton();

        codigoLibroText.setPreferredSize(new Dimension(300, 40));
        autorLibroText.setPreferredSize(new Dimension(300, 40));
        tituloLibroText.setPreferredSize(new Dimension(300, 40));
        copiasText.setPreferredSize(new Dimension(300, 40));
        fechaText.setPreferredSize(new Dimension(300, 40));
        editorialText.setPreferredSize(new Dimension(300, 40));
        setLayout(new java.awt.GridBagLayout());

        jLabel7.setText("NUEVO LIBRO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1; // Colocar a la izquierda
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 8;
        add(jLabel7, gridBagConstraints);

        jLabel1.setText("Código:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(74, 237, 0, 0);
        add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 96;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 212, 10, 0);
        add(codigoLibroText, gridBagConstraints);

        jLabel2.setText("Autor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 242, 0, 0);
        add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 167;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 176, 10, 0);
        add(autorLibroText, gridBagConstraints);

        jLabel3.setText("Título:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 243, 0, 0);
        add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 167;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 176, 10, 0);
        add(tituloLibroText, gridBagConstraints);

        jLabel4.setText("Cantidad de copias (solo valores numéricos):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 111, 0, 0);
        add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 168;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 176, 10, 175);
        add(copiasText, gridBagConstraints);

        jLabel5.setText("Fecha de publicación (yyyy-mm-dd):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 138, 0, 0);
        add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 167;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 176, 10, 0);
        add(fechaText, gridBagConstraints);

        jLabel6.setText("Editorial:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 223, 0, 0);
        add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 168;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 176, 10, 175);
        add(editorialText, gridBagConstraints);

        guardarLibroBoton.setText("Guardar Libro");
        guardarLibroBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarLibroBotonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(44, 199, 61, 0);
        add(guardarLibroBoton, gridBagConstraints);
    }

    private void guardarLibroBotonActionPerformed(java.awt.event.ActionEvent evt) {
        if (validarCamposObligatorios(codigoLibroText.getText(), autorLibroText.getText(), tituloLibroText.getText(), copiasText.getText()) == true && !fechaText.getText().equals(" ") && !editorialText.getText().equals(" ")) {
            //TODOS LOS CAMPOS LLENOS
            validarCodigo(codigoLibroText.getText());
            validarNumero(copiasText.getText());

            if (!app.validarLibroRepetido(codigoLibroText.getText())) {
                app.agregarNuevoLibro(codigoLibroText.getText(), autorLibroText.getText(), tituloLibroText.getText(), Integer.parseInt(copiasText.getText()), fechaText.getText(), editorialText.getText());
                limpiarCampos();
                guardarLibroBoton.setBackground(Color.GREEN);
            } else {
                JOptionPane.showMessageDialog(this, "El libro ya se encuentra registrado en la base de datos");
            }

        } else if (validarCamposObligatorios(codigoLibroText.getText(), autorLibroText.getText(), tituloLibroText.getText(), copiasText.getText()) == true && !fechaText.getText().equals(" ") && editorialText.getText().equals(" ")) {
            //CAMPO DE FECHA VACÍO
            validarCodigo(codigoLibroText.getText());
            validarNumero(copiasText.getText());
            verificarFormatoFecha(fechaText.getText());
            if (!app.validarLibroRepetido(codigoLibroText.getText())) {
                app.agregarNuevoLibro(codigoLibroText.getText(), autorLibroText.getText(), tituloLibroText.getText(), Integer.parseInt(copiasText.getText()), fechaText.getText(), editorialText.getText());
                limpiarCampos();
                guardarLibroBoton.setBackground(Color.GREEN);
            } else {
                JOptionPane.showMessageDialog(this, "El libro ya se encuentra registrado en la base de datos");
            }
        } else if (validarCamposObligatorios(codigoLibroText.getText(), autorLibroText.getText(), tituloLibroText.getText(), copiasText.getText()) == true && fechaText.getText().equals(" ") && !editorialText.getText().equals(" ")) {
            //CAMPO DE EDITORIAL VACÍO
            validarCodigo(codigoLibroText.getText());
            validarNumero(copiasText.getText());

            if (!app.validarLibroRepetido(codigoLibroText.getText())) {
                app.agregarNuevoLibro(codigoLibroText.getText(), autorLibroText.getText(), tituloLibroText.getText(), Integer.parseInt(copiasText.getText()), fechaText.getText(), editorialText.getText());
                limpiarCampos();
                guardarLibroBoton.setBackground(Color.GREEN);
            } else {
                JOptionPane.showMessageDialog(this, "El libro ya se encuentra registrado en la base de datos");
            }
        } else if (validarCamposObligatorios(codigoLibroText.getText(), autorLibroText.getText(), tituloLibroText.getText(), copiasText.getText()) == true && fechaText.getText().equals(" ") && editorialText.getText().equals(" ")) {
            //CAMPO DE FECHA Y EDITORIAL VACÍO
            validarCodigo(codigoLibroText.getText());
            validarNumero(copiasText.getText());
            if (!app.validarLibroRepetido(codigoLibroText.getText())) {
                app.agregarNuevoLibro(codigoLibroText.getText(), autorLibroText.getText(), tituloLibroText.getText(), Integer.parseInt(copiasText.getText()), fechaText.getText(), editorialText.getText());
                limpiarCampos();
                guardarLibroBoton.setBackground(Color.GREEN);
            } else {
                JOptionPane.showMessageDialog(this, "El libro ya se encuentra registrado en la base de datos");
            }
            app.agregarNuevoLibro(codigoLibroText.getText(), autorLibroText.getText(), tituloLibroText.getText(), Integer.parseInt(copiasText.getText()), " ", " ");
        } else {
            guardarLibroBoton.setBackground(Color.red);
        }
    }

    private void validarCodigo(String codigo) {
        String[] codigoLibro = codigo.split("-");

        try {
            int formato = Integer.parseInt(codigoLibro[0]);

            if (codigoLibro[0].length() != 3 || codigoLibro[1].length() != 3) {
                JOptionPane.showMessageDialog(this, "Formáto de código de libro inválido.\n\nEl formáto debe contener tres dígitos, guión, tres mayúsculas.\nEj. 123-ABC");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Formáto de código de libro inválido.\n\nEl formáto debe contener tres dígitos, guión, tres mayúsculas.\nEj. 123-ABC");
        }
    }

    private void validarNumero(String texto) {
        try {
            int numero = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ERROR.\nDebe llenar el campo con números");
        }
    }

    private boolean validarCamposObligatorios(String codigo, String autor, String titulo, String cantidadCopias) {
        if (codigo.equals(" ") && autor.equals(" ") && titulo.equals(" ") && cantidadCopias.equals(" ")) {
            JOptionPane.showMessageDialog(this, "Por favor llene los campos obligatorios.\n\n Campos obligatorios: Código, Autor, Título, Cantidad de copias");
            return false;
        }
        return true;
    }

    private void verificarFormatoFecha(String texto) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            formato.parse(texto);
            limpiarCampos();
            guardarLibroBoton.setBackground(Color.GREEN);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al ingresar la fecha\nEl formato es yyyy-mm-dd");
            guardarLibroBoton.setBackground(Color.RED);
        }
    }

    private void limpiarCampos() {
        codigoLibroText.setText("");
        autorLibroText.setText("");
        tituloLibroText.setText("");
        copiasText.setText("");
        fechaText.setText("");
        editorialText.setText("");
        guardarLibroBoton.setBackground(Color.GREEN);
    }

    private void mostrarDatos() {
        System.out.println(fechaText.getText());
        System.out.println(editorialText.getText());
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField autorLibroText;
    private javax.swing.JTextField codigoLibroText;
    private javax.swing.JTextField copiasText;
    private javax.swing.JTextField editorialText;
    private javax.swing.JTextField fechaText;
    private javax.swing.JButton guardarLibroBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField tituloLibroText;
    // End of variables declaration                   
}
