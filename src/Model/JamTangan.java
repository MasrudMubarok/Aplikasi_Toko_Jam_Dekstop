package Model;

import Frame.Service.MenuGantiBaterai;
import java.util.Date;

public class JamTangan extends Jam implements PenunjukWaktu {
     
    public String jenisPengait;
    public int diameterPengait;
    public boolean resistence;

    public JamTangan(String jenisPengait, int diameterPengait, boolean resistence) {
        this.jenisPengait = jenisPengait;
        this.diameterPengait = diameterPengait;
        this.resistence = resistence;
    }

    public JamTangan(String jenisPengait, int diameterPengait) {
        this.jenisPengait = jenisPengait;
        this.diameterPengait = diameterPengait;
    }

    public JamTangan() {
        this.jenisPengait = jenisPengait;     
    }

    public void gantiPengait(){
        setJenisPengait(jenisPengait);
        getJenisPengait();
    }

    public String getJenisPengait() {
        return jenisPengait;
    }

    public void setJenisPengait(String jenisPengait) {
        this.jenisPengait = jenisPengait;
    } 

    public int getDiameterPengait() {
        return diameterPengait;
    }

    public void setDiameterPengait(int diameterPengait) {
        this.diameterPengait = diameterPengait;
    }

    public boolean isResistence() {
        return resistence;
    }

    public void setResistence(boolean resistence) {
        this.resistence = resistence;
    }

    @Override
    public void aturWaktu() {
        Date dateOne = new Date();
        
        System.out.println(dateOne);     
        dateOne.setTime(waktu);    
        System.out.println(dateOne);
    }

    @Override
    public void gantiBaterai() {
        MenuGantiBaterai gb = new MenuGantiBaterai();
        
        String merk = gb.MerkTextField.getText();
        String harga = gb.HargaTextField.getText();
        String jumlah = gb.JumlahTextField.getText();
        String total = gb.TotalTextField.getText();
        int hargas = Integer.parseInt(harga);
        int totals = Integer.parseInt(total);
        int jumlahs = Integer.parseInt(jumlah);
        
        System.out.println(getMerk());
        if (merk == "Renata"){
            hargas = 15000;
        } else if (merk == "Sony"){
            hargas = 25000;
        } else {
            System.out.println("Masukkan jenis baterai");
        }
        
        totals = hargas - jumlahs;
    }
    
}
