package com.example.joseandres.practica_integradora;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSimple = (Button)findViewById(R.id.btn_normal);
        final TextView txt1 = (TextView)findViewById(R.id.txt1);
        final ToggleButton btnToogle = (ToggleButton)findViewById(R.id.TooggleButton);


        btnSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText("Boton siemple pulsado!");
            }

            });
        btnToogle.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View v){
                if(btnToogle.isChecked())
                    txt1.setText("Boton Toglle: ON");
                else
                    txt1.setText("Boton Toogle: OFF");
            }
        });
    }



        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
