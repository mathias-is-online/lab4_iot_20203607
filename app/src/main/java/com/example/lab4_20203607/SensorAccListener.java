package com.example.lab4_20203607;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

public class SensorAccListener implements SensorEventListener {


    private AppActivity mActivity;
    public void setAppActivity(AppActivity activity) {
        mActivity = activity;
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int sensorType = sensorEvent.sensor.getType();

        if(sensorType == Sensor.TYPE_ACCELEROMETER){
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];



            double aceleracion = Math.sqrt(x*x + y*y + z*z);
            if (aceleracion > 15) {
                mActivity.mostrarAlerta();
            }


        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
