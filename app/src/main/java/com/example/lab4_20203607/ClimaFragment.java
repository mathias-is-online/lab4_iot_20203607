package com.example.lab4_20203607;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.lab4_20203607.databinding.FragmentClimaBinding;
import com.example.lab4_20203607.entity.Clima;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClimaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClimaFragment extends Fragment {

    private List<Clima> listaClima;
    AppActivity mActivity;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof AppActivity) {
            mActivity = (AppActivity) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement AppActivity");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mActivity.activarMagnetometro();
    }

    @Override
    public void onStop() {
        super.onStop();
        mActivity.desactivarMagnetometro();
    }












    private TextView textViewDireccionViento;

    FragmentClimaBinding binding;
    private NavController navController;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ClimaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClimaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClimaFragment newInstance(String param1, String param2) {
        ClimaFragment fragment = new ClimaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentClimaBinding.inflate(inflater, container, false);

        textViewDireccionViento = binding.direccionviento;

        binding.button1.setOnClickListener(view -> {

            NavController navController = NavHostFragment.findNavController(ClimaFragment.this);
            navController.navigate(R.id.action_climaFragment1_to_geoFragment1);
        });




        return binding.getRoot();

    }


    public void actualizarDireccionViento(String direccionViento) {
        // Actualizar el TextView con la dirección del viento recibida
        if (textViewDireccionViento != null) {
            textViewDireccionViento.setText("Dirección del viento: " + direccionViento);
        }
    }






}