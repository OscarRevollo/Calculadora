package com.example.calculadoradeprecio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculadoradeprecio.Adapter.ProductoAdapter;
import com.example.calculadoradeprecio.Model.Producto;

import java.util.ArrayList;
import java.util.List;

public class ResultadosActivity extends AppCompatActivity  implements ProductoAdapter.ItemClickListener{
    String sandwich;
    String tucumana;
    String pavita;
    String mini ;
    String cebada ;
    List<Producto> mProducto;
    TextView cuenta,cambio;
    RecyclerView recyclerView;
    EditText monto_cancelado;
    ProductoAdapter adapter;
    Button volver,calcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        monto_cancelado=findViewById(R.id.monto_cancelado);
        getIncomingIntent();
        mProducto=new ArrayList<>();
        if(valido(sandwich)){
            Producto p1=new Producto("Sandwich",sandwich,6);
            mProducto.add(p1);
        }
        if(valido(tucumana)){
            Producto p2=new Producto("Tucumana",tucumana,5);
            mProducto.add(p2);
        }
        if(valido(pavita)){
            Producto p3=new Producto("Pavita",pavita,5);
            mProducto.add(p3);
        }
        if(valido(mini)){
            Producto p4=new Producto("Mini",mini,2);
            mProducto.add(p4);
        }
        if(valido(cebada)){
            Producto p4=new Producto("Cebada",cebada,1.5);
            mProducto.add(p4);
        }
        cambio=findViewById(R.id.cambio);
        RecyclerView recyclerView = findViewById(R.id.list_productos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProductoAdapter(ResultadosActivity.this, mProducto);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        cuenta=findViewById(R.id.cantidad);

        double total=calcularPago(mProducto);
        cuenta.setText(total+"");
        volver=findViewById(R.id.volver);
        calcular=findViewById(R.id.calcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pag=monto_cancelado.getText().toString();

                if(pag.isEmpty()){
                    Toast.makeText(ResultadosActivity.this, "Ingrese monto pagado ", Toast.LENGTH_SHORT).show();
                }else{
                       double valor = Double.parseDouble(pag);
                        double total=calcularPago(mProducto);
                       if(valor>0 && valor>total){
                           cambio.setText(""+(valor-total));
                       }else {
                           Toast.makeText(ResultadosActivity.this, "El pago es insuficiente o no valido", Toast.LENGTH_SHORT).show();
                       }
                }
            }
        });
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });


    }
    private void getIncomingIntent(){


        if(getIntent().hasExtra("sandwich") && getIntent().hasExtra("tucumana")
                && getIntent().hasExtra("pavita") && getIntent().hasExtra("mini")
                && getIntent().hasExtra("cebada")){

            sandwich = getIntent().getStringExtra("sandwich");
            tucumana = getIntent().getStringExtra("tucumana");
            pavita = getIntent().getStringExtra("pavita");
            mini = getIntent().getStringExtra("mini");
            cebada = getIntent().getStringExtra("cebada");

        }
    }
    private boolean valido(String text){
        boolean res=false;

        if(text.isEmpty()){
            res=false;
        }else{
            int valor = Integer.parseInt(text);
            if(valor>0) {
                res=true;
            }
        }
        return res;
    }
    public void crearArrayProducto(){
        mProducto=new ArrayList<>();

    }
public double calcularPago(List<Producto> p){
        double resp=0;
       for (int i=0 ;i<p.size();i++){
           Producto producto= p.get(i);
           resp=resp+(producto.getPrecio()*(Integer.parseInt(producto.getCantidad())));
       }
       return resp;
    }
    @Override
    public void onItemClick(View view, int position) {

    }
}
