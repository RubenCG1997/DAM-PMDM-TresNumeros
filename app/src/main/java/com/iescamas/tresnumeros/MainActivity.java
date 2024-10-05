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
    Button btn_Menor;
    Button btn_Mayor;
    Button btn_ord_Asc;
    Button btn_ord_Desc;
    Button btn_Borrar;

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
        btn_Menor = findViewById(R.id.btn_Menor);
        btn_Mayor = findViewById(R.id.btn_Mayor);
        btn_ord_Asc = findViewById(R.id.btn_Asc);
        btn_ord_Desc = findViewById(R.id.btn_Desc);
        btn_Borrar = findViewById(R.id.btn_Borrar);

        //Establecemos los listener
        btn_Mayor.setOnClickListener(view -> Operaciones(1));
        btn_Menor.setOnClickListener(view -> Operaciones(2));
        btn_ord_Asc.setOnClickListener(view -> Operaciones(3));
        btn_ord_Desc.setOnClickListener(view -> Operaciones(4));
        btn_Borrar.setOnClickListener(view ->{
            txt_PrimerNumero.setText("");
            txt_SegundoNumero.setText("");
            txt_TercerNumero.setText("");
            txt_Menor.setText("");
            txt_Mediano.setText("");
            txt_Mayor.setText("");
        });

    }
    private void Operaciones(int operacion){

        //Obtenemos los números pasandolos a String
        String primerNumero = txt_PrimerNumero.getText().toString();
        String segundoNumero = txt_SegundoNumero.getText().toString();
        String tercerNumero = txt_TercerNumero.getText().toString();

        //Comprobamos que ninguno está vacio
        if(!primerNumero.isEmpty() && !segundoNumero.isEmpty() && !tercerNumero.isEmpty()){
            //Convertimos esos números en int
            Integer primero = Integer.parseInt(primerNumero);
            Integer segundo = Integer.parseInt(segundoNumero);
            Integer tercero = Integer.parseInt(tercerNumero);
            //Lo pasamos a un array
            ArrayList<Integer> Lista = new ArrayList<>();
            //Añadimos los numeros a la lista
            Lista.add(primero);
            Lista.add(segundo);
            Lista.add(tercero);
            //Ordeno la lista
            Collections.sort(Lista);
            switch (operacion){

                case 1:
                               txt_Menor.setText("");
                               txt_Mediano.setText(String.valueOf(Collections.max(Lista)));
                               txt_Mayor.setText("");
                break;

                case 2:
                              txt_Menor.setText("");
                              txt_Mediano.setText(String.valueOf(Collections.min(Lista)));
                              txt_Mayor.setText("");
                break;

                case 3:
                              txt_Menor.setText(String.valueOf(Collections.min(Lista)));
                              txt_Mediano.setText(String.valueOf(Lista.get(1)));
                              txt_Mayor.setText(String.valueOf(Collections.max(Lista)));
                break;

                case 4:
                              txt_Menor.setText(String.valueOf(Collections.max(Lista)));
                              txt_Mediano.setText(String.valueOf(Lista.get(1)));
                              txt_Mayor.setText(String.valueOf(Collections.min(Lista)));
                break;

            }
        }
        else{
            txt_Menor.setText("");
            txt_Mediano.setText(msgError);
            txt_Mayor.setText("");
        }
    }
}