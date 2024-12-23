## RerinCar - Rental Mobil GUI

### Deskripsi Proyek
RerinCar adalah aplikasi GUI berbasis Java yang dirancang untuk mengelola penyewaan kendaraan. Aplikasi ini memungkinkan pengguna untuk menambah kendaraan, menyewa kendaraan, dan menghapus kendaraan dari daftar yang tersedia. Proyek ini dibangun menggunakan pustaka `javax.swing` untuk GUI.

---

### Fitur Utama
1. **Tambah Kendaraan**  
   Pengguna dapat menambahkan kendaraan baru ke daftar dengan mengisi nama kendaraan, tipe kendaraan, dan harga sewa per hari.

2. **Sewa Kendaraan**  
   Pengguna dapat menyewa kendaraan dengan memasukkan informasi pemesanan, seperti nama penyewa, tanggal sewa, tanggal pengembalian, dan jaminan.

3. **Hapus Kendaraan**  
   Pengguna dapat menghapus kendaraan yang tersedia dari daftar.

4. **Antarmuka Grafis**  
   Aplikasi memiliki antarmuka yang ramah pengguna dengan panel daftar kendaraan, tombol aksi, dan header yang menampilkan logo dan nama aplikasi.

---

### Struktur Proyek
- **`RentalCarGUI`**: Kelas utama yang mengatur GUI aplikasi dan logika utama seperti menambah, menyewa, dan menghapus kendaraan.
- **`Vehicle`**: Kelas model yang merepresentasikan kendaraan, mencakup informasi seperti nama, tipe, dan harga sewa.

---

### Teknologi yang Digunakan
- **Java**: Bahasa pemrograman utama.
- **Swing**: Digunakan untuk membangun antarmuka grafis.
- **ArrayList**: Struktur data untuk menyimpan daftar kendaraan.

---

### Cara Menjalankan Proyek
1. Pastikan Anda memiliki **Java Development Kit (JDK)** yang diinstal di komputer Anda.
2. Simpan file kode ke dalam file bernama `RentalCarGUI.java`.
3. Pastikan file logo aplikasi (`logo.png`) berada dalam direktori yang sama dengan file Java.
4. Buka terminal atau IDE dan jalankan program dengan perintah:
   ```bash
   javac RentalCarGUI.java
   java RentalCarGUI
   ```

---

### Cara Menggunakan
1. **Tambah Kendaraan**  
   Klik tombol "Tambah Kendaraan", masukkan data kendaraan, lalu klik OK. Kendaraan akan ditambahkan ke daftar.

2. **Sewa Kendaraan**  
   Pilih kendaraan dari daftar, klik tombol "Sewa Kendaraan", masukkan data penyewa, dan konfirmasi pemesanan.

3. **Hapus Kendaraan**  
   Pilih kendaraan dari daftar, lalu klik tombol "Hapus Kendaraan".

---

### Catatan Penting
- Format tanggal untuk penyewaan adalah `YYYY-MM-DD`.
- Harga sewa harus berupa angka desimal.
- Pastikan file `logo.png` tersedia untuk menampilkan logo di aplikasi.

---

### Lisensi
Proyek ini bersifat open-source dan dapat digunakan, dimodifikasi, serta didistribusikan untuk keperluan apa pun.