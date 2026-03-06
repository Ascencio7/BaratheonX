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

public class BaratheonCafes extends AppCompatActivity {

    ListView cafesLista;
    Button btnAtras;

    ArrayList<BaratheonMenuCafes> lista;

    int[] imgCafes = {
            R.drawable.cafeamericano,
            R.drawable.cafelatte,
            R.drawable.cafemoca,
            R.drawable.cafehelado
    };

    String[] cafes = {
            "Cafe Americano",
            "Cafe Latter",
            "Cafe Moca",
            "Cafe Helado"
    };

    String[] precios = {
            "$1.80",
            "$2.00",
            "$1.50",
            "$2.50"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baratheonx_cafes);

        cafesLista = findViewById(R.id.listCafe);
        btnAtras = findViewById(R.id.btnAtras);

        lista = new ArrayList<>();

        for(int i = 0; i < cafes.length; i++){
            lista.add(new BaratheonMenuCafes(imgCafes[i], cafes[i], precios[i]));
        }

        MenuAdapter adapter = new MenuAdapter(this, lista);
        cafesLista.setAdapter(adapter);

        cafesLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(BaratheonCafes.this,
                        "Seleccionaste: " + cafes[i] + " " + precios[i],
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnAtras.setOnClickListener(view -> finish());
    }

    class MenuAdapter extends BaseAdapter {

        Context ct;
        ArrayList<BaratheonMenuCafes> lista;
        LayoutInflater inf;

        public MenuAdapter(Context ct, ArrayList<BaratheonMenuCafes> lista) {
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

            BaratheonMenuCafes item = lista.get(i);

            img.setImageResource(item.getImagen());
            titulo.setText(item.getTitulo());
            desc.setText(item.getDescripcion());

            return v;
        }
    }
}