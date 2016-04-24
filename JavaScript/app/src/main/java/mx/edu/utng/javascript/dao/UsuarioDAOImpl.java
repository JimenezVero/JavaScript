package mx.edu.utng.javascript.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import mx.edu.utng.javascript.model.Usuario;


public class UsuarioDAOImpl {

    private SQLiteDatabase db;
    private String user;
    public static final String TABLE_NAME_5 = "tbl_estadoevaluacion";
///Agregango a db
    public void agregar(Usuario usuario, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(DBHelperUsuario.ID_USUARIO, usuario.getIdUsuario());
        values.put(DBHelper.NOMBRE, usuario.getNombre());
        values.put(DBHelper.APELLIDOP, usuario.getApellidop());
        values.put(DBHelper.APELLIDOM, usuario.getApellidom());
        values.put(DBHelper.USUARIO, usuario.getUsuario());
        values.put(DBHelper.PASSWORD, usuario.getPassword());
        values.put(DBHelper.CORREO, usuario.getCorreo());
        db.insert(DBHelper.TABLE_NAME_1, null, values);
    }

    public String verificarUsuario(SQLiteDatabase db){
        Cursor c = db.query("tbl_usuario",
                new String[]{"usuario"},
                "idUsuario=1",
                null, null, null,
                null);
        try{
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    user = c.getString(0);
                } while (c.moveToNext());
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return user;//Devuelve el número

    }
}
