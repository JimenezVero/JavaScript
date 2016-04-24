package mx.edu.utng.javascript;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by TOSHIBA on 02/03/2016.
 */
public class AcercaDeActivity extends Activity {


    //Creando componentes
    private TextView txtAcerca;
    private TextView txtUniversidad;
    private TextView txtNombre;
    private TextView txtClase;
    private TextView txtReferencias;
    private TextView txtLibro;
    private TextView txtAutoy;
    private TextView txtUrl;
    private String url = "https://www.youtube.com/channel/UCbr0g_ADLsdzhcoAFUZkuug";
    private TextView txtAutor;
    private Button btnImagen1;
    @Override

    //Instanciando
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acerca_de_layout);
        initComponent();
    }

    //Iniciando componentes
    private void initComponent() {
        txtAcerca = (TextView)findViewById(R.id.txt_acerca);
        txtUniversidad = (TextView)findViewById(R.id.txt_universidad);
        txtNombre = (TextView)findViewById(R.id.txt_nombre);
        txtClase = (TextView)findViewById(R.id.txt_clase);
        txtReferencias = (TextView)findViewById(R.id.txt_referencias);
        txtLibro = (TextView)findViewById(R.id.txt_libro);
        txtAutoy = (TextView)findViewById(R.id.txt_autory);
        txtAutor = (TextView)findViewById(R.id.txt_autor);
        txtUrl = (TextView)findViewById(R.id.txt_dir);
        btnImagen1 = (Button)findViewById(R.id.Btn_botonMasImagen1);

        txtUrl.setText(Html.fromHtml(" <a href=" + url + ">Sigue viendo mas video tutoriales</a>"));
    }

    public void presionBotonImagen1(View v) {
        startActivity(new Intent(AcercaDeActivity.this, ListaActivity.class));
        finish();
    }
}
