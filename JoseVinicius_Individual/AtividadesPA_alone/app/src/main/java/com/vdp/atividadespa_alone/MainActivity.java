package com.vdp.atividadespa_alone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Produto produto;
    EditText edtTxt1;
    EditText edtTxt2;
    EditText edtTxt3;
    TextView txtAlert;
    Button butao;
    Button butao3;
    Button toList;
    Button botao2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        edtTxt1 = findViewById(R.id.edtTxt1);
        edtTxt2 = findViewById(R.id.edtTxt2);
        edtTxt3 = findViewById(R.id.edtTxt3);
        butao = findViewById(R.id.butao);
        txtAlert = findViewById(R.id.txtAlert);
        butao3 = findViewById(R.id.butao3);
        toList = findViewById(R.id.tolistview);
        botao2 = findViewById(R.id.botao2);

        butao.setOnClickListener(this);
        botao2.setOnClickListener(this);
        butao3.setOnClickListener(this);
        toList.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(butao.getId() == view.getId()) {
            if (edtTxt1.getText().length() < 3 ||
                    edtTxt2.getText().length() < 1 ||
                    edtTxt2.getText().equals("0") ||
                    edtTxt3.getText().length() < 1 ||
                    edtTxt3.getText().equals("0")) {
                txtAlert.setVisibility(View.VISIBLE);
                butao3.setVisibility(View.VISIBLE);
            } else {
                produto = new Produto(edtTxt1.getText().toString(),
                        Integer.parseInt(edtTxt2.getText().toString()),
                        Double.parseDouble(edtTxt3.getText().toString()));
                Intent i = new Intent(this, Main2Activity.class);
                i.putExtra("produto", produto);
                startActivity(i);
            }
        }
        if(butao3.getId() == view.getId()){
            txtAlert.setVisibility(View.INVISIBLE);
            butao3.setVisibility(View.INVISIBLE);
        }
        if(toList.getId() == view.getId()){
            Intent i = new Intent(this, ListViewUsers.class);
            startActivity(i);
        }
        if(botao2.getId() == view.getId()){
            Intent i = new Intent(this, RecyclerViewUser.class);
            startActivity(i);
        }
    }
}
