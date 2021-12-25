package pack;

import javax.swing.*;
import javax.swing.event.*;

public class TableExample {

    public static void main(String[] a) {
        short X = 640;
        short Y = 480;
        JFrame f = new JFrame("Excel Worker");
        //
        JButton add_button = new JButton("Add");
        add_button.setBounds(X-40, Y-40, 100, 20);
        f.add(add_button);
        //
        String data[][]={
                {"Amit", "", "", ""},
                {"Jai", "", "", ""},
        };
        String column[]={"Товар", "Остаток", "Прордано", "Процент"};
        final JTable jt = new JTable(data,column);

        jt.setCellSelectionEnabled(true);
        ListSelectionModel select= jt.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        select.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                String result;
                int rows = jt.getRowCount();
                int columns = jt.getColumnCount();

                for(int row = 0; row < rows; row++){
                    if (jt.getValueAt(row, 1).toString() != "" && jt.getValueAt(row, 2).toString() != "") {
                        result = String.valueOf(Integer.parseInt(jt.getValueAt(row, 2).toString().trim()) / ( (Integer.parseInt(jt.getValueAt(row, 1).toString().trim()) + Integer.parseInt(jt.getValueAt(row, 2).toString().trim())) / 100.0));
                        jt.setValueAt(result, row,3);
                    }
                }
            }
        });

        JScrollPane sp=new JScrollPane(jt);
        f.add(sp);
        f.setSize(X, Y);
        f.setVisible(true);
    }
}