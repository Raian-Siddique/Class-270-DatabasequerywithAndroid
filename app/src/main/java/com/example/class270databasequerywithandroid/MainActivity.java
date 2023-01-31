package com.example.class270databasequerywithandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {


    EditText edQuery;
    Button bSearch;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edQuery= findViewById(R.id.edQuery);
        bSearch = findViewById(R.id.bSearch);
        tvDisplay = findViewById(R.id.tvDisplay);

        bSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               String url = "https://testbdraian.000webhostapp.com/apps/view.php?name="+ edQuery.getText().toString();

                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // response pailam, akhn response ta to app a dekhaite hbe
                        tvDisplay.setText(response.toString());


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();


                    }
                });

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(jsonArrayRequest);

//-----------------------------------------------------------
            }
        });



    }
}