/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend.reportes;

import backend.principal.FuncionamientoAplicacion;
import backend.principal.Prestamo;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
public class PrestamosPorCarreraEnIntervalo extends JPanel {

    private JTextField textFieldFechaInicio;
    private JTextField textFieldFechaFin;
    private TableRowSorter<TableModel> rowSorter;
    private JComboBox<String> filtroCarreraBox;
    private JScrollPane jScrollPane1;
    private JTable tablaReportes;

    public PrestamosPorCarreraEnIntervalo() {
        initComponents();
        actualizarTablaPrestamosPorCarrera();
        ajustarColumnaTexto();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Panel para los campos de búsqueda
        JPanel panelBusqueda = new JPanel(new GridLayout(2, 2, 5, 5));

        JLabel labelFechaInicio = new JLabel("Fecha inicio (YYYY-MM-DD):");
        panelBusqueda.add(labelFechaInicio);

        textFieldFechaInicio = new JTextField();
        textFieldFechaInicio.setPreferredSize(new Dimension(120, 30));
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
        panelBusqueda.add(textFieldFechaInicio);

        JLabel labelFechaFin = new JLabel("Fecha final (YYYY-MM-DD):");
        panelBusqueda.add(labelFechaFin);

        textFieldFechaFin = new JTextField();
        textFieldFechaFin.setPreferredSize(new Dimension(120, 30));
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
        panelBusqueda.add(textFieldFechaFin);

        add(panelBusqueda, BorderLayout.NORTH); // Agregamos el panel de búsqueda en la parte superior del contenedor principal

        // Panel para el ComboBox
        JPanel panelComboBox = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filtroCarreraBox = new JComboBox<>();
        filtroCarreraBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Todos", "Ingeniería", "Medicina", "Derecho", "Arquitectura", "Administración"}));
        filtroCarreraBox.setPreferredSize(new Dimension(120, 30));
        filtroCarreraBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroCarreraBoxActionPerformed(evt);
            }
        });
        panelComboBox.add(filtroCarreraBox);
        add(panelComboBox, BorderLayout.WEST); // Agregamos el ComboBox a la izquierda del contenedor principal

        // Tabla de reportes
        jScrollPane1 = new JScrollPane();
        tablaReportes = new JTable();
        tablaReportes.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(tablaReportes);
        add(jScrollPane1, BorderLayout.CENTER); // Agregamos la tabla al centro del contenedor principal
    }

    private void filtroCarreraBoxActionPerformed(java.awt.event.ActionEvent evt) {
        filtrarTabla();
    }

    public void actualizarTablaPrestamosPorCarrera() {
        String[] columnaPrestamosPorCarrera = {"No.", "Código carrera", "Nombre de carrera", "Carné", "Nombre de estudiante", "Fecha de Prestamo"};
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
            modeloDatos.setValueAt(prestamo.getFechaPrestamo(), i, 5);
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
        int column = 0; // Columna que deseas ajustar

        for (int row = 0; row < rowCount; row++) {
            int width = (int) tablaReportes.getCellRenderer(row, column).getTableCellRendererComponent(tablaReportes, tablaReportes.getValueAt(row, column), false, false, row, column).getPreferredSize().getWidth();
            width += 2 * tablaReportes.getIntercellSpacing().getWidth();
            columnModel.getColumn(column).setPreferredWidth(Math.max(columnModel.getColumn(column).getPreferredWidth(), width));
        }
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
                String carreraSeleccionada = (String) filtroCarreraBox.getSelectedItem();

                // Filtrar por fecha
                if (!fechaInicioText.isEmpty() && !fechaFinText.isEmpty()) {
                    try {
                        LocalDate fechaInicio = LocalDate.parse(fechaInicioText);
                        LocalDate fechaFin = LocalDate.parse(fechaFinText);
                        LocalDate fechaPrestamo = LocalDate.parse(entry.getStringValue(5)); // Obtener la fecha de préstamo
                        if (!(fechaPrestamo.isEqual(fechaInicio) || fechaPrestamo.isAfter(fechaInicio))
                                || !(fechaPrestamo.isEqual(fechaFin) || fechaPrestamo.isBefore(fechaFin.plusDays(1)))) {
                            return false;
                        }
                    } catch (DateTimeParseException e) {
                        return false; // No incluir esta fila en el filtro
                    }
                }

                // Filtrar por carrera
                if (!carreraSeleccionada.equals("Todos")) {
                    if (!entry.getStringValue(2).equals(carreraSeleccionada)) {
                        return false;
                    }
                }

                return true;
            }
        };

        rowSorter.setRowFilter(filtro);
    }
}