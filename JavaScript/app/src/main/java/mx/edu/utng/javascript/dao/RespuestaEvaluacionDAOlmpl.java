package mx.edu.utng.javascript.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import mx.edu.utng.javascript.model.RespuestaEvaluacion;

/**
 * Created by Iruzz on 05/04/2016.
 */
public class RespuestaEvaluacionDAOlmpl implements RespuestaEvaluacionDAO {

    //Iniciar variables
    private SQLiteDatabase db;
    private int numero=0;
    public static final String TABLE_NAME_5 = "tbl_estadoevaluacion";



//Agragando valores
    @Override
    public void agregar(RespuestaEvaluacion respuestaEvaluacion, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(DBHelperUsuario.ID_USUARIO, respuestaEvaluacion.getIdUsuario());
        values.put(DBHelperUsuario.ID_EVALUACION, respuestaEvaluacion.getIdEvaluacion());
        values.put(DBHelperUsuario.ID_PREGUNTA, respuestaEvaluacion.getIdPregunta());
        values.put(DBHelperUsuario.ESTADO_PREGUNTA, respuestaEvaluacion.isEstadoPregunta());
        db.insert(DBHelperUsuario.TABLE_NAME_4, null, values);

    }

//Obteniendo los resultados db
    public Integer obtenerResultados(SQLiteDatabase db, Integer estado){
        Log.i("SQLite", "query -> Consulta solo registros estado='TRUE' ");

        Cursor c = db.query("tbl_respuesta",
                new String[]{"count(estadoPregunta)"},
                " estadoPregunta=1 and idEvaluacion=1 and idUsuario=1",
                null, null, null,
                null);
        try{
            if (c.moveToFirst()) {

                do {
                    numero= c.getInt(0);
                    Log.d("Obtuve respuestas true"," "+numero);
                } while(c.moveToNext());
            }
            if(numero>=4) {
                if (estado == 0) {
                    final String INSERT_TABLE_5 = "INSERT INTO " + TABLE_NAME_5 +
                            "(idUsuario, idEvaluacion, estadoEvaluacion) VALUES (1,1,1);";
                    db.execSQL(INSERT_TABLE_5);
                } else {
                    final String UPDATE_TABLE_5 = "UPDATE " + TABLE_NAME_5 + " SET " +
                            "idUsuario=1, idEvaluacion=1, estadoEvaluacion1;";
                    db.execSQL(UPDATE_TABLE_5);
                }
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }

    public Integer obtenerResultados1(SQLiteDatabase db,Integer estado){
        Log.i("SQLite", "query -> Consulta solo registros estado='TRUE' ");
        Cursor c = db.query("tbl_respuesta",//Posición del cursor
                new String[]{"count(estadoPregunta)"},
                " estadoPregunta=1 and idEvaluacion=2 and idUsuario=1",
                null, null, null,
                null);
        try{
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    numero= c.getInt(0);
                    Log.d("Obtuve respuestas true"," "+numero);
                } while(c.moveToNext());
            }
            if(numero>=4 ){
                if(estado==0){
                    final String INSERT_TABLE_5 ="INSERT INTO "+TABLE_NAME_5+
                            "(idUsuario, idEvaluacion, estadoEvaluacion) VALUES (1,2,1);";
                    db.execSQL(INSERT_TABLE_5);
                }else{
                    final String UPDATE_TABLE_5 ="UPDATE "+TABLE_NAME_5+" SET "+
                            "idUsuario=1, idEvaluacion=2, estadoEvaluacion1;";
                    db.execSQL(UPDATE_TABLE_5);
                }
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");//Mensaje de error
        }
        return numero;
    }

    public Integer obtenerResultados2(SQLiteDatabase db,Integer estado){
        Log.i("SQLite", "query -> Consulta solo registros estado='TRUE' ");
        Cursor c = db.query("tbl_respuesta",//Posición del cursor
                new String[]{"count(estadoPregunta)"},
                " estadoPregunta=1 and idEvaluacion=3 and idUsuario=1",
                null, null, null,
                null);
        try{
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    numero= c.getInt(0);
                    Log.d("Obtuve respuestas true"," "+numero);
                } while(c.moveToNext());
            }
            if(numero>=4 ){
                if(estado==0){
                    final String INSERT_TABLE_5 ="INSERT INTO "+TABLE_NAME_5+
                            "(idUsuario, idEvaluacion, estadoEvaluacion) VALUES (1,3,1);";
                    db.execSQL(INSERT_TABLE_5);
                }else{
                    final String UPDATE_TABLE_5 ="UPDATE "+TABLE_NAME_5+" SET "+
                            "idUsuario=1, idEvaluacion=3, estadoEvaluacion1;";
                    db.execSQL(UPDATE_TABLE_5);
                }
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }


    public Integer obtenerResultados3(SQLiteDatabase db,Integer estado){
        Log.i("SQLite", "query -> Consulta solo registros estado='TRUE' ");
        Cursor c = db.query("tbl_respuesta",
                new String[]{"count(estadoPregunta)"},
                " estadoPregunta=1 and idEvaluacion=4 and idUsuario=1",
                null, null, null,
                null);
        try{
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    numero= c.getInt(0);
                    Log.d("Obtuve respuestas true"," "+numero);
                } while(c.moveToNext());
            }
            if(numero>=4 ){
                if(estado==0){
                    final String INSERT_TABLE_5 ="INSERT INTO "+TABLE_NAME_5+
                            "(idUsuario, idEvaluacion, estadoEvaluacion) VALUES (1,4,1);";
                    db.execSQL(INSERT_TABLE_5);
                }else{
                    final String UPDATE_TABLE_5 ="UPDATE "+TABLE_NAME_5+" SET "+
                            "idUsuario=1, idEvaluacion=4, estadoEvaluacion1;";
                    db.execSQL(UPDATE_TABLE_5);
                }
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }

    public Integer obtenerResultados4(SQLiteDatabase db,Integer estado){
        Log.i("SQLite", "query -> Consulta solo registros estado='TRUE' ");
        Cursor c = db.query("tbl_respuesta",
                new String[]{"count(estadoPregunta)"},
                " estadoPregunta=1 and idEvaluacion=5 and idUsuario=1",
                null, null, null,
                null);
        try{
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    numero= c.getInt(0);
                    Log.d("Obtuve respuestas true"," "+numero);
                } while(c.moveToNext());
            }
            if(numero>=4 ){
                if(estado==0){
                    final String INSERT_TABLE_5 ="INSERT INTO "+TABLE_NAME_5+
                            "(idUsuario, idEvaluacion, estadoEvaluacion) VALUES (1,5,1);";
                    db.execSQL(INSERT_TABLE_5);
                }else{
                    final String UPDATE_TABLE_5 ="UPDATE "+TABLE_NAME_5+" SET "+
                            "idUsuario=1, idEvaluacion=5, estadoEvaluacion1;";
                    db.execSQL(UPDATE_TABLE_5);
                }
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }

    public Integer obtenerResultados5(SQLiteDatabase db,Integer estado){
        Log.i("SQLite", "query -> Consulta solo registros estado='TRUE' ");
        Cursor c = db.query("tbl_respuesta",
                new String[]{"count(estadoPregunta)"},
                " estadoPregunta=1 and idEvaluacion=6 and idUsuario=1",
                null, null, null,
                null);
        try{
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    numero= c.getInt(0);
                    Log.d("Obtuve respuestas true"," "+numero);
                } while(c.moveToNext());
            }
            if(numero>=4 ){
                if(estado==0){
                    final String INSERT_TABLE_5 ="INSERT INTO "+TABLE_NAME_5+
                            "(idUsuario, idEvaluacion, estadoEvaluacion) VALUES (1,6,1);";
                    db.execSQL(INSERT_TABLE_5);
                }else{
                    final String UPDATE_TABLE_5 ="UPDATE "+TABLE_NAME_5+" SET "+
                            "idUsuario=1, idEvaluacion=6, estadoEvaluacion1;";
                    db.execSQL(UPDATE_TABLE_5);
                }
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }

    public Integer obtenerResultados6(SQLiteDatabase db,Integer estado){
        Log.i("SQLite", "query -> Consulta solo registros estado='TRUE' ");
        Cursor c = db.query("tbl_respuesta",
                new String[]{"count(estadoPregunta)"},
                " estadoPregunta=1 and idEvaluacion=7 and idUsuario=1",
                null, null, null,
                null);
        try{
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    numero= c.getInt(0);
                    Log.d("Obtuve respuestas true"," "+numero);
                } while(c.moveToNext());
            }
            if(numero>=4 ){
                if(estado==0){
                    final String INSERT_TABLE_5 ="INSERT INTO "+TABLE_NAME_5+
                            "(idUsuario, idEvaluacion, estadoEvaluacion) VALUES (1,7,1);";
                    db.execSQL(INSERT_TABLE_5);
                }else{
                    final String UPDATE_TABLE_5 ="UPDATE "+TABLE_NAME_5+" SET "+
                            "idUsuario=1, idEvaluacion=7, estadoEvaluacion1;";
                    db.execSQL(UPDATE_TABLE_5);
                }
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }


    public Integer obtenerResultados7(SQLiteDatabase db,Integer estado){
        Log.i("SQLite", "query -> Consulta solo registros estado='TRUE' ");
        Cursor c = db.query("tbl_respuesta",
                new String[]{"count(estadoPregunta)"},
                " estadoPregunta=1 and idEvaluacion=8 and idUsuario=1",
                null, null, null,
                null);
        try{
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    numero= c.getInt(0);
                    Log.d("Obtuve respuestas true"," "+numero);
                } while(c.moveToNext());
            }
            if(numero>=4 ){
                if(estado==0){
                    final String INSERT_TABLE_5 ="INSERT INTO "+TABLE_NAME_5+
                            "(idUsuario, idEvaluacion, estadoEvaluacion) VALUES (1,8,1);";
                    db.execSQL(INSERT_TABLE_5);
                }else{
                    final String UPDATE_TABLE_5 ="UPDATE "+TABLE_NAME_5+" SET "+
                            "idUsuario=1, idEvaluacion=8, estadoEvaluacion1;";
                    db.execSQL(UPDATE_TABLE_5);
                }
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;
    }


    @Override
    public void cambiar(RespuestaEvaluacion respuestaEvaluacion, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(DBHelperUsuario.ESTADO_PREGUNTA, respuestaEvaluacion.isEstadoPregunta());
        db.update(DBHelperUsuario.TABLE_NAME_4, values, DBHelper.ID_USUARIO + "=" + respuestaEvaluacion.getIdUsuario()
                        +" and "+DBHelperUsuario.ID_EVALUACION + "=" + respuestaEvaluacion.getIdEvaluacion()
                        +" and " +DBHelperUsuario.ID_PREGUNTA + "=" + respuestaEvaluacion.getIdPregunta(),
                null);
    }
    //Método Verificar ID

    public int verificarId(RespuestaEvaluacion respuestaEvaluacion, SQLiteDatabase db){
        Cursor c = db.query("tbl_respuesta",
                new String[]{"count(*)"},
                " idPregunta= "+respuestaEvaluacion.getIdPregunta()+" and idEvaluacion="+respuestaEvaluacion.getIdEvaluacion()+
                        " and idUsuario="+respuestaEvaluacion.getIdUsuario(),
                null, null, null,
                null);
        Log.d("Datos: ", " " + "idPregunta= " + respuestaEvaluacion.getIdPregunta() + " and idEvaluacion=" + respuestaEvaluacion.getIdEvaluacion() +
                " and idUsuario=" + respuestaEvaluacion.getIdUsuario());
        try{
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    numero = c.getInt(0);
                    Log.d("Obtuve respuesta exis", " " + numero);
                } while (c.moveToNext());
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");//Mensaje de error
        }
        return numero;

    }

    //Método verificar el estado del examen

    public int verificarEstado(RespuestaEvaluacion respuestaEvaluacion, SQLiteDatabase db){
        Cursor c = db.query("tbl_estadoevaluacion",
                new String[]{"count(*)"},
                " idEvaluacion="+respuestaEvaluacion.getIdEvaluacion()+" and idUsuario="+respuestaEvaluacion.getIdUsuario(),
                null, null, null,
                null);
        try{
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    numero = c.getInt(0);
                } while (c.moveToNext());
            }
        }catch(Exception e){
            Log.e("Base de Datos", "Error al leer la Base de Datos");
        }
        return numero;//Devuelve el número

    }


    //Utilizando cursor
    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBHelperUsuario.ID_USUARIO,
                DBHelperUsuario.ID_EVALUACION,
                DBHelperUsuario.ID_PREGUNTA,
                DBHelperUsuario.ESTADO_PREGUNTA
        };
        Cursor c = db.query(DBHelperUsuario.TABLE_NAME_4, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }
    }
