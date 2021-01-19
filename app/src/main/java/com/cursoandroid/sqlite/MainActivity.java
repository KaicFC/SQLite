package com.cursoandroid.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            //Criar ou Abrir o Banco de Dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Criar Tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR, idade INT(3))");

            //Inserir dados
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Kaic', 23)");
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Morgana', 25)");

            //Recuperar dados
            bancoDados.rawQuery("", null);



        }catch(Exception e){
            e.printStackTrace();
        }


    }


}
