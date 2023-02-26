package com.example.gerenciadorfn.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    FuncionarioController controller;

    Button rvVoltar;


    RecyclerView rvFuncionarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_consultar_funcionarios);




        rvFuncionarios = findViewById(R.id.rvFuncionarios);

        controller = new FuncionarioController(getApplicationContext());

        funcionarios = controller.listar();

        adapter = new FuncionarioAdapter(funcionarios, getApplicationContext());

        rvFuncionarios.setAdapter(adapter);

        rvFuncionarios.setLayoutManager(new LinearLayoutManager(this));



        }


}