package com.Matheus.ModularPAMIGravareRecuparerDados;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button gravar, recuperar;
    EditText nome,idade,telefone,email;
    TextView mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

      initComponent();

        nome.requestFocus();

        gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("chavegeral.xml", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("chaveNome", nome.getText().toString());
                editor.putString("chaveIdade", idade.getText().toString());
                editor.putString("chaveTelefone", telefone.getText().toString());
                editor.putString("chaveEmail", email.getText().toString());
                editor.commit();
                Toast.makeText(MainActivity.this,"Gravado com Sucesso", Toast.LENGTH_SHORT)
                        .show();
            }
        });
        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome,idade,telefone,email;
                SharedPreferences prefs = getSharedPreferences("chavegeral.xml",MODE_PRIVATE);

                nome=prefs.getString("chaveNome","");
                idade=prefs.getString("chaveIdade","");
                telefone=prefs.getString("chaveTelefone","");
                email=prefs.getString("chaveEmail","");

                mensagem.setText(nome+"\n"+idade+"\n"+telefone+"\n"+email);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initComponent() {
        gravar = findViewById(R.id.gravar);
        recuperar = findViewById(R.id.recuperar);
        nome = findViewById(R.id.nome);
        idade = findViewById(R.id.idade);
        telefone = findViewById(R.id.telefone);
        mensagem = findViewById(R.id.mensagem);
        email = findViewById(R.id.email);

    }
}