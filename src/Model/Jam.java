package Model;

public abstract class Jam {
    
    private String merk;
    public int harga;
    public String warna;
    public String model;
    public String tipe;
    public String bentuk;
    public int diameter;
    public long waktu;
  
    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getModel() {
        return model;
    }

    public void setJenis(String jenis) {
        this.model = model;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getBentuk() {
        return bentuk;
    }

    public void setBentuk(String bentuk) {
        this.bentuk = bentuk;
    }
    
    public abstract void gantiBaterai();
}
