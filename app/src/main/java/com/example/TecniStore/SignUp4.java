package com.example.TecniStore;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SignUp4 extends AppCompatActivity {

    private ImageView backView;
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up4);

        backView= findViewById(R.id.btnBackView);
        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pantallaInicial= new Intent(SignUp4.this, SignUp3.class);
                startActivity(pantallaInicial);
                finish();
            }
        });


        btnSiguiente= findViewById(R.id.btn_siguiente_datos_usuario);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home= new Intent(SignUp4.this, MainActivity.class);
                startActivity(home);
                finish();
            }
        });
    }
}