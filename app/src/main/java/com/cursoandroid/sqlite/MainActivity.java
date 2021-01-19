package com.cursoandroid.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

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
            //Cursor percerre os dados
             Cursor cursor = bancoDados.rawQuery("SELECT nome, idade FROM pessoas", null);

             //Indices da tabela
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            //Retornar o cursor para o primeiro ítem.
            cursor.moveToFirst();

            //Mover o cursor
             while(cursor != null){
                 Log.i("RESULTADO - nome", cursor.getString(indiceNome));
                 Log.i("RESULTADO - idade", cursor.getString(indiceIdade));
                cursor.moveToNext();
             }

        }catch(Exception e){
            e.printStackTrace();
        }


    }


}
