package Controller;

import Model.MainModel;
import View.*;

public class MainController {
    public void homeLaunch(){
        new HomeView();
    }
    public void titipLaunch(){
        MainModel cekModel = new MainModel();
        new TitipView(cekModel.cekTempat());
    }
    public void titipExecute(String[] dataTitip){
        MainModel inputModel = new MainModel();
        inputModel.titipKendaraan(dataTitip);
        MainModel cekModel = new MainModel();
        new TitipView(cekModel.cekTempat());
    }
    public void dataLaunch(){
        MainModel dataModel = new MainModel();
        new DataView(dataModel.dataKendaraan());
    }
    public void detailLaunch(String[] selectedData){
        new DetailView(selectedData);
    }
    public void ambilLaunch(String[] selectedData){
        new AmbilView(selectedData);
    }
    public void cetakHapus(String[] dataCetakHapus){
        MainModel cetakHapusModel = new MainModel();
        cetakHapusModel.riwayatKendaraan(dataCetakHapus);
        cetakHapusModel.hapusData(dataCetakHapus);
        new DataView(cetakHapusModel.dataKendaraan());
    }
    public void statusLaunch(){
        MainModel statusModel = new MainModel();
        new StatusView(statusModel.cekTempat());
    }
    public void riwayatLaunch(){
        MainModel riwayatModel = new MainModel();
        new RiwayatView(riwayatModel.dataRiwayat());
    }
    public void editLaunch(String[] editData){
        MainModel cekModel = new MainModel();
        new EditView(cekModel.cekTempat(), editData);
    }
    public void editExecute(String[] dataEdit){
        MainModel inputModel = new MainModel();
        inputModel.editKendaraan(dataEdit);
        new DetailView(dataEdit);
    }
    public void getStatData(String noKarcis){
        MainModel gsdModel = new MainModel();
        String[] dataKarcis = gsdModel.getDataKarcis(noKarcis);
        detailLaunch(dataKarcis);
    }
}
