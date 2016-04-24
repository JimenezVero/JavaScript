package mx.edu.utng.javascript;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.utng.javascript.dao.DBHelper;
import mx.edu.utng.javascript.dao.DBHelperUsuario;
import mx.edu.utng.javascript.dao.UsuarioDAOImpl;
import mx.edu.utng.javascript.model.Usuario;

/**
 * Created by Edgar on 04/04/2016.
 */
public class Registrarme extends Activity implements View.OnClickListener {

    //Inicaando variables
    private Button botonRegistrarme;
    private EditText edtNombre;
    private EditText edtApp;
    private EditText edtApm;
    private EditText edtUsuario;
    private EditText edtPassword;
    private EditText edtCorreo;
    private SQLiteDatabase db;
    private Usuario usuario;
    private UsuarioDAOImpl dao;
    private DBHelper dbHelper;
    private Bundle respuestaBundle;


    //Instanciando
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        initComponents();
    }

    //Iniciando componentes
    public void initComponents() {
        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtApp = (EditText) findViewById(R.id.edtApp);
        edtApm = (EditText) findViewById(R.id.edtApm);
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtCorreo = (EditText) findViewById(R.id.edtCorreo);
        botonRegistrarme = (Button) findViewById(R.id.buttonReg);
        botonRegistrarme.setOnClickListener(this);

        //conenctando a la base de datos
        dbHelper = new DBHelper(this, DBHelper.DATABASE_NAME, null, DBHelper.DATABASE_VERSION);
        db = dbHelper.getWritableDatabase();
        dao = new UsuarioDAOImpl();
    }

    //Dando opciones al boton al momento de dar clic
    @Override
    public void onClick(View v) {
        usuario = new Usuario(1, edtNombre.getText().toString(),edtApp.getText().toString(), edtApm.getText().toString(),
                edtUsuario.getText().toString(),edtPassword.getText().toString(),edtCorreo.getText().toString());
        Toast.makeText(getApplicationContext(), "Usuario Guardado", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Registrarme.this, Login.class));
        finish();
        if (respuestaBundle != null) {
            usuario.setIdUsuario(
                    respuestaBundle.getInt(DBHelperUsuario.ID_USUARIO));
        }
        if (usuario.getIdUsuario() == 1) {
            dao.agregar(usuario, db);
        } else {
            //dao.cambiar(usuario, db);
        }

        Log.d("Guardando datos", " " + usuario.getIdUsuario() + " el estado es: " + usuario.getNombre());
    }
}
