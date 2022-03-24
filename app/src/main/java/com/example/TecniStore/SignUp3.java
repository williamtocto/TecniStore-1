package com.example.TecniStore;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SignUp3 extends AppCompatActivity {

    private ImageView backView;
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3);

        backView= findViewById(R.id.btnBackView);
        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pantallaInicial= new Intent(SignUp3.this, SignUp2.class);
                startActivity(pantallaInicial);
                finish();
            }
        });

        btnSiguiente= findViewById(R.id.btn_siguiente_datos_pago);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SingUp4= new Intent(SignUp3.this, SignUp4.class);
                startActivity(SingUp4);
                finish();
            }
        });
    }
}