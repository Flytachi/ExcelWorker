package pack;

import javax.swing.*;

public class Gui {
    short X = 640;
    short Y = 480;
    JFrame f;

    Gui() {
        f = new JFrame("Excel Worker");
        String data[][] = {
//                {"Amit", "200", "10"},
//                {"Jai", "400", "500"},
//                {"Sachin", "1000", "300"},
                {"", "", "", ""}
        };
        String column[] = {"Товар", "Остаток", "Прордано"};
        JTable jt = new JTable(data, column);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(X, Y);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new Gui();
    }
}