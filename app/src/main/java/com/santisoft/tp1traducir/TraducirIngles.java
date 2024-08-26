package com.santisoft.tp1traducir;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.santisoft.tp1traducir.databinding.ActivityTraducirInglesBinding;

public class TraducirIngles extends AppCompatActivity {
    private ActivityTraducirInglesBinding binding;
    private TraducirInglesViewModel mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTraducirInglesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(TraducirInglesViewModel.class);

        mv.getmutablePalabra().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String palabra) {
                binding.tvTraducida.setText(palabra);
            }
        });

        mv.getMutableFoto().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer foto) {
                binding.imageView.setImageResource(foto);
            }
        });
        mv.traducir(getIntent());
    }
}