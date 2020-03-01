package Model;

import Frame.Service.MenuGantiBaterai;
import java.util.Date;

public class JamDinding extends Jam implements PenunjukWaktu {
            
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
        if (merk == "AA"){
            hargas = 15000;
        } else if (merk == "UltraFire"){
            hargas = 7500;
        } else {
            System.out.println("Masukkan jenis baterai");
        }
        
        totals = hargas - jumlahs;
    }
    
}
