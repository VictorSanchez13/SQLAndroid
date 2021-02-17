package mi.app.ejercicio3agenda;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class modCita extends AppCompatActivity {
    CrearCita crearCita;
    SQLiteDatabase dbCitas;
    String fecha, hora;

    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mod_cita);

        crearCita = new CrearCita(this, "DBCitas", null, 1);
        dbCitas = crearCita.getWritableDatabase();

    }

    public void modCitaClick (View view){
        EditText date = (EditText)findViewById(R.id.viewDate);
        fecha = date.getText().toString();

        EditText time = (EditText)findViewById(R.id.viewTime);
        hora = time.getText().toString();

        Cursor c = dbCitas.rawQuery("SELECT Asunto FROM Citas WHERE Fecha = '"+fecha+"' AND Hora = '"+hora+"'",null);

        if(c.moveToFirst()){

            TextView t10 = (TextView)findViewById(R.id.textView10);
            t10.setEnabled(true);

            EditText asunTxt = (EditText)findViewById(R.id.asuntoTexto);
            asunTxt.setEnabled(true);
            asunTxt.setText(c.getString(0));

            Button btn = (Button)findViewById(R.id.modBtn);
            btn.setEnabled(true);

        }
        else
        {
            TextView t10 = (TextView)findViewById(R.id.textView10);
            t10.setEnabled(false);
            EditText asunTxt = (EditText)findViewById(R.id.asuntoTexto);
            asunTxt.setEnabled(false);
            Button btn = (Button)findViewById(R.id.modBtn);
            btn.setEnabled(true);

            Toast.makeText(this, "NO EXISTE LA CITA", Toast.LENGTH_SHORT).show();
        }
    }

    public void modificarCita (View view){
        EditText asunTxt = (EditText)findViewById(R.id.asuntoTexto);
        String asunto = asunTxt.getText().toString();

        dbCitas.execSQL("UPDATE Citas SET Asunto = '"+asunto+"' WHERE Fecha = '"+fecha+"' AND Hora = '"+hora+"'");

        Cursor res = dbCitas.rawQuery("SELECT * FROM Citas WHERE Asunto = '"+asunto+"'", null);

        if(res.moveToFirst()){
            Toast.makeText(this, "Modificado con exito", Toast.LENGTH_SHORT).show();
            asunTxt.setText("");
            asunTxt.setEnabled(false);

            Button btn = (Button)findViewById(R.id.modBtn);
            btn.setEnabled(false);
        }
        else{
            Toast.makeText(this, "No se pudo modificar", Toast.LENGTH_SHORT).show();
        }
    }
}
