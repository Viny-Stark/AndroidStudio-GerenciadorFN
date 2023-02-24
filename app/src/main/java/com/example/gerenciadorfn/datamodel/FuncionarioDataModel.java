package com.example.gerenciadorfn.datamodel;

public class FuncionarioDataModel {

    public static final String TABELA = "funcionarios";

    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String SOBRENOME = "sobreNome";
    public static final String FUNCAO = "funcao";
    public static final String SALARIO = "salario";
    public static final String TELEFONE = "telefone";
    public static final String EMAIL = "email";

    public static String query;

    public static String gerarTabela(){

        query = "CREATE TABLE "+TABELA+" ( ";
        query += ID+" INTEGER PRIMARY KEY AUTOINCREMENT, ";
        query += NOME+" TEXT, ";
        query += SOBRENOME+" TEXT, ";
        query += FUNCAO+" TEXT, ";
        query += SALARIO+" TEXT, ";
        query += TELEFONE+" TEXT, ";
        query += EMAIL+" TEXT ";

        query += ")";

        return query;
    }
}
