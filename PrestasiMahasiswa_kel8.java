import java.util.Scanner;

public class PrestasiMahasiswa_kel8 {
    static String[][] prestasi = new String[50][4]; 
    static int[] tahunPrestasi = new int[50];          
    static int jmlPrestasi = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n===== PENCATATAN PRESTASI MAHASISWA =====");
            System.out.println("1. Tambah Data Prestasi Mahasiswa");
            System.out.println("2. Tampilkan Semua Prestasi");
            System.out.println("3. Analisis Prestasi Berdasarkan Jenis");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine(); 
            switch (pilihan) {
                case 1 -> tambahdataPrestasi();
                case 2 -> tampilkanPrestasi();
                case 3 -> analisisPrestasi();
                case 4 -> System.out.println("Program selesai. Terima kasih!");
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 4);
    }

    static void tambahdataPrestasi() {
        System.out.print("Masukkan Nama Mahasiswa: ");
        prestasi[jmlPrestasi][0] = sc.nextLine();

        System.out.print("Masukkan NIM Mahasiswa: ");
        prestasi[jmlPrestasi][1] = sc.nextLine();

        System.out.print("Masukkan Jenis Prestasi (): ");
        prestasi[jmlPrestasi][2] = sc.nextLine();

        String tingkat;
        do {
            System.out.print("Masukkan Tingkat Prestasi (Lokal/Nasional/Internasional): ");
            tingkat = sc.nextLine();
            if (!tingkat.equalsIgnoreCase("Lokal") && !tingkat.equalsIgnoreCase("Nasional") && !tingkat.equalsIgnoreCase("Internasional")) {
                System.out.println("Input tidak valid. Masukkan kembali tingkat prestasi.");
            }
        } while (!tingkat.equalsIgnoreCase("Lokal") && !tingkat.equalsIgnoreCase("Nasional") && !tingkat.equalsIgnoreCase("Internasional"));
        prestasi[jmlPrestasi][3] = tingkat;

        int tahun;
        do {
            System.out.print("Masukkan Tahun Prestasi (2010-2024): ");
            tahun = sc.nextInt();
            sc.nextLine(); 
            if (tahun < 2010 || tahun > 2024) {
                System.out.println("Tahun tidak valid. Masukkan kembali tahun prestasi.");
            }
        } while (tahun < 2010 || tahun > 2024);
        tahunPrestasi[jmlPrestasi] = tahun;

        jmlPrestasi++;
        System.out.println("Data prestasi berhasil ditambahkan.");
    }

    static void tampilkanPrestasi() {
        if (jmlPrestasi == 0) {
            System.out.println("Belum ada data prestasi.");
        } else {
            System.out.println("\n===== DAFTAR PRESTASI MAHASISWA =====");
            for (int i = 0; i < jmlPrestasi; i++) {
                System.out.printf("Nama: %s | NIM: %s | Jenis: %s | Tingkat: %s | Tahun: %d%n",
                        prestasi[i][0], prestasi[i][1], prestasi[i][2], prestasi[i][3], tahunPrestasi[i]);
            }
        }
    }

    static void analisisPrestasi() {
        System.out.print("Masukkan Jenis Prestasi untuk Analisis: ");
        String jenisAnalisis = sc.nextLine();
        boolean ditemukan = false;

        System.out.println("\n===== ANALISIS PRESTASI =====");
        for (int i = 0; i < jmlPrestasi; i++) {
            if (prestasi[i][2].equalsIgnoreCase(jenisAnalisis)) {
                System.out.printf("Nama: %s | NIM: %s | Tingkat: %s | Tahun: %d%n",
                        prestasi[i][0], prestasi[i][1], prestasi[i][3], tahunPrestasi[i]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada data prestasi dengan jenis tersebut.");
        }
    }
}