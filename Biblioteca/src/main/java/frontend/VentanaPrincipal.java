package frontend;

import frontend.registrosinformacionnueva.RegistroEstudianteNuevo;
import frontend.registrosinformacionnueva.RegistroLibroNuevo;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author michael
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Dimension dimension = toolkit.getScreenSize();
    private RegistroLibroNuevo libroNuevo = new RegistroLibroNuevo();
    private RegistroEstudianteNuevo estudianteNuevo = new RegistroEstudianteNuevo();

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        this.setSize(dimension.width - 350, dimension.height - 200);
        this.setTitle("BIBLIOTECA");
        this.setLocationRelativeTo(null);
        pintarPanel(libroNuevo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorPanel = new javax.swing.JPanel();
        barraMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        prestarLibroBoton = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(568, 418));

        javax.swing.GroupLayout contenedorPanelLayout = new javax.swing.GroupLayout(contenedorPanel);
        contenedorPanel.setLayout(contenedorPanelLayout);
        contenedorPanelLayout.setHorizontalGroup(
            contenedorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 825, Short.MAX_VALUE)
        );
        contenedorPanelLayout.setVerticalGroup(
            contenedorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(contenedorPanel, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Archivo");

        prestarLibroBoton.setText("Libro Nuevo");
        prestarLibroBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prestarLibroBotonActionPerformed(evt);
            }
        });
        jMenu1.add(prestarLibroBoton);

        jMenuItem2.setText("Estudiante Nuevo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Importar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        barraMenu.add(jMenu1);

        jMenu2.setText("Editar");

        jMenuItem4.setText("Editar Libro");
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Editar Estudiante");
        jMenu2.add(jMenuItem5);

        barraMenu.add(jMenu2);

        jMenu3.setText("Préstamos");

        jMenuItem6.setText("Inventario");
        jMenu3.add(jMenuItem6);

        jMenuItem7.setText("Prestar Libro");
        jMenu3.add(jMenuItem7);

        barraMenu.add(jMenu3);

        setJMenuBar(barraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prestarLibroBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prestarLibroBotonActionPerformed
        pintarPanel(libroNuevo);
    }//GEN-LAST:event_prestarLibroBotonActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        pintarPanel(estudianteNuevo);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
        chooser.setFileFilter(filtro);
        int seleccion = chooser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            String nombreArchivo = chooser.getSelectedFile().getName();
            String extension = nombreArchivo.substring(nombreArchivo.lastIndexOf('.') + 1).toLowerCase();

            if (extension.equals("txt") || extension.equals("py")) {
              /*  String textoLeido = miArchivo.abrirArchivo(chooser.getSelectedFile().getAbsolutePath());
                this.pintarPanel(editor);
                editor.setAreaEditor(textoLeido);*/
            } else {
                JOptionPane.showMessageDialog(this, "Solo se permiten archivos .txt y .py", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JPanel contenedorPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem prestarLibroBoton;
    // End of variables declaration//GEN-END:variables

    private void pintarPanel(Component panel) {
        contenedorPanel.removeAll();
        contenedorPanel.setLayout(new BorderLayout());
        panel.setSize(contenedorPanel.getWidth(), contenedorPanel.getHeight());
        contenedorPanel.add(panel);
        contenedorPanel.repaint();
        contenedorPanel.revalidate();
    }
}
