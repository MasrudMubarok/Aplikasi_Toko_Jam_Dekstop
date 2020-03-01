package Frame.Service;

public class Service {
    
    private String nama;
    private String noTelp;
    private String merk;
    private String tipe;
    private String harga;
    private String jumlah;
    private String total;

    public Service(String nama, String noTelp, String merk, String tipe, String harga, String jumlah, String total) {
        setNama(nama);
        setNoTelp(noTelp);
        setMerk(merk);
        setTipe(tipe);
        setHarga(harga);
        setJumlah(jumlah);
        setTotal(total);
    }    

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the noTelp
     */
    public String getNoTelp() {
        return noTelp;
    }

    /**
     * @param noTelp the noTelp to set
     */
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    /**
     * @return the merk
     */
    public String getMerk() {
        return merk;
    }

    /**
     * @param merk the merk to set
     */
    public void setMerk(String merk) {
        this.merk = merk;
    }

    /**
     * @return the harga
     */
    public String getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(String harga) {
        this.harga = harga;
    }

    /**
     * @return the Jumlah
     */
    public String getJumlah() {
        return jumlah;
    }

    /**
     * @param Jumlah the Jumlah to set
     */
    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    /**
     * @return the tortal
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param tortal the tortal to set
     */
    public void setTotal(String tortal) {
        this.total = tortal;
    }
    
    
}
