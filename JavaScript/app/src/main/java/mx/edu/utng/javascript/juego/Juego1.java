package mx.edu.utng.javascript.juego;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.javascript.R;

/**
 * Created by Iruzz on 19/04/2016.
 */
public class Juego1 extends Activity {
    private TextView txtJuego;
    private TextView txtAdivina;
    private EditText edtAdiv;
    private Button btnAdivinar;
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego1_layout);
        initcomponents();
    }

    private void initcomponents() {
        txtJuego = (TextView) findViewById(R.id.txt_juego);
        txtAdivina = (TextView) findViewById(R.id.txt_adivina);
        edtAdiv = (EditText) findViewById(R.id.edt_adiv);
        btnAdivinar = (Button) findViewById(R.id.btn_adiv);
        btnSiguiente = (Button) findViewById(R.id.btn_siguiente);
        Button botonA = (Button) findViewById(R.id.btn_adiv);


        botonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Palabra = ((EditText) findViewById(R.id.edt_adiv)).getText().toString();


                if (Palabra.equals("Manual de Tecnologias")) {

                    MediaPlayer mp = MediaPlayer.create(Juego1.this, R.raw.s1);
                    mp.start();
                    Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show();

                } else {
                    MediaPlayer mp = MediaPlayer.create(Juego1.this, R.raw.s2);
                    mp.start();
                    Toast.makeText(getApplicationContext(), "Incorrecto vuelve a intentarlo", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    public void presionBotonSiguiente(View v) {
        String Palabra = ((EditText) findViewById(R.id.edt_adiv)).getText().toString();

        if (Palabra.equals("Manual de Tecnologias")){
            startActivity(new Intent(Juego1.this, Juego2.class));
            finish();
        }else {
            startActivity(new Intent(Juego1.this, Juego1.class));
            finish();
        }

    }
}
