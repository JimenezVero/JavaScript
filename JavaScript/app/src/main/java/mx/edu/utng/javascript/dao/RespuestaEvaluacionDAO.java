package mx.edu.utng.javascript.dao;

import android.database.sqlite.SQLiteDatabase;

import mx.edu.utng.javascript.model.RespuestaEvaluacion;

/**
 * Created by Iruzz on 05/04/2016.
 */
public interface RespuestaEvaluacionDAO {
    void agregar(RespuestaEvaluacion respuestaEvaluacion, SQLiteDatabase db);
    void cambiar(RespuestaEvaluacion respuestaEvaluacion, SQLiteDatabase db);

}
