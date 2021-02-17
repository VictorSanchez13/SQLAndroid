package mi.app.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void newClienteClick(View view){
        Intent i = new Intent(this, formCliente.class);
        startActivity(i);

    }

    public void newFacturaClick(View view){
        Intent i = new Intent(this, formFactura.class);
        startActivity(i);

    }

    public void consFacturaClick(View view){
        Intent i = new Intent(this, ConsultarFacturas.class);
        startActivity(i);

    }

}