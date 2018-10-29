package com.example.taruc.lab2bmicalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    private double bmiReceive;
    private ImageView imageView;
    private TextView status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        imageView = findViewById(R.id.bmiImage);
        status = findViewById(R.id.statusBMI);
        imageView.setImageResource(R.drawable.normal);

        Intent intent = getIntent();

        if(intent.hasExtra(MainActivity.EXTRA_VALUE))
        {
            bmiReceive = intent.getDoubleExtra(MainActivity.EXTRA_VALUE,0);

            if(bmiReceive < 18.5)
            {
                imageView.setImageResource(R.drawable.under);
                status.setText("Under Weight");

            }
            else if(bmiReceive < 24.5)
            {
                imageView.setImageResource(R.drawable.normal);
                status.setText("Perfectly Normal");
            }
            else {
                imageView.setImageResource(R.drawable.over);
                status.setText("OverWeight");
            }

        }
    }
}
