package com.example.gerenciadorfn.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gerenciadorfn.R;
import com.example.gerenciadorfn.api.AppUtil;
import com.example.gerenciadorfn.controller.UsuarioController;
import com.example.gerenciadorfn.model.Usuario;

public class CadastroUsuarioActivity extends AppCompatActivity {

    EditText editNomeCompleto,editCpf,editNomeEmpresa,editCnpj,editEmail,editSenha;

    Button btnCadastro,btnVoltar;
    CheckBox ckTermos;

    Usuario usuarioNovo;

    UsuarioController controller;

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        initFormulario();



        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (dadosOk()){


                        usuarioNovo.setNomeCompleto(editNomeCompleto.getText().toString());
                        usuarioNovo.setCpf(editCpf.getText().toString());
                        usuarioNovo.setNomeDaEmpresa(editNomeEmpresa.getText().toString());
                        usuarioNovo.setCnpj(editCnpj.getText().toString());
                        usuarioNovo.setEmail(editEmail.getText().toString());
                        usuarioNovo.setSenha(editSenha.getText().toString());

                        controller.incluir(usuarioNovo);

                        salvarSharedPreferences();

                        Intent intent = new Intent(CadastroUsuarioActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                }
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(CadastroUsuarioActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ckTermos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alerta =new AlertDialog.Builder(CadastroUsuarioActivity.this);
                alerta.setTitle("Termos de USO");
                alerta
                        .setMessage("Concorda com o termo sei la 123 69?")
                        .setCancelable(false)
                        .setNegativeButton("Discordo", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(),
                                        "E preciso CONCORDA para continuar o cadastro",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("Concordo", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Toast.makeText(getApplicationContext(), "Concordo escolhido", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alertDialog = alerta.create();
                alertDialog.show();

            }

        });

    }

    private boolean dadosOk() {

        boolean retorno= true;
        if(TextUtils.isEmpty(editNomeCompleto.getText().toString())){
            editNomeCompleto.setError("*");
            editNomeCompleto.requestFocus();
            retorno =false;
        }
        if(TextUtils.isEmpty(editCpf.getText().toString())){
            editCpf.setError("*");
            editCpf.requestFocus();
            retorno =false;
        }
        if(TextUtils.isEmpty(editNomeEmpresa.getText().toString())){
            editNomeEmpresa.setError("*");
            editNomeEmpresa.requestFocus();
            retorno =false;
        }
        if(TextUtils.isEmpty(editCnpj.getText().toString())){
            editCnpj.setError("*");
            editCnpj.requestFocus();
            retorno =false;
        }
        if(TextUtils.isEmpty(editEmail.getText().toString())){
            editEmail.setError("*");
            editEmail.requestFocus();
            retorno =false;
        }
        if(TextUtils.isEmpty(editSenha.getText().toString())){
            editSenha.setError("*");
            editSenha.requestFocus();
            retorno =false;
        }
        if (!ckTermos.isChecked()) {
            ckTermos.setError("E Necessario Aceitar os Termos de Uso");
            ckTermos.requestFocus();
            retorno= false;
        }
        return retorno;
    }

    private void initFormulario() {

        editNomeCompleto = findViewById(R.id.editNomeCompleto);
        editCpf = findViewById(R.id.editCpf);
        editNomeEmpresa = findViewById(R.id.editNomeEmpresa);
        editCnpj = findViewById(R.id.editCnpj);
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        btnCadastro = findViewById(R.id.btnCadastro);
        btnVoltar = findViewById(R.id.btnVoltar);
        ckTermos = findViewById(R.id.ckTermos);

        usuarioNovo = new Usuario();

        controller = new UsuarioController(this);
    }
    public void validarTermo(View view) {

        if (!ckTermos.isChecked()) {

            Toast.makeText(getApplicationContext(),
                    "É nessário aceitar os termos de uso para continuar o cadastro...",
                    Toast.LENGTH_LONG).show();
        }

    }
    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.LOG_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putString("email",editEmail.getText().toString());
        dados.putString("senha",editSenha.getText().toString());
        dados.apply();

    }


}