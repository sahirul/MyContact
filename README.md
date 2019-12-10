# MyContact
Menampilkan data dari internet dengan format JSON
Langkah langkah untuk melakukan praktikum:
1. Edit file build.gradle (module:app) tambahkan
    implementation 'com.loopj.android:android-async-http:1.4.9'
    implementation 'androidx.recyclerview:recyclerview:1.0.0'
    implementation 'com.android.support:cardview-v7:27.1.1'
2. Edit file AndroidManifest.xml
    <uses-permission android:name="android.permission.INTERNET" />
3. Membuat tampilan pada file activity_main.xml dan layout_row_contact.xml
4. Membuat file MyContact.java yang merupakan Plain Old Java Object.
5. Membuat ContactAsynctTaskLoader.java yang merupakan cara untuk koneksi ke API di internet
6. Membuat ContactAdapter.java yang merupakan pertengahan antara recyclerview dengan data
7. Mengubah MainActivity.java untuk menghubungkan semuanya
8. Membuat DetailContact.java untuk melihat detail dari data.

#Selamat mencoba
