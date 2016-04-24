package mx.edu.utng.javascript.navegador;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;

import mx.edu.utng.javascript.ListaActivity;
import mx.edu.utng.javascript.R;

/**
 * Created by Iruzz on 03/04/2016.
 */
public class ContenidoN extends Activity{
    //crear variables
    private ListView lsvNavegacion;
    private ListView lsvMinimizacion;
    private ListView lsvDescarga;
    private Button btnImagen;


    //instanciando
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conenidon_layout);
        initComponents();
    }
    //iniciando componentes
    private void initComponents(){

        btnImagen = (Button)findViewById(R.id.Btn_botonMasImagen);


        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("Navegacion");
        spec.setContent(R.id.tabNavegacion);
        spec.setIndicator("Navegacion");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Minimizacion");
        spec.setContent(R.id.tabMinimizacion);
        spec.setIndicator("Minimizacion");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Descarga");
        spec.setContent(R.id.tabDescarga);
        spec.setIndicator("Descarga");
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
        lsvNavegacion = (ListView)findViewById(R.id.lsv_navegacion);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.navegacion,
                android.R.layout.simple_list_item_1);
        lsvNavegacion.setAdapter(adapter);

        lsvMinimizacion = (ListView)findViewById(R.id.lsv_minimizacion);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(
                this,
                R.array.minimizacion, android.R.layout.simple_list_item_1);
        lsvMinimizacion.setAdapter(adapter3);

        lsvDescarga = (ListView)findViewById(R.id.lsv_descarga);
        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(
                this,
                R.array.descarga, android.R.layout.simple_list_item_1);
        lsvDescarga.setAdapter(adapter4);
    }
    //al presionar ña imagen creara in intento
    public void presionBotonImagen(View v) {
        startActivity(new Intent(ContenidoN.this, EvaluarN.class));
        finish();
    }
    public void presionBotonImagen1(View v) {
        startActivity(new Intent(ContenidoN.this, ListaActivity.class));
        finish();
    }


    public void presionaBotonAudio(View v) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.s3);
        mp.start();
    }
    public void presionaBotonvideo(View v) {
        startActivity(new Intent(ContenidoN.this, VideoN.class));
        finish();
    }
}
