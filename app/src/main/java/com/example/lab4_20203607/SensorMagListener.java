package com.example.lab4_20203607;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class SensorMagListener implements SensorEventListener{
    private AppActivity mActivity;

    public SensorMagListener(AppActivity activity) {
        mActivity = activity;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] magValues = event.values;

        float x = magValues[0];
        float y = magValues[1];

        // Calcular la orientación y, por lo tanto, la dirección del viento
        String direccionViento = calcularDireccionViento(x, y);

        // Actualizar la interfaz de usuario con la dirección del viento calculada
        mActivity.actualizarDireccionViento(direccionViento);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // No es necesario hacer nada aquí para este caso
    }

    private String calcularDireccionViento(float x, float y) {
        // Analizar los valores de los ejes X e Y para determinar la orientación y, por lo tanto, la dirección del viento
        if (x > 0 && y > 0) {
            return "Noreste";
        } else if (x > 0 && y < 0) {
            return "Sureste";
        } else if (x < 0 && y > 0) {
            return "Noroeste";
        } else if (x < 0 && y < 0) {
            return "Suroeste";
        } else if (x > 0 && y == 0) {
            return "Este";
        } else if (x < 0 && y == 0) {
            return "Oeste";
        } else if (x == 0 && y > 0) {
            return "Norte";
        } else if (x == 0 && y < 0) {
            return "Sur";
        } else {
            return "Desconocida";
        }
    }
}

