package Frame.Service;

import Frame.MenuPilihan;
import Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MenuLayanan extends javax.swing.JFrame {

    private Connection conn = new Koneksi().connect();
    private DefaultTableModel tabmode;

    protected void datatable() {
        Object[] Baris = {"ID_LAYANAN", "NAMA_LAYANAN", "TARIF"};
        tabmode = new DefaultTableModel(null, Baris);
        while (tabmode.getRowCount() > 0) {
            for (int i = 0; i < tabmode.getRowCount(); ++i) {
                tabmode.removeRow(i);
            }
        }
        DaftarLayananTable.setModel(tabmode);
        try {
            java.sql.Statement stat = conn.createStatement();
            String sql = "select * from layanan";
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String ID_LAYANAN = hasil.getString("ID_LAYANAN");
                String NAMA_LAYANAN = hasil.getString("NAMA_LAYANAN");
                String TARIF = hasil.getString("TARIF");
                String[] data = {ID_LAYANAN, NAMA_LAYANAN, TARIF};
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
        int i = DaftarLayananTable.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Pilih Data yang ingin dihapus");
        } else {
            DefaultTableModel tm = (DefaultTableModel) DaftarLayananTable.getModel();
            String kd = tm.getValueAt(i, 0).toString();
            try {
                Statement st = conn.createStatement();
                String sql = "Delete from layanan where ID_LAYANAN ='" + kd + "'";
                st.execute(sql);
                datatable();
                JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage() + " Data gagal dihapus");
            }
        }
    }    
    
    public MenuLayanan() {
        initComponents();
        datatable();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new java.awt.Color(11,189,189));        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DaftarLayananTable = new javax.swing.JTable();
        TambahButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        HapusButton = new javax.swing.JButton();
        TransaksiButton = new javax.swing.JButton();
        KembaliButton1 = new javax.swing.JButton();

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("WATCH SERVICE");

        DaftarLayananTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID_LAYANAN", "NAMA_LAYANAN", "TARIF"
            }
        ));
        jScrollPane1.setViewportView(DaftarLayananTable);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(217, 217, 217))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(TransaksiButton)
                        .addGap(58, 58, 58)
                        .addComponent(KembaliButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(HapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TransaksiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KembaliButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahButtonActionPerformed
        new MenuTambahLayanan().show();
        this.dispose();
    }//GEN-LAST:event_TambahButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        int cek = DaftarLayananTable.getSelectedRow();
        MenuTambahLayanan tl = new MenuTambahLayanan();
        String id = (String) DaftarLayananTable.getValueAt(cek, 1);
        tl.NamaLayananTextField.setText(id);
        String harga = (String) DaftarLayananTable.getValueAt(cek, 2);
        tl.TarifTextField.setText(harga);        
        String cek_id = (String) DaftarLayananTable.getValueAt(cek, 0);
        tl.cek = true;
        this.setVisible(false);
        tl.setVisible(true);
    }//GEN-LAST:event_EditButtonActionPerformed

    private void HapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusButtonActionPerformed
        hapus();
    }//GEN-LAST:event_HapusButtonActionPerformed

    private void TransaksiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransaksiButtonActionPerformed
//        int cek = DaftarLayananTable.getSelectedRow();
//        String id = (String) DaftarLayananTable.getValueAt(cek, 0);
//        int idl = Integer.parseInt(id);
//        if (idl == 1){
//            new MenuGantiBaterai().show();
//            this.dispose();            
//        } else {
//            JOptionPane.showMessageDialog(null, "Harap pilih data dahulu");
//        }
        int cek = DaftarLayananTable.getSelectedRow();
        MenuTransaksiService ts = new MenuTransaksiService();
        String id = (String) DaftarLayananTable.getValueAt(cek, 0);
        ts.IdLayananTextField.setText(id);
        String harga = (String) DaftarLayananTable.getValueAt(cek, 2);
        ts.HargaTextField.setText(harga);        
        String cek_id = (String) DaftarLayananTable.getValueAt(cek, 0);
        ts.idt = cek_id;
        ts.cek = true;
        this.setVisible(false);
        ts.setVisible(true); 
    }//GEN-LAST:event_TransaksiButtonActionPerformed

    private void KembaliButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KembaliButton1ActionPerformed
        new MenuPilihan().show();
        this.dispose();
    }//GEN-LAST:event_KembaliButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuLayanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuLayanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuLayanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuLayanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuLayanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable DaftarLayananTable;
    private javax.swing.JButton EditButton;
    private javax.swing.JButton HapusButton;
    private javax.swing.JButton KembaliButton1;
    private javax.swing.JButton TambahButton;
    private javax.swing.JButton TransaksiButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
