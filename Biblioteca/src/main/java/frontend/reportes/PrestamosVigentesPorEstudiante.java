/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend.reportes;

import backend.principal.FuncionamientoAplicacion;
import backend.principal.Prestamo;
import java.time.LocalDate;
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
 * @author ryoumen_kyoma
 */
public class PrestamosVigentesPorEstudiante extends JPanel{
    private JTextField textFieldBusqueda;
    private TableRowSorter<TableModel> rowSorter;
    
    public PrestamosVigentesPorEstudiante() {
        initComponents();
        actualizarTablaPrestamosIntervaloTiempo();
        agregarCampoBusqueda();
        ajustarColumnaTexto();
    }
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
    }
                   
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaReportes;               

    public void actualizarTablaPrestamosIntervaloTiempo() {
        String[] columnas = {"No.", "Carnet", "Nombre", "Código de libro", "Título", "Fecha de préstamo", "Fecha de devolución"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, FuncionamientoAplicacion.listaPrestamos.size());
        tablaReportes.setModel(modelo);

        TableModel modeloDatos = tablaReportes.getModel();
        LocalDate fechaActual = LocalDate.now(); // Obtener la fecha actual una vez
        LocalDate fechaLimite = fechaActual.plusDays(3); // Obtener la fecha límite tres días después del día actual

        int fila = 0;
        for (Prestamo prestamo : FuncionamientoAplicacion.listaPrestamos) {
            LocalDate fechaPrestamo = prestamo.getFechaPrestamo();
            if (!fechaPrestamo.isBefore(fechaActual) && !fechaPrestamo.isAfter(fechaLimite)) {
                modeloDatos.setValueAt(fila + 1, fila, 0);
                modeloDatos.setValueAt(prestamo.getEstudiante().getCarnet(), fila, 1);
                modeloDatos.setValueAt(prestamo.getEstudiante().getNombre(), fila, 2);
                modeloDatos.setValueAt(prestamo.getLibro().getCodigo(), fila, 3);
                modeloDatos.setValueAt(prestamo.getLibro().getTitulo(), fila, 4);
                modeloDatos.setValueAt(prestamo.getFechaPrestamo(), fila, 5);
                modeloDatos.setValueAt(prestamo.getFechaDevolucion(), fila, 6);
                fila++;
            }
        }
        FuncionamientoAplicacion.guardarSerializableLibros();
    }

    private void ajustarColumnaTexto() {
        TableColumnModel columnModel = tablaReportes.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(0).setMaxWidth(40);
        columnModel.getColumn(0).setMinWidth(40);

        int rowCount = tablaReportes.getRowCount();
        int column = 0; // Columna que deseas ajustar

        for (int row = 0; row < rowCount; row++) {
            int width = (int) tablaReportes.getCellRenderer(row, column).getTableCellRendererComponent(tablaReportes, tablaReportes.getValueAt(row, column), false, false, row, column).getPreferredSize().getWidth();
            width += 2 * tablaReportes.getIntercellSpacing().getWidth();
            columnModel.getColumn(column).setPreferredWidth(Math.max(columnModel.getColumn(column).getPreferredWidth(), width));
        }
    }

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
            rowSorter = new TableRowSorter<>(tablaReportes.getModel());
            tablaReportes.setRowSorter(rowSorter);
        }
        if (texto.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
        }
    }
}

