package mx.edu.utng.javascript;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.javascript.dao.DBHelper;
import mx.edu.utng.javascript.dao.RespuestaEvaluacionDAOlmpl;
import mx.edu.utng.javascript.diseno.ContenidoD;
import mx.edu.utng.javascript.funciones.ContenidoF;
import mx.edu.utng.javascript.fundamenos.ContenidoFF;
import mx.edu.utng.javascript.introduccion.ContenidoI;
import mx.edu.utng.javascript.juego.Juego;
import mx.edu.utng.javascript.literales.ContenidoL;
import mx.edu.utng.javascript.model.Correo;
import mx.edu.utng.javascript.navegador.ContenidoN;
import mx.edu.utng.javascript.objetos.ContenidoO;
import mx.edu.utng.javascript.patrones.ContenidoP;

//Clase Lista
public class
        ListaActivity extends ActionBarActivity {


    private RespuestaEvaluacionDAOlmpl dao;
    private int numero = 0;
    private String correo = "";
    private SQLiteDatabase curso;
    private DBHelper dbHelper;
    //Creado
    private TextView txtInicio;
    private ListView lsvContenido;
    public String[] datos = new String[]{"Introduccion", "Fundamentos", "Literales y Constructores", "Funciones",
            "Patrones de creacion de objetos", "Patrones de la reutilizaciode código", "Patrones de diseño",
            "DOM y Patrones de navegador", "Certificado"};

    //Instanciando
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        initComponents();

    }

//Inflando el menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mebu, menu);
        return true;
    }

