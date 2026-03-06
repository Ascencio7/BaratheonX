package com.example.baratheonx;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BaratheonLogin extends  AppCompatActivity{
    EditText etxtUsuario, etxtPass;
    Button btnIniciar;

    String userC = "vladimirascencio";
    String passC = "Vladi123@Ascencio";

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxtUsuario = findViewById(R.id.etxtUsuario);
        etxtPass = findViewById(R.id.etxtPass);
        btnIniciar = findViewById(R.id.btnIniciar);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usua = etxtUsuario.getText().toString();
                String contra = etxtPass.getText().toString();

                // Validar que los campos no esten vacios
                if (usua.isEmpty() || contra.isEmpty()){
                    Toast.makeText(BaratheonLogin.this, "Completa los campos", Toast.LENGTH_SHORT).show();
                }else if(usua.equals(userC) && contra.equals(passC)){
                    Toast.makeText(BaratheonLogin.this, "Bienvenido a BaratheonX", Toast.LENGTH_SHORT).show();

                    Intent intent1 = new Intent(BaratheonLogin.this, BaratheonRegistro.class);

                    intent1.putExtra("usuario", usua);
                    startActivity(intent1);
                }
                else{
                    Toast.makeText(BaratheonLogin.this, "El usuario o contraseña son incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}