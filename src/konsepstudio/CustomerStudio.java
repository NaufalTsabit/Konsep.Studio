/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konsepstudio;

/**
 *
 * @author Athma Farhan
 */
public class CustomerStudio {
    private int noTrans;
    private String tanggal;
    private String nama;
    private String noHP;
    private String noItem;
    private String item;
    private String ket;
    private String tglSewa;
    private String hariSewa;
    private String jamSewa;
    private String durasiSewa;
    private String harga;

    public CustomerStudio() {
    }

    public CustomerStudio(int noTrans, String tanggal, String nama, String noHP, String noItem, String item, String ket, String tglSewa, String hariSewa, String jamSewa, String durasiSewa, String harga) {
        this.noTrans = noTrans;
        this.tanggal = tanggal;
        this.nama = nama;
        this.noHP = noHP;
        this.noItem = noItem;
        this.item = item;
        this.ket = ket;
        this.tglSewa = tglSewa;
        this.hariSewa = hariSewa;
        this.jamSewa = jamSewa;
        this.durasiSewa = durasiSewa;
        this.harga = harga;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public int getNoTrans() {
        return noTrans;
    }

    public void setNoTrans(int noTrans) {
        this.noTrans = noTrans;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getNoItem() {
        return noItem;
    }

    public void setNoItem(String noItem) {
        this.noItem = noItem;
    }
    
    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getTglSewa() {
        return tglSewa;
    }

    public void setTglSewa(String tglSewa) {
        this.tglSewa = tglSewa;
    }

    public String getHariSewa() {
        return hariSewa;
    }

    public void setHariSewa(String hariSewa) {
        this.hariSewa = hariSewa;
    }

    public String getJamSewa() {
        return jamSewa;
    }

    public void setJamSewa(String jamSewa) {
        this.jamSewa = jamSewa;
    }

    public String getDurasiSewa() {
        return durasiSewa;
    }

    public void setDurasiSewa(String durasiSewa) {
        this.durasiSewa = durasiSewa;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    
    
}
