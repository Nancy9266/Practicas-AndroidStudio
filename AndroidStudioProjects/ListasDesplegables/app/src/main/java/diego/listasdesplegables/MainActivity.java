package diego.listasdesplegables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.valores_array,android.R.layout.simple_spinner_item);

        Spinner CmbOptions = (Spinner) findViewById(R.id.CmbOptions);
        final TextView lblMensaje = (TextView) findViewById(R.id.lblMensaje);

                CmbOptions.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        CmbOptions.setAdapter(adapter);

        CmbOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lblMensaje.setText("Seleccionado " + parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                lblMensaje.setText("");

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
