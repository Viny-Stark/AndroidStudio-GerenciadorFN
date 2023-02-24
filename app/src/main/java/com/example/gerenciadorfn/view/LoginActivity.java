package com.example.gerenciadorfn.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gerenciadorfn.R;
import com.example.gerenciadorfn.api.AppDataBase;
import com.example.gerenciadorfn.api.AppUtil;
import com.example.gerenciadorfn.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    EditText editEmailLogin,editSenhaL;
    Button btnLogin,btnCadastrar;

    Usuario usuario;

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initFormulario();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validarDados() ) {


                    if (validarDadosDoUsuario()) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        return;
                    }else{
                        Toast.makeText(LoginActivity.this,
                                "Senha ou Email não conferem",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginActivity.this,CadastroUsuarioActivity.class);
                startActivity(intent);
                return;
            }
        });
    }

    private void initFormulario() {

        editEmailLogin=findViewById(R.id.editEmailLogin);
        editSenhaL=findViewById(R.id.editSenhaL);
        btnLogin=findViewById(R.id.btnLogin);
        btnCadastrar=findViewById(R.id.btnCadastrar);

        usuario = new Usuario();

        restaurarSharedPreferences();



    }

    private boolean validarDados(){

        boolean retorno = true;

        if(TextUtils.isEmpty(editEmailLogin.getText().toString())){
            editEmailLogin.setError("*");
            editEmailLogin.requestFocus();
            retorno=false;
        }
        if(TextUtils.isEmpty(editSenhaL.getText().toString())){
            editSenhaL.setError("*");
            editSenhaL.requestFocus();
            retorno=false;
        }

        return  retorno;
    }
    public boolean validarDadosDoUsuario() {

        boolean retorno = false;

        // comparar as senhas

        String senhaDigitadaPura = editSenhaL.getText().toString();
        String senhaMD5 = usuario.getSenha();

        if(senhaMD5.equals((senhaDigitadaPura))){
            retorno = true;
        }


        return retorno;

    }
    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.LOG_APP, MODE_PRIVATE);

        usuario.setEmail(preferences.getString("email", "teste@teste.com"));
        usuario.setSenha(preferences.getString("senha", "12345"));




    }


}