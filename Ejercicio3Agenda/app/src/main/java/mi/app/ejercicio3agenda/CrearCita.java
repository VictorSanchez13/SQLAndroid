package mi.app.ejercicio3agenda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CrearCita extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE Citas (id INTEGER PRIMARY KEY AUTOINCREMENT, Fecha TEXT, Hora TEXT, Asunto TEXT)";

    public CrearCita (Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version){
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Se elimina la versión anterior de la tabla
        //Ojo, haciendo esto eliminas también TODOS los registros, habría que pensar en un volcado previo.
        db.execSQL("DROP TABLE IF EXISTS Citas");

        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreate);
    }
}
