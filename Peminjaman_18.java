public class Peminjaman_18 {
    Mahasiswa_18 mhs;
    Buku_18 buku;
    int lamaPinjam;
    int batasPinjam = 5; // Batas pinjam 5 hari
    int terlambat;
    int denda;

    // Konstruktor peminjaman 
    public Peminjaman_18(Mahasiswa_18 mhs, Buku_18 buku, int lamaPinjam) {
        this.mhs = mhs;
        this.buku = buku;
        this.lamaPinjam = lamaPinjam;
        hitungDenda(); // Langsung hitung denda saat objek dibuat
    }

    // Method untuk menghitung denda keterlambatan [cite: 16, 26, 50]
    public void hitungDenda() {
        if (lamaPinjam > batasPinjam) {
            terlambat = lamaPinjam - batasPinjam;
            denda = terlambat * 2000; // Denda Rp 2.000 per hari [cite: 26]
        } else {
            terlambat = 0;
            denda = 0;}
    }

    // Menampilkan detail transaksi peminjaman [cite: 51, 110-118]
    public void tampilPeminjaman() {
        System.out.println(mhs.nama + " | " + buku.judul + " | Lama: " + lamaPinjam +" | Terlambat: " + terlambat + " | Denda: " + denda);
    }
}