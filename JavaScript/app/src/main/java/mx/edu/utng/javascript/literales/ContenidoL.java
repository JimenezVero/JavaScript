package mx.edu.utng.javascript.literales;

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
public class ContenidoL extends Activity{
    //crear variables
    private ListView lsvLiterales;
    private ListView lsvThat;
    private ListView lsvLie;
    private Button btnImagen;


    //instanciando
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenidol_layout);
        initComponents();
    }
    //iniciando componentes
    private void initComponents(){

        btnImagen = (Button)findViewById(R.id.Btn_botonMasImagen);



        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("Literales");
        spec.setContent(R.id.tabLiterales);
        spec.setIndicator("Lierales y Constructores");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("That");
        spec.setContent(R.id.tabThat);
        spec.setIndicator("Constructores");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Lie");
        spec.setContent(R.id.tabLierales2);
        spec.setIndicator("JSON");
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
        lsvLiterales = (ListView)findViewById(R.id.lsv_literales);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.literales,
                android.R.layout.simple_list_item_1);
        lsvLiterales.setAdapter(adapter);

        lsvThat = (ListView)findViewById(R.id.lsv_that);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(
                this,
                R.array.that, android.R.layout.simple_list_item_1);
        lsvThat.setAdapter(adapter3);

        lsvLie = (ListView)findViewById(R.id.lsv_literales2);
        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(
                this,
                R.array.literales2, android.R.layout.simple_list_item_1);
        lsvLie.setAdapter(adapter4);


    }
    //al presionar ña imagen creara in intento
    public void presionBotonImagen(View v) {
        startActivity(new Intent(ContenidoL.this, EvaluarL.class));
        finish();
    }


    public void presionBotonImagen1(View v) {
        startActivity(new Intent(ContenidoL.this, ListaActivity.class));
        finish();
    }


    public void presionaBotonAudio(View v) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.s3);
        mp.start();
    }
    public void presionaBotonvideo(View v) {
        startActivity(new Intent(ContenidoL.this, VideoL.class));
        finish();
    }
}
