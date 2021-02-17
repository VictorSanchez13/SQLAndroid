package mi.app.ejercicio3agenda;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class newCita extends AppCompatActivity {
    CrearCita crearCita;
    SQLiteDatabase dbCitas;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_cita);

        crearCita = new CrearCita(this, "DBCitas", null, 1);
        dbCitas = crearCita.getWritableDatabase();
    }

    public void createDate(View view){
        Toast.makeText(this, nuevaCita()?"Nueva cita añadida": "No se puedo añadir la cita", Toast.LENGTH_LONG).show();
    }

    public boolean nuevaCita(){
        EditText date = (EditText)findViewById(R.id.dateTxt);
        String fecha = date.getText().toString();

        EditText time = (EditText)findViewById(R.id.timeTxt);
        String hora = time.getText().toString();

        EditText text = (EditText) findViewById(R.id.asuntoTxt);
        String asunto = text.getText().toString();


        Cursor c = dbCitas.rawQuery("SELECT * FROM Citas WHERE Fecha = '"+fecha+"' AND Hora = '"+hora+"'", null);//Comprobamos si esxiste el registro

        if(!c.moveToFirst()){
            dbCitas.execSQL("INSERT INTO Citas(Fecha, Hora, Asunto) VALUES ('"+fecha+"', '"+hora+"', '"+asunto+"')");
            return true;
        }
        else{
            Toast.makeText(this, "YA EXISTE LA CITA", Toast.LENGTH_SHORT).show();
        }


        return false;

    }
}
