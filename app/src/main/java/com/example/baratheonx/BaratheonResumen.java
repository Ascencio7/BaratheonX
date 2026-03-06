package com.example.baratheonx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BaratheonResumen extends AppCompatActivity {
    TextView txtRestaurante, txtRubro, txtCliente, txtUsuario;
    Button btnMenu, btnRegresar, btnSalir;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baratheonx_resumen_datos);

        txtRestaurante = findViewById(R.id.txtRestaurante);
        txtRubro = findViewById(R.id.txtRubro);
        txtCliente = findViewById(R.id.txtCliente);
        txtUsuario = findViewById(R.id.txtUsuario);
        btnMenu = findViewById(R.id.btnMenu);
        btnRegresar = findViewById(R.id.btnRegresar);
        btnSalir = findViewById(R.id.btnSalir);

        String res = getIntent().getStringExtra("restaurante");
        String rb = getIntent().getStringExtra("rubro");
        String cl = getIntent().getStringExtra("cliente");
        String us = getIntent().getStringExtra("usuario");

        txtRestaurante.setText("Restaurante:  " + res);
        txtRubro.setText("Rubro: " + rb);
        txtCliente.setText("Cliente: " + cl);
        txtUsuario.setText("Usuario: " + us);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(BaratheonResumen.this, BaratheonMenu.class);
                startActivity(intent2);
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}