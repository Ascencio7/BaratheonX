package com.example.baratheonx;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BaratheonMenu extends AppCompatActivity {
    Button btnPizza, btnCafe, btnPostres, btnAtras;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baratheonx_menu);

        btnPizza = findViewById(R.id.btnPizza);
        btnCafe = findViewById(R.id.btnCafe);
        btnPostres = findViewById(R.id.btnPostres);
        btnAtras = findViewById(R.id.btnAtras);

        btnPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BaratheonMenu.this, "Menú de Pizzas", Toast.LENGTH_SHORT).show();

                Intent intent3 = new Intent(BaratheonMenu.this, BaratheonPizzas.class);
                startActivity(intent3);
            }
        });

        btnCafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BaratheonMenu.this, "Menú de Cafés", Toast.LENGTH_SHORT).show();

                Intent intent4 = new Intent(BaratheonMenu.this, BaratheonCafes.class);
                startActivity(intent4);
            }
        });

        btnPostres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BaratheonMenu.this, "Menú de Postres", Toast.LENGTH_SHORT).show();

                Intent intent5 = new Intent(BaratheonMenu.this, BaratheonPostres.class);
                startActivity(intent5);
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}