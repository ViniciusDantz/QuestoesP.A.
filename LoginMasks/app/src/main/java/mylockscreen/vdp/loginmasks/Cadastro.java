package mylockscreen.vdp.loginmasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cadastro extends AppCompatActivity implements View.OnClickListener {

    Button botao2;
    EditText edttxt1;
    EditText edttxt2;
    EditText edttxt3;
    TextView txtview;
    TextView txtUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        botao2 = findViewById(R.id.butao2);
        edttxt1 = findViewById(R.id.edtcpf);
        edttxt2 = findViewById(R.id.edtnome);
        edttxt3 = findViewById(R.id.edtemail);
        txtview = findViewById(R.id.erro2);
        txtUser = findViewById(R.id.txtUser);

        botao2.setOnClickListener(this);
        if(getIntent().hasExtra("user")){
            txtUser.setText("Bem vindo "+ getIntent().getExtras().getString("user")+ "!");
        }
    }

    @Override
    public void onClick(View view) {

    }
}
