/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nilaiMahasiswa;

import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class ListNilai extends javax.swing.JFrame {

    public Statement st;
    public ResultSet rs;
    public DefaultTableModel tabModel;
    public Object editNIM;
    Connection conn = Conn.Connect();

    /**
     * Creates new form ListNilai
     */
    public ListNilai() {
        initComponents();
        showData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableNilai = new javax.swing.JTable();
        buttonAdd = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelTitle.setText("Nilai Mahasiswa");

        jScrollPane1.setViewportView(tableNilai);

        buttonAdd.setText("Add");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonEdit.setText("Edit");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEdit)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTitle)
                    .addComponent(buttonAdd)
                    .addComponent(buttonEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        FormNilai form = new FormNilai();
        form.show();
        dispose();
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        int selectedRow = tableNilai.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Pilih 1 Data dari Tabel untuk Diedit!");
        }

        String nim = tableNilai.getValueAt(selectedRow, 0).toString();

        editNIM = nim;

        System.out.println(nim);

        EditNilai form = new EditNilai(this);
        form.show();
        dispose();
    }//GEN-LAST:event_buttonEditActionPerformed

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
            java.util.logging.Logger.getLogger(ListNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListNilai().setVisible(true);
            }
        });
    }

    public static String getGrade(double avg) {
        if (avg >= 90 && avg <= 100) {
            return "A";
        } else if (avg >= 85) {
            return "A-";
        } else if (avg >= 80) {
            return "B+";
        } else if (avg >= 75) {
            return "B";
        } else if (avg >= 70) {
            return "B-";
        } else if (avg >= 65) {
            return "C+";
        } else if (avg >= 60) {
            return "C";
        } else if (avg >= 55) {
            return "C-";
        } else if (avg >= 50) {
            return "D+";
        } else if (avg >= 45) {
            return "D";
        } else if (avg < 45 && avg >= 0) {
            return "E";
        } else {
            return "Invalid Value";
        }
    }

    private void showData() {
        DefaultTableModel table = (DefaultTableModel) tableNilai.getModel();
        table.setRowCount(0);

        table.addColumn("NIM");
        table.addColumn("Nama");
        table.addColumn("Tugas");
        table.addColumn("Kuis");
        table.addColumn("UTS");
        table.addColumn("UAS");
        table.addColumn("Average");
        table.addColumn("Grade");
        table.addColumn("Ket.");

        try {
            String sql = "select * from nilai order by nim asc";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);

            while (rs.next()) {
                String nim = rs.getString("nim");
                String nama = rs.getString("nama");
                int tugas = rs.getInt("tugas");
                int kuis = rs.getInt("kuis");
                int uts = rs.getInt("uts");
                int uas = rs.getInt("uas");
                float avg = (tugas + kuis + uts + uas) / 4;
                DecimalFormat formatDec = new DecimalFormat("#.00");

                String grade = getGrade(avg);

                String ket = (avg >= 75) ? "Lulus" : "Tidak Lulus";

                table.addRow(new String[]{
                    nim,
                    nama,
                    Integer.toString(tugas),
                    Integer.toString(kuis),
                    Integer.toString(uts),
                    Integer.toString(uas),
                    formatDec.format(avg),
                    grade,
                    ket
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Show Data Failed!");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JTable tableNilai;
    // End of variables declaration//GEN-END:variables
}
