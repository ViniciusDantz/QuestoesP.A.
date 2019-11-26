package com.vdp.atividadespa_alone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    TextView txt1;
    TextView txt2;
    Button butao2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        butao2 = findViewById(R.id.butao2);

        Intent i = getIntent();
        Produto produto = i.getParcelableExtra("produto");

        txt1.setText(produto.getDescricao());
        String precoTotal= ""+ (produto.getQuantidade() * produto.getValorUni());
        txt2.setText(precoTotal);
        butao2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
