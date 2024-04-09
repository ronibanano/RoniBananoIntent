package com.example.ronibananointent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText ed1;
    private Button plus,minus,multi,divid,clear,equal,credit;

    float resulte=0;
    int count=0;
    String oper,str;
    float num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        oper="";
        str="";
        ed1 = findViewById(R.id.editText);
        plus= findViewById(R.id.button);
        minus= findViewById(R.id.button2);
        multi= findViewById(R.id.button3);
        divid= findViewById(R.id.button4);
        clear= findViewById(R.id.button5);
        equal= findViewById(R.id.button6);
        credit= findViewById(R.id.button7);
    }
    public void plus(View view) {
        str=ed1.getText().toString();
        if(!str.isEmpty()){
            count+=1;
            num=Float.parseFloat(str);
            if(oper.equals("-"))
                resulte-=num;
            else if(oper.equals("*"))
                resulte*=num;
            else if(oper.equals("/")) {
                if (num == 0)
                    ed1.setText("Error");
                else
                    resulte /= num;
            }
            else
                resulte+=num;
            oper="+";
        }

        ed1.setText("");
        ed1.getHint();
    }

    public void minus(View view) {
        str=ed1.getText().toString();
        if(!str.isEmpty()){
            count+=1;
            num=Float.parseFloat(str);
            if(oper.equals("+"))
                resulte+=num;
            else if(oper.equals("*"))
                resulte*=num;
            else if(oper.equals("/")) {
                if (num == 0)
                    ed1.setText("Error");
                else
                    resulte /= num;
            }
            else{
                if(count==1)
                    if(oper.equals(""))
                        resulte=num;
                    else
                        resulte=Float.valueOf(-num);
                else
                    resulte-=num;
            }

        }

        oper="-";
        ed1.setText("");
        ed1.getHint();

    }

    public void multi(View view) {
        str=ed1.getText().toString();
        if(!str.isEmpty()){
            count+=1;
            num=Float.parseFloat(str);
            if(oper.equals("+"))
                resulte+=num;
            else if(oper.equals("-"))
                resulte-=num;
            else if(oper.equals("/")){
                if(num==0)
                    ed1.setText("Error");
                else
                    resulte /= num;
            }
            else{
                if(count==1)
                    resulte=num;
                else
                    resulte*=num;
            }

            oper="*";

        }

        ed1.setText("");
        ed1.getHint();
    }

    public void divid(View view) {
        str=ed1.getText().toString();
        if(!str.isEmpty()){
            count+=1;
            num=Float.parseFloat(str);
            if(oper.equals("+"))
                resulte+=num;
            else if(oper.equals("-"))
                resulte-=num;
            else if (oper.equals("*"))
                resulte*=num;
            else{
                if(count==1)
                    resulte=num;
                else if (num == 0)
                    ed1.setText("Error");
                else
                    resulte/=num;
            }

            oper="/";
        }

        ed1.setText("");
        ed1.getHint();
    }

    public void equal(View view) {
        if (oper.equals("+")) {
            str = ed1.getText().toString();
            num = Float.parseFloat(str);
            resulte += num;
        }
        if (oper.equals("-")) {
            str = ed1.getText().toString();
            num = Float.parseFloat(str);
            resulte -= num;
        }
        if (oper.equals("*")) {
            str = ed1.getText().toString();
            num = Float.parseFloat(str);
            resulte *= num;
        }
        if (oper.equals("/")) {
            str = ed1.getText().toString();
            num = Float.parseFloat(str);
            if(num==0)
                ed1.setText("Error");

            else {
                resulte /= num;
                ed1.setText(resulte + "");
            }
        }
        else
            ed1.setText(resulte+"");
    }

    public void clear(View view) {
        count=0;
        resulte=0;
        oper="";
        ed1.setText("");
        ed1.getHint();
    }

    public void next(View view) {
        Intent si = new Intent(this,MainActivity2.class);
        if(ed1.getText().toString().equals("Error"))
            si.putExtra("error","Error");
        else
            si.putExtra("n",resulte);
        startActivity(si);
    }
}