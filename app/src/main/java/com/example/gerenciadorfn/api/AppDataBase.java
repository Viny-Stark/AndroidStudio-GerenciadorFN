package com.example.gerenciadorfn.api;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.gerenciadorfn.datamodel.FuncionarioDataModel;
import com.example.gerenciadorfn.datamodel.UsuarioDataModel;
import com.example.gerenciadorfn.model.Funcionario;
import com.example.gerenciadorfn.model.Usuario;
import com.example.gerenciadorfn.view.LoginActivity;

import java.util.ArrayList;
import java.util.List;

public  class AppDataBase extends SQLiteOpenHelper {
    private static final String DB_NAME = "GerenciadorFN.sqlite";
    private static final int DB_VERSION = 1;

    Cursor cursor;

    SQLiteDatabase db;

    public AppDataBase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Criar as tabelas

        try {

            // Executar o que desejamos
            db.execSQL(FuncionarioDataModel.gerarTabela());
            db.execSQL(UsuarioDataModel.gerarTabela());

            Log.i(AppUtil.LOG_APP, "TB Cliente: " + FuncionarioDataModel.gerarTabela());
            Log.i(AppUtil.LOG_APP, "TB Usuario: " + UsuarioDataModel.gerarTabela());

        } catch (SQLException e) {

            // Capturar o erro
            Log.e(AppUtil.LOG_APP, "Erro TB Cliente: " + e.getMessage());

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean insert(String tabela, ContentValues dados){

        boolean sucesso=true;

        try{
            Log.i(AppUtil.LOG_APP,tabela+"insert() executado com sucesso");
            sucesso=db.insert(tabela,null,dados)>0;

        }catch (SQLException e){
            Log.e(AppUtil.LOG_APP,tabela+" falhou ao executar o insert" +e.getMessage());
        }

        return sucesso;
    }

    /**
     * Deletar dados no banco de dados
     * @return
     */
    public  boolean delete(String tabela, int id ){

        boolean sucesso=true;

        try{
            Log.i(AppUtil.LOG_APP,tabela+"delete() executado com sucesso");
            sucesso=db.delete(tabela,"id =?",new String[]{Integer.toString(id)})>0;

        }catch (SQLException e){
            Log.e(AppUtil.LOG_APP,tabela+" falhou ao executar o delete" +e.getMessage());
        }

        return sucesso;
    }

    /**
     * Atualizar dados no banco de dados
     * @return
     */
    public boolean update(String tabela, ContentValues dados){

        boolean sucesso=true;

        try{

            int id =dados.getAsInteger("id");

            Log.i(AppUtil.LOG_APP,tabela+"uptade() executado com sucesso");

            sucesso=db.update(tabela,dados,"id =?",new String[]{Integer.toString(id)})>0;

        }catch (SQLException e){
            Log.e(AppUtil.LOG_APP,tabela+" falhou ao executar o update" +e.getMessage());
        }

        return sucesso;
    }

    @SuppressLint("Range")
    public List<Funcionario> list(String tabela){

        List<Funcionario>list = new ArrayList<>();

        Funcionario funcionario;

        String sql = "SELECT * FROM " + tabela;


        try {

            cursor = db.rawQuery(sql, null);

            if (cursor.moveToFirst()) {

                do {

                    funcionario = new Funcionario();

                    //funcionario.setId(cursor.getInt(cursor.getColumnIndex(FuncionarioDataModel.ID)));
                    funcionario.setId(cursor.getColumnIndex(FuncionarioDataModel.ID));
                    funcionario.setNome(cursor.getString(cursor.getColumnIndex(FuncionarioDataModel.NOME)));
                    funcionario.setFuncao(cursor.getString(cursor.getColumnIndex(FuncionarioDataModel.FUNCAO)));
                    funcionario.setSalario(cursor.getString(cursor.getColumnIndex(FuncionarioDataModel.SALARIO)));
                    funcionario.setTelefone(cursor.getString(cursor.getColumnIndex(FuncionarioDataModel.TELEFONE)));
                    funcionario.setEmail(cursor.getString(cursor.getColumnIndex(FuncionarioDataModel.EMAIL)));

                    list.add(funcionario);

                } while (cursor.moveToNext());

                Log.i(AppUtil.LOG_APP,tabela+" lista gerada com sucesso");

            }

        }catch (SQLException e ){

            Log.e(AppUtil.LOG_APP,"Erro ao listar os dados"+tabela);
            Log.e(AppUtil.LOG_APP,"Erro: "+e.getMessage());

        }


        return list;
    }
    public boolean validarUsuario(String usuario,String senha){

        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM usuarios WHERE usuario=? AND senha=?"
       ,new String[]{usuario,senha} );
        c.moveToFirst();

        return c.getCount() > 0;
    }
    public double calcularSomaSalarios() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT SUM(salario) FROM funcionarios", null);
        double soma = 0;
        if (c.moveToFirst()) {
            soma = c.getDouble(0);
        }
        c.close();
        return soma;
    }



    

}
