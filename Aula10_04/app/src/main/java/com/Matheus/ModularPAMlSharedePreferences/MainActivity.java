package com.Matheus.ModularPAMlSharedePreferences;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.Matheus.ModularPAMlSharedePreferences.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AnotacaoPreferencias preferencias = new AnotacaoPreferencias (MainActivity.this);
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoRecuperado = binding.editTextText.getText().toString();
            if (textoRecuperado.equals("")){
                Snackbar.make(binding.getRoot(), "Preencha a anotao", Snackbar.LENGTH_LONG).show();
            }else{
                preferencias.salvarPreferencias(textoRecuperado);
                Snackbar.make(binding.getRoot(), "Anotacao Salva", Snackbar.LENGTH_LONG).show();
            }
                Snackbar.make(binding.getRoot(),"Clicou no batao", Snackbar.LENGTH_LONG).
                setAnchorView(R.id.floatingActionButton).
                        setAction("Action", null).show();


            }
        });




    }
}