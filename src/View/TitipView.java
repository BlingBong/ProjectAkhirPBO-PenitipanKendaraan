package View;

import Controller.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

public class TitipView extends JFrame implements ActionListener {
    private JPanel panelTitip;
    private JTextField etPlat;
    private JRadioButton jkMotor;
    private JRadioButton jkMobil;
    private JButton btnSimpan;
    private JButton btnClear;
    private JButton btnKembali;
    private JRadioButton t1;
    private JRadioButton t2;
    private JRadioButton t3;
    private JRadioButton t5;
    private JRadioButton t4;
    private JRadioButton t6;
    private JRadioButton t7;
    private JRadioButton t8;
    private JRadioButton t9;
    private JRadioButton t10;
    private JRadioButton t11;
    private JRadioButton t12;
    private JRadioButton t13;
    private JRadioButton t14;
    private JRadioButton t15;
    private JRadioButton t16;
    private JRadioButton t17;
    private JRadioButton t18;
    private JRadioButton t19;
    private JRadioButton t20;
    private ButtonGroup jkGroup;
    private ButtonGroup tGroup;

    public TitipView(String[] cek) {
        setTitle("Titip Kendaraan");
        btnKembali.addActionListener(this);
        btnSimpan.addActionListener(this);
        btnClear.addActionListener(this);

        btnKembali.setFocusPainted(false);
        btnSimpan.setFocusPainted(false);
        btnClear.setFocusPainted(false);

        jkGroup = new ButtonGroup();
        jkGroup.add(jkMotor);
        jkGroup.add(jkMobil);

        tGroup = new ButtonGroup();
        tGroup.add(t1);
        tGroup.add(t2);
        tGroup.add(t3);
        tGroup.add(t4);
        tGroup.add(t5);
        tGroup.add(t6);
        tGroup.add(t7);
        tGroup.add(t8);
        tGroup.add(t9);
        tGroup.add(t10);
        tGroup.add(t11);
        tGroup.add(t12);
        tGroup.add(t13);
        tGroup.add(t14);
        tGroup.add(t15);
        tGroup.add(t16);
        tGroup.add(t17);
        tGroup.add(t18);
        tGroup.add(t19);
        tGroup.add(t20);

        cekRB(tGroup, cek);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelTitip);
        this.pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==btnSimpan) {
            if (etPlat.getText().isEmpty()) {
                setMessage("Plat Nomor harus diisi");
            }
            else {
                try {
                    String plat = etPlat.getText();
                    String jenis = getRB(jkGroup);
                    String nomor = getRB(tGroup);

                    Date tgl_masuk = new Date();
                    SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String tanggal_masuk = dateForm.format(tgl_masuk);

                    if (plat.length() > 10){
                        setMessage("Maksimal Karakter Plat Kendaraan Adalah 10");
                    }
                    else if (jenis == null){
                        setMessage("Jenis Kendaraan Harus Diisi");
                    }
                    else if (nomor == null){
                        setMessage("Tempat Penitipan Harus Diisi");
                    }
                    else {
                        String[] dataTitip = {
                                plat, jenis, nomor, tanggal_masuk
                        };

                        MainController titip = new MainController();
                        titip.titipExecute(dataTitip);
                        dispose();
                    }
                }
                catch (NumberFormatException e) {
                    setMessage("Semua Data Kendaraan Harus Diisi");
                }
            }
        }

        else if(actionEvent.getSource()== btnClear){
            etPlat.setText("");
            jkGroup.clearSelection();
            tGroup.clearSelection();
        }

        else if(actionEvent.getSource()== btnKembali){
            MainController homeController = new MainController();
            homeController.homeLaunch();
            dispose();
        }
    }

    public void setMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }

    public String getRB(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> bg = buttonGroup.getElements(); bg.hasMoreElements();) {
            AbstractButton rb = bg.nextElement();

            if (rb.isSelected()) {
                return rb.getText();
            }
        }

        return null;
    }

    public void cekRB(ButtonGroup buttonGroup, String[] tempat) {
        for (Enumeration<AbstractButton> bg = buttonGroup.getElements(); bg.hasMoreElements();) {
            AbstractButton rb = bg.nextElement();

            for (String s : tempat) {     //int i = 0; i < tempat.length; i++
                if (rb.getText().equals(s)) {
                    rb.setEnabled(false);
                }
            }
        }
    }
}
