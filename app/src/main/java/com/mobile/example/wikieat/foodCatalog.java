package com.mobile.example.wikieat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class foodCatalog extends AppCompatActivity {
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private TextView namaMakanan;
    private TextView deskripsi;
    private TextView hargaText;
    private Button kembaliButton;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_catalog);
        backButton = findViewById(R.id.backButton);
        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new foodImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String Name;
                String Desc;
                String Harga;

                if (position == 0){
                Name = "Onigiri";
                Desc = "Onigiri adalah nasi kepal versi Jepang yang biasanya berbentuk bola atau segitiga.\n\n" +
                        "Di Dalam Onigiri biasanya diisi salmon, ayam, umeboshi, dan tuna (dried plum) lalu " +
                        "kemudian dibungkus dengan nori. Jika Anda baru pertama kali mencobai onigiri, \n" +
                        "pilihlah tuna dengan mayonese, atau ayam mayonaise karena rasanya sangat familiar dengan lidah Indonesia. \n\n" +
                        "Onigiri sangat mudah ditemukan di Jepang, hampir semua convenience store menjualnya.";
                Harga = "Rp. 10.000 - 20.000";
                    popupdialog(Name,Desc,Harga);
                }

                else if (position == 1){
                    Name = "Ramen";
                    Desc = "Ramen adalah hidangan mie sup yang telah berkembang menjadi sangat populer \n" +
                            "dan dianggap sebagai buah bibir untuk makanan Jepang. \n\n" +
                            "Awalnya, sup dibuat dari tulang ayam, tapi dalam beberapa tahun terakhir, \n" +
                            "daging babi, daging sapi, dan makanan laut juga digunakan dalam membuat sup ini \n" +
                            "sehingga menciptakan beragam selera. Seperti rasa garam, kecap, miso yang khas, " +
                            "dan juga ramen rasa kari ";
                    Harga = "Rp. 30.000 - 50.000";
                    popupdialog(Name,Desc,Harga);
                }

                else if (position == 2){
                    Name = "Soba";
                    Desc = "Soba artinya tepung dalam bahasa Jepang, tapi Soba di sini artinya adalah mie. \n\n" +
                            "Mie Jepang yang biasanya dinikmati dengan kecap asin atau kecap manis \n" +
                            "dengan topping telur, atau tempura, atau side dish lainnya. ";
                    Harga = "Rp. 20.000 - 35.000";
                    popupdialog(Name,Desc,Harga);
                }

                else if (position == 3){
                    Name = "Sushi";
                    Desc = "Sushi adalah masakan menggabungkan cuka beras dan makanan laut. \n" +
                            "Ada juga jenis sushi fermentasi yang dikenal sebagai nare-sushi. \n\n" +
                            "Tetapi jenis yang paling khas dari sushi adalah  Nigirizushi yang memiliki bentuk sederhana dan Temakizushi yang biasanya digulung menggunakan nori atau rumput laut.\n\n" +
                            "Ada banyak bahan lain yang tersedia bagi Anda yang tidak suka ikan mentah, \n" +
                            "termasuk udang rebus dan belut panggang. \n\n" +
                            "Anda dapat menemukan sushi di seluruh Jepang, " +
                            "tetapi sushi dari restoran di daerah kelas tinggi seperti Ginza atau dekat dengan\n" +
                            "pelabuhan perikanan sangat lezat karena ikannya dijamin segar.";
                    Harga = "Rp. 10.000 - 30.000";
                    popupdialog(Name,Desc,Harga);
                }

                else if (position == 4){
                    Name = "Tempura";
                    Desc = "Tempura bisa berupa hidangan seafood, sayuran segar, atau bahan-bahan lainnya yang dicelupkan ke dalam tepung dan telur adonan, " +
                    "kemudian dibaluri dengan tepung roti lalu digoreng sampai cokelat keemasan.";
                    Harga = "Rp. 20.000 - 35.000";
                    popupdialog(Name,Desc,Harga);
                }

                else if (position == 5){
                    Name = "Yakitori";
                    Desc = "Bagaikan sate dalam daftar menu Indonesia, \n\n" +
                            "Yakitori adalah hidangan sate ayam yang dibumbui dengan garam manis atau kecap, lalu " +
                            "ditusukkan ke tusukan seperti sate. \n" +
                            "Anda biasanya dapat menemukan yakitori di bar / restoran atau biasa disebut " +
                            "Izakaya di Jepang.";
                    Harga = "Rp. 10.000 - 20.000";
                    popupdialog(Name,Desc,Harga);
                }

                else if (position == 6){
                    Name = "Matcha";
                    Desc = "Matcha menjadi minuman khas Jepang yang sudah terkenal di berbagai negara.\n\n" +
                            "Minuman ini terbuat dari bubuk teh hijau yang cukup dituang air dan diaduk hingga berbusa. " +
                            "Matcha kerap disajikan dalam bentuk minuman. \n\n" +
                            "Namun  Matcha dapat dikonsumsi sebagai topping kue, cookies, permen, latte, dan lain sebagainya.";
                    Harga = "Rp. 10.000 - 25.000";
                    popupdialog(Name,Desc,Harga);
                }

                else if (position == 7){
                    Name = "Teh Sakura";
                    Desc = "Teh sakura ini menjadi minuman khas Jepang yang cukup populer.\n\n" +
                            "Pasalnya, minuman ini terbuat dari bunga musim semi di Jepang, Bunga Sakura. " +
                            "Bunga sakura yang diseduh dan dijadikan teh akan terasa nikmat. " +
                            "Teh ini cocok diminum sambil menikmati musim semi di Jepang.";
                    Harga = "Rp. 10.000 - 25.000";
                    popupdialog(Name,Desc,Harga);
                }

                else if (position == 8){
                    Name = "Sake";
                    Desc = "Sake merupakan minuman khas Jepang yang terkenal di dunia.\n\n" +
                            "Minuman beralkohol ini dibuat dari fermentasi beras. " +
                            "Rasa Sake Jepang bergantung pada aspek jenis beras, waktu fermentasi, dan lain sebagainya. " +
                            "Rasanya bercampur antara rasa alkohol penuh umami dengan rasa manis seperti wine. " +
                            "Sake di setiap wilayah di Jepang memiliki rasa yang unik khas lokal.";
                    Harga = "Rp. 80.000 - 900.000";
                    popupdialog(Name,Desc,Harga);
                }

                else if (position == 9){
                    Name = "Uroncha / Teh Oolong";
                    Desc =  "Nama lain teh Uroncha adalah teh olong.\n\n" +
                            "Perbedaan Uroncha daripada teh lainnya adalah dalam proses pembuatannya. " +
                            "Teh hitam, teh hijau dan Uroncha memang berasal dari daun teh yang sama. Namun, proses oksidasi Uroncha memberikan aroma yang kuat. " +
                            "Minuman ini biasanya diminum saat makan siang untuk menenangkan perut.";
                    Harga = "Rp. 10.000 - 50.000";
                    popupdialog(Name,Desc,Harga);
                }

                else if (position == 10){
                    Name = "Shochu";
                    Desc =  "Shochu rasanya seperti vodka dan terbuat dari beras, ubi jalar, tebu, dan barley. " +
                            "Rasa Sochu tergantung dari cara penyeduhannya. Varian dari ubi jalar merupakan sochu yang paling terkenal di Jepang.";
                    Harga = "Rp. 50.000 - 600.000";
                    popupdialog(Name,Desc,Harga);
                }

                else if (position == 11){
                    Name =  "Ramune (ラムネ)";
                    Desc =  "Ramune adalah minuman berkarbonasi non alkohol yang namanya berasal dari bahasa Inggris lemonade.\n\n" +
                            "Dalam bahasa Jepang, lemonade diucapkan remonedo (レモネード), " +
                            "yang mungkin salah didengar saat pertama kali diperkenalkan di Jepang atau mengalami perubahan bahasa seiring waktu sehingga menjadi ramune. " +
                            "Minuman Ramune sangatlah terkenal di Jepang bahkan di Indonesia sekalipun karena rasanya yang sangat segar.";
                    Harga = "Rp. 20.000 - 100.000";
                    popupdialog(Name,Desc,Harga);
                }
            }
        });

        backButton.setOnClickListener(view->{
            this.finish();
        });
    }




    public void popupdialog(String a,String b, String c){
        dialogBuilder = new AlertDialog.Builder(this);
        final View popupview = getLayoutInflater().inflate(R.layout.foodpopup,null);
        deskripsi = (TextView) popupview.findViewById(R.id.deskripsi);
        namaMakanan = (TextView) popupview.findViewById(R.id.namaMakanan);
        hargaText = (TextView) popupview.findViewById(R.id.hargaText);
        kembaliButton = (Button) popupview.findViewById(R.id.kembaliButton);

        namaMakanan.setText(a);
        deskripsi.setText(b);
        hargaText.setText(c);

        dialogBuilder.setView(popupview);
        dialog = dialogBuilder.create();
        dialog.show();

        kembaliButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

}