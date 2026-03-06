package com.example.baratheonx;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class BaratheonPostres extends AppCompatActivity {

    ListView postreLista;
    Button btnAtras;

    ArrayList<BaratheonMenuPostres> lista;

    int[] imgPostres = {
            R.drawable.tresleches,
            R.drawable.tiramisu,
            R.drawable.postrefruta,
            R.drawable.cheesecake,
            R.drawable.brownie
    };

    String[] postres = {
            "Tres Leches",
            "Postre Tiramisu",
            "Postre de Frutas",
            "Postre Cheesecake",
            "Postre Brownie"
    };

    String[] precios = {
            "$1.80",
            "$2.15",
            "$2.50",
            "$3.50",
            "$3.90"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baratheonx_postres);

        postreLista = findViewById(R.id.listPostres);
        btnAtras = findViewById(R.id.btnAtras);

        lista = new ArrayList<>();

        for(int i = 0; i < postres.length; i++){
            lista.add(new BaratheonMenuPostres(imgPostres[i], postres[i], precios[i]));
        }

        MenuAdapter adapter = new MenuAdapter(this, lista);
        postreLista.setAdapter(adapter);

        postreLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(BaratheonPostres.this,
                        "Seleccionaste: " + postres[i] + " " + precios[i],
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnAtras.setOnClickListener(view -> finish());
    }

    class MenuAdapter extends BaseAdapter {

        Context ct;
        ArrayList<BaratheonMenuPostres> lista;
        LayoutInflater inf;

        public MenuAdapter(Context ct, ArrayList<BaratheonMenuPostres> lista) {
            this.ct = ct;
            this.lista = lista;
            inf = LayoutInflater.from(ct);
        }

        @Override
        public int getCount() {
            return lista.size();
        }

        @Override
        public Object getItem(int i) {
            return lista.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View v, ViewGroup parent) {

            v = inf.inflate(R.layout.baratheonx_menu_items, null);

            ImageView img = v.findViewById(R.id.imgElemento);
            TextView titulo = v.findViewById(R.id.txtTitulo);
            TextView desc = v.findViewById(R.id.txtDescripcion);

            BaratheonMenuPostres item = lista.get(i);

            img.setImageResource(item.getImagen());
            titulo.setText(item.getTitulo());
            desc.setText(item.getDescripcion());

            return v;
        }
    }
}