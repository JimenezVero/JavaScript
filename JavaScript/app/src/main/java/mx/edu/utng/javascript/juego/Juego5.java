package mx.edu.utng.javascript.juego;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import mx.edu.utng.javascript.ListaActivity;
import mx.edu.utng.javascript.R;

/**
 * Created by Iruzz on 19/04/2016.
 */
public class Juego5 extends Activity {
    private TextView txtFelicidad;
    private Button btnCont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego5_layout);
        initcomponents();
    }

    private void initcomponents() {
        txtFelicidad = (TextView)findViewById(R.id.txt_felicidad);
        btnCont = (Button)findViewById(R.id.btn_cont);

    }

    public void presionBotonSiguiente(View v) {

        startActivity(new Intent(Juego5.this, ListaActivity.class));
            finish();


    }
}
