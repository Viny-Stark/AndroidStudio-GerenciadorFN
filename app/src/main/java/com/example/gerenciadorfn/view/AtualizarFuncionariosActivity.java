package com.example.gerenciadorfn.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gerenciadorfn.R;
import com.example.gerenciadorfn.controller.FuncionarioController;
import com.example.gerenciadorfn.model.Funcionario;

public class AtualizarFuncionariosActivity extends AppCompatActivity {

    TextView textIDFuncionario,textAtualizarFuncao;

    AdicionarFuncionarioActivity adicionarFuncionarioActivity;

    Button btnAtualizar,btnVoltar;

    EditText edtIDFuncionario,edtAtualizarNome,edtAtualizarFuncao,edtAtualizarSalario;

    Funcionario atualizarFuncionario;

    FuncionarioController funcionarioController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_funcionarios);

        initFormulario();

        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                atualizarFuncionario.setId(Integer.parseInt(edtIDFuncionario.getText().toString()));
                atualizarFuncionario.setNome(edtAtualizarNome.getText().toString());
                atualizarFuncionario.setFuncao(edtAtualizarFuncao.getText().toString());
                atualizarFuncionario.setSalario(edtAtualizarSalario.getText().toString());


                funcionarioController.alterar(atualizarFuncionario);

                Intent intent=new Intent(AtualizarFuncionariosActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder =new AlertDialog.Builder(AtualizarFuncionariosActivity.this);

                builder.setTitle("Deseja mesmo Voltar?");
                builder.setMessage("Voltar ao Menu Principal");
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent IntVoltar= new Intent(AtualizarFuncionariosActivity.this,MainActivity.class);
                        startActivity(IntVoltar);
                        return;
                    }
                });
                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(getApplicationContext(),
                                "Continue a Atualização",
                                Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });


    }

    private void initFormulario() {

        textIDFuncionario=findViewById(R.id.textIDFuncionario);
        textAtualizarFuncao=findViewById(R.id.textAtualizarFuncao);
        edtIDFuncionario=findViewById(R.id.edtIDFuncionario);
        edtAtualizarNome=findViewById(R.id.edtAtualizarNome);
        edtAtualizarFuncao=findViewById(R.id.edtAtualizarFuncao);
        edtAtualizarSalario=findViewById(R.id.edtAtualizarSalario);
        btnAtualizar=findViewById(R.id.btnAtualizar);
        btnVoltar=findViewById(R.id.btnVoltar);


        adicionarFuncionarioActivity=new AdicionarFuncionarioActivity();

        atualizarFuncionario= new Funcionario();

        funcionarioController=new FuncionarioController(this);


    }
}