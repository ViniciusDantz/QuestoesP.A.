package com.vdp.atividadespa_alone;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewUser extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.recycleview);

        rv = findViewById(R.id.rv);

        UsuarioAdapter adapter = new UsuarioAdapter(this);

        rv.setAdapter(adapter);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this);
        rv.setLayoutManager(layout);
    }
}
