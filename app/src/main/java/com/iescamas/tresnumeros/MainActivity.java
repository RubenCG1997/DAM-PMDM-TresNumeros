package com.iescamas.tresnumeros;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    final String msgError = "Error!!!!";
    //Instanciamos los objetos que vamos a utilizar

    TextView txt_PrimerNumero;
    TextView txt_SegundoNumero;
    TextView txt_TercerNumero;
    TextView txt_Menor;
    TextView txt_Mediano;
    TextView txt_Mayor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vinculamos las instancias con los elementos de la interfaz
        txt_PrimerNumero = findViewById(R.id.txt_PrimerNúmero);
        txt_SegundoNumero = findViewById(R.id.txt_SegundoNumero);
        txt_TercerNumero = findViewById(R.id.txt_TercerNúmero);
        txt_Menor = findViewById(R.id.txt_Menor);
        txt_Mediano = findViewById(R.id.txt_Mediano);
        txt_Mayor = findViewById(R.id.txt_Mayor);

        //Establecemos los listener
        findViewById(R.id.btn_Mayor).setOnClickListener(view -> Operaciones(1));
        findViewById(R.id.btn_Menor).setOnClickListener(view -> Operaciones(2));
        findViewById(R.id.btn_Asc).setOnClickListener(view -> Operaciones(3));
        findViewById(R.id.btn_Desc).setOnClickListener(view -> Operaciones(4));
        findViewById(R.id.btn_Borrar).setOnClickListener(view ->clear());

    }
    private void Operaciones(int operacion){

        //Obtenemos los números pasandolos a String
        String primerNumero = txt_PrimerNumero.getText().toString();
        String segundoNumero = txt_SegundoNumero.getText().toString();
        String tercerNumero = txt_TercerNumero.getText().toString();

        //Comprobamos que ninguno está vacio
        if(!primerNumero.isEmpty() && !segundoNumero.isEmpty() && !tercerNumero.isEmpty()){

            switch (operacion){

                case 1: maximo(conversionOrdenada(primerNumero,segundoNumero,tercerNumero));break;

                case 2: minimo(conversionOrdenada(primerNumero,segundoNumero,tercerNumero));break;

                case 3: menorMayor(conversionOrdenada(primerNumero,segundoNumero,tercerNumero));break;

                case 4: mayorMenor(conversionOrdenada(primerNumero,segundoNumero,tercerNumero));break;

            }
        }
        else{
            msgError();
        }
    }
    private ArrayList<Integer> conversionOrdenada(String numero1,String numero2,String numero3){
        ArrayList<Integer>Lista = new ArrayList<>();
        //Convertimos esos números en int
        Integer primero = Integer.parseInt(numero1);
        Integer segundo = Integer.parseInt(numero2);
        Integer tercero = Integer.parseInt(numero3);
        //Añadimos los numeros a la lista
        Lista.add(primero);
        Lista.add(segundo);
        Lista.add(tercero);
        Collections.sort(Lista);
        return Lista;
    }
    private void clear(){
        txt_PrimerNumero.setText("");
        txt_SegundoNumero.setText("");
        txt_TercerNumero.setText("");
        txt_Menor.setText("");
        txt_Mediano.setText("");
        txt_Mayor.setText("");
    }
    private void msgError(){
        txt_Menor.setText("");
        txt_Mediano.setText(msgError);
        txt_Mayor.setText("");
    }
    private void maximo(ArrayList<Integer> lista){
        txt_Menor.setText("");
        txt_Mediano.setText(String.valueOf(Collections.max(lista)));
        txt_Mayor.setText("");
    }
    private void minimo(ArrayList<Integer>lista){
        txt_Menor.setText("");
        txt_Mediano.setText(String.valueOf(Collections.min(lista)));
        txt_Mayor.setText("");
    }
    private void menorMayor(ArrayList<Integer>lista){
        txt_Menor.setText(String.valueOf(Collections.min(lista)));
        txt_Mediano.setText(String.valueOf(lista.get(1)));
        txt_Mayor.setText(String.valueOf(Collections.max(lista)));
    }
    private void mayorMenor(ArrayList<Integer>lista){
        txt_Menor.setText(String.valueOf(Collections.max(lista)));
        txt_Mediano.setText(String.valueOf(lista.get(1)));
        txt_Mayor.setText(String.valueOf(Collections.min(lista)));
    }
}