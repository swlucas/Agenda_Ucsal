package br.ucsal.agendaucsal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheAgendamento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_agendamento);

        TextView textView = findViewById(R.id.detalhe_1);

        String list_produto = getIntent().getStringExtra("list_agendamento");
        textView.setText(list_produto.toString());

    }
}
