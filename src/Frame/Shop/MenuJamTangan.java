package Frame.Shop;

import Frame.MenuUtama;
import Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MenuJamTangan extends javax.swing.JFrame {

    private Connection conn = new Koneksi().connect();
    private DefaultTableModel tabmode;

    protected void datatable() {
        Object[] Baris = {"ID_BARANG", "MERK", "TIPE", "WARNA", "MODEL", "BENTUK", "DIAMETER", "JENIS_PENGAIT", "DIAMETER_PENGAIT", "RESISTENCE", "HARGA"};
        tabmode = new DefaultTableModel(null, Baris);
        while (tabmode.getRowCount() > 0) {
            for (int i = 0; i < tabmode.getRowCount(); ++i) {
                tabmode.removeRow(i);
            }
        }
        DaftarTanganTable.setModel(tabmode);
        try {
            java.sql.Statement stat = conn.createStatement();
            String sql = "select * from barang where TIPE like 'JT%'";
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String ID_BARANG = hasil.getString("ID_BARANG");
                String MERK = hasil.getString("MERK");
                String TIPE = hasil.getString("TIPE");
                String WARNA = hasil.getString("WARNA");
                String MODEL = hasil.getString("MODEL");
                String BENTUK = hasil.getString("BENTUK");
                String DIAMETER= hasil.getString("DIAMETER");
                String JENIS_PENGAIT = hasil.getString("JENIS_PENGAIT");
                String DIAMETER_PENGAIT = hasil.getString("DIAMETER_PENGAIT");
                String RESISTENCE = hasil.getString("RESISTENCE");                
                String HARGA = hasil.getString("HARGA");
                String[] data = {ID_BARANG, MERK, TIPE, WARNA, MODEL, BENTUK, DIAMETER, JENIS_PENGAIT, DIAMETER_PENGAIT, RESISTENCE, HARGA};
                tabmode.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }     

    public void tambah() {
        try {
            Statement st = conn.createStatement();
            String sql = "";
            st.execute(sql);
            datatable();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void hapus() {
        int i = DaftarTanganTable.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Pilih Data yang ingin dihapus");
        } else {
            DefaultTableModel tm = (DefaultTableModel) DaftarTanganTable.getModel();
            String kd = tm.getValueAt(i, 0).toString();
            try {
                Statement st = conn.createStatement();
                String sql = "Delete from barang where ID_BARANG ='" + kd + "'";
                st.execute(sql);
                datatable();
                JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage() + " Data gagal dihapus");
            }
        }
    }
    
    public MenuJamTangan() {
        initComponents();
        datatable();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new java.awt.Color(11,189,189));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DaftarTanganTable = new javax.swing.JTable();
        TambahButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        HapusButton = new javax.swing.JButton();
        TransaksiButton1 = new javax.swing.JButton();
        KembaliButton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DAFTAR JAM TANGAN");

        DaftarTanganTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_BARANG", "MERK", "TIPE", "WARNA", "MODEL", "BENTUK", "DIAMETER", "JENIS_PENGAIT", "DIAMETER_PENGAIT", "RESISTENCE", "HARGA"
            }
        ));
        jScrollPane1.setViewportView(DaftarTanganTable);
        if (DaftarTanganTable.getColumnModel().getColumnCount() > 0) {
            DaftarTanganTable.getColumnModel().getColumn(0).setResizable(false);
            DaftarTanganTable.getColumnModel().getColumn(2).setResizable(false);
        }

        TambahButton.setBackground(new java.awt.Color(255, 255, 255));
        TambahButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TambahButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/014-plus.png"))); // NOI18N
        TambahButton.setText("TAMBAH");
        TambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahButtonActionPerformed(evt);
            }
        });

        EditButton.setBackground(new java.awt.Color(255, 255, 255));
        EditButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        EditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/006-wrench.png"))); // NOI18N
        EditButton.setText("EDIT");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        HapusButton.setBackground(new java.awt.Color(255, 255, 255));
        HapusButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        HapusButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/002-cancel.png"))); // NOI18N
        HapusButton.setText("HAPUS");
        HapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusButtonActionPerformed(evt);
            }
        });

        TransaksiButton1.setBackground(new java.awt.Color(255, 255, 255));
        TransaksiButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TransaksiButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/008-pay.png"))); // NOI18N
        TransaksiButton1.setText("TRANSAKSI");
        TransaksiButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransaksiButton1ActionPerformed(evt);
            }
        });

        KembaliButton.setBackground(new java.awt.Color(255, 255, 255));
        KembaliButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        KembaliButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/015-back.png"))); // NOI18N
        KembaliButton.setText("KEMBALI");
        KembaliButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KembaliButtonActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(TransaksiButton1)
                        .addGap(58, 58, 58)
                        .addComponent(KembaliButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(TambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(HapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TransaksiButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KembaliButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
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

    private void KembaliButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KembaliButtonActionPerformed
        new MenuJenisShop().show();
        this.dispose();
    }//GEN-LAST:event_KembaliButtonActionPerformed

    private void TambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahButtonActionPerformed
        new MenuTambahJamTangan().show();
        this.dispose();
    }//GEN-LAST:event_TambahButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        int cek = DaftarTanganTable.getSelectedRow();
        MenuTambahJamTangan tj = new MenuTambahJamTangan();
        String merk = (String) DaftarTanganTable.getValueAt(cek, 1);
        tj.MerkTextField.setText(merk);
        String tipe = (String) DaftarTanganTable.getValueAt(cek, 2);
        tj.TipeTextField.setText(tipe);
        String warna = (String) DaftarTanganTable.getValueAt(cek, 3);
        tj.WarnaTextField.setText(warna);
        String model = (String) DaftarTanganTable.getValueAt(cek, 4);
        tj.ModelTextField.setText(model); 
        String bentuk = (String) DaftarTanganTable.getValueAt(cek, 5);
        tj.BentukTextField.setText(bentuk); 
        String diameter = (String) DaftarTanganTable.getValueAt(cek, 6);
        tj.DiameterTextField.setText(diameter);
        String jenis_pengait = (String) DaftarTanganTable.getValueAt(cek, 7);
        tj.JnsPengaitTextField.setText(jenis_pengait);
        String diameter_pengait = (String) DaftarTanganTable.getValueAt(cek, 8);
        tj.DiameterPengaitTextField.setText(diameter_pengait);
        String resistence = (String) DaftarTanganTable.getValueAt(cek, 9);
        tj.ResistenceTextField.setText(resistence);
        String harga = (String) DaftarTanganTable.getValueAt(cek, 10);
        tj.HargaTextField.setText(harga);        
        String cek_id = (String) DaftarTanganTable.getValueAt(cek, 0);
        tj.idb = cek_id;
        tj.cek = true;
        this.setVisible(false);
        tj.setVisible(true); 
    }//GEN-LAST:event_EditButtonActionPerformed

    private void HapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusButtonActionPerformed
        hapus();
    }//GEN-LAST:event_HapusButtonActionPerformed

    private void TransaksiButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransaksiButton1ActionPerformed
        int cek = DaftarTanganTable.getSelectedRow();
        MenuTransaksiJam tj = new MenuTransaksiJam();
        String id = (String) DaftarTanganTable.getValueAt(cek, 0);
        tj.IdBarangTextField.setText(id);
        String harga = (String) DaftarTanganTable.getValueAt(cek, 10);
        tj.HargaTextField.setText(harga);        
        String cek_id = (String) DaftarTanganTable.getValueAt(cek, 0);
        tj.idt = cek_id;
        tj.cek = true;
        this.setVisible(false);
        tj.setVisible(true); 
    }//GEN-LAST:event_TransaksiButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuJamTangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuJamTangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuJamTangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuJamTangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuJamTangan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable DaftarTanganTable;
    private javax.swing.JButton EditButton;
    private javax.swing.JButton HapusButton;
    private javax.swing.JButton KembaliButton;
    private javax.swing.JButton TambahButton;
    private javax.swing.JButton TransaksiButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
