package com.example.gerenciadorfn.api;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gerenciadorfn.R;
import com.example.gerenciadorfn.model.Funcionario;
import com.example.gerenciadorfn.view.MainActivity;
import com.example.gerenciadorfn.view.SplashActivity;

import java.util.List;

public class FuncionarioAdapter extends RecyclerView.Adapter <FuncionarioAdapter.ViewHolder>{

    private List<Funcionario>aFuncionarios;//Lista de Funcionarios no Adpter = aFuncionarios
    private Context aContext;

    public FuncionarioAdapter(List<Funcionario> aFuncionarios, Context aContext) {
        this.aFuncionarios = aFuncionarios;
        this.aContext = aContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context= parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View linhaView=inflater.inflate(R.layout.linha_detalhe_funcionario,parent,false);

        ViewHolder viewHolder=new ViewHolder(linhaView);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull FuncionarioAdapter.ViewHolder holder, int position) {

        Funcionario objDaLinha = aFuncionarios.get(position);



        TextView txtNome = holder.rvNome;
        txtNome.setText(objDaLinha.getNome());

        TextView txtFuncao =holder.rvFuncao;
        txtFuncao.setText(objDaLinha.getFuncao());

        TextView txtSalario = holder.rvSalario;
        txtSalario.setText(objDaLinha.getSalario());

    }

    @Override
    public int getItemCount() {
        return aFuncionarios.size();
    }


    public class  ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView rvNome;
        public TextView rvFuncao;
        public TextView rvSalario;





        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            rvNome = itemView.findViewById(R.id.rvNome);
            rvFuncao= itemView.findViewById(R.id.rvFuncao);
            rvSalario= itemView.findViewById(R.id.rvSalario);



            Log.i(AppUtil.LOG_APP,"Nome: " +rvNome.getText().toString());
            Log.i(AppUtil.LOG_APP,"Funcao: " +rvFuncao.getText().toString());
            Log.i(AppUtil.LOG_APP,"Id: " +rvSalario.getText().toString());

            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {


            int position = getAdapterPosition();

            Funcionario funcionarioSelecionado = aFuncionarios.get(position);

            if(position != RecyclerView.NO_POSITION){




                Log.i(AppUtil.LOG_APP,
                        "Cliente ID "+ position +" Nome: "+funcionarioSelecionado.getNome() +
                                " Funcao: " +funcionarioSelecionado.getFuncao());

                chamarIntent();


                /*Toast.makeText(aContext,
                        "Cliente ID "+ position +" Nome: "+funcionarioSelecionado.getNome() +
                                " Funcao: " + funcionarioSelecionado.getFuncao(),
                        Toast.LENGTH_LONG).show();*/
            }
        }

    }

    public void  chamarIntent(){

        Intent intent=new Intent(aContext,MainActivity.class);
        aContext.startActivity(intent);
    }


}
