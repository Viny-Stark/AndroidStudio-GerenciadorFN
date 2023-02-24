package com.example.gerenciadorfn.controller;

import android.content.ContentValues;
import android.content.Context;


import androidx.annotation.Nullable;

import com.example.gerenciadorfn.api.AppDataBase;
import com.example.gerenciadorfn.datamodel.FuncionarioDataModel;
import com.example.gerenciadorfn.model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioController extends AppDataBase {

    private static  final String TABELA= FuncionarioDataModel.TABELA;
    private ContentValues dados;

    public FuncionarioController(@Nullable Context context) {
        super(context);
    }

    public boolean incluir(Funcionario obj){
        dados= new ContentValues();

        dados.put(FuncionarioDataModel.NOME, obj.getNome());
        dados.put(FuncionarioDataModel.SOBRENOME, obj.getSobrenome());
        dados.put(FuncionarioDataModel.FUNCAO, obj.getFuncao());
        dados.put(FuncionarioDataModel.SALARIO, obj.getSalario());
        dados.put(FuncionarioDataModel.TELEFONE, obj.getTelefone());
        dados.put(FuncionarioDataModel.EMAIL, obj.getEmail());

        return  insert(TABELA, dados);
    }

    public boolean alterar(Funcionario obj){

        dados= new ContentValues();

        dados.put(FuncionarioDataModel.ID, obj.getId());
        dados.put(FuncionarioDataModel.NOME, obj.getNome());
        dados.put(FuncionarioDataModel.FUNCAO, obj.getFuncao());
        dados.put(FuncionarioDataModel.SALARIO, obj.getSalario());
        /*dados.put(FuncionarioDataModel.TELEFONE, obj.getTelefone());
        dados.put(FuncionarioDataModel.EMAIL, obj.getEmail());*/

        return  update(TABELA, dados);
    }

    public boolean deletar(Funcionario obj){

        return  delete(TABELA,obj.getId());
    }

    public List<Funcionario> listar(){

        return list(TABELA);
    }





}
