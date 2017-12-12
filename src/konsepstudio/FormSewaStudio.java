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
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Athma Farhan
 */
public class FormSewaStudio extends javax.swing.JFrame {
    private TableRowSorter<TableModel> rowSorter;
    String []title = 
    {"No Trans","Tanggal","Nama","Nomor HP","NoItem","Item","Ket","Tgl Sewa","Hari Sewa", "Jam Sewa","Durasi Sewa","Harga"};
    
    private DefaultTableModel tabmode;
    ArrayList<CustomerStudio> listCustStudio = new ArrayList<>();//
    Connection con;
    String HariSewa = null;
    Date DateWaktu = null;
    Date Sembilan = null;
    Date DuaPuluh = null;
    Date EnamBelas = null;
    Date DateHari = null;
    Date Senin = null;
    Date Selasa = null;
    Date Rabu = null;
    Date Kamis = null;
    Date Jumat = null;
    Date Sabtu = null;
    Date Minggu = null;
    int index = -1;//


/**
     * Creates new form FormSewaKamera
     */
    public FormSewaStudio() {
        initComponents();//
        connectDatabase();//
        updateTable();//
        showCBJamMenit();//
        
    }
    
    public void connectDatabase(){
        Object []baris = {"No Trans","Tanggal","Nama","Nomor HP","NoItem","Item","Ket","Tgl Sewa","Hari Sewa","Jam Sewa","Durasi Sewa","Harga"};
        tabmode = new DefaultTableModel();
        tblStudio.setModel(tabmode);
        String sql = "select * from custstudio";
        try {
            
            con = new Koneksi().getCon();
            Statement stmt = con.createStatement();
            ResultSet customerStudio = stmt.executeQuery(sql);
            while (customerStudio.next() == true){
                listCustStudio.add(new CustomerStudio(
                customerStudio.getInt("notrans"),
                customerStudio.getString("tanggal"),
                customerStudio.getString("nama"),
                customerStudio.getString("nohp"),
                customerStudio.getString("noitem"),
                customerStudio.getString("item"),
                customerStudio.getString("ket"),
                customerStudio.getString("tglsewa"),
                customerStudio.getString("harisewa"),
                customerStudio.getString("jamsewa"),
                customerStudio.getString("durasisewa"),
                customerStudio.getString("harga")));
                
                //String notrans = ListCustKamera.get(index).getNoTrans();
                //String[] data = {notrans, tanggal, nama, jaminan, nohp, nokamera, jenis, ket, jmlhari, tglkembali, harikembali, harga};
                   tabmode.addRow(baris);
            }
            con.close();
        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(this,"Error", "Informasi",
             JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void updateTable() {
        Object[][] data = new Object[listCustStudio.size()][12];
        int x = 0;
        for (CustomerStudio CS:listCustStudio){
            data[x][0] = CS.getNoTrans();
            data[x][1] = CS.getTanggal();
            data[x][2] = CS.getNama();
            data[x][3] = CS.getNoHP();
            data[x][4] = CS.getNoItem();
            data[x][5] = CS.getItem();
            data[x][6] = CS.getKet();
            data[x][7] = CS.getTglSewa();
            data[x][8] = CS.getHariSewa();
            data[x][9] = CS.getJamSewa();
            data[x][10] = CS.getDurasiSewa();
            data[x][11] = CS.getHarga();
            ++x;
        }
        //tabmode = new DefaultTableModel(data, title);
        tblStudio.setModel(new DefaultTableModel(data, title));
    }
    

    public void showCBJamMenit(){
        String[] itemsJam = { "09","10","11","12","13","14","15","16","17","18","19","20" };
        String[] itemsMenit = { "00","15","30","45" };
        cbJam.setPrototypeDisplayValue("XX");
        //jamComboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        
        cbMenit.setPrototypeDisplayValue("XX");
        cbJam.setModel(new javax.swing.DefaultComboBoxModel(itemsJam));
        cbMenit.setModel(new javax.swing.DefaultComboBoxModel(itemsMenit));
    }
    
    private void showData() {
        CustomerStudio CS = listCustStudio.get(index);
        txtNoTrans.setText(String.valueOf(CS.getNoTrans()));
        txtNama.setText(CS.getNama());
        txtNomorHP.setText(CS.getNoHP());
        txtNomorItem.setText(CS.getNoItem());
        txtItem.setText(CS.getNoItem());
        txtKeterangan.setText(CS.getKet());
        String jam = CS.getJamSewa().substring(0, 2);
        String menit = CS.getJamSewa().substring(3, 5);
        cbJam.setSelectedItem(jam);
        cbMenit.setSelectedItem(menit);
        
        txtHarga.setText(CS.getHarga());
        
        SimpleDateFormat sdfTglBlnThn = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date DateTglBlnThn = null;
        
        try {
            jSpinner1.setValue(Integer.valueOf(CS.getDurasiSewa()));
            DateTglBlnThn = sdfTglBlnThn.parse(CS.getTglSewa());
        } catch (NumberFormatException | ParseException ex) {
            JOptionPane.showMessageDialog(this,"Error", "Informasi",
             JOptionPane.INFORMATION_MESSAGE);
        }
        //yoii = yoi.parse("3000/12/12");
        datepickerTanggalSewa.setDate(DateTglBlnThn);
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
        txtNomorItem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtItem = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        datepickerTanggalSewa = new org.jdesktop.swingx.JXDatePicker();
        cbJam = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtNomorHP = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtKeterangan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        txtHarga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudio = new javax.swing.JTable();
        cbMenit = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtNoTrans = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lblShowHari = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(68, 141, 253));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Pengisian Form Sewa Studio");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(292, 292, 292))
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

        jLabel3.setText("Nomor HP");

        jLabel2.setText("Nama");

        jButton2.setText("|<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Jumlah Sewa");

        jLabel1.setText("No Transaksi");

        datepickerTanggalSewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datepickerTanggalSewaActionPerformed(evt);
            }
        });

