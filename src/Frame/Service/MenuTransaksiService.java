package Frame.Service;

import Koneksi.Koneksi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class MenuTransaksiService extends javax.swing.JFrame {

    private Connection conn = new Koneksi().connect();
    private DefaultTableModel tabmode;
    String simpan_id;
    public static String idt;
    public boolean cek;     

    protected void reset() {
        NamaPelangganTextField.setText("");
        NoTelpTextField.setText("");
        JumlahTextField.setText("");
        TotalTextField.setText("");
        BayarTextField.setText("");
        KembalianTextField.setText("");
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

    public void simpan() {
        if (NamaPelangganTextField.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Harap isi data dahulu");
        } else {           
            try {
                Statement st = conn.createStatement();
                String sql = "INSERT INTO transaksi (NAMA,NO_TELP,ID_LAYANAN,JUMLAH,TOTAL) values ('" + NamaPelangganTextField.getText() + "','" + NoTelpTextField.getText() + "','" +
                        IdLayananTextField.getText()+ "','" + JumlahTextField.getText() + "','" + TotalTextField.getText() + "')";
                st.execute(sql);
                reset();
                bersih();                
                datatable();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage() + "ss");
            }
        }
    }

    public void edit() {
        int i = DaftarTransaksiTable.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Pilih Data yang ingin diedit");
        } else {
            DefaultTableModel tm = (DefaultTableModel) DaftarTransaksiTable.getModel();
            String kd = tm.getValueAt(i, 0).toString();
            try {
                Statement st = conn.createStatement();
                String sql = "Update transaksi set NAMA = '" + NamaPelangganTextField.getText() + "', NO_TELP = '" + NoTelpTextField.getText() + "',"
                        + "ID_LAYANAN = '" + IdLayananTextField.getText() + "', JUMLAH = '" + JumlahTextField.getText() + "', TOTAL = '" + TotalTextField.getText() + "' where ID_TRANSAKSI ='" + kd + "'";
                st.execute(sql);
                reset();
                bersih();
                datatable();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dirubah");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage() + " Data gagal diedit");
            }
        }
    }

    public void hapus() {
        int i = DaftarTransaksiTable.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Pilih Data yang ingin dihapus");
        } else {
            DefaultTableModel tj = (DefaultTableModel) DaftarTransaksiTable.getModel();
            String kd = tj.getValueAt(i, 0).toString();
            try {
                Statement st = conn.createStatement();
                String sql = "Delete from transaksi where ID_TRANSAKSI ='" + kd + "'";
                st.execute(sql);
                reset();
                bersih();
                datatable();
                JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage() + " Data gagal dihapus");
            }
        }
    }

    protected void datatable() {
        Object[] Baris = {"ID_TRANSAKSI", "NAMA", "NO_TELP", "ID_LAYANAN", "JUMLAH", "TOTAL", "TANGGAL"};
        tabmode = new DefaultTableModel(null, Baris);
        DaftarTransaksiTable.setModel(tabmode);
        try {
            java.sql.Statement stat = conn.createStatement();
            String sql = "select ID_TRANSAKSI, NAMA, NO_TELP, ID_LAYANAN, JUMLAH, TOTAL, TANGGAL from transaksi inner join layanan using (ID_LAYANAN)";
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String ID_TRANSAKSI = hasil.getString("ID_TRANSAKSI");
                String NAMA = hasil.getString("NAMA");
                String NO_HP = hasil.getString("NO_TELP");
                String ID_LAYANAN = hasil.getString("ID_LAYANAN");
                String JUMLAH = hasil.getString("JUMLAH");
                String TOTAL = hasil.getString("TOTAL");
                String TANGGAL = hasil.getString("TANGGAL");
                String[] data = {ID_TRANSAKSI, NAMA, NO_HP, ID_LAYANAN, JUMLAH, TOTAL, TANGGAL};
                tabmode.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "Gagal Menampilkan Data");
        }
    }

    public void bersih() {
        DefaultTableModel tb = (DefaultTableModel) DaftarTransaksiTable.getModel();
        while (tb.getRowCount() > 0) {
            for (int i = 0; i < tb.getRowCount(); ++i) {
                tb.removeRow(i);
            }
        }
    }    
    
    public MenuTransaksiService() {
        initComponents();
        datatable();
        tanggal();        
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

        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        KembaliLabel = new javax.swing.JLabel();
        tgll = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NamaPelangganTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        NoTelpTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        IdLayananTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        HargaTextField = new javax.swing.JTextField();
        JumlahTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TotalTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        BayarTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        KembalianTextField = new javax.swing.JTextField();
        ResetButton = new javax.swing.JButton();
        SimpanButton = new javax.swing.JButton();
        HapusButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DaftarTransaksiTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

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
                .addGap(0, 378, Short.MAX_VALUE))
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TRANSAKSI SERVICE");

        KembaliLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        KembaliLabel.setForeground(new java.awt.Color(255, 255, 255));
        KembaliLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/015-back.png"))); // NOI18N
        KembaliLabel.setText("KEMBALI");
        KembaliLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KembaliLabelMouseClicked(evt);
            }
        });

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
        jLabel5.setText("ID LAYANAN");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("HARGA");

        JumlahTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JumlahTextFieldKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("JUMLAH");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TOTAL");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("BAYAR");

        BayarTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BayarTextFieldKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("KEMBALIAN");

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

        HapusButton.setBackground(new java.awt.Color(255, 255, 255));
        HapusButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        HapusButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/002-cancel.png"))); // NOI18N
        HapusButton.setText("HAPUS");
        HapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusButtonActionPerformed(evt);
            }
        });

        EditButton.setBackground(new java.awt.Color(255, 255, 255));
        EditButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        EditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/006-wrench.png"))); // NOI18N
        EditButton.setText("EDIT");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        DaftarTransaksiTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_TRANSAKSI", "NAMA_PELANGGAN", "NO_TELP", "ID_LAYANAN", "JUMLAH", "TOTAL", "TANGGAL"
            }
        ));
        DaftarTransaksiTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DaftarTransaksiTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DaftarTransaksiTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IdLayananTextField)
                            .addComponent(NoTelpTextField)
                            .addComponent(NamaPelangganTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HargaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BayarTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TotalTextField)
                    .addComponent(JumlahTextField)
                    .addComponent(KembalianTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(KembaliLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tgll)
                        .addGap(29, 29, 29))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(201, 201, 201))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ResetButton)
                        .addGap(10, 10, 10)
                        .addComponent(SimpanButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tgll)
                    .addComponent(KembaliLabel))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NamaPelangganTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(NoTelpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(IdLayananTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(99, 99, 99)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BayarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(JumlahTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TotalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(HargaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addComponent(KembalianTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SimpanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void BayarTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BayarTextFieldKeyReleased
        int bayar = Integer.parseInt(BayarTextField.getText());
        int total = Integer.parseInt(TotalTextField.getText());
        int kembalian = bayar - total;
        if (bayar >= total) {
            KembalianTextField.setText(String.valueOf(kembalian));
        } else {
            KembalianTextField.setText("");
        }
    }//GEN-LAST:event_BayarTextFieldKeyReleased

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        reset();
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void SimpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanButtonActionPerformed
        simpan();
    }//GEN-LAST:event_SimpanButtonActionPerformed

    private void HapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusButtonActionPerformed
        hapus();
        reset();
    }//GEN-LAST:event_HapusButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        edit();
    }//GEN-LAST:event_EditButtonActionPerformed

    private void DaftarTransaksiTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DaftarTransaksiTableMouseClicked
        int pilih = DaftarTransaksiTable.getSelectedRow();
        NamaPelangganTextField.setText((String) DaftarTransaksiTable.getValueAt(pilih, 1));
        NoTelpTextField.setText((String) DaftarTransaksiTable.getValueAt(pilih, 2));
        IdLayananTextField.setText((String) DaftarTransaksiTable.getValueAt(pilih, 3));
        JumlahTextField.setText((String) DaftarTransaksiTable.getValueAt(pilih, 4));
        TotalTextField.setText((String) DaftarTransaksiTable.getValueAt(pilih, 5));
    }//GEN-LAST:event_DaftarTransaksiTableMouseClicked

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
            java.util.logging.Logger.getLogger(MenuTransaksiService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuTransaksiService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuTransaksiService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuTransaksiService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuTransaksiService().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField BayarTextField;
    private javax.swing.JTable DaftarTransaksiTable;
    private javax.swing.JButton EditButton;
    private javax.swing.JButton HapusButton;
    public javax.swing.JTextField HargaTextField;
    public javax.swing.JTextField IdLayananTextField;
    public javax.swing.JTextField JumlahTextField;
    private javax.swing.JLabel KembaliLabel;
    public javax.swing.JTextField KembalianTextField;
    public javax.swing.JTextField NamaPelangganTextField;
    public javax.swing.JTextField NoTelpTextField;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton SimpanButton;
    public javax.swing.JTextField TotalTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel tgll;
    // End of variables declaration//GEN-END:variables
}
