package mx.edu.utng.javascript.fundamenos;

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
public class ContenidoFF extends Activity{
    //crear variables
    private ListView lsvFunamentos;
    private ListView lsvLoops;
    private ListView lsvSangria;
    private Button btnImagen;

    //instanciando
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenidoff_layout);
        initComponents();
    }
    //iniciando componentes
    private void initComponents(){

        btnImagen = (Button)findViewById(R.id.Btn_botonMasImagen);


        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("Fundamentos");
        spec.setContent(R.id.tabFundamentos);
        spec.setIndicator("Fundamentos");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Loops");
        spec.setContent(R.id.tabLoops);
        spec.setIndicator("Loops");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Sangria");
        spec.setContent(R.id.tabSangria);
        spec.setIndicator("Sangria");
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
        lsvFunamentos = (ListView)findViewById(R.id.lsv_fundamentos);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.fundamentos,
                android.R.layout.simple_list_item_1);
        lsvFunamentos.setAdapter(adapter);

        lsvLoops = (ListView)findViewById(R.id.lsv_looos);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(
                this,
                R.array.loops, android.R.layout.simple_list_item_1);
        lsvLoops.setAdapter(adapter3);

        lsvSangria = (ListView)findViewById(R.id.lsv_sangria);
        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(
                this,
                R.array.sangria, android.R.layout.simple_list_item_1);
        lsvSangria.setAdapter(adapter4);


    }
    //al presionar ña imagen creara in intento
    public void presionBotonImagen(View v) {
        startActivity(new Intent(ContenidoFF.this, EvaluacionFF.class));
        finish();
    }

    public void presionBotonImagen1(View v) {
        startActivity(new Intent(ContenidoFF.this, ListaActivity.class));
        finish();
    }


    public void presionaBotonAudio(View v) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.s3);
        mp.start();
    }
    public void presionaBotonvideo(View v) {
        startActivity(new Intent(ContenidoFF.this, VideoFF.class));
        finish();
    }

}
