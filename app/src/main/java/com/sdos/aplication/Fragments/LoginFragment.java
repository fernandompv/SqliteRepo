package com.sdos.aplication.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.sdos.aplication.R;

public class LoginFragment extends Fragment {

    private Button mInicioSesion;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login,container,false);
    }

    @Override
    public void onResume() {
        initializeComponent();
        listenerFragment();
        super.onResume();
    }

    private void initializeComponent(){
        mInicioSesion = getActivity().findViewById(R.id.bt_InicioSesión);
    }

    private void listenerFragment(){
        mInicioSesion.setOnClickListener(view -> {
            initTable();
        });
    }

    private void initTable(){
        //Lanzamos el fragment siguiente para que aparezcala tabla con los valores
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_layout, new TableFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
