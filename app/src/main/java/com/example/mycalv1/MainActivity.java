package com.example.mycalv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
private EditText n,m;
private Button bttn;
private Spinner spn;
private TextView tv;
int n1,n2;
String val="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n=findViewById(R.id.editTextNumber);
        m=findViewById(R.id.editTextNumber2);
        bttn=findViewById(R.id.button);
        spn=findViewById(R.id.spinner);
        tv=findViewById(R.id.Result);
        ArrayAdapter<CharSequence> Adater=ArrayAdapter.createFromResource(this,R.array.Sum, android.R.layout.simple_spinner_item);
        spn.setAdapter(Adater);
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                val=parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }) ;
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String a=n.getText().toString();
                String b=m.getText().toString();

                if (!a.equals("")&& !b.equals("")){
                    calcular(a,b);
                }
                else {
                    Toast.makeText(MainActivity.this, "Eres retrasado", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void calcular(String a, String b) {
        int x=Integer.parseInt(a);
        int y=Integer.parseInt(b);
        int result=0;
        String res_st="";
    switch (val){
        case "sum":
            result=x+y;
            res_st=Integer.toString(result);
            tv.setText(res_st);
            break;
        case "res":
            result=x-y;
            res_st=Integer.toString(result);
            tv.setText(res_st);
            break;
        case "mul":
            result=x*y;
            res_st=Integer.toString(result);
            tv.setText(res_st);
            break;
        case "div":
            result=x/y;
            res_st=Integer.toString(result);
            tv.setText(res_st);
            break;
    }
    }
}