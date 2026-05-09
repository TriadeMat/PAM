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
                String nome1,idade1,telefone1,email1;
                SharedPreferences prefs = getSharedPreferences("chavegeral.xml",MODE_PRIVATE);

                nome1=prefs.getString("chaveNome","");
                idade1=prefs.getString("chaveIdade","");
                telefone1=prefs.getString("chaveTelefone","");
                email1=prefs.getString("chaveEmail","");

                mensagem.setText(nome1+"\n"+idade1+"\n"+telefone1+"\n"+email1);
                nome.setText(nome1);
                telefone.setText(telefone1);
                idade.setText(idade1);
                email.setText(email1);
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