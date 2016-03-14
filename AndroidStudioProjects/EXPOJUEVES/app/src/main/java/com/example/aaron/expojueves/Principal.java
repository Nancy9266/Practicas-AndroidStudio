package com.example.aaron.expojueves;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    private TextView lblEtiqueta;
    private ListView lstOpciones;

    private Titular[] datos =
            new Titular[]{
                    new Titular("Título 1", "Subtítulo largo 1"),
                    new Titular("Título 2", "Subtítulo largo 2"),
                    new Titular("Título 3", "Subtítulo largo 3"),
                    new Titular("Título 4", "Subtítulo largo 4"),
                    new Titular("Título 5", "Subtítulo largo 5"),
                    new Titular("Título 6", "Subtítulo largo 6"),
                    new Titular("Título 7", "Subtítulo largo 7"),
                    new Titular("Título 8", "Subtítulo largo 8"),
                    new Titular("Título 9", "Subtítulo largo 9"),
                    new Titular("Título 10", "Subtítulo largo 10"),
                    new Titular("Título 11", "Subtítulo largo 11"),
                    new Titular("Título 12", "Subtítulo largo 12"),
                    new Titular("Título 13", "Subtítulo largo 13"),
                    new Titular("Título 14", "Subtítulo largo 14"),
                    new Titular("Título 15", "Subtítulo largo 15")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        lblEtiqueta = (TextView)findViewById(R.id.LblEtiqueta);
        lstOpciones = (ListView)findViewById(R.id.LstOpciones);

        //Cabecera
        //View header = getLayoutInflater().inflate(R.layout.list_header, null);
        //lstOpciones.addHeaderView(header);

        //Adaptador
        AdaptadorTitulares adaptador =
                new AdaptadorTitulares(this, datos);

        lstOpciones.setAdapter(adaptador);

        //Eventos
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> a, View v, int position, long id){
                String opcionSelccionada =
                        ((Titular)a.getItemAtPosition(position)).getTitulo();

                lblEtiqueta.setText("Opcion Seleccionada: " + opcionSelccionada);
            }
        });
        /*
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //Alternativa 1:
                String opcionSeleccionada =
                        ((Titular)a.getItemAtPosition(position)).getTitulo();

                //Alternativa 2:
                //String opcionSeleccionada =
                //		((TextView)v.findViewById(R.id.LblTitulo))
                //			.getText().toString();

                lblEtiqueta.setText("Opción seleccionada: " + opcionSeleccionada);
            }
        });*/
    }

    public class Titular{
        private String titulo;
        private String subtitulo;

        public Titular(String tit, String sub){
            titulo = tit;
            subtitulo = sub;
        }

        public String getTitulo(){
            return titulo;
        }

        public String getSubtitulo(){
            return subtitulo;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class AdaptadorTitulares extends ArrayAdapter<Principal.Titular> {

    AdaptadorTitulares(Context context, Principal.Titular[] datos) {
        super(context, R.layout.second_activity, datos);
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        View item = convertView;
        ViewHolder holder;

        if(item == null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.second_activity, null);

            holder = new ViewHolder();
            holder.titulo = (TextView)item.findViewById(R.id.LblTitulo);
            holder.subtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);

        item.setTag(holder);
    }
        else
        {
            holder = (ViewHolder)item.getTag();
        }

        holder.titulo.setText(datos[position].getTitulo());
        holder.subtitulo.setText(datos[position].getSubtitulo());



        return(item);
        }
        }

    static class ViewHolder{
        TextView titulo;
        TextView subtitulo;
    }

}

