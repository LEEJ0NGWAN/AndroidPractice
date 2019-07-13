package com.example.checkunivhierarchy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button checkButton;
    EditText inputUnivText;
    String inputUnivName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkButton  = (Button)findViewById(R.id.checkButton);
        inputUnivText = (EditText)findViewById(R.id.inputUnivText);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToResultActivity = new Intent(MainActivity.this, ResultActivity.class);
                inputUnivName = inputUnivText.getText().toString().trim();
                filteringUnivName(inputUnivName);
                if( inputUnivName.length() > 1 ) {
                    intentToResultActivity.putExtra("univName", inputUnivName);
                    startActivity(intentToResultActivity);
                }
                else Toast.makeText(MainActivity.this,"소속을 제대로 밝히시오!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    void filteringUnivName(String inputUnivName){
        if(inputUnivName.endsWith("대학")) inputUnivName.replace("대학","");
        else if(inputUnivName.endsWith("대학교")) inputUnivName.replace("대학교", "");
    }
}
