package com.iescamas.tresnumeros;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final String msgError = "Error!!!!";
    //Instanciamos los objetos que vamos a utilizar

    TextView etv_PrimerNumero;
    TextView etv_SegundoNumero;
    TextView etv_TercerNumero;
    TextView tv_Menor;
    TextView tv_Mediano;
    TextView tv_Mayor;
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
        etv_PrimerNumero = findViewById(R.id.etn_PrimerNumero);
        etv_SegundoNumero = findViewById(R.id.etn_SegundoNumero);
        etv_TercerNumero = findViewById(R.id.etn_TercerNumero);
        tv_Menor = findViewById(R.id.tv_Menor);
        tv_Mediano = findViewById(R.id.tv_Mediano);
        tv_Mayor = findViewById(R.id.tv_Mayor);
        btn_Menor = findViewById(R.id.btn_Menor);
        btn_Mayor = findViewById(R.id.btn_Mayor);
        btn_ord_Asc = findViewById(R.id.btn_Asc);
        btn_ord_Desc = findViewById(R.id.btn_Desc);
        btn_Borrar = findViewById(R.id.btn_Borrar);

        //Establecemos los listener
        btn_Mayor.setOnClickListener(view -> Operaciones("Mayor"));
        btn_Menor.setOnClickListener(view -> Operaciones("Menor"));
        btn_ord_Asc.setOnClickListener(view -> Operaciones("Ord Asc"));
        btn_ord_Desc.setOnClickListener(view -> Operaciones("Ord Desc"));
        btn_Borrar.setOnClickListener(view ->{
            etv_PrimerNumero.setText("");
            etv_SegundoNumero.setText("");
            etv_TercerNumero.setText("");
            tv_Menor.setText("");
            tv_Mediano.setText("");
            tv_Mayor.setText("");
        });

    }
    private void Operaciones(String msg){

        //Obtenemos los números pasandolos a String
        String primerNumero = etv_PrimerNumero.getText().toString();
        String segundoNumero = etv_SegundoNumero.getText().toString();
        String tercerNumero = etv_TercerNumero.getText().toString();

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
            switch (msg){

                case "Mayor":
                               tv_Menor.setText("");
                               tv_Mediano.setText(String.valueOf(Collections.max(Lista)));
                               tv_Mayor.setText("");
                break;

                case "Menor":
                              tv_Menor.setText("");
                              tv_Mediano.setText(String.valueOf(Collections.min(Lista)));
                              tv_Mayor.setText("");
                break;

                case "Ord Asc":
                              tv_Menor.setText(String.valueOf(Collections.min(Lista)));
                              tv_Mediano.setText(String.valueOf(Lista.get(1)));
                              tv_Mayor.setText(String.valueOf(Collections.max(Lista)));
                break;

                case "Ord Desc":
                              tv_Menor.setText(String.valueOf(Collections.max(Lista)));
                              tv_Mediano.setText(String.valueOf(Lista.get(1)));
                              tv_Mayor.setText(String.valueOf(Collections.min(Lista)));
                break;

            }
        }
        else{
            tv_Menor.setText("");
            tv_Mediano.setText(msgError);
            tv_Mayor.setText("");
        }
    }
}