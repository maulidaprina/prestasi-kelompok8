public class PrestasiMahasiswa_kel8Tampildananalisisprestasi {
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

