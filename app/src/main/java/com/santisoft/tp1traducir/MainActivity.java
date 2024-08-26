package com.santisoft.tp1traducir;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.santisoft.tp1traducir.databinding.ActivityMainBinding;



public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        binding.btTraducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String palabra = binding.etPalabra.getText().toString().trim();
                if(!palabra.isEmpty()) {
                    mv.envirPalabra(palabra);
                } else {
                    Toast.makeText(getApplication(), "Por favor ingresa una palabra", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}