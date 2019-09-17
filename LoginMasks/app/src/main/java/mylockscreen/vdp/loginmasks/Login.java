package mylockscreen.vdp.loginmasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button botao;
    EditText edttxt1;
    EditText edttxt2;
    TextView txtview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        botao = findViewById(R.id.btnlogin);
        edttxt1 = findViewById(R.id.usuarioedt);
        edttxt2 = findViewById(R.id.senhaedt);
        txtview = findViewById(R.id.erro);

        botao.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(edttxt1.equals("senai") == false || edttxt2.equals("senai") == false){
            txtview.setVisibility(View.VISIBLE);
        }else{
            Intent i = new Intent(this, Cadastro.class);
            i.putExtra("user", edttxt1.getText());
            startActivity(i);
        }
    }
}