        cbJam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbJam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJamActionPerformed(evt);
            }
        });

        jLabel4.setText("No Item");

        jButton11.setText("New");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel8.setText("Harga");

        txtNomorHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomorHPActionPerformed(evt);
            }
        });

        jButton5.setText(">|");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel6.setText("Jam Sewa");

        jLabel9.setText("Keterangan");

        jButton8.setText("Delete");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel5.setText("Item");

        tblStudio.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblStudio);

        cbMenit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        jLabel10.setText("Tanggal Sewa");

        jButton10.setText("MENU");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel12.setText("Hari Sewa");

        lblShowHari.setText("Pilih tanggal sewa dahulu!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHarga)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton5)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomorHP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomorItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(67, 67, 67)
                                        .addComponent(txtNoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(73, 73, 73)
                                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblShowHari)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(cbJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbMenit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(datepickerTanggalSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomorHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomorItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(datepickerTanggalSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(lblShowHari))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMenit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
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

    private void cbJamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJamActionPerformed
        
    }//GEN-LAST:event_cbJamActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int field1 = 0;
        String field2 = txtNama.getText();
        String field3 = txtNomorHP.getText();
        int    field4 = 0;
        String field5 = txtItem.getText();
        String field6 = txtKeterangan.getText();
        String field7 = null;
        String field8 = null;
        String field9 = null;
        int    field10 = 0;
        int    field11 = 0;
        
        String jam = null;
        String menit = null;
        
        SimpleDateFormat sdfTglBlnThn = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfHari = new SimpleDateFormat("EEE", Locale.US);
            
        try {
            jam = (String) cbJam.getSelectedItem();
            menit = (String) cbMenit.getSelectedItem();
    
            field1 = Integer.parseInt(txtNoTrans.getText());
            field4 = Integer.parseInt(txtNomorItem.getText());
            field7 = sdfTglBlnThn.format(datepickerTanggalSewa.getDate());
            field8 = sdfHari.format(datepickerTanggalSewa.getDate());
            field9 = jam+":"+menit;
            field10 = (int)jSpinner1.getValue();
            field11 = Integer.parseInt(txtHarga.getText());
                
        } catch (NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(this,"Data yang Anda Masukkan Salah", "Informasi",
             JOptionPane.INFORMATION_MESSAGE);
        }
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());

        CustomerStudio newCS = new CustomerStudio();
        newCS.setNoTrans(Integer.parseInt(txtNoTrans.getText()));
        newCS.setTanggal(timeStamp+".0");
        newCS.setNama(txtNama.getText());
        newCS.setNoHP(txtNomorHP.getText());
        newCS.setNoItem(txtNomorItem.getText());
        newCS.setItem(txtItem.getText());
        newCS.setKet(txtKeterangan.getText());
                
        try {
            newCS.setTglSewa(sdfTglBlnThn.format(datepickerTanggalSewa.getDate()));
            newCS.setHariSewa(sdfHari.format(datepickerTanggalSewa.getDate()));
            newCS.setJamSewa(jam+":"+menit);
            this.listCustStudio.add(newCS);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Data yang Anda Masukkan Salah", "Informasi",
             JOptionPane.INFORMATION_MESSAGE);
        }
        boolean InputBerhasil = false;
        try {
            Connection con = new Koneksi().getCon();
            PreparedStatement myPreparedStatement = null;
            String sqlinput = "INSERT INTO `custstudio` "
                    + "(`notrans`, `tanggal`, `nama`, `nohp`, `noitem`, `item`, `ket`, `tglsewa`, `harisewa`, `jamsewa`, `durasisewa`, `harga`) "
                    + "VALUES (?, CURRENT_TIMESTAMP, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            myPreparedStatement = con.prepareStatement(sqlinput);
            myPreparedStatement.setInt(1, field1);
            myPreparedStatement.setString(2, field2);
            myPreparedStatement.setString(3, field3);
            myPreparedStatement.setInt(4, field4);
            myPreparedStatement.setString(5, field5);
            myPreparedStatement.setString(6, field6);
            myPreparedStatement.setString(7, field7);
            myPreparedStatement.setString(8, field8);
            myPreparedStatement.setString(9, field9);
            myPreparedStatement.setInt(10, field10);
            myPreparedStatement.setInt(11, field11);
            myPreparedStatement.executeUpdate();
            InputBerhasil = true;
         
        
        if (InputBerhasil == true) {
            JOptionPane.showMessageDialog(this,"Penambahan Sukses", "Informasi", 
                JOptionPane.INFORMATION_MESSAGE);
        } else if (InputBerhasil == false) {
            JOptionPane.showMessageDialog(this,"Penambahan Gagal", "Informasi",
            JOptionPane.INFORMATION_MESSAGE);
        }
            txtNoTrans.setText("");
            txtNama.setText("");
            txtNomorHP.setText("");
            txtNomorItem.setText("");
            txtItem.setText("");
            txtKeterangan.setText("");
            datepickerTanggalSewa.setDate(null);
            lblShowHari.setText("Pilih tanggal sewa terlebih dahulu");
            cbJam.setSelectedIndex(0);
            cbMenit.setSelectedIndex(0);
            jSpinner1.setValue(0);
            txtHarga.setText("");
         
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
        updateTable();
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String Jam = (String) cbJam.getSelectedItem();
        String Menit = (String) cbMenit.getSelectedItem();
        
        try {
            SimpleDateFormat SDHariSewa = new SimpleDateFormat("EEE", Locale.US);
            SimpleDateFormat DateWaktuSewa = new SimpleDateFormat("HH:mm");
            HariSewa = SDHariSewa.format(datepickerTanggalSewa.getDate());
            lblShowHari.setText(HariSewa);
        
            DateHari = SDHariSewa.parse(HariSewa);
            Senin = SDHariSewa.parse("MON");
            Selasa = SDHariSewa.parse("TUE");
            Rabu = SDHariSewa.parse("WED");
            Kamis = SDHariSewa.parse("THU");
            Jumat = SDHariSewa.parse("FRI");
            Sabtu = SDHariSewa.parse("SAT");
            Minggu = SDHariSewa.parse("SUN");
            DateWaktu = DateWaktuSewa.parse(Jam+":"+Menit);
            
            Sembilan = DateWaktuSewa.parse("09:00");
            EnamBelas = DateWaktuSewa.parse("16:00");
            DuaPuluh = DateWaktuSewa.parse("20:00");
            
            int jamSewa = (int)jSpinner1.getValue();
            if ( DateHari.equals(Senin) || DateHari.equals(Selasa) || DateHari.equals(Rabu) || DateHari.equals(Kamis) || DateHari.equals(Jumat))  {
            if (DateWaktu.before(EnamBelas)) {
                switch (jamSewa){
                case 1:
                    txtHarga.setText("90000");
                    break;
                case 2:
                    txtHarga.setText("150000");
                    break;
                default:
                    txtHarga.setText(String.valueOf(150000+(((int)jSpinner1.getValue()-2)*(75000))));
                    break;
                }
            }
            else if (DateWaktu.equals(EnamBelas) || DateWaktu.after(EnamBelas)) {
                switch (jamSewa){
                case 1:
                    txtHarga.setText("115000");
                    break;
                case 2:
                    txtHarga.setText("175000");
                    break;
                default:
                    txtHarga.setText(String.valueOf(175000+(((int)jSpinner1.getValue()-2)*(75000))));
                    break;
                }
            }
            
            
        }
        else if (DateHari.equals(Sabtu)) {
            if ((int)jSpinner1.getValue()==1) {
                txtHarga.setText("140000");
            }
            else if ((int)jSpinner1.getValue()==2) {
                txtHarga.setText("200000");
            }
            else if ((int)jSpinner1.getValue()>=3) {
                txtHarga.setText(String.valueOf(200000+(((int)jSpinner1.getValue()-2)*(75000))));
            }
        }
        else if (DateHari.equals(Minggu)) {
            if ((int)jSpinner1.getValue()==1) {
                txtHarga.setText("165000");
            }
            else if ((int)jSpinner1.getValue()==2) {
                txtHarga.setText("225000");
            }
            else if ((int)jSpinner1.getValue()>=3) {
                txtHarga.setText(String.valueOf(225000+(((int)jSpinner1.getValue()-2)*(75000))));
            }
        
        
        
        
        
        
        }
        } catch (NullPointerException | ParseException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Masukkan Data Tanggal yang benar!",
                    "Informasi",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        updateTable();
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        String field1 = txtNama.getText();
        String field2 = txtNomorHP.getText();
        int    field3 = 0;
        String field4 = txtItem.getText();
        String field5 = txtKeterangan.getText();
        String field6 = null;
        String field7 = null;
        String field8 = null;
        int    field9 = 0;
        int    field10 = 0;
        int field11 = 0;
        
        String jam = null;
        String menit = null;
        
        SimpleDateFormat sdfTglBlnThn = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfHari = new SimpleDateFormat("EEE", Locale.US);
            
        try {
            jam = (String) cbJam.getSelectedItem();
            menit = (String) cbMenit.getSelectedItem();
    
            field3 = Integer.parseInt(txtNomorItem.getText());
            field6 = sdfTglBlnThn.format(datepickerTanggalSewa.getDate());
            field7 = sdfHari.format(datepickerTanggalSewa.getDate());
            field8 = jam+":"+menit;
            field9 = (int)jSpinner1.getValue();
            field10 = Integer.parseInt(txtHarga.getText());
            field11 = Integer.parseInt(txtNoTrans.getText());
                
        } catch (NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(this,"Data yang Anda Masukkan Salah (1)", "Informasi",
             JOptionPane.INFORMATION_MESSAGE);
        }
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());

        CustomerStudio newCS = new CustomerStudio();
        newCS.setNoTrans(Integer.parseInt(txtNoTrans.getText()));
        newCS.setTanggal(timeStamp+".0");
        newCS.setNama(txtNama.getText());
        newCS.setNoHP(txtNomorHP.getText());
        newCS.setNoItem(txtNomorItem.getText());
        newCS.setItem(txtItem.getText());
        newCS.setKet(txtKeterangan.getText());
                
        try {
            newCS.setTglSewa(sdfTglBlnThn.format(datepickerTanggalSewa.getDate()));
            newCS.setHariSewa(sdfHari.format(datepickerTanggalSewa.getDate()));
            newCS.setJamSewa(jam+":"+menit);
            newCS.setDurasiSewa(String.valueOf(jSpinner1.getValue()));
            newCS.setHarga(txtHarga.getText());
            this.listCustStudio.set(index, newCS);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Data yang Anda Masukkan Salah (2)", "Informasi",
             JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }
        boolean InputBerhasil = false;
        try {
            Connection con = new Koneksi().getCon();
            PreparedStatement myPreparedStatement = null;
            String sqlupdate = "UPDATE `custstudio` SET "
                    + "`nama` = ?, `nohp` = ?, `noitem` = ?, `item` = ?, `ket` = ?, `tglsewa` = ?, `harisewa` = ?, `jamsewa` = ?, `durasisewa` = ?, `harga` = ? "
                    + "WHERE `custstudio`.`notrans` = ?";
            myPreparedStatement = con.prepareStatement(sqlupdate);
            
            myPreparedStatement.setString(1, field1);
            myPreparedStatement.setString(2, field2);
            myPreparedStatement.setInt(3, field3);
            myPreparedStatement.setString(4, field4);
            myPreparedStatement.setString(5, field5);
            myPreparedStatement.setString(6, field6);
            myPreparedStatement.setString(7, field7);
            myPreparedStatement.setString(8, field8);
            myPreparedStatement.setInt(9, field9);
            myPreparedStatement.setInt(10, field10);
            myPreparedStatement.setInt(11, field11);
            myPreparedStatement.executeUpdate();
            InputBerhasil = true;
         
        
        if (InputBerhasil == true) {
            JOptionPane.showMessageDialog(this,"Penambahan Sukses", "Informasi", 
                JOptionPane.INFORMATION_MESSAGE);
        } else if (InputBerhasil == false) {
            JOptionPane.showMessageDialog(this,"Penambahan Gagal", "Informasi",
            JOptionPane.INFORMATION_MESSAGE);
        }
         
       //myPreparedStatement.close();
       //con.close();
       
            
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this,"Error", "Informasi",
             JOptionPane.INFORMATION_MESSAGE);
        } catch (NullPointerException | SQLException ex) {
            InputBerhasil = false;
            JOptionPane.showMessageDialog(this,"Terdapat kesalahan input data", "Informasi", 
                JOptionPane.INFORMATION_MESSAGE);
            ex.printStackTrace();
        }
        updateTable();
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       index = listCustStudio.size()-1;
       showData();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
    int NoTransTempInt = listCustStudio.get(listCustStudio.size()-1).getNoTrans()+1;
        txtNoTrans.setText(String.valueOf(NoTransTempInt));
        txtNama.setText("");
        txtNomorHP.setText("");
        txtNomorItem.setText("");
        txtItem.setText("");
        txtKeterangan.setText("");
        datepickerTanggalSewa.setDate(null);
        lblShowHari.setText("Pilih tanggal sewa terlebih dahulu!");
        cbJam.setSelectedIndex(0);
        cbMenit.setSelectedIndex(0);
        jSpinner1.setValue(0);
        txtHarga.setText("");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Yakin akan dihapus?", "Konfirmasi", 0) == 0) {
            Connection con = new Koneksi().getCon();
            PreparedStatement myPreparedStatement = null;
            String sqldelete = "DELETE FROM custstudio WHERE `notrans` =?";
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
            listCustStudio.remove(index);
            this.updateTable();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txtNomorHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomorHPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomorHPActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        index = 0;
        showData();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void datepickerTanggalSewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datepickerTanggalSewaActionPerformed

        SimpleDateFormat SDHariSewa = new SimpleDateFormat("EEE", Locale.US);
        HariSewa = SDHariSewa.format(datepickerTanggalSewa.getDate());
        lblShowHari.setText(HariSewa);
    }//GEN-LAST:event_datepickerTanggalSewaActionPerformed

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
            java.util.logging.Logger.getLogger(FormSewaStudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSewaStudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSewaStudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSewaStudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSewaStudio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbJam;
    private javax.swing.JComboBox<String> cbMenit;
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
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblShowHari;
    private javax.swing.JTable tblStudio;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtItem;
    private javax.swing.JTextField txtKeterangan;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoTrans;
    private javax.swing.JTextField txtNomorHP;
    private javax.swing.JTextField txtNomorItem;
    // End of variables declaration//GEN-END:variables
}
