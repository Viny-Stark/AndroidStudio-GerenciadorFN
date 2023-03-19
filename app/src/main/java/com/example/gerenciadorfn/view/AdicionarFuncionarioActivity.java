package com.example.gerenciadorfn.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gerenciadorfn.R;
import com.example.gerenciadorfn.controller.FuncionarioController;
import com.example.gerenciadorfn.model.Funcionario;

public class AdicionarFuncionarioActivity extends AppCompatActivity {

    EditText editNome,editSobrenome,editFuncao,editSalario,editTelefone,editEmail;
    

    Button btnCadastro,btnVoltar;

    Boolean isFormularioOk;

    FuncionarioController controller;

    Funcionario funcionarioNovo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_adicionar_funcionario);
        
        initFormulario();

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validarFormulario()){

                        funcionarioNovo.setNome(editNome.getText().toString());
                        funcionarioNovo.setSobrenome(editSobrenome.getText().toString());
                        funcionarioNovo.setFuncao(editFuncao.getText().toString());
                        funcionarioNovo.setSalario(editSalario.getText().toString());
                        funcionarioNovo.setTelefone(editTelefone.getText().toString());
                        funcionarioNovo.setEmail(editEmail.getText().toString());

                        controller.incluir(funcionarioNovo);

                    Intent intent=new Intent(AdicionarFuncionarioActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                }
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder =new AlertDialog.Builder(AdicionarFuncionarioActivity.this);

                builder.setTitle("Deseja mesmo Voltar?");
                builder.setMessage("Voltar ao Menu Principal");
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent IntVoltar= new Intent(AdicionarFuncionarioActivity.this,MainActivity.class);
                        startActivity(IntVoltar);
                        return;
                    }
                });
                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(getApplicationContext(),
                                "Continue o Cadastro!",
                                Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });




        
    }
    private void initFormulario() {

        editNome=findViewById(R.id.editNome);
        editSobrenome=findViewById(R.id.editSobrenome);
        editFuncao=findViewById(R.id.editFuncao);
        editSalario=findViewById(R.id.editSalario);
        editTelefone=findViewById(R.id.editTelefone);
        editEmail=findViewById(R.id.editEmail);
        btnCadastro=findViewById(R.id.btnCadastro);
        btnVoltar=findViewById(R.id.btnVoltar);

        isFormularioOk = false;

        funcionarioNovo=new Funcionario();

        controller=new FuncionarioController(this);

    }
    private boolean validarFormulario() {

        boolean retorno = true;

        if (TextUtils.isEmpty(editNome.getText().toString())) {
            editNome.setError("*");
            editNome.requestFocus();
            retorno = false;
        }
        if (TextUtils.isEmpty(editSobrenome.getText().toString())) {
            editSobrenome.setError("*");
            editSobrenome.requestFocus();
            retorno = false;
        }
        if (TextUtils.isEmpty(editFuncao.getText().toString())) {
            editFuncao.setError("*");
            editFuncao.requestFocus();
            retorno = false;
        }
        if (TextUtils.isEmpty(editSalario.getText().toString())) {
            editSalario.setError("*");
            editSalario.requestFocus();
            retorno = false;
        }
        if (TextUtils.isEmpty(editTelefone.getText().toString())) {
            editTelefone.setError("*");
            editTelefone.requestFocus();
            retorno = false;
        }
        if (TextUtils.isEmpty(editEmail.getText().toString())) {
            editEmail.setError("*");
            editEmail.requestFocus();
            retorno = false;
        }

        return retorno;
    }

    public void validarTermo(View view) {


    }
}