package com.example.workz;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

import com.example.workz.MainActivity;

public class ServiceActivity extends Service {

    Sensor sAcelerometro;
    int moveX=0;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

        MainActivity.mSensores = (SensorManager) getSystemService(SENSOR_SERVICE);
        sAcelerometro = MainActivity.mSensores.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        MainActivity.mSensores.registerListener(
                new Acelerometro(),
                sAcelerometro,
                SensorManager.SENSOR_DELAY_GAME
        );

        return START_STICKY;
    }

    class Acelerometro implements SensorEventListener{
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            double x = sensorEvent.values[0];



            Bundle pacote = new Bundle();
            pacote.putDouble("valorX", x);



            if(x<-15||x>15){
                moveX++;

            }


            if(moveX>10){
                moveX = 0;
                Intent iAbrir = getPackageManager().
                        getLaunchIntentForPackage("com.example.workz");
                iAbrir.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(iAbrir);
            }


        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    }

}
