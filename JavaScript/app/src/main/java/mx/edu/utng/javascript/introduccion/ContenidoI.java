package mx.edu.utng.javascript.introduccion;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import mx.edu.utng.javascript.ListaActivity;
import mx.edu.utng.javascript.R;

/**
 * Created by Iruzz on 03/04/2016.
 */
public class ContenidoI extends Activity {
    //crear variables
    private ListView lsvPatrones;
    private ListView lsvPrototipos;
    private ListView lsvEmc;
    private Button btnImagen;
    private TextView txtIntroduccion;

    //instanciando
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenidoi_layout);
        initComponents();
    }
    //iniciando componentes
    private void initComponents(){

        btnImagen = (Button)findViewById(R.id.Btn_botonMasImagen);


        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("Patrones");
        spec.setContent(R.id.tabPatrones);
        spec.setIndicator("Patrones");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Prototipos");
        spec.setContent(R.id.tabPrototipos);
        spec.setIndicator("Prototipos");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Emc");
        spec.setContent(R.id.tabEcm);
        spec.setIndicator("ECMAScript 5");
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
        lsvPatrones = (ListView)findViewById(R.id.lsv_patrones);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.patrones,
                android.R.layout.simple_list_item_1);
        lsvPatrones.setAdapter(adapter);

        lsvPrototipos = (ListView)findViewById(R.id.lsv_prototipos);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(
                this,
                R.array.prototipos, android.R.layout.simple_list_item_1);
        lsvPrototipos.setAdapter(adapter3);

        lsvEmc = (ListView)findViewById(R.id.lsv_ecm);
        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(
                this,
                R.array.ecm, android.R.layout.simple_list_item_1);
        lsvEmc.setAdapter(adapter4);


    }
    //al presionar ña imagen creara in intento
    public void presionBotonImagen(View v) {
        startActivity(new Intent(ContenidoI.this, EvaluarI.class));
        finish();
    }
    public void presionaBotonAudio(View v) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.s3);
        mp.start();
    }
    public void presionaBotonvideo(View v) {
        startActivity(new Intent(ContenidoI.this, VideoI.class));
        finish();
    }
    public void presionBotonImagen1(View v) {
        startActivity(new Intent(ContenidoI.this, ListaActivity.class));
        finish();
    }


}
