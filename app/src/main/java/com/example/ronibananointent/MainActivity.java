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
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    int resulte=0;

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
        ed1 = findViewById(R.id.editText);
        b1= findViewById(R.id.button);
        b2= findViewById(R.id.button2);
        b3= findViewById(R.id.button3);
        b4= findViewById(R.id.button4);
        b5= findViewById(R.id.button5);
        b6= findViewById(R.id.button6);
        b7= findViewById(R.id.button7);
    }

    public void exe(View view) {
        String st=ed1.getText().toString();
        int num = Integer.parseInt(st);
        resulte=resulte+num;
        ed1.setText("");
    }

    public void exe1(View view) {
        String st=ed1.getText().toString();
        int num = Integer.parseInt(st);
        resulte=resulte-num;
        ed1.setText("");
    }

    public void exe2(View view) {
        String st=ed1.getText().toString();
        int num = Integer.parseInt(st);
        resulte=resulte*num;
        ed1.setText("");
    }

    public void exe3(View view) {
        String st=ed1.getText().toString();
        int num = Integer.parseInt(st);
        if (num==0)
            ed1.setText("Error");
        else {
            resulte = resulte / num;
            ed1.setText("");
        }

    }

    public void exe4(View view) {
        ed1.setText(resulte);
    }

    public void exe5(View view) {
        ed1.setText("");
        resulte=0;
    }

    public void exe6(View view) {
        Intent si= new Intent(this,MainActivity2.class);
        si.putExtra("n",resulte);
        startActivity(si);
    }
}