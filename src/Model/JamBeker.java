package Model;

import java.util.Date;
import java.util.Calendar;
import Frame.Service.MenuTambahLayanan;
import javax.swing.JTextField;
import Frame.Service.MenuGantiBaterai;
        
public class JamBeker extends Jam implements PenunjukWaktu{
    
    public int jumlahKaki;
    public int jmlahLonceng;
    public String jenisBell;

    public JamBeker(int jumlahKaki, int jmlahLonceng, String jenisBell) {
        this.jumlahKaki = jumlahKaki;
        this.jmlahLonceng = jmlahLonceng;
        this.jenisBell = jenisBell; 
    }

    public JamBeker(int jumlahKaki, int jmlahLonceng) {
        this.jumlahKaki = jumlahKaki;
        this.jmlahLonceng = jmlahLonceng;
    }
    
    public void beliJam(String merk) {
        super.merk = merk;
    }    

    public JamBeker() {
        this.jumlahKaki = jumlahKaki;
    }
    
    public int getJumlahKaki() {
        return jumlahKaki;
    }

    public void setJumlahKaki(int jumlahKaki) {
        this.jumlahKaki = jumlahKaki;
    }

    public int getJmlahLonceng() {
        return jmlahLonceng;
    }

    public void setJmlahLonceng(int jmlahLonceng) {
        this.jmlahLonceng = jmlahLonceng;
    }

    public String getJenisBell() {
        return jenisBell;
    }

    public void setJenisBell(String jenisBell) {
        this.jenisBell = jenisBell;
    }
    
    public void setAlarm(int waktu) {
        super.waktu = waktu;
    } 
    
    public void gantiLonceng(){
        setJenisBell(jenisBell);
        setJmlahLonceng(jmlahLonceng);
        System.out.println(getJenisBell());
        System.out.println(getJmlahLonceng());
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
        if (merk == "ABC"){
            hargas = 5000;
        } else if (merk == "Alkaline"){
            hargas = 15000;
        } else {
            System.out.println("Masukkan jenis baterai");
        }
        
        totals = hargas - jumlahs;
    }

    @Override
    public void aturWaktu() {
        Date dateOne = new Date();
        
        System.out.println(dateOne);     
        dateOne.setTime(waktu);    
        System.out.println(dateOne);
    }
}
