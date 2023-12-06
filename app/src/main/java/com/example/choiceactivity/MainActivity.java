package com.example.choiceactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;

    CheckBox c1,c2,c3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup =findViewById(R.id.radioGroup);
        c1 =findViewById(R.id.c1);
        c2 =findViewById(R.id.c2);
        c3 =findViewById(R.id.c3);

        findViewById(R.id.btnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedRadiobtn = radioGroup.getCheckedRadioButtonId();
                if(selectedRadiobtn != -1){
                    RadioButton radioButton = findViewById(selectedRadiobtn);
                    String choice = radioButton.getText().toString();
                    Toast.makeText(MainActivity.this,choice, Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Not Selected", Toast.LENGTH_SHORT).show();
                }

            }
        });

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = "Choice:-";

                if(c1.isChecked()){
                    String s1 = c1.getText().toString();
                    s = s + s1 + ","; //Choice:-Android,
                }

                if(c2.isChecked()){
                    String s2 = c2.getText().toString();
                    s = s + s2 + ","; //Choice:-Android,IOS  OR  //Choice:-IOS,...
                }

                if(c3.isChecked()){
                    String s3 = c3.getText().toString();
                    s = s + s3 + ","; //Choice:-Android,IOS,Flutter  OR  //Choice:-Flutter,...
                }

                s.trim();
                s = s.substring(0,s.length()-1);
                Log.e("Save",s);

            }
        });

    }
}