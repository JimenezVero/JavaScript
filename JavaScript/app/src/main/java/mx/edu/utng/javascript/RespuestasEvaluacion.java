package mx.edu.utng.javascript;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;

import mx.edu.utng.javascript.dao.DBHelper;
import mx.edu.utng.javascript.dao.DBHelperUsuario;
import mx.edu.utng.javascript.dao.RespuestaEvaluacionDAOlmpl;
import mx.edu.utng.javascript.model.RespuestaEvaluacion;

/**
 * Created by Iruzz on 06/04/2016.
 */
public class RespuestasEvaluacion extends Activity {

    //Iniciando variable
    private ListView lista;
    private DBHelper dbHelper;
    private RespuestaEvaluacionDAOlmpl dao;
    private RespuestaEvaluacion cliente;
    //    private Cursor cursor;
    private SQLiteDatabase db;
    private TextView tv_preguntaID;
    private TextView tv_Status;
    private GoogleApiClient client;

//Instanciando
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.respuestas_examen);
        initComponents();


    }

    //Iniciar componentes
    private void initComponents() {
        lista = (ListView) findViewById(R.id.lsv_respuestas);
        dbHelper = new DBHelper(this, DBHelper.DATABASE_NAME, null,
                DBHelper.DATABASE_VERSION);
        db = dbHelper.getWritableDatabase();
        dao = new RespuestaEvaluacionDAOlmpl();
    }

    // Tomar los datos desde la base de datos para poner en el curso y después en el adapter
    Cursor cursor = dao.leerDatos();

    String[] from = new String[]{
            DBHelperUsuario.ID_USUARIO,
            DBHelperUsuario.ID_EVALUACION,
            DBHelperUsuario.ID_PREGUNTA,
            DBHelperUsuario.ESTADO_PREGUNTA
    };
    int[] to = new int[]{

            R.id.user_id,
            R.id.pregunta_id,
            R.id.estatus
    };

    SimpleCursorAdapter adapter = new SimpleCursorAdapter(
            RespuestasEvaluacion.this, R.layout.layout_row_format, cursor, from, to);

}
