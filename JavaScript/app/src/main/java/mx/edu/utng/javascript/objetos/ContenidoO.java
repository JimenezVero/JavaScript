package mx.edu.utng.javascript.objetos;

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
public class ContenidoO extends Activity{
    //crear variables
    private ListView lsvCreacion;
    private ListView lsvPrivcidad;
    private ListView lsvPatroM;
    private Button btnImagen;

    //instanciando
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenidoo_layout);
        initComponents();
    }
    //iniciando componentes
    private void initComponents(){

        btnImagen = (Button)findViewById(R.id.Btn_botonMasImagen);


        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("Creacion");
        spec.setContent(R.id.tabCreacion);
        spec.setIndicator("Creacion");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Privacidad");
        spec.setContent(R.id.tabPrivacidad);
        spec.setIndicator("Privacidad");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("PatronM");
        spec.setContent(R.id.tabPatroM);
        spec.setIndicator("Modulos");
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
        lsvCreacion = (ListView)findViewById(R.id.lsv_creacion);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.creacion,
                android.R.layout.simple_list_item_1);
        lsvCreacion.setAdapter(adapter);

        lsvPrivcidad = (ListView)findViewById(R.id.lsv_privacidad);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(
                this,
                R.array.privacidad, android.R.layout.simple_list_item_1);
        lsvPrivcidad.setAdapter(adapter3);

        lsvPatroM = (ListView)findViewById(R.id.lsv_patroM);
        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(
                this,
                R.array.patrones_modulo, android.R.layout.simple_list_item_1);
        lsvPatroM.setAdapter(adapter4);


    }
    //al presionar ña imagen creara in intento
    public void presionBotonImagen(View v) {
        startActivity(new Intent(ContenidoO.this, EvaluarO.class));
        finish();
    }
    public void presionBotonImagen1(View v) {
        startActivity(new Intent(ContenidoO.this, ListaActivity.class));
        finish();
    }

    public void presionaBotonAudio(View v) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.s3);
        mp.start();
    }
    public void presionaBotonvideo(View v) {
        startActivity(new Intent(ContenidoO.this, VideoO.class));
        finish();
    }
}
