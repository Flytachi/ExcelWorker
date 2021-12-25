package pack;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;

public class Gui {
    private short X = 640;
    private short Y = 480;
    private final JFrame app = new JFrame("Excel Worker");
    private JTable table;

    public Gui() {
        System.out.println("Welcome to Excel Worker.");
        this.createMenu();
        this.createTable();
        this.app.setSize(this.X, this.Y);
        this.app.setVisible(true);
    }

    private void createMenu() {
        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu("add");
        mb.add(menu);
        this.app.setJMenuBar(mb);
    }

    private void createTable() {
        String data[][]={
            {"Amit", "", "", ""},
            {"Jai", "", "", ""},
        };
        String column[] = {"Товар", "Остаток", "Прордано", "Процент"};
        this.table = new JTable(data, column);

        this.table.setCellSelectionEnabled(true);
        ListSelectionModel select= table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        select.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                String result;
                int rows = table.getRowCount();
                int columns = table.getColumnCount();

                for(int row = 0; row < rows; row++){
                    if (table.getValueAt(row, 1).toString() != "" && table.getValueAt(row, 2).toString() != "") {
                        result = String.valueOf(Integer.parseInt(table.getValueAt(row, 2).toString().trim()) / ( (Integer.parseInt(table.getValueAt(row, 1).toString().trim()) + Integer.parseInt(table.getValueAt(row, 2).toString().trim())) / 100.0));
                        table.setValueAt(result, row,3);
                    }
                }
            }
        });

        JScrollPane scroll = new JScrollPane(this.table);
        this.app.add(scroll);
    }

}