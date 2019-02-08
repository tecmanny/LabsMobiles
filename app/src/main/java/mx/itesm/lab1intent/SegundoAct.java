package mx.itesm.lab1intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SegundoAct extends AppCompatActivity {
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        tv2 = (TextView)findViewById(R.id.tv2);
        String dato = getIntent().getStringExtra("dato");
        tv2.setText("Hola " + dato);

    }


    //botonAnt

    public void regresar (View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}
