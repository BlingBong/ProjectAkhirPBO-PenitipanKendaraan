package View;

import Controller.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailView extends JFrame implements ActionListener {
    private JButton btnKembali;
    private JPanel panelDetail;
    private JButton btnEdit;
    private JButton btnAmbil;
    private JLabel lblPlat;
    private JLabel lblJenis;
    private JLabel lblNomor;
    private JLabel lblTglMasuk;

    private String[] selected;

    public DetailView(String[] selectedData) {
        selected = selectedData;
        setTitle("Detail " + selected[1]);
        btnEdit.addActionListener(this);
        btnAmbil.addActionListener(this);
        btnKembali.addActionListener(this);
        btnEdit.setFocusPainted(false);
        btnAmbil.setFocusPainted(false);
        btnKembali.setFocusPainted(false);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelDetail);
        this.pack();
        setLocationRelativeTo(null);

        lblPlat.setText(selected[1]);
        lblJenis.setText(selected[2]);
        lblNomor.setText(selected[3]);
        lblTglMasuk.setText(selected[4]);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==btnAmbil){

            MainController ambilController = new MainController();
            ambilController.ambilLaunch(selected);
            dispose();
        }

        else if(actionEvent.getSource()==btnEdit) {
            MainController editController = new MainController();
            editController.editLaunch(selected);
            dispose();
        }

        else if(actionEvent.getSource()==btnKembali) {
            MainController dataController = new MainController();
            dataController.dataLaunch();
            dispose();
        }
    }

    public void setMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}
