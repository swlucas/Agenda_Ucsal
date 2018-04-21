package br.ucsal.agendaucsal;

import android.content.Intent;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = this.findViewById(R.id.list_view_agendamentos);

        final ArrayList<String> list_agendamento = new ArrayList<String>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list_agendamento);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,DetalheAgendamento.class);
                intent.putExtra("list_agendamento",list_agendamento.get(i));
                startActivity(intent);
            }
        });



        client = new AsyncHttpClient();
        client.get("https://raw.githubusercontent.com/swlucas/cantoresJson/master/teste", new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("AsyncHttpClient","response = " + responseString);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("AsyncHttpClient","response = " + responseString);
                Gson gson = new GsonBuilder().create();
                Agendamento[] agendamentos = gson.fromJson(responseString,Agendamento[].class);
                adapter.clear();
                for(Agendamento agendamento:agendamentos){
                    adapter.add(agendamento.getAssunto());
                }
            }
        });
    }

    
}
