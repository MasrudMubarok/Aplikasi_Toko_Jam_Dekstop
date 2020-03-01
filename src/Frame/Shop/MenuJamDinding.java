package Frame.Shop;

import Frame.MenuUtama;
import Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MenuJamDinding extends javax.swing.JFrame {
    
    private Connection conn = new Koneksi().connect();
    private DefaultTableModel tabmode;

    protected void datatable() {
        Object[] Baris = {"ID_BARANG", "MERK", "TIPE", "WARNA", "MODEL", "BENTUK", "DIAMETER", "HARGA"};
        tabmode = new DefaultTableModel(null, Baris);
        while (tabmode.getRowCount() > 0) {
            for (int i = 0; i < tabmode.getRowCount(); ++i) {
                tabmode.removeRow(i);
            }
        }
        DaftarDindingTable.setModel(tabmode);
        try {
            java.sql.Statement stat = conn.createStatement();
            String sql = "select * from barang where TIPE like 'JD%'";
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String ID_BARANG = hasil.getString("ID_BARANG");
                String MERK = hasil.getString("MERK");
                String TIPE = hasil.getString("TIPE");
                String WARNA = hasil.getString("WARNA");
                String MODEL = hasil.getString("MODEL");
                String BENTUK = hasil.getString("BENTUK");
                String DIAMETER= hasil.getString("DIAMETER");    
                String HARGA = hasil.getString("HARGA");
                String[] data = {ID_BARANG, MERK, TIPE, WARNA, MODEL, BENTUK, DIAMETER, HARGA};
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
        int i = DaftarDindingTable.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Pilih Data yang ingin dihapus");
        } else {
            DefaultTableModel tm = (DefaultTableModel) DaftarDindingTable.getModel();
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
    
    public MenuJamDinding() {
        initComponents();
        datatable();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new java.awt.Color(11,189,189));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TransaksiButton1 = new javax.swing.JButton();
        KembaliButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DaftarDindingTable = new javax.swing.JTable();
        TambahButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        HapusButton = new javax.swing.JButton();
        TransaksiButton = new javax.swing.JButton();
        KembaliButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        TransaksiButton1.setBackground(new java.awt.Color(255, 255, 255));
        TransaksiButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TransaksiButton1.setText("TRANSAKSI");

        KembaliButton.setBackground(new java.awt.Color(255, 255, 255));
        KembaliButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        KembaliButton.setText("KEMBALI");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DAFTAR JAM DINDING");

        DaftarDindingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_BARANG", "MERK", "TIPE", "WARNA", "MODEL", "BENTUK", "DIAMETER", "HARGA"
            }
        ));
        jScrollPane1.setViewportView(DaftarDindingTable);

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

        TransaksiButton.setBackground(new java.awt.Color(255, 255, 255));
        TransaksiButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TransaksiButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/008-pay.png"))); // NOI18N
        TransaksiButton.setText("TRANSAKSI");
        TransaksiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransaksiButtonActionPerformed(evt);
            }
        });

        KembaliButton1.setBackground(new java.awt.Color(255, 255, 255));
        KembaliButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        KembaliButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/015-back.png"))); // NOI18N
        KembaliButton1.setText("KEMBALI");
        KembaliButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KembaliButton1ActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(191, 191, 191))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(TransaksiButton)
                        .addGap(58, 58, 58)
                        .addComponent(KembaliButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(TambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(HapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TransaksiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KembaliButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
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

    private void KembaliButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KembaliButton1ActionPerformed
        new MenuJenisShop().show();
        this.dispose();        
    }//GEN-LAST:event_KembaliButton1ActionPerformed

    private void TambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahButtonActionPerformed
        new MenuTambahJamDinding().show();
        this.dispose();
    }//GEN-LAST:event_TambahButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        int cek = DaftarDindingTable.getSelectedRow();
        MenuTambahJamDinding tj = new MenuTambahJamDinding();
        String merk = (String) DaftarDindingTable.getValueAt(cek, 1);
        tj.MerkTextField.setText(merk);
        String tipe = (String) DaftarDindingTable.getValueAt(cek, 2);
        tj.TipeTextField.setText(tipe);
        String warna = (String) DaftarDindingTable.getValueAt(cek, 3);
        tj.WarnaTextField.setText(warna);
        String model = (String) DaftarDindingTable.getValueAt(cek, 4);
        tj.ModelTextField.setText(model); 
        String bentuk = (String) DaftarDindingTable.getValueAt(cek, 5);
        tj.BentukTextField.setText(bentuk); 
        String diameter = (String) DaftarDindingTable.getValueAt(cek, 6);
        tj.DiameterTextField.setText(diameter);
        String harga = (String) DaftarDindingTable.getValueAt(cek, 7);
        tj.HargaTextField.setText(harga);        
        String cek_id = (String) DaftarDindingTable.getValueAt(cek, 0);
        tj.idb = cek_id;
        tj.cek = true;
        this.setVisible(false);
        tj.setVisible(true);   
    }//GEN-LAST:event_EditButtonActionPerformed

    private void HapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusButtonActionPerformed
        hapus();
    }//GEN-LAST:event_HapusButtonActionPerformed

    private void TransaksiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransaksiButtonActionPerformed
        int cek = DaftarDindingTable.getSelectedRow();
        MenuTransaksiJam tj = new MenuTransaksiJam();
        String id = (String) DaftarDindingTable.getValueAt(cek, 0);
        tj.IdBarangTextField.setText(id);
        String harga = (String) DaftarDindingTable.getValueAt(cek, 7);
        tj.HargaTextField.setText(harga);        
        String cek_id = (String) DaftarDindingTable.getValueAt(cek, 0);
        tj.idt = cek_id;
        tj.cek = true;
        this.setVisible(false);
        tj.setVisible(true); 
    }//GEN-LAST:event_TransaksiButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MenuJamDinding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuJamDinding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuJamDinding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuJamDinding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuJamDinding().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable DaftarDindingTable;
    private javax.swing.JButton EditButton;
    private javax.swing.JButton HapusButton;
    private javax.swing.JButton KembaliButton;
    private javax.swing.JButton KembaliButton1;
    private javax.swing.JButton TambahButton;
    private javax.swing.JButton TransaksiButton;
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
