package com.example.TecniStore;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class DetalleProducto extends AppCompatActivity {

    ImageView img, btn_mas, btn_menos;
    TextView proName, proPrice, proDesc, proQty, cantidad;

    String name, price, desc, qty;
    String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);

        btn_mas=findViewById(R.id.btn_plus);
        btn_menos=findViewById(R.id.btn_less);
        cantidad=findViewById(R.id.txt_cantidad_compra);


        Intent i = getIntent();


        name = i.getStringExtra("name");
        image = i.getStringExtra("image");
        price = i.getStringExtra("price");
        desc = i.getStringExtra("desc");
        qty = i.getStringExtra("qty");

        proName = findViewById(R.id.productName);
        proDesc = findViewById(R.id.prodDesc);
        proPrice = findViewById(R.id.prodPrice);
        img = findViewById(R.id.big_image);
        //back = findViewById(R.id.back2);
        proQty = findViewById(R.id.qty);

        proName.setText(name);
        proPrice.setText(price);
        proDesc.setText(desc);
        proQty.setText(qty);

        Picasso.get()
                .load(image)
                .error(R.mipmap.ic_launcher)
                .into(img);

        btn_mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!cantidad.getText().equals(qty)) {
                    sumCantidad();
                }
            }
        });

        btn_menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!cantidad.getText().equals("1")){
                    resCantidad();
                }
            }
        });

    }

    private void sumCantidad(){
        int num= Integer.parseInt(cantidad.getText().toString());
        int suma= num+1;
        cantidad.setText(String.valueOf(suma));
    }

    private void resCantidad(){
        int num= Integer.parseInt(cantidad.getText().toString());
        int resta= num-1;
        cantidad.setText(String.valueOf(resta));
    }

}