/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konsepstudio;

/**
 *
 * @author Asus
 */
public class CustomerKamera {
    private int NoTrans;
    private String Tanggal;
    private String Nama;
    private String Jaminan;
    private String NoHP;
    private String NoKamera;
    private String Merk;
    private String Jenis;
    private String Ket;
    private String JmlHari;
    private String TglKembali;
    private String HariKembali;
    private String Harga;

    public CustomerKamera() {
    }

    public CustomerKamera(int NoTrans, String Tanggal, String Nama, String Jaminan, String NoHP, String NoKamera, String Merk, String Jenis, String Ket, String JmlHari, String TglKembali, String HariKembali, String Harga) {
        this.NoTrans = NoTrans;
        this.Tanggal = Tanggal;
        this.Nama = Nama;
        this.Jaminan = Jaminan;
        this.NoHP = NoHP;
        this.NoKamera = NoKamera;
        this.Merk = Merk;
        this.Jenis = Jenis;
        this.Ket = Ket;
        this.JmlHari = JmlHari;
        this.TglKembali = TglKembali;
        this.HariKembali = HariKembali;
        this.Harga = Harga;
    }

   

    public int getNoTrans() {
        return NoTrans;
    }

    public void setNoTrans(int NoTrans) {
        this.NoTrans = NoTrans;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String Tanggal) {
        this.Tanggal = Tanggal;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getJaminan() {
        return Jaminan;
    }

    public void setJaminan(String Jaminan) {
        this.Jaminan = Jaminan;
    }

    public String getNoHP() {
        return NoHP;
    }

    public void setNoHP(String NoHP) {
        this.NoHP = NoHP;
    }

    public String getNoKamera() {
        return NoKamera;
    }

    public void setNoKamera(String NoKamera) {
        this.NoKamera = NoKamera;
    }
    
    public String getJenis() {
        return Jenis;
    }

    public void setJenis(String Jenis) {
        this.Jenis = Jenis;
    }

    public String getKet() {
        return Ket;
    }

    public void setKet(String Ket) {
        this.Ket = Ket;
    }

    public String getJmlHari() {
        return JmlHari;
    }

    public void setJmlHari(String JmlHari) {
        this.JmlHari = JmlHari;
    }

    public String getTglKembali() {
        return TglKembali;
    }

    public void setTglKembali(String TglKembali) {
        this.TglKembali = TglKembali;
    }

    public String getHariKembali() {
        return HariKembali;
    }

    public void setHariKembali(String HariKembali) {
        this.HariKembali = HariKembali;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String Harga) {
        this.Harga = Harga;
    }

    public String getMerk() {
        return Merk;
    }

    public void setMerk(String Merk) {
        this.Merk = Merk;
    }
    
    
    
}
