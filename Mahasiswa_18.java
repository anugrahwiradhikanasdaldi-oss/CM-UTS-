public class Mahasiswa_18 {
    String nim, nama, prodi;

    // Konstruktor sesuai 
    public Mahasiswa_18(String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    // Menampilkan data mahasiswa
    public void tampilMahasiswa() {
        System.out.println("NIM: " + nim + " | Nama: " + nama + " | Prodi: " + prodi);
    }
}