package mx.edu.utng.javascript.funciones;

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
public class ContenidoF extends Activity{
//crear variables
    private ListView lsvFunciones;
    private ListView lsvEventos;
    private ListView lsvVolviendo;
    private Button btnImagen;

//instanciando
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenidof_layout);
        initComponents();
    }
//iniciando componentes
    private void initComponents(){

        btnImagen = (Button)findViewById(R.id.Btn_botonMasImagen);


        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("Funcion");
        spec.setContent(R.id.tabFuncion);
        spec.setIndicator("Funciones");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Evento");
        spec.setContent(R.id.tabEvento);
        spec.setIndicator("Eventos");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Volviendo");
        spec.setContent(R.id.tabVolviendo);
        spec.setIndicator("Volviendo a Funciones");
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
        lsvFunciones = (ListView)findViewById(R.id.lsv_funcion);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.funciones,
                android.R.layout.simple_list_item_1);
        lsvFunciones.setAdapter(adapter);

        lsvEventos = (ListView)findViewById(R.id.lsv_evento);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(
                this,
                R.array.eventos, android.R.layout.simple_list_item_1);
        lsvEventos.setAdapter(adapter3);

        lsvVolviendo = (ListView)findViewById(R.id.lsv_volviedo);
        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(
                this,
                R.array.volviendo, android.R.layout.simple_list_item_1);
        lsvVolviendo.setAdapter(adapter4);


    }
    //al presionar ña imagen creara in intento
    public void presionBotonImagen(View v) {
        startActivity(new Intent(ContenidoF.this, EvaluarF.class));
        finish();
    }
    public void presionBotonImagen1(View v) {
        startActivity(new Intent(ContenidoF.this, ListaActivity.class));
        finish();
    }

    public void presionaBotonAudio(View v) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.s3);
        mp.start();
    }
    public void presionaBotonvideo(View v) {
        startActivity(new Intent(ContenidoF.this, VideoF.class));
        finish();
    }
}
