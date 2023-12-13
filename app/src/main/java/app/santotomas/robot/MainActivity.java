package app.santotomas.robot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnIniciar = findViewById(R.id.btnIniciar);

        btnIniciar.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,SegundaActivity.class);
            startActivity(intent);
        });

    }
}