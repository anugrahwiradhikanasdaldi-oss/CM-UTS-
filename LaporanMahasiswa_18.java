public class LaporanMahasiswa_18 {
    Mahasiswa_18 mahasiswa;
    int totalPinjam;
    int totalDenda;
    int totalTerlambat;
    // Konstruktor untuk inisialisasi dengan objek Mahasiswa
    public LaporanMahasiswa_18(Mahasiswa_18 mahasiswa) {
        this.mahasiswa = mahasiswa;
    }
    // Method untuk menghitung laporan berdasarkan data peminjaman
    public void hitungLaporan(Peminjaman_18[] pinjam) {
        this.totalPinjam = 0;
        this.totalDenda = 0;
        this.totalTerlambat = 0;
        for (Peminjaman_18 p : pinjam) {
            if (p.mhs.nim.equals(this.mahasiswa.nim)) {
                this.totalPinjam++;
                this.totalDenda += p.denda;
                if (p.terlambat > 0) {
                    this.totalTerlambat++;
                }
            }
        }
    }
    // Method untuk menampilkan laporan mahasiswa
    public void tampilLaporan() {
        System.out.println("NIM: " + mahasiswa.nim + " | Nama: " + mahasiswa.nama + 
            " | Total Pinjam: " + totalPinjam + " | Total Denda: Rp " + totalDenda + 
            " | Terlambat: " + totalTerlambat + "x");
    }
}