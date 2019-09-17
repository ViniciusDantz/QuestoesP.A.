package mylockscreen.vdp.applogcat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botao = findViewById(R.id.botao);

        botao.setOnClickListener(this);

        if(getIntent().hasExtra("string")){
            String texto = getIntent().getExtras().getString("string");
            botao.setText(texto);
        }
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }
}
