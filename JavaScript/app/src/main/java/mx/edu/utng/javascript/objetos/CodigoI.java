package mx.edu.utng.javascript.objetos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;

import mx.edu.utng.javascript.R;
import mx.edu.utng.javascript.introduccion.EvaluarI;

/**
 * Created by Iruzz on 06/04/2016.
 */
public class CodigoI extends Activity {

    //crear variables
    private ListView lsvCodigo1;
    private ListView lsvCodigo2;
    private Button btnImagen;
   ;
    //Instanciar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.codigoi_layout);
        initComponents();
    }
    //Iniciar componentes
    private void initComponents(){


        btnImagen = (Button)findViewById(R.id.Btn_botonMasImagen);

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("Codigo");
        spec.setContent(R.id.tabCodigo1);
        spec.setIndicator("Codigo");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Codigo");
        spec.setContent(R.id.tabCodigo2);
        spec.setIndicator("Codigo");
        tabHost.addTab(spec);



        tabHost.setCurrentTab(0);
        lsvCodigo1 = (ListView)findViewById(R.id.lsv_codigo1);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.codigo,
                android.R.layout.simple_list_item_1);
        lsvCodigo1.setAdapter(adapter);

        lsvCodigo2 = (ListView)findViewById(R.id.lsv_cogigo2);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(
                this,
                R.array.codigo2, android.R.layout.simple_list_item_1);
        lsvCodigo2.setAdapter(adapter3);




    }
    public void presionBotonImagen(View v) {
        startActivity(new Intent(CodigoI.this, EvaluarO3.class));
        finish();
    }

}
