package View;

import Controller.MainController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;

public class DataView extends JFrame implements ActionListener {
    private JPanel panelData;
    private JTable tabelData;
    private JTextField etSearch;
    private JButton btnKembali;

    public DataView(String[][] data) {
        setTitle("Data Kendaraan");
        btnKembali.addActionListener(this);
        btnKembali.setFocusPainted(false);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelData);
        this.pack();
        setLocationRelativeTo(null);

        DefaultTableModel model = (DefaultTableModel) tabelData.getModel();
        String[] column = {"ID Pelanggan", "Plat Kendaraan", "Jenis", "Nomor Penitipan", "Tanggal Masuk"};
        String[] row = new String[5];
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
            model.addRow(row);
            dataCount++;
        }

        etSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                DefaultTableModel model = (DefaultTableModel)tabelData.getModel();
                String search = etSearch.getText();
                TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
                tabelData.setRowSorter(tr);
                tr.setRowFilter(RowFilter.regexFilter(search));
            }
        });

        tabelData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel model = (DefaultTableModel)tabelData.getModel();
                int selectedRowIndex = tabelData.getSelectedRow();

                String[] selectedData = {
                        model.getValueAt(selectedRowIndex, 0).toString(),
                        model.getValueAt(selectedRowIndex, 1).toString(),
                        model.getValueAt(selectedRowIndex, 2).toString(),
                        model.getValueAt(selectedRowIndex, 3).toString(),
                        model.getValueAt(selectedRowIndex, 4).toString()
                };

                MainController detailController = new MainController();
                detailController.detailLaunch(selectedData);
                dispose();
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
