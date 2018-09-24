/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smart;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cheylis
 */
public class form extends javax.swing.JFrame {

    /**
     * Creates new form form
     */
    public form() {
        initComponents();
        initTable();
        tampilData();
        bobotDefault();
    }
    private DefaultTableModel model;
    private final Connection con = koneksi.getConnection();
    private Statement stt;
    private ResultSet rss;

    private void bobotDefault() {
        spinWLB.setValue(25);
        spinWKE.setValue(20);
        spinWTJ.setValue(20);
        spinWKS.setValue(15);
        spinWKH.setValue(10);
        spinWIQ.setValue(10);
    }

    private void initTable() {
        model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama");
        model.addColumn("Logika Berpikir");
        model.addColumn("Ketelitian");
        model.addColumn("Tanggung Jawab");
        model.addColumn("Kerja Sama");
        model.addColumn("Kehati-hatian");
        model.addColumn("IQ");
        jTable1.setModel(model);
    }

    private void tampilData() {
        try {
            String sql = "Select * from alternatif";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while (rss.next()) {
                Object[] o = new Object[8];
                o[0] = rss.getString("id");
                o[1] = rss.getString("NamaPegawai");
                String lb = rss.getString("LogikaBerpikir");
                if (Integer.parseInt(lb) >= 90) {
                    o[2] = "Sangat Baik";
                } else if (Integer.parseInt(lb) >= 70) {
                    o[2] = "Baik";
                } else if (Integer.parseInt(lb) >= 60) {
                    o[2] = "Cukup";
                } else {
                    o[2] = "Kurang";
                }

                String ke = rss.getString("Ketelitian");
                if (Integer.parseInt(ke) >= 90) {
                    o[3] = "Sangat Baik";
                } else if (Integer.parseInt(ke) >= 70) {
                    o[3] = "Baik";
                } else if (Integer.parseInt(ke) >= 60) {
                    o[3] = "Cukup";
                } else {
                    o[3] = "Kurang";
                }
                String tj = rss.getString("TanggungJawab");
                if (Integer.parseInt(tj) >= 90) {
                    o[4] = "Sangat Baik";
                } else if (Integer.parseInt(tj) >= 70) {
                    o[4] = "Baik";
                } else if (Integer.parseInt(tj) >= 60) {
                    o[4] = "Cukup";
                } else {
                    o[4] = "Kurang";
                }
                String ks = rss.getString("KerjaSama");
                if (Integer.parseInt(ks) >= 90) {
                    o[5] = "Sangat Baik";
                } else if (Integer.parseInt(ks) >= 70) {
                    o[5] = "Baik";
                } else if (Integer.parseInt(ks) >= 60) {
                    o[5] = "Cukup";
                } else {
                    o[5] = "Kurang";
                }
                String kh = rss.getString("Kehatihatian");
                if (Integer.parseInt(kh) >= 90) {
                    o[6] = "Sangat Baik";
                } else if (Integer.parseInt(kh) >= 70) {
                    o[6] = "Baik";
                } else if (Integer.parseInt(kh) >= 60) {
                    o[6] = "Cukup";
                } else {
                    o[6] = "Kurang";
                }
                String iq = rss.getString("IQ");
                if (Integer.parseInt(iq) >= 90) {
                    o[7] = "Sangat Baik";
                } else if (Integer.parseInt(iq) >= 70) {
                    o[7] = "Baik";
                } else if (Integer.parseInt(iq) >= 60) {
                    o[7] = "Cukup";
                } else {
                    o[7] = "Kurang";
                }
                model.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void tambahData(String NamaPegawai, int LogikaBerpikir, int Ketelitian, int TanggungJawab, int KerjaSama, int Kehatihatian, int IQ) {
        try {
            String sql = "Insert into alternatif "
                    + "(NamaPegawai,LogikaBerpikir,Ketelitian,TanggungJawab,KerjaSama,Kehatihatian,IQ) "
                    + "values ('" + NamaPegawai + "','" + LogikaBerpikir + ""
                    + "','" + Ketelitian + "','" + TanggungJawab + ""
                    + "','" + KerjaSama + "','" + Kehatihatian + "','" + IQ + "')";
            stt = con.createStatement();
            stt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateData(String idPeg, String NamaPeg, int LB, int KE, int TJ, int KS, int KH, int IQ) {
        try {
            String sql = "update alternatif set NamaPegawai='" + NamaPeg + "', LogikaBerpikir=" + LB + ", "
                    + "Ketelitian=" + KE + ", TanggungJawab=" + TJ + ", KerjaSama=" + KS + ", Kehatihatian=" + KH + ", "
                    + "IQ=" + IQ + " where id='" + idPeg + "'";
            stt = con.createStatement();
            stt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void hapusData(String idPeg) {
        try {
            String sql = "delete from alternatif where id='" + idPeg + "'";
            stt = con.createStatement();
            stt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        spinTJ = new javax.swing.JSpinner();
        spinKE = new javax.swing.JSpinner();
        spinLB = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        spinKH = new javax.swing.JSpinner();
        spinKS = new javax.swing.JSpinner();
        spinIQ = new javax.swing.JSpinner();
        btnTambah = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        tfNama = new javax.swing.JTextField();
        btnHitung = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        spinWLB = new javax.swing.JSpinner();
        spinWKE = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        spinWTJ = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        spinWKH = new javax.swing.JSpinner();
        spinWIQ = new javax.swing.JSpinner();
        spinWKS = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SPK Kenaikan Jabatan dengan Metode SMART");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nama Pegawai");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Logika Berpikir");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Ketelitian");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tanggung Jawab");

        spinTJ.setNextFocusableComponent(spinKS);

        spinKE.setNextFocusableComponent(spinTJ);

        spinLB.setNextFocusableComponent(spinKE);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Kerja Sama");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Kehati-hatian");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("IQ");

        spinKH.setNextFocusableComponent(spinIQ);

        spinIQ.setNextFocusableComponent(btnTambah);

        btnTambah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.setName(""); // NOI18N
        btnTambah.setNextFocusableComponent(btnUpdate);
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setNextFocusableComponent(btnHapus);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.setNextFocusableComponent(tfNama);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        tfNama.setNextFocusableComponent(spinLB);

        btnHitung.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(spinKE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                        .addComponent(spinLB, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(spinTJ))
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spinKH, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(spinKS)
                    .addComponent(spinIQ))
                .addGap(93, 93, 93)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTambah)
                    .addComponent(btnUpdate)
                    .addComponent(btnHapus)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnHitung)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(spinKS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spinLB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(spinKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(spinKE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(spinIQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(spinTJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHitung)
                    .addComponent(btnReset))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Pengaturan Bobot :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Logika Berpikir");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Ketelitian");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Tanggung Jawab");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Kerja Sama");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Kehati-hatian");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("IQ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(143, 143, 143))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel9)
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel10)
                                        .addGap(23, 23, 23))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(50, 50, 50)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spinWLB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spinWKE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(6, 6, 6)
                                .addComponent(spinWTJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spinWKS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spinWIQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spinWKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(spinWLB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(spinWKS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(spinWKE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(spinWKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(spinWTJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(spinWIQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if (tfNama.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong!");
            tfNama.requestFocus();
        } else if (Integer.parseInt(spinLB.getValue().toString()) <= 0 || Integer.parseInt(spinLB.getValue().toString()) > 100) {
            JOptionPane.showMessageDialog(null, "Nilai Logika Berpikir tidak bisa lebih dari 100 atau di bawah 0");
            spinLB.requestFocus();
        } else if (Integer.parseInt(spinKE.getValue().toString()) <= 0 || Integer.parseInt(spinKE.getValue().toString()) > 100) {
            JOptionPane.showMessageDialog(null, "Nilai Ketelitian tidak bisa lebih dari 100 atau di bawah 0");
            spinKE.requestFocus();
        } else if (Integer.parseInt(spinTJ.getValue().toString()) <= 0 || Integer.parseInt(spinTJ.getValue().toString()) > 100) {
            JOptionPane.showMessageDialog(null, "Nilai Tanggung Jawab tidak bisa lebih dari 100 atau di bawah 0");
            spinTJ.requestFocus();
        } else if (Integer.parseInt(spinKS.getValue().toString()) <= 0 || Integer.parseInt(spinKS.getValue().toString()) > 100) {
            JOptionPane.showMessageDialog(null, "Nilai Kerja Sama tidak bisa lebih dari 100 atau di bawah 0");
            spinKS.requestFocus();
        } else if (Integer.parseInt(spinKH.getValue().toString()) <= 0 || Integer.parseInt(spinKH.getValue().toString()) > 100) {
            JOptionPane.showMessageDialog(null, "Nilai Kehatihatian tidak bisa lebih dari 100 atau di bawah 0");
            spinKH.requestFocus();
        } else if (Integer.parseInt(spinIQ.getValue().toString()) <= 0 || Integer.parseInt(spinIQ.getValue().toString()) > 100) {
            JOptionPane.showMessageDialog(null, "Nilai IQ tidak bisa lebih dari 100 atau di bawah 0");
            spinIQ.requestFocus();
        } else {
            String nama = tfNama.getText();
            int lb = Integer.parseInt(spinLB.getValue().toString());
            int ke = Integer.parseInt(spinKE.getValue().toString());
            int tj = Integer.parseInt(spinTJ.getValue().toString());
            int ks = Integer.parseInt(spinKS.getValue().toString());
            int kh = Integer.parseInt(spinKH.getValue().toString());
            int iq = Integer.parseInt(spinIQ.getValue().toString());
            tambahData(nama, lb, ke, tj, ks, kh, iq);
            btnResetActionPerformed(evt);
        }


    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed

        int count = 0;
        float wLB = Float.parseFloat(spinWLB.getValue().toString()) / (Float.parseFloat(spinWLB.getValue().toString()) + Float.parseFloat(spinWKE.getValue().toString()) + Float.parseFloat(spinWTJ.getValue().toString()) + Float.parseFloat(spinWKS.getValue().toString()) + Float.parseFloat(spinWKH.getValue().toString()) + Float.parseFloat(spinWIQ.getValue().toString()));
        float wKE = Float.parseFloat(spinWKE.getValue().toString()) / (Float.parseFloat(spinWLB.getValue().toString()) + Float.parseFloat(spinWKE.getValue().toString()) + Float.parseFloat(spinWTJ.getValue().toString()) + Float.parseFloat(spinWKS.getValue().toString()) + Float.parseFloat(spinWKH.getValue().toString()) + Float.parseFloat(spinWIQ.getValue().toString()));
        float wTJ = Float.parseFloat(spinWTJ.getValue().toString()) / (Float.parseFloat(spinWLB.getValue().toString()) + Float.parseFloat(spinWKE.getValue().toString()) + Float.parseFloat(spinWTJ.getValue().toString()) + Float.parseFloat(spinWKS.getValue().toString()) + Float.parseFloat(spinWKH.getValue().toString()) + Float.parseFloat(spinWIQ.getValue().toString()));
        float wKS = Float.parseFloat(spinWKS.getValue().toString()) / (Float.parseFloat(spinWLB.getValue().toString()) + Float.parseFloat(spinWKE.getValue().toString()) + Float.parseFloat(spinWTJ.getValue().toString()) + Float.parseFloat(spinWKS.getValue().toString()) + Float.parseFloat(spinWKH.getValue().toString()) + Float.parseFloat(spinWIQ.getValue().toString()));
        float wKH = Float.parseFloat(spinWKH.getValue().toString()) / (Float.parseFloat(spinWLB.getValue().toString()) + Float.parseFloat(spinWKE.getValue().toString()) + Float.parseFloat(spinWTJ.getValue().toString()) + Float.parseFloat(spinWKS.getValue().toString()) + Float.parseFloat(spinWKH.getValue().toString()) + Float.parseFloat(spinWIQ.getValue().toString()));
        float wIQ = Float.parseFloat(spinWIQ.getValue().toString()) / (Float.parseFloat(spinWLB.getValue().toString()) + Float.parseFloat(spinWKE.getValue().toString()) + Float.parseFloat(spinWTJ.getValue().toString()) + Float.parseFloat(spinWKS.getValue().toString()) + Float.parseFloat(spinWKH.getValue().toString()) + Float.parseFloat(spinWIQ.getValue().toString()));

        for (int baris = 0; baris < jTable1.getRowCount(); baris++) {
            for (int kolom = 2; kolom < jTable1.getColumnCount(); kolom++) {
                switch (jTable1.getValueAt(baris, kolom).toString()) {
                    case "Sangat Baik":
                        jTable1.setValueAt("4", baris, kolom);
                        break;
                    case "Baik":
                        jTable1.setValueAt("3", baris, kolom);
                        break;
                    case "Cukup":
                        jTable1.setValueAt("2", baris, kolom);
                        break;
                    default:
                        jTable1.setValueAt("1", baris, kolom);
                        break;
                }
            }
        }

        model.addColumn("Maximize");

        for (int baris = 0; baris < jTable1.getRowCount(); baris++) {
            for (int kolom = 2; kolom < jTable1.getColumnCount() - 1; kolom++) {
                float utility = (float) (Integer.parseInt(jTable1.getValueAt(baris, kolom).toString()) - 1) / 3;
                jTable1.setValueAt(utility, baris, kolom);
            }
            float maximize = (float) Float.parseFloat(jTable1.getValueAt(baris, 2).toString()) * wLB + Float.parseFloat(jTable1.getValueAt(baris, 3).toString()) * wKE + Float.parseFloat(jTable1.getValueAt(baris, 4).toString()) * wTJ + Float.parseFloat(jTable1.getValueAt(baris, 5).toString()) * wKS + Float.parseFloat(jTable1.getValueAt(baris, 6).toString()) * wKH + Float.parseFloat(jTable1.getValueAt(baris, 7).toString()) * wIQ;
            jTable1.setValueAt(maximize, baris, jTable1.getColumnCount() - 1);
        }

        do {
            count = 0;
            for (int baris = 0; baris < jTable1.getRowCount(); baris++) {
                if (baris + 1 == jTable1.getRowCount()) {
                    break;
                }
                float maximize1 = (float) Float.parseFloat(jTable1.getValueAt(baris, jTable1.getColumnCount() - 1).toString());
                float maximize2 = (float) Float.parseFloat(jTable1.getValueAt(baris + 1, jTable1.getColumnCount() - 1).toString());
                String temp;

                if (maximize2 > maximize1) {
                    for (int kolom = 1; kolom < jTable1.getColumnCount(); kolom++) {
                        temp = jTable1.getValueAt(baris, kolom).toString();
                        jTable1.setValueAt(jTable1.getValueAt(baris + 1, kolom), baris, kolom);
                        jTable1.setValueAt(temp, baris + 1, kolom);
                        count++;
                    }
                }
            }
        } while (count != 0);

        String hasil="";
        int pointer = 0;
        do {
            if (pointer == 0) {
                hasil = jTable1.getValueAt(pointer, 1).toString();
            } else if (jTable1.getValueAt(pointer, jTable1.getColumnCount()-1).toString().equals(jTable1.getValueAt(pointer-1, jTable1.getColumnCount()-1).toString())) {
                hasil = hasil.concat("\n"+jTable1.getValueAt(pointer, 1).toString());
            } else{
                break;                
            }               
            pointer++;
        } while (jTable1.getValueAt(pointer, jTable1.getColumnCount()-1) != jTable1.getValueAt(pointer-1, jTable1.getColumnCount()-1));

        JOptionPane.showMessageDialog(
                null, "Pegawai dengan nama \n" + hasil + "\nBerhak menerima kenaikan jabatan!");

    }//GEN-LAST:event_btnHitungActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        tfNama.setText("");
        spinLB.setValue(0);
        spinKE.setValue(0);
        spinTJ.setValue(0);
        spinKS.setValue(0);
        spinKH.setValue(0);
        spinIQ.setValue(0);
        initTable();
        tampilData();
        bobotDefault();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String id = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
        String nama = tfNama.getText();
        int lb = Integer.parseInt(spinLB.getValue().toString());
        int ke = Integer.parseInt(spinKE.getValue().toString());
        int tj = Integer.parseInt(spinTJ.getValue().toString());
        int ks = Integer.parseInt(spinKS.getValue().toString());
        int kh = Integer.parseInt(spinKH.getValue().toString());
        int iq = Integer.parseInt(spinIQ.getValue().toString());
        updateData(id, nama, lb, ke, tj, ks, kh, iq);
        btnResetActionPerformed(evt);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int baris = jTable1.getSelectedRow();
        tfNama.setText(jTable1.getValueAt(baris, 1).toString());

        try {
            String sql = "Select * from alternatif where id = " + jTable1.getValueAt(baris, 0);
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while (rss.next()) {
                Object[] o = new Object[6];
                o[0] = rss.getString("LogikaBerpikir");
                o[1] = rss.getString("Ketelitian");
                o[2] = rss.getString("TanggungJawab");
                o[3] = rss.getString("KerjaSama");
                o[4] = rss.getString("Kehatihatian");
                o[5] = rss.getString("IQ");
                spinLB.setValue(Integer.parseInt(o[0].toString()));
                spinKE.setValue(Integer.parseInt(o[1].toString()));
                spinTJ.setValue(Integer.parseInt(o[2].toString()));
                spinKS.setValue(Integer.parseInt(o[3].toString()));
                spinKH.setValue(Integer.parseInt(o[4].toString()));
                spinIQ.setValue(Integer.parseInt(o[5].toString()));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        String id = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
        hapusData(id);
        btnResetActionPerformed(evt);
    }//GEN-LAST:event_btnHapusActionPerformed

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
            java.util.logging.Logger.getLogger(form.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner spinIQ;
    private javax.swing.JSpinner spinKE;
    private javax.swing.JSpinner spinKH;
    private javax.swing.JSpinner spinKS;
    private javax.swing.JSpinner spinLB;
    private javax.swing.JSpinner spinTJ;
    private javax.swing.JSpinner spinWIQ;
    private javax.swing.JSpinner spinWKE;
    private javax.swing.JSpinner spinWKH;
    private javax.swing.JSpinner spinWKS;
    private javax.swing.JSpinner spinWLB;
    private javax.swing.JSpinner spinWTJ;
    private javax.swing.JTextField tfNama;
    // End of variables declaration//GEN-END:variables
}
