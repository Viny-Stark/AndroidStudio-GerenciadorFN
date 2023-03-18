package com.example.gerenciadorfn.controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.example.gerenciadorfn.api.AppDataBase;
import com.example.gerenciadorfn.datamodel.FuncionarioDataModel;
import com.example.gerenciadorfn.datamodel.UsuarioDataModel;
import com.example.gerenciadorfn.model.Funcionario;
import com.example.gerenciadorfn.model.Usuario;

import java.util.List;

public class UsuarioController extends AppDataBase {

    private static  final String TABELA= UsuarioDataModel.TABELA;
    private ContentValues dados;

    public UsuarioController(@Nullable Context context) {
        super(context);
    }

    public boolean incluir(Usuario obj){
        dados= new ContentValues();

        dados.put(UsuarioDataModel.NOME_COMPLETO, obj.getNomeCompleto());
        dados.put(UsuarioDataModel.CPF, obj.getCpf());
        dados.put(UsuarioDataModel.NOME_DA_EMPRESA, obj.getNomeDaEmpresa());
        dados.put(UsuarioDataModel.CNPJ, obj.getCnpj());
        dados.put(UsuarioDataModel.EMAIL, obj.getEmail());
        dados.put(UsuarioDataModel.USUARIO, obj.getUsuario());
        dados.put(UsuarioDataModel.SENHA, obj.getSenha());

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
