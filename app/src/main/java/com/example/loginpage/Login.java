package com.example.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    ListView listViewProductList;
    ListView list;
    String data[]={"Margherita","Peppy paneer","Mexican green wave","Cheese n Corn","Paneer Makhani"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        listViewProductList=(ListView)findViewById(R.id.listViewProductList);
        ArrayAdapter adapter=new ArrayAdapter(Login.this,R.layout.list,data);
        listViewProductList.setAdapter(adapter);
        listViewProductList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txt=(TextView)view;
                String n1=txt.getText().toString();
                if(n1=="Margherita") {
                    Intent i = new Intent(Login.this, productDetailActivity1.class);
                    startActivity(i);
                }
                else if(n1=="Peppy Paneer") {
                    Intent i = new Intent(Login.this, productDetailActivity2.class);
                    startActivity(i);
                }
                else if(n1=="Mexican Green Wave") {
                    Intent i = new Intent(Login.this, productDetailActivity3.class);
                    startActivity(i);
                }
                else if(n1=="Cheese n Corn") {
                    Intent i = new Intent(Login.this, productDetailActivity4.class);
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(Login.this, productDetailActivity5.class);
                    startActivity(i);
                }
            }
        });

    }
}
