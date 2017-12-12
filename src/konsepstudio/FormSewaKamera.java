/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konsepstudio;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Athma Farhan
 */

public class FormSewaKamera extends javax.swing.JFrame {
private DefaultTableModel tabmode;
Connection con = null;
ArrayList<CustomerKamera> ListCustKamera = new ArrayList<>();//
String[] title = {"No Trans","Tanggal","Nama","Jaminan","Nomor HP","NoKamera","Merk","Jenis","Ket","Jumlah Sewa","Tgl Sewa","Jumlah Hari","Tgl Kembali","Hari Kembali","Harga"};    
int index = -1;//
private final Hashtable<String, String[]> subItemsJenis = new Hashtable<>();
ArrayList<ArrayList<Kamera>> arrKamera = new ArrayList<>();//
ArrayList<Kamera> arrCanon = new ArrayList<>();//
ArrayList<Kamera> arrSony = new ArrayList<>();//
ArrayList<Kamera> arrFujifilm = new ArrayList<>();//
ArrayList<Kamera> arrXiaomi = new ArrayList<>();//
static ArrayList<Kamera> arrGoPro = new ArrayList<>();//
Kamera Canon1 ;
Kamera Canon2 ;
Kamera Sony1 ;
Kamera Fujifilm1 ;
Kamera Fujifilm2 ;
Kamera Fujifilm3 ;
Kamera Xiaomi1 ;
Kamera GoPro1 ;

/**
     * Creates new form FormSewaKamera
     */
    public FormSewaKamera() {
        initComponents();//
        connectDatabase();//
        updateTable();//
        listKamera();//
        showCBMerkJenis();//
        
    }
    
    
    public void connectDatabase(){
        Object []baris = {"No Trans","Tanggal","Nama","Jaminan","Nomor HP","NoKamera","Merk","Jenis","Ket","Jumlah Sewa","Tgl Sewa","Jumlah Hari","Tgl Kembali","Hari Kembali","Harga"};
        tabmode = new DefaultTableModel();
        
        tblKamera.setModel(tabmode);
        String sql = "select * from custkamera";
        try {
            
            con = new Koneksi().getCon();
            Statement stmt = con.createStatement();
            ResultSet customerKamera = stmt.executeQuery(sql);
            while (customerKamera.next() == true){
                ListCustKamera.add(new CustomerKamera(
                customerKamera.getInt("notrans"),
                customerKamera.getString("tanggal"),
                customerKamera.getString("nama"),
                customerKamera.getString("jaminan"),
                customerKamera.getString("nohp"),
                customerKamera.getString("nokamera"),
                customerKamera.getString("merk"),
                customerKamera.getString("jenis"),
                customerKamera.getString("ket"),
                customerKamera.getString("jmlhari"),
                customerKamera.getString("tglsewa"),
                customerKamera.getString("harisewa"),
                customerKamera.getString("tglkembali"),
                customerKamera.getString("harikembali"),
                customerKamera.getString("harga")));
                
                //String notrans = ListCustKamera.get(index).getNoTrans();
                //String[] data = {notrans, tanggal, nama, jaminan, nohp, nokamera, jenis, ket, jmlhari, tglkembali, harikembali, harga};
                   tabmode.addRow(baris);
            }
        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(this,"Error", "Informasi",
             JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void updateTable() {
        Object[][] data = new Object[ListCustKamera.size()][15];
        int x = 0;
        for (CustomerKamera CK:ListCustKamera){
            data[x][0] = CK.getNoTrans();
            data[x][1] = CK.getTanggal();
            data[x][2] = CK.getNama();
            data[x][3] = CK.getJaminan();
            data[x][4] = CK.getNoHP();
            data[x][5] = CK.getNoKamera();
            data[x][6] = CK.getMerk();
            data[x][7] = CK.getJenis();
            data[x][8] = CK.getKet();
            data[x][9] = CK.getJmlHari();
            data[x][10] = CK.getTglSewa();
            data[x][11] = CK.getHariSewa();
            data[x][12] = CK.getTglKembali();
            data[x][13] = CK.getHariKembali();
            data[x][14] = CK.getHarga();
            ++x;
        }
        tblKamera.setModel(new DefaultTableModel(data, title));
    }
    
    public  void listKamera(){
        Canon1 = new Kamera("Canon", "Canon 700d", 90000, 255000, 580000);
        Canon2 = new Kamera("Canon", "Canon 600d", 90000, 255000, 580000);
        Sony1 = new Kamera("Sony", "Sony a6000", 125000, 360000, 825000);
        Fujifilm1 = new Kamera("Fujifilm", "Fujifilm X-A2", 125000, 360000, 825000);
        Fujifilm2 = new Kamera("Fujifilm", "Fujifilm X-A3", 150000, 435000, 955000);
        Fujifilm3 = new Kamera("Fujifilm", "Fujifilm X-T10", 150000, 435000, 955000);
        Xiaomi1 = new Kamera("Xiaomi", "Xiaomi Yi", 50000, 135000, 300000);
        GoPro1 = new Kamera("GoPro", "GoPro Hero4", 80000, 225000, 510000);
        arrCanon.add(Canon1);
        arrCanon.add(Canon2);
        arrSony.add(Sony1);
        arrFujifilm.add(Fujifilm1);
        arrFujifilm.add(Fujifilm2);
        arrFujifilm.add(Fujifilm3);
        arrXiaomi.add(Xiaomi1);
        arrGoPro.add(GoPro1);
        arrKamera.add(arrCanon);
        arrKamera.add(arrSony);
        arrKamera.add(arrFujifilm);
        arrKamera.add(arrXiaomi);
        arrKamera.add(arrGoPro);
    }

    public void showCBMerkJenis(){
        String[] itemsMerk = { "Pilih Merk Kamera", "Canon", "Sony", "Fujifilm", "Xiaomi", "GoPro" };
        cbMerk.setPrototypeDisplayValue("XXXXXXX");
        cbMerk.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        
        String[] subItems1 = { "Pilih Jenis", "Canon 700d", "Canon 600d"};
        subItemsJenis.put(itemsMerk[1], subItems1);

        String[] subItems2 = { "Pilih Jenis", "Sony a6000"};
        subItemsJenis.put(itemsMerk[2], subItems2);

        String[] subItems3 = { "Pilih Jenis", "Fujifilm X-A2", "Fujifilm X-A3", "Fujifilm X-T10" };
        subItemsJenis.put(itemsMerk[3], subItems3);
        
        String[] subItems4 = { "Pilih Jenis", "Xiaomi Yi"};
        subItemsJenis.put(itemsMerk[4], subItems4);
        
        String[] subItems5 = { "Pilih Jenis", "GoPro Hero 4"};
        subItemsJenis.put(itemsMerk[5], subItems5);
        cbJenis.setPrototypeDisplayValue("XXXXXXXX");
        cbMerk.setModel(new javax.swing.DefaultComboBoxModel(itemsMerk));
        
        cbJenis.setEnabled(false);
    }
    
    private void showData() {
        CustomerKamera CK = ListCustKamera.get(index);
        txtNoTrans.setText(String.valueOf(CK.getNoTrans()));
        txtNama.setText(CK.getNama());
        txtJaminan.setText(CK.getJaminan());
        txtNomorHP.setText(CK.getNoHP());
        txtNomorKamera.setText(CK.getNoKamera());
        cbMerk.setSelectedItem(CK.getMerk());
        cbJenis.setSelectedItem(CK.getJenis());
        txtJumlahHari.setText(CK.getJmlHari());
        txtHarga.setText(CK.getHarga());
        txtKeterangan.setText(CK.getKet());
        
        SimpleDateFormat sdfTglBlnThn = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date DateTglBlnThn = null;
        
        try {
            DateTglBlnThn = sdfTglBlnThn.parse(CK.getTglSewa());
            DateTglBlnThn = sdfTglBlnThn.parse(CK.getTglKembali());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this,"Error", "Informasi",
             JOptionPane.INFORMATION_MESSAGE);
        }
        //yoii = yoi.parse("3000/12/12");
        datepickerTanggalSewa.setDate(DateTglBlnThn);
        datepickerTanggalKembali.setDate(DateTglBlnThn);
        //Date DPck = Date.parse(s)
        //datepickerTglKembali.set
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtNomorHP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNomorKamera = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        datepickerTanggalKembali = new org.jdesktop.swingx.JXDatePicker();
        cbMerk = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtJaminan = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtKeterangan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        txtHarga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKamera = new javax.swing.JTable();
        cbJenis = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtJumlahHari = new javax.swing.JTextField();
        txtNoTrans = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        datepickerTanggalSewa = new org.jdesktop.swingx.JXDatePicker();
        lblTglSewa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(68, 141, 253));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Pengisian Form Sewa Kamera");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(278, 278, 278))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(239, 248, 252));

        jButton1.setBackground(new java.awt.Color(68, 141, 253));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cek Harga Sewa Kamera");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("<<");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Jaminan");

        jLabel2.setText("Nama");

        jButton2.setText("|<");

        jLabel7.setText("Jumlah Hari");

        jLabel1.setText("No Transaksi");

        cbMerk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMerk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMerkActionPerformed(evt);
            }
        });

        jLabel4.setText("Nomor HP");

        jButton11.setText("New");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel8.setText("Harga");

        txtJaminan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJaminanActionPerformed(evt);
            }
        });

        jButton5.setText(">|");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel6.setText("Tipe Kamera");

        jLabel9.setText("Keterangan");

        jButton8.setText("Delete");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel5.setText("No Kamera");

        tblKamera.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblKamera);

        cbJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton6.setText("Save");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Update");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton4.setText(">>");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel10.setText("Tanggal Kembali");

        jButton10.setText("MENU");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        lblTglSewa.setText("Tanggal Sewa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(67, 67, 67)
                                .addComponent(txtNoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtJaminan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomorHP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomorKamera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbMerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtJumlahHari, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblTglSewa)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(datepickerTanggalSewa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHarga, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5))
                            .addComponent(txtKeterangan, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(datepickerTanggalKembali, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8)
                        .addGap(298, 298, 298)
                        .addComponent(jButton10))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3)
                    .addContainerGap(985, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtJaminan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomorHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomorKamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtJumlahHari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(datepickerTanggalSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTglSewa))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(datepickerTanggalKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jButton4)
                        .addComponent(jButton5)
                        .addComponent(jButton11)
                        .addComponent(jButton6)
                        .addComponent(jButton7)
                        .addComponent(jButton8))
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(96, 96, 96)
                    .addComponent(jLabel3)
                    .addContainerGap(554, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbMerkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMerkActionPerformed
        if (cbMerk.getSelectedIndex()!=0) {
            cbJenis.setEnabled(true);
        }
        else {
            cbJenis.setEnabled(false);
        }

        String item = (String)cbMerk.getSelectedItem();
        Object objKamera = subItemsJenis.get( item );

        if (objKamera == null) {
            cbJenis.setModel( new DefaultComboBoxModel() );
        }
        else {
            cbJenis.setModel( new DefaultComboBoxModel( (String[])objKamera ) );
        }
        txtJumlahHari.setText("");
        txtHarga.setText("");
    }//GEN-LAST:event_cbMerkActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