//DEclarando las opciones de manu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {


            case R.id.menu_login:
                startActivity(new Intent(ListaActivity.this, Registrarme.class));
                break;

            case R.id.menu_cambiar:
                startActivity(new Intent(ListaActivity.this, CambioContrasena.class));
                break;

            case R.id.menu_acerca:
                startActivity(new Intent(ListaActivity.this, AcercaDeActivity.class));

                break;

            case R.id.menu_ubicacion:
                startActivity(new Intent(ListaActivity.this, MapsActivity.class));
                break;

            case R.id.menu_juego:
                startActivity(new Intent(ListaActivity.this, Juego.class));
                break;


            default:
                break;


        }
        return true;

    }

    //Iniciando componentes
    private void initComponents() {
        ArrayAdapter adaptador = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, datos);
        txtInicio = (TextView) findViewById(R.id.txv_tematico);
        lsvContenido = (ListView) findViewById(R.id.lst_contenido);
        lsvContenido.setAdapter(adaptador);
        dbHelper = new DBHelper(this, DBHelper.DATABASE_NAME, null, DBHelper.DATABASE_VERSION);
        curso = dbHelper.getWritableDatabase();
        dao = new RespuestaEvaluacionDAOlmpl();

        //Comunicando actividades, realizando intenos

        lsvContenido.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                switch (position) {

                    case 0:

                        startActivity(new Intent(ListaActivity.this, ContenidoI.class));
                        break;

                    case 1:

                        int estado = obtenerEstadoEvaluacion();
                        if(estado !=1){
                            Toast.makeText(ListaActivity.this, "Conenido Bloqueado", Toast.LENGTH_SHORT).show();
                            initComponents();
                        }else {
                            startActivity(new Intent(ListaActivity.this, ContenidoFF.class));

                            String email = obtenerCorreo();
                            Correo correo  =  new Correo(email,"Examen1","Examen 6 Aciertos:"+estado);
                            correo.enviarResultado();

                        }

                        break;

                    case 2:

                        int aciertos1=obtenerEstadoEvaluacion1();
                        if(aciertos1!=1){
                            Toast.makeText(getApplicationContext(), "Conenido Bloqueado", Toast.LENGTH_SHORT).show();
                            initComponents();
                        }else {

                            startActivity(new Intent(ListaActivity.this, ContenidoL.class));

                        }

                        break;

                    case 3:

                        int aciertos2=obtenerEstadoEvaluacion2();
                        if(aciertos2!=1){
                            Toast.makeText(getApplicationContext(), "Conenido Bloqueado", Toast.LENGTH_SHORT).show();
                            initComponents();
                        }else {
                            startActivity(new Intent(ListaActivity.this, ContenidoF.class));
                        }
                        break;

                    case 4:

                        int aciertos3=obtenerEstadoEvaluacion3();
                        if(aciertos3!=1){
                            Toast.makeText(getApplicationContext(), "Conenido Bloqueado", Toast.LENGTH_SHORT).show();
                            initComponents();
                        }else {
                            startActivity(new Intent(ListaActivity.this, ContenidoO.class));
                        }
                        break;

                    case 5:

                        int aciertos4=obtenerEstadoEvaluacion4();
                        if(aciertos4!=1){
                            Toast.makeText(ListaActivity.this, "Conenido Bloqueado", Toast.LENGTH_SHORT).show();
                            initComponents();
                        }else {
                            startActivity(new Intent(ListaActivity.this, ContenidoP.class));
                        }
                        break;

                    case 6:

                        int aciertos5=obtenerEstadoEvaluacion5();
                        if(aciertos5!=1){
                            Toast.makeText(ListaActivity.this, "Conenido Bloqueado", Toast.LENGTH_SHORT).show();
                            initComponents();
                        }else {
                            startActivity(new Intent(ListaActivity.this, ContenidoD.class));
                        }

                        break;

                    case 7:

                        int aciertos6=obtenerEstadoEvaluacion6();
                        if(aciertos6!=1){
                            Toast.makeText(getApplicationContext(), "Conenido Bloqueado", Toast.LENGTH_SHORT).show();
                            initComponents();
                        }else {
                            startActivity(new Intent(ListaActivity.this, ContenidoN.class));
                        }

                        break;

                    case 8:
                        int aciertos7=obtenerEstadoEvaluacion7();
                        if(aciertos7!=1){
                            Toast.makeText(getApplicationContext(), "Bloqueado", Toast.LENGTH_SHORT).show();
                            initComponents();
                        }else {
                            startActivity(new Intent(ListaActivity.this, Certificado.class));
                        }

                        break;

                    default:

                        break;
                }

            }

        });
    }


    public Integer obtenerEstadoEvaluacion() {
        Log.i("SQLite", "query -> Consulta solo registros estadoEvaluacion' ");
        Cursor c = curso.query("tbl_estadoevaluacion", new String[]{"estadoEvaluacion"},
                " idUsuario=1 and idEvaluacion=1", null, null, null, null);
        try {
            if (c.moveToFirst()) {
                do {
                    numero = c.getInt(0);
                    Log.d("Obtuve respuestas true", " " + numero);
                } while (c.moveToNext());
            }
        } catch (Exception e) {
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }

    public Integer obtenerEstadoEvaluacion1() {
        Log.i("SQLite", "query -> Consulta solo registros estadoEvaluacion' ");
        Cursor c = curso.query("tbl_estadoevaluacion", new String[]{"estadoEvaluacion"},
                " idUsuario=1 and idEvaluacion=2", null, null, null, null);
        try {
            if (c.moveToFirst()) {
                do {
                    numero = c.getInt(0);
                    Log.d("Obtuve respuestas true", " " + numero);
                } while (c.moveToNext());
            }
        } catch (Exception e) {
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }

    public Integer obtenerEstadoEvaluacion2() {
        Log.i("SQLite", "query -> Consulta solo registros estadoEvaluacion' ");
        Cursor c = curso.query("tbl_estadoevaluacion", new String[]{"estadoEvaluacion"},
                " idUsuario=1 and idEvaluacion=3", null, null, null, null);
        try {
            if (c.moveToFirst()) {
                do {
                    numero = c.getInt(0);
                    Log.d("Obtuve respuestas true", " " + numero);
                } while (c.moveToNext());
            }
        } catch (Exception e) {
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }

    public Integer obtenerEstadoEvaluacion3() {
        Log.i("SQLite", "query -> Consulta solo registros estadoEvaluacion' ");
        Cursor c = curso.query("tbl_estadoevaluacion", new String[]{"estadoEvaluacion"},
                " idUsuario=1 and idEvaluacion=4", null, null, null, null);
        try {
            if (c.moveToFirst()) {
                do {
                    numero = c.getInt(0);
                    Log.d("Obtuve respuestas true", " " + numero);
                } while (c.moveToNext());
            }
        } catch (Exception e) {
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }


    public Integer obtenerEstadoEvaluacion4() {
        Log.i("SQLite", "query -> Consulta solo registros estadoEvaluacion' ");
        Cursor c = curso.query("tbl_estadoevaluacion", new String[]{"estadoEvaluacion"},
                " idUsuario=1 and idEvaluacion=5", null, null, null, null);
        try {
            if (c.moveToFirst()) {
                do {
                    numero = c.getInt(0);
                    Log.d("Obtuve respuestas true", " " + numero);
                } while (c.moveToNext());
            }
        } catch (Exception e) {
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }

    public Integer obtenerEstadoEvaluacion5() {
        Log.i("SQLite", "query -> Consulta solo registros estadoEvalucion' ");
        Cursor c = curso.query("tbl_estadoevaluacion", new String[]{"estadoEvaluacion"},
                " idUsuario=1 and idEvaluacion=6", null, null, null, null);
        try {
            if (c.moveToFirst()) {
                do {
                    numero = c.getInt(0);
                    Log.d("Obtuve respuestas true", " " + numero);
                } while (c.moveToNext());
            }
        } catch (Exception e) {
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }

    public Integer obtenerEstadoEvaluacion6() {
        Log.i("SQLite", "query -> Consulta solo registros estadoEvaluacion' ");
        Cursor c = curso.query("tbl_estadoevaluacion", new String[]{"estadoEvaluacion"},
                " idUsuario=1 and idEvaluacion=7", null, null, null, null);
        try {
            if (c.moveToFirst()) {
                do {
                    numero = c.getInt(0);
                    Log.d("Obtuve respuestas true", " " + numero);
                } while (c.moveToNext());
            }
        } catch (Exception e) {
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }

    public Integer obtenerEstadoEvaluacion7() {
        Log.i("SQLite", "query -> Consulta solo registros estadoEvaluacion' ");
        Cursor c = curso.query("tbl_estadoevaluacion", new String[]{"estadoEvaluacion"},
                " idUsuario=1 and idEvaluacion=8", null, null, null, null);
        try {
            if (c.moveToFirst()) {
                do {
                    numero = c.getInt(0);
                    Log.d("Obtuve respuestas true", " " + numero);
                } while (c.moveToNext());
            }
        } catch (Exception e) {
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }

    public String obtenerCorreo() {
        Log.i("SQLite", "query -> Consulta correo' ");
        Cursor c = curso.query("tbl_usuario", new String[]{"correo"},
                " idUsuario=1", null, null, null, null);
        try {
            if (c.moveToFirst()) {
                do {
                    correo = c.getString(0);
                    Log.d("Obtuve correo", " " + correo);
                } while (c.moveToNext());
            }
        } catch (Exception e) {
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return correo;
    }



}


