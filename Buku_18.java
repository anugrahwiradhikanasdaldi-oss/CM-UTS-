public class Buku_18 {
    String kodeBuku, judul;
    int tahunTerbit;

    // Konstruktor sesuai class diagram 
    public Buku_18(String kode, String judul, int tahun) {
        this.kodeBuku = kode;
        this.judul = judul;
        this.tahunTerbit = tahun; 
    }
    // Menampilkan data buku 
    public void tampilBuku() {
        System.out.println("Kode: " + kodeBuku + " | Judul: " + judul + " | Tahun: " + tahunTerbit);
    }
}