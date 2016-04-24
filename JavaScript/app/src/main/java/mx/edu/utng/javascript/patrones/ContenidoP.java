package mx.edu.utng.javascript.patrones;

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
public class ContenidoP extends Activity{
    //crear variables
    private ListView lsvImplemenacion;
    private ListView lsvCadena;
    private ListView lsvKlass;
    private Button btnImagen;

    //instanciando
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenidop_layout);
        initComponents();
    }
    //iniciando componentes
    private void initComponents(){

        btnImagen = (Button)findViewById(R.id.Btn_botonMasImagen);


        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("Implementacion");
        spec.setContent(R.id.tabImplemenacion);
        spec.setIndicator("Implementacion");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Cadena");
        spec.setContent(R.id.tabCadena);
        spec.setIndicator("Cadena");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Klass");
        spec.setContent(R.id.tabKlass);
        spec.setIndicator("Klass");
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
        lsvImplemenacion = (ListView)findViewById(R.id.lsv_implementacion);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.implementacion,
                android.R.layout.simple_list_item_1);
        lsvImplemenacion.setAdapter(adapter);

        lsvCadena = (ListView)findViewById(R.id.lsv_cadena);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(
                this,
                R.array.cadena, android.R.layout.simple_list_item_1);
        lsvCadena.setAdapter(adapter3);

        lsvKlass = (ListView)findViewById(R.id.lsv_klass);
        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(
                this,
                R.array.klass, android.R.layout.simple_list_item_1);
        lsvKlass.setAdapter(adapter4);
    }
    //al presionar ña imagen creara in intento
    public void presionBotonImagen(View v) {
        startActivity(new Intent(ContenidoP.this, EvaluarP.class));
        finish();
    }
    public void presionBotonImagen1(View v) {
        startActivity(new Intent(ContenidoP.this, ListaActivity.class));
        finish();
    }


    public void presionaBotonAudio(View v) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.s3);
        mp.start();
    }
    public void presionaBotonvideo(View v) {
        startActivity(new Intent(ContenidoP.this, VideoP.class));
        finish();
    }
}
