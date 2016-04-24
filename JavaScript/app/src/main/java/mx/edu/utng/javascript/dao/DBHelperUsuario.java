package mx.edu.utng.javascript.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelperUsuario extends SQLiteOpenHelper {

    //Iniciar variables
    public static final String DATABASE_NAME = "curso.db";
    public static final int DATABASE_VERSION = 2;
    public static final String TABLE_NAME_1 = "tbl_usuario";
    public static final String TABLE_NAME_2 = "tbl_evaluacion";
    public static final String TABLE_NAME_3 = "tbl_pregunta";
    public static final String TABLE_NAME_4 = "tbl_respuesta";
    public static final String TABLE_NAME_5 = "tbl_estadoevaluacion";
    public static final String ID_USUARIO = "idUsuario";
    public static final String ID_EVALUACION = "idEvaluacion";
    public static final String ID_PREGUNTA = "idPregunta";
    public static final String ESTADO_PREGUNTA = "estadoPregunta";
    public static final String ESTADO_EVALUACION = "estadoEvaluacion";

    //Creamos la tabla 1
    private static final String CREATE_TABLE_1 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_1 +
            "(idUsuario INTEGER NOT NULL PRIMARY KEY, " +
            "nombre  TEXT NOT NULL, " +
            "apellidop  TEXT NOT NULL, "+
            "apellidom  TEXT NOT NULL, "+
            "usuario  TEXT NOT NULL, "+
            "password  TEXT NOT NULL, "+
            "correo TEXT NOT NULL);";




    //Crear tabla 2
    private static final String CREATE_TABLE_2 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_2 +
            "(idEvaluacion INTEGER NOT NULL PRIMARY KEY, " +
            "descripcion  TEXT NOT NULL);";

    //Insertar en la tabls 2
    private static final String INSERT_TABLE_2 =
            "INSERT INTO tbl_evaluacion SELECT 1,'Introduccion'" +
                    "UNION SELECT 2,'Fundamentos'" +
                    "UNION SELECT 3,'Literales y Constructores'" +
                    "UNION SELECT 4,'Funciones'" +
                    "UNION SELECT 5,'Patrones de creacion de objetos'" +
                    "UNION SELECT 6,'Patrones de la reutilizaciode codigo'"+
                    "UNION SELECT 7,'Patrones de diseno'"+
                    "UNION SELECT 8,'DOM y Patrones de navegador'";



    //Cear tabla 3
    private static final String CREATE_TABLE_3 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_3 +
            "(idPregunta INTEGER NOT NULL PRIMARY KEY, " +
            "pregunta  TEXT NOT NULL, " +
            "idEvaluacion INTEGER NOT NULL, " +
            "FOREIGN KEY (idEvaluacion) REFERENCES " +
            TABLE_NAME_2 + "(idEvaluacion));";



    //Insertar en la tabla 3
    private static final String INSERT_TABLE_3 =
            "INSERT INTO " + TABLE_NAME_3 +
                    " SELECT 1,'P1',1" +
                    " UNION SELECT 2,'P2',1" +
                    " UNION SELECT 3,'P3',1" +
                    " UNION SELECT 4,'P4',1" +
                    " UNION SELECT 5,'P5',1" +
                    " UNION SELECT 6,'P1',2" +
                    " UNION SELECT 7,'P2',2" +
                    " UNION SELECT 8,'P3',2" +
                    " UNION SELECT 9,'P4',2" +
                    " UNION SELECT 10,'P5',2" +
                    " UNION SELECT 11,'P1',3" +
                    " UNION SELECT 12,'P2',3" +
                    " UNION SELECT 13,'P3',3" +
                    " UNION SELECT 14,'P4',3" +
                    " UNION SELECT 15,'P5',3" +
                    " UNION SELECT 16,'P1',4" +
                    " UNION SELECT 17,'P2',4" +
                    " UNION SELECT 18,'P3',4" +
                    " UNION SELECT 19,'P4',4" +
                    " UNION SELECT 20,'P5',4" +
                    " UNION SELECT 21,'P1',5" +
                    " UNION SELECT 22,'P2',5" +
                    " UNION SELECT 23,'P3',5" +
                    " UNION SELECT 24,'P4',5" +
                    " UNION SELECT 25,'P5',5" +
                    " UNION SELECT 26,'P1',6" +
                    " UNION SELECT 27,'P2',6" +
                    " UNION SELECT 28,'P3',6" +
                    " UNION SELECT 29,'P4',6" +
                    " UNION SELECT 30,'P5',6" +
                    " UNION SELECT 31,'P1',7" +
                    " UNION SELECT 32,'P2',7" +
                    " UNION SELECT 33,'P3',7" +
                    " UNION SELECT 34,'P4',7" +
                    " UNION SELECT 35,'P5',7" +
                    " UNION SELECT 36,'P1',8" +
                    " UNION SELECT 37,'P2',8" +
                    " UNION SELECT 38,'P3',8" +
                    " UNION SELECT 39,'P4',8" +
                    " UNION SELECT 40,'P5',8" ;

    //Cear tabla 4
    private static final String CREATE_TABLE_4 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_4 +
            "(idUsuario INTEGER, " +
            "idEvaluacion INTEGER, " +
            "idPregunta INTEGER , " +
            "estadoPregunta BOOLEAN, " +
            "FOREIGN KEY (idUsuario) REFERENCES " +
            TABLE_NAME_1 + "(idUsuario)," +
            "FOREIGN KEY (idEvaluacion) REFERENCES " +
            TABLE_NAME_2 + "(idEvaluacion)," +
            "FOREIGN KEY (idPregunta) REFERENCES " +
            TABLE_NAME_3 + "(idPregunta)," +
            "PRIMARY KEY(idUsuario,idEvaluacion,idPregunta));";

    //Crear tabla 5
    private static final String CREATE_TABLE_5 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_5 +
            "(idUsuario INTEGER, " +
            "idEvaluacion INTEGER, " +
            "estadoEvaluacion BOOLEAN, " +
            "FOREIGN KEY (idUsuario) REFERENCES " +
            TABLE_NAME_1 + "(idUsuario)," +
            "FOREIGN KEY (idEvaluacion) REFERENCES " +
            TABLE_NAME_2 + "(idEvaluacion)," +
            "PRIMARY KEY (idUsuario,idEvaluacion));";

    public DBHelperUsuario(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    //Crear las tablas en la db
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_1);
        db.execSQL(CREATE_TABLE_2);
        db.execSQL(CREATE_TABLE_3);
        db.execSQL(CREATE_TABLE_4);
        db.execSQL(CREATE_TABLE_5);

        db.execSQL(INSERT_TABLE_2);
        db.execSQL(INSERT_TABLE_3);

    }

    //si ya existe la tabla se va a actualizar
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_1+";");
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_2+";");
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_3+";");
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_4+";");
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_5+";");
        onCreate(db);
    }
}
