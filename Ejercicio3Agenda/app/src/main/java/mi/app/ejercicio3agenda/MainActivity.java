package mi.app.ejercicio3agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void newCitaClick(View view){
        Intent i = new Intent(this, newCita.class);
        startActivity(i);
    }

    public void delCitaClick(View view){
        Intent i = new Intent(this, delCita.class);
        startActivity(i);
    }

    public void viewCita(View view){
        Intent i = new Intent(this, viewCita.class);
        startActivity(i);
    }

    public void modCita(View view){
        Intent i = new Intent(this, modCita.class);
        startActivity(i);
    }
}