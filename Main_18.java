import java.util.Scanner;

public class Main_18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Inisialisasi data mahasiswa sesuai tabel 
        Mahasiswa_18[] daftarMhs = {
            new Mahasiswa_18("25001", "dika", "Sistem Informasi Bisnis"),
            new Mahasiswa_18("25002", "nanas", "teknik informatika"),
            new Mahasiswa_18("25003", "repi", "Sistem Informasi Bisnis")
        };

        // Inisialisasi data buku sesuai tabel 
        Buku_18[] daftarBuku = {
            new Buku_18("B001", "Algoritma", 2020),
            new Buku_18("B002", "Basis Data", 2019),
            new Buku_18("B003", "Pemrograman", 2021),
            new Buku_18("B004", "bisnis", 2024)
        };

        // Inisialisasi data peminjaman (Array of Objects)
        Peminjaman_18[] pinjam = {
            new Peminjaman_18(daftarMhs[0], daftarBuku[0], 7),
            new Peminjaman_18(daftarMhs[1], daftarBuku[1], 3),
            new Peminjaman_18(daftarMhs[2], daftarBuku[2], 10),
            new Peminjaman_18(daftarMhs[2], daftarBuku[3], 6),
            new Peminjaman_18(daftarMhs[0], daftarBuku[1], 4)
        };

        int pilihan;
        do {
            // Menu Utama 
            System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan Berdasarkan Denda");
            System.out.println("5. Cari Berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (pilihan) {
                case 1:
                    System.out.println("Daftar Mahasiswa:");
                    for (Mahasiswa_18 m : daftarMhs) m.tampilMahasiswa();
                    break;
                case 2:
                    System.out.println("Daftar Buku:");
                    for (Buku_18 b : daftarBuku) b.tampilBuku();
                    break;
                case 3:
                    System.out.println("Data Peminjaman:");
                    for (Peminjaman_18 p : pinjam) p.tampilPeminjaman();
                    break;
                case 4:
                    // Implementasi Selection Sort (Denda Terbesar)
                    for (int i = 0; i < pinjam.length - 1; i++) {
                        int idxMax = i;
                        for (int j = i + 1; j < pinjam.length; j++) {
                            if (pinjam[j].denda > pinjam[idxMax].denda) {
                                idxMax = j;
                            }
                        }
                        Peminjaman_18 temp = pinjam[idxMax];
                        pinjam[idxMax] = pinjam[i];
                        pinjam[i] = temp;
                    }
                    System.out.println("Setelah diurutkan (Denda terbesar):");
                    for (Peminjaman_18 p : pinjam) p.tampilPeminjaman();
                    break;
                case 5:
                    // Implementasi Sequential Search berdasarkan NIM
                    System.out.print("Masukkan NIM: ");
                    String cariNim = sc.nextLine();
                    boolean ditemukan = false;
                    for (Peminjaman_18 p : pinjam) {
                        if (p.mhs.nim.equals(cariNim)) {
                            p.tampilPeminjaman();
                            ditemukan = true;
                        }
                    }
                    if (!ditemukan) System.out.println("Data dengan NIM tersebut tidak ditemukan.");
                    break;
                case 0:
                    System.out.println("Keluar program...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }
}