package mx.edu.utng.javascript;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by TOSHIBA on 10/02/2016.
 */
public class InicioActivity extends Activity implements View.OnClickListener{

    //Ceando componentes

    private Button btnIniciar;

    //Instanciando
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_layout);
        initComponet();
    }

    //Iniciando componenes
    private void initComponet(){

        btnIniciar = (Button)findViewById(R.id.btn1);
        btnIniciar.setOnClickListener(this);
    }
//Creando un intento
    @Override
    public void onClick(View v) {
        startActivity(new Intent(InicioActivity.this, ListaActivity.class));
        finish();
    }


}




