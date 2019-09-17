package mylockscreen.vdp.applogcat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    Button botao2;
    EditText edittxt;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        botao2 = findViewById(R.id.botao2);
        edittxt = findViewById(R.id.edit);
        txtView = findViewById(R.id.textview);

        botao2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(edittxt.length() < 2){
            txtView.setVisibility(View.VISIBLE);
        }else{
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("string", edittxt.getText().toString());
            Log.i("String para activity: ", edittxt.getText().toString());
            startActivity(i);
        }
    }
}
