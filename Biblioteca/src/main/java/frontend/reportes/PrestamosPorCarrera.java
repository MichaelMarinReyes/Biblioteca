package frontend.reportes;

import backend.principal.FuncionamientoAplicacion;
import backend.principal.Prestamo;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author michael
 */
public class PrestamosPorCarrera extends javax.swing.JPanel {

    /**
     * Creates new form PrestamosPorCarrera
     */
    public PrestamosPorCarrera() {
        initComponents();
        actualizarTablaPrestamosPorCarrera();
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
        tablaReportes = new javax.swing.JTable();
        filtroCarreraBox = new javax.swing.JComboBox<>();

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

        filtroCarreraBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Ingeniería", "Medicina", "Derecho", "Arquitectura", "Administración" }));
        filtroCarreraBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroCarreraBoxActionPerformed(evt);
            }
        });
        add(filtroCarreraBox, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void filtroCarreraBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroCarreraBoxActionPerformed
        String carreraSeleccionada = (String) filtroCarreraBox.getSelectedItem();
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tablaReportes.getModel());
        tablaReportes.setRowSorter(rowSorter);

        if (!carreraSeleccionada.equals("Todos")) {
            RowFilter<TableModel, Object> rowFilter = RowFilter.regexFilter(carreraSeleccionada, 2); // Filtrar por la columna de nombre de carrera
            rowSorter.setRowFilter(rowFilter);
        } else {
            tablaReportes.setRowSorter(null);
        }
    }//GEN-LAST:event_filtroCarreraBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> filtroCarreraBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaReportes;
    // End of variables declaration//GEN-END:variables

    public void actualizarTablaPrestamosPorCarrera() {
        String[] columnaPrestamosPorCarrera = {"No.", "Código carrera", "Nombre de carrera", "Carné", "Nombre de estudiante"};
        DefaultTableModel modelo = new DefaultTableModel(columnaPrestamosPorCarrera, FuncionamientoAplicacion.listaPrestamos.size());
        tablaReportes.setModel(modelo);

        TableModel modeloDatos = tablaReportes.getModel();
        for (int i = 0; i < FuncionamientoAplicacion.listaPrestamos.size(); i++) {
            Prestamo prestamo = FuncionamientoAplicacion.listaPrestamos.get(i);
            modeloDatos.setValueAt(String.valueOf(i + 1), i, 0);
            modeloDatos.setValueAt(prestamo.getEstudiante().getCodigoCarrera(), i, 1);
            modeloDatos.setValueAt(nombreCarrera(prestamo.getEstudiante().getCodigoCarrera()), i, 2);
            modeloDatos.setValueAt(prestamo.getEstudiante().getCarnet(), i, 3);
            modeloDatos.setValueAt(prestamo.getEstudiante().getNombre(), i, 4);
        }
    }

    private String nombreCarrera(int codigoCarrera) {
        switch (codigoCarrera) {
            case 1 -> {
                return "Ingeniería";
            }
            case 2 -> {
                return "Medicina";
            }
            case 3 -> {
                return "Derecho";
            }
            case 4 -> {
                return "Arquitectura";
            }
            case 5 -> {
                return "Administración";
            }
            default -> {
            }
        }
        return "";
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
}
