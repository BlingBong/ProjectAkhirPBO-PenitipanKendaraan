package View;

import Controller.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

public class AmbilView extends JFrame implements ActionListener {
    private JButton btnCetak;
    private JPanel panelAmbil;
    private JButton btnBatal;
    private JTextField etUang;
    private JRadioButton noMasih;
    private JRadioButton noHilang;
    private JLabel lblPlat;
    private JLabel lblJenis;
    private JLabel lblNomor;
    private JLabel lblLama;
    private JLabel lblTotal;
    private JLabel lblKembalian;
    private JLabel lblTglMasuk;
    private JLabel lblTglKeluar;
    private ButtonGroup noGroup;

    private String[] selected;

    public AmbilView(String[] selectedData) {
        selected = selectedData;
        setTitle("Ambil " + selected[1]);
        btnCetak.addActionListener(this);
        btnBatal.addActionListener(this);

        btnCetak.setFocusPainted(false);
        btnBatal.setFocusPainted(false);

        noGroup = new ButtonGroup();
        noGroup.add(noMasih);
        noGroup.add(noHilang);

        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelAmbil);
        this.pack();
        setLocationRelativeTo(null);


        lblPlat.setText(selected[1]);
        lblJenis.setText(selected[2]);
        lblNomor.setText(selected[3]);
        lblTglMasuk.setText(selected[4]);

        Date tgl_keluar = new Date();
        SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String tglKeluar = dateForm.format(tgl_keluar);

        lblTglKeluar.setText(tglKeluar);

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = dateForm.parse(selected[4]);
            d2 = dateForm.parse(tglKeluar);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long bedaWaktu = d2.getTime() - d1.getTime();

        String bedaDetik = Long.toString((bedaWaktu / 1000) % 60);
        String bedaMenit = Long.toString((bedaWaktu / (1000 * 60)) % 60);
        String bedaJam = Long.toString((bedaWaktu / (1000 * 60 * 60)) % 24);
        String bedaTahun = Long.toString((bedaWaktu / (1000l * 60 * 60 * 24 * 365)));
        String bedaHari = Long.toString((bedaWaktu / (1000 * 60 * 60 * 24)) % 365);

        String lama = bedaTahun + " tahun, " + bedaHari + " hari, " + bedaJam + " jam, " + bedaMenit + " menit, " + bedaDetik + " detik";

        lblLama.setText(lama);

        //konversi ke mata uang rupiah
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);

        etUang.setEnabled(false);
        btnCetak.setEnabled(false);

        MouseAdapter listener = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                etUang.setEnabled(true);

                long perJam = (bedaWaktu / (1000 * 60 * 60)); //dikurangi 1, karena tarif awal tetap walaupun penitipan kurang dari 1 jam

                int tarifJenis = 0;
                if (selected[2].equals("Motor")){
                    tarifJenis = 2000;
                }
                else if (selected[2].equals("Mobil")){
                    tarifJenis = 5000;
                }

                int noStat = 0;
                if (noMasih.isSelected()){
                    noStat = 0;
                }
                else if (noHilang.isSelected()){
                    noStat = 30000;
                }

                long tarifHitung;
                if (perJam < 1){
                    tarifHitung = tarifJenis + noStat;
                }
                else {
                    tarifHitung = (perJam * tarifJenis) + noStat;
                }

                String tarif = String.valueOf(tarifHitung);
                lblTotal.setText(kursIndonesia.format(Double.parseDouble(tarif)));

                etUang.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        super.keyReleased(e);
                        String inputUang = etUang.getText();
                        if (!inputUang.equals("")){
                            int total = Integer.parseInt(tarif);
                            int uang = Integer.parseInt(inputUang);
                            double sisa = uang-total;
                            if (sisa < 0){
                                lblKembalian.setText("Maaf, uang Anda kurang.");
                                btnCetak.setEnabled(false);
                            }
                            else if (sisa == 0){
                                lblKembalian.setText("Uang pas.");
                                btnCetak.setEnabled(true);
                            }
                            else{
                                lblKembalian.setText(kursIndonesia.format(sisa));
                                btnCetak.setEnabled(true);
                            }
                        }
                    }
                });

                String inputUang = etUang.getText();
                if (!inputUang.equals("")){
                    int total = Integer.parseInt(tarif);
                    int uang = Integer.parseInt(inputUang);
                    double sisa = uang-total;
                    if (sisa < 0){
                        lblKembalian.setText("Maaf, uang Anda kurang.");
                        btnCetak.setEnabled(false);
                    }
                    else if (sisa == 0){
                        lblKembalian.setText("Uang pas.");
                        btnCetak.setEnabled(true);
                    }
                    else{
                        lblKembalian.setText(kursIndonesia.format(sisa));
                        btnCetak.setEnabled(true);
                    }
                }
            }
        };
        noMasih.addMouseListener(listener);
        noHilang.addMouseListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==btnCetak) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Yakin ingin mengambil kendaraan dan mencetak nota?", "Ambil Kendaraan?", dialogButton);
            if(dialogResult == 0) {
                printRecord(panelAmbil);

                //konversi ke mata uang rupiah
                DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
                DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
                formatRp.setCurrencySymbol("Rp. ");
                formatRp.setMonetaryDecimalSeparator(',');
                formatRp.setGroupingSeparator('.');
                kursIndonesia.setDecimalFormatSymbols(formatRp);

                String getUang = etUang.getText();
                String uangConverted = kursIndonesia.format(Double.parseDouble(getUang));

                String[] riwayat = {
                        selected[0], selected[1], selected[2], selected[3], selected[4], lblTglKeluar.getText(),
                        getRB(noGroup), lblLama.getText(), lblTotal.getText(), uangConverted, lblKembalian.getText()
                };

                for (int i = 0; i < riwayat.length; i++){
                    System.out.println(riwayat[i]);
                };

                MainController cetakController = new MainController();
                cetakController.cetakHapus(riwayat);
                dispose();
            }
        }
        else if(actionEvent.getSource()==btnBatal) {
            MainController detailController = new MainController();
            detailController.detailLaunch(selected);
            dispose();
        }
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

    private void printRecord(JPanel panel) {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Nota " + lblPlat.getText());
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int i) {
                if (i > 0){
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D graphics2D = (Graphics2D)graphics;
                graphics2D.translate(pageFormat.getImageableX()*2, pageFormat.getImageableY()*2);

                panel.paint(graphics2D);

                return Printable.PAGE_EXISTS;
            }
        });

        boolean returningResult = printerJob.printDialog();
        if (returningResult){
            try{
                printerJob.print();
            }
            catch (PrinterException printerException){
                JOptionPane.showMessageDialog(this, "Print Error: " + printerException.getMessage());
            }
        }
    }
}
