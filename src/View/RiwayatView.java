package View;

import Controller.MainController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;

public class RiwayatView extends JFrame implements ActionListener {
    private JPanel panelRiwayat;
    private JTable tabelRiwayat;
    private JTextField etSearch;
    private JButton btnKembali;

    public RiwayatView(String[][] data) {
        setTitle("Riwayat Penitipan");
        btnKembali.addActionListener(this);
        btnKembali.setFocusPainted(false);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelRiwayat);
        this.pack();
        setLocationRelativeTo(null);

        DefaultTableModel model = (DefaultTableModel) tabelRiwayat.getModel();
        String[] column = {"ID Pelanggan", "Plat Kendaraan", "Jenis", "Nomor Penitipan", "Tanggal Masuk", "Tanggal Keluar", "Status Karcis",
                            "Lama Penitipan", "Total yang Harus Dibayar", "Uang Pembayaran", "Kembalian"};
        String[] row = new String[11];
        model.setRowCount(0);

        for (String s : column) { //int i = 0; i < column.length; i++
            model.addColumn(s);
        }

        int dataCount = 0;

        while (data[dataCount][0] != null) { //true
            row[0] = data[dataCount][0];
            row[1] = data[dataCount][1];
            row[2] = data[dataCount][2];
            row[3] = data[dataCount][3];
            row[4] = data[dataCount][4];
            row[5] = data[dataCount][5];
            row[6] = data[dataCount][6];
            row[7] = data[dataCount][7];
            row[8] = data[dataCount][8];
            row[9] = data[dataCount][9];
            row[10] = data[dataCount][10];
            model.addRow(row);
            dataCount++;
        }

        etSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                DefaultTableModel model = (DefaultTableModel)tabelRiwayat.getModel();
                String search = etSearch.getText();
                TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
                tabelRiwayat.setRowSorter(tr);
                tr.setRowFilter(RowFilter.regexFilter(search));
            }
        });
        tabelRiwayat.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                if (tabelRiwayat.getPreferredSize().width < tabelRiwayat.getParent().getWidth()) {
                    tabelRiwayat.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                } else {
                    tabelRiwayat.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()== btnKembali){
            MainController homeController = new MainController();
            homeController.homeLaunch();
            dispose();
        }
    }
}
