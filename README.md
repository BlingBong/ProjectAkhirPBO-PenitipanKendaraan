# ProjectAkhir PBO Penitipan Kendaraan
## Implementasi Pemrograman Berorientasi Objek Java pada Sistem Usaha Penitipan Kendaraan.

- Program ini merupakan program yang digunakan untuk memudahkan pengelola usaha penitipan kendaraan dalam proses pelayanan pelanggan, pemantauan tempat penitipan, dan pencatatan administrasi usaha.

- Dalam implementasinya, program ini menggunakan konsep MVC dan terintegrasi dengan database lokal yang dibangun menggunakan MySQL.

- Program ini dimulai dari tampilan menu utama atau home yang akan menampilkan tombol-tombol untuk menjalankan fungsi dan menu program lainnya.

   ![image](https://github.com/BlingBong/ProjectAkhirPBO-PenitipanKendaraan/assets/62862052/cc43d7af-23f2-475a-a288-9a8924ebcfdc)

- Pada menu penitipan, pengguna dapat memasukkan data kendaraan pelanggan yang masuk beserta pemilihan nomor tempat penitipan. Tempat penitipan yang disediakan adalah sebanyak 20 tempat, dan jika sudah terisi maka tidak akan bisa dipilih lagi untuk kendaraan lain. Tanggal dan waktu masuk kendaraan akan otomatis dibaca dari waktu PC guna proses perhitungan tarif nantinya. Data-data tersebut kemudian akan disimpan di dalam database.

   ![image](https://github.com/BlingBong/ProjectAkhirPBO-PenitipanKendaraan/assets/62862052/75f31ff8-f9ae-4441-864e-3a158e205ca7)

- Pengguna dapat melihat daftar data kendaraan yang ada di database lewat menu data, data-data tersebut juga dapat dilihat secara detail untuk dilakukan proses perubahan data jika terdapat kesalahan atau dilanjutkan ke menu pengambilan kendaraan. Pada menu proses pengambilan, tanggal dan waktu keluar juga akan secara otomatis dibaca dari waktu PC. Pada menu ini, pengguna perlu memilih apakah pelanggan masih memiliki nomor karcis parkir. Untuk kemudian, program akan secara otomatis menghitung tarif total penitipan kendaraan.

   ![image](https://github.com/BlingBong/ProjectAkhirPBO-PenitipanKendaraan/assets/62862052/3a9b7fe6-6e0e-4b26-80a3-fd7907657835)

- Tarif untuk motor adalah Rp.2000,00/jam dan untuk mobil adalah Rp.3000,00/jam. Jika pengguna kehilangan nomor karcis, maka tarif akan ditambah sebesar Rp.30.000,00. Kemudian, pengguna perlu memasukkan jumlah uang pelanggan yang digunakan untuk pembayaran. Program akan secara otomatis mendeteksi apakah uang tersebut kurang, pas, atau membutuhkan kembalian. Setelah proses pembayaran selesai, pengguna dapat mencetak nota untuk diberikan ke pelanggan.

   ![image](https://github.com/BlingBong/ProjectAkhirPBO-PenitipanKendaraan/assets/62862052/f631aafe-e01d-469d-83a0-ee661685fdc4)
   ![image](https://github.com/BlingBong/ProjectAkhirPBO-PenitipanKendaraan/assets/62862052/2888b23a-9691-47fc-b823-b8a72a5839af)

- Pengguna juga dapat memantau status tempat penitipan kendaraan terkini pada menu status. Jika berwarna hijau, maka tempat tersebut masih kosong. Jika berwarna merah, maka tempat tersebut sudah terisi. Tempat yang sudah terisi dapat langsung ditekan untuk melihat detail kendaraan tersebut.

   ![image](https://github.com/BlingBong/ProjectAkhirPBO-PenitipanKendaraan/assets/62862052/9c9e5a81-a661-48b1-a63e-2c644e277c76)

- Terakhir, terdapat menu riwayat yang akan menampilkan daftar riwayat data kendaraan yang pernah dititipkan. Lengkap dari identitas kendaraan, tanggal masuk, tanggal keluar, hingga detail pembayaran.

   ![image](https://github.com/BlingBong/ProjectAkhirPBO-PenitipanKendaraan/assets/62862052/a6f3112b-cc0b-4ab5-9fc9-4e8e734e5b5c)
