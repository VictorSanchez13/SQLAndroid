package mi.app.ejercicio3agenda;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class viewCita extends AppCompatActivity {
    CrearCita crearCita;
    SQLiteDatabase dbCitas;

    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_cita);

        crearCita = new CrearCita(this, "DBCitas", null, 1);
        dbCitas = crearCita.getWritableDatabase();

    }

    public void viewCitaClick (View view){
        EditText date = (EditText)findViewById(R.id.viewDate);
        String fecha = date.getText().toString();

        EditText time = (EditText)findViewById(R.id.viewTime);
        String hora = time.getText().toString();

        Cursor c = dbCitas.rawQuery("SELECT * FROM Citas WHERE Fecha = '"+fecha+"' AND Hora = '"+hora+"'",null);

        if(c.moveToFirst()){
            TextView t8 = (TextView)findViewById(R.id.textView8);
            t8.setEnabled(true);

            TextView t10 = (TextView)findViewById(R.id.textView10);
            t10.setEnabled(true);

            TextView id = (TextView)findViewById(R.id.numCitaTxt);
            id.setText(c.getString(0));

            TextView asunto = (TextView)findViewById(R.id.asuntoCitaTxt);
            asunto.setText(c.getString(3));
        }
        else
        {
            TextView t8 = (TextView)findViewById(R.id.textView8);
            t8.setEnabled(false);

            TextView t10 = (TextView)findViewById(R.id.textView10);
            t10.setEnabled(false);

            TextView id = (TextView)findViewById(R.id.numCitaTxt);
            id.setText("");

            TextView asunto = (TextView)findViewById(R.id.asuntoCitaTxt);
            asunto.setText("");

            Toast.makeText(this, "NO EXISTE LA CITA", Toast.LENGTH_SHORT).show();
        }
    }
}
