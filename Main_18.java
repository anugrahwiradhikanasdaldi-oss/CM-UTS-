import java.util.Scanner;

public class Main_18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Mahasiswa_18[] daftarMhs = {
            new Mahasiswa_18("25001", "Andi", "Sistem Informasi Bisnis"),
            new Mahasiswa_18("25002", "Budi", "Teknik Informatika"),
            new Mahasiswa_18("25003", "Citra", "Sistem Informasi Bisnis")
        };

        Buku_18[] daftarBuku = {
            new Buku_18("B001", "Algoritma", 2020),
            new Buku_18("B002", "Basis Data", 2019),
            new Buku_18("B003", "Pemrograman", 2021),
            new Buku_18("B004", "Fisika", 2024)
        };

        Peminjaman_18[] pinjam = {
            new Peminjaman_18(daftarMhs[0], daftarBuku[0], 7),
            new Peminjaman_18(daftarMhs[1], daftarBuku[1], 3),
            new Peminjaman_18(daftarMhs[2], daftarBuku[2], 10),
            new Peminjaman_18(daftarMhs[2], daftarBuku[3], 6),
            new Peminjaman_18(daftarMhs[0], daftarBuku[1], 4)
        };

        // Hitung denda awal untuk data dummy
        for(Peminjaman_18 p : pinjam) p.hitungDenda();

        int pilihan;
        do {
            System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan Berdasarkan Denda ");
            System.out.println("5. Cari Berdasarkan NIM ");
            System.out.println("6. Tambah Data Peminjaman");
            System.out.println("7. Tampilkan Statistik");
            System.out.println("8. Laporan Per Mahasiswa ");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine(); 

            switch (pilihan) {
                case 1:
                    for (Mahasiswa_18 m : daftarMhs) m.tampilMahasiswa();
                    break;
                case 2:
                    for (Buku_18 b : daftarBuku) b.tampilBuku();
                    break;
                case 3:
                    for (Peminjaman_18 p : pinjam) p.tampilPeminjaman();
                    break;

                case 4: 
                    // LEVEL MEDIUM: Insertion Sort Descending 
                    for (int i = 1; i < pinjam.length; i++) {
                        Peminjaman_18 key = pinjam[i];
                        int j = i - 1;
                        while (j >= 0 && pinjam[j].denda < key.denda) {
                            pinjam[j + 1] = pinjam[j];
                            j = j - 1;
                        }
                        pinjam[j + 1] = key;
                    }
                    System.out.println("Setelah diurutkan dengan Insertion Sort (Denda terbesar):");
                    for (Peminjaman_18 p : pinjam) p.tampilPeminjaman();
                    break;

                case 5:
                    // LEVEL MEDIUM: Binary Search berdasarkan NIM Mahasiswa
                    System.out.print("Masukkan NIM: ");
                    String cariNim = sc.nextLine();
                    Peminjaman_18[] salinan = new Peminjaman_18[pinjam.length];
                    System.arraycopy(pinjam, 0, salinan, 0, pinjam.length);
                    for (int i = 1; i < salinan.length; i++) {
                        Peminjaman_18 key = salinan[i];
                        int j = i - 1;
                        while (j >= 0 && salinan[j].mhs.nim.compareTo(key.mhs.nim) > 0) {
                            salinan[j + 1] = salinan[j];
                            j--;
                        }
                        salinan[j + 1] = key;
                    }
                    // 3. Binary Search
                    int low = 0, high = salinan.length - 1, mid = -1;
                    boolean found = false;
                    while (low <= high) {
                        int currentMid = (low + high) / 2;
                        if (salinan[currentMid].mhs.nim.equals(cariNim)) {
                            mid = currentMid;
                            found = true;
                            break;
                        } else if (salinan[currentMid].mhs.nim.compareTo(cariNim) < 0) {
                            low = currentMid + 1;
                        } else {
                            high = currentMid - 1;
                        }
                    }

                    if (found) {
                        System.out.println("[Binary Search] Data ditemukan:");
                        // Ekspansi ke kiri 
                        int left = mid;
                        while (left >= 0 && salinan[left].mhs.nim.equals(cariNim)) {
                            left--;
                        }
                        // Ekspansi ke kanan dan tampilkan data yang cocok
                        for (int k = left + 1; k < salinan.length && salinan[k].mhs.nim.equals(cariNim); k++) {
                            salinan[k].tampilPeminjaman();
                        }
                    } else {
                        System.out.println("Data tidak ditemukan!");
                    }
                    break;

                case 6:
                    // LEVEL EASY : Tambah data peminjaman baru
                    System.out.print("Masukkan NIM: ");
                    String nimIn = sc.nextLine();
                    Mahasiswa_18 mFound = null;
                    for (Mahasiswa_18 m : daftarMhs) if (m.nim.equals(nimIn)) mFound = m;
                    
                    if (mFound == null) {
                        System.out.println("NIM tidak ditemukan!");
                        break;
                    }

                    System.out.print("Masukkan Kode Buku: ");
                    String bIn = sc.nextLine();
                    Buku_18 bFound = null;
                    for (Buku_18 b : daftarBuku) if (b.kodeBuku.equals(bIn)) bFound = b;

                    if (bFound == null) {
                        System.out.println("Kode buku tidak ditemukan!");
                        break;
                    }

                    System.out.print("Masukkan lama pinjam (hari): ");
                    int lama = sc.nextInt();
                    Peminjaman_18 baru = new Peminjaman_18(mFound, bFound, lama);
                    baru.hitungDenda(); 

                    Peminjaman_18[] tempArr = new Peminjaman_18[pinjam.length + 1];
                    System.arraycopy(pinjam, 0, tempArr, 0, pinjam.length);
                    tempArr[tempArr.length - 1] = baru;
                    pinjam = tempArr;
                    System.out.println("Data peminjaman berhasil ditambahkan!");
                    break;

                case 7: // LEVEL EASY: TAMPILKAN DATA PEMINJAMAN  
                    int totDenda = 0, telat = 0, tepat = 0;
                    for (Peminjaman_18 p : pinjam) {
                        totDenda += p.denda;
                        if (p.terlambat > 0) telat++; else tepat++;
                    }
                    System.out.println("=== STATISTIK PEMINJAMAN ===");
                    System.out.println("Total Denda Keseluruhan: Rp " + totDenda);
                    System.out.println("Jumlah Peminjaman Terlambat: " + telat);
                    System.out.println("Jumlah Peminjaman Tepat Waktu: " + tepat);
                    break;

                case 8:
                    // LEVEL HARD: Laporan Per Mahasiswa 
                    System.out.println("=== LAPORAN PER MAHASISWA ===");
                    LaporanMahasiswa_18[] laporan = new LaporanMahasiswa_18[daftarMhs.length];
                    for (int i = 0; i < daftarMhs.length; i++) {
                        laporan[i] = new LaporanMahasiswa_18(daftarMhs[i]);
                        laporan[i].hitungLaporan(pinjam); // Menggunakan array pinjam terbaru 
                        laporan[i].tampilLaporan();
                    }
                    break;

                case 0:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }
}