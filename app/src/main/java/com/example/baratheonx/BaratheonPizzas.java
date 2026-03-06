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

public class BaratheonPizzas extends AppCompatActivity {

    ListView pizzaLista;
    Button btnAtras;

    ArrayList<BaratheonMenuPizza> lista;

    int[] imgPizzas = {
            R.drawable.pizzasuprema,
            R.drawable.pizzapepperoni,
            R.drawable.pizzaorillaqueso,
            R.drawable.pizzacuatroestaciones,
            R.drawable.pizzajamon
    };

    String[] pizzas = {
            "Pizza Baratheon Suprema",
            "Pizza Pepperoni",
            "Pizza con Orilla de Queso",
            "Pizza Cuatro Estaciones",
            "Pizza Jamón"
    };

    String[] precios = {
            "$17.80",
            "$5.00",
            "$8.90",
            "$10.50",
            "$4.50"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baratheonx_pizzas);

        pizzaLista = findViewById(R.id.listPizzas);
        btnAtras = findViewById(R.id.btnAtras);

        lista = new ArrayList<>();

        for(int i = 0; i < pizzas.length; i++){
            lista.add(new BaratheonMenuPizza(imgPizzas[i], pizzas[i], precios[i]));
        }

        MenuAdapter adapter = new MenuAdapter(this, lista);
        pizzaLista.setAdapter(adapter);

        pizzaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(BaratheonPizzas.this,
                        "Seleccionaste: " + pizzas[i] + " " + precios[i],
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnAtras.setOnClickListener(view -> finish());
    }

    class MenuAdapter extends BaseAdapter {

        Context ct;
        ArrayList<BaratheonMenuPizza> lista;
        LayoutInflater inf;

        public MenuAdapter(Context ct, ArrayList<BaratheonMenuPizza> lista) {
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

            BaratheonMenuPizza item = lista.get(i);

            img.setImageResource(item.getImagen());
            titulo.setText(item.getTitulo());
            desc.setText(item.getDescripcion());

            return v;
        }
    }
}