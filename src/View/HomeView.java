package View;

import Controller.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeView extends JFrame implements ActionListener {
    private JPanel panelHome;
    private JButton btnTitip;
    private JButton btnLihat;
    private JButton btnStatus;
    private JButton btnRiwayat;

    public HomeView() {
        setTitle("HOME");
        btnTitip.addActionListener(this);
        btnLihat.addActionListener(this);
        btnStatus.addActionListener(this);
        btnRiwayat.addActionListener(this);

        btnTitip.setFocusPainted(false);
        btnLihat.setFocusPainted(false);
        btnStatus.setFocusPainted(false);
        btnRiwayat.setFocusPainted(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelHome);
        this.pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()== btnTitip){
            MainController titip = new MainController();
            titip.titipLaunch();
            dispose();
        }
        else if(actionEvent.getSource()== btnLihat){
            MainController dataController = new MainController();
            dataController.dataLaunch();
            dispose();
        }
        else if(actionEvent.getSource()== btnStatus){
            MainController statusController = new MainController();
            statusController.statusLaunch();
            dispose();
        }
        else if(actionEvent.getSource()== btnRiwayat){
            MainController riwayatController = new MainController();
            riwayatController.riwayatLaunch();
            dispose();
        }
    }
}
