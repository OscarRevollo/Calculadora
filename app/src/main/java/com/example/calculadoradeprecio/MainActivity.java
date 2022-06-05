package com.example.calculadoradeprecio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button sand_mas,sand_menos,tucu_mas,tucu_menos,pavita_mas,pavita_menos,mini_mas,mini_menos,cebada_mas,cebada_menos,calcular,reset;
    EditText sandwich_text,tucu_text,pavita_text,mini_text,cebada_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sand_mas = findViewById(R.id.sand_mas);
        sand_menos = findViewById(R.id.sand_menos);
        tucu_mas= findViewById(R.id.tucu_mas);
        tucu_menos=  findViewById(R.id.tucu_menos);
        pavita_mas=  findViewById(R.id.pavita_mas);
        pavita_menos=  findViewById(R.id.pavita_menos);
        mini_mas= findViewById(R.id.mini_mas);
        mini_menos=  findViewById(R.id.mini_menos);
        cebada_mas= findViewById(R.id.cebada_mas);
        cebada_menos= findViewById(R.id.cebada_menos);
        calcular=  findViewById(R.id.calcular);
        reset=findViewById(R.id.reset);
        sandwich_text=findViewById(R.id.sandwich_text);
        tucu_text=findViewById(R.id.tucu_text);
        pavita_text=findViewById(R.id.pavita_text);
        mini_text=findViewById(R.id.mini_text);
        cebada_text=findViewById(R.id.cebada_text);
        sand_mas.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String valortext = sandwich_text.getText().toString();
                if(valortext.isEmpty()){
                    valortext="0";
                }
                int valor = Integer.parseInt(valortext);
                valor++;
                sandwich_text.setText(String.valueOf(valor));
            }
        });
        sand_menos.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String valortext = sandwich_text.getText().toString();
                if(valortext.isEmpty()){
                    valortext="0";
                }
                int valor = Integer.parseInt(valortext);
                valor--;
                if(valor>=0) {
                    sandwich_text.setText(String.valueOf(valor));
                }else{
                    sandwich_text.setText("0");
                }
            }
        });
        tucu_mas.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String valortext = tucu_text.getText().toString();
                if(valortext.isEmpty()){
                    valortext="0";
                }
                int valor = Integer.parseInt(valortext);
                valor++;
                tucu_text.setText(String.valueOf(valor));
            }
        });
        tucu_menos.setOnClickListener(new View.OnClickListener()
                {@Override
                    public void onClick(View v)
                    {
                        String valortext = tucu_text.getText().toString();
                        if(valortext.isEmpty()){
                            valortext="0";
                        }
                        int valor = Integer.parseInt(valortext);
                        valor--;
                        if(valor>=0) {
                            tucu_text.setText(String.valueOf(valor));
                        }else{
                            tucu_text.setText("0");
                        }
                    }
                });
        pavita_mas.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String valortext = pavita_text.getText().toString();
                if(valortext.isEmpty()){
                    valortext="0";
                }
                int valor = Integer.parseInt(valortext);
                valor++;
                pavita_text.setText(String.valueOf(valor));
            }
        });
                pavita_menos.setOnClickListener(new View.OnClickListener()
                {@Override
                public void onClick(View v)
                {
                    String valortext = pavita_text.getText().toString();
                    if(valortext.isEmpty()){
                        valortext="0";
                    }
                    int valor = Integer.parseInt(valortext);
                    valor--;
                    if(valor>=0) {
                        pavita_text.setText(String.valueOf(valor));
                    }else{
                        pavita_text.setText("0");
                    }
                }
                });
        mini_mas.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String valortext = mini_text.getText().toString();
                if(valortext.isEmpty()){
                    valortext="0";
                }
                int valor = Integer.parseInt(valortext);
                valor++;
                mini_text.setText(String.valueOf(valor));
            }
        });
                mini_menos.setOnClickListener(new View.OnClickListener()
                {@Override
                public void onClick(View v)
                {
                    String valortext = mini_text.getText().toString();
                    if(valortext.isEmpty()){
                        valortext="0";
                    }
                    int valor = Integer.parseInt(valortext);
                    valor--;
                    if(valor>=0) {
                        mini_text.setText(String.valueOf(valor));
                    }else{
                        mini_text.setText("0");
                    }
                }
                });
        cebada_mas.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String valortext = cebada_text.getText().toString();
                if(valortext.isEmpty()){
                    valortext="0";
                }
                int valor = Integer.parseInt(valortext);
                valor++;
                cebada_text.setText(String.valueOf(valor));
            }
        });
        cebada_menos.setOnClickListener(new View.OnClickListener()
                {@Override
                public void onClick(View v)
                {
                    String valortext = cebada_text.getText().toString();
                    if(valortext.isEmpty()){
                        valortext="0";
                    }
                    int valor = Integer.parseInt(valortext);
                    valor--;
                    if(valor>=0) {
                        cebada_text.setText(String.valueOf(valor));
                    }else{
                        cebada_text.setText("0");
                    }
                }
                });
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valido(sandwich_text) || valido(tucu_text) || valido(pavita_text) ||
                     valido(mini_text)|| valido (cebada_text)) {

                    Intent intent = new Intent(MainActivity.this, ResultadosActivity.class);
                    intent.putExtra("sandwich",sandwich_text.getText().toString() );
                    intent.putExtra("tucumana", tucu_text.getText().toString());
                    intent.putExtra("pavita", pavita_text.getText().toString());
                    intent.putExtra("mini", mini_text.getText().toString());
                    intent.putExtra("cebada", cebada_text.getText().toString());
                    startActivity(intent);


                }else {
                    Toast.makeText(MainActivity.this, "LLene la cantidad de un producto", Toast.LENGTH_SHORT).show();
                }

                }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sandwich_text.setText("");
                        tucu_text.setText("");
                pavita_text.setText("");
                        mini_text.setText("");
                cebada_text.setText("");
            }
        });
    }
    private boolean valido(EditText text){
        boolean res=false;
        String valortext = text.getText().toString();
        if(valortext.isEmpty()){
            res=false;
        }else{
            int valor = Integer.parseInt(valortext);
            if(valor>0) {
               res=true;
            }

        }
        return res;
    }
}
