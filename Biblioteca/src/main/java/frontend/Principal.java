/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ryoumen_kyoma
 */
public class Principal extends javax.swing.JFrame {

    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Dimension dimension = toolkit.getScreenSize();
    private Image imagenFondo = new ImageIcon(getClass().getResource("/imagenes/logo.jpg")).getImage();
    private JLabel relojLabel;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setSize(dimension.width - 350, dimension.height - 200);
        this.setTitle("BIBLIOTECA");
        this.setLocationRelativeTo(null);

        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
            }
        });

        JMenuBar menuPrincipal = new JMenuBar();
        JMenu menuLibros = new JMenu("Libros");
        JMenu menuUsuarios = new JMenu("Usuarios");
        JMenu menuRegistros = new JMenu("Registros");
        JMenu menuReportes = new JMenu("Reportes");
        menuPrincipal.add(menuLibros);
        menuPrincipal.add(menuUsuarios);
        menuPrincipal.add(menuRegistros);
        menuPrincipal.add(menuReportes);
        //agregar iconos a cada menu
        ImageIcon iconoAbrirRegistros = new ImageIcon(getClass().getResource("/imagenes/abrir_reportes_icono.png"));
        Image imageAbrirRegistros = iconoAbrirRegistros.getImage();
        Image newImageAbrirRegistros = imageAbrirRegistros.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconoAbrirRegistros = new ImageIcon(newImageAbrirRegistros);
        ImageIcon iconoLibros = new ImageIcon(getClass().getResource("/imagenes/libros_icono.png"));
        Image image = iconoLibros.getImage();
        Image newImage = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconoLibros = new ImageIcon(newImage);
        ImageIcon iconoUsuario = new ImageIcon(getClass().getResource("/imagenes/usuarios_icono.png"));
        Image imageUsuarios = iconoUsuario.getImage();
        Image newImageUsuarios = imageUsuarios.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconoUsuario = new ImageIcon(newImageUsuarios);
        ImageIcon iconoUsuarioNuevo = new ImageIcon(getClass().getResource("/imagenes/agregar_usuarios_icono.png"));
        Image imageUsuariosNuevo = iconoUsuarioNuevo.getImage();
        Image newImageUsuariosNuevos = imageUsuariosNuevo.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconoUsuarioNuevo = new ImageIcon(newImageUsuariosNuevos);
        ImageIcon iconoReportes = new ImageIcon(getClass().getResource("/imagenes/reportes_icono.png"));
        Image imageReportes = iconoReportes.getImage();
        Image newImageReportes = imageReportes.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconoReportes = new ImageIcon(newImageReportes);
        //creacion de items en cada menu
        //items libros
        JMenuItem itemLibros01 = new JMenuItem("Nuevo Libro", iconoLibros);
        JMenuItem itemLibros02 = new JMenuItem("Editar Libro", iconoLibros);
        JMenuItem itemLibros03 = new JMenuItem("Prestar Libro", iconoLibros);
        //items usuarios
        JMenuItem itemUsuarios01 = new JMenuItem("Nuevo Estudiante", iconoUsuarioNuevo);
        JMenuItem itemUsuarios02 = new JMenuItem("Editar Estudiante", iconoUsuario);
        //items registros
        JMenuItem itemImportarRegistros = new JMenuItem("Importar Registros", iconoAbrirRegistros);
        //items reportes
        JMenuItem itemGenerarReporte = new JMenuItem("Generar Reporte",iconoReportes);
        //agregar al menu
        menuLibros.add(itemLibros01);
        menuLibros.add(itemLibros02);
        menuLibros.add(itemLibros03);
        menuUsuarios.add(itemUsuarios01);
        menuUsuarios.add(itemUsuarios02);
        menuRegistros.add(itemImportarRegistros);
        menuReportes.add(itemGenerarReporte);

        // Acción para Abrir Registros
        itemImportarRegistros.addActionListener((ActionEvent e) -> {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
            chooser.setFileFilter(filtro);
            int seleccion = chooser.showOpenDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                String nombreArchivo = chooser.getSelectedFile().getName();
                String extension = nombreArchivo.substring(nombreArchivo.lastIndexOf('.') + 1).toLowerCase();

                if (extension.equals("txt")) {
                    String rutaArchivo = chooser.getSelectedFile().getAbsolutePath();
                    System.out.println("Ruta del archivo seleccionado: " + rutaArchivo);
                } else {
                    JOptionPane.showMessageDialog(this, "Solo se permiten archivos .txt", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //personalizar menu
        Font menuFont = new Font("Arial", Font.BOLD, 25);
        menuPrincipal.setFont(menuFont);
        for (int i = 0; i < menuPrincipal.getMenuCount(); i++) {
            JMenu menu = menuPrincipal.getMenu(i);
            menu.setFont(menuFont);
            for (int j = 0; j < menu.getItemCount(); j++) {
                JMenuItem menuItem = menu.getItem(j);
                menuItem.setFont(menuFont);
            }
        }

        // Establece el diseño de la barra de menú
        menuPrincipal.setLayout(new BoxLayout(menuPrincipal, BoxLayout.X_AXIS));

        // Establece la barra de menú en el marco
        setJMenuBar(menuPrincipal);
        //panel de mensaje random
        JPanel panelTexto = new JPanel(new BorderLayout());
        JLabel label = new JLabel("¿QUE TE GUSTARÍA HACER HOY?");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setForeground(Color.BLUE);
        label.setOpaque(true);
        label.setBackground(new Color(251, 250, 248));
        panelTexto.add(label, BorderLayout.CENTER);
        add(panelTexto, BorderLayout.CENTER); // Añade el panel de texto al centro del JFrame
        //panel de fecha y hora
        JPanel panelReloj = new JPanel(new BorderLayout());
        relojLabel = new JLabel();
        relojLabel.setHorizontalAlignment(JLabel.RIGHT);
        relojLabel.setFont(new Font("Bitstream Charter", Font.BOLD, 30));
        relojLabel.setForeground(Color.BLACK);
        panelReloj.add(relojLabel, BorderLayout.CENTER);
        panelReloj.setPreferredSize(new Dimension(getWidth(), 50)); // Establece el tamaño del panel del reloj
        panelReloj.setBackground(new Color(251, 250, 248)); // Establece el color de fondo del panel del reloj
        add(panelReloj, BorderLayout.PAGE_END); // Añade el panel del reloj a la parte inferior del JFrame

        // Iniciar el reloj
        iniciarReloj();
    }

    private void iniciarReloj() {
        Thread hiloReloj = new Thread(() -> {
            while (true) {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
                SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss a");
                String fecha = formatoFecha.format(new Date());
                String hora = formatoHora.format(new Date());
                relojLabel.setText("CUNOC;" + " " + fecha + " " + hora);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        hiloReloj.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
