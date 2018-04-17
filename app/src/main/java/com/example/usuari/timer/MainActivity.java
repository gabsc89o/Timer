package com.example.usuari.timer;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static TextView tvtiempo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvtiempo = (TextView)this.findViewById(R.id.tvTiempo);
    }

    @Override
    protected void onResume() {
        startService(new Intent(this,ServiceClock.class));
        super.onResume();
    }

    @Override
    protected void onPause() {
        stopService(new Intent(this,ServiceClock.class));
        super.onPause();
    }
    public static Handler manejador = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String resultado = (String) msg.obj;
            tvtiempo.setText(resultado);
        }
    };
}