int field1 = 0;
        String field2 = txtNama.getText();
        String field3 = txtJaminan.getText();
        String field4 = txtNomorHP.getText();
        String field5 = txtNomorKamera.getText();
        String field6 = (String)cbMerk.getSelectedItem();
        String field7 = (String)cbJenis.getSelectedItem();
        String field8 = txtKeterangan.getText();
        int    field9 = 0;
        String field10 = null;
        String field11 = null;
        String field12 = null;
        String field13 = null;
        int    field14 = 0;
        
        SimpleDateFormat sdfTglBlnThn = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfHari = new SimpleDateFormat("EEE", Locale.US);
            
        try {
            field1 = Integer.parseInt(txtNoTrans.getText());
            field9 = Integer.parseInt(txtJumlahHari.getText());
            field10 = sdfTglBlnThn.format(datepickerTanggalSewa.getDate());
            field11 = sdfHari.format(datepickerTanggalSewa.getDate());
            field12 = sdfTglBlnThn.format(datepickerTanggalKembali.getDate());
            field13 = sdfHari.format(datepickerTanggalKembali.getDate());
            field14 = Integer.parseInt(txtHarga.getText());
                
        } catch (NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(this,"Data yang Anda Masukkan Salah", "Informasi",
             JOptionPane.INFORMATION_MESSAGE);
        }
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());

        CustomerKamera newCK = new CustomerKamera();
        newCK.setNoTrans(Integer.parseInt(txtNoTrans.getText()));
        newCK.setTanggal(timeStamp+".0");
        newCK.setNama(txtNama.getText());
        newCK.setJaminan(txtJaminan.getText());
        newCK.setNoHP(txtNomorHP.getText());
        newCK.setNoKamera(txtNomorKamera.getText());
        newCK.setMerk((String)cbMerk.getSelectedItem());
        newCK.setJenis((String)cbJenis.getSelectedItem());
        newCK.setKet(txtKeterangan.getText());
        newCK.setJmlHari(txtJumlahHari.getText());
        
        newCK.setHarga(txtHarga.getText());
        try {
            newCK.setTglKembali(sdfTglBlnThn.format(datepickerTanggalSewa.getDate()));
            newCK.setHariKembali(sdfHari.format(datepickerTanggalSewa.getDate()));
            newCK.setTglKembali(sdfTglBlnThn.format(datepickerTanggalKembali.getDate()));
            newCK.setHariKembali(sdfHari.format(datepickerTanggalKembali.getDate()));
            this.ListCustKamera.add(newCK);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error", "Informasi",
             JOptionPane.INFORMATION_MESSAGE);
        }
        boolean InputBerhasil = false;
        try {
            Connection con = new Koneksi().getCon();
            PreparedStatement myPreparedStatement = null;
            String sqlinput = "INSERT INTO `custkamera`"
                        + "(`notrans`, `tanggal`, `nama`, `jaminan`, `nohp`, `nokamera`,`merk`, `jenis`, `ket`, `jmlhari`, `tglsewa`, `harisewa`,`tglkembali`, `harikembali`, `harga`)"
                        + " VALUES (?, CURRENT_TIMESTAMP, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            myPreparedStatement = con.prepareStatement(sqlinput);
            myPreparedStatement.setInt(1, field1);
            myPreparedStatement.setString(2, field2);
            myPreparedStatement.setString(3, field3);
            myPreparedStatement.setString(4, field4);
            myPreparedStatement.setString(5, field5);
            myPreparedStatement.setString(6, field6);
            myPreparedStatement.setString(7, field7);
            myPreparedStatement.setString(8, field8);
            myPreparedStatement.setInt(9, field9);
            myPreparedStatement.setString(10, field10);
            myPreparedStatement.setString(11, field11);
            myPreparedStatement.setString(12, field12);
            myPreparedStatement.setString(13, field13);
            myPreparedStatement.setInt(14, field14);
            myPreparedStatement.executeUpdate();
            InputBerhasil = true;
         
        
        if (InputBerhasil == true) {
            JOptionPane.showMessageDialog(this,"Penambahan Sukses", "Informasi", 
                JOptionPane.INFORMATION_MESSAGE);
            updateTable();
        } else if (InputBerhasil == false) {
            JOptionPane.showMessageDialog(this,"Penambahan Gagal", "Informasi",
            JOptionPane.INFORMATION_MESSAGE);
        }
            txtNoTrans.setText("");
            txtNama.setText("");
            txtJaminan.setText("");
            txtNomorHP.setText("");
            txtNomorKamera.setText("");
            cbMerk.setSelectedItem("Pilih Merk Kamera");
            txtJumlahHari.setText("");
            txtHarga.setText("");
            txtKeterangan.setText("");
            datepickerTanggalSewa.setDate(null);
            datepickerTanggalKembali.setDate(null);
         
       //myPreparedStatement.close();
       //con.close();
       
            
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this,"Error", "Informasi",
             JOptionPane.INFORMATION_MESSAGE);
        } catch (NullPointerException | SQLException ex) {
            InputBerhasil = false;
            JOptionPane.showMessageDialog(this,"Terdapat kesalahan input data", "Informasi", 
                JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int IntJumlahHari = 0;
        Kamera KameraKe = null;
        try {
            
            KameraKe = arrKamera.get(cbMerk.getSelectedIndex()-1).get(cbJenis.getSelectedIndex()-1);
        
            String StringJumlahHari = txtJumlahHari.getText();
            IntJumlahHari = Integer.parseInt(StringJumlahHari);
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Masukkan Jumlah Hari yang benar!",
                    "Informasi",
                    JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (NullPointerException | IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Masukkan Merk dan Jenis Kamera yang benar!",
                    "Informasi",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
        if (IntJumlahHari<=0) {    
        }
        else if (IntJumlahHari==1) {
            txtHarga.setText(String.valueOf(KameraKe.getHargaPerHari()));
        }
        else if (IntJumlahHari==2) {
            txtHarga.setText(String.valueOf(KameraKe.getHargaPerHari()*2));
        }
        else if (IntJumlahHari==3) {
            txtHarga.setText(String.valueOf(KameraKe.getHargaPerTigaHari()));
        }
        else if (IntJumlahHari>=4 && IntJumlahHari<7) {
            txtHarga.setText(String.valueOf(
                    KameraKe.getHargaPerTigaHari()
                            +
                            ((IntJumlahHari-3)*KameraKe.getHargaPerHari()))
            );
        }
        else if (IntJumlahHari==7) {
            txtHarga.setText(String.valueOf(KameraKe.getHargaPerTujuhHari()));
        }
        else {
            txtHarga.setText(String.valueOf(KameraKe.getHargaPerTujuhHari()+((IntJumlahHari-7)*KameraKe.getHargaPerHari())));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String field1 = txtNama.getText();
        String field2 = txtJaminan.getText();
        String field3 = txtNomorHP.getText();
        String field4 = txtNomorKamera.getText();
        String field5 = (String)cbMerk.getSelectedItem();
        String field6 = (String)cbJenis.getSelectedItem();
        String field7 = txtKeterangan.getText();
        int    field8 = 0;
        String field9 = null;
        String field10 = null;
        String field11 = null;
        String field12 = null;
        int    field13 = 0;
        int    field14 = Integer.parseInt(txtNoTrans.getText());
        
        SimpleDateFormat tglblnthnKembali = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat hariKembali = new SimpleDateFormat("EEE", Locale.US);
            
        try {
            field8 = Integer.parseInt(txtJumlahHari.getText());
            field9 = tglblnthnKembali.format(datepickerTanggalSewa.getDate());
            field10 = hariKembali.format(datepickerTanggalSewa.getDate());
            field11 = tglblnthnKembali.format(datepickerTanggalKembali.getDate());
            field12 = hariKembali.format(datepickerTanggalKembali.getDate());
            field14 = Integer.parseInt(txtHarga.getText());
                
        } catch (NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(this,"Data yang Anda Masukkan Salah", "Informasi",
             JOptionPane.INFORMATION_MESSAGE);
        }
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());

        CustomerKamera newCK = new CustomerKamera();
        newCK.setNoTrans(Integer.parseInt(txtNoTrans.getText()));
        newCK.setTanggal(ListCustKamera.get(index).getTanggal());
        newCK.setNama(txtNama.getText());
        newCK.setJaminan(txtJaminan.getText());
        newCK.setNoHP(txtNomorHP.getText());
        newCK.setNoKamera(txtNomorKamera.getText());
        newCK.setMerk((String)cbMerk.getSelectedItem());
        newCK.setJenis((String)cbJenis.getSelectedItem());
        newCK.setKet(txtKeterangan.getText());
        newCK.setJmlHari(txtJumlahHari.getText());
        newCK.setHarga(txtHarga.getText());
        boolean InputBerhasil = false;
        try {
            newCK.setTglKembali(tglblnthnKembali.format(datepickerTanggalSewa.getDate()));
            newCK.setHariKembali(hariKembali.format(datepickerTanggalSewa.getDate()));
            newCK.setTglKembali(tglblnthnKembali.format(datepickerTanggalKembali.getDate()));
            newCK.setHariKembali(hariKembali.format(datepickerTanggalKembali.getDate()));
            this.ListCustKamera.set(index, newCK);
        
            Connection con = new Koneksi().getCon();
            PreparedStatement myPreparedStatement = null;
            String sqlupdate = "UPDATE `custkamera` SET "
            + "`nama`=?,`jaminan`=?,`nohp`=?,`nokamera`=?,`merk`=?,`jenis`=?,`ket`=?,`jmlhari`=?,`tglsewa`=?,`harisewa`=?,`tglkembali`=?,`harikembali`=?,`harga`=? "
                    + "WHERE `notrans`=?";

            myPreparedStatement = con.prepareStatement(sqlupdate);
            myPreparedStatement.setString(1, field1);
            myPreparedStatement.setString(2, field2);
            myPreparedStatement.setString(3, field3);
            myPreparedStatement.setString(4, field4);
            myPreparedStatement.setString(5, field5);
            myPreparedStatement.setString(6, field6);
            myPreparedStatement.setString(7, field7);
            myPreparedStatement.setInt(8, field8);
            myPreparedStatement.setString(9, field9);
            myPreparedStatement.setString(10, field10);
            myPreparedStatement.setString(11, field11);
            myPreparedStatement.setString(12, field12);
            myPreparedStatement.setInt(13, field13);
            myPreparedStatement.setInt(14, field14);
            myPreparedStatement.executeUpdate();
            InputBerhasil = true;
            }
        catch (SQLException | NullPointerException e) {
            InputBerhasil = false;
            JOptionPane.showMessageDialog(this,"Terdapat kesalahan input data", "Informasi", 
                JOptionPane.INFORMATION_MESSAGE);
            }
        updateTable();
        if (InputBerhasil = true) {
            JOptionPane.showMessageDialog(this,"Data telah berhasil diupdate!", "Informasi", 
                JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(this,"Data telah berhasil diupdate!", "Informasi", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       index = ListCustKamera.size()-1;
       showData();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        txtNoTrans.setText("");
        txtNama.setText("");
        txtJaminan.setText("");
        txtNomorHP.setText("");
        txtNomorKamera.setText("");
        cbMerk.setSelectedItem("Pilih Merk Kamera");
        txtJumlahHari.setText("");
        txtHarga.setText("");
        txtKeterangan.setText("");
        datepickerTanggalSewa.setDate(null);
        datepickerTanggalKembali.setDate(null);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Yakin akan dihapus?", "Konfirmasi", 0) == 0) {
            Connection con = new Koneksi().getCon();
            PreparedStatement myPreparedStatement = null;
            String sqldelete = "DELETE FROM custkamera WHERE `notrans` =?";
            try {
                int    field1 = Integer.parseInt(txtNoTrans.getText());
                myPreparedStatement = con.prepareStatement(sqldelete);
                myPreparedStatement.setInt(1, field1);
                myPreparedStatement.executeUpdate();
            }
            catch (SQLException errorSQL) {
                JOptionPane.showMessageDialog(this, "Data tidak berhasil dihapus", "Informasi", 1);
            }
            catch (NumberFormatException | NullPointerException e) {
                JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!", "Informasi", 1);
            }
            ListCustKamera.remove(index);
            this.updateTable();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txtJaminanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJaminanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJaminanActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            if(this.index < this.ListCustKamera.size()){
            ++index;
        }
        showData();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this,"Data yang dicari tidak ditemukan", "Informasi", 
                JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if(this.index > 0){
            --index;
        }
        showData();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this,"Data yang dicari tidak ditemukan", "Informasi", 
                JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
    try {
        con.close();
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    } catch (SQLException ex) {

    }
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(FormSewaKamera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSewaKamera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSewaKamera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSewaKamera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSewaKamera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbJenis;
    private javax.swing.JComboBox<String> cbMerk;
    private org.jdesktop.swingx.JXDatePicker datepickerTanggalKembali;
    private org.jdesktop.swingx.JXDatePicker datepickerTanggalSewa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel lblTglSewa;
    private javax.swing.JTable tblKamera;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJaminan;
    private javax.swing.JTextField txtJumlahHari;
    private javax.swing.JTextField txtKeterangan;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoTrans;
    private javax.swing.JTextField txtNomorHP;
    private javax.swing.JTextField txtNomorKamera;
    // End of variables declaration//GEN-END:variables
}
