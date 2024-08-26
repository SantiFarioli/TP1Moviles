package com.santisoft.tp1traducir;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainActivityViewModel extends AndroidViewModel {
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public void envirPalabra(String palabra) {
        Intent intent = new Intent(getApplication(),TraducirIngles.class);
        intent.putExtra("palabra", palabra);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplication().startActivity(intent);


    }
}
