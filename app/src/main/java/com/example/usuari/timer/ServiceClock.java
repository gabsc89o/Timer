package com.example.usuari.timer;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.text.DateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ServiceClock extends Service {
    Timer timer;
    public ServiceClock() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        iniciarServicio();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }
    private void iniciarServicio(){
        timer = new Timer();
        timer.schedule(new MiTimer(),0,500);
    }
    private  class MiTimer extends TimerTask{

        @Override
        public void run() {
            Date d = new Date();
            DateFormat df = DateFormat.getTimeInstance(DateFormat.LONG);
                String resultado = df.format(d);
                MainActivity.manejador.obtainMessage(0,0,0,resultado).sendToTarget();

            }
        }
}
