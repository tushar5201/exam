package com.example.exam;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Data extends AppCompatActivity {

    TextView stockName, stockPrice;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        stockName = findViewById(R.id.stockName);
        stockPrice = findViewById(R.id.stockPrice);

        url = "https://real-time-finance-data.p.rapidapi.com/stock-time-series?symbol=SUZLON&period=1D&language=en";

//        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
////                    String price = String.valueOf(response.getJSONObject("data"));
//                    JSONObject data = new JSONObject(String.valueOf(response.getJSONObject("data")));
//                    String symbolName = data.getString("symbol");
//                    String symbolPrice = data.getString("price");
//
//                    stockName.setText(symbolName);
//                    stockPrice.setText(symbolPrice);
//                } catch (JSONException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        }){
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                HashMap headers = new HashMap();
//                headers.put("x-rapidapi-key", "c92e06d5c6mshfce3e7cdfaad84ap1f19dfjsn2f60255af180");
//                headers.put("x-rapidapi-host", "real-time-finance-data.p.rapidapi.com");
//
//                return  headers;
//            }
//        };
//
//        Volley.newRequestQueue(Data.this).add(req);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
//                    String price = String.valueOf(response.getJSONObject("data"));
                            JSONObject data = new JSONObject(String.valueOf(response.getJSONObject("data")));
                            String symbolName = data.getString("symbol");
                            String symbolPrice = data.getString("price");

                            stockName.setText(symbolName);
                            stockPrice.setText(symbolPrice);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap headers = new HashMap();
                        headers.put("x-rapidapi-key", "c92e06d5c6mshfce3e7cdfaad84ap1f19dfjsn2f60255af180");
                        headers.put("x-rapidapi-host", "real-time-finance-data.p.rapidapi.com");

                        return  headers;
                    }
                };

                Volley.newRequestQueue(Data.this).add(req);
            }
        }, 1000);
    }
}