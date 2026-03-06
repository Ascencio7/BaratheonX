package com.example.baratheonx;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BaratheonRegistro extends AppCompatActivity {

    TextView txtRestaurante, txtRubro;
    EditText etxtCliente;
    Button btnContinuar;

    String nombreUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baratheonx_registro);

        txtRestaurante = findViewById(R.id.txtRestaurante);
        txtRubro = findViewById(R.id.txtRubro);
        etxtCliente = findViewById(R.id.etxtCliente);
        btnContinuar = findViewById(R.id.btnContinuar);

        nombreUsuario = getIntent().getStringExtra("usuario");

        btnContinuar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String res = "BaratheonX";
                String rb = "Pizzería y Cafetería";
                String cl = etxtCliente.getText().toString();

                if(cl.isEmpty()){
                    Toast.makeText(BaratheonRegistro.this, "Ingresa el nombre del cliente", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent2 = new Intent(BaratheonRegistro.this, BaratheonResumen.class);
                    intent2.putExtra("restaurante", res);
                    intent2.putExtra("rubro", rb);
                    intent2.putExtra("cliente", cl);
                    intent2.putExtra("usuario", nombreUsuario);
                    startActivity(intent2);
                }
            }
        });
    }
}