/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Athma Farhan
 */
public class Kamera {
    private final String MerkKamera;
    private final String JenisKamera;
    private final int HargaPerHari;
    private final int HargaPerTigaHari;
    private final int HargaPerTujuhHari;

    public Kamera(String MerkKamera, String JenisKamera, int HargaPerHari, int HargaPerTigaHari, int HargaPerTujuhHari) {

        this.MerkKamera = MerkKamera;
        this.JenisKamera = JenisKamera;
        this.HargaPerHari = HargaPerHari;
        this.HargaPerTigaHari = HargaPerTigaHari;
        this.HargaPerTujuhHari = HargaPerTujuhHari;
    }


    public String getMerkKamera() {
        return MerkKamera;
    }

    public String getJenisKamera() {
        return JenisKamera;
    }

    public int getHargaPerHari() {
        return HargaPerHari;
    }

    public int getHargaPerTigaHari() {
        return HargaPerTigaHari;
    }

    public int getHargaPerTujuhHari() {
        return HargaPerTujuhHari;
    }
    
    
}
