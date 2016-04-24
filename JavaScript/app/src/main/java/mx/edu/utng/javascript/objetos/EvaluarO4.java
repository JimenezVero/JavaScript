package mx.edu.utng.javascript.objetos;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.Toast;

import mx.edu.utng.javascript.ListaActivity;
import mx.edu.utng.javascript.R;
import mx.edu.utng.javascript.dao.DBHelper;
import mx.edu.utng.javascript.dao.RespuestaEvaluacionDAOlmpl;
import mx.edu.utng.javascript.model.RespuestaEvaluacion;

/**
 * Created by Iruzz on 07/04/2016.
 */
public class EvaluarO4 extends Activity implements View.OnClickListener{
    //crear variables
    private Button btnCalifi;
    private Button btnContinuar;
    private CheckBox chkRsp1;
    private CheckBox chkRsp2;
    private CheckBox chkRsp3;
    private SQLiteDatabase db;
    private RespuestaEvaluacion respuestaEvaluacion;
    private RespuestaEvaluacionDAOlmpl dao;
    private DBHelper dbHelper;
    private Bundle respuestaBundle;
    private boolean resultadoCheck;
    String estado="inactivo";
    private Chronometer cronometro;
    //Instanciar
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.codigoi2_layout);
        Typeface font = Typeface.createFromAsset(getAssets(), "robotobold.ttf");
        cronometro = (Chronometer)findViewById(R.id.chronometer);
        cronometro.setTypeface(font);
        initComponents();
    }
    //Iniciar componentes
    private void initComponents(){

        btnContinuar =(Button) findViewById(R.id.btn_continuar);
        btnContinuar.setOnClickListener(this);
        btnCalifi =(Button) findViewById(R.id.btn_califi);
        btnCalifi.setOnClickListener(this);
        chkRsp1= (CheckBox) findViewById(R.id.cck_rsp1);
        chkRsp2 = (CheckBox) findViewById(R.id.cck_rsp2);
        chkRsp3 = (CheckBox) findViewById(R.id.cck_rsp3);
        dbHelper = new DBHelper(this,DBHelper.DATABASE_NAME,null,DBHelper.DATABASE_VERSION);
        db = dbHelper.getWritableDatabase();
        dao = new RespuestaEvaluacionDAOlmpl();
        if(estado == "inactivo"){
            cronometro.setBase(SystemClock.elapsedRealtime());
            cronometro.start();
        }
    }


    //Metodo click
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_califi:

                cronometro.stop();
                estado="inactivo";

                //boolean isChecked = ((CheckBox)view).isChecked();
                if (chkRsp1.isChecked()) {

                    MediaPlayer mp = MediaPlayer.create(this, R.raw.s2);
                    mp.start();
                    Toast.makeText(getApplicationContext(), "Incorrecto Presione Continuar", Toast.LENGTH_SHORT).show();
                    resultadoCheck = false;
                } else if (chkRsp2.isChecked()) {
                    MediaPlayer mp = MediaPlayer.create(this, R.raw.s1);
                    mp.start();
                    Toast.makeText(getApplicationContext(), "Correcto Presione Continuar", Toast.LENGTH_SHORT).show();
                    resultadoCheck= true;
                } else if (chkRsp3.isChecked()) {
                    MediaPlayer mp = MediaPlayer.create(this, R.raw.s2);
                    mp.start();
                    Toast.makeText(getApplicationContext(), "Incorrecto Presione Continuar", Toast.LENGTH_SHORT).show();
                    resultadoCheck = false;
                }
                respuestaEvaluacion = new RespuestaEvaluacion(1, 5, 25, resultadoCheck);
                int registros = dao.verificarId(respuestaEvaluacion, db);
                Log.d("registros", " " + registros);
                if (registros == 0) {
                    dao.agregar(respuestaEvaluacion, db);
                    int estado = dao.verificarEstado(respuestaEvaluacion, db);
                    int aciertos = dao.obtenerResultados4(db, estado);
                    Log.d("Aciertos ", " " + aciertos);
                    if (aciertos >= 4) {
                        Toast toast = Toast.makeText(this, "Evaluacion Aprobada", Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        Toast toast = Toast.makeText(this, "Evaluacion No Aprobada", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                } else {
                    dao.cambiar(respuestaEvaluacion, db);
                    int estado = dao.verificarEstado(respuestaEvaluacion, db);
                    int aciertos = dao.obtenerResultados4(db, estado);
                    Log.d("Aciertos ", " " + aciertos);
                    if (aciertos >= 4) {
                        Toast toast = Toast.makeText(this, "Evaluacion Aprobada", Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        Toast toast = Toast.makeText(this, "Evaluacion No Aprobada", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }


                Log.d("Guardando datos", " " + respuestaEvaluacion.getIdPregunta() + " el estado es: " + respuestaEvaluacion.isEstadoPregunta());


                break;

            case R.id.btn_continuar:

                int estado = dao.verificarEstado(respuestaEvaluacion, db);
                int aciertos = dao.obtenerResultados4(db, estado);
                Log.d("Aciertos ", " " + aciertos);
                if (aciertos >= 4) {
                    PieGraph4 pie = new PieGraph4();
                    Intent lineIntent = pie.getIntent(this);
                    startActivity(lineIntent);
                    finish();
                } else {
                    startActivity(new Intent(EvaluarO4.this, ContenidoO.class));
                    finish();
                }

                break;
        }
    }


}
