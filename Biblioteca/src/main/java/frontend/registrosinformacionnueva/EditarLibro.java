/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend.registrosinformacionnueva;

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
public class EditarLibro extends JPanel{
    private FuncionamientoAplicacion app = new FuncionamientoAplicacion();

    public EditarLibro() {
        initComponents();
        this.setBackground(new java.awt.Color(251, 250, 248));
        Font font = new Font("Bitstream Charter", Font.BOLD, 30);
        jLabel1.setFont(font);
        jLabel2.setFont(font);
    }
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codigoLibroText = new javax.swing.JTextField();
        buscarLibroButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        informacionLibroTextArea = new javax.swing.JTextArea();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Mostrar Información del Libro:");
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
    }
    private void buscarLibroButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String codigoLibro = codigoLibroText.getText();
        Libro libro = app.buscarLibroPorCodigo(codigoLibro);
        if (libro != null) {
            int option = JOptionPane.showConfirmDialog(this, "¿Desea editar el contenido de este libro?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                // Permitir la edición del contenido del libro
                
                
                // Mostrar el nuevo contenido del libro
                informacionLibroTextArea.setText("Título: " + libro.getTitulo() + "\n" +
                                                  "Autor: " + libro.getAutor() + "\n" +
                                                  "Editorial: " + libro.getEditorial() + "\n" +
                                                  "Fecha de Publicación: " + libro.getFechaPublicacion() + "\n" +
                                                  "Cantidad Disponible: " + libro.getCantidadCopias() + "\n");
            } else {
                informacionLibroTextArea.setText("Título: " + libro.getTitulo() + "\n" +
                                                  "Autor: " + libro.getAutor() + "\n" +
                                                  "Editorial: " + libro.getEditorial() + "\n" +
                                                  "Fecha de Publicación: " + libro.getFechaPublicacion() + "\n" +
                                                  "Cantidad Disponible: " + libro.getCantidadCopias() + "\n");
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

    // Variables declaration
    private javax.swing.JButton buscarLibroButton;
    private javax.swing.JTextField codigoLibroText;
    private javax.swing.JTextArea informacionLibroTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration
}
