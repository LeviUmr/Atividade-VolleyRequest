package br.com.example.atividadevolley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView codigo,nome_do_titulo,tipo,locado;
    Button btnCarregaDados;

    String url_json = "http://192.168.1.2/Atividade-VolleyRequest/informacoes.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declaração dos objetos
        codigo = findViewById(R.id.txtCodigo);
        nome_do_titulo = findViewById(R.id.txtNome_do_titulo);
        tipo = findViewById(R.id.txtTipo);
        locado = findViewById(R.id.txtLocado);

        btnCarregaDados = findViewById(R.id.btnCarregaDados);

        btnCarregaDados.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url_json, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    //Os nomes recebidos pelo response.get deverá ter o mesmo nome dos campos da tabela php
                                    codigo.setText(response.getString("Codigo"));
                                    nome_do_titulo.setText(response.getString("Nome_do_titulo"));
                                    tipo.setText(response.getString("Tipo"));
                                    locado.setText(response.getString("Locado"));
                                } catch (JSONException e) {
                                    Toast.makeText(getApplicationContext(),
                                            "Nenhum nome encontrado...",
                                            Toast.LENGTH_SHORT).show();
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),
                                "Erro ao carregar as informações",
                                Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                });
                MySingleton.getInstance(MainActivity.this).addToRequestque(jsonObjectRequest);
            }
        });
    }
}