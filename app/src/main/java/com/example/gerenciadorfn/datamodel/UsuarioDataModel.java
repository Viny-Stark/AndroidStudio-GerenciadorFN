package com.example.gerenciadorfn.datamodel;

import com.example.gerenciadorfn.api.AppDataBase;
import com.example.gerenciadorfn.model.Usuario;

public class UsuarioDataModel  {

    public static final String TABELA = "usuarios";

    public static final String ID = "id";
    public static final String NOME_COMPLETO = "nomeCompleto";

    public static final String CPF = "cpf";
    public static final String NOME_DA_EMPRESA = "nomeDaEmpresa";
    public static final String  CNPJ = "cnpj";

    public static final String EMAIL = "email";
    public static final String SENHA = "senha";

    public static String query;


    public static String gerarTabela(){

        query = "CREATE TABLE "+TABELA+" ( ";
        query += ID+" INTEGER PRIMARY KEY AUTOINCREMENT, ";
        query += NOME_COMPLETO+" TEXT, ";
        query += CPF+" TEXT, ";
        query += NOME_DA_EMPRESA+" TEXT, ";
        query += CNPJ+" TEXT, ";
        query += EMAIL+" TEXT, ";
        query += SENHA+" TEXT ";

        query += ")";

        return query;
    }
}
