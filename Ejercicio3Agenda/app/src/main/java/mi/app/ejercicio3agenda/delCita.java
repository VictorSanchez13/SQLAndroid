package mi.app.ejercicio3agenda;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class delCita extends AppCompatActivity {

    CrearCita crearCita;
    SQLiteDatabase dbCitas;

    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.del_cita);
        crearCita = new CrearCita(this, "DBCitas", null, 1);
        dbCitas = crearCita.getWritableDatabase();

    }

    public void deleteDate(View view){

        Toast.makeText(this, borrarCita()?"Cita eliminada con éxito": "No se pudo borrar la cita", Toast.LENGTH_SHORT).show();
    }

    public boolean borrarCita(){
        Button btn = (Button)findViewById(R.id.deleteCita);

        EditText date = (EditText) findViewById(R.id.delDate);
        String fecha = date.getText().toString();

        EditText time = (EditText)findViewById(R.id.delTime);
        String hora = time.getText().toString();

        Cursor c = dbCitas.rawQuery("SELECT * FROM Citas WHERE Fecha = '"+fecha+"' AND Hora = '"+hora+"'", null);

        if (c.moveToFirst()){//Existe el registro

            dbCitas.execSQL("DELETE FROM Citas WHERE Fecha = '"+fecha+"' AND Hora = '"+hora
                    +"'");
            return true;
        }
        return false;
    }
}
