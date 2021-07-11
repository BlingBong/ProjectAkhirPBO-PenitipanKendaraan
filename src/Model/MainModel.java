package Model;

import javax.swing.*;
import java.sql.*;

public class MainModel {
    public Connection connection;
    public Statement statement;

    public MainModel(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/penitipan?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            System.out.println("Koneksi Berhasil");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void titipKendaraan(String[] dataTitip){
        try {
            String query = ("INSERT INTO kendaraan (id, plat, jenis, nomor, tanggal_masuk) values (id, ?, ?, ?, ?)");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString (1, String.valueOf(dataTitip[0]));
            preparedStatement.setString (2, String.valueOf(dataTitip[1]));
            preparedStatement.setString (3, String.valueOf(dataTitip[2]));
            preparedStatement.setString (4, String.valueOf(dataTitip[3]));
            preparedStatement.execute();
            preparedStatement.close();
            JOptionPane.showMessageDialog(null, "Penitipan Kendaraan Berhasil");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String[] cekTempat() {
        ResultSet resultSet;
        String[] nomorTempat = new String[20];
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT nomor FROM kendaraan");

            int i = 0;
            while(resultSet.next()){
                nomorTempat[i] = resultSet.getString("nomor");
                i++;
            }
            statement.close();
            return nomorTempat;
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public String[][] dataKendaraan() {
        ResultSet resultSet;
        String[][] data = new String[20][5];
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM kendaraan");

            int i = 0;
            while(resultSet.next()){
                data[i][0] = resultSet.getString("id");
                data[i][1] = resultSet.getString("plat");
                data[i][2] = resultSet.getString("jenis");
                data[i][3] = resultSet.getString("nomor");
                data[i][4] = resultSet.getString("tanggal_masuk");
                i++;
            }
            statement.close();
            return data;
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public void hapusData(String[] dataHapus){
        try {
            String query = ("DELETE FROM kendaraan WHERE id = ?");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString (1, String.valueOf(dataHapus[0]));
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void riwayatKendaraan(String[] dataRiwayat){
        try {
            String query = ("INSERT INTO riwayat (id, plat, jenis, nomor, tanggal_masuk, tanggal_keluar, status_karcis, lama, total, uang, kembalian) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString (1, String.valueOf(dataRiwayat[0]));
            preparedStatement.setString (2, String.valueOf(dataRiwayat[1]));
            preparedStatement.setString (3, String.valueOf(dataRiwayat[2]));
            preparedStatement.setString (4, String.valueOf(dataRiwayat[3]));
            preparedStatement.setString (5, String.valueOf(dataRiwayat[4]));
            preparedStatement.setString (6, String.valueOf(dataRiwayat[5]));
            preparedStatement.setString (7, String.valueOf(dataRiwayat[6]));
            preparedStatement.setString (8, String.valueOf(dataRiwayat[7]));
            preparedStatement.setString (9, String.valueOf(dataRiwayat[8]));
            preparedStatement.setString (10, String.valueOf(dataRiwayat[9]));
            preparedStatement.setString (11, String.valueOf(dataRiwayat[10]));
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String[][] dataRiwayat() {
        ResultSet resultSet;
        String[][] data = new String[100][11];
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM riwayat");

            int i = 0;
            while(resultSet.next()){
                data[i][0] = resultSet.getString("id");
                data[i][1] = resultSet.getString("plat");
                data[i][2] = resultSet.getString("jenis");
                data[i][3] = resultSet.getString("nomor");
                data[i][4] = resultSet.getString("tanggal_masuk");
                data[i][5] = resultSet.getString("tanggal_keluar");
                data[i][6] = resultSet.getString("status_karcis");
                data[i][7] = resultSet.getString("lama");
                data[i][8] = resultSet.getString("total");
                data[i][9] = resultSet.getString("uang");
                data[i][10] = resultSet.getString("kembalian");
                i++;
            }
            statement.close();
            return data;
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public void editKendaraan(String[] data){
        try {
            String query = ("UPDATE kendaraan SET plat = ?, jenis = ?, nomor = ?, tanggal_masuk = ? WHERE id = ?");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString (1, String.valueOf(data[1]));
            preparedStatement.setString (2, String.valueOf(data[2]));
            preparedStatement.setString (3, String.valueOf(data[3]));
            preparedStatement.setString (4, String.valueOf(data[4]));
            preparedStatement.setString (5, String.valueOf(data[0]));
            preparedStatement.execute();
            preparedStatement.close();
            JOptionPane.showMessageDialog(null, "Edit Data Berhasil");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String[] getDataKarcis(String noKarcis){
        try {
            ResultSet resultSet;
            String[] dataKarcis = new String[5];
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM kendaraan WHERE nomor = " + noKarcis);

            while(resultSet.next()){
                dataKarcis[0] = resultSet.getString("id");
                dataKarcis[1] = resultSet.getString("plat");
                dataKarcis[2] = resultSet.getString("jenis");
                dataKarcis[3] = resultSet.getString("nomor");
                dataKarcis[4] = resultSet.getString("tanggal_masuk");
            }
            statement.close();
            return dataKarcis;
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
}
