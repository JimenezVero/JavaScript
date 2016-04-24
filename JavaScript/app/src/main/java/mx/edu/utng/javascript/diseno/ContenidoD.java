package mx.edu.utng.javascript.diseno;

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
public class
        ContenidoD  extends Activity{

    //Crando variables
    private ListView lsvInstancia;
    private ListView lsvIterador;
    private ListView lsvEstraegia;
    private Button btnImagen;

//Instanciando
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenidod_layout);
        initComponents();
    }

    //iniciando componentes
    private void initComponents(){

        btnImagen = (Button)findViewById(R.id.Btn_botonMasImagen);


        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("Instancia");
        spec.setContent(R.id.tabInstancia);
        spec.setIndicator("Insancia");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Iterador");
        spec.setContent(R.id.tabIterador);
        spec.setIndicator("Iterador");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Estrategia");
        spec.setContent(R.id.tabEstrategia);
        spec.setIndicator("Estatregia");
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
        lsvInstancia = (ListView)findViewById(R.id.lsv_instancia);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.instancia,
                android.R.layout.simple_list_item_1);
        lsvInstancia.setAdapter(adapter);

        lsvIterador = (ListView)findViewById(R.id.lsv_iterador);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(
                this,
                R.array.iterador, android.R.layout.simple_list_item_1);
        lsvIterador.setAdapter(adapter3);

        lsvEstraegia = (ListView)findViewById(R.id.lsv_estrategia);
        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(
                this,
                R.array.estrategia, android.R.layout.simple_list_item_1);
        lsvEstraegia.setAdapter(adapter4);


    }
    public void presionBotonImagen(View v) {
        startActivity(new Intent(ContenidoD.this, EvaluarD.class));
        finish();
    }

    public void presionBotonImagen1(View v) {
        startActivity(new Intent(ContenidoD.this, ListaActivity.class));
        finish();
    }


    public void presionaBotonAudio(View v) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.s3);
        mp.start();
    }
    public void presionaBotonvideo(View v) {
        startActivity(new Intent(ContenidoD.this, VideoD.class));
        finish();
    }
}
