package frontend.reportes;

import backend.principal.FuncionamientoAplicacion;
import backend.principal.Prestamo;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author michael
 */
public class DevolucionesConcluidas extends javax.swing.JPanel {

    /**
     * Creates new form Devoluciones
     */
    public DevolucionesConcluidas() {
        initComponents();
        actualizarTablaDevolucionesHechas();
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
        jTree1 = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaReportes = new javax.swing.JTable();

        jScrollPane1.setViewportView(jTree1);

        setLayout(new java.awt.BorderLayout());

        tablaReportes = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
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
        jScrollPane2.setViewportView(tablaReportes);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private javax.swing.JTable tablaReportes;
    // End of variables declaration//GEN-END:variables

    public void actualizarTablaDevolucionesHechas() {
        String[] columnaDevolucionHoy = {"No.", "Carnet", "Nombre", "Código de libro", "Título", "Fecha de préstamo", "Fecha de devolución"};
        DefaultTableModel modelo = new DefaultTableModel(columnaDevolucionHoy, FuncionamientoAplicacion.listaDevoluciones.size());
        tablaReportes.setModel(modelo);

        TableModel modeloDatos = tablaReportes.getModel();
        for (int i = 0; i < FuncionamientoAplicacion.listaDevoluciones.size(); i++) {
            if (FuncionamientoAplicacion.listaDevoluciones.get(i).getFechaDevolucion() == LocalDate.now()) {
                Prestamo prestamo = FuncionamientoAplicacion.listaDevoluciones.get(i);
                modeloDatos.setValueAt(String.valueOf((i + 1)), i, 0);
                modeloDatos.setValueAt(prestamo.getEstudiante().getCarnet(), i, 1);
                modeloDatos.setValueAt(prestamo.getEstudiante().getNombre(), i, 2);
                modeloDatos.setValueAt(prestamo.getLibro().getCodigo(), i, 3);
                modeloDatos.setValueAt(prestamo.getLibro().getAutor(), i, 4);
                modeloDatos.setValueAt(prestamo.getFechaPrestamo(), i, 5);
                modeloDatos.setValueAt(prestamo.getFechaDevolucion(), i, 6);
            }
        }
        FuncionamientoAplicacion.guardarSerializableDevoluciones();
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
