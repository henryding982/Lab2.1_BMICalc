package com.example.taruc.lab2bmicalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText weightValue;
    private EditText heightValue;
    public static String EXTRA_VALUE = ".com.example.taruc.lab2bmicalc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weightValue = findViewById(R.id.weightTxt);
        heightValue = findViewById(R.id.heightTxt);
    }

    public void onClickEvent(View view)
    {
        Intent intent = new Intent(this,secondActivity.class);
        if(!TextUtils.isEmpty(weightValue.getText()))
        {
            if(!TextUtils.isEmpty(heightValue.getText()))
            {
                double weight = Double.parseDouble(weightValue.getText().toString());
                double height = Double.parseDouble(heightValue.getText().toString());

                double BMI = weight / (height * height);

                intent.putExtra(EXTRA_VALUE,BMI);
                startActivity(intent);
            }
            else
            {
                heightValue.setError("Please enter the height value");
            }

        }
        else
        {
            weightValue.setError("Please enter the weight");
        }


    }
}
