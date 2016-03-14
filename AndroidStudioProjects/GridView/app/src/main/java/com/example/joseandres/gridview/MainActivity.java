package com.example.joseandres.gridview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[]datos = new  String[50];
        for (int i=1; i<=50; i++)
            datos [i-1] = "Dato"+ 1;
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        GridView grdOpciones = (GridView)findViewById(R.id.GridOpciones);
        final TextView lblMensaje = (TextView)findViewById(R.id.lblMensaje);

        grdOpciones.setAdapter(adaptador);
        grdOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?>
        parent, View view, int position, long id) {
        lblMensaje.setText("Opcion Seleccionada:" + parent.getItemAtPosition(position));

             }
            }
           );
          }
         }



