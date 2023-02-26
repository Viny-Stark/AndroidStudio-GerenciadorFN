package com.example.gerenciadorfn.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gerenciadorfn.R;
import com.example.gerenciadorfn.api.AppUtil;
import com.example.gerenciadorfn.controller.FuncionarioController;
import com.example.gerenciadorfn.model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnConsultarFuncionario,btnAdicionarFuncionario,btnAtualizarDadosFuncionario;

    //Teste do LongClick
    Button btnTestOnLongClick;

    FuncionarioController funcionarioController;

    Funcionario funcionario;

    List<Funcionario>funcionarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        iniciarComponentes();

        //buscarListaDeFuncionarios();

        btnAdicionarFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,
                        AdicionarFuncionarioActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });

        btnAtualizarDadosFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,
                        AtualizarFuncionariosActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        btnConsultarFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,
                        ConsultarFuncionariosActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });

        btnTestOnLongClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {



                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);


                Intent intent = new Intent(MainActivity.this,SplashActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this,"OnLongClick Funcional",Toast.LENGTH_LONG).show();


                return false;
            }
        });

    }

    private void iniciarComponentes() {

        btnConsultarFuncionario=findViewById(R.id.btnConsultarFuncionario);
        btnAdicionarFuncionario=findViewById(R.id.btnAdicionarFuncionario);
        btnAtualizarDadosFuncionario=findViewById(R.id.btnAtualizarDadosFuncionario);
        btnTestOnLongClick=findViewById(R.id.btnTestOnLongClick);

        funcionario=new Funcionario();

        funcionarioController=new FuncionarioController(getApplicationContext());



    }
}