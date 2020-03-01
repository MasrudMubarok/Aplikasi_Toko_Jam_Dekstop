/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame.Service;

import Koneksi.Koneksi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class MenuGantiBaterai extends javax.swing.JFrame {

    ArrayList<Service> list = new ArrayList<>();
    private Connection conn = new Koneksi().connect();
    private DefaultTableModel tabmode;
    String simpan_id;
    public static String idt;
    public boolean cek;
    
    public void simpan() {
        String nama, noTelp, merk, tipe, harga, jumlah, total;
        nama = NamaPelangganTextField.getText().toString();
        noTelp = NoTelpTextField.getText().toString();
        merk = MerkTextField.getText().toString();
        tipe = TipeTextField.getText().toString(); 
        harga = HargaTextField.getText().toString();
        jumlah = JumlahTextField.getText().toString();
        total = TotalTextField.getText().toString();

        Service serviceBaru = new Service(nama, noTelp, merk, tipe, harga, jumlah, total);

        list.add(serviceBaru);
        JumlahKontak();
    }

    public void simpanPelanggan(){
        if (NamaPelangganTextField.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Harap isi data dahulu");
        } else {           
            try {
                Statement st = conn.createStatement();
                String sql = "INSERT INTO transaksi (NAMA,NO_TELP,JUMLAH,TOTAL) values ('" + NamaPelangganTextField.getText() + "','" + NoTelpTextField.getText() +
                         "','" + JumlahTextField.getText() + "','" + TotalTextField.getText() + "')";
                st.execute(sql);
                reset();
//                bersih();                
//                datatable();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage() + "ss");
            }
        }        
    }
    
    public void simpanBarang(){
        try {
            Statement st = conn.createStatement();
            String sql = "INSERT INTO barang (MERK,TIPE, HARGA) values ('" + MerkTextField.getText() + "','" + TipeTextField.getText() + "','" + HargaTextField.getText() +"')";
            st.execute(sql);
            reset();
//                bersih();                
//                datatable();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "bs");
        }        
    }
    
    public ArrayList tampilkan(){
        ArrayList<Service> list = new ArrayList<>();
        try {
            String sql = "select MERK, TIPE, HARGA, NAMA, NO_TELP, JUMLAH, TOTAL from transaksi inner join barang where transaksi.ID_BARANG = barang.ID_BARANG and TIPE like 'BT%'";
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                list.add(new Service(res.getString("NAMA"), res.getString("NO_TELP"), res.getString("MERK"), res.getString("TIPE"), res.getString("HARGA"), res.getString("JUMLAH"), res.getString("TOTAL")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "cs");
        }
        return list;
    }
    
    public void CariKontak(String nama) {
        boolean ada = false;
        for (int count = 0; count < list.size(); count++) {
            if (nama.equalsIgnoreCase(list.get(count).getNama())) {
                JOptionPane.showMessageDialog(this, "Data ditemukan! "
                        + "\n"
                        + "\nNama: " + list.get(count).getNama()
                        + "\nNoTelp: " + list.get(count).getNoTelp()
                        + "\nMerk: " + list.get(count).getMerk()
                        + "\nTipe: " + list.get(count).getTipe()
                        + "\nHarga: " + list.get(count).getHarga()
                        + "\nJumlah: " + list.get(count).getJumlah()
                        + "\nTotal: " + list.get(count).getTotal()
                );
                ada = true;
            }
        }
        if (ada = false) {
            JOptionPane.showMessageDialog(this, "Data Tidak Ditemukan");
        }
    }

    public void SemuaData() {
        String listNama = "";
        for (int count = 0; count < list.size(); count++) {
            listNama += (count + 1) + " " + list.get(count).getNama() + "\n";
        }
        JOptionPane.showMessageDialog(this, "Jumlah Pelanggan: " + list.size()
                + "\n"
                + listNama);
    }

    public void JumlahKontak() {
        int jumlah;
        jumlah = list.size();
        JumlahPelanggan.setText(Integer.toString(jumlah));
    }
    
    protected void reset() {
        NamaPelangganTextField.setText("");
        NoTelpTextField.setText("");
        JumlahTextField.setText("");
        TotalTextField.setText("");
    }    
    
    public void tanggal() {
        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Date tgl = new Date();
                SimpleDateFormat tglan = new SimpleDateFormat("HH:mm:ss / dd-MM-yyyy");
                tgll.setText(tglan.format(tgl));
            }
        };
        new Timer(100, task).start();
    }  
    
    public MenuGantiBaterai() {
        initComponents();
        tanggal();
        list = tampilkan();
        System.out.println(tampilkan().size());
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new java.awt.Color(11,189,189));         
    }  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        KembaliLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tgll = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NamaPelangganTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        NoTelpTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        MerkTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        HargaTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        JumlahTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TotalTextField = new javax.swing.JTextField();
        ResetButton = new javax.swing.JButton();
        SimpanButton = new javax.swing.JButton();
        JumlahPelangganLabel = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cariNama = new javax.swing.JTextField();
        CariButton = new javax.swing.JButton();
        JumlahPelanggan = new javax.swing.JLabel();
        TampilkanButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        TipeTextField = new javax.swing.JTextField();

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/logo21.jpg"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Mesquite Std", 0, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("watch!");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel13.setFont(new java.awt.Font("Mesquite Std", 0, 48)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("MUBAROK");
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setForeground(new java.awt.Color(0, 102, 153));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/logo21.jpg"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Mesquite Std", 0, 48)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel15.setText("watch!");
        jLabel15.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel16.setFont(new java.awt.Font("Mesquite Std", 0, 48)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 102));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel16.setText("MUBAROK");
        jLabel16.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(0, 378, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15))))
                .addContainerGap())
        );

        KembaliLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        KembaliLabel.setForeground(new java.awt.Color(255, 255, 255));
        KembaliLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/015-back.png"))); // NOI18N
        KembaliLabel.setText("KEMBALI");
        KembaliLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KembaliLabelMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TRANSAKSI GANTI BATERAI");

        tgll.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tgll.setForeground(new java.awt.Color(255, 255, 255));
        tgll.setText("tanggal");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NAMA PEL");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NO TELP");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("MERK");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("HARGA");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("JUMLAH");

        JumlahTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JumlahTextFieldKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TOTAL");

        ResetButton.setBackground(new java.awt.Color(255, 255, 255));
        ResetButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ResetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/005-reset-1.png"))); // NOI18N
        ResetButton.setText("RESET");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        SimpanButton.setBackground(new java.awt.Color(255, 255, 255));
        SimpanButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SimpanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/001-save.png"))); // NOI18N
        SimpanButton.setText("SIMPAN");
        SimpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanButtonActionPerformed(evt);
            }
        });

        JumlahPelangganLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JumlahPelangganLabel.setForeground(new java.awt.Color(255, 255, 255));
        JumlahPelangganLabel.setText("JUMLAH PELANGGAN :");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Cari Nama :");

        CariButton.setBackground(new java.awt.Color(255, 255, 255));
        CariButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CariButton.setText("CARI");
        CariButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariButtonActionPerformed(evt);
            }
        });

        JumlahPelanggan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JumlahPelanggan.setForeground(new java.awt.Color(255, 255, 255));
        JumlahPelanggan.setText("0");

        TampilkanButton.setBackground(new java.awt.Color(255, 255, 255));
        TampilkanButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TampilkanButton.setText("TAMPILKAN SEMUA DATA");
        TampilkanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TampilkanButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TIPE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(153, 153, 153))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(MerkTextField)
                                        .addComponent(NoTelpTextField)
                                        .addComponent(NamaPelangganTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(TipeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(355, 355, 355))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(KembaliLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tgll)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TampilkanButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cariNama, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(CariButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(181, 181, 181)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(JumlahPelangganLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(JumlahPelanggan))
                                            .addComponent(jLabel7)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(88, 88, 88)
                                                .addComponent(HargaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(30, 30, 30)
                                                .addComponent(JumlahTextField))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(41, 41, 41)
                                                .addComponent(TotalTextField)))))
                                .addGap(5, 5, 5))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(SimpanButton)
                                .addGap(135, 135, 135))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(ResetButton)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tgll)
                    .addComponent(KembaliLabel))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NamaPelangganTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(HargaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(NoTelpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JumlahTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(MerkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JumlahPelangganLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JumlahPelanggan)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TipeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SimpanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariNama, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CariButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(TampilkanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KembaliLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KembaliLabelMouseClicked
        this.setVisible(false);
        new MenuLayanan().setVisible(true);
    }//GEN-LAST:event_KembaliLabelMouseClicked

    private void JumlahTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JumlahTextFieldKeyReleased
        int total = (Integer.parseInt(HargaTextField.getText()) * Integer.parseInt(JumlahTextField.getText()));
        TotalTextField.setText(Integer.toString(total));
    }//GEN-LAST:event_JumlahTextFieldKeyReleased

    private void SimpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanButtonActionPerformed
        simpan();
        simpanBarang();
        simpanPelanggan();
    }//GEN-LAST:event_SimpanButtonActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        reset();
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void CariButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariButtonActionPerformed
        String cari;
        cari = cariNama.getText().toString();
        CariKontak(cari);
    }//GEN-LAST:event_CariButtonActionPerformed

    private void TampilkanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TampilkanButtonActionPerformed
        SemuaData();
    }//GEN-LAST:event_TampilkanButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuGantiBaterai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGantiBaterai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGantiBaterai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGantiBaterai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGantiBaterai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CariButton;
    public javax.swing.JTextField HargaTextField;
    private javax.swing.JLabel JumlahPelanggan;
    private javax.swing.JLabel JumlahPelangganLabel;
    public javax.swing.JTextField JumlahTextField;
    private javax.swing.JLabel KembaliLabel;
    public javax.swing.JTextField MerkTextField;
    public javax.swing.JTextField NamaPelangganTextField;
    public javax.swing.JTextField NoTelpTextField;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton SimpanButton;
    private javax.swing.JButton TampilkanButton;
    public javax.swing.JTextField TipeTextField;
    public javax.swing.JTextField TotalTextField;
    private javax.swing.JTextField cariNama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel tgll;
    // End of variables declaration//GEN-END:variables
}
