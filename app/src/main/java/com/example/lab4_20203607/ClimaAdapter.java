package com.example.lab4_20203607;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4_20203607.entity.Clima;

import java.util.List;

public class ClimaAdapter extends RecyclerView.Adapter<ClimaAdapter.ClimaViewHolder>{



    private List<Clima> listaClima;
    private Context context;

    public List<Clima> getListaClima() {
        return listaClima;
    }

    public void setListaClima(List<Clima> listaClima) {
        this.listaClima = listaClima;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ClimaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.clima_rv, parent, false);
        return new ClimaViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ClimaViewHolder holder, int position) {
        Clima c = listaClima.get(position);
        holder.clima = c;

        TextView nombre = holder.itemView.findViewById(R.id.Nombre);
        nombre.setText(c.getName());

        TextView latitud = holder.itemView.findViewById(R.id.latitud);
        latitud.setText("Latitud: "+ c.getLat());

        TextView longitud = holder.itemView.findViewById(R.id.longitud);
        longitud.setText("Longitud: "+ c.getLon());


        Log.d("gage", "llega aca");

    }

    @Override
    public int getItemCount() {
        return listaClima.size();
    }


    public class ClimaViewHolder extends RecyclerView.ViewHolder{

        Clima clima;

        public ClimaViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}
