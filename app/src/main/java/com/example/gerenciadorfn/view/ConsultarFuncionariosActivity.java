package com.example.gerenciadorfn.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.example.gerenciadorfn.R;
import com.example.gerenciadorfn.api.FuncionarioAdapter;
import com.example.gerenciadorfn.controller.FuncionarioController;
import com.example.gerenciadorfn.model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class ConsultarFuncionariosActivity extends AppCompatActivity {

    List<Funcionario> funcionarios;


    FuncionarioAdapter adapter;

    Button btnV;
    FuncionarioController controller;

    RecyclerView rvFuncionarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_consultar_funcionarios);

        initComponetes();

        btnV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder =new AlertDialog.Builder(ConsultarFuncionariosActivity.this);

                builder.setTitle("Deseja mesmo Voltar?");
                builder.setMessage("Voltar ao Menu Principal");
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent IntVoltar= new Intent(ConsultarFuncionariosActivity.this,MainActivity.class);
                        startActivity(IntVoltar);
                        return;
                    }
                });
                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });


        rvFuncionarios = findViewById(R.id.rvFuncionarios);

        controller = new FuncionarioController(getApplicationContext());

        funcionarios = controller.listar();

        adapter = new FuncionarioAdapter(funcionarios, getApplicationContext());

        rvFuncionarios.setAdapter(adapter);

        rvFuncionarios.setLayoutManager(new LinearLayoutManager(this));

        }

    private void initComponetes() {

        btnV=findViewById(R.id.btnV);
    }


}