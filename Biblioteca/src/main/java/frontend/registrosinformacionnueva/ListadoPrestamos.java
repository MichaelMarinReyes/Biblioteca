package frontend.registrosinformacionnueva;

import backend.principal.FuncionamientoAplicacion;
import backend.principal.Prestamo;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ryoumen_kyoma
 */
public class ListadoPrestamos extends javax.swing.JPanel {

    private JTextField textFieldBusqueda;
    private TableRowSorter<TableModel> rowSorter;

    /**
     * Creates new form ListadoEstudiantes
     */
    public ListadoPrestamos() {
        initComponents();
        actualizarTablaPrestamos();
        agregarCampoBusqueda();
        ajustarColumnaTexto();
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
        tablaPrestamos = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        tablaPrestamos = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tablaPrestamos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaPrestamos);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPrestamos;
    // End of variables declaration//GEN-END:variables

    private void agregarCampoBusqueda() {
        textFieldBusqueda = new JTextField();
        textFieldBusqueda.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarTabla(textFieldBusqueda.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarTabla(textFieldBusqueda.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarTabla(textFieldBusqueda.getText());
            }
        });
        add(textFieldBusqueda, java.awt.BorderLayout.NORTH);
    }

    private void filtrarTabla(String texto) {
        if (rowSorter == null) {
            rowSorter = new TableRowSorter<>(tablaPrestamos.getModel());
            tablaPrestamos.setRowSorter(rowSorter);
        }
        if (texto.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
        }
    }

    public void actualizarTablaPrestamos() {
        String[] columnas = {"No.", "Codigo del libro", "Título del libro", "Carnet de estudiante", "Nombre estudiante", "Fecha de préstamo", "Fecha de devolución", "Días con mora", "Libros prestados"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, FuncionamientoAplicacion.listaPrestamos.size());
        tablaPrestamos.setModel(modelo);

        TableModel modeloDatos = tablaPrestamos.getModel();
        for (int i = 0; i < FuncionamientoAplicacion.listaPrestamos.size(); i++) {
            Prestamo prestamo = FuncionamientoAplicacion.listaPrestamos.get(i);
            modeloDatos.setValueAt(String.valueOf(i + 1), i, 0);
            modeloDatos.setValueAt(prestamo.getLibro().getCodigo(), i, 1);
            modeloDatos.setValueAt(prestamo.getLibro().getTitulo(), i, 2);
            modeloDatos.setValueAt(prestamo.getEstudiante().getCarnet(), i, 3);
            modeloDatos.setValueAt(prestamo.getEstudiante().getNombre(), i, 4);
            modeloDatos.setValueAt(prestamo.getFechaPrestamo(), i, 5);
            modeloDatos.setValueAt(prestamo.getFechaDevolucion(), i, 6);
            modeloDatos.setValueAt(prestamo.getDiasConMora(), i, 7);
            modeloDatos.setValueAt(prestamo.getEstudiante().getLibrosPrestados(), i, 8);

        }
        FuncionamientoAplicacion.guardarSerializablePrestamos();
    }

    private void ajustarColumnaTexto() {
        TableColumnModel columnModel = tablaPrestamos.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40); // Establecer ancho mínimo inicial a 0
        columnModel.getColumn(0).setMaxWidth(40); // Establecer ancho máximo a 0
        columnModel.getColumn(0).setMinWidth(40); // Establecer ancho mínimo a 0

        int rowCount = tablaPrestamos.getRowCount();
        int column = 0;

        for (int row = 0; row < rowCount; row++) {
            int width = (int) tablaPrestamos.getCellRenderer(row, column).getTableCellRendererComponent(tablaPrestamos, tablaPrestamos.getValueAt(row, column), false, false, row, column).getPreferredSize().getWidth();
            width += 2 * tablaPrestamos.getIntercellSpacing().getWidth();
            columnModel.getColumn(column).setPreferredWidth(Math.max(columnModel.getColumn(column).getPreferredWidth(), width));
        }
    }
}
