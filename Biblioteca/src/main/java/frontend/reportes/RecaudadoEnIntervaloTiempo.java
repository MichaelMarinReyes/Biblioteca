package frontend.reportes;

import backend.principal.FuncionamientoAplicacion;
import backend.principal.Prestamo;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author michael
 */
public class RecaudadoEnIntervaloTiempo extends javax.swing.JPanel {

    private JTextField textFieldFechaInicio;
    private JTextField textFieldFechaFin;
    private TableRowSorter<TableModel> rowSorter;

    /**
     * Creates new form RecaudadoEnIntervaloTiempo
     */
    public RecaudadoEnIntervaloTiempo() {
        initComponents();
        actualizarTablaIngresosIntervaloTiempo();
        ajustarColumnaTexto();
        agregarCampoBusqueda();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReportes = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        tablaReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaReportes);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaReportes;
    // End of variables declaration//GEN-END:variables

    public void actualizarTablaIngresosIntervaloTiempo() {
        String[] columnaDevolucionHoy = {"No.", "Carnet", "Nombre", "Código de libro", "Título", "Fecha de préstamo", "Fecha de devolución"};
        DefaultTableModel modelo = new DefaultTableModel(columnaDevolucionHoy, FuncionamientoAplicacion.listaPrestamos.size());
        tablaReportes.setModel(modelo);

        TableModel modeloDatos = tablaReportes.getModel();
        for (int i = 0; i < FuncionamientoAplicacion.listaPrestamos.size(); i++) {
            Prestamo estudiante = FuncionamientoAplicacion.listaPrestamos.get(i);
            modeloDatos.setValueAt(String.valueOf(i + 1), i, 0);
            modeloDatos.setValueAt(estudiante.getEstudiante().getCarnet(), i, 1);
            modeloDatos.setValueAt(estudiante.getEstudiante().getNombre(), i, 2);
            modeloDatos.setValueAt(estudiante.getLibro().getCodigo(), i, 3);
            modeloDatos.setValueAt(estudiante.getLibro().getTitulo(), i, 4);
            modeloDatos.setValueAt(estudiante.getFechaPrestamo(), i, 5);
            modeloDatos.setValueAt(estudiante.getFechaPrestamo(), i, 6);
        }
        FuncionamientoAplicacion.guardarSerializableLibros();
    }

    private void ajustarColumnaTexto() {
        TableColumnModel columnModel = tablaReportes.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(0).setMaxWidth(40);
        columnModel.getColumn(0).setMinWidth(40);

        int rowCount = tablaReportes.getRowCount();
        int column = 0;

        for (int row = 0; row < rowCount; row++) {
            int width = (int) tablaReportes.getCellRenderer(row, column).getTableCellRendererComponent(tablaReportes, tablaReportes.getValueAt(row, column), false, false, row, column).getPreferredSize().getWidth();
            width += 2 * tablaReportes.getIntercellSpacing().getWidth();
            columnModel.getColumn(column).setPreferredWidth(Math.max(columnModel.getColumn(column).getPreferredWidth(), width));
        }
    }

    private void agregarCampoBusqueda() {
        JPanel panelBusqueda = new JPanel();
        panelBusqueda.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5)); // Establecer el layout para organizar los componentes centrados en una fila

        JLabel labelFechaInicio = new JLabel("Fecha inicio (YYYY-MM-DD):");
        panelBusqueda.add(labelFechaInicio); // Agregar la etiqueta de fecha inicio al panel de búsqueda

        textFieldFechaInicio = new JTextField();
        textFieldFechaInicio.setPreferredSize(new Dimension(120, 30)); // Establecer el tamaño preferido para textFieldFechaInicio
        textFieldFechaInicio.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarTabla();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarTabla();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarTabla();
            }
        });
        panelBusqueda.add(textFieldFechaInicio); // Agregar textFieldFechaInicio al panel de búsqueda

        JLabel labelFechaFin = new JLabel("Fecha final (YYYY-MM-DD):");
        panelBusqueda.add(labelFechaFin); // Agregar la etiqueta de fecha final al panel de búsqueda

        textFieldFechaFin = new JTextField();
        textFieldFechaFin.setPreferredSize(new Dimension(120, 30)); // Establecer el tamaño preferido para textFieldFechaFin
        textFieldFechaFin.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarTabla();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarTabla();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarTabla();
            }
        });
        panelBusqueda.add(textFieldFechaFin); // Agregar textFieldFechaFin al panel de búsqueda

        add(panelBusqueda, java.awt.BorderLayout.NORTH); // Agregar el panel de búsqueda al JPanel principal
    }

    private void filtrarTabla() {
        if (rowSorter == null) {
            rowSorter = new TableRowSorter<>(tablaReportes.getModel());
            tablaReportes.setRowSorter(rowSorter);
        }

        RowFilter<TableModel, Integer> filtro = new RowFilter<TableModel, Integer>() {
            @Override
            public boolean include(javax.swing.RowFilter.Entry<? extends TableModel, ? extends Integer> entry) {
                String fechaInicioText = textFieldFechaInicio.getText();
                String fechaFinText = textFieldFechaFin.getText();
                if (fechaInicioText.isEmpty() || fechaFinText.isEmpty()) {
                    return true; // Si están vacíos, mostrar todas las filas
                }

                try {
                    LocalDate fechaInicio = LocalDate.parse(fechaInicioText);
                    LocalDate fechaFin = LocalDate.parse(fechaFinText);
                    LocalDate fechaPrestamo = LocalDate.parse(entry.getStringValue(5)); // Obtener la fecha de préstamo
                    return (fechaPrestamo.isEqual(fechaInicio) || fechaPrestamo.isAfter(fechaInicio))
                            && (fechaPrestamo.isEqual(fechaFin) || fechaPrestamo.isBefore(fechaFin.plusDays(1))); // Incluir también los registros del día final
                } catch (DateTimeParseException e) {
                    return false; // No incluir esta fila en el filtro
                }
            }
        };

        rowSorter.setRowFilter(filtro);
    }
}
