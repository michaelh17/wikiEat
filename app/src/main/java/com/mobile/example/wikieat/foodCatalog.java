package com.mobile.example.wikieat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class foodCatalog extends AppCompatActivity {
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private TextView namaMakanan;
    private TextView deskripsi;
    private Button kembaliButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_catalog);

        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new foodImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String Name;
                String Desc;

                if (position == 0){
                Name = "Onigiri";
                Desc = "Onigiri adalah nasi kepal versi Jepang yang biasanya berbentuk bola atau segitiga.\n" +
                        "Di Dalam Onigiri biasanya diisi salmon, ayam, umeboshi, dan tuna (dried plum) lalu\n" +
                        "kemudian dibungkus dengan nori. Jika Anda baru pertama kali mencobai onigiri , \n" +
                        "pilihlah tuna dengan mayonese, atau ayam mayonese karena rasanya sangat familiar dengan lidah Indonesia. \n" +
                        "Onigiri sangat mudah ditemukan di Jepang, hampir semua convenience store menjualnya. ";

                    popupdialog(Name,Desc);
                }
                Toast.makeText(foodCatalog.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }



    public void popupdialog(String a,String b){
        dialogBuilder = new AlertDialog.Builder(this);
        final View popupview = getLayoutInflater().inflate(R.layout.foodpopup,null);
        deskripsi = (TextView) popupview.findViewById(R.id.deskripsi);
        namaMakanan = (TextView) popupview.findViewById(R.id.namaMakanan);
        kembaliButton = (Button) popupview.findViewById(R.id.kembaliButton);

        namaMakanan.setText(a);
        deskripsi.setText(b);

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