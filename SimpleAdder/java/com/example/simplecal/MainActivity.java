package com.example.simplecal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText n1Input, n2Input;
    TextView resultValue;
    Button actionButton;
    String n1 = null, n2 = null;
    boolean n1IntFlag = false, n2IntFlag = false;
    int n1Val = 0, n2Val = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1Input = (EditText) findViewById(R.id.n1Input);
        n2Input = (EditText) findViewById(R.id.n2Input);
        resultValue = (TextView) findViewById(R.id.resultValue);
        actionButton = (Button) findViewById(R.id.actionButton);
        actionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                n1Val = n2Val = 0;
                n1IntFlag = n2IntFlag = false;
                n1 = n1Input.getText().toString();
                n2 = n2Input.getText().toString();
                for(int i = 0; i < n1.length(); i++){
                    if(n1.charAt(i) >= 48 && n1.charAt(i) <= 57){
                        n1Val = (n1Val*10) + n1.charAt(i) - 48; n1IntFlag = true;
                    }
                }
                for(int i = 0; i < n2.length(); i++){
                    if(n2.charAt(i) >= 48 && n2.charAt(i) <= 57){
                        n2Val = (n2Val*10) + n2.charAt(i) - 48; n2IntFlag = true;
                    }
                }
                if(n1IntFlag && n2IntFlag)
                    resultValue.setText(Integer.toString(n1Val+n2Val));
                else
                    resultValue.setText("제대로 입력해 짜식아");
            }
        });
    }
}
