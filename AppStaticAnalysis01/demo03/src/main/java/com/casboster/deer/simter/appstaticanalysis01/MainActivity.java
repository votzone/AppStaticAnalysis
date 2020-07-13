package com.casboster.deer.simter.appstaticanalysis01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity {
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(getBaseContext());
        requestQueue.add(stringRequest);
        requestQueue.start();
    }

    /**
     * StringRequest请求，默认为GET
     */
    public StringRequest stringRequest = new StringRequest("http://www.baidu.com", new Response.Listener<String>() {

        @Override
        public void onResponse(String response) {
            Toast.makeText(getBaseContext(), response, Toast.LENGTH_SHORT).show();
        }

    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError volleyError) {
            Toast.makeText(getBaseContext(), volleyError.toString(), Toast.LENGTH_SHORT).show();
        }
    });
}
