package com.santisoft.tp1traducir;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.santisoft.tp1traducir.modelo.Palabra;

import java.util.ArrayList;

public class TraducirInglesViewModel extends AndroidViewModel {
    private ArrayList<Palabra> lista;
    private MutableLiveData<String> mutablePalabra;
    private MutableLiveData<Integer> mutableFoto;

    public TraducirInglesViewModel(@NonNull Application application) {
        super(application);
        lista = new ArrayList<>();
        lista.add(new Palabra("Casa","House", R.drawable.casa));
        lista.add(new Palabra("Fiesta","Party", R.drawable.fiesta));
        lista.add(new Palabra("Pelota","Ball", R.drawable.pelota));
        lista.add(new Palabra("Pescar","Fishing", R.drawable.pescar));
        lista.add(new Palabra("Viaje", "Travel", R.drawable.viaje));
    }

    public LiveData<String> getmutablePalabra(){
        if (mutablePalabra == null){
            mutablePalabra = new MutableLiveData<>();
        }
        return mutablePalabra;
    }

    public LiveData<Integer> getMutableFoto() {
        if (mutableFoto == null) {
            mutableFoto = new MutableLiveData<>();
        }
        return mutableFoto;
    }

    public void traducir(Intent intent) {
        String palabra = intent.getStringExtra("palabra");
        mutablePalabra.setValue("Palabra no encontada");
        mutableFoto.setValue(R.drawable.error);
        for (Palabra p : lista) {
            if (p.getEspaniol().equalsIgnoreCase(palabra)){
                mutablePalabra.setValue(p.getIngles());
                mutableFoto.setValue(p.getFoto());

            }
          }
        }
    }
