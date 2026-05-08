package com.Matheus.ModularPAMlSharedePreferences;

import android.content.Context;
import android.content.SharedPreferences;


public class AnotacaoPreferencias{
    public final SharedPreferences preferences;
    public   final SharedPreferences.Editor editor;

    private static final  String CHAVE_NOME = "anotação";

    public AnotacaoPreferencias(Context context){
        preferences = context.getSharedPreferences("arqPreferencias", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }
    public void salvarPreferencias(String anotacao){

    }
    public String recuperarAnotacao (){
        return preferences.getString(CHAVE_NOME,"") ;
    }
}
