package com.example.gerenciadorfn.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gerenciadorfn.R;
import com.example.gerenciadorfn.api.AppDataBase;
import com.example.gerenciadorfn.api.AppUtil;
import com.example.gerenciadorfn.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    EditText editUsuario,editSenha;
    Button btnLogin,btnCadastrar;
    CheckBox ckLembrar;

    Usuario usuario;
    SQLiteDatabase db;

    AppDataBase base;
    private SharedPreferences preferences;

    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);


        initFormulario();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario=editUsuario.getText().toString();
                String senha=editSenha.getText().toString();

                if(!usuario.equals("") && !senha.equals("")){
                    boolean res=base.ValidarUsuario(usuario,senha);
                    if(res) {
                        Toast.makeText(LoginActivity.this, "Bem vindo " + usuario, Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(LoginActivity.this,"Email ou senha incorretos",Toast.LENGTH_LONG).show();

                    }
                }else{
                    Toast.makeText(LoginActivity.this,"Preencha todos os campos",Toast.LENGTH_LONG).show();

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

        editUsuario=findViewById(R.id.editUsuario);
        editSenha=findViewById(R.id.editSenha);
        btnLogin=findViewById(R.id.btnLogin);
        btnCadastrar=findViewById(R.id.btnCadastrar);

        usuario = new Usuario();

        base = new AppDataBase(this);


    }
    private boolean validarDados(){

        boolean retorno = true;

        if(TextUtils.isEmpty(editUsuario.getText().toString())){
            editUsuario.setError("*");
            editUsuario.requestFocus();
            retorno=false;
        }
        if(TextUtils.isEmpty(editSenha.getText().toString())){
            editSenha.setError("*");
            editSenha.requestFocus();
            retorno=false;
        }

        return  retorno;
    }




}