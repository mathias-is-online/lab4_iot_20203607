package com.example.lab4_20203607;

import static android.content.ContentValues.TAG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4_20203607.entity.Clima;
import com.example.lab4_20203607.retrofithelpers.ClimaService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppActivity extends AppCompatActivity{

    ClimaService climaService;

    private List<Clima> listaClima;

    SensorManager mSensorManager;

    SensorAccListener listener = new SensorAccListener();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.appactivity);

        Map<String, String> localNames = new HashMap<>();
        listaClima = new ArrayList<>();
        Clima clima1 = new Clima("Lima", localNames, -12.0621065, -77.0365256, "PE", "Lima");
        listaClima.add(clima1);


        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        //cargarListaClima();

    }

    @Override
    protected void onResume() {
        super.onResume();

        Sensor mAcc = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(listener,mAcc,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop() {
        super.onStop();

        mSensorManager.unregisterListener(listener);
    }


    public void mostrarAlerta() {
        runOnUiThread(() -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Tu teléfono está experimentando una aceleración mayor a 15m/s^2");
            builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }















    public void createRetrofitServiceClima() {
        climaService = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ClimaService.class);
    }


    public void cargarListaWebService(String ciudad) {

        climaService.getClima(ciudad, 1, "8dd6fc3be19ceb8601c2c3e811c16cf1").enqueue(new Callback<List<Clima>>() {
            @Override
            public void onResponse(Call<List<Clima>> call, Response<List<Clima>> response) {
                if (response.isSuccessful()) {
                    List<Clima> climaobtenido = response.body();
                    // Procesar la lista de climas
                    if (climaobtenido != null && !climaobtenido.isEmpty()) {
                        Clima clima = listaClima.get(0);
                        // Procesar el objeto de clima
                        listaClima.add(clima);
                    } else {
                        Log.e(TAG, "Lista de climas vacía");
                    }
                } else {
                    Log.e(TAG, "Error en la respuesta: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Clima>> call, Throwable t) {
                Log.e(TAG, "Error en la solicitud: " + t.getMessage());
            }
        });


    }


    public void cargarListaClima() {
        ClimaAdapter climaAdapter = new ClimaAdapter();

        climaAdapter.setListaClima(listaClima);
        for (Clima i:listaClima){
            Log.d("hola",i.getName());
        }
        climaAdapter.setContext(AppActivity.this);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setAdapter(climaAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(AppActivity.this));
    }



}
